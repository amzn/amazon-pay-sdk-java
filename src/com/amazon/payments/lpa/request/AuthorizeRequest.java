package com.amazon.payments.lpa.request;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Build request for Authorize API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752010
 */
public class AuthorizeRequest {
        
    //required parameters
    private String amazonOrderReferenceId;
    private String authorizationReferenceId;
    private String authorizationAmount;
    private String authorizationCurrencyCode;
    
    //optonal parameters
    private String sellerAuthorizationNote;
    private String transactionTimeout;
    private String captureNow;
    private String softDescriptor;
    private String mwsAuthToken;
    private List<ProviderCredit> providerCredit;
    
    public AuthorizeRequest(String amazonOrderReferenceId, String authorizationReferenceId, String authorizationAmount) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.authorizationReferenceId = authorizationReferenceId;
        this.authorizationAmount = authorizationAmount;
    }
    
    public AuthorizeRequest setCurrencyCode(String currencyCode) {
        this.authorizationCurrencyCode = currencyCode;
        return this;
    }
    
    public String getCurrencyCode() {
        return authorizationCurrencyCode;
    }
    
    public AuthorizeRequest setSellerAuthorizationNote(String sellerAuthorizationNote){
        this.sellerAuthorizationNote = sellerAuthorizationNote;
        return this;
    }
    

    public AuthorizeRequest setTransactionTimeout(String TransactionTimeout) {
        this.transactionTimeout = TransactionTimeout;
        return this;
    }
    

    public AuthorizeRequest setCaptureNow(String CaptureNow) {
        this.captureNow = CaptureNow;
        return this;
    }

    public AuthorizeRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }

    public AuthorizeRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }
    
    public AuthorizeRequest setProviderCredit(List<ProviderCredit> providerCreditList) {
        this.providerCredit = providerCreditList;
        return this;
    }

    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
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

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    public List<ProviderCredit> getProviderCredit() {
        return providerCredit;
    }
    

    
}
