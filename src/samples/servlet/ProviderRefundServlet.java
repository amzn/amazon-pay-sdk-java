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

import samples.GetProviderCreditReversalDetailsSample;
import samples.RefundExample;
import samples.RefundSample;
import samples.utils.Utilities;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditReversalDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.ProviderCreditReversalSummary;
import com.amazonservices.mws.offamazonpayments.model.ProviderCreditReversalSummaryList;
import com.amazonservices.mws.offamazonpayments.model.RefundResponse;
import com.amazonservices.mws.offamazonpaymentsipn.model.RefundNotification;

public class ProviderRefundServlet extends IpnExampleServletBase {
    private static final long serialVersionUID = 1L;
    RefundExample example = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        outStream = response.getWriter();
        String amazonOrderReferenceId = request.getParameter("OrderReferenceId");
        String amazonCaptureId = request.getParameter("CaptureId");

        this.example = new RefundExample(amazonOrderReferenceId, amazonCaptureId, config, service, outStream);
        runSample(request);
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all API calls
     * that will be required for a refund
     * 
     * @param request
     */
    public void runSample(HttpServletRequest request) {
        try {
            this.printMessage("<html><head><title>Provider Refund result</title></head><body><div><pre>");
            this.doRefund(request);
            this.printMessage("Refund example is complete");
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
     * Method gets details for refund, and makes refund request call
     * It also waits for the refund to complete.
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void doRefund(HttpServletRequest request) throws OffAmazonPaymentsServiceException {

        try {
            double refundAmount = Double.parseDouble(request.getParameter("RefundedAmount"));

            // Optional
            String sellerRefundNote = request.getParameter("SellerRefundNote");
            String softDescriptor = request.getParameter("SoftDescriptor");
            String providerId = request.getParameter("ProviderId");
            String creditReversalAmount = request.getParameter("CreditReversalAmount");

            RefundResponse response = this.example.refund(refundAmount, sellerRefundNote, softDescriptor, providerId,
                    creditReversalAmount);
            validateResponseNotNull(response, "RefundResponse");
            RefundSample.printResponse(response, outStream);
            this.printMessage("Waiting for Refund to Complete...");
            String amazonRefundId = waitRefundToComplete(response);
            
            ProviderCreditReversalSummaryList providerCreditReversalSummaryList = this.example
                    .waitForRefundDetailsWithProviderCreditReversalSummaryList(amazonRefundId)
                    .getProviderCreditReversalSummaryList();
            getProviderCreditReversalDetails(providerCreditReversalSummaryList);

        } catch (NumberFormatException e) {
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
    private String waitRefundToComplete(RefundResponse refundResponse) throws OffAmazonPaymentsServiceException {
        String amazonRefundId = refundResponse.getRefundResult().getRefundDetails().getAmazonRefundId();
        RefundNotification response = this.example.servletWaitUntilRefundComplete(amazonRefundId);
        validateResponseNotNull(response, "RefundNotification");
        Utilities.printRefundNotification(response, outStream);
        return response.getRefundDetails().getAmazonRefundId();
    }

    /**
     * Method to Get Provider Credit Reversal Details from
     * Provider Credit Reversal Summary List
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void getProviderCreditReversalDetails(ProviderCreditReversalSummaryList providerCreditReversalSummaryList)
            throws OffAmazonPaymentsServiceException {
        if (providerCreditReversalSummaryList == null || !providerCreditReversalSummaryList.isSetMember()) {
            throw new OffAmazonPaymentsServiceException("Null Provider Credit Summary List from Capture Details.");
        }
        for (ProviderCreditReversalSummary providerCreditReversalSummary : providerCreditReversalSummaryList
                .getMember()) {
            this.example.servletWaitForProviderCreditReversalNotification(providerCreditReversalSummary
                    .getProviderCreditReversalId());
            GetProviderCreditReversalDetailsResponse getProviderCreditReversalDetailsResponse = this.example
                    .getProviderCreditReversalDetails(providerCreditReversalSummary.getProviderCreditReversalId());
            validateResponseNotNull(getProviderCreditReversalDetailsResponse, "GetProviderCreditReversalDetailsResponse");
            GetProviderCreditReversalDetailsSample.printResponse(getProviderCreditReversalDetailsResponse, outStream);
        }
    }
}
