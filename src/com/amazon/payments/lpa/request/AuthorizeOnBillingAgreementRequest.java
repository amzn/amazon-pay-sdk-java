package com.amazon.payments.lpa.request;

/**
 * Build request for AuthorizeOnBillingAgreement API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751940
 */

public class AuthorizeOnBillingAgreementRequest {
        
    //required parameters
    private String amazonBillingAgreementId;
    private String authorizationReferenceId;
    private String authorizationAmount;
    private String authorizationCurrencyCode;
    
    //optional parameters
    private String sellerAuthorizationNote;
    private String transactionTimeout;
    private String captureNow;
    private String softDescriptor;
    private String platformId;
    private String sellerNote;
    private String InheritShippingAddress;

    
    private String sellerOrderId;
    private String storeName;
    private String customInformation;
    private String mwsAuthToken;

    public AuthorizeOnBillingAgreementRequest(String amazonBillingAgreementId, String authorizationReferenceId, String authorizationAmount) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        this.authorizationReferenceId = authorizationReferenceId;
        this.authorizationAmount = authorizationAmount;
    }

    public String getCurrencyCode() {
        return authorizationCurrencyCode;
    }
    
    public AuthorizeOnBillingAgreementRequest setCurrencyCode(String authorizationCurrencyCode){
        this.authorizationCurrencyCode = authorizationCurrencyCode;
        return this;

    }
    public AuthorizeOnBillingAgreementRequest setSellerAuthorizationNote(String sellerAuthorizationNote){
        this.sellerAuthorizationNote = sellerAuthorizationNote;
        return this;

    }
    
    public AuthorizeOnBillingAgreementRequest setTransactionTimeout(String TransactionTimeout) {
        this.transactionTimeout = TransactionTimeout;
        return this;

    }
    
    
    public AuthorizeOnBillingAgreementRequest setCaptureNow(String CaptureNow) {
        this.captureNow = CaptureNow;
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }
    
    public AuthorizeOnBillingAgreementRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }
    
    public AuthorizeOnBillingAgreementRequest setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }
    
    public AuthorizeOnBillingAgreementRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setInheritShippingAddress(String InheritShippingAddress) {
        this.InheritShippingAddress = InheritShippingAddress;
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    public String getAuthorizationReferenceId() {
        return authorizationReferenceId;
    }

    public String getAuthorizationAmount() {
        return authorizationAmount;
    }

    public String getAuthorizationCurrencyCode() {
        return authorizationCurrencyCode;
    }

    public String getSellerAuthorizationNote() {
        return sellerAuthorizationNote;
    }

    public String getTransactionTimeout() {
        return transactionTimeout;
    }

    public String getCaptureNow() {
        return captureNow;
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public String getInheritShippingAddress() {
        return InheritShippingAddress;
    }

    public String getSellerOrderId() {
        return sellerOrderId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getCustomInformation() {
        return customInformation;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    
}
