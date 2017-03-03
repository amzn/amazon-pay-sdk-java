/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.response.parser;

import com.amazon.pay.response.model.AuthorizationDetails;
import com.amazon.pay.response.model.GetAuthorizationDetailsResponse;
import java.io.Serializable;

/**
 * Response from GetAuthorizationDetails service API, as returned by Amazon Pay
 */
public final class GetAuthorizationDetailsResponseData extends ResponseData implements  Serializable{
    
    private String requestId;
    private AuthorizationDetails authorizationDetails;
    
    public GetAuthorizationDetailsResponseData(GetAuthorizationDetailsResponse authorizeResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(authorizeResponse != null) {
            if(authorizeResponse.getGetAuthorizationDetailsResult() != null) {
                authorizationDetails = authorizeResponse.getGetAuthorizationDetailsResult().getAuthorizationDetails();
            }
            this.requestId = authorizeResponse.getResponseMetadata().getRequestId();
        }
    }

    /**
     * The requestID that uniquely identifies the service request the caller
     * made.
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
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752450
     * 
     * @return authorizationDetails
     *
     */
    public AuthorizationDetails getDetails() {
        return authorizationDetails;
    }

    /**
     * Returns the string representation of GetAuthorizationDetailsResponseData
     */
    @Override
    public String toString() {
        return "GetAuthorizationDetailsResponseData{" + "requestId=" + requestId + ", authorizationDetails=" + authorizationDetails.toString() + '}';
    }
    
    

}
