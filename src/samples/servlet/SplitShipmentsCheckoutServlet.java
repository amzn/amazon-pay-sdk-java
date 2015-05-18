/******************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * *****************************************************************************
 *
 */
package samples.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import samples.AuthorizeSample;
import samples.CaptureSample;
import samples.SetOrderReferenceDetailsSample;
import samples.SplitShipmentsCheckoutExample;
import samples.utils.Utilities;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.AuthorizeResponse;
import com.amazonservices.mws.offamazonpayments.model.CaptureResponse;
import com.amazonservices.mws.offamazonpayments.model.SellerOrderAttributes;
import com.amazonservices.mws.offamazonpayments.model.SetOrderReferenceDetailsResponse;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationDetails;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationNotification;

public class SplitShipmentsCheckoutServlet extends IpnExampleServletBase {

    private static Log LOG = LogFactory.getLog(SplitShipmentsCheckoutServlet.class);

    private static final long serialVersionUID = 1L;
    private SplitShipmentsCheckoutExample example = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        outStream = response.getWriter();
        String amazonOrderReferenceId = getParameterFromSession("OrderReferenceId", request);
        example = new SplitShipmentsCheckoutExample(amazonOrderReferenceId, config, service, outStream);
        runSample(request);
    }

    /*
     * Helper ENUM for setting cost for selected item
     */
    private static enum ItemCost {

        TSHIRT(75.30), SHORT(43.20), SWEATER(78.98), BLOUSE(42.00), SKIRT(98.99);

        private double value;

        private ItemCost(double value) {
            this.value = value;
        }

        public double getItemCost() {
            return this.value;
        }
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all
     * API calls that will be required for split
     * shipments with multiple authorizations followed
     * with it's capture
     */
    public void runSample(HttpServletRequest request) {
        try {
            this.printMessage("<html><head><title>Split shipments result</title></head><body><div><pre>");
            this.printMessage("Getting Order Item details and # of shipments to run this sample...");
            this.getNumberOfShipmentsAndOrderItems(request);

            this.printMessage("Now setting order reference detail...");
            this.addOrderRefernceDetails(request);

            this.printMessage("Order Reference is set with provided details.");
            this.printMessage("Now confirming this order reference...");
            example.confirmOrderReference();

            printMessage("Order Reference is confirmed and moved to 'OPEN' state");
            printMessage("Now getting details for Authorization...");
            this.authorizeAndCaptureShipments(request);

            this.printMessage("Authorization and Captures are completed for all shipment");
            this.printMessage("Now Closing the Order Reference...");
            example.closeOrderReference();

            this.printMessage("Order Refernce Moved to CLOSED state.");
            example.printOrderDetails();
            this.printMessage("Split Shipments Checkout Example is complete.");

        } catch (OffAmazonPaymentsServiceException ex) {
            outStream.println("Caught Exception: " + ex.getMessage());
            outStream.println("Response Status Code: " + ex.getStatusCode());
            outStream.println("Error Code: " + ex.getErrorCode());
            outStream.println("Error Type: " + ex.getErrorType());
            outStream.println("Request ID: " + ex.getRequestId());
            outStream.println("XML: " + ex.getXML());
            outStream.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        } finally {
            this.printMessage("</pre></div></body></html>");
        }
    }

    /**
     * Method to get Order Item detail and number of shipments.
     * It sets each order item with name, cost (including tax and
     * Shipping charge) and shipment number provided from console
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void getNumberOfShipmentsAndOrderItems(HttpServletRequest request) throws OffAmazonPaymentsServiceException {
        try {
            LOG.debug("Number of shipments :" + getParameterFromSession("NumberOfShipments", request));
            int totalShipments = Integer.parseInt(getParameterFromSession("NumberOfShipments", request));
            for (int i = 1; i <= totalShipments; i++) {
                String item = request.getParameter(String.format("Item_%s", i));
                String itemName = getItem(Integer.parseInt(item));
                /*
                 * Assuming this price, for each item, includes tax and shipment charge
                 */
                if (itemName == null) {
                    throw new OffAmazonPaymentsServiceException("Invalid Order Item selected");
                }
                double itemCost = ItemCost.valueOf(itemName).getItemCost();
                this.example.addOrderItemDetail(itemName, itemCost, i);
            }
        } catch (NumberFormatException e) {
            throw new OffAmazonPaymentsServiceException("Invalid number of shipments.");
        }

    }

    /**
     * It sets Order Reference object with Order Total
     * and other optional parameters provided from console
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void addOrderRefernceDetails(HttpServletRequest request) throws OffAmazonPaymentsServiceException {

        /*
         * Order total is calculated in SplitShipmentsCheckoutExample class
         * with orderItemDetails list
         * 
         * Following inputs are OPTIONAL, you can skip by pressing enter:
         * 
         * Use SellerOrderAttribute to set sellerOrderId, storeName,
         * orderItemCategories, customInformation.
         */
        String optionalSellerNote = getParameterFromSession("SellerNote", request);
        SellerOrderAttributes optionalSellerOrderAttributes = getSellerOrderAttributes(request);
        /*
         * Using setOrderReferenceDetails(), above parameters are added
         * to this Amazon order reference Id
         */
        SetOrderReferenceDetailsResponse response = this.example.setOrderDetails(optionalSellerNote,
                optionalSellerOrderAttributes);
        validateResponseNotNull(response, "SetOrderReferenceDetailResponse");
        SetOrderReferenceDetailsSample.printResponse(response, outStream);

    }

    /**
     * Method to authorize every shipment, waits for authorization complete
     * and captures each authorization
     * 
     * @param request
     * 
     * @param captureNow
     * @throws OffAmazonPaymentsServiceException
     */
    private void authorizeAndCaptureShipments(HttpServletRequest request) throws OffAmazonPaymentsServiceException {

        int totalShipment = this.example.orderItemDetails.size();

        if (totalShipment < 1) {
            throw new OffAmazonPaymentsServiceException("No Shipment to authorize...");
        }

        /*
         * Iterates through every shipment and performs:
         * Authorization
         * Waits for authorization to complete
         * And Captures the open authorization
         */
        for (int shipmentNumber = 1; shipmentNumber <= totalShipment; shipmentNumber++) {

            this.printMessage("Authorizing shipment #" + shipmentNumber + "...");
            String authorizationId = this.authorize(shipmentNumber);

            if (authorizationId == null) {
                throw new OffAmazonPaymentsServiceException("AmazonAuthorization ID is Null");
            }
            this.printMessage("Waiting on authorization to complete for shipment #" + shipmentNumber + "...");
            AuthorizationDetails authDetails = this.waitForAuthorization(authorizationId);

            this.printMessage("Authorization for this order item is complete and " + "moved to 'OPEN' state");
            this.printMessage("Now getting details for Capture for this " + "Authorization...");
            this.capture(authDetails, shipmentNumber, request);
        }

    }

    /**
     * Method that authorizes the order item in specified shipment number
     * 
     * @param shipmentNumber
     * @return amazonAuthorizationId
     * @throws OffAmazonPaymentsServiceException
     */
    private String authorize(int shipmentNumber) throws OffAmazonPaymentsServiceException {
        AuthorizeResponse response = this.example.authorizePartialOrderAmount(shipmentNumber);
        String amazonAuthorizationId = null;
        validateResponseNotNull(response, "AuthorizeResponse");
        AuthorizeSample.printResponse(response, outStream);

        this.validateResponseNotNull(response.getAuthorizeResult(), "AuthorizationResult");
        this.validateResponseNotNull(response.getAuthorizeResult().getAuthorizationDetails(), "AuthorizationDetails");
        amazonAuthorizationId = response.getAuthorizeResult().getAuthorizationDetails().getAmazonAuthorizationId();

        return amazonAuthorizationId;
    }

    /**
     * Method to check Authorization state
     * If the final state is OPEN, it returns Authorization Details
     * else throws exception
     * 
     * @return
     * @throws OffAmazonPaymentsServiceException
     */
    private AuthorizationDetails waitForAuthorization(String amazonAuthorizationId)
            throws OffAmazonPaymentsServiceException {

        AuthorizationNotification response = this.example.servletWaitUntilAuthorizationComplete(amazonAuthorizationId);

        validateResponseNotNull(response, "GetAuthorizationDetailsResponse");
        String authStatus = response.getAuthorizationDetails().getAuthorizationStatus().getState();
        if ((!authStatus.toUpperCase().equals("OPEN"))) {
            throw new OffAmazonPaymentsServiceException("Authorization State is " + authStatus
                    + ". Cannot capture this authorization");
        }
        Utilities.printAuthorizationNotification(response, outStream);
        return response.getAuthorizationDetails();

    }

    /**
     * Method to get capture details and
     * make capture request with provided info from console
     * 
     * @param authDetails
     * @param request
     * @throws OffAmazonPaymentsServiceException
     */
    private void capture(AuthorizationDetails authDetails, int shipmentNumber, HttpServletRequest request)
            throws OffAmazonPaymentsServiceException {
        validateResponseNotNull(authDetails, "AuthorizationDetails");
        String optionalSoftDescriptor = getParameterFromSession("SoftDescriptor", request);
        String optionalSellerCaptureNote = getParameterFromSession("SellerCaptureNote", request);
        CaptureResponse captureResponse = this.example.capturePartialOrderAmount(authDetails.getAuthorizationAmount()
                .getAmount(), authDetails.getAuthorizationAmount().getCurrencyCode(), authDetails
                .getAmazonAuthorizationId(), shipmentNumber, optionalSoftDescriptor, optionalSellerCaptureNote);
        validateResponseNotNull(captureResponse, "CaptureResponse");
        CaptureSample.printResponse(captureResponse, outStream);

    }

    /**
     * Method prints list of items for each shipment
     * 
     * @param shipmentNumber
     * @return
     */
    private String getItem(int option) {
        switch (option) {
        case 1:
            return "TSHIRT";
        case 2:
            return "SHORT";
        case 3:
            return "SWEATER";
        case 4:
            return "BLOUSE";
        case 5:
            return "SKIRT";
        default:
            return null;
        }
    }

    /**
     * Method to read Optional Seller Attributes for this Order
     * Gets following detail:
     * -sellerOrderId
     * -sellerCustomNotes
     * -storeName
     * -orderItemCategories
     * 
     * @return
     */
    private SellerOrderAttributes getSellerOrderAttributes(HttpServletRequest request) {
        SellerOrderAttributes optionalSellerOrderAttributes = new SellerOrderAttributes();

        String sellerOrderId = getParameterFromSession("SellerOrderId", request);
        if (StringUtils.isNotBlank(sellerOrderId)) {
            optionalSellerOrderAttributes.setSellerOrderId(sellerOrderId);
        }

        String sellerCustomNotes = getParameterFromSession("SellerNote", request);
        if (StringUtils.isNotBlank(sellerCustomNotes)) {
            optionalSellerOrderAttributes.setCustomInformation(sellerCustomNotes);
        }

        String storeName = getParameterFromSession("StoreName", request);
        if (StringUtils.isNotBlank(storeName)) {
            optionalSellerOrderAttributes.setStoreName(storeName);
        }

        return optionalSellerOrderAttributes;
    }

    private String getParameterFromSession(String attribute, HttpServletRequest request) {
        return (String) request.getSession().getAttribute(attribute);
    }

}
