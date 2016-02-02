package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the {@link com.amazon.payments.lpa.Client#cancelOrderReference(CancelOrderReferenceRequest) CancelOrderReference operation}.
 * For more information documentation, see  
 * <a href="https://payments.amazon.com/documentation/"> API Reference</a>
 */
public class CancelOrderReferenceRequest implements Serializable{
        
    //required parameters
    private final String amazonOrderReferenceId;
    
    //optional parameters
    private String cancelationReason;
    private String mwsAuthToken;
    
    /*
    * @param amazonOrderReferenceId
    *      The order reference identifier. This value is retrieved 
    *      from the Amazon Button widget after the buyer has successfully 
    *      authenticated with Amazon.
    * 
    * @return CancelOrderReferenceeRequest 
    *           Container holding authorize operation parameters
    */
    public CancelOrderReferenceRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }
    
    /** 
     * Optional parameter 
     * 
     * @param cancelationReason Describes the reason for the cancelation. This is for 
     * informational purposes only and is never displayed to the customer. 
     * The value can be retrieved in future GetOrderReferenceDetails calls.
     * Maximum: 1024 characters
     */
    public CancelOrderReferenceRequest setCancelReason(String cancelationReason) {
        this.cancelationReason = cancelationReason;
        return this;
    }
 
    /**
     * Applicable for third-party solution providers only. 
     * 
     * @param mwsAuthToken 
     */
    public CancelOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
    *  Represents the order reference identifier.
    * 
    * @return Returns AmazonOrderReferenceId from request
    */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /*
     * Describes the reason for the cancelation. This is for 
     * informational purposes only and is never displayed to the customer. 
     * The value can be retrieved in future GetOrderReferenceDetails calls.
     * Maximum: 1024 characters 
    
    * @return Returns cancelationReason from request
    */
    public String getCancelationReason() {
        return cancelationReason;
    }

    /**
     * Applicable for third-party solution providers only. 
     * 
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
        return "CancelOrderReferenceRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId + ", cancelationReason=" 
                + cancelationReason + ", mwsAuthToken=" + mwsAuthToken + '}';
    }


    
}
