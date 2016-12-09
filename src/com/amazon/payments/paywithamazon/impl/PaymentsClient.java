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
package com.amazon.payments.paywithamazon.impl;

import com.amazon.payments.paywithamazon.Client;
import com.amazon.payments.paywithamazon.Config;
import com.amazon.payments.paywithamazon.exceptions.AmazonClientException;
import com.amazon.payments.paywithamazon.exceptions.AmazonServiceException;
import com.amazon.payments.paywithamazon.request.AuthorizeOnBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.AuthorizeRequest;
import com.amazon.payments.paywithamazon.request.CancelOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.CaptureRequest;
import com.amazon.payments.paywithamazon.request.ChargeRequest;
import com.amazon.payments.paywithamazon.request.CloseAuthorizationRequest;
import com.amazon.payments.paywithamazon.request.CloseBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.CloseOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.ConfirmBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.ConfirmOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.CreateOrderReferenceForIdRequest;
import com.amazon.payments.paywithamazon.request.GetAuthorizationDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetBillingAgreementDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetCaptureDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetProviderCreditDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetProviderCreditReversalDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetRefundDetailsRequest;
import com.amazon.payments.paywithamazon.request.RefundRequest;
import com.amazon.payments.paywithamazon.request.RequestHelper;
import com.amazon.payments.paywithamazon.request.ReverseProviderCreditRequest;
import com.amazon.payments.paywithamazon.request.SetBillingAgreementDetailsRequest;
import com.amazon.payments.paywithamazon.request.SetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.request.ValidateBillingAgreementRequest;
import com.amazon.payments.paywithamazon.response.model.AuthorizationDetails;
import com.amazon.payments.paywithamazon.response.model.BillingAgreementDetails;
import com.amazon.payments.paywithamazon.response.model.CaptureDetails;
import com.amazon.payments.paywithamazon.response.model.Environment;
import com.amazon.payments.paywithamazon.response.model.OrderReferenceDetails;
import com.amazon.payments.paywithamazon.response.model.RefundDetails;
import com.amazon.payments.paywithamazon.response.parser.AuthorizeOnBillingAgreementResponseData;
import com.amazon.payments.paywithamazon.response.parser.AuthorizeResponseData;
import com.amazon.payments.paywithamazon.response.parser.CancelOrderReferenceResponseData;
import com.amazon.payments.paywithamazon.response.parser.CaptureResponseData;
import com.amazon.payments.paywithamazon.response.parser.CloseAuthorizationResponseData;
import com.amazon.payments.paywithamazon.response.parser.CloseBillingAgreementResponseData;
import com.amazon.payments.paywithamazon.response.parser.CloseOrderReferenceResponseData;
import com.amazon.payments.paywithamazon.response.parser.CreateOrderReferenceForIdResponseData;
import com.amazon.payments.paywithamazon.response.parser.ConfirmBillingAgreementResponseData;
import com.amazon.payments.paywithamazon.response.parser.ConfirmOrderReferenceResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetAuthorizationDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetBillingAgreementDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetCaptureDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetOrderReferenceDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetPaymentDetails;
import com.amazon.payments.paywithamazon.response.parser.GetProviderCreditDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetProviderCreditReversalDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetRefundDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetServiceStatusResponseData;
import com.amazon.payments.paywithamazon.response.parser.Parser;
import com.amazon.payments.paywithamazon.response.parser.RefundResponseData;
import com.amazon.payments.paywithamazon.response.parser.ResponseData;
import com.amazon.payments.paywithamazon.response.parser.ReverseProviderCreditResponseData;
import com.amazon.payments.paywithamazon.response.parser.SetBillingAgreementDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.SetOrderReferenceDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.ValidateBillingAgreementResponseData;
import com.amazon.payments.paywithamazon.types.AmazonReferenceIdType;
import com.amazon.payments.paywithamazon.types.ServiceConstants;
import com.amazon.payments.paywithamazon.types.User;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Client for accessing Pay with Amazon API.
 */
public class PaymentsClient implements Client  {

    private final RequestHelper helper;
    private final PaymentsConfig paymentsConfig;

