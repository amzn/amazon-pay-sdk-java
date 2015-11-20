package com.amazon.payments.paywithamazon.response.model;

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

}
