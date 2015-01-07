/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import samples.utils.Utilities;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceClient;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.AuthorizeOnBillingAgreementRequest;
import com.amazonservices.mws.offamazonpayments.model.AuthorizeOnBillingAgreementResponse;
import com.amazonservices.mws.offamazonpayments.model.BillingAgreementAttributes;
import com.amazonservices.mws.offamazonpayments.model.BillingAgreementDetails;
import com.amazonservices.mws.offamazonpayments.model.CloseBillingAgreementRequest;
import com.amazonservices.mws.offamazonpayments.model.CloseBillingAgreementResponse;
import com.amazonservices.mws.offamazonpayments.model.ConfirmBillingAgreementRequest;
import com.amazonservices.mws.offamazonpayments.model.ConfirmBillingAgreementResponse;
import com.amazonservices.mws.offamazonpayments.model.GetBillingAgreementDetailsRequest;
import com.amazonservices.mws.offamazonpayments.model.GetBillingAgreementDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.Price;
import com.amazonservices.mws.offamazonpayments.model.SellerBillingAgreementAttributes;
import com.amazonservices.mws.offamazonpayments.model.SetBillingAgreementDetailsRequest;
import com.amazonservices.mws.offamazonpayments.model.SetBillingAgreementDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.ValidateBillingAgreementRequest;
import com.amazonservices.mws.offamazonpayments.model.ValidateBillingAgreementResponse;

/**
 * Automatic payment simple checkout example
 * 
 * This demonstrates a merchant use case where the item is in stock, and
 * the billing agreement creation is immediately followed by the order
 * confirmation and capture of funds for the merchant
 * 
 * This use case makes the assumption that the merchant is using the billing
 * agreement address capture widget to capture the destination address for the
 * order, and uses the address information to calculate a tax and shipping rate
 * 
 * This example will show the following service calls:
 * - GetBillingAgreementDetails
 * - SetBillingAgreementDetails
 * - ConfirmBillingAgreement
 * - AuthorizeOnBillingAgreement
 * - GetAuthorizeDetails
 * - Capture
 * - GetCaptureDetails
 * - CloseBillingAgreement
 */
public class AutomaticPaymentSimpleCheckoutExample extends CheckoutExampleBase {

    private String amazonBillingAgreementId = null;

    public AutomaticPaymentSimpleCheckoutExample(String amazonBillingAgreementId,
            OffAmazonPaymentsServiceConfig config, OffAmazonPaymentsServiceClient service, PrintWriter outStream) {
        super(config, service, outStream);
        this.amazonBillingAgreementId = amazonBillingAgreementId.trim();
        outStream.println("Billing Agreement Id: " + this.amazonBillingAgreementId);
        outStream.println("Seller Id: " + this.sellerId);
    }

    /**
     * Method to make get billing agreement details, use this method to
     * determine buyer's shipping address detail
     * 
     * @return BillingAgreementDetails
     * @throws OffAmazonPaymentsServiceException
     */
    public BillingAgreementDetails getBillingAgreementDetails() throws OffAmazonPaymentsServiceException {
        GetBillingAgreementDetailsRequest request = new GetBillingAgreementDetailsRequest();
        request.setAmazonBillingAgreementId(this.amazonBillingAgreementId);
        request.setSellerId(this.sellerId);
        GetBillingAgreementDetailsResponse response = this.service.getBillingAgreementDetails(request);
        return response.getGetBillingAgreementDetailsResult().getBillingAgreementDetails();
    }

    /**
     * Method to set seller details to the Billing Agreement
     * 
     * @param optionalSellerNote
     * @param optionalSellerBillingAgreementAttributes
     * @throws OffAmazonPaymentsServiceException
     */
    public void setBillingAgreementDetails(String sellerBillingAgreementId, String customInformation, String storeName,
            String sellerNote) throws OffAmazonPaymentsServiceException {
        /*
         * Set SellerBillingAgreementAttributes, this is optional parameter
         */
        SellerBillingAgreementAttributes sellerBillingAgreementAttributes = new SellerBillingAgreementAttributes();
        if (sellerBillingAgreementId != null && !sellerBillingAgreementId.equals("")) {
            sellerBillingAgreementAttributes.setSellerBillingAgreementId(sellerBillingAgreementId);
        }
        if (customInformation != null && !customInformation.equals("")) {
            sellerBillingAgreementAttributes.setCustomInformation(customInformation);
        }
        if (storeName != null && !storeName.equals("")) {
            sellerBillingAgreementAttributes.setStoreName(storeName);
        }

        /*
         * Use BillingAgreementAttributes to set sellerNote and
         * sellerBillingAgreementAttributes, they are optional parameters
         */
        BillingAgreementAttributes billingAgreementAttributes = new BillingAgreementAttributes();
        if (sellerNote != null) {
            billingAgreementAttributes.setSellerNote(sellerNote);
        }
        if (sellerBillingAgreementAttributes != null) {
            billingAgreementAttributes.setSellerBillingAgreementAttributes(sellerBillingAgreementAttributes);
        }

        SetBillingAgreementDetailsRequest request = new SetBillingAgreementDetailsRequest();
        request.setAmazonBillingAgreementId(this.amazonBillingAgreementId);
        request.setSellerId(this.sellerId);
        request.setBillingAgreementAttributes(billingAgreementAttributes);

        SetBillingAgreementDetailsResponse response = this.service.setBillingAgreementDetails(request);

        Utilities.validateResponseNotNull(response, "SetBillingAgreementDetailsResponse");
        SetBillingAgreementDetailsSample.printResponse(response, outStream);

    }

