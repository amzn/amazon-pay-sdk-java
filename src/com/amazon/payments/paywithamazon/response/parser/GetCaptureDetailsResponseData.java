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

import com.amazon.payments.paywithamazon.response.model.CaptureDetails;
import com.amazon.payments.paywithamazon.response.model.GetCaptureDetailsResponse;
import java.io.Serializable;

/**
 * Response from GetCaptureDetails service API, as returned by Amazon Payments
 */
public final class GetCaptureDetailsResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    private CaptureDetails captureDetails;
    
    public GetCaptureDetailsResponseData(GetCaptureDetailsResponse getCaptureDetailsResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(getCaptureDetailsResponse != null) {
            if(getCaptureDetailsResponse.getGetCaptureDetailsResult() != null) {
                captureDetails = getCaptureDetailsResponse.getGetCaptureDetailsResult().getCaptureDetails();
            }
            this.requestId = getCaptureDetailsResponse.getResponseMetadata().getRequestId();
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
     * Encapsulates details about a Capture object and its status.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752580
     * 
     * @return captureDetails
     */
    public CaptureDetails getDetails() {
        return captureDetails;
    }

    /**
     * Returns the string representation of GetCaptureDetailsResponseData
     */
    @Override
    public String toString() {
        return "GetCaptureDetailsResponseData{" + "requestId=" + requestId + ", captureDetails=" + captureDetails.toString() + '}';
    }
    
    

}
