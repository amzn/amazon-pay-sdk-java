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
 * This represents the GetMerchantAccountStatusResult node parsed
 * from the Amazon Pay GetMerchantAccountStatusResponse.
 *
 * <pre>{@code
 *      <GetMerchantAccountStatusResult>
 *        <AccountStatus>ACTIVE</AccountStatus>
 *      </GetMerchantAccountStatusResult>
 *  }</pre>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountStatus"
})
@XmlRootElement(name = "GetMerchantAccountStatusResult")
public class GetMerchantAccountStatusResult {

    @XmlElement(name = "AccountStatus", required = true)
    protected AccountStatus accountStatus;

    public GetMerchantAccountStatusResult() {
        super();
    }

    /**
     * @return  account status:
     *   ACTIVE - Merchant account is active
     *   INACTIVE - Merchant account is not active
     */
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    /**
     * Returns the string representation of GetMerchantAccountStatusResult
     */
    @Override
    public String toString() {
        return "GetMerchantAccountStatus{" + "accountStatus=" + accountStatus + "}";
    }
}
