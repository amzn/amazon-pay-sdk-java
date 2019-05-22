/**
 * Copyright 2016-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

/**
 * Encapsulates details about an Order Reference object and its current state.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderReferenceDetails", propOrder = {
        "amazonOrderReferenceId",
        "buyer",
        "orderTotal",
        "sellerNote",
        "platformId",
        "destination",
        "paymentDescriptor",
        "billingAddress",
        "releaseEnvironment",
        "sellerOrderAttributes",
        "orderReferenceStatus",
        "constraints",
        "creationTimestamp",
        "expirationTimestamp",
        "parentDetails",
        "idList",
        "orderLanguage",
        "requestPaymentAuthorization",
        "paymentServiceProviderAttributes",
        "paymentReference",
        "paymentAuthenticationStatus"
})
public class OrderReferenceDetails {

    @XmlElement(name = "AmazonOrderReferenceId", required = true)
    protected String amazonOrderReferenceId;
    @XmlElement(name = "Buyer", required = true)
    protected Buyer buyer;
    @XmlElement(name = "OrderTotal")
    protected OrderTotal orderTotal;
    @XmlElement(name = "SellerNote")
    protected String sellerNote;
    @XmlElement(name = "PlatformId")
    protected String platformId;
    @XmlElement(name = "Destination")
    protected Destination destination;
    @XmlElement(name = "PaymentDescriptor")
    protected  PaymentDescriptor paymentDescriptor;
    @XmlElement(name = "BillingAddress")
    protected BillingAddress billingAddress;
    @XmlElement(name = "ReleaseEnvironment", required = true)
    protected Environment releaseEnvironment;
    @XmlElement(name = "SellerOrderAttributes")
    protected SellerOrderAttributes sellerOrderAttributes;
    @XmlElement(name = "OrderReferenceStatus", required = true)
    protected OrderReferenceStatus orderReferenceStatus;
    @XmlElement(name = "Constraints")
    protected Constraints constraints;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "ExpirationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTimestamp;
    @XmlElement(name = "ParentDetails")
    protected ParentDetails parentDetails;
    @XmlElement(name = "IdList")
    protected IdList idList;
    @XmlElement(name = "OrderLanguage")
    protected String orderLanguage;
    @XmlElement(name = "RequestPaymentAuthorization")
    protected Boolean requestPaymentAuthorization;
    @XmlElement(name = "PaymentServiceProviderAttributes")
    protected PaymentServiceProviderAttributes paymentServiceProviderAttributes;
    @XmlElement(name = "PaymentReference")
    protected PaymentReference paymentReference;
    @XmlElement(name = "PaymentAuthenticationStatus")
    protected PaymentAuthenticationStatus paymentAuthenticationStatus;

    public OrderReferenceDetails() {
        super();
    }

    /**
     * The order reference identifier retrieved from the Amazon Button widget.
     *
     * @return amazonOrderReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * Provides details about the buyer. This information will only be returned
     * after you confirm the order reference.
     *
     * @return buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Represents the total amount for this Order Reference object.
     * This response element is not returned if you have not set it by
     * calling the SetOrderReferenceDetails operation.
     *
     * @return orderTotal
     */
    public OrderTotal getOrderTotal() {
        return orderTotal;
    }

    /**
     * Represents a description of the order that is displayed in emails to the
     * buyer. This response element is not returned if you have not set it by
     * calling the SetOrderReferenceDetails operation.
     *
     * @return sellerNote
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * Represents the SellerId of the Solution Provider that developed the
     * platform. This response element is not returned if you have not set
     * it by calling the SetOrderReferenceDetails operation.
     *
     * @return platformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Represents the address selected by the buyer through the AddressBook widget.
     * Complete buyer information will only be returned after you have confirmed
     * the order reference or have specified a valid AddressConsentToken in the
     * GetOrderReferenceDetails operation. Until then, only the City, StateOrRegion,
     * PostalCode, and CountryCode elements are returned.
     *
     * @return destination
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Represents the Payment details used by the buyer through the Wallet Widget.
     * It returns short description of the credit card and if it is the card they want
     * to use, place the order. If not, they change it and the short description of the
     * new card will be displayed.
     *
     * @return PaymentDescriptor
     */

    public PaymentDescriptor getPaymentDescriptor() {
        return paymentDescriptor;
    }

    /**
     *
     * @return billingAddress
     */
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
     * Provides more context about the order represented by this order reference.
     * This response element is not returned if you have not set it by calling
     * the SetOrderReferenceDetails operation.
     *
     * @return sellerOrderAttributes
     */
    public SellerOrderAttributes getSellerOrderAttributes() {
        return sellerOrderAttributes;
    }

    /**
     * Indicates the current status of the order reference.
     * For more information about the State and ReasonCode response elements, see Order Reference States and Reason Codes.
     *
     * @return orderReferenceStatus
     */
    public OrderReferenceStatus getOrderReferenceStatus() {
        return orderReferenceStatus;
    }

    /**
     * A list of constraints that indicates mandatory information that is missing or incorrect.
     * The presence of constraints indicates that the order reference is
     * not ready to be confirmed and cannot be used for payment operations.
     * For more information, see Order Reference Constraints.
     *
     * @return constraints
     */
    public Constraints getConstraints() {
        return constraints;
    }

    /**
     * The date and time, in UTC, when the order reference was created. In ISO 8601 format.
     *
     * @return creationTimestamp
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * The date and time, in UTC, when the order reference will expire and
     * will no longer be valid for authorization requests.
     *
     * @return expirationTimestamp
     */
    public XMLGregorianCalendar getExpirationTimestamp() {
        return expirationTimestamp;
    }

    /**
     *
     * @return parentDetails
     */
    public ParentDetails getParentDetails() {
        return parentDetails;
    }

    /**
     * A list of AmazonAuthorizationId identifiers that have been requested
     * on this Order Reference object. This list is empty if you have not requested
     * any authorizations on this order reference.
     *
     * @return idList
     */
    public IdList getIdList() {
        return idList;
    }

    /**
     *
     * @return orderLanguage
     */
    public String getOrderLanguage() {
        return orderLanguage;
    }

    /**
     *
     * @return requestPaymentAuthorization
     */
    public Boolean getRequestPaymentAuthorization() {
        return requestPaymentAuthorization;
    }

    /**
     *
     * @return paymentServiceProviderAttributes
     */
    public PaymentServiceProviderAttributes getPaymentServiceProviderAttributes() {
        return paymentServiceProviderAttributes;
    }

    /**
     *
     * @return paymentReference
     */
    public PaymentReference getPaymentReference() {
        return paymentReference;
    }

    /**
     *
     * @return paymentAuthenticationStatus
     */
    public PaymentAuthenticationStatus getPaymentAuthenticationStatus() {
        return paymentAuthenticationStatus;
    }

    /**
     * String representation of OrderReferenceDetails
     */
    @Override
    public String toString() {
        return "OrderReferenceDetails{"
                + "amazonOrderReferenceId=" + amazonOrderReferenceId
                + ", buyer=" + buyer
                + ", orderTotal=" + orderTotal
                + ", sellerNote=" + sellerNote
                + ", platformId=" + platformId
                + ", destination=" + destination
                + ", paymentDescriptor=" + paymentDescriptor
                + ", billingAddress=" + billingAddress
                + ", releaseEnvironment=" + releaseEnvironment
                + ", sellerOrderAttributes=" + sellerOrderAttributes
                + ", orderReferenceStatus=" + orderReferenceStatus
                + ", constraints=" + constraints
                + ", creationTimestamp=" + creationTimestamp
                + ", expirationTimestamp=" + expirationTimestamp
                + ", parentDetails=" + parentDetails
                + ", idList=" + idList
                + ", orderLanguage=" + orderLanguage
                + ", requestPaymentAuthorization=" + requestPaymentAuthorization
                + ", paymentServiceProviderAttributes=" + paymentServiceProviderAttributes
                + ", paymentReference=" + paymentReference
                + ", paymentAuthenticationStatus=" + paymentAuthenticationStatus
                + '}';
    }
}
