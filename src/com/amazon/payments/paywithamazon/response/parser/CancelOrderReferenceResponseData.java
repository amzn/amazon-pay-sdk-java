package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.CancelOrderReferenceResponse;
import java.io.Serializable;

/**
 * Response from CancelOrderReferenceResponse service API, as returned by Amazon Payments
 */
public final class CancelOrderReferenceResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    
    public CancelOrderReferenceResponseData(CancelOrderReferenceResponse cancelOrderReferenceResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(cancelOrderReferenceResponse != null) {
            if(cancelOrderReferenceResponse.getResponseMetadata() != null) {
                this.requestId = cancelOrderReferenceResponse.getResponseMetadata().getRequestId();
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
     * Returns the string representation of CancelOrderReferenceResponseData
     */
    @Override
    public String toString() {
        return "CancelOrderReferenceResponseData{" + "requestId=" + requestId + '}';
    }
    
    
    
}
