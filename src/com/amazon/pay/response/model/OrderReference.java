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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderReference", propOrder = {
        "releaseEnvironment",
        "orderReferenceStatus",
        "amazonOrderReferenceId",
        "creationTimestamp",
        "sellerOrderAttributes",
        "orderTotal",
        "sellerNote",
        "orderLanguage"
})
public class OrderReference {
    @XmlElement(name = "ReleaseEnvironment", required = true)
    protected Environment releaseEnvironment;
    @XmlElement(name = "OrderReferenceStatus", required = true)
    protected OrderReferenceStatus orderReferenceStatus;
    @XmlElement(name = "AmazonOrderReferenceId", required = true)
    protected String amazonOrderReferenceId;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "SellerOrderAttributes")
    protected SellerOrderAttributes sellerOrderAttributes;
    @XmlElement(name = "OrderTotal")
    protected OrderTotal orderTotal;
    @XmlElement(name = "SellerNote")
    protected String sellerNote;
    @XmlElement(name = "OrderLanguage")
    protected String orderLanguage;

    public OrderReference(){
        super();
    }

    public Environment getReleaseEnvironment() {
        return releaseEnvironment;
    }

    public OrderReferenceStatus getOrderReferenceStatus() {
        return orderReferenceStatus;
    }

    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    public SellerOrderAttributes getSellerOrderAttributes() {
        return sellerOrderAttributes;
    }

    public OrderTotal getOrderTotal() {
        return orderTotal;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public String getOrderLanguage() {
        return orderLanguage;
    }

    /**
     * String representation of OrderReference
     */

    @Override
    public String toString() {
        return "OrderReferenceDetails{"
                + "amazonOrderReferenceId=" + amazonOrderReferenceId
                + ", releaseEnvironment=" + releaseEnvironment
                + ", sellerOrderAttributes=" + sellerOrderAttributes.toString()
                + ", orderReferenceStatus=" + orderReferenceStatus
                + ", creationTimestamp=" + creationTimestamp
                + ", orderTotal=" + orderTotal
                + ", orderLanguage=" + orderLanguage
                + ", sellerNote=" + sellerNote + '}';
    }
}