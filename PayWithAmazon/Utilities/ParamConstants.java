/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Utilities;

/**
 *
 * @author nehaa
 */
public class ParamConstants {
        
    public static final String AMAZON_ORDER_REFERENCE_ID = "AmazonOrderReferenceId";
    public static final String AMAZON_AUTHORIZATION_REFERENCE_ID = "AuthorizationReferenceId";
    public static final String AMAZON_AUTHORIZATION_ID = "AmazonAuthorizationId";
    public static final String AUTHORIZATION_REFERENCE_ID = "AuthorizationReferenceId";
    public static final String AMAZON_CAPTURE_ID = "AmazonCaptureId";
    public static final String AMAZON_REFUND_ID = "AmazonRefundId";
    public static final String REFUND_REFERENCE_ID = "RefundReferenceId";
    public static final String REFUND_AMOUNT = "RefundAmount.Amount";
    public static final String REFUND_AMOUNT_CURRENCY_CODE = "RefundAmount.CurrencyCode";  
    public static final String SELLER_REFUND_NOTE = "SellerRefundNote";
    public static final String AMAZON_BILLING_AGREEMENT_ID = "AmazonBillingAgreementId";
    public static final String BILLING_AGREEMENT_PLATFORM_ID = "BillingAgreementAttributes.PlatformId";
    public static final String BILLING_AGREEMENT_SELLER_NOTE = "BillingAgreementAttributes.SellerNote";
    public static final String BILLING_AGREEMENT_SELLER_BILLING_AGREEMENT_ID = "BillingAgreementAttributes.SellerBillingAgreementAttributes.SellerBillingAgreementId";
    public static final String BILLING_AGREEMENT_SELLER_STORE_NAME = "BillingAgreementAttributes.SellerBillingAgreementAttributes.StoreName";
    public static final String BILLING_AGREEMENT_SELLER_CUSTOM_INFORMATION = "BillingAgreementAttributes.SellerBillingAgreementAttributes.CustomInformation";

    public static final String AUTHORIZATION_AMOUNT = "AuthorizationAmount.Amount";
    public static final String AUTHORIZATION_CURRENCEYCODE = "AuthorizationAmount.CurrencyCode";
    public static final String CAPTURE_NOW = "CaptureNow";
    public static final String CAPTURE_NOTE = "CaptureNote";
    public static final String CAPTURE_AMOUNT = "CaptureAmount.Amount";
    public static final String CAPTURE_CURRENCEYCODE = "CaptureAmount.CurrencyCode"; 
    public static final String CAPTURE_REFERENCE_ID = "CaptureReferenceId";

    public static final String SELLER_AUTHORIZATION_NOTE = "SellerAuthorizationNote";
    public static final String TRANSACTION_TIMEOUT = "TransactionTimeout";
    public static final String SOFT_DESCRIPTOR = "SoftDescriptor";
    public static final String ADDRESS_CONSENT_TOKEN = "AddressConsentToken";
    public static final String CANCELATION_REASON = "CancelationReason";
    public static final String CLOSURE_REASON = "ClosureReason";
    public static final String INHERIT_SHIPPING_ADDRESS = "InheritShippingAddress";

    public static final String MWS_AUTH_TOKEN = "mwsAuthToken";
    public static final String ORDER_AMOUNT = "OrderReferenceAttributes.OrderTotal.Amount";
    public static final String ORDER_CURRENCY_CODE = "OrderReferenceAttributes.OrderTotal.CurrencyCode";

    public static final String CURRENCY_CODE = "OrderReferenceAttributes.OrderTotal.CurrencyCode";
    public static final String PLATFORM_ID = "OrderReferenceAttributes.PlatformId";
    public static final String SELLER_NOTE = "OrderReferenceAttributes.SellerNote";
    public static final String SELLER_ORDER_ID = "OrderReferenceAttributes.SellerOrderAttributes.SellerOrderId";
    public static final String STORE_NAME = "OrderReferenceAttributes.SellerOrderAttributes.StoreName";
    public static final String CUSTOM_INFORMATION = "OrderReferenceAttributes.SellerOrderAttributes.CustomInformation";
    
    public static final String AMAZON_PROVIDER_CREDIT_ID = "AmazonProviderCreditId";
    public static final String CREDIT_REVERSAL_REFERENCE_ID = "CreditReversalReferenceId";
    public static final String CREDIT_REVERSAL_AMOUNT = "CreditReversalAmount.Amount";
    public static final String CREDIT_REVERSAL_AMOUNT_CURRENCY_CODE = "CreditReversalAmount.CurrencyCode";
    public static final String CREDIT_REVERSAL_NOTE = "CreditReversalNote";
    
    public static final String AMAZON_PROVIDER_CREDIT_REVERSAL_ID = "AmazonProviderCreditReversalId";
    public static final String AMAZON_PAYMENTS_API_VERSION = "2013-01-01";
}
