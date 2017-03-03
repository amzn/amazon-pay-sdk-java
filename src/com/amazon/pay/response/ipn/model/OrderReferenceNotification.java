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

import com.amazon.pay.response.model.OrderReferenceDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * An IPN notification to indicate a change in status for an order reference
 * notification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "orderReference"
})
@XmlRootElement(name="OrderReferenceNotification")
public class OrderReferenceNotification  extends Notification {

    
    /**
     * Order reference details field.
     */
    @XmlElement(name = "OrderReference", required = true)
    private OrderReferenceDetails orderReference;

    /**
     * Creates a new instance of the order reference.
     */
    public OrderReferenceNotification() {
       super(NotificationType.OrderReferenceNotification);
    }

    /**
     * @return gets the order reference details for
     * this order reference notification
     */
    public OrderReferenceDetails getOrderReference() {
        return orderReference;
    }

    /**
     * Returns the string representation of OrderReferenceNotification
     * 
     * @return Returns the string representation of OrderReferenceNotification
     */
    @Override
    public String toString() {
        return "OrderReferenceNotification{" + "orderReference=" + orderReference.toString() + '}';
    }



}
