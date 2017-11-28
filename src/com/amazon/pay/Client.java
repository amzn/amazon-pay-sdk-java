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
package com.amazon.pay;

import com.amazon.pay.exceptions.AmazonServiceException;
import com.amazon.pay.request.AuthorizeOnBillingAgreementRequest;
import com.amazon.pay.request.AuthorizeRequest;
import com.amazon.pay.request.CancelOrderReferenceRequest;
import com.amazon.pay.request.CaptureRequest;
import com.amazon.pay.request.ChargeRequest;
import com.amazon.pay.request.CloseAuthorizationRequest;
import com.amazon.pay.request.CloseBillingAgreementRequest;
import com.amazon.pay.request.CloseOrderReferenceRequest;
import com.amazon.pay.request.ConfirmBillingAgreementRequest;
import com.amazon.pay.request.ConfirmOrderReferenceRequest;
import com.amazon.pay.request.CreateOrderReferenceForIdRequest;
import com.amazon.pay.request.GetAuthorizationDetailsRequest;
import com.amazon.pay.request.GetBillingAgreementDetailsRequest;
import com.amazon.pay.request.GetCaptureDetailsRequest;
import com.amazon.pay.request.GetOrderReferenceDetailsRequest;
import com.amazon.pay.request.GetProviderCreditDetailsRequest;
import com.amazon.pay.request.GetProviderCreditReversalDetailsRequest;
import com.amazon.pay.request.GetRefundDetailsRequest;
import com.amazon.pay.request.RefundRequest;
import com.amazon.pay.request.ReverseProviderCreditRequest;
import com.amazon.pay.request.SetBillingAgreementDetailsRequest;
import com.amazon.pay.request.SetOrderReferenceDetailsRequest;
import com.amazon.pay.request.ValidateBillingAgreementRequest;
import com.amazon.pay.request.ListOrderReferenceRequest;
import com.amazon.pay.request.ListOrderReferenceByNextTokenRequest;
import com.amazon.pay.request.SetOrderAttributesRequest;
import com.amazon.pay.response.parser.AuthorizeOnBillingAgreementResponseData;
import com.amazon.pay.response.parser.AuthorizeResponseData;
import com.amazon.pay.response.parser.CancelOrderReferenceResponseData;
import com.amazon.pay.response.parser.CaptureResponseData;
import com.amazon.pay.response.parser.CloseAuthorizationResponseData;
import com.amazon.pay.response.parser.CloseBillingAgreementResponseData;
import com.amazon.pay.response.parser.CloseOrderReferenceResponseData;
import com.amazon.pay.response.parser.ConfirmBillingAgreementResponseData;
import com.amazon.pay.response.parser.ConfirmOrderReferenceResponseData;
import com.amazon.pay.response.parser.CreateOrderReferenceForIdResponseData;
import com.amazon.pay.response.parser.GetAuthorizationDetailsResponseData;
import com.amazon.pay.response.parser.GetBillingAgreementDetailsResponseData;
import com.amazon.pay.response.parser.GetCaptureDetailsResponseData;
import com.amazon.pay.response.parser.GetOrderReferenceDetailsResponseData;
import com.amazon.pay.response.parser.GetPaymentDetails;
import com.amazon.pay.response.parser.GetProviderCreditDetailsResponseData;
import com.amazon.pay.response.parser.GetProviderCreditReversalDetailsResponseData;
import com.amazon.pay.response.parser.GetRefundDetailsResponseData;
import com.amazon.pay.response.parser.ListOrderReferenceResponseData;
import com.amazon.pay.response.parser.ListOrderReferenceByNextTokenResponseData;
import com.amazon.pay.response.parser.RefundResponseData;
import com.amazon.pay.response.parser.ReverseProviderCreditResponseData;
import com.amazon.pay.response.parser.GetServiceStatusResponseData;
import com.amazon.pay.response.parser.SetBillingAgreementDetailsResponseData;
import com.amazon.pay.response.parser.SetOrderAttributesResponseData;
import com.amazon.pay.response.parser.SetOrderReferenceDetailsResponseData;
import com.amazon.pay.response.parser.ValidateBillingAgreementResponseData;
import com.amazon.pay.types.User;
import java.io.IOException;