    /**
     * Constructs a new client to invoke service methods on
     * Amazon Payments API using the specified MWS account credentials.
     *
     * @param config The client configuration includes MWS account credentials
     *        and control options how this client connects to Amazon Payments
     */
    public PaymentsClient(Config config) {
        this.paymentsConfig = (PaymentsConfig)config;
        this.helper = new RequestHelper(this.paymentsConfig);
    }



    /**
     * The GetServiceStatus operation returns the operational status of the Pay with Amazon API
     * section of Amazon Marketplace Web Service (Amazon MWS).
     * Documentation: https://payments.amazon.com/developer/documentation/apireference/201752110
     *
     * @return The response from the GetServiceStatus service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetServiceStatusResponseData getServiceStatus()
            throws AmazonServiceException {
        final ResponseData rawResponse = sendRequest(helper.getPostURLGetServiceStatus());
        return Parser.getServiceStatus(rawResponse);
    }


    /**
     * The CreateOrderReferenceForId operation is used to create an Order Reference object from
     * the object represented by the Id and IdType request parameters.
     *
     * Documentation: https://payments.amazon.com/developer/documentation/apireference/201751670
     *
     * @param createOrderReferenceForIdRequest Container for the necessary
     *           parameters to execute the GetOrderReferenceDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the CreateOrderReferenceForId service API, as
     *         returned by Amazon Payments.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public CreateOrderReferenceForIdResponseData createOrderReferenceForId(
            CreateOrderReferenceForIdRequest createOrderReferenceForIdRequest)
            throws AmazonServiceException {
        final ResponseData rawResponse = sendRequest(helper.getPostURL(
            createOrderReferenceForIdRequest));
        return Parser.createOrderReferenceForId(rawResponse);
    }


    /**
     * The GetOrderReferenceDetails operation returns details about the
     * Order Reference object and its current state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751970
     *
     * @param getOrderReferenceDetailsRequest Container for the necessary
     *           parameters to execute the GetOrderReferenceDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the GetOrderReferenceDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetOrderReferenceDetailsResponseData getOrderReferenceDetails(GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest(helper.getPostURL(getOrderReferenceDetailsRequest));
        return Parser.getOrderReferenceDetails(rawResponse);
    }


    /**
     * Invoke the getPaymentDetails convenience method which calls several API calls:
     * GetOrderReferenceDetails, GetAuthorizationDetails, GetCaptureDetails, GetRefundDetails.
     *
     * @param orderReferenceID the Order Reference of which to obtain all payment details
     *
     * @return The response from the four API calls packaged in an object for easy processing
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetPaymentDetails getPaymentDetails(String orderReferenceID) throws AmazonServiceException {
        GetPaymentDetails paymentDetails = new GetPaymentDetails();

        GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest = new GetOrderReferenceDetailsRequest(orderReferenceID);
        OrderReferenceDetails orderReferenceResponse = getOrderReferenceDetails(getOrderReferenceDetailsRequest).getDetails();

        try {
            paymentDetails.putOrderReferenceDetails(orderReferenceID, orderReferenceResponse);
            List<String> amazon_authorization_id = orderReferenceResponse.getIdList().getMember();

            for (String authorizeID : amazon_authorization_id) {
                    GetAuthorizationDetailsRequest getAuthDetailsRequest = new GetAuthorizationDetailsRequest(authorizeID);
                    AuthorizationDetails responseAuthorize = getAuthorizationDetails(getAuthDetailsRequest).getDetails();
                    paymentDetails.putAuthorizationDetails(authorizeID, responseAuthorize);

                    List<String> amazon_capture_id = responseAuthorize.getIdList().getMember();

                    for (String captureID : amazon_capture_id) {
                            GetCaptureDetailsRequest getCaptureDetailsRequest = new GetCaptureDetailsRequest(captureID);
                            CaptureDetails responseCapture = getCaptureDetails(getCaptureDetailsRequest).getDetails();
                            paymentDetails.putCaptureDetails(captureID, responseCapture);

                            List<String> amazon_refund_id = responseCapture.getIdList().getMember();

                            for (String refundID : amazon_refund_id) {
                                    GetRefundDetailsRequest getRefundDetailsRequest = new GetRefundDetailsRequest(refundID);
                                    RefundDetails responseRefund = getRefundDetails(getRefundDetailsRequest).getDetails();
                                    paymentDetails.putRefundDetails(refundID, responseRefund);
                            }
                     }
            }

        } catch (Exception e) {
            throw new AmazonClientException("Encountered Exception: ", e);
        }
        return paymentDetails;
    }



    /**
     * Call the SetOrderReferenceDetails operation to specify order details
     * such as the amount of the order,
     * a description of the order, and other order attributes.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751960
     *
     * @param setOrderReferenceDetailsRequest Container for the necessary
     *           parameters to execute the SetOrderReferenceDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the SetOrderReferenceDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public SetOrderReferenceDetailsResponseData setOrderReferenceDetails(SetOrderReferenceDetailsRequest setOrderReferenceDetailsRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest(helper.getPostURL(setOrderReferenceDetailsRequest));
        return Parser.setOrderReferenceDetails(rawResponse);
    }


    /**
     * The Authorize operation reserves a specified amount against the payment
     * methods stored in the order reference. To charge the payment methods,
     * you must either set the CaptureNow request parameter to true, or call the
     * Capture operation after you call this operation. An authorization is only
     * valid for a particular time period, which is specified in the response of
     * the operation.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752010
     *
     *
     * @param authorizeRequest Container for the necessary
     *           parameters to execute the Authorize service API on
     *           Amazon Payments.
     *
     * @return The response from the Authorize service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public AuthorizeResponseData authorize(AuthorizeRequest authorizeRequest) throws AmazonServiceException   {
        ResponseData rawResponse = sendRequest(helper.getPostURL(authorizeRequest));
        return Parser.getAuthorizeData(rawResponse);
    }



    /**
     * Call the GetAuthorizationDetails operation to query the status of a particular authorization
     * and to retrieve information about the total amount captured on the authorization.
     * If you received a Pending status when you called the Authorize operation,
     * you can call this operation to get the current status.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752030
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the GetAuthorizationDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the GetAuthorizationDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetAuthorizationDetailsResponseData getAuthorizationDetails(GetAuthorizationDetailsRequest request) throws AmazonServiceException   {
        ResponseData rawResponse = sendRequest(helper.getPostURL(request));
        return Parser.getAuthorizationDetailsData(rawResponse);
    }



    /**
     * Call the Capture operation to capture funds from an authorized payment instrument.
     * To successfully capture a payment, you must call this operation on an Authorization object
     * before it expires, as specified by the ExpirationTimestamp returned in response of the Authorize operation call.
     * You must specify a capture amount, and the amount cannot exceed the original amount that was authorized.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752040
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the Capture service API on
     *           Amazon Payments.
     *
     * @return The response from the Capture service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public CaptureResponseData capture(CaptureRequest request) throws AmazonServiceException   {
        ResponseData rawResponse = sendRequest(helper.getPostURL(request));
        return Parser.getCapture(rawResponse);
    }



    /**
     * Call the GetCaptureDetails operation to capture funds from an authorized payment instrument.
     * To successfully capture a payment, you must call this operation on an Authorization object
     * before it expires, as specified by the ExpirationTimestamp returned in response of the Authorize operation call.
     * You must specify a capture amount, and the amount cannot exceed the original amount that was authorized.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752060
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the GetCaptureDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the GetCaptureDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetCaptureDetailsResponseData getCaptureDetails(GetCaptureDetailsRequest request) throws AmazonServiceException   {
        ResponseData rawResponse = sendRequest(helper.getPostURL(request));
        return Parser.getCaptureDetailsData(rawResponse);
    }





    /**
     * Call the ConfirmOrderReference operation after the order reference is free of
     * constraints and all required information has been set on the order reference.
     * After you call this operation, the order reference is set to the Open state and
     * you can submit authorizations against the order reference.
     * Documentation; https://payments.amazon.com/documentation/apireference/201751630#201751980
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the ConfirmOrderReference service API on
     *           Amazon Payments.
     *
     * @return The response from the ConfirmOrderReference service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public ConfirmOrderReferenceResponseData  confirmOrderReference(ConfirmOrderReferenceRequest request) throws AmazonServiceException  {
        ResponseData rawResponse = sendRequest(helper.getPostURL(request));
        return Parser.confirmOrderReference(rawResponse);
    }



    /**
     * Call the CloseAuthorization operation to close an authorization after the
     * total amount of the authorization has been captured.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752070
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the CloseAuthorization service API on
     *           Amazon Payments.
     *
     * @return The response from the CloseAuthorization service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public CloseAuthorizationResponseData closeAuthorization(CloseAuthorizationRequest request) throws AmazonServiceException  {
        ResponseData rawResponse = sendRequest(helper.getPostURL(request));
        return Parser.closeAuthorizationResponse(rawResponse);
    }






    /**
     * Call the CancelOrderReference operation to cancel a previously confirmed order reference.
     * You can cancel an Order Reference object only if there are no Completed, Closed, or Pending
     * captures against it. If you cancel an order reference, all authorizations associated with
     * this order reference are also closed.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751990
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the CancelOrderReference service API on
     *           Amazon Payments.
     *
     * @return The response from the CancelOrderReference service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public CancelOrderReferenceResponseData cancelOrderReference(CancelOrderReferenceRequest request) throws AmazonServiceException  {
        ResponseData rawResponse = sendRequest(helper.getPostURL(request));
        return Parser.getCancelOrderReference(rawResponse);
    }



    /**
     * Call the CloseOrderReference operation to indicate that a previously confirmed order reference
     * has been fulfilled (fully or partially) and that you do not expect to create any new
     * authorizations on this order reference. You can still capture funds against open
     * authorizations on the order reference.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752000
     *
     *
     * @param closeOrderReferenceRequest Container for the necessary
     *           parameters to execute the CloseOrderReference service API on
     *           Amazon Payments.
     *
     * @return The response from the CloseOrderReference service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public CloseOrderReferenceResponseData closeOrderReference(CloseOrderReferenceRequest closeOrderReferenceRequest) throws AmazonServiceException  {
        ResponseData rawResponse = sendRequest(helper.getPostURL(closeOrderReferenceRequest));
        return Parser.getCloseOrderReference(rawResponse);
    }





    /**
     * Call the Refund operation to refund a previously captured amount. You call the
     * GetRefundDetails operation to query the status of a refund.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752080
     *
     *
     * @param refundRequest Container for the necessary
     *           parameters to execute the Refund service API on
     *           Amazon Payments.
     *
     * @return The response from the Refund service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public RefundResponseData refund(RefundRequest refundRequest) throws AmazonServiceException  {
        ResponseData rawResponse = sendRequest(helper.getPostURL(refundRequest));
        return Parser.getRefundData(rawResponse);
    }





    /**
     * Call the GetRefundDetails operation to query the status of a particular refund.
     * If you received a Pending status when you called the Refund operation,
     * you can call this operation to get the current status.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752100
     *
     *
     * @param getRefundDetailsRequest Container for the necessary
     *           parameters to execute the GetRefundDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the GetRefundDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetRefundDetailsResponseData getRefundDetails(GetRefundDetailsRequest getRefundDetailsRequest) throws AmazonServiceException  {
        ResponseData rawResponse = sendRequest(helper.getPostURL(getRefundDetailsRequest));
        return Parser.getRefundDetailsData(rawResponse);
    }



    /**
     * The GetBillingAgreementDetails operation returns details about the Billing
     * Agreement object and its current state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751690
     *
     *
     * @param getBillingAgreementDetailsRequest Container for the necessary
     *           parameters to execute the GetBillingAgreementDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the GetBillingAgreementDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetBillingAgreementDetailsResponseData getBillingAgreementDetails(GetBillingAgreementDetailsRequest getBillingAgreementDetailsRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest(helper.getPostURL(getBillingAgreementDetailsRequest));
        return Parser.getBillingAgreementDetailsData(rawResponse);
    }




    /**
     * Call the SetBillingAgreementDetails operation to specify billing agreement
     * details such as a description of the agreement and other information about the merchant.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751700
     *
     *
     * @param setBillingAgreementDetailsRequest Container for the necessary
     *           parameters to execute the SetBillingAgreementDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the SetBillingAgreementDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public SetBillingAgreementDetailsResponseData setBillingAgreementDetails(SetBillingAgreementDetailsRequest setBillingAgreementDetailsRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest(helper.getPostURL(setBillingAgreementDetailsRequest));
        return Parser.getSetBillingAgreementDetailsResponse(rawResponse);
    }





    /**
     * Call the ValidateBillingAgreement operation when the billing agreement moves to the
     * Open state (that is, after a successful call to the ConfirmBillingAgreement operation).
     * This operation validates the status of the billing agreement and the validity of the
     * payment method associated with the billing agreement.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751720
     *
     *
     * @param validateBillingAgreementRequest Container for the necessary
     *           parameters to execute the ValidateBillingAgreement service API on
     *           Amazon Payments.
     *
     * @return The response from the ValidateBillingAgreement service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public ValidateBillingAgreementResponseData validateBillingAgreement(ValidateBillingAgreementRequest validateBillingAgreementRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest(helper.getPostURL(validateBillingAgreementRequest));
        return Parser.getValidateBillingAgreementResponse(rawResponse);
    }




    /**
     * Call the ConfirmBillingAgreement operation when the billing agreement is free of constraints,
     * indicating that all required information has been set on the billing agreement.
     * On successful completion of the ConfirmBillingAgreement call, the billing agreement
     * moves to the Open state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751710
     *
     *
     * @param confirmBillingAgreementRequest Container for the necessary
     *           parameters to execute the ConfirmBillingAgreement service API on
     *           Amazon Payments.
     *
     * @return The response from the ConfirmBillingAgreement service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public ConfirmBillingAgreementResponseData confirmBillingAgreement(ConfirmBillingAgreementRequest confirmBillingAgreementRequest) throws AmazonServiceException{
        ResponseData rawResponse = sendRequest(helper.getPostURL(confirmBillingAgreementRequest));
        return Parser.confirmBillingAgreementResponse(rawResponse);
    }




    /**
     * The AuthorizeOnBillingAgreement operation reserves a specified amount against the
     * payment methods stored in the billing agreement. To charge the payment methods,
     * you must either set the CaptureNow request parameter to true, or call the
     * Capture operation after you call this operation. An authorization is only valid for
     * a particular time period, which is specified in the response of the operation.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751940
     *
     *
     * @param authorizeOnBillingAgreementRequest Container for the necessary
     *           parameters to execute the AuthorizeOnBillingAgreement service API on
     *           Amazon Payments.
     *
     * @return The response from the AuthorizeOnBillingAgreement service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public AuthorizeOnBillingAgreementResponseData authorizeOnBillingAgreement(AuthorizeOnBillingAgreementRequest authorizeOnBillingAgreementRequest) throws AmazonServiceException{
        ResponseData rawResponse = sendRequest(helper.getPostURL(authorizeOnBillingAgreementRequest));
        return Parser.getAuthorizeOnBillingAgreement(rawResponse);
    }



    /**
     * Call the CloseBillingAgreement operation on a previously confirmed billing agreement to
     * indicate that you want to terminate the billing agreement with the buyer and that you
     * do not expect to create any new order references or authorizations on this billing agreement.
     * All open authorizations on the billing agreement can still be used to capture funds.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751950
     *
     *
     * @param closeBillingAgreementRequest Container for the necessary
     *           parameters to execute the CloseBillingAgreement service API on
     *           Amazon Payments.
     *
     * @return The response from the CloseBillingAgreement service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public  CloseBillingAgreementResponseData closeBillingAgreement(CloseBillingAgreementRequest closeBillingAgreementRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest(helper.getPostURL(closeBillingAgreementRequest));
        return Parser.closeBillingAgreementResponse(rawResponse);
    }




    /**
     * Call the GetProviderCreditReversalDetails operation for getting provider credit reversal details
     *
     *
     * @param getProviderCreditReversalDetailsRequest Container for the necessary
     *           parameters to execute the GetProviderCreditReversalDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the GetProviderCreditReversalDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetProviderCreditReversalDetailsResponseData  getProviderCreditReversalDetails(GetProviderCreditReversalDetailsRequest getProviderCreditReversalDetailsRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest(helper.getPostURL(getProviderCreditReversalDetailsRequest));
        return Parser.getProviderCreditReversalDetails(rawResponse);
    }





    /**
     * Call the GetProviderCreditDetails operation for getting provider credit reversal details
     *
     *
     * @param getProviderCreditDetailsRequest Container for the necessary
     *           parameters to execute the GetProviderCreditDetails service API on
     *           Amazon Payments.
     *
     * @return The response from the GetProviderCreditDetails service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetProviderCreditDetailsResponseData getProviderCreditDetails(GetProviderCreditDetailsRequest getProviderCreditDetailsRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest(helper.getPostURL(getProviderCreditDetailsRequest));
        return Parser.getGetProviderCreditDetails(rawResponse);
    }



    /**
     * Call the ReverseProviderCredit operation for getting provider credit reversal details
     *
     *
     * @param reverseProviderCreditRequest Container for the necessary
     *           parameters to execute the ReverseProviderCredit service API on
     *           Amazon Payments.
     *
     * @return The response from the ReverseProviderCredit service API, as
     *         returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public  ReverseProviderCreditResponseData reverseProviderCredit(ReverseProviderCreditRequest reverseProviderCreditRequest) throws AmazonServiceException {
        ResponseData rawResponse = sendRequest( helper.getPostURL(reverseProviderCreditRequest));
        return Parser.getReverseProviderCreditResponseData(rawResponse);
    }




    /**
     * This API call allows you to obtain user profile information once a user has
     * logged into your application using their Amazon credentials.
     *
     *
     * @param accessToken The access token is available in the return URL parameters after a user has logged in.
     * @param clientId Your client id is located in your Seller Central account.
     * @return User The response from the service API, as returned by Amazon Payments
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Payments indicating
     *             either a problem with the data in the request, or a server side issue.
     * @throws IOException
     */
    @Override
    public User getUserInfo(String accessToken , String clientId) throws AmazonServiceException, IOException {

        String decodedAccessToken = URLDecoder.decode(accessToken,"UTF-8");
        String profileEndpoint;

        if(paymentsConfig.getEnvironment() == Environment.SANDBOX) {
            profileEndpoint = ServiceConstants.profileEndpointSandboxMappings.get(paymentsConfig.getRegion());
        } else {
            profileEndpoint = ServiceConstants.profileEndpointMappings.get(paymentsConfig.getRegion());
        }

        Map<String,String> headerValues = new HashMap<String, String>();
        ResponseData response = Util.httpSendRequest("GET" , profileEndpoint + "/auth/o2/tokeninfo?access_token=" + decodedAccessToken , null , headerValues, null);

        Map m = Util.convertJsonToObject(response.toXML() , Map.class);
        if(m.containsKey("error")) {
            throw new AmazonServiceException("Retrieving User Info Failed. "+(String)m.get("error_description"));
        }

        if ( clientId == null || !clientId.equals(m.get("aud"))) {
            //the access token does not belong to us
            throw new AmazonClientException("Access token does not belong to clientId: " + clientId);
        }

        headerValues.put("Authorization" , "bearer " + decodedAccessToken);
        response = Util.httpSendRequest("GET" , profileEndpoint + "/user/profile" , null, headerValues);

        m = Util.convertJsonToObject(response.toXML() , Map.class);
        if(m.containsKey("error")) {
            throw new AmazonServiceException("Retrieving User Info Failed. "+(String)m.get("error_description"));
        }

        User user = Util.convertJsonToObject(response.toXML() , User.class);
        return user;
    }




