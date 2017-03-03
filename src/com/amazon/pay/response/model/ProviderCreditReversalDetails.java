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
package com.amazon.pay.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditReversalDetails", propOrder = {
    "amazonProviderCreditReversalId",
    "sellerId",
    "providerId",
    "creditReversalReferenceId",
    "creditReversalAmount",
    "creationTimestamp",
    "creditReversalStatus",
    "creditReversalNote"
})
public class ProviderCreditReversalDetails {

    @XmlElement(name = "AmazonProviderCreditReversalId", required = true)
    protected String amazonProviderCreditReversalId;
    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "CreditReversalReferenceId", required = true)
    protected String creditReversalReferenceId;
    @XmlElement(name = "CreditReversalAmount", required = true)
    protected Price creditReversalAmount;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CreditReversalStatus", required = true)
    protected Status creditReversalStatus;
    @XmlElement(name = "CreditReversalNote")
    protected String creditReversalNote;

    public ProviderCreditReversalDetails() {
        super();
    }

    public String getAmazonProviderCreditReversalId() {
        return amazonProviderCreditReversalId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getCreditReversalReferenceId() {
        return creditReversalReferenceId;
    }


    public Price getCreditReversalAmount() {
        return creditReversalAmount;
    }

    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    public Status getCreditReversalStatus() {
        return creditReversalStatus;
    }

    public String getCreditReversalNote() {
        return creditReversalNote;
    }

    /**
     * String representation of providerCreditReversalNotification
     */
    @Override
    public String toString() {
        return "ProviderCreditReversalDetails{" + "amazonProviderCreditReversalId=" + amazonProviderCreditReversalId 
                + ", sellerId=" + sellerId + ", providerId=" + providerId + ", creditReversalReferenceId=" 
                + creditReversalReferenceId + ", creditReversalAmount=" + creditReversalAmount + ", creationTimestamp=" 
                + creationTimestamp + ", creditReversalStatus=" + creditReversalStatus + ", creditReversalNote=" 
                + creditReversalNote + '}';
    }

}
