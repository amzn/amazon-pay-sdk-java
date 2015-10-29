package com.amazon.payments.lpa.request;

/**
 * Build request forValidateBillingAgreement API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751720
 */
public class ValidateBillingAgreementRequest {
   
    //required parameters
    private String amazonBillingAgreementId;
    
    //optional parameters
    private String mwsAuthToken;
    
    public ValidateBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    public ValidateBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    
}
