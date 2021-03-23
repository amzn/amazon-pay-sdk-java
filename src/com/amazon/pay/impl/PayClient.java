/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.impl;

import com.amazon.pay.Client;
import com.amazon.pay.Config;
import com.amazon.pay.exceptions.AmazonClientException;
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
import com.amazon.pay.request.GetMerchantAccountStatusRequest;
import com.amazon.pay.request.GetProviderCreditDetailsRequest;
import com.amazon.pay.request.GetProviderCreditReversalDetailsRequest;
import com.amazon.pay.request.GetRefundDetailsRequest;
import com.amazon.pay.request.ListOrderReferenceByNextTokenRequest;
import com.amazon.pay.request.ListOrderReferenceRequest;
import com.amazon.pay.request.RefundRequest;
import com.amazon.pay.request.RequestHelper;
import com.amazon.pay.request.ReverseProviderCreditRequest;
import com.amazon.pay.request.SetBillingAgreementDetailsRequest;
import com.amazon.pay.request.SetOrderAttributesRequest;
import com.amazon.pay.request.SetOrderReferenceDetailsRequest;
import com.amazon.pay.request.ValidateBillingAgreementRequest;
import com.amazon.pay.response.model.AuthorizationDetails;
import com.amazon.pay.response.model.BillingAgreementDetails;
import com.amazon.pay.response.model.CaptureDetails;
import com.amazon.pay.response.model.Environment;
import com.amazon.pay.response.model.OrderReferenceDetails;
import com.amazon.pay.response.model.RefundDetails;
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
import com.amazon.pay.response.parser.GetMerchantAccountStatusResponseData;
import com.amazon.pay.response.parser.GetPaymentDetails;
import com.amazon.pay.response.parser.GetProviderCreditDetailsResponseData;
import com.amazon.pay.response.parser.GetProviderCreditReversalDetailsResponseData;
import com.amazon.pay.response.parser.GetRefundDetailsResponseData;
import com.amazon.pay.response.parser.GetServiceStatusResponseData;
import com.amazon.pay.response.parser.ListOrderReferenceByNextTokenResponseData;
import com.amazon.pay.response.parser.ListOrderReferenceResponseData;
import com.amazon.pay.response.parser.Parser;
import com.amazon.pay.response.parser.RefundResponseData;
import com.amazon.pay.response.parser.ResponseData;
import com.amazon.pay.response.parser.ReverseProviderCreditResponseData;
import com.amazon.pay.response.parser.SetBillingAgreementDetailsResponseData;
import com.amazon.pay.response.parser.SetOrderAttributesResponseData;
import com.amazon.pay.response.parser.SetOrderReferenceDetailsResponseData;
import com.amazon.pay.response.parser.ValidateBillingAgreementResponseData;
import com.amazon.pay.types.AmazonReferenceIdType;
import com.amazon.pay.types.ServiceConstants;
import com.amazon.pay.types.User;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Client for accessing Amazon Pay API.
 */
public class PayClient implements Client  {

    private final RequestHelper helper;
    private final PayConfig payConfig;

    /**
     * Constructs a new client to invoke service methods on
     * Amazon Pay API using the specified MWS account credentials.
     *
     * @param config The client configuration includes MWS account credentials
     *        and control options how this client connects to Amazon Pay
     */
    public PayClient(Config config) {
        this.payConfig = (PayConfig)config;
        this.helper = new RequestHelper(this.payConfig);
    }



