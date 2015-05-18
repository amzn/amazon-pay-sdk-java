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

package samples;

import java.io.PrintWriter;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

import samples.utils.Utilities;

/**
 * Order Cancellation Example
 * 
 * This example demonstrates a merchant use case, where a order needs to be
 * cancelled before capturing the amount.
 * 
 * Cancellation operation can be performed on a previously confirmed
 * order reference.You can only call the CancelOrderReference
 * operation when the order reference has not been charged,
 * or has captured funds. If you cancel an order reference,
 * all authorizations associated with this order reference are also closed
 * 
 * This example will show the following service calls
 * by extending from SimpleCheckoutExample Class:
 * - SetOrderReferenceDetails
 * - ConfirmOrderReference
 * - Authorize
 * - GetAuthorizeDetails
 * - CancelOrderReference
 * - GetOrderReferenceDetails
 */
public class OrderCancellationExample extends SimpleCheckoutExample {

    private String amazonOrderReferenceId = null;

    public OrderCancellationExample(String amazonOrderReferenceId, OffAmazonPaymentsServiceConfig config,
            OffAmazonPaymentsServiceClient service, PrintWriter outStream) {
        super(amazonOrderReferenceId, config, service, outStream);
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }

    /**
     * Method to set the order reference with
     * just the order amount of 100.00, all
     * optional parameters are set to NULL
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void setOrderReferenceDetail() throws OffAmazonPaymentsServiceException {
        SetOrderReferenceDetailsResponse response = setOrderDetails(100.00, null, null);
        Utilities.validateResponseNotNull(response, "SetOrderReferenceDetailsResponse");
        SetOrderReferenceDetailsSample.printResponse(response, outStream);

    }

    /**
     * Method to authorize request call
     * for the full order total set in this
     * Order reference
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void authorize() throws OffAmazonPaymentsServiceException {
        this.authorize(false, 1, "", "");
    }

    /**
     * Method to cancel a Order Reference object
     * And to move ORO to CANCELED state
     * 
     * @param optionalCancellationNote
     * @throws OffAmazonPaymentsServiceException
     */
    public void cancelOrderReference(String optionalCancellationNote) throws OffAmazonPaymentsServiceException {
        CancelOrderReferenceRequest request = new CancelOrderReferenceRequest();
        request.setAmazonOrderReferenceId(this.amazonOrderReferenceId);
        request.setSellerId(this.sellerId);

        /*
         * Optional parameter
         */
        request.setCancelationReason(optionalCancellationNote);

        CancelOrderReferenceResponse response = this.service.cancelOrderReference(request);
        Utilities.validateResponseNotNull(response, "CancelOrderReferenceResponse");
        CancelOrderReferenceSample.printResponse(response, outStream);

    }

    /**
     * Method to show Order reference detail
     * for provided Amazon Order Reference ID
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void printOrderReferenceDetails() throws OffAmazonPaymentsServiceException {
        GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest();
        request.setAmazonOrderReferenceId(this.amazonOrderReferenceId);
        request.setSellerId(this.sellerId);

        GetOrderReferenceDetailsResponse response = this.service.getOrderReferenceDetails(request);
        Utilities.validateResponseNotNull(response, "GetOrderReferenceDetailsResponse");
        GetOrderReferenceDetailsSample.printResponse(response, outStream);

    }

    /**
     * Method to show Authorization details after cancellation
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void printAuthorizationDetails() throws OffAmazonPaymentsServiceException {
        GetAuthorizationDetailsResponse response = this.getAuthorizationDetails();
        Utilities.validateResponseNotNull(response, "GetAuthorizationDetailsResponse");
        GetAuthorizationDetailsSample.printResponse(response, outStream);
    }

}
