
package com.amazon.payments.paywithamazon;

public class TestConstants {
    public static final String billingAgreementId = "CTEST_AMAZON_BILLING_AGREEMENT_ID";
    public static final String billinAgreementIdDraft ="TEST_AMAZON_BILLING_AGREEMENT_ID_DRAFT";
    public static final String addressConsentToken = "TEST_ADDRESS_CONSENT_TOKEN";
    public static final String clientId = "TEST_CLIENT_ID";
    public static final String tokenInfoResponse = "{\"aud\":\"TEST_CLIENT_ID\",\"user_id\":\"amzn1.account.AF5W6J2OG52NKFJGEN52GEZ5CWFQ\",\"iss\":\"https://www.amazon.com\",\"exp\":2370,\"app_id\":\"amzn1.application.5286e3c9cac24d8188908b500f4a05a5\",\"iat\":1446510240}";
    public static final String userProfileErrorResponse = "{\"error_description\":\"The request has an invalid parameter : access_token\",\"error\":\"invalid_token\"}";
    public static final String userInfoResponse = "{\"user_id\":\"amzn1.account.AF5W6J2OG52NKFJGEN52GEZ5CWFQ\",\"name\":\"Test Buyer\",\"email\":\"testbuyer2@amazon.com\"}";
    public static final String merchantId = "TEST_MERCHANT_ID";
    public static final String accessKey = "TEST_ACCESS_KEY";
    public static final String secretKey = "TEST_SECRET_KEY";
    public static final String region = "us";
    public static final String sandbox_mode = "true"; 
    public static final String timeStamp = "2015-00-00T00:00:00Z";
    public static final String urlEncoded_TimeStamp = "2015-00-00T00%3A00%3A00Z";
    public static final String platformId = "A11WKBU7ADWTAU";
    public static final String MWS_URL = "https://mws.amazonservices.com/OffAmazonPayments_Sandbox/2013-01-01";
    public static final String mwsAuthToken = "TEST_MWS_AUTH_TOKEN";
    public static final String sampletext ="testNote";
    public static final String storeName ="TestStore";
    public static final String sellerBillingAgreementId = "TEST_BILLING_AGREEMENT_ID";
    public static final String softDescriptor = "AMZNTestTest";
    public static final String amazonOrderReferenceId = "AMAZON_ORDER_REFERENCE_ID";
    public static final String Endpoint500 = "https://www.example.com/";
    public static final String providerSellerId = "TEST_PROVIDER_SELLER_ID";
    public static final String providerCreditId = "TEST_PROVIDER_CREDIT";
    public static final String reversalProviderCreditId = "TEST_PROVIDER_REVERSAL_CREDIT";
    public static final String reversalProviderCreditReferenceId = "TEST_PROVIDER_REVERSAL_CREDIT_REFERENCE_ID";
    public static final String reversalProviderAmount = "5";
    public static final String creditReferenceReversalId = "TEST_CREDIT_REFERENCE_REVERSAL_ID";
    public static final String authorizationReferenceId = "TEST_AUTHORIZATION_REFERENCE_ID";
    public static final String userProfileURL = "https://api.sandbox.amazon.com/user/profile";
    public static final String tokenInfoURL = "https://api.sandbox.amazon.com/auth/o2/tokeninfo?access_token=";
}