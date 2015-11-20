package com.amazon.payments.paywithamazon.response.model;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderItemCategories", propOrder = {
    "orderItemCategory"
})
public class OrderItemCategories {

    @XmlElement(name = "OrderItemCategory", required = true)
    protected List<String> orderItemCategory;

    /**
     * Default constructor
     * 
     */
    public OrderItemCategories() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public OrderItemCategories(final List<String> orderItemCategory) {
        this.orderItemCategory = orderItemCategory;
    }


    public List<String> getOrderItemCategory() {
        if (orderItemCategory == null) {
            orderItemCategory = new ArrayList<String>();
        }
        return this.orderItemCategory;
    }


}
