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
package com.amazon.payments.paywithamazon.response.model;

import com.amazon.payments.paywithamazon.response.model.ResponseMetadata;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "closeOrderReferenceResult",
    "responseMetadata"
})
@XmlRootElement(name = "CloseOrderReferenceResponse")
public class CloseOrderReferenceResponse {

    @XmlElement(name = "CloseOrderReferenceResult", required = true)
    protected CloseOrderReferenceResult closeOrderReferenceResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    
    public CloseOrderReferenceResponse() {
        super();
    }

    public CloseOrderReferenceResult getCloseOrderReferenceResult() {
        return closeOrderReferenceResult;
    }


    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    @XmlRootElement(name = "CloseOrderReferenceResult")
    public static class CloseOrderReferenceResult {
        public CloseOrderReferenceResult() {
            super();
    }
    }
}
