/*****************************************************************************
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
 * ****************************************************************************
 */

package samples;

import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

import samples.utils.Utilities;

/******************************************************************************
 * Split Shipments Checkout Example
 * 
 * This demonstrates a merchant use case where the items in a particular Order
 * reference have multiple shipments or single item shipped multiple times. In
 * either use case, it requires multiple Authorization and Capture. This example
 * helps to implement such use case
 * 
 * NOTE: This example uses item level details for setting an Order Reference,
 * this is for demonstration purpose ONLY. With Amazon Payment Advanced API it
 * is NOT required to provide item level details
 * 
 * This example will show the following service calls:
 * - GetOrderReferenceDetails
 * - SetOrderReferenceDetails
 * - ConfirmOrderReference
 * - Authorize
 * - GetAuthorizeDetails
 * - Capture
 * - CloseOrderReference
 *****************************************************************************/

public class SplitShipmentsCheckoutExample extends CheckoutExampleBase {

    private String amazonOrderReferenceId = null;
    private String authorizationId = null;
    private String captureId = null;
    /*
     * List of OrderItemDetail helper class instances to
     * hold details on order items that are shipped individually
     */
    public List<OrderItemDetail> orderItemDetails = new ArrayList<OrderItemDetail>();

    public SplitShipmentsCheckoutExample(String amazonOrderReferenceId, OffAmazonPaymentsServiceConfig config,
            OffAmazonPaymentsServiceClient service, PrintWriter outStream) {
        super(config, service, outStream);
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.authorizationId = amazonOrderReferenceId + "a01";
        this.captureId = this.authorizationId + "c01";
    }

    /**
     * Method to print the order reference details, Use this method to
     * display buyer's shipping address detail
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void printOrderDetails() throws OffAmazonPaymentsServiceException {
        this.printOrderDetails(this.amazonOrderReferenceId);
    }

    /**
     * Method to set required seller details to the Order Reference Object
     * 
     * @param optionalSellerNote
     * @param optionalSellerOrderAttributes
     * @return SetOrderReferenceDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public SetOrderReferenceDetailsResponse setOrderDetails(String optionalSellerNote,
            SellerOrderAttributes optionalSellerOrderAttributes) throws OffAmazonPaymentsServiceException {

        if (this.orderItemDetails.isEmpty()) {
            throw new OffAmazonPaymentsServiceException("No Order items to set order reference detail");
        } else {
            /*
             * Set the total amount for the purchase using OrderTotal Class
             */
            double orderTotalCharge = 0.00;
            for (OrderItemDetail orderItem : this.orderItemDetails) {
                orderTotalCharge += orderItem.getAmount();
            }

            OrderReferenceAttributes orderReferenceAttributes = new OrderReferenceAttributes();

            OrderTotal orderTotal = new OrderTotal();
            orderTotal.setAmount(new Double(orderTotalCharge).toString());
            orderTotal.setCurrencyCode(config.getCurrencyCode());

            orderReferenceAttributes.setOrderTotal(orderTotal);

            /*
             * Set seller note for this order, this is optional parameter
             */
            if (optionalSellerNote != null) {
                orderReferenceAttributes.setSellerNote(optionalSellerNote);
            }

            /*
             * Set seller order attribute, this is optional parameter
             */
            if (optionalSellerOrderAttributes != null) {
                orderReferenceAttributes.setSellerOrderAttributes(optionalSellerOrderAttributes);
            }

            SetOrderReferenceDetailsRequest request = new SetOrderReferenceDetailsRequest();
            request.setAmazonOrderReferenceId(this.amazonOrderReferenceId);
            request.setSellerId(this.sellerId);
            request.setOrderReferenceAttributes(orderReferenceAttributes);