    /**
     * This method combines multiple API calls to perform a complete transaction with minimum requirements.
     *
     * @param chargeRequest Container for the necessary parameters to call Charge method
     *
     * @return GetAuthorizationDetailsResponseData Returns the authorization details of the transaction
     *
     * @throws AmazonServiceException
     */
    @Override
    public GetAuthorizationDetailsResponseData charge(final ChargeRequest chargeRequest) throws AmazonServiceException {

        GetAuthorizationDetailsResponseData authDetails = null;
        AmazonReferenceIdType type = chargeRequest.getType();
        switch(type) {
            case ORDER_REFERENCE_ID:
                authDetails = chargeORO(chargeRequest);
                break;
            case BILLING_AGREEMENT_ID:
                authDetails = chargeBillingAgreement(chargeRequest);
                break;
            default:
                throw new AmazonClientException("Aborting..charge method failed to handle request");
        }
        return authDetails;
    }

    private GetAuthorizationDetailsResponseData chargeBillingAgreement(ChargeRequest chargeRequest) throws AmazonServiceException {

        GetAuthorizationDetailsResponseData authDetails = null;
        //set and confirm only in Draft state

        String amazonReferenceId = chargeRequest.getAmazonReferenceId();
        String mwsAuthToken = chargeRequest.getMwsAuthToken();
        String amount = chargeRequest.getAmount();

        BillingAgreementDetails res = getBillingAgreementDetails(new GetBillingAgreementDetailsRequest(amazonReferenceId).setMWSAuthToken(mwsAuthToken)).getDetails();
        String billingAgreementStatus = res.getBillingAgreementStatus().getState();
        if("Draft".equals(billingAgreementStatus)) {
            setBillingAgreementDetails(new SetBillingAgreementDetailsRequest(amazonReferenceId)
                    .setMWSAuthToken(mwsAuthToken)
                    .setCustomInformation(chargeRequest.getCustomInformation())
                    .setPlatformId(chargeRequest.getPlatformId())
                    .setSellerNote(chargeRequest.getSellerNote())
                    .setStoreName(chargeRequest.getStoreName())
                    .setSellerBillingAgreementId(chargeRequest.getChargeOrderId()));
        }

        confirmBillingAgreement(new ConfirmBillingAgreementRequest(amazonReferenceId).setMWSAuthToken(mwsAuthToken));

        //authorize only if in Open state
        BillingAgreementDetails postConfirmResponse = getBillingAgreementDetails(new GetBillingAgreementDetailsRequest(amazonReferenceId).setMWSAuthToken(mwsAuthToken)).getDetails();
        String postConfirmStatus = postConfirmResponse.getBillingAgreementStatus().getState();
        if("Open".equals(postConfirmStatus)) {
            AuthorizationDetails authResponse = authorizeOnBillingAgreement(new AuthorizeOnBillingAgreementRequest(amazonReferenceId, chargeRequest.getChargeReferenceId(), amount)
                    .setMWSAuthToken(mwsAuthToken)
                    .setCaptureNow(chargeRequest.getCaptureNow())
                    .setTransactionTimeout(chargeRequest.getTransactionTimeout())
                    .setPlatformId(chargeRequest.getPlatformId())
                    .setCustomInformation(chargeRequest.getCustomInformation())
                    .setStoreName(chargeRequest.getStoreName())
                    .setSellerNote(chargeRequest.getSellerNote())
                    .setSellerAuthorizationNote(chargeRequest.getSellerNote())
                    .setAuthorizationCurrencyCode(chargeRequest.getCurrencyCode())
                    .setSellerOrderId(chargeRequest.getChargeOrderId())
                    .setSoftDescriptor(chargeRequest.getSoftDescriptor())
                    .setInheritShippingAddress(chargeRequest.getInheritShippingAddress()))
                    .getDetails();
            String authId = authResponse.getAmazonAuthorizationId();
            authDetails = getAuthorizationDetails(new GetAuthorizationDetailsRequest(authId).setMWSAuthToken(mwsAuthToken));
        } else {
            throw new AmazonClientException("Billing Agreement is in "+ postConfirmStatus +" state, unable to authorize transaction: ");
        }
        return authDetails;

    }

