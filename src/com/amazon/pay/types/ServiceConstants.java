/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.types;

import com.amazon.pay.types.Region;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServiceConstants {

    public static final Map<Region, String> mwsEndpointMappings;
    public static final Map<Region, String> profileEndpointMappings;
    public static final Map<Region, String> profileEndpointSandboxMappings;

    // API Request Parameters
    public static final String ADDRESS_CONSENT_TOKEN = "AddressConsentToken";
    public static final String ACCESS_TOKEN = "AccessToken";
    public static final String AMAZON_AUTHORIZATION_ID = "AmazonAuthorizationId";
    public static final String AMAZON_AUTHORIZATION_REFERENCE_ID = "AuthorizationReferenceId";
    public static final String AMAZON_BILLING_AGREEMENT_ID = "AmazonBillingAgreementId";
    public static final String AMAZON_CAPTURE_ID = "AmazonCaptureId";
    public static final String AMAZON_ORDER_REFERENCE_ID = "AmazonOrderReferenceId";
    public static final String AMAZON_PROVIDER_CREDIT_ID = "AmazonProviderCreditId";
    public static final String AMAZON_PROVIDER_CREDIT_REVERSAL_ID = "AmazonProviderCreditReversalId";
    public static final String AMAZON_REFUND_ID = "AmazonRefundId";
    public static final String AUTHORIZATION_AMOUNT = "AuthorizationAmount.Amount";
    public static final String AUTHORIZATION_CURRENCEYCODE = "AuthorizationAmount.CurrencyCode";
    public static final String AUTHORIZATION_REFERENCE_ID = "AuthorizationReferenceId";
    public static final String BA_CUSTOM_INFORMATION = "SellerOrderAttributes.CustomInformation";
    public static final String BA_SELLER_ORDER_ID = "SellerOrderAttributes.SellerOrderId";
    public static final String BA_STORE_NAME = "SellerOrderAttributes.StoreName";
    public static final String BILLING_AGREEMENT_PLATFORM_ID = "BillingAgreementAttributes.PlatformId";
    public static final String BILLING_AGREEMENT_SELLER_BILLING_AGREEMENT_ID = "BillingAgreementAttributes.SellerBillingAgreementAttributes.SellerBillingAgreementId";
    public static final String BILLING_AGREEMENT_SELLER_CUSTOM_INFORMATION = "BillingAgreementAttributes.SellerBillingAgreementAttributes.CustomInformation";
    public static final String BILLING_AGREEMENT_SELLER_NOTE = "BillingAgreementAttributes.SellerNote";
    public static final String BILLING_AGREEMENT_SELLER_STORE_NAME = "BillingAgreementAttributes.SellerBillingAgreementAttributes.StoreName";
    public static final String CANCELATION_REASON = "CancelationReason";
    public static final String CAPTURE_AMOUNT = "CaptureAmount.Amount";
    public static final String CAPTURE_CURRENCEYCODE = "CaptureAmount.CurrencyCode";
    public static final String CAPTURE_NOTE = "SellerCaptureNote";
    public static final String CAPTURE_NOW = "CaptureNow";
    public static final String CAPTURE_REFERENCE_ID = "CaptureReferenceId";
    public static final String CLOSURE_REASON = "ClosureReason";
    public static final String CONFIRM_NOW = "ConfirmNow";
    public static final String CREDIT_REVERSAL_AMOUNT = "CreditReversalAmount.Amount";
    public static final String CREDIT_REVERSAL_AMOUNT_CURRENCY_CODE = "CreditReversalAmount.CurrencyCode";
    public static final String CREDIT_REVERSAL_NOTE = "CreditReversalNote";
    public static final String CREDIT_REVERSAL_REFERENCE_ID = "CreditReversalReferenceId";
    public static final String CUSTOM_INFORMATION = "OrderReferenceAttributes.SellerOrderAttributes.CustomInformation";
    public static final String ID = "Id";
    public static final String ID_TYPE = "IdType";
    public static final String INHERIT_SHIPPING_ADDRESS = "InheritShippingAddress";
    public static final String ORDER_AMOUNT = "OrderReferenceAttributes.OrderTotal.Amount";
    public static final String ORDER_CURRENCY_CODE = "OrderReferenceAttributes.OrderTotal.CurrencyCode";
    public static final String PLATFORM_ID = "OrderReferenceAttributes.PlatformId";
    public static final String REFUND_AMOUNT = "RefundAmount.Amount";
    public static final String REFUND_AMOUNT_CURRENCY_CODE = "RefundAmount.CurrencyCode";
    public static final String REFUND_REFERENCE_ID = "RefundReferenceId";
    public static final String SELLER_AUTHORIZATION_NOTE = "SellerAuthorizationNote";
    public static final String SELLER_NOTE = "OrderReferenceAttributes.SellerNote";
    public static final String SELLER_ORDER_ID = "OrderReferenceAttributes.SellerOrderAttributes.SellerOrderId";
    public static final String SELLER_REFUND_NOTE = "SellerRefundNote";
    public static final String SOFT_DESCRIPTOR = "SoftDescriptor";
    public static final String STORE_NAME = "OrderReferenceAttributes.SellerOrderAttributes.StoreName";
    public static final String TRANSACTION_TIMEOUT = "TransactionTimeout";

    // API Request Parameters - (Mostly) Required Parameters
    public static final String ACTION = "Action";
    public static final String AMAZON_PAY_API_VERSION = "2013-01-01";
    public static final String AWSACCESSKEYID = "AWSAccessKeyId";
    public static final String MWS_AUTH_TOKEN = "MWSAuthToken";
    public static final String SELLER_ID = "SellerId";
    public static final String SIGNATURE = "Signature";
    public static final String SIGNATUREMETHOD = "SignatureMethod";
    public static final String SIGNATUREVERSION = "SignatureVersion";
    public static final String TIMESTAMP = "Timestamp";
    public static final String VERSION = "Version";

    // API Actions - Consider moving these to enum class in future
    public static final String AUTHORIZE = "Authorize";
    public static final String AUTHORIZE_BILLING_AGREEMENT_DETAILS = "AuthorizeOnBillingAgreement";
    public static final String CANCEL_ORDER_REFERENCE = "CancelOrderReference";
    public static final String CAPTURE = "Capture";
    public static final String CLOSE_AUTHORIZATION = "CloseAuthorization";
    public static final String CLOSE_BILLING_AGREEMENT_DETAILS = "CloseBillingAgreement";
    public static final String CLOSE_ORDER_REFERENCE = "CloseOrderReference";
    public static final String CONFIRM_BILLING_AGREEMENT_DETAILS = "ConfirmBillingAgreement";
    public static final String CONFIRM_ORDER_REFERENCE = "ConfirmOrderReference";
    public static final String CREATE_ORDER_REFERENCE_FOR_ID = "CreateOrderReferenceForId";
    public static final String GET_AUTHORIZATION_DETAILS = "GetAuthorizationDetails";
    public static final String GET_BILLING_AGREEMENT_DETAILS = "GetBillingAgreementDetails";
    public static final String GET_CAPTURE_DETAILS = "GetCaptureDetails";
    public static final String GET_ORDER_REFERENCE_DETAILS = "GetOrderReferenceDetails";
    public static final String GET_PROVIDER_CREDIT_DETAILS = "GetProviderCreditDetails";
    public static final String GET_REFUND_DETAILS = "GetRefundDetails";
    public static final String GET_REVERSE_PROVIDER_CREDIT_DETAILS = "GetProviderCreditReversalDetails";
    public static final String GET_SERVICE_STATUS = "GetServiceStatus";
    public static final String REFUND = "Refund";
    public static final String REVERSE_PROVIDER_CREDIT_DETAILS = "ReverseProviderCredit";
    public static final String SET_BILLING_AGREEMENT_DETAILS = "SetBillingAgreementDetails";
    public static final String SET_ORDER_REFERENCE_DETAILS = "SetOrderReferenceDetails";
    public static final String VALIDATE_BILLING_AGREEMENT_DETAILS = "ValidateBillingAgreement";

    // SDK version
    public static final String APPLICATION_LIBRARY_VERSION = "3.1.0";
    public static final String GITHUB_SDK_NAME = "amazon-pay-sdk-java";

    // Exponential backoff wait times (milliseconds) for retry operations
    public static final int FIRST_RETRY_WAIT_TIME = 1000;
    public static final int SECOND_RETRY_WAIT_TIME = 4000;
    public static final int THIRD_RETRY_WAIT_TIME = 10000;

    static {
        Map<Region, String> mwsEndpointMappingsMap = new HashMap<Region,String>();
        mwsEndpointMappingsMap.put(Region.UK, "https://mws-eu.amazonservices.com");
        mwsEndpointMappingsMap.put(Region.DE, "https://mws-eu.amazonservices.com");
        mwsEndpointMappingsMap.put(Region.US, "https://mws.amazonservices.com");
        mwsEndpointMappingsMap.put(Region.JP, "https://mws.amazonservices.jp");
        mwsEndpointMappings = Collections.unmodifiableMap(mwsEndpointMappingsMap);

        Map<Region, String> profileEndpointMappingsMap = new HashMap<Region,String>();
        profileEndpointMappingsMap.put(Region.UK, "https://api.amazon.co.uk");
        profileEndpointMappingsMap.put(Region.US, "https://api.amazon.com");
        profileEndpointMappingsMap.put(Region.DE, "https://api.amazon.de");
        profileEndpointMappingsMap.put(Region.JP, "https://api.amazon.co.jp");
        profileEndpointMappings = Collections.unmodifiableMap(profileEndpointMappingsMap);

        Map<Region, String> profileEndpointSandboxMappingsMap = new HashMap<Region,String>();
        profileEndpointSandboxMappingsMap.put(Region.UK, "https://api.sandbox.amazon.co.uk");
        profileEndpointSandboxMappingsMap.put(Region.US, "https://api.sandbox.amazon.com");
        profileEndpointSandboxMappingsMap.put(Region.DE, "https://api.sandbox.amazon.de");
        profileEndpointSandboxMappingsMap.put(Region.JP, "https://api.sandbox.amazon.co.jp");
        profileEndpointSandboxMappings = Collections.unmodifiableMap(profileEndpointSandboxMappingsMap);
    }

}
