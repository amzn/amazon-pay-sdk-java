package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.CloseAuthorizationResponse;
import java.io.Serializable;

/**
 * Response from CloseAuthorization service API, as returned by Amazon Payments
 */
public final class CloseAuthorizationResponseData  extends ResponseData implements Serializable{

    private String requestId;
    
    public CloseAuthorizationResponseData(CloseAuthorizationResponse closeAuthorizationResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(closeAuthorizationResponse != null) {
            if(closeAuthorizationResponse.getResponseMetadata() != null) {
                this.requestId = closeAuthorizationResponse.getResponseMetadata().getRequestId();
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
     * Returns the string representation of CloseAuthorizationResponseData
     */
    @Override
    public String toString() {
        return "CloseAuthorizationResponseData{" + "requestId=" + requestId + '}';
    }
    
    
}
