/**
 * Copyright 2016-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
 * GetMerchantAccountStatus API.
 *
 * <pre>{@code
 *      <GetMerchantAccountStatusResponse xmlns="http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01">
 *        <GetMerchantAccountStatusResult>
 *          <AccountStatus>ACTIVE</AccountStatus>
 *        </GetMerchantAccountStatusResult>
 *        <ResponseMetadata>
 *          <RequestId>986dce6b-45e2-4883-bbf4-17adce5994a4</RequestId>
 *        </ResponseMetadata>
 *      </GetMerchantAccountStatusResponse>
 *  }</pre>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getMerchantAccountStatusResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetMerchantAccountStatusResponse")
public class GetMerchantAccountStatusResponse {

    @XmlElement(name = "GetMerchantAccountStatusResult", required = true)
    protected GetMerchantAccountStatusResult getMerchantAccountStatusResult;

    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public GetMerchantAccountStatusResponse() {
        super();
    }

    public GetMerchantAccountStatusResult getMerchantAccountStatusResult() {
        return getMerchantAccountStatusResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

}
