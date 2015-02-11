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
import samples.ReverseProviderCreditExample;
import samples.ReverseProviderCreditSample;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditReversalDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.ReverseProviderCreditResponse;

public class ReverseProviderCreditServlet extends IpnExampleServletBase {
    private static final long serialVersionUID = 1L;
    private ReverseProviderCreditExample example = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        outStream = response.getWriter();
        String amazonProviderCreditId = request.getParameter("ProviderCreditId");
        this.example = new ReverseProviderCreditExample(amazonProviderCreditId, config, service, outStream);
        runSample(request);
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all API calls
     * that will be required for a reverse provider credit
     * 
     * @param request
     */
    public void runSample(HttpServletRequest request) {
        try {
            this.printMessage("<html><head><title>Reverse Provider Credit result</title></head><body><div><pre>");
            this.doReverseProviderCredit(request);
            this.printMessage("Reverse Provider Credit example is complete");
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
     * Method gets details for reverse provider credit, and makes
     * the reverse provider credit call and wait for the IPN. 
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void doReverseProviderCredit(HttpServletRequest request) throws OffAmazonPaymentsServiceException {

        double creditReversalAmount = Double.parseDouble(request.getParameter("CreditReversalAmount"));
        // Optional
        String sellerCreditReversalNote = request.getParameter("CreditReversalNote");
        ReverseProviderCreditResponse response = this.example.reverseProviderCredit(creditReversalAmount,
                sellerCreditReversalNote);
        validateResponseNotNull(response, "ReverseProviderCreditResponse");
        ReverseProviderCreditSample.printResponse(response, outStream);
        
        String providerCreditReversalId = response.getReverseProviderCreditResult().getProviderCreditReversalDetails()
                .getAmazonProviderCreditReversalId();
        this.example.servletWaitForProviderCreditReversalNotification(providerCreditReversalId);
        
        GetProviderCreditReversalDetailsResponse getProviderCreditReversalDetailsResponse = this.example
                .getProviderCreditReversalDetails(providerCreditReversalId);
        validateResponseNotNull(getProviderCreditReversalDetailsResponse, "GetProviderCreditReversalDetailsResponse");
        GetProviderCreditReversalDetailsSample.printResponse(getProviderCreditReversalDetailsResponse, outStream);
    }
}
