package com.amazon.payments.paywithamazon.response.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditReversalList", propOrder = {
    "member"
})
public class ProviderCreditReversalList {

    @XmlElement(required = true)
    protected List<ProviderCreditReversal> member;

    public ProviderCreditReversalList() {
        super();
    }

    public List<ProviderCreditReversal> getMember() {
        if (member == null) {
            member = new ArrayList<ProviderCreditReversal>();
        }
        return this.member;
    }

    @Override
    public String toString() {
        return "ProviderCreditReversalList{" + "member=" + member.toString() + '}';
    }


}
