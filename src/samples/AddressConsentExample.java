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
package samples;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceClient;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.GetOrderReferenceDetailsRequest;
import com.amazonservices.mws.offamazonpayments.model.GetOrderReferenceDetailsResponse;

public class AddressConsentExample {

	private String amazonOrderReferenceId;
	private OffAmazonPaymentsServiceConfig config;
	private OffAmazonPaymentsServiceClient service;
	private String sellerId;

	public AddressConsentExample(String amazonOrderReferenceId,
			Properties properties, PrintWriter outStream) {
		this.amazonOrderReferenceId = amazonOrderReferenceId;
		this.config = new OffAmazonPaymentsServiceConfig(properties);
		this.service = new OffAmazonPaymentsServiceClient(this.config);
		this.sellerId = this.config.getSellerId();
	}

	public GetOrderReferenceDetailsResponse getOrderReferenceDetails(
			String addressConsentToken)
			throws OffAmazonPaymentsServiceException,
			UnsupportedEncodingException {
		GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest();
		request.setAmazonOrderReferenceId(amazonOrderReferenceId);
		request.setSellerId(sellerId);
		if (addressConsentToken != null) {
			request.setAddressConsentToken(URLDecoder.decode(
					addressConsentToken, "UTF-8"));
		}

		return service.getOrderReferenceDetails(request);
	}

	public void validateOrderReferenceIsInACorrectState(
			GetOrderReferenceDetailsResponse orderReferenceDetailsResponse) {
		GetOrderReferenceDetailsSample.validateOrderReferenceIsInACorrectState(
				orderReferenceDetailsResponse
						.getGetOrderReferenceDetailsResult()
						.getOrderReferenceDetails(), "DRAFT");
	}

	public void printOrderReferenceResponse(
			GetOrderReferenceDetailsResponse orderReferenceDetailsResponse,
			PrintWriter outStream) {
		GetOrderReferenceDetailsSample.printResponse(orderReferenceDetailsResponse, outStream);
	}

}
