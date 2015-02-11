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
 */

package samples.cli;

import samples.AuthorizeSample;
import samples.CaptureSample;
import samples.GetAuthorizationDetailsSample;
import samples.SetOrderReferenceDetailsSample;
import samples.SplitShipmentsCheckoutExample;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

public class SplitShipmentsCheckoutExampleCLI extends CLIHelperClass {

    private SplitShipmentsCheckoutExample example = null;

    /*
     * Helper ENUM for setting cost for selected item
     */
    public static enum ItemCost {

        TSHIRT(75.30), SHORT(43.20), SWEATER(78.98), BLOUSE(42.00), SKIRT(98.99);

        private double value;

        private ItemCost(double value) {
            this.value = value;
        }

        public double getItemCost() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        SplitShipmentsCheckoutExampleCLI splitShipmentsCheckoutExampleCLI = new SplitShipmentsCheckoutExampleCLI();
        splitShipmentsCheckoutExampleCLI.runSample();
    }

    public SplitShipmentsCheckoutExampleCLI() {
        super();
        this.example = new SplitShipmentsCheckoutExample(amazonOrderReferenceId, config, service, outStream);
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all
     * API calls that will be required for split
     * shipments with multiple authorizations followed
     * with it's capture
     */
    public void runSample() {
        try {
            this.printMessage("Getting Order Item details and # of shipments to run this sample...");
            this.getNumberOfShipmentsAndOrderItems();

            this.printMessage("Now setting order reference detail...");
            this.addOrderRefernceDetails();

            this.printMessage("Order Reference is set with provided details.");
            this.printMessage("Now confirming this order reference...");
            example.confirmOrderReference();

            printMessage("Order Reference is confirmed and moved to 'OPEN' state");
            printMessage("Now getting details for Authorization...");
            this.authorizeAndCaptureShipments();

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
        }
    }

    /**
     * Method to get Order Item detail and number of shipments.
     * It sets each order item with name, cost (including tax and
     * Shipping charge) and shipment number provided from console
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void getNumberOfShipmentsAndOrderItems() throws OffAmazonPaymentsServiceException {

        outStream.println("Enter number of shipments. " + "Each shipment will have seperate authorization:");
        int totalShipments = Integer.valueOf(in.next().trim());
        for (int i = 1; i <= totalShipments; i++) {
            String itemName = getItem(i);
            /*
             * Assuming this price, for each item, includes tax and shipment charge
             */
            if (itemName == null) {
                throw new OffAmazonPaymentsServiceException("Invalid Order Item selected");
            }
            double itemCost = ItemCost.valueOf(itemName).getItemCost();
            this.example.addOrderItemDetail(itemName, itemCost, i);
        }

    }

    /**
     * It sets Order Reference object with Order Total
     * and other optional parameters provided from console
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void addOrderRefernceDetails() throws OffAmazonPaymentsServiceException {

        /*
         * Order total is calculated in SplitShipmentsCheckoutExample class
         * with orderItemDetails list
         * 
         * Following inputs are OPTIONAL, you can skip by pressing enter:
         * 
         * Use SellerOrderAttribute to set sellerOrderId, storeName,
         * orderItemCategories, customInformation.
         */
        String optionalSellerNote = getUserStringFromConsole("Seller Note");
        SellerOrderAttributes optionalSellerOrderAttributes = getSellerOrderAttributes();
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
     * @param captureNow
     * @throws OffAmazonPaymentsServiceException
     */
    private void authorizeAndCaptureShipments() throws OffAmazonPaymentsServiceException {

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
            this.capture(authDetails, shipmentNumber);
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

        validateResponseNotNull(response.getAuthorizeResult(), "AuthorizationResult");
        validateResponseNotNull(response.getAuthorizeResult().getAuthorizationDetails(), "AuthorizationDetails");
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

        GetAuthorizationDetailsResponse response = this.example
                .cliWaitUntilAuthorizationComplete(amazonAuthorizationId);

        validateResponseNotNull(response, "GetAuthorizationDetailsResponse");
        String authStatus = response.getGetAuthorizationDetailsResult().getAuthorizationDetails()
                .getAuthorizationStatus().getState();
        if ((!authStatus.toUpperCase().equals("OPEN"))) {
            throw new OffAmazonPaymentsServiceException("Authorization State is " + authStatus
                    + ". Cannot capture this authorization");
        }
        GetAuthorizationDetailsSample.printResponse(response, outStream);
        return response.getGetAuthorizationDetailsResult().getAuthorizationDetails();

    }

    /**
     * Method to get capture details and
     * make capture request with provided info from console
     * 
     * @param authDetails
     * @throws OffAmazonPaymentsServiceException
     */
    private void capture(AuthorizationDetails authDetails, int shipmentNumber) throws OffAmazonPaymentsServiceException {
        validateResponseNotNull(authDetails, "AuthorizationDetails");
        String optionalSoftDescriptor = getUserStringFromConsole("Soft Descriptor");
        String optionalSellerCaptureNote = getUserStringFromConsole("Seller Capture Note");
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
    private String getItem(int shipmentNumber) {
        outStream.println("Select an order item for shipment #: " + shipmentNumber);
        outStream.println("1. T-Shirt");
        outStream.println("2. Short");
        outStream.println("3. Sweater");
        outStream.println("4. Blouse");
        outStream.println("5. Skirt");
        outStream.println("Your Option? :");
        int option = Integer.valueOf(in.next().trim());
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
    private SellerOrderAttributes getSellerOrderAttributes() {
        SellerOrderAttributes optionalSellerOrderAttributes = new SellerOrderAttributes();

        String sellerOrderId = this.getUserStringFromConsole("seller order id for this order: ");
        if (sellerOrderId != null && !sellerOrderId.equals("")) {
            optionalSellerOrderAttributes.setSellerOrderId(sellerOrderId);
        }

        String sellerCustomNotes = this.getUserStringFromConsole("your custom notes for this order: ");
        if (sellerCustomNotes != null && !sellerCustomNotes.equals("")) {
            optionalSellerOrderAttributes.setCustomInformation(sellerCustomNotes);
        }

        String storeName = this.getUserStringFromConsole("your store name: ");
        if (storeName != null && !storeName.equals("")) {
            optionalSellerOrderAttributes.setStoreName(storeName);
        }

        return optionalSellerOrderAttributes;
    }
}
