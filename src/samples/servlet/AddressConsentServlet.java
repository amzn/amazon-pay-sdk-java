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
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.GetOrderReferenceDetailsResponse;

import samples.AddressConsentExample;
import samples.utils.PropertyBundle;

/**
 * Execute the service call to show the usage of the address consent token
 * 
 * This example is for US based customers of Login and Pay with Amazon.
 * 
 */
public class AddressConsentServlet extends IpnExampleServletBase {

	private static final long serialVersionUID = 1L;
	AddressConsentExample example = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		outStream = response.getWriter();
		String amazonOrderReferenceId = request
				.getParameter("OrderReferenceId");
		example = new AddressConsentExample(amazonOrderReferenceId,
				PropertyBundle.getProperties(), outStream);
		runSample(request);
	}

	/**
	 * Run the example by making requests for order reference details with and
	 * without the address consent token
	 * 
	 * @param request
	 * @throws UnsupportedEncodingException 
	 */
	private void runSample(HttpServletRequest request) throws UnsupportedEncodingException {
		try {
			this.printMessage("<html><head><title>Address consent result</title></head><body>");
			GetOrderReferenceDetailsResponse orderReferenceDetailsWithoutAddressConsent = getOrderReferenceDetailsWithoutAddressConsent(request);
			validateOrderReferenceIsInACorrectState(orderReferenceDetailsWithoutAddressConsent);

			GetOrderReferenceDetailsResponse orderReferenceDetailsWithAddressConsent = getOrderReferenceDetailsWithAddressConsent(request);

			printOrderReferenceResponses(
					orderReferenceDetailsWithoutAddressConsent,
					orderReferenceDetailsWithAddressConsent);

		} catch (OffAmazonPaymentsServiceException ex) {
			outStream.println("Caught Exception: " + ex.getMessage());
			outStream.println("Response Status Code: " + ex.getStatusCode());
			outStream.println("Error Code: " + ex.getErrorCode());
			outStream.println("Error Type: " + ex.getErrorType());
			outStream.println("Request ID: " + ex.getRequestId());
			outStream.println("XML: " + ex.getXML());
			outStream.println("ResponseHeaderMetadata: "
					+ ex.getResponseHeaderMetadata());
			ex.printStackTrace(outStream);
		} finally {
			this.printMessage("</body></html>");
		}
	}

	private GetOrderReferenceDetailsResponse getOrderReferenceDetailsWithoutAddressConsent(
			HttpServletRequest request)
			throws OffAmazonPaymentsServiceException, UnsupportedEncodingException {
		return example.getOrderReferenceDetails(null);
	}

	private void validateOrderReferenceIsInACorrectState(
			GetOrderReferenceDetailsResponse orderReferenceDetailsResponse)
			throws OffAmazonPaymentsServiceException {
		example.validateOrderReferenceIsInACorrectState(orderReferenceDetailsResponse);
	}

	private GetOrderReferenceDetailsResponse getOrderReferenceDetailsWithAddressConsent(
			HttpServletRequest request) throws OffAmazonPaymentsServiceException, UnsupportedEncodingException {
		return example.getOrderReferenceDetails(request
				.getParameter("AccessToken"));
	}

	private void printOrderReferenceResponses(
			GetOrderReferenceDetailsResponse orderReferenceDetailsWithoutAddressConsent,
			GetOrderReferenceDetailsResponse orderReferenceDetailsWithAddressConsent) {
		this.printMessage("<div style=\"width:100%\">");
		this.printMessage("<div style=\"float:left; width:45%\">");
		this.printMessage("<div style=\"font-weight:bold\">GetOrderReferenceDetails result without address consent token</div>");
		this.printMessage("<div>");
		this.printMessage("<pre>");
		this.example.printOrderReferenceResponse(orderReferenceDetailsWithoutAddressConsent, outStream);
		this.printMessage("</pre>");
		this.printMessage("</div>");
		this.printMessage("</div>");
		this.printMessage("<div style=\"float:right; width:45%; border-left:dashed; padding-left:1%\">");
		this.printMessage("<div style=\"font-weight:bold\">GetOrderReferenceDetails result with address consent token</div>");
		this.printMessage("<div>");
		this.printMessage("<pre>");
		this.example.printOrderReferenceResponse(orderReferenceDetailsWithAddressConsent, outStream);
		this.printMessage("</pre>");
		this.printMessage("</div>");
		this.printMessage("</div>");
		this.printMessage("</div>");
	}
}
