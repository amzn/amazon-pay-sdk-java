package com.amazon.payments.lpa.request;

import java.net.URLDecoder;


/**
 * Build request for GetBillingAgreementDetails API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751690
 */

public class GetBillingAgreementDetailsRequest {
    
    //required parameters
    private String amazonBillingAgreementId;
    
    //optional parameters
    private String addressConsentToken;
    private String mwsAuthToken;
        
    public GetBillingAgreementDetailsRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    public GetBillingAgreementDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

        
    public GetBillingAgreementDetailsRequest setAddressConsentToken(String addressConsentToken) {
        this.addressConsentToken = URLDecoder.decode(addressConsentToken);
        return this;
    }

    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    public String getAddressConsentToken() {
        return addressConsentToken;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    
    
}
