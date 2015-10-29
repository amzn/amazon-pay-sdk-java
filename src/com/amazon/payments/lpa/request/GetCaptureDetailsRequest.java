package com.amazon.payments.lpa.request;



/**
 * https://payments.amazon.com/documentation/apireference/201752640#201752060
 * @author nehaa
 */
public class GetCaptureDetailsRequest {
        
    private String amazonCaptureId;
    private String mwsAuthToken;   
    
    public GetCaptureDetailsRequest(String amazonCaptureId) {
        this.amazonCaptureId = amazonCaptureId;
    }
    
     /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public GetCaptureDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonCaptureId() {
        return amazonCaptureId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    

    
}
