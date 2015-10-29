package com.amazon.payments.lpa.request;

public class GetProviderCreditDetailsRequest {
        
    //required parameters
    private String amazonProviderCreditId;
    private String sellerId;
    
    //optional parameters
    private String mwsAuthToken;

    public GetProviderCreditDetailsRequest(String amazonProviderCreditId , String sellerId) {
        this.amazonProviderCreditId = amazonProviderCreditId;
        this.sellerId = sellerId;
    }

    public GetProviderCreditDetailsRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonProviderCreditId() {
        return amazonProviderCreditId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    
    
}
