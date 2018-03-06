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
package com.amazon.pay.response.ipn.model;

import com.amazon.pay.response.model.BillingAgreementDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An IPN notification to indicate a change in status for
 * a billing agreement notification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "billingAgreement"
})
@XmlRootElement(name="BillingAgreementNotification")
public class BillingAgreementNotification  extends Notification {

    /**
     * Billing Agreement.
     */
    @XmlElement(name="BillingAgreement", required = true)
    private BillingAgreementDetails billingAgreement;


    /**
     * Creates a new instance of the billing agreement notification.
     */
    public BillingAgreementNotification() {
        super(NotificationType.BillingAgreementNotification);
    }

    /**
     * @return the billing agreement field
     */
    public BillingAgreementDetails getBillingAgreement() {
        return this.billingAgreement;
    }

    /**
     * String representation of BillingAgreement Notification
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BillingAgreementNotification{" + "billingAgreement=" + billingAgreement.toString() + '}';
    }
}
