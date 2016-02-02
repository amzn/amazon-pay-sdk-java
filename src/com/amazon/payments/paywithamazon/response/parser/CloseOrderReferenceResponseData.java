package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.CloseOrderReferenceResponse;
import java.io.Serializable;

/**
 * Response from CloseOrderReference service API, as returned by Amazon Payments
 */
public final class CloseOrderReferenceResponseData extends ResponseData implements Serializable{
    
    private String requestId;
    
    public CloseOrderReferenceResponseData(CloseOrderReferenceResponse closeOrderReferenceResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(closeOrderReferenceResponse != null) {
            if(closeOrderReferenceResponse.getResponseMetadata() != null) {
                this.requestId = closeOrderReferenceResponse.getResponseMetadata().getRequestId();
            }
        }
    }

     /**
      * The requestID that uniquely identifies the service request
     * the caller made.
     * 
     * @return  The requestID that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Returns the string representation of CloseOrderReferenceResponseData
     */
    @Override
    public String toString() {
        return "CloseOrderReferenceResponseData{" + "requestId=" + requestId + '}';
    }
    
    
}