public interface Client {

    /**
     * The Authorize operation reserves a specified amount against the payment
     * methods stored in the order reference. To charge the payment methods,
     * you must either set the CaptureNow request parameter to true, or call the
     * Capture operation after you call this operation. An authorization is only
     * valid for a particular time period, which is specified in the response of
     * the operation.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752010
     *
     * @param authorizeRequest Container for the necessary
     *           parameters to execute the Authorize service API on
     *           Amazon Pay.
     *
     * @return The response from the Authorize service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    AuthorizeResponseData authorize(AuthorizeRequest authorizeRequest) throws AmazonServiceException;

    /**
     * The AuthorizeOnBillingAgreement operation reserves a specified amount against the
     * payment methods stored in the billing agreement. To charge the payment methods,
     * you must either set the CaptureNow request parameter to true, or call the
     * Capture operation after you call this operation. An authorization is only valid for
     * a particular time period, which is specified in the response of the operation.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751940
     *
     * @param authorizeOnBillingAgreementRequest Container for the necessary
     *           parameters to execute the AuthorizeOnBillingAgreement service API on
     *           Amazon Pay.
     *
     * @return The response from the AuthorizeOnBillingAgreement service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    AuthorizeOnBillingAgreementResponseData authorizeOnBillingAgreement(AuthorizeOnBillingAgreementRequest authorizeOnBillingAgreementRequest) throws AmazonServiceException;

    /**
     * Call the CancelOrderReference operation to cancel a previously confirmed order reference.
     * You can cancel an Order Reference object only if there are no Completed, Closed, or Pending
     * captures against it. If you cancel an order reference, all authorizations associated with
     * this order reference are also closed.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751990
     *
     * @param request Container for the necessary
     *           parameters to execute the CancelOrderReference service API on
     *           Amazon Pay.
     *
     * @return The response from the CancelOrderReference service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    CancelOrderReferenceResponseData cancelOrderReference(CancelOrderReferenceRequest request) throws AmazonServiceException;

    /**
     * Call the Capture operation to capture funds from an authorized payment instrument.
     * To successfully capture a payment, you must call this operation on an Authorization object
     * before it expires, as specified by the ExpirationTimestamp returned in response of the Authorize operation call.
     * You must specify a capture amount, and the amount cannot exceed the original amount that was authorized.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752040
     *
     * @param request Container for the necessary
     *           parameters to execute the Capture service API on
     *           Amazon Pay.
     *
     * @return The response from the Capture service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    CaptureResponseData capture(CaptureRequest request) throws AmazonServiceException;

    /**
     * This method combines multiple API calls to perform
     * a complete transaction with minimum requirements.
     *
     * @param chargeRequest Container for the necessary
     *                parameters to execute the Charge request service API on
     *                Amazon Pay
     *
     * @return GetAuthorizationDetailsResponseData
     *              Returns the authorization details of the transaction
     *
     * @throws AmazonServiceException
     */
    GetAuthorizationDetailsResponseData charge(final ChargeRequest chargeRequest) throws AmazonServiceException;

