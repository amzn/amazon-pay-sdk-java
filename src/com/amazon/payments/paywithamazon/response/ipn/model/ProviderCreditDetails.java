package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.model.IdList;
import com.amazon.payments.paywithamazon.response.model.Price;
import com.amazon.payments.paywithamazon.response.model.Status;
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
    @XmlElement(name = "ProviderSellerId", required = true)
    protected String providerSellerId;
    @XmlElement(name = "CreditReferenceId", required = true)
    protected String creditReferenceId;
    @XmlElement(name = "CreditAmount", required = true)
    protected Price creditAmount;
    @XmlElement(name = "CreditReversalAmount", required = true)
    protected Price creditReversalAmount;
    @XmlElement(name = "CreditReversalIdList", required = true)
    protected CreditReversalIdList creditReversalIdList;
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
     * Returns the providerSellerId 
     * (applicable while processing ProviderCreditNotification only)
     */
    public String getProviderSellerId() {
        return providerSellerId;
    }

    /**
     * Returns the creditReferenceId from notification
     * 
     * @return Returns the creditReferenceId
     */
    public String getCreditReferenceId() {
        return creditReferenceId;
    }

    /**
     * Returns the creditAmount from notification
     * 
     * @return Returns the creditAmount from notification
     */
    public Price getCreditAmount() {
        return creditAmount;
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
     * Returns the creditReversalIdList from notification
     * 
     * @return Returns the creditReversalIdList from notification
     */
    public CreditReversalIdList getCreditReversalIdList() {
        return creditReversalIdList;
    }
    
    /**
     * Returns the creationTimeStamp from notification 
     * 
     * @return Returns the creationTimeStamp from notification 
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Returns the creditStatus from notification 
     * 
     * @return Returns the creditStatus from notification
     */
    public Status getCreditStatus() {
        return creditStatus;
    }

    /**
     * String representation of providerCreditDetails
     */
    @Override
    public String toString() {
        return "ProviderCreditDetails{" + "amazonProviderCreditId=" + amazonProviderCreditId + ", sellerId=" 
                + sellerId + ", creditReferenceId=" + creditReferenceId 
                + ", creditAmount=" + creditAmount + ", creditReversalAmount=" + creditReversalAmount 
                + ", creditReversalIdList=" + creditReversalIdList + ", creationTimestamp=" + creationTimestamp 
                + ", creditStatus=" + creditStatus + '}';
    }


}
