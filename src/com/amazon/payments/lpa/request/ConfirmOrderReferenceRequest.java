package com.amazon.payments.lpa.request;


/**
 * Build request for ConfirmOrderReference API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751980
 */

public class ConfirmOrderReferenceRequest {
    
    //required parameters
    private String amazonOrderReferenceId;
    
    //optional parameters
    private String mwsAuthToken;   

    public ConfirmOrderReferenceRequest(String amazonOrderReferenceId){
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }
    
    public ConfirmOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    

    
}