    /**
     * Call the CloseAuthorization operation to close an authorization after the
     * total amount of the authorization has been captured.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752070
     *
     * @param request Container for the necessary
     *           parameters to execute the CloseAuthorization service API on
     *           Amazon Pay.
     *
     * @return The response from the CloseAuthorization service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    CloseAuthorizationResponseData closeAuthorization(CloseAuthorizationRequest request) throws AmazonServiceException;

    /**
     * Call the CloseBillingAgreement operation on a previously confirmed billing agreement to
     * indicate that you want to terminate the billing agreement with the buyer and that you
     * do not expect to create any new order references or authorizations on this billing agreement.
     * All open authorizations on the billing agreement can still be used to capture funds.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751950
     *
     * @param closeBillingAgreementRequest Container for the necessary
     *           parameters to execute the CloseBillingAgreement service API on
     *           Amazon Pay.
     *
     * @return The response from the CloseBillingAgreement service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    CloseBillingAgreementResponseData closeBillingAgreement(CloseBillingAgreementRequest closeBillingAgreementRequest) throws AmazonServiceException;

    /**
     * Call the CloseOrderReference operation to indicate that a previously confirmed order reference
     * has been fulfilled (fully or partially) and that you do not expect to create any new
     * authorizations on this order reference. You can still capture funds against open
     * authorizations on the order reference.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752000
     *
     * @param closeOrderReferenceRequest Container for the necessary
     *           parameters to execute the CloseOrderReference service API on
     *           Amazon Pay.
     *
     * @return The response from the CloseOrderReference service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    CloseOrderReferenceResponseData closeOrderReference(CloseOrderReferenceRequest closeOrderReferenceRequest) throws AmazonServiceException;

    /**
     * Call the ConfirmBillingAgreement operation when the billing agreement is free of constraints,
     * indicating that all required information has been set on the billing agreement.
     * On successful completion of the ConfirmBillingAgreement call, the billing agreement
     * moves to the Open state.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751710
     *
     * @param confirmBillingAgreementRequest Container for the necessary
     *           parameters to execute the ConfirmBillingAgreement service API on
     *           Amazon Pay.
     *
     * @return The response from the ConfirmBillingAgreement service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    ConfirmBillingAgreementResponseData confirmBillingAgreement(ConfirmBillingAgreementRequest confirmBillingAgreementRequest) throws AmazonServiceException;

    /**
     * Call the ConfirmOrderReference operation after the order reference is free of
     * constraints and all required information has been set on the order reference.
     * After you call this operation, the order reference is set to the Open state and
     * you can submit authorizations against the order reference.
     * Documentation; https://pay.amazon.com/documentation/apireference/201751630#201751980
     *
     * @param request Container for the necessary
     *           parameters to execute the ConfirmOrderReference service API on
     *           Amazon Pay.
     *
     * @return The response from the ConfirmOrderReference service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    ConfirmOrderReferenceResponseData confirmOrderReference(ConfirmOrderReferenceRequest request) throws AmazonServiceException;

    /**
     * The CreateOrderReferenceForId operation is used to create an Order Reference object from
     * the object represented by the Id and IdType request parameters.
     *
     * Documentation: https://pay.amazon.com/developer/documentation/apireference/201751670
     *
     * @param createOrderReferenceForIdRequest Container for the necessary
     *           parameters to execute the GetOrderReferenceDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the CreateOrderReferenceForId service API, as
     *         returned by Amazon Pay.
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    CreateOrderReferenceForIdResponseData createOrderReferenceForId(
            CreateOrderReferenceForIdRequest createOrderReferenceForIdRequest)
            throws AmazonServiceException;

    /**
     * Call the GetAuthorizationDetails operation to query the status of a particular authorization
     * and to retrieve information about the total amount captured on the authorization.
     * If you received a Pending status when you called the Authorize operation,
     * you can call this operation to get the current status.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752030
     *
     * @param request Container for the necessary
     *           parameters to execute the GetAuthorizationDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetAuthorizationDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetAuthorizationDetailsResponseData getAuthorizationDetails(GetAuthorizationDetailsRequest request) throws AmazonServiceException;

    /**
     * The GetBillingAgreementDetails operation returns details about the Billing
     * Agreement object and its current state.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751690
     *
     * @param getBillingAgreementDetailsRequest Container for the necessary
     *           parameters to execute the GetBillingAgreementDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetBillingAgreementDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetBillingAgreementDetailsResponseData getBillingAgreementDetails(GetBillingAgreementDetailsRequest getBillingAgreementDetailsRequest) throws AmazonServiceException;

    /**
     * Call the GetCaptureDetails operation to capture funds from an authorized payment instrument.
     * To successfully capture a payment, you must call this operation on an Authorization object
     * before it expires, as specified by the ExpirationTimestamp returned in response of the Authorize operation call.
     * You must specify a capture amount, and the amount cannot exceed the original amount that was authorized.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752060
     *
     * @param request Container for the necessary
     *           parameters to execute the GetCaptureDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetCaptureDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetCaptureDetailsResponseData getCaptureDetails(GetCaptureDetailsRequest request) throws AmazonServiceException;

    /**
     * The GetOrderReferenceDetails operation returns details about the
     * Order Reference object and its current state.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751970
     *
     * @param getOrderReferenceDetailsRequest Container for the necessary
     *           parameters to execute the GetOrderReferenceDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetOrderReferenceDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetOrderReferenceDetailsResponseData getOrderReferenceDetails(GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest) throws AmazonServiceException;


    /**
     * Invoke the getPaymentDetails convenience method which calls several API calls:
     * GetOrderReferenceDetails, GetAuthorizationDetails, GetCaptureDetails, GetRefundDetails.
     *
     * @param orderReferenceID the Order Reference of which to obtain all payment details
     *        The authorization token that you received when you registered for Amazon MWS.
     *        Required For web applications and third-party developer authorizations only.
     *
     * @return The response from the four API calls packaged in an object for easy processing
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetPaymentDetails getPaymentDetails(String orderReferenceID, String MWSAuthToken) throws AmazonServiceException;

    /**
     * Invoke the getPaymentDetails convenience method which calls several API calls:
     * GetOrderReferenceDetails, GetAuthorizationDetails, GetCaptureDetails, GetRefundDetails.
     *
     * @param orderReferenceID the Order Reference of which to obtain all payment details
     *
     * @return The response from the four API calls packaged in an object for easy processing
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetPaymentDetails getPaymentDetails(String orderReferenceID) throws AmazonServiceException;

    /**
     * Call the GetProviderCreditDetails operation for getting provider credit reversal details
     *
     * @param getProviderCreditDetailsRequest Container for the necessary
     *           parameters to execute the GetProviderCreditDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetProviderCreditDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetProviderCreditDetailsResponseData getProviderCreditDetails(GetProviderCreditDetailsRequest getProviderCreditDetailsRequest) throws AmazonServiceException;

    /**
     * Call the GetProviderCreditReversalDetails operation for getting provider credit reversal details
     *
     * @param getProviderCreditReversalDetailsRequest Container for the necessary
     *           parameters to execute the GetProviderCreditReversalDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetProviderCreditReversalDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetProviderCreditReversalDetailsResponseData getProviderCreditReversalDetails(GetProviderCreditReversalDetailsRequest getProviderCreditReversalDetailsRequest) throws AmazonServiceException;

    /**
     * Call the GetRefundDetails operation to query the status of a particular refund.
     * If you received a Pending status when you called the Refund operation,
     * you can call this operation to get the current status.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752100
     *
     * @param getRefundDetailsRequest Container for the necessary
     *           parameters to execute the GetRefundDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetRefundDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetRefundDetailsResponseData getRefundDetails(GetRefundDetailsRequest getRefundDetailsRequest) throws AmazonServiceException;

    /**
     * The GetServiceStatus operation returns the operational status of the Pay with Amazon API
     * section of Amazon Marketplace Web Service (Amazon MWS).
     * Documentation: https://pay.amazon.com/developer/documentation/apireference/201752110
     *
     * @return The response from the GetServiceStatus service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    GetServiceStatusResponseData getServiceStatus() throws AmazonServiceException;

    /**
     * This API call allows you to obtain user profile information once a user has
     * logged into your application using their Amazon credentials.
     *
     * @param accessToken The access token is available in the return URL parameters after a user has logged in.
     * @param clientId Your client id is located in your Seller Central account.
     * @return User The response from the service API, as returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     * @throws IOException
     */
    User getUserInfo(String accessToken, String clientId) throws AmazonServiceException, IOException;