            SetOrderReferenceDetailsResponse response = this.service.setOrderReferenceDetails(request);
            return response;
        }
    }

    /**
     * Method to confirm an ORO. Calling this method will move
     * Order reference Object from DRAFT to OPEN STATE
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void confirmOrderReference() throws OffAmazonPaymentsServiceException {
        ConfirmOrderReferenceRequest request = new ConfirmOrderReferenceRequest();
        request.setAmazonOrderReferenceId(this.amazonOrderReferenceId);
        request.setSellerId(this.sellerId);

        ConfirmOrderReferenceResponse result = this.service.confirmOrderReference(request);
        Utilities.validateResponseNotNull(result, "ConfirmOrderReferenceResponse");
        ConfirmOrderReferenceSample.printResponse(result, outStream);
    }

    /**
     * Method to authorize the partial amount for the order reference.
     * 
     * This method uses an integer - shipmentNumber to generate unique
     * seller authorization Id for each authorization requestcall.
     * 
     * This method also sets a Transaction timeout, which illustrates
     * another way to timeout the authorization
     * 
     * @param shipmentNumber
     * @return AuthorizeResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public AuthorizeResponse authorizePartialOrderAmount(int shipmentNumber) throws OffAmazonPaymentsServiceException {
        if (this.orderItemDetails.isEmpty()) {
            throw new OffAmazonPaymentsServiceException("No Order Items set for authorization");
        } else {
            /*
             * Checks every Order Item to match with provided shiping number, if none found, throw an exception
             */
            for (OrderItemDetail itemToAuthorize : this.orderItemDetails) {
                if (itemToAuthorize.getShipmentNumber() == shipmentNumber) {
                    AuthorizeRequest request = new AuthorizeRequest();
                    /*
                     * Getting the total order amount and
                     * currency code from Order Reference
                     */
                    Price authTotal = new Price();
                    authTotal.setAmount(Double.valueOf(itemToAuthorize.getAmount()).toString());
                    authTotal.setCurrencyCode(this.config.getCurrencyCode());

                    request.setAuthorizationAmount(authTotal);
                    request.setAmazonOrderReferenceId(this.amazonOrderReferenceId);
                    request.setSellerId(this.sellerId);
                    /*
                     * shipmentNumber is used to generate unique seller
                     * Authorization ID each authorization
                     */
                    request.setAuthorizationReferenceId(this.authorizationId + new Integer(shipmentNumber).toString());

                    /*
                     * Optional Parameters
                     */
                    request.setSellerAuthorizationNote("Authorization for: " + itemToAuthorize.getItemName());
                    /*
                     * Optional timeout parameter.
                     * This is used when polling for auth status.
                     */
                    request.setTransactionTimeout(15);

                    AuthorizeResponse result = this.service.authorize(request);
                    return result;
                }
            }
            throw new OffAmazonPaymentsServiceException("No Orde Item found with shipment number: " + shipmentNumber);
        }
    }

    /**
     * Method to capture partial authorized Amount
     * This method uses an integer - shipmentNumber to generate unique
     * seller capture Id for each capture request call.
     * 
     * @param amount
     * @param currencyCode
     * @param amazonAuthorizationId
     * @param shipmentNumber
     * @param softDescriptor
     * @param sellerCaptureNote
     * @return CaptureResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public CaptureResponse capturePartialOrderAmount(String amount, String currencyCode, String amazonAuthorizationId,
            int shipmentNumber, String softDescriptor, String sellerCaptureNote)
            throws OffAmazonPaymentsServiceException {
        return this.captureOrderAmount(amount, currencyCode, amazonAuthorizationId, this.captureId
                + new Integer(shipmentNumber).toString(), softDescriptor, sellerCaptureNote);
    }

    /**
     * Method to close Order Reference. It is always recommended to
     * close the order reference object after all amount is captured
     * 
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public void closeOrderReference() throws OffAmazonPaymentsServiceException {
        CloseOrderReferenceRequest request = new CloseOrderReferenceRequest();
        request.setSellerId(this.sellerId);
        request.setAmazonOrderReferenceId(this.amazonOrderReferenceId);

        CloseOrderReferenceResponse result = this.service.closeOrderReference(request);
        Utilities.validateResponseNotNull(result, "CloseOrderReferenceResponse");
        CloseOrderReferenceSample.printResponse(result, outStream);

    }

    /**
     * Helper Method to add items to OrderItemDetails list
     * 
     * @param itemName
     * @param amount
     * @param shipmentNumber
     */
    public void addOrderItemDetail(String itemName, double amount, int shipmentNumber)
            throws OffAmazonPaymentsServiceException {
        if (itemName == null) {
            throw new OffAmazonPaymentsServiceException("No Item Name provided to add");
        }
        OrderItemDetail item = new OrderItemDetail(itemName, amount, this.config.getCurrencyCode(), shipmentNumber);
        this.orderItemDetails.add(item);

    }

    /***************************************************************************
     * Helper class for demonstrating spilt shipment example with
     * different order item with their Amount and Currency Code
     * 
     * Note: Amount for each item is assumed to include
     * quantity,tax and shipping rate
     ***************************************************************************/
    private class OrderItemDetail {
        private String itemName;
        private double amount;
        private int shipmentNumber;

        public OrderItemDetail(String itemName, double amount, String currencyCode, int shipmentNumber) {
            this.amount = amount;
            this.itemName = itemName;
            this.shipmentNumber = shipmentNumber;
        }

        public String getItemName() {
            return this.itemName;
        }

        public double getAmount() {
            return this.amount;
        }

        public int getShipmentNumber() {
            return this.shipmentNumber;
        }
    }

}
