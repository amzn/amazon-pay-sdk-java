package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.AuthorizationDetails;
import com.amazon.payments.paywithamazon.response.model.AuthorizeResponse;
import java.io.Serializable;

/*
 * Response from Authorize service API, as returned by Amazon Payments
*/
public final class AuthorizeResponseData extends ResponseData implements Serializable {
    
    private String requestId;
    private AuthorizationDetails authorizationDetails;
    
    public AuthorizeResponseData(AuthorizeResponse authorizeResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(authorizeResponse != null) {
            if(authorizeResponse.getAuthorizeResult() != null) {
                this.authorizationDetails = authorizeResponse.getAuthorizeResult().getAuthorizationDetails();
            }
            this.requestId = authorizeResponse.getResponseMetadata().getRequestId();
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
     * Encapsulates details about an Authorization object, 
     * including the status, amount captured, and fee charged.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752450
     * 
     * @return authorizationDetails
     *
     */
    public AuthorizationDetails getDetails() {
        return authorizationDetails;
    }

    /**
     * Returns the string representation of AuthorizeResponseData
     */
    @Override
    public String toString() {
        return "AuthorizeResponseData{" + "requestId=" + requestId + ", authorizationDetails=" + authorizationDetails.toString() + '}';
    }
    
    

    
}
