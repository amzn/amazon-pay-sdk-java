package com.amazon.payments.paywithamazon.response.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdList", propOrder = {
    "member"
})
public class IdList {

    @XmlElement(required = true)
    protected List<String> member;

    /**
     * Default constructor
     * 
     */
    public IdList() {
        super();
    }


    public IdList(final List<String> member) {
        this.member = member;
    }

    public List<String> getMember() {
        if (member == null) {
            member = new ArrayList<String>();
        }
        return this.member;
    }

 
}
