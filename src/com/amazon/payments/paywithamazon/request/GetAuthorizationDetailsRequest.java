package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the GetAuthorizationDetails operation.
 *
 * For more information documentation, see
 * https://payments.amazon.com/documentation/
 */
public class GetAuthorizationDetailsRequest implements Serializable{

    //required parameters
    private String amazonAuthorizationId;

    //optional parameters
    private String mwsAuthToken;

    /**
     *
     * @param amazonAuthorizationId
     *                         The authorization identifier that was generated 
     *                          by Amazon in the earlier call to Authorize.
     */
    public GetAuthorizationDetailsRequest(String amazonAuthorizationId) {
        this.amazonAuthorizationId = amazonAuthorizationId;
    }

    /**
     * @param mwsAuthToken
     */
    public GetAuthorizationDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * @return AmazonAuthorizationId
     */
    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    /**
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
        return "GetAuthorizationDetailsRequest{" + "amazonAuthorizationId=" + amazonAuthorizationId + ", mwsAuthToken=" + mwsAuthToken + '}';
    }



}
