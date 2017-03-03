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
package com.amazon.pay.response.model;

import com.amazon.pay.response.model.ResponseMetadata;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCaptureDetailsResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetCaptureDetailsResponse")
public class GetCaptureDetailsResponse {

    @XmlElement(name = "GetCaptureDetailsResult", required = true)
    protected GetCaptureDetailsResult getCaptureDetailsResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    
    public GetCaptureDetailsResponse() {
        super();
    }
    
    public GetCaptureDetailsResult getGetCaptureDetailsResult() {
        return getCaptureDetailsResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "captureDetails"
    })
    @XmlRootElement(name = "GetCaptureDetailsResult")
    public static class GetCaptureDetailsResult {

        @XmlElement(name = "CaptureDetails", required = true)
        protected CaptureDetails captureDetails;

        public GetCaptureDetailsResult() {
            super();
        }
        
        public CaptureDetails getCaptureDetails() {
            return captureDetails;
        }

    }

}
