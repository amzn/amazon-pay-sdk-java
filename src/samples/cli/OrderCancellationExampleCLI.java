/*******************************************************************************
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
 *
 */

package samples.cli;

import samples.OrderCancellationExample;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

/**
 * Order Cancellation Example CLI
 * This sample drives OrderCancellationExample by
 * getting required inputs via command line
 * 
 */

public class OrderCancellationExampleCLI extends CLIHelperClass {

    private OrderCancellationExample example = null;

    public OrderCancellationExampleCLI() {
        super();
        this.example = new OrderCancellationExample(amazonOrderReferenceId, config, service, outStream);
    }

    public static void main(String[] args) {
        OrderCancellationExampleCLI cancellationSample = new OrderCancellationExampleCLI();
        cancellationSample.runSample();
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all API calls
     * that will be required for a Order Cancellation
     */
    public void runSample() {
        try {
            this.printMessage("Setting this Order " + "Reference with an order total of $100.00...");
            example.setOrderReferenceDetail();

            this.printMessage("Now confirming this order reference...");
            example.confirmOrderReference();

            this.printMessage("Order Reference is confirmed " + "and moved to 'OPEN' state");
            this.printMessage("Now Authorizing this Order Reference " + "with full amount ($100.00)...");
            example.authorize();
            this.waitForAuthorization();

            this.printMessage("Authorization is COMPLETE and " + "there are no Captures on this Order Reference");
            this.printMessage("Now Cancelling this order...");
            example.cancelOrderReference(this.amazonOrderReferenceId);

            this.printMessage("Order Reference Details after cancellation");
            example.printOrderReferenceDetails();

            this.printMessage("Authorization Details after cancellation");
            example.printAuthorizationDetails();
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
     * Method to check Authorization state
     * If the final state is not OPEN
     * it throws exception
     * 
     * @return
     * @throws OffAmazonPaymentsServiceException
     */
    private void waitForAuthorization() throws OffAmazonPaymentsServiceException {

        outStream.println("Waiting for authorization to complete...");

        GetAuthorizationDetailsResponse response = this.example.cliWaitUntilAuthorizationComplete();
        validateResponseNotNull(response, "Authorization");

        String authStatus = response.getGetAuthorizationDetailsResult().getAuthorizationDetails()
                .getAuthorizationStatus().getState();
        if ((!authStatus.toUpperCase().equals("OPEN"))) {
            throw new OffAmazonPaymentsServiceException("Authorization State is not OPEN. " + "It is: " + authStatus);
        }

    }
}
