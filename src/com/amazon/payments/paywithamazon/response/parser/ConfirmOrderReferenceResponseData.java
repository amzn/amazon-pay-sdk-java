package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.ConfirmOrderReferenceResponse;
import java.io.Serializable;

/**
 * Response from ConfirmOrderReference service API, as returned by Amazon Payments
 */
public final class ConfirmOrderReferenceResponseData  extends ResponseData implements Serializable {
    
    private String requestId;
    
    public ConfirmOrderReferenceResponseData(ConfirmOrderReferenceResponse confirmOrderReferenceResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(confirmOrderReferenceResponse != null) {
            if(confirmOrderReferenceResponse.getResponseMetadata() != null) {
                this.requestId = confirmOrderReferenceResponse.getResponseMetadata().getRequestId();
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
     * Returns the string representation of ConfirmOrderReferenceResponseData
     */
    @Override
    public String toString() {
        return "ConfirmOrderReferenceResponseData{" + "requestId=" + requestId + '}';
    }
    
    
}
