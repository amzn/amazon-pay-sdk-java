package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.ipn.model.Notification;
import com.amazon.payments.paywithamazon.response.model.ProviderCreditDetails;
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
        "providerCreditDetails"
})
@XmlRootElement(name="ProviderCreditNotification")
public class ProviderCreditNotification  extends Notification {

    /**
     * ProviderCredit details.
     */
    @XmlElement(name="ProviderCreditDetails", required = true)
    private ProviderCreditDetails providerCreditDetails;

    /**
     * Creates a new instance of the providerCredit notification.
     */
    public ProviderCreditNotification() {
        super(NotificationType.ProviderCreditNotification);
    }

    public ProviderCreditNotification(final ProviderCreditDetails details) {
        super(NotificationType.ProviderCreditNotification);
        providerCreditDetails = details;
    }

    /**
     * @return the details for this providerCredit notification
     */
    public ProviderCreditDetails getProviderCreditDetails() {
        return this.providerCreditDetails;
    }

    /**
     * Sets the details for this providerCredit notification.
     * @param details the new providerCredit details for this notification
     */
    public void setProviderCreditDetails(final ProviderCreditDetails details) {
        this.providerCreditDetails = details;
    }

    public boolean isSetProviderCreditDetails() {
        return (this.providerCreditDetails != null);
    }


}
