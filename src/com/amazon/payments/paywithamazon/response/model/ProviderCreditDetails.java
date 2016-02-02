package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditDetails", propOrder = {
    "amazonProviderCreditId",
    "sellerId",
    "providerId",
    "providerSellerId",
    "creditReferenceId",
    "creditAmount",
    "creditReversalAmount",
    "creditReversalIdList",
    "creationTimestamp",
    "creditStatus"
})
public class ProviderCreditDetails {

    @XmlElement(name = "AmazonProviderCreditId", required = true)
    protected String amazonProviderCreditId;
    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "ProviderSellerId", required = false)
    protected String providerSellerId;
    @XmlElement(name = "CreditReferenceId", required = true)
    protected String creditReferenceId;
    @XmlElement(name = "CreditAmount", required = true)
    protected Price creditAmount;
    @XmlElement(name = "CreditReversalAmount", required = true)
    protected Price creditReversalAmount;
    @XmlElement(name = "CreditReversalIdList", required = true)
    protected IdList creditReversalIdList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CreditStatus", required = true)
    protected Status creditStatus;

    public ProviderCreditDetails() {
        super();
    }

    /**
     * Returns the amazonProviderCreditId
     */
    public String getAmazonProviderCreditId() {
        return amazonProviderCreditId;
    }

    /**
     * Returns the sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Returns the providerId
     */
    public String getProviderId() {
        return providerId;
    }
    
    /**
     * Returns the providerSellerId 
     * (applicable while processing ProviderCreditNotification only)
     */
    public String getProviderSellerId() {
        return providerSellerId;
    }

    public String getCreditReferenceId() {
        return creditReferenceId;
    }

    public Price getCreditAmount() {
        return creditAmount;
    }

    public Price getCreditReversalAmount() {
        return creditReversalAmount;
    }

    public IdList getCreditReversalIdList() {
        return creditReversalIdList;
    }
    
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    public Status getCreditStatus() {
        return creditStatus;
    }

    /**
     * String representation of providerCreditDetails
     */
    @Override
    public String toString() {
        return "ProviderCreditDetails{" + "amazonProviderCreditId=" + amazonProviderCreditId + ", sellerId=" 
                + sellerId + ", providerId=" + providerId + ", creditReferenceId=" + creditReferenceId 
                + ", creditAmount=" + creditAmount + ", creditReversalAmount=" + creditReversalAmount 
                + ", creditReversalIdList=" + creditReversalIdList + ", creationTimestamp=" + creationTimestamp 
                + ", creditStatus=" + creditStatus + '}';
    }


}
