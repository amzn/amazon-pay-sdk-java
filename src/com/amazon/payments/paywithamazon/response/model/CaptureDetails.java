package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Encapsulates details about a Capture object and its status.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaptureDetails", propOrder = {
    "amazonCaptureId",
    "captureReferenceId",
    "sellerCaptureNote",
    "captureAmount",
    "refundedAmount",
    "captureFee",
    "idList",
    "creationTimestamp",
    "captureStatus",
    "softDescriptor",
    "providerCreditSummaryList"
})
public class CaptureDetails {

    @XmlElement(name = "AmazonCaptureId", required = true)
    protected String amazonCaptureId;
    @XmlElement(name = "CaptureReferenceId", required = true)
    protected String captureReferenceId;
    @XmlElement(name = "SellerCaptureNote", required = true)
    protected String sellerCaptureNote;
    @XmlElement(name = "CaptureAmount", required = true)
    protected Price captureAmount;
    @XmlElement(name = "RefundedAmount", required = true)
    protected Price refundedAmount;
    @XmlElement(name = "CaptureFee", required = true)
    protected Price captureFee;
    @XmlElement(name = "IdList", required = true)
    protected IdList idList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CaptureStatus", required = true)
    protected Status captureStatus;
    @XmlElement(name = "SoftDescriptor", required = true)
    protected String softDescriptor;
    @XmlElement(name = "ProviderCreditSummaryList")
    protected ProviderCreditSummaryList providerCreditSummaryList;

    public CaptureDetails() {
        super();
    }

    /**
     * The Amazon-generated identifier for this capture.
     * 
     * @return amazonCaptureId
     */
    public String getAmazonCaptureId() {
        return amazonCaptureId;
    }

    /**
     * The identifier for this capture that you specify.
     * 
     * @return captureReferenceId
     */
    public String getCaptureReferenceId() {
        return captureReferenceId;
    }

    /**
     * A description for the capture that is displayed in emails to the buyer.
     * 
     * @return sellerCaptureNote
     */
    public String getSellerCaptureNote() {
        return sellerCaptureNote;
    }

    /**
     * The amount to be captured. Type: Price
     * 
     * @return captureAmount
     */
    public Price getCaptureAmount() {
        return captureAmount;
    }

    /**
     * The total amount that has been refunded on this capture.
     * 
     * @return refundedAmount
     */
    public Price getRefundedAmount() {
        return refundedAmount;
    }

    /**
     * The fee that was charged by Amazon for this capture.
     * 
     * @return captureFee
     */
    public Price getCaptureFee() {
        return captureFee;
    }

    /**
     * A list of AmazonRefundId identifiers that have been requested on this Capture object. 
     * This list is empty if you have not requested any refunds on this capture.
     * 
     * @return idList
     */
    public IdList getIdList() {
        return idList;
    }
    
    /**
     * The time at which the capture was created. In ISO 8601 format.
     * 
     * @return creationTimestamp
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Represents the current status of the capture. For more information 
     * about the State and ReasonCode response elements, see Capture States 
     * and Reason Codes. Type: Status
     * 
     * @return captureStatus
     */
    public Status getCaptureStatus() {
        return captureStatus;
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
     * @return providerCreditSummaryList
     */
    public ProviderCreditSummaryList getProviderCreditSummaryList() {
        return providerCreditSummaryList;
    }

    /**
     * Returns the string representation of captureDetails
     */
    @Override
    public String toString() {
        return "CaptureDetails{" + "amazonCaptureId=" + amazonCaptureId + ", captureReferenceId=" + captureReferenceId 
                + ", sellerCaptureNote=" + sellerCaptureNote + ", captureAmount=" + captureAmount + ", refundedAmount=" 
                + refundedAmount + ", captureFee=" + captureFee + ", idList=" + idList + ", creationTimestamp=" 
                + creationTimestamp + ", captureStatus=" + captureStatus + ", softDescriptor=" + softDescriptor 
                + ", providerCreditSummaryList=" + providerCreditSummaryList + '}';
    }

}
