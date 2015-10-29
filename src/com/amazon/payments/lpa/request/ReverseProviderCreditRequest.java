package com.amazon.payments.lpa.request;

public class ReverseProviderCreditRequest {
        
    //required parameters
    private String amazonProviderCreditId;
    private String creditReversalReferenceId;
    private String creditReversalAmount;
    private String creditReversalAmountCurrencyCode;
    private String sellerId;
    
    //optional parameters
    private String creditReversalNote ;
    private String mwsAuthToken;
    
    public ReverseProviderCreditRequest(String amazonProviderCreditId, String creditReversalReferenceId, String sellerId, String creditReversalAmount){
        this.amazonProviderCreditId = amazonProviderCreditId;
        this.creditReversalReferenceId = creditReversalReferenceId;
        this.creditReversalAmount = creditReversalAmount;
        this.sellerId = sellerId;
    }
    
    public ReverseProviderCreditRequest setCurrencyCode(String currencyCode) {
        this.creditReversalAmountCurrencyCode = currencyCode;
        return this;
    }

    public String getCurrencyCode() {
        return creditReversalAmountCurrencyCode;
    }
    
    public ReverseProviderCreditRequest setCreditReversalNote(String creditReversalNote) {
        this.creditReversalNote = creditReversalNote;
        return this;
    }
    
    public ReverseProviderCreditRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonProviderCreditId() {
        return amazonProviderCreditId;
    }

    public String getCreditReversalReferenceId() {
        return creditReversalReferenceId;
    }

    public String getCreditReversalAmount() {
        return creditReversalAmount;
    }

    public String getCreditReversalAmountCurrencyCode() {
        return creditReversalAmountCurrencyCode;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getCreditReversalNote() {
        return creditReversalNote;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    
}
