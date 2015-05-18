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

import samples.CaptureSample;
import samples.GetAuthorizationDetailsSample;
import samples.SimpleCheckoutExample;
import samples.utils.Utilities;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.CaptureResponse;
import com.amazonservices.mws.offamazonpayments.model.GetAuthorizationDetailsResponse;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationDetails;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationNotification;

public class SimpleCheckoutServlet extends IpnExampleServletBase {

    private static final long serialVersionUID = 1L;
    SimpleCheckoutExample example = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        outStream = response.getWriter();
        String amazonOrderReferenceId = request.getParameter("OrderReferenceId");
        example = new SimpleCheckoutExample(amazonOrderReferenceId, config, service, outStream);
        runSample(request);
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all
     * API calls that will be required for simple
     * cart checkout followed with immediate authorization
     * and capture of entire order amount
     */
    public void runSample(HttpServletRequest request) {
        try {
            this.printMessage("<html><head><title>Simple checkout result</title></head><body><div><pre>");
            example.addOrderReferenceDetails(request.getParameter("SellerNote"),
                    request.getParameter("OrderReferenceId"), request.getParameter("CustomNote"),
                    request.getParameter("StoreName"), request.getParameter("Subtotal"),
                    request.getParameter("ShippingType"));

            this.printMessage("Order Reference is set with provided details.");
            this.printMessage("Now confirming this order reference...");

            example.confirmOrderReference();
            this.printMessage("Order Reference is confirmed and " + "moved to 'OPEN' state");
            this.printMessage("Now getting details for Authorization...");

            int authOption = Integer.parseInt(request.getParameter("AuthorizeOption"));
            if (!(authOption == 1 || authOption == 2)) {
                throw new OffAmazonPaymentsServiceException("Invalid Authorization Option.");
            }

            boolean captureNow = false;
            String captureNowString = request.getParameter("DirectCapture");
            if (captureNowString != null && captureNowString.equals("on")) {
                captureNow = true;
            }
            example.authorize(captureNow, authOption, request.getParameter("SoftDescriptor"),
                    request.getParameter("SellerAuthorizationNote"));
            AuthorizationDetails authDetails = this.waitForAuthorizationNotification(captureNow);

            this.getPostAuthDetails();

            if (captureNow) {
                this.printMessage("Authorization with Capture is complete");
                this.printMessage("Now Closing the Order Reference...");
            } else {
                this.printMessage("Authorization for this Order Reference " + "is complete and moved to 'OPEN' state");
                this.printMessage("Now getting details for Capture...");

                this.capture(authDetails, request.getParameter("softDescriptor"),
                        request.getParameter("sellerCaptureNote"));
                this.printMessage("Capture for this Order Reference is complete");
                this.printMessage("Now Closing the Order Reference...");
            }
            example.closeOrder();
            this.printMessage("Order Refernce Moved to CLOSED state.");
            this.printMessage("Simple Checkout Example is complete.");

        } catch (OffAmazonPaymentsServiceException ex) {
            outStream.println("Caught Exception: " + ex.getMessage());
            outStream.println("Response Status Code: " + ex.getStatusCode());
            outStream.println("Error Code: " + ex.getErrorCode());
            outStream.println("Error Type: " + ex.getErrorType());
            outStream.println("Request ID: " + ex.getRequestId());
            outStream.println("XML: " + ex.getXML());
            outStream.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
            ex.printStackTrace(outStream);
        } finally {
            this.printMessage("</pre></div></body></html>");
        }

    }

    /**
     * Method to get the authorization details
     * For countries that charge VAT, additional information about
     * the buyer is available once the auth is completed.
     * 
     * @return void
     * @throws OffAmazonPaymentsServiceException
     */
    private void getPostAuthDetails() throws OffAmazonPaymentsServiceException {
        outStream.println("Requesting auth details");
        GetAuthorizationDetailsResponse authorizationDetails = this.example.getAuthorizationDetails();
        GetAuthorizationDetailsSample.printResponse(authorizationDetails, this.outStream);
    }

    /**
     * Method to check Authorization state
     * If the final state is OPEN, it returns Authorization Details
     * If State is CLOSED and If Capture Now is set to true, it return NULL
     * else throws exception
     * 
     * @return
     * @throws OffAmazonPaymentsServiceException
     */
    private AuthorizationDetails waitForAuthorizationNotification(boolean captureNow)
            throws OffAmazonPaymentsServiceException {
        outStream.println("Waiting for authorization to complete...");
        AuthorizationNotification response = this.example.servletWaitUntilAuthorizationComplete();
        validateResponseNotNull(response, "GetAuthorizationDetailsResponse");
        String authStatus = response.getAuthorizationDetails().getAuthorizationStatus().getState();
        if ((!authStatus.toUpperCase().equals("OPEN"))) {
            if (captureNow && authStatus.toUpperCase().equals("CLOSED")) {
                Utilities.printAuthorizationNotification(response, outStream);
                return null;
            } else {
                throw new OffAmazonPaymentsServiceException("Authorization State is " + authStatus
                        + ". Cannot capture this Authorization");
            }
        } else {
            Utilities.printAuthorizationNotification(response, outStream);
            return response.getAuthorizationDetails();
        }
    }

    /**
     * Method to get capture details and
     * make capture request with provided info from console
     * 
     * @param authDetails
     * @throws OffAmazonPaymentsServiceException
     */
    private void capture(AuthorizationDetails authDetails, String softDescriptor, String sellerCaptureNote)
            throws OffAmazonPaymentsServiceException {
        validateResponseNotNull(authDetails, "AuthorizationDetails");
        String optionalSoftDescriptor = softDescriptor;
        String optionalSellerCaptureNote = sellerCaptureNote;
        CaptureResponse captureResponse = this.example.captureOrderAmount(authDetails.getAuthorizationAmount()
                .getAmount(), authDetails.getAuthorizationAmount().getCurrencyCode(), authDetails
                .getAmazonAuthorizationId(), optionalSoftDescriptor, optionalSellerCaptureNote);
        validateResponseNotNull(captureResponse, "CaptureResponse");
        CaptureSample.printResponse(captureResponse, outStream);
    }
}
