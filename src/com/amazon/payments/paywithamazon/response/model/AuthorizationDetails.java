/**
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorizationDetails", propOrder = {
    "amazonAuthorizationId",
    "authorizationReferenceId",
    "authorizationBillingAddress",
    "sellerAuthorizationNote",
    "authorizationAmount",
    "capturedAmount",
    "authorizationFee",
    "idList",
    "creationTimestamp",
    "expirationTimestamp",
    "authorizationStatus",
    "orderItemCategories",
    "captureNow",
    "softDescriptor",
    "addressVerificationCode",
    "softDecline"

})
public class AuthorizationDetails {

    @XmlElement(name = "AmazonAuthorizationId", required = true)
    protected String amazonAuthorizationId;
    @XmlElement(name = "AuthorizationReferenceId", required = true)
    protected String authorizationReferenceId;
    @XmlElement(name = "AuthorizationBillingAddress")
    protected Address authorizationBillingAddress;
    @XmlElement(name = "SellerAuthorizationNote", required = true)
    protected String sellerAuthorizationNote;
    @XmlElement(name = "AuthorizationAmount", required = true)
    protected Price authorizationAmount;
    @XmlElement(name = "CapturedAmount", required = true)
    protected Price capturedAmount;
    @XmlElement(name = "AuthorizationFee", required = true)
    protected Price authorizationFee;
    @XmlElement(name = "IdList", required = true)
    protected IdList idList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "ExpirationTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTimestamp;
    @XmlElement(name = "AuthorizationStatus", required = true)
    protected Status authorizationStatus;
    @XmlElement(name = "OrderItemCategories", required = true)
    protected OrderItemCategories orderItemCategories;
    @XmlElement(name = "CaptureNow")
    protected boolean captureNow;
    @XmlElement(name = "SoftDescriptor", required = true)
    protected String softDescriptor;
    @XmlElement(name = "AddressVerificationCode")
    protected String addressVerificationCode;
    @XmlElement(name = "SoftDecline")
    protected boolean softDecline;

    public AuthorizationDetails() {
        super();
    }

    /**
     *
     * @return The Amazon-generated identifier for this authorization transaction.
     */
    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    /**
     * The identifier for this authorization transaction that you specify.
     * @return
     */
    public String getAuthorizationReferenceId() {
        return authorizationReferenceId;
    }

    /**
     *
     * @return authorizationBillingAddress
     */
    public Address getAuthorizationBillingAddress() {
        return authorizationBillingAddress;
    }

    /**
     *
     * @return A description for the authorization transaction that is displayed in emails to the buyer.
     */
    public String getSellerAuthorizationNote() {
        return sellerAuthorizationNote;
    }

    /**
     *
     * @return The amount to be authorized.
     */
    public Price getAuthorizationAmount() {
        return authorizationAmount;
    }

    /**
     *
     * @return The total amount that has been captured on this authorization.
     */
    public Price getCapturedAmount() {
        return capturedAmount;
    }

    /**
     *
     * @return The fee that was charged by Amazon for this authorization.
     */
    public Price getAuthorizationFee() {
        return authorizationFee;
    }

    /**
     *
     * @return A list of AmazonCaptureId identifiers that have been requested
     * on this Authorization object. This list is empty if you have not
     * requested any captures on this authorization.
     */
    public IdList getIdList() {
        return idList;
    }

    /**
     * @return The time at which the authorization was created. In ISO 8601 format.
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     *
     * @return The time when the authorization expires and no further
     * captures can be requested against the authorization. In ISO 8601 format.
     */
    public XMLGregorianCalendar getExpirationTimestamp() {
        return expirationTimestamp;
    }

    /**
     *
     * @return Describes the current status of the authorization.
     */
    public Status getAuthorizationStatus() {
        return authorizationStatus;
    }

    /**
     *
     * @return orderItemCategories
     */
    public OrderItemCategories getOrderItemCategories() {
        return orderItemCategories;
    }

    /**
     *
     * @return Indicates whether you specified a direct capture against the
     * order reference. The captured amount will be disbursed to your account
     * in the next disbursement cycle.
     */
    public boolean isCaptureNow() {
        return captureNow;
    }

    /**
     *
     * @return The description to be shown on the buyer's payment instrument
     * statement if CaptureNow was set to true.
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     *
     * @return addressVerificationCode
     */
    public String getAddressVerificationCode() {
        return addressVerificationCode;
    }

    /**
     * @return Indicates whether an authorization resulted in a soft decline. If true, the authorization
     * resulted in a soft decline and may be successful if you try again.
     * If false, the authorization was a hard decline, and you should contact the buyer to update their
     * information.
     */
    public boolean isSoftDecline() {
        return softDecline;
    }

    /**
     * String representation of Authorization Details
     */
    @Override
    public String toString() {
        return "AuthorizationDetails{" + "amazonAuthorizationId=" + amazonAuthorizationId
                + ", authorizationReferenceId=" + authorizationReferenceId + ", authorizationBillingAddress="
                + authorizationBillingAddress + ", sellerAuthorizationNote=" + sellerAuthorizationNote
                + ", authorizationAmount=" + authorizationAmount + ", capturedAmount=" + capturedAmount
                + ", authorizationFee=" + authorizationFee + ", idList=" + idList + ", creationTimestamp="
                + creationTimestamp + ", expirationTimestamp=" + expirationTimestamp + ", authorizationStatus="
                + authorizationStatus + ", orderItemCategories=" + orderItemCategories + ", captureNow="
                + captureNow + ", softDescriptor=" + softDescriptor + ", addressVerificationCode="
                + addressVerificationCode +", softDecline="  + softDecline + '}';
    }

}
