package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.model.ProviderCreditReversalDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An IPN notification to indicate a change in status for 
 * a providerCredit transaction notification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "providerCreditReversalDetails"
})
@XmlRootElement(name="ProviderCreditReversalNotification")
public class ProviderCreditReversalNotification extends Notification  {

    /**
     * ProviderCredit details.
     */
    @XmlElement(name="ProviderCreditReversalDetails", required = true)
    private ProviderCreditReversalDetails providerCreditReversalDetails;

    /**
     * Creates a new instance of the providerCredit notification.
     */
    public ProviderCreditReversalNotification() {
        super(NotificationType.ProviderCreditReversalNotification);
    }

    public ProviderCreditReversalNotification(final ProviderCreditReversalDetails details) {
        super(NotificationType.ProviderCreditReversalNotification);
        providerCreditReversalDetails = details;
    }

    /**
     * @return the details for this providerCredit notification
     */
    public ProviderCreditReversalDetails getProviderCreditReversalDetails() {
        return this.providerCreditReversalDetails;
    }

}
