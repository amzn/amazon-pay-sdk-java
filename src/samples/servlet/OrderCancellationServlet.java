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

import samples.OrderCancellationExample;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationNotification;

public class OrderCancellationServlet extends IpnExampleServletBase {

    private static final long serialVersionUID = 1L;

    OrderCancellationExample example = null;
    String amazonOrderReferenceId = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        amazonOrderReferenceId = request.getParameter("OrderReferenceId");
        outStream = response.getWriter();
        example = new OrderCancellationExample(amazonOrderReferenceId, config, service, outStream);
        runSample();
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all API calls
     * that will be required for a Order Cancellation
     */
    public void runSample() {
        try {
            this.printMessage("<html><head><title>Order cancellation result</title></head><body><div><pre>");
            this.printMessage("Setting this Order " + "Reference with an order total of $100.00...");
            example.setOrderReferenceDetail();

            this.printMessage("Now confirming this order reference...");
            example.confirmOrderReference();

            this.printMessage("Order Reference is confirmed " + "and moved to 'OPEN' state");
            this.printMessage("Now Authorizing this Order Reference " + "with full amount ($100.00)...");
            example.authorize();
            this.waitForAuthorizationNotification();

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
        } finally {
            this.printMessage("</pre></div></body></html>");
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
    private void waitForAuthorizationNotification() throws OffAmazonPaymentsServiceException {

        outStream.println("Waiting for authorization to complete...");

        AuthorizationNotification response = this.example.servletWaitUntilAuthorizationComplete();
        validateResponseNotNull(response, "Authorization");

        String authStatus = response.getAuthorizationDetails().getAuthorizationStatus().getState();
        if ((!authStatus.toUpperCase().equals("OPEN"))) {
            throw new OffAmazonPaymentsServiceException("Authorization State is not OPEN. " + "It is: " + authStatus);

        }
    }
}
