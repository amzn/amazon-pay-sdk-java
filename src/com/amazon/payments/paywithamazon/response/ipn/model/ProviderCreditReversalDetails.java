package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.model.*;
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
    "providerSellerId",
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
    @XmlElement(name = "ProviderSellerId", required = true)
    protected String providerSellerId;
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

    /**
     * Returns the amazonProviderCreditReversalId from notification
     * 
     * @return Returns the amazonProviderCreditReversalId from notification
     */
    public String getAmazonProviderCreditReversalId() {
        return amazonProviderCreditReversalId;
    }

    /**
     * Returns the sellerId from notification
     * 
     * @return Returns the sellerId from notification
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Returns the providerSellerId from notification
     * 
     * @return Returns the providerSellerId from notification
     */
    public String getProviderSellerId() {
        return providerSellerId;
    }

    /**
     * Returns the creditReversalReferenceId from notification
     * 
     * @return Returns the creditReversalReferenceId from notification
     */
    public String getCreditReversalReferenceId() {
        return creditReversalReferenceId;
    }


    /**
     * Returns the creditReversalAmount from notification 
     * 
     * @return Returns the creditReversalAmount from notification 
     */
    public Price getCreditReversalAmount() {
        return creditReversalAmount;
    }

    /**
     * Returns the creationTimestamp from notification
     * 
     * @return Returns the creationTimestamp from notification
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Returns the creditReversalStatus from notification
     * 
     * @return Returns the creditReversalStatus from notification
     */
    public Status getCreditReversalStatus() {
        return creditReversalStatus;
    }

    /**
     * Returns the creditReversalNote from notification
     * 
     * @return Returns the creditReversalNote from notification
     */
    public String getCreditReversalNote() {
        return creditReversalNote;
    }

    /**
     * String representation of providerCreditReversalNotification
     */
    @Override
    public String toString() {
        return "ProviderCreditReversalDetails{" + "amazonProviderCreditReversalId=" + amazonProviderCreditReversalId 
                + ", sellerId=" + sellerId + ", providerId=" + providerSellerId + ", creditReversalReferenceId=" 
                + creditReversalReferenceId + ", creditReversalAmount=" + creditReversalAmount + ", creationTimestamp=" 
                + creationTimestamp + ", creditReversalStatus=" + creditReversalStatus + ", creditReversalNote=" 
                + creditReversalNote + '}';
    }

}
