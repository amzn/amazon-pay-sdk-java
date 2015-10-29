package com.amazon.payments.lpa.request;

public class GetProviderCreditReversalDetailsRequest {
    
    //required parameters
    private String amazonProviderCreditReversalId;
    private String sellerId;
    
    //optional parameters
    private String mwsAuthToken;
    
    public GetProviderCreditReversalDetailsRequest(String amazonProviderCreditReversalId , String sellerId) {
        this.amazonProviderCreditReversalId = amazonProviderCreditReversalId;
        this.sellerId = sellerId;
    }

    public GetProviderCreditReversalDetailsRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonProviderCreditReversalId() {
        return amazonProviderCreditReversalId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
            

}