    /**
     * Call the Refund operation to refund a previously captured amount. You call the
     * GetRefundDetails operation to query the status of a refund.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752080
     *
     * @param refundRequest Container for the necessary
     *           parameters to execute the Refund service API on
     *           Amazon Pay.
     *
     * @return The response from the Refund service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    RefundResponseData refund(RefundRequest refundRequest) throws AmazonServiceException;

    /**
     * Call the ReverseProviderCredit operation for getting provider credit reversal details
     *
     * @param reverseProviderCreditRequest Container for the necessary
     *           parameters to execute the ReverseProviderCredit service API on
     *           Amazon Pay.
     *
     * @return The response from the ReverseProviderCredit service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    ReverseProviderCreditResponseData reverseProviderCredit(ReverseProviderCreditRequest reverseProviderCreditRequest) throws AmazonServiceException;

    /**
     * Call the SetBillingAgreementDetails operation to specify billing agreement
     * details such as a description of the agreement and other information about the merchant.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751700
     *
     * @param setBillingAgreementDetailsRequest Container for the necessary
     *           parameters to execute the SetBillingAgreementDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the SetBillingAgreementDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    SetBillingAgreementDetailsResponseData setBillingAgreementDetails(SetBillingAgreementDetailsRequest setBillingAgreementDetailsRequest) throws AmazonServiceException;

    /**
     * Call the SetOrderReferenceDetails operation to specify order details
     * such as the amount of the order,
     * a description of the order, and other order attributes.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751960
     *
     * @param setOrderReferenceDetailsRequest Container for the necessary
     *           parameters to execute the SetOrderReferenceDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the SetOrderReferenceDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    SetOrderReferenceDetailsResponseData setOrderReferenceDetails(SetOrderReferenceDetailsRequest setOrderReferenceDetailsRequest) throws AmazonServiceException;

    /**
     * Call the ValidateBillingAgreement operation when the billing agreement moves to the
     * Open state (that is, after a successful call to the ConfirmBillingAgreement operation).
     * This operation validates the status of the billing agreement and the validity of the
     * payment method associated with the billing agreement.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201751720
     *
     * @param validateBillingAgreementRequest Container for the necessary
     *           parameters to execute the ValidateBillingAgreement service API on
     *           Amazon Pay.
     *
     * @return The response from the ValidateBillingAgreement service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    ValidateBillingAgreementResponseData validateBillingAgreement(ValidateBillingAgreementRequest validateBillingAgreementRequest) throws AmazonServiceException;

    /**
     * Accessor method for PayConfig configuration object
     *
     * @return Config client configuration object
     *
     * @throws AmazonServiceException
     */
    Config getConfig();

