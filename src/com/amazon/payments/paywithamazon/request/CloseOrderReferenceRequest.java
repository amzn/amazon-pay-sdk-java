package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;


/**
 * Container for the parameters to the {@link com.amazon.payments.lpa.Client#closeOrderReference(CloseOrderReferenceRequest) CloseOrderReference operation}.
 * For more information documentation, see  
 * <a href="https://payments.amazon.com/documentation/"> API Reference</a>
 */
public class CloseOrderReferenceRequest implements Serializable{
    
    //required parameters
    private String amazonOrderReferenceId;
    
    //optional parameters
    private String closureReason;
    private String mwsAuthToken; 
    
    /**
     * @param amazonOrderReferenceId 
     *              The ID of the order reference for which the details are being requested.
     * 
     * @return CloseOrderReferenceRequest
     */
    public CloseOrderReferenceRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }
    
    /**
     * Sets the reason for closing the order reference. This is for 
     * informational purposes only and is never displayed to the customer. 
     * 
     * @param closureReason 
     *              
     */
    public CloseOrderReferenceRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }
    
    /**
     * Sets MWSAuthToken parameter in request. MWSAuthToken is required only for third-party solution providers
     * and marketplaces. Do not specify this parameter for merchants creating their own custom integration. 
     * 
     * @param mwsAuthToken 
     */
    public CloseOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * The ID of the order reference for which the details are being requested.
     * 
     * @return AmazonOrderReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * Describes the reason for closing the order reference.
     * @return ClosureReason
     */
    public String getClosureReason() {
        return closureReason;
    }

    /** 
     * Represents the MWSAuthToken parameter in request. MWSAuthToken is required only for third-party solution providers
     * and marketplaces. Do not specify this parameter for merchants creating their own custom integration. 
     
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
        return "CloseOrderReferenceRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId + ", closureReason=" + closureReason + ", mwsAuthToken=" 
                + mwsAuthToken + '}';
    }
    

}
