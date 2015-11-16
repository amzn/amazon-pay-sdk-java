package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the {@link com.amazon.payments.lpa.Client#validateBillingAgreement(ValidateBillingAgreementRequest) ValidateBillingAgreement operation}.
 * For more information documentation, see  
 * <a href="https://payments.amazon.com/documentation/"> API Reference</a>
 */
public class ValidateBillingAgreementRequest implements Serializable{
   
    //required parameters
    private String amazonBillingAgreementId;
    
    //optional parameters
    private String mwsAuthToken;
    
    /**
     * 
     * @param amazonBillingAgreementId The billing agreement identifier. 
     * This value is retrieved from the Amazon Button, AddressBook, or Wallet widgets.
     */
    public ValidateBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    /**
     * 
     * @param mwsAuthToken
     */
    public ValidateBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * 
     * @return AmazonBillingAgreementId
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     * 
     * @return MWSAuthToken
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ValidateBillingAgreementRequest{" + "amazonBillingAgreementId=" + amazonBillingAgreementId + ", mwsAuthToken=" + mwsAuthToken + '}';
    }

    
}
