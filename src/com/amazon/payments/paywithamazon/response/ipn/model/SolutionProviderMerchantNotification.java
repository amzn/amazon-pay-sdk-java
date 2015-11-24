package com.amazon.payments.paywithamazon.response.ipn.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * An IPN notification to indicate a change in status for
 * a solutionProviderMerchant transaction notification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "merchantRegistrationDetails" })
@XmlRootElement(name = "SolutionProviderMerchantNotification")
public class SolutionProviderMerchantNotification  extends Notification {

    @XmlElement(name = "MerchantRegistrationDetails", required = true)
    private MerchantRegistrationDetails merchantRegistrationDetails;

    public SolutionProviderMerchantNotification() {
        super(NotificationType.SolutionProviderMerchantNotification);
    }

    public SolutionProviderMerchantNotification(final MerchantRegistrationDetails details) {
        super(NotificationType.SolutionProviderMerchantNotification);
        merchantRegistrationDetails = details;
    }

    /**
     * Returns the details of merchantRegistrationDetails
     * 
     * @return Returns the details of merchantRegistrationDetails
     */
    public MerchantRegistrationDetails getMerchantRegistrationDetails() {
        return this.merchantRegistrationDetails;
    }

    /**
     * String representation of SolutionProviderMerchantNotification
     * 
     * @return Returns the string representation of SolutionProviderMerchantNotification
     */
    @Override
    public String toString() {
        return "SolutionProviderMerchantNotification{" + "merchantRegistrationDetails=" + merchantRegistrationDetails.toString() + '}';
    }

    
}
