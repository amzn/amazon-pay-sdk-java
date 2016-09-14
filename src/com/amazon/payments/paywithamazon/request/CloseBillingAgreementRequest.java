package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the CloseBillingAgreement operation.
 *
 * For more information documentation, see
 * https://payments.amazon.com/documentation/
 */
public class CloseBillingAgreementRequest implements Serializable{

    //required parameters
    private String amazonBillingAgreementId;

    //optional parameters
    private String closureReason;
    private String mwsAuthToken;

    /**
     *
     * @param amazonBillingAgreementId
     *              The billing agreement identifier. This value is retrieved 
     *              from the Amazon Button, AddressBook, or Wallet widgets.
     */
    public CloseBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    /**
     * @param closureReason
     *              Describes the reason for closing the billing agreement.
     */
    public CloseBillingAgreementRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }

    /**
     * Applicable for third-party solution providers only. 
     * @param mwsAuthToken
     */
    public CloseBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * The billing agreement identifier. This value is retrieved 
     *              from the Amazon Button, AddressBook, or Wallet widgets.
     * @return AmazonBillingAgreementId specified in request 
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     *
     * @return ClosureResason specified in request
     */
    public String getClosureReason() {
        return closureReason;
    }

    /**
     *
     * @return MWSAuthToken specified in request
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
        return "CloseBillingAgreementRequest{" + "amazonBillingAgreementId=" + amazonBillingAgreementId + ", closureReason="
                + closureReason + ", mwsAuthToken=" + mwsAuthToken + '}';
    }


}
