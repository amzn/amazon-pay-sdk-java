package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the 
 * {@link com.amazon.payments.lpa.Client#getProviderCreditDetails(GetProviderCreditDetailsRequest) GetProviderCreditDetails operation}.
 *
 */
public class GetProviderCreditDetailsRequest implements Serializable{
        
    //required parameters
    private String amazonProviderCreditId;
    private String sellerId;
    
    //optional parameters
    private String mwsAuthToken;

    /**
     * 
     * @param amazonProviderCreditId
     * @param sellerId 
     */
    public GetProviderCreditDetailsRequest(String amazonProviderCreditId , String sellerId) {
        this.amazonProviderCreditId = amazonProviderCreditId;
        this.sellerId = sellerId;
    }

    /**
     * @param mwsAuthToken
     * @param mwsAuthToken
     * @return 
     */
    public GetProviderCreditDetailsRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * @return amazonProviderCreditId
     */
    public String getAmazonProviderCreditId() {
        return amazonProviderCreditId;
    }

    /**
     * @return sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * @return mwsAuthToken
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
        return "GetProviderCreditDetailsRequest{" + "amazonProviderCreditId=" + amazonProviderCreditId + ", sellerId=" + sellerId + ", mwsAuthToken=" 
                + mwsAuthToken + '}';
    }
    
    
}
