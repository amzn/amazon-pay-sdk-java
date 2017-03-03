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

import com.amazon.pay.response.model.GetProviderCreditDetailsResponse;
import com.amazon.pay.response.model.ProviderCreditDetails;
import java.io.Serializable;

/**
 * Response from GetProviderCreditDetails service API, as returned by Amazon Pay
 */
public final class GetProviderCreditDetailsResponseData  extends ResponseData implements Serializable {
    
    private String requestId;
    private ProviderCreditDetails providerCreditDetails;
    
    public GetProviderCreditDetailsResponseData(GetProviderCreditDetailsResponse getProviderCreditDetailsResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(getProviderCreditDetailsResponse != null) {
            if(getProviderCreditDetailsResponse.getGetProviderCreditDetailsResult()!= null) {
                this.providerCreditDetails = getProviderCreditDetailsResponse.getGetProviderCreditDetailsResult().getProviderCreditDetails();
            }
            this.requestId = getProviderCreditDetailsResponse.getResponseMetadata().getRequestId();
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
     * Encapsulates details about providerCreditDetails
     * 
     * @return providerCreditDetails
     */
    public ProviderCreditDetails getDetails() {
        return providerCreditDetails;
    }

    /**
     * Returns the string representation of GetProviderCreditDetailsResponseData
     * @return 
     */
    @Override
    public String toString() {
        return "GetProviderCreditDetailsResponseData{" + "requestId=" + requestId + ", providerCreditDetails=" + providerCreditDetails.toString() + '}';
    }
    
    

}
