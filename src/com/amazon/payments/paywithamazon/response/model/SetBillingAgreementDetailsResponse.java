package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "setBillingAgreementDetailsResult",
    "responseMetadata"
})
@XmlRootElement(name = "SetBillingAgreementDetailsResponse")
public class SetBillingAgreementDetailsResponse {

    @XmlElement(name = "SetBillingAgreementDetailsResult", required = true)
    protected SetBillingAgreementDetailsResult setBillingAgreementDetailsResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public SetBillingAgreementDetailsResponse() {
        super();
    }

    public SetBillingAgreementDetailsResult getSetBillingAgreementDetailsResult() {
        return setBillingAgreementDetailsResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }


}
