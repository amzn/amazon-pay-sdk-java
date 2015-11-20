package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCredit", propOrder = {
    "providerId",
    "creditAmount"
})
public class ProviderCredit {

    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "CreditAmount", required = true)
    protected Price creditAmount;

    public ProviderCredit() {
        super();
    }

    public ProviderCredit(String providerId, Price creditAmount) {
        this.providerId = providerId;
        this.creditAmount = creditAmount;
    }
    
    public String getProviderId() {
        return providerId;
    }

    public Price getCreditAmount() {
        return creditAmount;
    }

}
