package com.amazon.payments.lpa.request;

/**
 * Build request for CancelOrderReference API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751990
 */
public class CancelOrderReferenceRequest {
        
    //required parameters
    private String amazonOrderReferenceId;
    
    //optional parameters
    private String cancelationReason;
    private String mwsAuthToken;
    
    public CancelOrderReferenceRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }
    
    public CancelOrderReferenceRequest setCancelReason(String cancelationReason) {
        this.cancelationReason = cancelationReason;
        return this;
    }
 
    public CancelOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    public String getCancelationReason() {
        return cancelationReason;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    
}
