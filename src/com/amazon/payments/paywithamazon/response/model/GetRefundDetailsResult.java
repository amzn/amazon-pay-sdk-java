package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "refundDetails"
})
@XmlRootElement(name = "GetRefundDetailsResult")
public class GetRefundDetailsResult {

    @XmlElement(name = "RefundDetails", required = true)
    protected RefundDetails refundDetails;

    public GetRefundDetailsResult() {
        super();
    }


    public RefundDetails getRefundDetails() {
        return refundDetails;
    }

}
