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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "validationResult",
    "failureReasonCode",
    "billingAgreementStatus"
})
@XmlRootElement(name = "ValidateBillingAgreementResult")
public class ValidateBillingAgreementResult {

    @XmlElement(name = "ValidationResult", required = true)
    protected RequestStatus validationResult;
    @XmlElement(name = "FailureReasonCode")
    protected String failureReasonCode;
    @XmlElement(name = "BillingAgreementStatus")
    protected BillingAgreementStatus billingAgreementStatus;

    public ValidateBillingAgreementResult() {
        super();
    }

    public RequestStatus getValidationResult() {
        return validationResult;
    }


    public String getFailureReasonCode() {
        return failureReasonCode;
    }


    public BillingAgreementStatus getBillingAgreementStatus() {
        return billingAgreementStatus;
    }


}
