/*******************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * *****************************************************************************
 */

package com.amazonservices.mws.offamazonpayments.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefundType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RefundType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AmazonA-ZRefund"/>
 *     &lt;enumeration value="AmazonA-ZGuarantee"/>
 *     &lt;enumeration value="SellerInitiated"/>
 *     &lt;enumeration value="Chargeback"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RefundType")
@XmlEnum
public enum RefundType {

    @XmlEnumValue("AmazonA-ZRefund")
    AMAZON_A_Z_REFUND("AmazonA-ZRefund"),
    @XmlEnumValue("AmazonA-ZGuarantee")
    AMAZON_A_Z_GUARANTEE("AmazonA-ZGuarantee"),
    @XmlEnumValue("SellerInitiated")
    SELLER_INITIATED("SellerInitiated"),
    @XmlEnumValue("Chargeback")
    CHARGEBACK("Chargeback");
    private final String value;

    RefundType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }

    public static RefundType fromValue(String v) {
        for (RefundType c: RefundType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
