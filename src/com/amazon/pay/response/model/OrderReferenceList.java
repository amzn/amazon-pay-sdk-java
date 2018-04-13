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
import java.util.ArrayList;
import java.util.List;

/**
 * This represents the OrderReferenceList node parsed
 * from the Amazon Pay ListOrderReference API response.
 *
 *    &lt;OrderReferenceList&gt;
 *        &lt;OrderReference&gt;
 *            ...
 *        &lt;/OrderReference&gt;
 *    &lt;/OrderReferenceList&gt;
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "orderReferences"
})
@XmlRootElement(name = "OrderReferenceList")
public class OrderReferenceList {

    @XmlElement(name = "OrderReference")
    protected List<OrderReference> orderReferences;

    public OrderReferenceList() {
        super();
    }

    public OrderReferenceList(final List<OrderReference> orderReferences){
        this.orderReferences = orderReferences;
    }

    public List<OrderReference> getOrderReferences() {
        if (orderReferences == null){
            orderReferences = new ArrayList<OrderReference>();
        }
        return orderReferences;
    }
}
