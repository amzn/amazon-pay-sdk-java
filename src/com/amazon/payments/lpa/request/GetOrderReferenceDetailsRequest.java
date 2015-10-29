package com.amazon.payments.lpa.request;

import java.net.URLDecoder;

public class GetOrderReferenceDetailsRequest {
        
    private String amazonOrderReferenceId;
    private String addressConsentToken;
    private String mwsAuthToken;   
    
    public GetOrderReferenceDetailsRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }
    
    public GetOrderReferenceDetailsRequest setAddressConsentToken( String addressConsentToken ) {
        this.addressConsentToken = URLDecoder.decode(addressConsentToken);
        return this;
    }
    
    public String getAddressConsentToken() {
        return this.addressConsentToken;
    }
    
    /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public GetOrderReferenceDetailsRequest setMWSAuthToken(String mwsAuthToken) {
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
