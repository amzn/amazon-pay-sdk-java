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
package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.model.RefundDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An IPN notification to indicate a change in status
 * for a refund transaction.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "refundDetails"
})
@XmlRootElement(name = "RefundNotification")
public class RefundNotification  extends Notification {

    /**
     * Refund notification details.
     */
    @XmlElement(name = "RefundDetails", required = true)
    private RefundDetails refundDetails;

    /**
     * Creates a new instance of the refund notification.
     */
    public RefundNotification() {
        super(NotificationType.RefundNotification);
    }

    /**
     * @return the refund details field
     */
    public RefundDetails getRefundDetails() {
        return refundDetails;
    }

    /**
     * String representation of refundDetails
     */
    @Override
    public String toString() {
        return "RefundNotification{" + "refundDetails=" + refundDetails.toString() + '}';
    }



}
