package com.amazon.payments.lpa.request;

/**
 * Build request for CloseOrderReference API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201752640#201752030
 */

public class GetAuthorizationDetailsRequest {
    
    //required parameters
    private String amazonAuthorizationId;
    
    //optional parameters
    private String mwsAuthToken; 
    
    
    public GetAuthorizationDetailsRequest(String amazonAuthorizationId) {
        this.amazonAuthorizationId = amazonAuthorizationId;
    }
  
     /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public GetAuthorizationDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    
    
    
}
