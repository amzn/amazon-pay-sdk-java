package com.amazon.payments.paywithamazon.response.ipn.model;

import com.amazon.payments.paywithamazon.response.model.SolutionProviderOptions;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantRegistrationDetails", propOrder = { "sellerId", "type", "options" })
public class MerchantRegistrationDetails {

    @XmlElement(name = "SellerId", required = true)
    public String sellerId;
    @XmlElement(name = "Type", required = true)
    public String type;
    @XmlElement(name = "Options", required = true)
    public SolutionProviderOptions options;

    public MerchantRegistrationDetails() {
        super();
    }

    public MerchantRegistrationDetails(final String sellerId, final String type,
            final SolutionProviderOptions options) {
        this.sellerId = sellerId;
        this.type = type;
        this.options = options;
    }

    /**
     * Returns the sellerId from MerchantRegistrationDetails
     * 
     * @return  Returns the sellerId from MerchantRegistrationDetails
     */
    public String getSellerId() {
        return sellerId;
    }


    /**
     * Returns the type from MerchantRegistrationDetails
     * 
     * @return Returns the type from MerchantRegistrationDetails
     */
    public String getType() {
        return type;
    }


    /**
     * Returns the options from MerchantRegistrationDetails
     * 
     * @return Returns the options from MerchantRegistrationDetails
     */
    public SolutionProviderOptions getOptions() {
        return options;
    }

    /**
     * Returns the string representation of MerchantRegistrationDetails
     * 
     * @return Returns the string representation of MerchantRegistrationDetails
     */
    @Override
    public String toString() {
        return "MerchantRegistrationDetails{" + "sellerId=" + sellerId + ", type=" + type + ", options=" 
                + options.toString() + '}';
    }


}
