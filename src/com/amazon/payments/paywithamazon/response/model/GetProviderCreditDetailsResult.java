package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "providerCreditDetails"
})
@XmlRootElement(name = "GetProviderCreditDetailsResult")
public class GetProviderCreditDetailsResult {

    @XmlElement(name = "ProviderCreditDetails")
    protected ProviderCreditDetails providerCreditDetails;

    public GetProviderCreditDetailsResult() {
        super();
    }

    public ProviderCreditDetails getProviderCreditDetails() {
        return providerCreditDetails;
    }

}