    /**
     * Method to confirm a Billing Agreement
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void confirmBillingAgreement() throws OffAmazonPaymentsServiceException {
        ConfirmBillingAgreementRequest request = new ConfirmBillingAgreementRequest();
        request.setAmazonBillingAgreementId(this.amazonBillingAgreementId);
        request.setSellerId(this.sellerId);

        ConfirmBillingAgreementResponse response = this.service.confirmBillingAgreement(request);
        Utilities.validateResponseNotNull(response, "ConfirmBillingAgreementResponse");
        ConfirmBillingAgreementSample.printResponse(response, outStream);
    }

    /**
     * Method to validate a Billing Agreement
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void validateBillingAgreement() throws OffAmazonPaymentsServiceException {
        ValidateBillingAgreementRequest request = new ValidateBillingAgreementRequest();
        request.setAmazonBillingAgreementId(this.amazonBillingAgreementId);
        request.setSellerId(this.sellerId);

        ValidateBillingAgreementResponse response = this.service.validateBillingAgreement(request);
        Utilities.validateResponseNotNull(response, "ValidateBillingAgreementResponse");
        ValidateBillingAgreementSample.printResponse(response, outStream);
    }

    /**
     * Method to get required and optional parameters
     * for authorization on a Billing Agreement and makes request call
     * 
     * @param authAmount
     * @param authReferenceId
     * @param captureNow
     * @param softDescriptor
     * @param sellerAuthorizationNote
     * @return amazonAuthorizationId
     * @throws OffAmazonPaymentsServiceException
     */
    public String authorizeOnBillingAgreement(double authAmount, String authReferenceId, boolean captureNow,
            String softDescriptor, String sellerAuthorizationNote) throws OffAmazonPaymentsServiceException {
        AuthorizeOnBillingAgreementRequest request = new AuthorizeOnBillingAgreementRequest();

        Price authTotal = new Price();
        authTotal.setAmount(Double.valueOf(authAmount).toString());
        authTotal.setCurrencyCode(config.getCurrencyCode());

        request.setAuthorizationAmount(authTotal);
        request.setAmazonBillingAgreementId(this.amazonBillingAgreementId);
        request.setSellerId(this.sellerId);
        request.setAuthorizationReferenceId(authReferenceId);

        /*
         * Optional Parameters
         * Note: Soft Descriptor can be set to Authorization request
         * Only if captureNow flag is turned on
         */
        if (captureNow && softDescriptor != null) {
            request.setSoftDescriptor(softDescriptor);
        }
        request.setCaptureNow(new Boolean(captureNow));
        if (sellerAuthorizationNote != null) {
            request.setSellerAuthorizationNote(sellerAuthorizationNote);
        }

        AuthorizeOnBillingAgreementResponse response = this.service.authorizeOnBillingAgreement(request);

        Utilities.validateResponseNotNull(response, "AuthorizeOnBillingAgreementResponse");
        AuthorizeOnBillingAgreementSample.printResponse(response, outStream);
        return response.getAuthorizeOnBillingAgreementResult().getAuthorizationDetails().getAmazonAuthorizationId();
    }

    /**
     * Method to Close a Billing Agreement
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void closeBillingAgreement() throws OffAmazonPaymentsServiceException {
        CloseBillingAgreementRequest request = new CloseBillingAgreementRequest();
        request.setSellerId(this.sellerId);
        request.setAmazonBillingAgreementId(this.amazonBillingAgreementId);

        CloseBillingAgreementResponse response = this.service.closeBillingAgreement(request);
        Utilities.validateResponseNotNull(response, "CloseBillingAgreementResponse");
        CloseBillingAgreementSample.printResponse(response, outStream);
    }

}
