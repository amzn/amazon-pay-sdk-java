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
    "getAuthorizationDetailsResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetAuthorizationDetailsResponse")
public class GetAuthorizationDetailsResponse {

    @XmlElement(name = "GetAuthorizationDetailsResult", required = true)
    protected GetAuthorizationDetailsResult getAuthorizationDetailsResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    
    public GetAuthorizationDetailsResponse() {
        super();
    }

    public GetAuthorizationDetailsResult getGetAuthorizationDetailsResult() {
        return getAuthorizationDetailsResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
       "authorizationDetails"
    })
    @XmlRootElement(name = "GetAuthorizationDetailsResult")
    public static class GetAuthorizationDetailsResult {

        @XmlElement(name = "AuthorizationDetails", required = true)
        protected AuthorizationDetails authorizationDetails;

        public GetAuthorizationDetailsResult() {
            super();
        }

        public AuthorizationDetails getAuthorizationDetails() {
            return authorizationDetails;
        }
}
    
}