    /**
     * The ListOrderReference operation is used to list all the order reference objects from
     * the object represented by the QueryId and QueryIdType request parameters.
     *
     * @param listOrderReferenceRequest Container for the necessary
     *           parameters to execute the ListOrderReference service API on
     *           Amazon Pay.
     *
     * @return The response from the ListOrderReference service API, as
     *         returned by Amazon Pay.
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    ListOrderReferenceResponseData listOrderReference(
            ListOrderReferenceRequest listOrderReferenceRequest)
            throws AmazonServiceException;

    /**
     * The ListOrderReferenceByNextToken operation is used to list all the order reference objects from
     * the object represented by the next page token request parameter.
     *
     * @param listOrderReferenceByNextTokenRequest Container for the necessary
     *           parameters to execute the ListOrderReferenceByNextToken service API on
     *           Amazon Pay.
     *
     * @return The response from the ListOrderReferenceByNextToken service API, as
     *         returned by Amazon Pay.
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListOrderReferenceByNextTokenResponseData listOrderReferenceByNextToken(
            ListOrderReferenceByNextTokenRequest listOrderReferenceByNextTokenRequest)
            throws AmazonServiceException;

    /**
     * The SetOrderAttributes operation is used to set order attributes even after
     * the order has been confirmed.
     *
     * @param  setOrderAttributesRequest Container for the necessary
     *           parameters to execute the SetOrderAttributes service API on
     *           Amazon Pay.
     *
     * @return The response from the SetOrderAttributes service API, as
     *         returned by Amazon Pay.
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public SetOrderAttributesResponseData setOrderAttributes(
            SetOrderAttributesRequest setOrderAttributesRequest)
            throws AmazonServiceException;

}
