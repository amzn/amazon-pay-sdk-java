package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;
import java.net.URLDecoder;

/**
 * Container for the parameters to the {@link com.amazon.payments.lpa.Client#getOrderReferenceDetails(GetOrderReferenceDetailsRequest) GetOrderReferenceDetails operation}.
 * For more information documentation, see  
 * <a href="https://payments.amazon.com/documentation/"> API Reference</a>
 */
public class GetOrderReferenceDetailsRequest implements Serializable{
        
    private String amazonOrderReferenceId;
    private String addressConsentToken;
    private String mwsAuthToken;   
    
    /**
     * 
     * @param amazonOrderReferenceId The order reference identifier. 
     *                               This value is retrieved from the Amazon Button widget 
     *                               after the buyer has successfully authenticated with Amazon.
     */
    public GetOrderReferenceDetailsRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }
    
    /**
     * 
     * @param addressConsentToken The buyer address consent token. This value is retrieved 
     *                            from the Amazon Button widget after the buyer has 
     *                            successfully authenticated with Amazon.
     */
    public GetOrderReferenceDetailsRequest setAddressConsentToken( String addressConsentToken ) {
        this.addressConsentToken = URLDecoder.decode(addressConsentToken);
        return this;
    }
    
    /**
     * 
     * @return AddressConsentToken
     */
    public String getAddressConsentToken() {
        return this.addressConsentToken;
    }
    
    /**
     * Sets MWSAuthToken parameter in request. MWSAuthToken is required only for third-party solution providers
     * and marketplaces. Do not specify this parameter for merchants creating their own custom integration. 
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public GetOrderReferenceDetailsRequest setMWSAuthToken(String mwsAuthToken) {
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
        return "GetOrderReferenceDetailsRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId + ", addressConsentToken=" 
                + addressConsentToken + ", mwsAuthToken=" + mwsAuthToken + '}';
    }
    


    
}