    private GetAuthorizationDetailsResponseData chargeORO(ChargeRequest chargeRequest) throws AmazonServiceException {

        GetAuthorizationDetailsResponseData authDetails = null;

        String amazonReferenceId = chargeRequest.getAmazonReferenceId();
        String mwsAuthToken = chargeRequest.getMwsAuthToken();

        //call getOrderReferenceDetails 
        GetOrderReferenceDetailsRequest getOrderDetailsRequest = new GetOrderReferenceDetailsRequest(amazonReferenceId).setMWSAuthToken(mwsAuthToken);
        OrderReferenceDetails response = getOrderReferenceDetails(getOrderDetailsRequest).getDetails();

        //call setOrderReferenceDetails only in Draft state
        if("Draft".equals(response.getOrderReferenceStatus().getState())) {
            setOrderReferenceDetails(
                    new SetOrderReferenceDetailsRequest(amazonReferenceId , chargeRequest.getAmount())
                            .setMWSAuthToken(mwsAuthToken)
                            .setSellerOrderId(chargeRequest.getChargeOrderId())
                            .setStoreName(chargeRequest.getStoreName())
                            .setSellerNote(chargeRequest.getSellerNote())
                            .setCustomInformation(chargeRequest.getCustomInformation())
                            .setPlatformId(chargeRequest.getPlatformId())
                            .setOrderCurrencyCode(chargeRequest.getCurrencyCode()));
        }

        confirmOrderReference(new ConfirmOrderReferenceRequest(amazonReferenceId).setMWSAuthToken(mwsAuthToken));

        //authorize only if in Open state
        OrderReferenceDetails postConfirmResponse = getOrderReferenceDetails(getOrderDetailsRequest).getDetails();
        if("Open".equals(postConfirmResponse.getOrderReferenceStatus().getState())) {
            String authId = authorize(
                    new AuthorizeRequest(amazonReferenceId, chargeRequest.getChargeReferenceId() , chargeRequest.getAmount() )
                            .setMWSAuthToken(mwsAuthToken)
                            .setCaptureNow(chargeRequest.getCaptureNow())
                            .setTransactionTimeout(chargeRequest.getTransactionTimeout())
                            .setProviderCredit(chargeRequest.getProviderCredit())
                            .setSellerAuthorizationNote(chargeRequest.getSellerNote())
                            .setSoftDescriptor(chargeRequest.getSoftDescriptor())
                            .setProviderCredit(chargeRequest.getProviderCredit())
            ).getDetails().getAmazonAuthorizationId();
            authDetails = getAuthorizationDetails(new GetAuthorizationDetailsRequest(authId).setMWSAuthToken(mwsAuthToken));
        } else {
            //if not open state, throw exception
            throw new AmazonClientException("Order Reference is in "+ postConfirmResponse.getOrderReferenceStatus().getState() +" state, unable to authorize transaction: ");
        }

        return authDetails;
    }

