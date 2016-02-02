package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "providerCreditReversalDetails"
})
@XmlRootElement(name = "GetProviderCreditReversalDetailsResult")
public class GetProviderCreditReversalDetailsResult {

    @XmlElement(name = "ProviderCreditReversalDetails")
    protected ProviderCreditReversalDetails providerCreditReversalDetails;


    public GetProviderCreditReversalDetailsResult() {
        super();
    }

    public ProviderCreditReversalDetails getProviderCreditReversalDetails() {
        return providerCreditReversalDetails;
    }

}
