package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Provides more context about an agreement that is represented by a Billing Agreement object.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellerBillingAgreementAttributes", propOrder = {
    "sellerBillingAgreementId",
    "storeName",
    "customInformation"
})
public class SellerBillingAgreementAttributes {

    @XmlElement(name = "SellerBillingAgreementId")
    protected String sellerBillingAgreementId;
    @XmlElement(name = "StoreName")
    protected String storeName;
    @XmlElement(name = "CustomInformation")
    protected String customInformation;

    public SellerBillingAgreementAttributes() {
        super();
    }

    /**
     * The merchant-specified identifier of this billing agreement.
     * 
     * @return sellerBillingAgreementId
     */
    public String getSellerBillingAgreementId() {
        return sellerBillingAgreementId;
    }


    /**
     * The identifier of the store from which the order was placed. This 
     * overrides the default value in Seller Central under Settings > Account Settings.
     * It is displayed to the buyer in their emails and transaction history on the Amazon Payments website.
     * 
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }


    /**
     * Any additional information that you wish to include with this billing agreement.
     * 
     * @return customInformation
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * Returns the string representation of SellerBillingAgreementAttributes
     */
    @Override
    public String toString() {
        return "SellerBillingAgreementAttributes{" + "sellerBillingAgreementId=" + sellerBillingAgreementId + ", storeName=" + storeName + ", customInformation=" + customInformation + '}';
    }


 
 
}
