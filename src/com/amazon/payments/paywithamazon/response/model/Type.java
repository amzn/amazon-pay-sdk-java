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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "Type")
@XmlEnum
public enum Type {

    @XmlEnumValue("OrderReference")
    ORDER_REFERENCE("OrderReference"),
    @XmlEnumValue("BillingAgreement")
    BILLING_AGREEMENT("BillingAgreement"),
    @XmlEnumValue("ChildOrderReference")
    CHILD_ORDER_REFERENCE("ChildOrderReference");
    private final String value;

    Type(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }

    public static Type fromValue(String v) {
        for (Type c: Type.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
