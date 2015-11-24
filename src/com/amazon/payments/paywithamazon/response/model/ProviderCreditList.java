package com.amazon.payments.paywithamazon.response.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditList", propOrder = {
    "member"
})
public class ProviderCreditList {

    @XmlElement(required = true)
    protected List<ProviderCredit> member;

    public ProviderCreditList() {
        super();
    }

    public ProviderCreditList(final List<ProviderCredit> member) {
        this.member = member;
    }

    public List<ProviderCredit> getMember() {
        if (member == null) {
            member = new ArrayList<ProviderCredit>();
        }
        return this.member;
    }

    @Override
    public String toString() {
        return "ProviderCreditList{" + "member=" + member + '}';
    }

    
}
