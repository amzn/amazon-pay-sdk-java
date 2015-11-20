package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authorizeOnBillingAgreementResult",
    "responseMetadata"
})
@XmlRootElement(name = "AuthorizeOnBillingAgreementResponse")
public class AuthorizeOnBillingAgreementResponse {

    @XmlElement(name = "AuthorizeOnBillingAgreementResult", required = true)
    protected AuthorizeOnBillingAgreementResult authorizeOnBillingAgreementResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public AuthorizeOnBillingAgreementResponse() {
        super();
    }


    public AuthorizeOnBillingAgreementResult getAuthorizeOnBillingAgreementResult() {
        return authorizeOnBillingAgreementResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

}
