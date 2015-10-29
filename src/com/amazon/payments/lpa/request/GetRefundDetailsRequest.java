package com.amazon.payments.lpa.request;

/**
 * https://payments.amazon.com/documentation/apireference/201752640#201752100
 * 
 */
public class GetRefundDetailsRequest {
        
    private String amazonRefundId;
    private String mwsAuthToken;  
    
    public GetRefundDetailsRequest(String amazonRefundId) {
        this.amazonRefundId = amazonRefundId;
    }
    
    /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public GetRefundDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonRefundId() {
        return amazonRefundId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }


    
}
