package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "closeBillingAgreementResult",
    "responseMetadata"
})
@XmlRootElement(name = "CloseBillingAgreementResponse")
public class CloseBillingAgreementResponse {

    @XmlElement(name = "CloseBillingAgreementResult", required = true)
    protected CloseBillingAgreementResult closeBillingAgreementResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public CloseBillingAgreementResponse() {
        super();
    }


    public CloseBillingAgreementResult getCloseBillingAgreementResult() {
        return closeBillingAgreementResult;
    }

    public void setCloseBillingAgreementResult(CloseBillingAgreementResult value) {
        this.closeBillingAgreementResult = value;
    }
    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }


    
}
