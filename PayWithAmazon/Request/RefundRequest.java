/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * https://payments.amazon.com/documentation/apireference/201751630#201752010
 * @author nehaa
 */
public class RefundRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    private String amazonCaptureId = null;
    private String refundReferenceId = null;
    private String refundAmount = null;
    private String sellerRefundNote = null;
    private String softDescriptor = null;
    private String mwsAuthToken = null;   
    /**
     * Set the value of sellerAuthorizationNote
     *
     * @param amazonOrderReferenceId new value of sellerAuthorizationNote
     */
    public RefundRequest setAmazonCaptureId(String captureId) {
        this.amazonCaptureId = captureId;
        parameters.put(ParamConstants.AMAZON_CAPTURE_ID, captureId);
        return this;
    }
    
    /**
     * Set the value of sellerAuthorizationNote
     *
     * @param authorizationReferenceId new value of sellerAuthorizationNote
     */
    public RefundRequest setRefundReferenceId(String refundReferenceId) {
        this.refundReferenceId = refundReferenceId;
        parameters.put(ParamConstants.REFUND_REFERENCE_ID, refundReferenceId);
        return this;
    }

    /**
     * Set the value of authorizationAmount
     *
     * @param refundAmount new value of authorizationAmount
     */
    public RefundRequest setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
        parameters.put(ParamConstants.REFUND_AMOUNT, refundAmount);
        return this;
    }

    /**
     * Set the value of sellerRefundNote
     *
     * @param sellerRefundNote new value of sellerRefundNote
     */
    public RefundRequest setSellerRefundNote(String sellerRefundNote){
        this.sellerRefundNote = sellerRefundNote;
         parameters.put(ParamConstants.SELLER_REFUND_NOTE, sellerRefundNote);
         return this;
    }

    /**
     * Set the value of softDescriptor
     *
     * @param softDescriptor new value of softDescriptor
     */
    public RefundRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        parameters.put(ParamConstants.SOFT_DESCRIPTOR, softDescriptor);
        return this;
    }

    /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public RefundRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }

    /**
     * Get the value of request parameters
     *
     * @return parameters map of all request parameters
     */
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
