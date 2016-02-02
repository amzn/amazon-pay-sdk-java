package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Provides more context about an order that is represented by an Order Reference object.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellerOrderAttributes", propOrder = {
    "sellerOrderId",
    "storeName",
    "orderItemCategories",
    "customInformation"
})
public class SellerOrderAttributes {

    @XmlElement(name = "SellerOrderId")
    protected String sellerOrderId;
    @XmlElement(name = "StoreName")
    protected String storeName;
    @XmlElement(name = "OrderItemCategories")
    protected OrderItemCategories orderItemCategories;
    @XmlElement(name = "CustomInformation")
    protected String customInformation;

    public SellerOrderAttributes() {
        super();
    }


    /**
     * The merchant-specified identifier of this order. This is displayed to the 
     * buyer in their emails and transaction history on the Amazon Payments website.
     * 
     * @return sellerOrderId
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }


    /**
     * The identifier of the store from which the order was placed. This overrides 
     * the default value in Seller Central under Settings > Account Settings. 
     * It is displayed to the buyer in their emails and transaction history 
     * on the Amazon Payments website.
     * 
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }


    /**
     * 
     * @return orderItemCategories
     */
    public OrderItemCategories getOrderItemCategories() {
        return orderItemCategories;
    }


    /**
     * Any additional information that you want to include with this order reference.
     * 
     * @return customInformation
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * Returns string representation of SellerOrderAttributes
     */
    @Override
    public String toString() {
        return "SellerOrderAttributes{" + "sellerOrderId=" + sellerOrderId + ", storeName=" + storeName + ", orderItemCategories=" 
                + orderItemCategories.toString() + ", customInformation=" + customInformation + '}';
    }

}
