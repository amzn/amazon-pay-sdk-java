/**
 * Copyright 2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This represents the parsed response from the Amazon Pay
 * SetOrderAttributes API.
 *
 * &lt;SetOrderAttributesResponse xmlns="http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01"&gt;
 *   &lt;SetOrderAttributesResult&gt;
 *     &lt;OrderReferenceDetails&gt;
 *        ....
 *     &lt;/OrderReferenceDetails&gt;
 *   &lt;/SetOrderAttributesResult&gt;
 *   &lt;ResponseMetadata&gt;
 *     &lt;RequestId&gt;4d5e0306-257e-4a13-b2ad-45b891c3de2a&lt;/RequestId&gt;
 *   &lt;/ResponseMetadata&gt;
 * &lt;/SetOrderAttributesResponse&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "setOrderAttributesResult",
        "responseMetadata"
})
@XmlRootElement(name = "SetOrderAttributesResponse")
public class SetOrderAttributesResponse {



    @XmlElement(name = "SetOrderAttributesResult", required = true)

    protected SetOrderAttributesResult setOrderAttributesResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public SetOrderAttributesResponse() {
        super();
    }

    public SetOrderAttributesResult getSetOrderAttributesResult() {
        return setOrderAttributesResult;
    }
    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }
}