    /**
     * The GetServiceStatus operation returns the operational status of the Amazon Pay API
     * section of Amazon Marketplace Web Service (Amazon MWS).
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/getservicestatus.html
     *
     * @return The response from the GetServiceStatus service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/createorderreferenceforid.html
     *
     * @param createOrderReferenceForIdRequest Container for the necessary
     *           parameters to execute the GetOrderReferenceDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the CreateOrderReferenceForId service API, as
     *         returned by Amazon Pay.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/getorderreferencedetails.html
     *
     * @param getOrderReferenceDetailsRequest Container for the necessary
     *           parameters to execute the GetOrderReferenceDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetOrderReferenceDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetPaymentDetails getPaymentDetails(String orderReferenceID) throws AmazonServiceException {
        return getPaymentDetails(orderReferenceID, null);
    }


    /**
     * Invoke the getPaymentDetails convenience method which calls several API calls:
     * GetOrderReferenceDetails, GetAuthorizationDetails, GetCaptureDetails, GetRefundDetails.
     *
     * @param orderReferenceID the Order Reference of which to obtain all payment details
     * The authorization token that you received when you registered for Amazon MWS.
     *        Required For web applications and third-party developer authorizations only.
     *
     * @return The response from the four API calls packaged in an object for easy processing
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetPaymentDetails getPaymentDetails(
            String orderReferenceID,
            String MWSAuthToken)
            throws AmazonServiceException {
        GetPaymentDetails paymentDetails = new GetPaymentDetails();

        final GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest =
                new GetOrderReferenceDetailsRequest(orderReferenceID).setMWSAuthToken(MWSAuthToken);
        final OrderReferenceDetails orderReferenceResponse = getOrderReferenceDetails(getOrderReferenceDetailsRequest).getDetails();

        paymentDetails.putOrderReferenceDetails(orderReferenceID, orderReferenceResponse);
        if (orderReferenceResponse.getIdList() != null) {
            final List<String> amazonAuthorizations = orderReferenceResponse.getIdList().getMember();

            for (String authorizeId : amazonAuthorizations) {
                final GetAuthorizationDetailsRequest getAuthDetailsRequest =
                        new GetAuthorizationDetailsRequest(authorizeId).setMWSAuthToken(MWSAuthToken);
                final AuthorizationDetails responseAuthorize = getAuthorizationDetails(getAuthDetailsRequest).getDetails();
                paymentDetails.putAuthorizationDetails(authorizeId, responseAuthorize);

                if (responseAuthorize.getIdList() != null) {
                    final List<String> amazonCaptures = responseAuthorize.getIdList().getMember();

                    for (String captureId : amazonCaptures) {
                        final GetCaptureDetailsRequest getCaptureDetailsRequest =
                                new GetCaptureDetailsRequest(captureId).setMWSAuthToken(MWSAuthToken);
                        final CaptureDetails responseCapture = getCaptureDetails(getCaptureDetailsRequest).getDetails();
                        paymentDetails.putCaptureDetails(captureId, responseCapture);

                        if (responseCapture.getIdList() != null) {
                            final List<String> amazonRefunds = responseCapture.getIdList().getMember();

                            for (String refundId : amazonRefunds) {
                                final GetRefundDetailsRequest getRefundDetailsRequest =
                                        new GetRefundDetailsRequest(refundId).setMWSAuthToken(MWSAuthToken);
                                final RefundDetails responseRefund = getRefundDetails(getRefundDetailsRequest).getDetails();
                                paymentDetails.putRefundDetails(refundId, responseRefund);
                            }
                        }
                    }
                }
            }
        }

        return paymentDetails;
    }


    /**
     * Call the SetOrderReferenceDetails operation to specify order details
     * such as the amount of the order,
     * a description of the order, and other order attributes.
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/setorderreferencedetails.html
     *
     * @param setOrderReferenceDetailsRequest Container for the necessary
     *           parameters to execute the SetOrderReferenceDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the SetOrderReferenceDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/authorize.html
     *
     *
     * @param authorizeRequest Container for the necessary
     *           parameters to execute the Authorize service API on
     *           Amazon Pay.
     *
     * @return The response from the Authorize service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/getauthorizationdetails.html
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the GetAuthorizationDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetAuthorizationDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/capture.html
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the Capture service API on
     *           Amazon Pay.
     *
     * @return The response from the Capture service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/getcapturedetails.html
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the GetCaptureDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetCaptureDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/confirmorderreference.html
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the ConfirmOrderReference service API on
     *           Amazon Pay.
     *
     * @return The response from the ConfirmOrderReference service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/closeauthorization.html
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the CloseAuthorization service API on
     *           Amazon Pay.
     *
     * @return The response from the CloseAuthorization service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/cancelorderreference.html
     *
     *
     * @param request Container for the necessary
     *           parameters to execute the CancelOrderReference service API on
     *           Amazon Pay.
     *
     * @return The response from the CancelOrderReference service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/closeorderreference.html
     *
     *
     * @param closeOrderReferenceRequest Container for the necessary
     *           parameters to execute the CloseOrderReference service API on
     *           Amazon Pay.
     *
     * @return The response from the CloseOrderReference service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/refund.html
     *
     *
     * @param refundRequest Container for the necessary
     *           parameters to execute the Refund service API on
     *           Amazon Pay.
     *
     * @return The response from the Refund service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/getrefunddetails.html
     *
     *
     * @param getRefundDetailsRequest Container for the necessary
     *           parameters to execute the GetRefundDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetRefundDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/getbillingagreementdetails.html
     *
     *
     * @param getBillingAgreementDetailsRequest Container for the necessary
     *           parameters to execute the GetBillingAgreementDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the GetBillingAgreementDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/setbillingagreementdetails.html
     *
     *
     * @param setBillingAgreementDetailsRequest Container for the necessary
     *           parameters to execute the SetBillingAgreementDetails service API on
     *           Amazon Pay.
     *
     * @return The response from the SetBillingAgreementDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/validatebillingagreement.html
     *
     *
     * @param validateBillingAgreementRequest Container for the necessary
     *           parameters to execute the ValidateBillingAgreement service API on
     *           Amazon Pay.
     *
     * @return The response from the ValidateBillingAgreement service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/confirmbillingagreement.html
     *
     *
     * @param confirmBillingAgreementRequest Container for the necessary
     *           parameters to execute the ConfirmBillingAgreement service API on
     *           Amazon Pay.
     *
     * @return The response from the ConfirmBillingAgreement service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/authorizeonbillingagreement.html
     *
     *
     * @param authorizeOnBillingAgreementRequest Container for the necessary
     *           parameters to execute the AuthorizeOnBillingAgreement service API on
     *           Amazon Pay.
     *
     * @return The response from the AuthorizeOnBillingAgreement service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/closebillingagreement.html
     *
     *
     * @param closeBillingAgreementRequest Container for the necessary
     *           parameters to execute the CloseBillingAgreement service API on
     *           Amazon Pay.
     *
     * @return The response from the CloseBillingAgreement service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     *           Amazon Pay.
     *
     * @return The response from the GetProviderCreditReversalDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     *           Amazon Pay.
     *
     * @return The response from the GetProviderCreditDetails service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     *           Amazon Pay.
     *
     * @return The response from the ReverseProviderCredit service API, as
     *         returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
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
     * @return User The response from the service API, as returned by Amazon Pay
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     * @throws IOException
     *             If an IO Exception response is thrown.
     */
    @Override
    public User getUserInfo(String accessToken , String clientId) throws AmazonServiceException, IOException {

        final String decodedAccessToken = URLDecoder.decode(accessToken, ServiceConstants.UTF_8);
        String profileEndpoint;

        if (payConfig.getOverrideProfileURL() != null) {
            profileEndpoint = payConfig.getOverrideProfileURL();
        } else {
            if (payConfig.getEnvironment() == Environment.SANDBOX) {
                profileEndpoint = ServiceConstants.profileEndpointSandboxMappings.get(payConfig.getRegion());
            } else {
                profileEndpoint = ServiceConstants.profileEndpointMappings.get(payConfig.getRegion());
            }
        }

        Map<String,String> headerValues = new HashMap<String, String>();
        headerValues.put(ServiceConstants.X_AMZ_ACCESS_TOKEN, decodedAccessToken);
        ResponseData response = Util.httpSendRequest(ServiceConstants.GET, profileEndpoint + ServiceConstants.AUTH_O2_TOKENINFO_URI, null, headerValues, null);

        Map m = Util.convertJsonToObject(response.toXML(), Map.class);
        if (m.containsKey(ServiceConstants.ERROR)) {
            throw new AmazonServiceException("Retrieving User Info Failed. " + (String)m.get(ServiceConstants.ERROR_DESCRIPTION));
        }

        if (clientId == null || !clientId.equals(m.get("aud"))) {
            //the access token does not belong to us
            throw new AmazonClientException("Access token does not belong to clientId: " + clientId);
        }

        response = Util.httpSendRequest(ServiceConstants.GET , profileEndpoint + ServiceConstants.USER_PROFILE_URI, null, headerValues);
        m = Util.convertJsonToObject(response.toXML() , Map.class);
        if (m.containsKey(ServiceConstants.ERROR)) {
            throw new AmazonServiceException("Retrieving User Info Failed. " + (String)m.get(ServiceConstants.ERROR_DESCRIPTION));
        }

        final User user = Util.convertJsonToObject(response.toXML() , User.class);
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
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
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
    @Override
    public ListOrderReferenceResponseData listOrderReference(
            ListOrderReferenceRequest listOrderReferenceRequest)
            throws AmazonServiceException {
        final ResponseData rawResponse = sendRequest(helper.getPostURL(
                listOrderReferenceRequest));
        return Parser.listOrderReference(rawResponse);
    }

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
    @Override
    public ListOrderReferenceByNextTokenResponseData listOrderReferenceByNextToken(
            ListOrderReferenceByNextTokenRequest listOrderReferenceByNextTokenRequest)
            throws AmazonServiceException {
        final ResponseData rawResponse = sendRequest(helper.getPostURL(
                listOrderReferenceByNextTokenRequest));
        return Parser.listOrderReferenceByNextToken(rawResponse);
    }

    /**
     * The SetOrderAttributes operation is used to set order attributes even after
     * the order has been confirmed.
     * Documentation: https://developer.amazon.com/docs/amazon-pay-api/setorderattributes.html
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
    @Override
    public SetOrderAttributesResponseData setOrderAttributes(
            SetOrderAttributesRequest setOrderAttributesRequest)
            throws AmazonServiceException {
        final ResponseData rawResponse = sendRequest(helper.getPostURL(
                setOrderAttributesRequest));
        return Parser.setOrderAttributes(rawResponse);
    }

    /**
     * The GetMerchantAccountStatus operation is used to query the status of a particular
     * merchant account and to retrieve information if the account is active or inactive.
     *
     * @param  getMerchantAccountStatusRequest Container for the optional
     *           parameters to execute the GetMerchantAccountStatus service API on
     *           Amazon Pay.
     *
     * @return The response from the GetMerchantAccountStatus service API, as
     *         returned by Amazon Pay.
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetMerchantAccountStatusResponseData getMerchantAccountStatus(
            GetMerchantAccountStatusRequest getMerchantAccountStatusRequest)
            throws AmazonServiceException {
        final ResponseData rawResponse = sendRequest(helper.getPostURL(
                getMerchantAccountStatusRequest));
        return Parser.getMerchantAccountStatus(rawResponse);
    }

    /**
     * The GetMerchantAccountStatus operation is used to query the status of a particular
     * merchant account and to retrieve information if the account is active or inactive.
     *
     * @return The response from the GetMerchantAccountStatus service API, as
     *         returned by Amazon Pay.
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public GetMerchantAccountStatusResponseData getMerchantAccountStatus()
            throws AmazonServiceException {
        final ResponseData rawResponse = sendRequest(helper.getPostURL(
                new GetMerchantAccountStatusRequest()));
        return Parser.getMerchantAccountStatus(rawResponse);
    }

    private ResponseData sendRequest(String httpPostRequest)  {
        ResponseData response = null;

        try {
            response = postRequest(httpPostRequest);
            int statusCode = response.getStatusCode();
            int retry = 0;
            //503 status code is returned when request is throttled and 500 is returned for InternalServerError
            while ((statusCode == 503  || statusCode == 500) && retry < 3 && payConfig.isUseAutoRetryOnThrottle()) {
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
        } catch (IOException e) {
            throw new AmazonClientException("Encountered IOException: ", e);
        } catch (InterruptedException ex) {
            throw new AmazonClientException("Encountered InterruptedException:", ex);
        }
        return response;
    }

    private ResponseData postRequest(String httpPostRequest) throws IOException {
        return Util.httpSendRequest("POST", Util.getServiceURLEndpoint(payConfig), httpPostRequest, null, this.helper.payConfig);
    }

    /**
     * Accessor method for PayConfig configuration object
     *
     * @return Config client configuration object
     *
     * @throws AmazonServiceException
     *             If an error response is returned by Amazon Pay indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    @Override
    public Config getConfig() throws AmazonServiceException {
        return payConfig;
    }

}
