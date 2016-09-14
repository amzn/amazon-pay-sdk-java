package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the ConfirmOrderReference operation.
 *
 * For more information documentation, see
 * https://payments.amazon.com/documentation/
 */
public class ConfirmOrderReferenceRequest implements Serializable{

    //required parameters
    private String amazonOrderReferenceId;

    //optional parameters
    private String mwsAuthToken;

    /**
     *
     * @param amazonOrderReferenceId The order reference identifier.
     */
    public ConfirmOrderReferenceRequest(String amazonOrderReferenceId){
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }

    /**
     *
     * @param mwsAuthToken
     */
    public ConfirmOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     *
     * @return AmazonOrderReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
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
        return "ConfirmOrderReferenceRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId + ", mwsAuthToken=" + mwsAuthToken + '}';
    }

}
