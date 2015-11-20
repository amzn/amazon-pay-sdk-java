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
