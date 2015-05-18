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
 * *****************************************************************************
 */

package samples.cli;

import samples.ReverseProviderCreditExample;
import samples.ReverseProviderCreditSample;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

/**
 * Refund Example CLI
 * This sample drives RefundExample by
 * getting required inputs via command line
 * 
 */

public class ReverseProviderCreditExampleCLI extends CLIHelperClass {

    private ReverseProviderCreditExample example = null;

    /**
     * ReverseProviderCreditExample instance
     */
    public ReverseProviderCreditExampleCLI() {
        String amazonProviderCreditId = this
                .getUserStringFromConsole("Amazon Provider Credit Id to run Reverse Provider Credit: ");
        this.example = new ReverseProviderCreditExample(amazonProviderCreditId, config, service, outStream);
    }

    public static void main(String[] args) {
        ReverseProviderCreditExampleCLI reverseProviderCreditSample = new ReverseProviderCreditExampleCLI();
        reverseProviderCreditSample.runSample();
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all API calls
     * that will be required for a refund
     */
    public void runSample() {
        try {
            this.doReverseProviderCredit();
            this.printMessage("Reverse Provider Credit is complete");
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
     * Method gets details for refund, and makes refund request call
     * It also waits for the refund to complete.
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void doReverseProviderCredit() throws OffAmazonPaymentsServiceException {

        double creditReversalAmount = this.getCreditReversalAmount();
        /*
         * Optional Parameters
         * Can be skipped just pressing enter
         */
        String sellerCreditReversalNote = this.getUserStringFromConsole("Seller note for Credit Reversal Note");

        ReverseProviderCreditResponse response = this.example.reverseProviderCredit(creditReversalAmount,
                sellerCreditReversalNote);
        validateResponseNotNull(response, "ReverseProviderCreditResponse");
        ReverseProviderCreditSample.printResponse(response, outStream);
    }

    /**
     * Method to get credit reversal amount from console
     * 
     * @return creditReversalAmtoun
     * @throws OffAmazonPaymentsServiceException
     */
    private double getCreditReversalAmount() throws OffAmazonPaymentsServiceException {
        outStream.println("Please Enter a credit reversal amount: ");
        try {
            double refundAmount = Double.valueOf(in.next().trim());
            refundAmount = Double.valueOf(new java.text.DecimalFormat("#.##").format(refundAmount));
            return refundAmount;
        } catch (NumberFormatException e) {
            throw new OffAmazonPaymentsServiceException("Invalid credit reversal amount.");
        } catch (NullPointerException e) {
            throw new OffAmazonPaymentsServiceException("Invalid credit reversal amount.");
        }
    }
}
