package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Encapsulates details about a Refund object and its status.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefundDetails", propOrder = {
    "amazonRefundId",
    "refundReferenceId",
    "sellerRefundNote",
    "refundType",
    "refundAmount",
    "feeRefunded",
    "creationTimestamp",
    "refundStatus",
    "softDescriptor",
    "providerCreditReversalSummaryList"
})
public class RefundDetails {

    @XmlElement(name = "AmazonRefundId", required = true)
    protected String amazonRefundId;
    @XmlElement(name = "RefundReferenceId", required = true)
    protected String refundReferenceId;
    @XmlElement(name = "SellerRefundNote", required = true)
    protected String sellerRefundNote;
    @XmlElement(name = "RefundType", required = true)
    protected RefundType refundType;
    @XmlElement(name = "RefundAmount", required = true)
    protected Price refundAmount;
    @XmlElement(name = "FeeRefunded", required = true)
    protected Price feeRefunded;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "RefundStatus", required = true)
    protected Status refundStatus;
    @XmlElement(name = "SoftDescriptor", required = true)
    protected String softDescriptor;
    @XmlElement(name = "ProviderCreditReversalSummaryList")
    protected ProviderCreditReversalSummaryList providerCreditReversalSummaryList;

    /**
     * Default constructor
     * 
     */
    public RefundDetails() {
        super();
    }


    /**
     * The Amazon-generated identifier for this refund transaction.
     * 
     * @return amazonRefundId
     */
    public String getAmazonRefundId() {
        return amazonRefundId;
    }


    /**
     * The identifier for this refund transaction that you specify.
     * 
     * @return refundReferenceId
     */
    public String getRefundReferenceId() {
        return refundReferenceId;
    }

    /**
     * A description for the refund that is displayed in emails to the buyer.
     * 
     * @return sellerRefundNote
     */
    public String getSellerRefundNote() {
        return sellerRefundNote;
    }

    /**
     * Indicates the refund type.
     * 
     * @return refundType
     */
    public RefundType getRefundType() {
        return refundType;
    }
    
    /**
     * The amount requested for the refund. Type: Price
     * 
     * @return refundAmount
     */
    public Price getRefundAmount() {
        return refundAmount;
    }

    /**
     * The capture fee that has been refunded. Type: Price
     * 
     * @return feeRefunded
     */
    public Price getFeeRefunded() {
        return feeRefunded;
    }

    /**
     * The time at which the refund was created. In ISO 8601 format.
     * 
     * @return creationTimestamp
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Represents the status of the refund request.
     * 
     * @return refundStatus
     */
    public Status getRefundStatus() {
        return refundStatus;
    }

    /**
     * The description to be shown on the buyer's payment instrument statement.
     * 
     * @return softDescriptor
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     * 
     * @return providerCreditReversalSummaryList
     */
    public ProviderCreditReversalSummaryList getProviderCreditReversalSummaryList() {
        return providerCreditReversalSummaryList;
    }

}
