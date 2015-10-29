package com.amazon.payments.lpa.request;

/**
 * Build request for CloseOrderReference API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752000
 */

public class CloseOrderReferenceRequest {
    
    //required parameters
    private String amazonOrderReferenceId;
    
    //optional parameters
    private String closureReason;
    private String mwsAuthToken; 
        
    public CloseOrderReferenceRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }
    
    public CloseOrderReferenceRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }
    
    public CloseOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    public String getClosureReason() {
        return closureReason;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    

}
