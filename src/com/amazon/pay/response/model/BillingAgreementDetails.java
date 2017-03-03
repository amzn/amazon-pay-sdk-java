/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAgreementDetails", propOrder = {
    "amazonBillingAgreementId",
    "billingAgreementLimits",
    "buyer",
    "sellerNote",
    "platformId",
    "destination",
    "billingAddress",
    "releaseEnvironment",
    "sellerBillingAgreementAttributes",
    "billingAgreementStatus",
    "constraints",
    "creationTimestamp",
    "expirationTimestamp",
    "billingAgreementConsent",
    "orderLanguage"
})
public class BillingAgreementDetails {

    @XmlElement(name = "AmazonBillingAgreementId", required = true)
    protected String amazonBillingAgreementId;
    @XmlElement(name = "BillingAgreementLimits")
    protected BillingAgreementLimits billingAgreementLimits;
    @XmlElement(name = "Buyer", required = true)
    protected Buyer buyer;
    @XmlElement(name = "SellerNote")
    protected String sellerNote;
    @XmlElement(name = "PlatformId")
    protected String platformId;
    @XmlElement(name = "Destination")
    protected Destination destination;
    @XmlElement(name = "BillingAddress")
    protected BillingAddress billingAddress;
    @XmlElement(name = "ReleaseEnvironment", required = true)
    protected Environment releaseEnvironment;
    @XmlElement(name = "SellerBillingAgreementAttributes")
    protected SellerBillingAgreementAttributes sellerBillingAgreementAttributes;
    @XmlElement(name = "BillingAgreementStatus", required = true)
    protected BillingAgreementStatus billingAgreementStatus;
    @XmlElement(name = "Constraints")
    protected Constraints constraints;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "ExpirationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTimestamp;
    @XmlElement(name = "BillingAgreementConsent")
    protected Boolean billingAgreementConsent;
    @XmlElement(name = "OrderLanguage")
    protected String orderLanguage;
    

    public BillingAgreementDetails() {
        super();
    }

    /**
     * This value is retrieved from the Amazon Button, AddressBook, or Wallet widgets.
     * 
     * @return amazonBillingAgreementId
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }


    /**
     * Represents the total amount that you can charge a buyer in a given time period.
     * 
     * @return billingAgreementLimits
     */
    public BillingAgreementLimits getBillingAgreementLimits() {
        return billingAgreementLimits;
    }

    /**
     * Provides details about the buyer. This information will 
     * only be returned after you confirm the billing agreement.
     * 
     * @return buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Represents a description of the billing agreement that is displayed 
     * in emails to the buyer and on the Amazon Pay website. This response
     * element is not returned if you have not set it by calling the 
     * SetBillingAgreementDetails operation.
     * 
     * @return sellerNote
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * Represents the SellerId of the Solution Provider that developed the platform.
     * 
     * @return platformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * 
     * Represents the address selected by the buyer through the AddressBook widget. 
     * Complete buyer information will only be returned after you have confirmed the 
     * billing agreement or have specified a valid AddressConsentToken in the 
     * GetBillingAgreementDetails operation. Until then, only the City, StateOrRegion,
     * PostalCode, and CountryCode elements are returned.
     * 
     * @return destination
     */
    public Destination getDestination() {
        return destination;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * Indicates if the order is for a Live (Production) or Sandbox environment.
     * 
     * @return releaseEnvironment
     */
    public Environment getReleaseEnvironment() {
        return releaseEnvironment;
    }

    /**
     * Provides more context about the billing agreement represented by this Billing Agreement object. 
     * This response element is not returned if you have not set it by calling the 
     * SetBillingAgreementDetails operation.
     * 
     * @return sellerBillingAgreementAttributes
     */
    public SellerBillingAgreementAttributes getSellerBillingAgreementAttributes() {
        return sellerBillingAgreementAttributes;
    }

    /**
     * Indicates the current status of the billing agreement. 
     * For more information about the State and ReasonCode response elements, 
     * see Billing Agreement States and Reason Codes.
     * 
     * @return billingAgreementStatus
     */
    public BillingAgreementStatus getBillingAgreementStatus() {
        return billingAgreementStatus;
    }

    /**
     * A list of constraints that indicates mandatory information that is missing 
     * or incorrect. The presence of constraints indicates that the billing agreement 
     * is not ready to be confirmed and cannot be used for payment operations.
     * 
     * @return constraints
     */
    public Constraints getConstraints() {
        return constraints;
    }

    /**
     * The date and time, in UTC, when the billing agreement was created. In ISO 8601 format.
     * 
     * @return creationTimestamp
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * 
     * @return expirationTimestamp
     */
    public XMLGregorianCalendar getExpirationTimestamp() {
        return expirationTimestamp;
    }

    /**
     * Indicates the current buyer's consent for the billing agreement.
     * @return billingAgreementConsent
     */
    public Boolean isBillingAgreementConsent() {
        return billingAgreementConsent;
    }

    /**
     * 
     * @return orderLanguage
     */
    public String getOrderLanguage() {
        return orderLanguage;
    }

    /**
     * String representation of Billing Agreement
     */
    @Override
    public String toString() {
        return "BillingAgreementDetails{"
                + "amazonBillingAgreementId=" + amazonBillingAgreementId
                + ", billingAgreementLimits=" + billingAgreementLimits
                + ", buyer=" + buyer
                + ", sellerNote=" + sellerNote
                + ", platformId=" + platformId
                + ", destination=" + destination
                + ", billingAddress=" + billingAddress
                + ", releaseEnvironment=" + releaseEnvironment
                + ", sellerBillingAgreementAttributes=" + sellerBillingAgreementAttributes
                + ", billingAgreementStatus=" + billingAgreementStatus
                + ", constraints=" + constraints
                + ", creationTimestamp=" + creationTimestamp
                + ", expirationTimestamp=" + expirationTimestamp
                + ", billingAgreementConsent=" + billingAgreementConsent
                + ", orderLanguage=" + orderLanguage + '}';
    }


}