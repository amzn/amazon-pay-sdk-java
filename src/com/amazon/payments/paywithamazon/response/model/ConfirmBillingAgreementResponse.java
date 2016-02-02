package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "confirmBillingAgreementResult",
    "responseMetadata"
})
@XmlRootElement(name = "ConfirmBillingAgreementResponse")
public class ConfirmBillingAgreementResponse {

    @XmlElement(name = "ConfirmBillingAgreementResult", required = true)
    protected ConfirmBillingAgreementResult confirmBillingAgreementResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public ConfirmBillingAgreementResponse() {
        super();
    }

    public ConfirmBillingAgreementResult getConfirmBillingAgreementResult() {
        return confirmBillingAgreementResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }


}
