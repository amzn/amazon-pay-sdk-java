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
