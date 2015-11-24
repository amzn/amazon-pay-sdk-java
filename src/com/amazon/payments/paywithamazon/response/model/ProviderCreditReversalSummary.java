package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditReversalSummary", propOrder = {
    "providerId",
    "providerCreditReversalId"
})
public class ProviderCreditReversalSummary {

    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "ProviderCreditReversalId", required = true)
    protected String providerCreditReversalId;

    public ProviderCreditReversalSummary() {
        super();
    }

    public String getProviderId() {
        return providerId;
    }

    public String getProviderCreditReversalId() {
        return providerCreditReversalId;
    }

    @Override
    public String toString() {
        return "ProviderCreditReversalSummary{" + "providerId=" + providerId + ", providerCreditReversalId=" + providerCreditReversalId + '}';
    }

    
}
