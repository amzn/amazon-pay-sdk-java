package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the ConfirmBillingAgreement operation.
 *
 * For more information documentation, see
 * https://payments.amazon.com/documentation/
 */
public class ConfirmBillingAgreementRequest implements Serializable{

    //required parameters
    private String amazonBillingAgreementId;

    //optional parameters
    private String mwsAuthToken;

    /**
     *
     * @param amazonBillingAgreementId
     *                  The billing agreement identifier.
     */
    public ConfirmBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    /**
     * Applicable for third-party solution providers only 
     * @param mwsAuthToken
     */
    public ConfirmBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * The billing agreement identifier. 
     *
     * @return Returns AmazonBillingAgreementId from request
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     * Applicable for third-party solution providers only 
     * @return Returns mwsAuthToken from request
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
        return "ConfirmBillingAgreementRequest{" + "amazonBillingAgreementId=" + amazonBillingAgreementId + ", mwsAuthToken=" + mwsAuthToken + '}';
    }


}
