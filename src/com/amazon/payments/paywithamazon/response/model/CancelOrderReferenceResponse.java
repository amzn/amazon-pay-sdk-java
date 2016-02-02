package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cancelOrderReferenceResult",
    "responseMetadata"
})
@XmlRootElement(name = "CancelOrderReferenceResponse")
public class CancelOrderReferenceResponse {

    @XmlElement(name = "CancelOrderReferenceResult", required = true)
    protected CancelOrderReferenceResult cancelOrderReferenceResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public CancelOrderReferenceResponse() {
        super();
    }

    public CancelOrderReferenceResult getCancelOrderReferenceResult() {
        return cancelOrderReferenceResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }


}
