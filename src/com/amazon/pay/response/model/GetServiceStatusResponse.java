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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This represents the parsed response from the Amazon Pay
 * GetServiceStatusResponse API.
 *
 * <GetServiceStatusResponse xmlns="http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01">
 *   <GetServiceStatusResult>
 *     <Status>GREEN</Status>
 *     <Timestamp>2016-2017-11-27T02:57:30.504Z</Timestamp>
 *   </GetServiceStatusResult>
 *   <ResponseMetadata>
 *     <RequestId>93437336-70dd-4359-b453-f13a90dccb99</RequestId>
 *   </ResponseMetadata>
 * </GetServiceStatusResponse>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getServiceStatusResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetServiceStatusResponse")
public class GetServiceStatusResponse {

    @XmlElement(name = "GetServiceStatusResult", required = true)
    protected GetServiceStatusResult getServiceStatusResult;

    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public GetServiceStatusResponse() {
        super();
    }

    public GetServiceStatusResult getServiceStatusResult() {
        return getServiceStatusResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

}
