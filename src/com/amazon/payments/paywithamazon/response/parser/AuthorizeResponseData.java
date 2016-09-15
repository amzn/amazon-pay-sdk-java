/**
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
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
