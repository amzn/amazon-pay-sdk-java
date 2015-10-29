package com.amazon.payments.lpa.request;

/**
 * Build request for CloseAuthorization API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752070
 */

public class CloseAuthorizationRequest {
        
    //required parameters
    private String amazonAuthorizationId;
    
    //optional parameters
    private String closureReason;
    private String mwsAuthToken; 
    
    public CloseAuthorizationRequest(String amazonAuthorizationId) {
        this.amazonAuthorizationId = amazonAuthorizationId;
    }
    
    public CloseAuthorizationRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }

    public CloseAuthorizationRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    public String getClosureReason() {
        return closureReason;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }


}
