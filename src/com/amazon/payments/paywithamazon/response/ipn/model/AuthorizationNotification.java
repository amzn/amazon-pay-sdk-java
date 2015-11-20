package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.model.AuthorizationDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ipn", propOrder = {
        "authorizationDetails"
}, namespace="https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01")
@XmlRootElement(name="AuthorizationNotification")
public class AuthorizationNotification  extends Notification {

    /**
     * Authorization details field.
     */
    @XmlElement(name = "AuthorizationDetails", required = true)
    protected AuthorizationDetails authorizationDetails;

    /**
     * Creates a new instance of the authorization notification.
     */
    public AuthorizationNotification() {
       super(NotificationType.AuthorizationNotification);
    }

    /**
     * Value constructor
     *
     */
    public AuthorizationNotification(final AuthorizationDetails authorizationDetails) {
        super(NotificationType.AuthorizationNotification);
        this.authorizationDetails = authorizationDetails;
    }

    /**
     * Gets the value of the authorizationDetails property.
     *
     * @return
     *     possible object is
     *     {@link AuthorizationDetails }
     *
     */
    public AuthorizationDetails getAuthorizationDetails() {
        return this.authorizationDetails;
    }

    @Override
    public String toString() {
        return "AuthorizationNotification{" + "authorizationDetails=" + authorizationDetails + '}';
    }



}
