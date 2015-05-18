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

import samples.GetRefundDetailsSample;
import samples.RefundExample;
import samples.RefundSample;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

/**
 * Refund Example CLI
 * This sample drives RefundExample by
 * getting required inputs via command line
 * 
 */

public class RefundExampleCLI extends CLIHelperClass {

    private RefundExample example = null;

    /**
     * .
     * Constructor, which calls super() to set AmazonOrder Reference ID
     * And It also gets reads Capture ID from console to initialize
     * RefundExample instance
     */
    public RefundExampleCLI() {
        super();

        String amazonCaptureId = this.getUserStringFromConsole("a valid Amazon Capture ID to run this Refund Sample: ");

        this.example = new RefundExample(amazonOrderReferenceId, amazonCaptureId, config, service, outStream);
    }

    public static void main(String[] args) {
        RefundExampleCLI refundSample = new RefundExampleCLI();
        refundSample.runSample();
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all API calls
     * that will be required for a refund
     */
    public void runSample() {
        try {
            this.printMessage("OrderReferenceDetails for Refund..");
            example.printOrderDetails();

            this.printMessage("Capture Details for this Refund..");
            example.printCaptureDetailsForRefund();

            this.printMessage("Now getting details about the Refund...");
            this.doRefund();

            this.printMessage("Refund is complete");
            this.printMessage("CaptureDetails after the refund...");
            example.printCaptureDetailsForRefund();

            this.printMessage("Refund example is complete");
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
    private void doRefund() throws OffAmazonPaymentsServiceException {

        double refundAmount = this.getRefundAmount();
        /*
         * Optional Parameters
         * Can be skipped just pressing enter
         */
        String sellerRefundNote = this.getUserStringFromConsole("Seller note for Refund");
        String softDescriptor = this.getUserStringFromConsole("Soft Descriptor for the Refund");

        RefundResponse response = this.example.refund(refundAmount, sellerRefundNote, softDescriptor);
        validateResponseNotNull(response, "RefundResponse");
        this.printMessage("Refund request set...");
        RefundSample.printResponse(response, outStream);
        this.printMessage("Waiting for Refund to Complete...");
        waitRefundToComplete(response);

    }

    /**
     * Method to get refund amount from console
     * 
     * @return refundAmount
     * @throws OffAmazonPaymentsServiceException
     */
    private double getRefundAmount() throws OffAmazonPaymentsServiceException {
        outStream.println("Please Enter a refund amount for this Sample: ");
        try {
            double refundAmount = Double.valueOf(in.next().trim());
            refundAmount = Double.valueOf(new java.text.DecimalFormat("#.##").format(refundAmount));
            return refundAmount;
        } catch (NumberFormatException e) {
            throw new OffAmazonPaymentsServiceException("Invalid refund amount.");
        } catch (NullPointerException e) {
            throw new OffAmazonPaymentsServiceException("Invalid refund amount.");
        }
    }

    /**
     * Method to wait on refund status to move from PENDING
     * If the return refund status is not COMPLETE
     * this throws an exception
     * 
     * @param RefundResponse
     * @throws OffAmazonPaymentsServiceException
     */
    private void waitRefundToComplete(RefundResponse refundResponse) throws OffAmazonPaymentsServiceException {

        String amazonRefundId = null;

        validateResponseNotNull(refundResponse.getRefundResult(), "RefundResult");
        validateResponseNotNull(refundResponse.getRefundResult().getRefundDetails(), "RefundDetails");
        amazonRefundId = refundResponse.getRefundResult().getRefundDetails().getAmazonRefundId();

        GetRefundDetailsResponse response = this.example.cliWaitUntilRefundComplete(amazonRefundId);
        validateResponseNotNull(response, "GetRefundDetailsResponse");

        String refundStatus = response.getGetRefundDetailsResult().getRefundDetails().getRefundStatus().getState();
        if ((!refundStatus.toUpperCase().equals("COMPLETED"))) {
            if ((refundStatus.toUpperCase().equals("PENDING"))) {
                this.printMessage("Refund status is still Pending!!");
                this.printMessage("Check the status for this refund again with" + "AmazonRefund ID: "
                        + response.getGetRefundDetailsResult().getRefundDetails().getAmazonRefundId());
                System.exit(0);
            } else {
                throw new OffAmazonPaymentsServiceException("Refund State is NOT COMPLETE. It is " + refundStatus);
            }
        }
        GetRefundDetailsSample.printResponse(response, outStream);

    }
}
