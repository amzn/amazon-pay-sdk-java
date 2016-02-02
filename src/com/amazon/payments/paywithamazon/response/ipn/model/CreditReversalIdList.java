package com.amazon.payments.paywithamazon.response.ipn.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditReversalIdList", propOrder = {
    "id"
})
public class CreditReversalIdList {

    @XmlElement(name="Id" , required = true)
    protected List<String> id;

    /**
     * Default constructor
     * 
     */
    public CreditReversalIdList() {
        super();
    }


    public CreditReversalIdList(final List<String> id) {
        this.id = id;
    }

    public List<String> getId() {
        if (id == null) {
            id = new ArrayList<String>();
        }
        return this.id;
    }

    @Override
    public String toString() {
        return "IdList{" + "id=" + id + '}';
    }

 
}
