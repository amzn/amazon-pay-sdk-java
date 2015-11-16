package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the {@link com.amazon.payments.lpa.Client#getRefundDetails(GetRefundDetailsRequest) GetRefundDetails operation}.
 * For more information documentation, see  
 * <a href="https://payments.amazon.com/documentation/"> API Reference</a>
 */
public class GetRefundDetailsRequest implements Serializable{
        
    private String amazonRefundId;
    private String mwsAuthToken;  
    
    /**
     * 
     * @param amazonRefundId The Amazon-generated identifier for this refund transaction.
     */
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

    /**
     * 
     * @return amazonRefundId
     */
    public String getAmazonRefundId() {
        return amazonRefundId;
    }

    /**
     * 
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
        return "GetRefundDetailsRequest{" + "amazonRefundId=" + amazonRefundId + ", mwsAuthToken=" + mwsAuthToken + '}';
    }


    
}
