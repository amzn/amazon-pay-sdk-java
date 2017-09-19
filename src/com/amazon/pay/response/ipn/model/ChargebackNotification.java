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
package com.amazon.pay.response.ipn.model;

import com.amazon.pay.response.model.ChargebackDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An IPN notification to indicate a change in status
 * for a chargeback transaction.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "chargebackDetails"
})
@XmlRootElement(name = "ChargebackNotification")
public class ChargebackNotification extends Notification {

    /**
     * Chargeback notification details.
     */
    @XmlElement(name = "ChargebackDetails", required = true)
    private ChargebackDetails chargebackDetails;

    /**
     * Creates a new instance of the chargeback notification.
     */
    public ChargebackNotification() {
        super(NotificationType.ChargebackNotification);
    }

    /**
     * @return the chargeback details field
     */
    public ChargebackDetails getChargebackDetails() {
        return chargebackDetails;
    }

    /**
     * String representation of chargebackDetails
     */
    @Override
    public String toString() {
        return "ChargebackNotification{" + "chargebackDetails=" + chargebackDetails.toString() + '}';
    }

}