    private ResponseData sendRequest(String httpPostRequest)  {
        ResponseData response = null;
        try {
            response = postRequest(httpPostRequest);
            int statusCode = response.getStatusCode();
            int retry = 0;
            //503 status code is returned when request is throttled and 500 is returned for InternalServerError
            while ((statusCode == 503  || statusCode == 500) && retry < 3 && paymentsConfig.isUseAutoRetryOnThrottle()) {
                retry++;
                //retry request 3 times
                if (retry == 1) {
                    Thread.sleep(ServiceConstants.FIRST_RETRY_WAIT_TIME);
                } else if (retry == 2) {
                    Thread.sleep(ServiceConstants.SECOND_RETRY_WAIT_TIME);
                } else if (retry == 3) {
                    Thread.sleep(ServiceConstants.THIRD_RETRY_WAIT_TIME);
                } else {
                    return null;
                }
                response = postRequest(httpPostRequest);
                statusCode = response.getStatusCode();
            }
        }catch (IOException e) {
            throw new AmazonClientException("Encountered IOException: ", e);
        } catch (InterruptedException ex) {
            throw new AmazonClientException("Encountered InterruptedException:", ex);
        }
        return response;
    }

    private ResponseData postRequest(String httpPostRequest) throws IOException {
        return Util.httpSendRequest("POST", Util.getServiceURLEndpoint(paymentsConfig.getRegion() , paymentsConfig.getEnvironment()), httpPostRequest, null, this.helper.paymentsConfig);
    }

}
