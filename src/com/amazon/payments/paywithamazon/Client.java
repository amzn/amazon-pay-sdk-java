package com.amazon.payments.paywithamazon;



import com.amazon.payments.paywithamazon.exceptions.AmazonServiceException;
import com.amazon.payments.paywithamazon.request.AuthorizeOnBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.AuthorizeRequest;
import com.amazon.payments.paywithamazon.request.CancelOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.CaptureRequest;
import com.amazon.payments.paywithamazon.request.CloseAuthorizationRequest;
import com.amazon.payments.paywithamazon.request.CloseBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.CloseOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.ConfirmBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.ConfirmOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.GetAuthorizationDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetBillingAgreementDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetCaptureDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetProviderCreditDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetProviderCreditReversalDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetRefundDetailsRequest;
import com.amazon.payments.paywithamazon.request.RefundRequest;
import com.amazon.payments.paywithamazon.request.ReverseProviderCreditRequest;
import com.amazon.payments.paywithamazon.request.SetBillingAgreementDetailsRequest;
import com.amazon.payments.paywithamazon.request.SetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.request.ValidateBillingAgreementRequest;
import com.amazon.payments.paywithamazon.response.parser.AuthorizeOnBillingAgreementResponseData;
import com.amazon.payments.paywithamazon.response.parser.AuthorizeResponseData;
import com.amazon.payments.paywithamazon.response.parser.CancelOrderReferenceResponseData;
import com.amazon.payments.paywithamazon.response.parser.CaptureResponseData;
import com.amazon.payments.paywithamazon.response.parser.CloseAuthorizationResponseData;
import com.amazon.payments.paywithamazon.response.parser.CloseBillingAgreementResponseData;
import com.amazon.payments.paywithamazon.response.parser.CloseOrderReferenceResponseData;
import com.amazon.payments.paywithamazon.response.parser.ConfirmBillingAgreementResponseData;
import com.amazon.payments.paywithamazon.response.parser.ConfirmOrderReferenceResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetAuthorizationDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetBillingAgreementDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetCaptureDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetOrderReferenceDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetProviderCreditDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetProviderCreditReversalDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.GetRefundDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.RefundResponseData;
import com.amazon.payments.paywithamazon.response.parser.ReverseProviderCreditResponseData;
import com.amazon.payments.paywithamazon.response.parser.SetBillingAgreementDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.SetOrderReferenceDetailsResponseData;
import com.amazon.payments.paywithamazon.response.parser.ValidateBillingAgreementResponseData;
import com.amazon.payments.paywithamazon.types.User;
import java.io.IOException;


public interface Client {

    /**
     * <p>
     * The Authorize operation reserves a specified amount against the payment
     * methods stored in the order reference. To charge the payment methods,
     * you must either set the CaptureNow request parameter to true, or call the
     * Capture operation after you call this operation. An authorization is only
     * valid for a particular time period, which is specified in the response of
     * the operation.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752010
     * </p>
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
    AuthorizeResponseData authorize(AuthorizeRequest authorizeRequest) throws AmazonServiceException;

    /**
     * <p>
     * The AuthorizeOnBillingAgreement operation reserves a specified amount against the
     * payment methods stored in the billing agreement. To charge the payment methods,
     * you must either set the CaptureNow request parameter to true, or call the
     * Capture operation after you call this operation. An authorization is only valid for
     * a particular time period, which is specified in the response of the operation.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751940
     * </p>
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
    AuthorizeOnBillingAgreementResponseData authorizeOnBillingAgreement(AuthorizeOnBillingAgreementRequest authorizeOnBillingAgreementRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the CancelOrderReference operation to cancel a previously confirmed order reference.
     * You can cancel an Order Reference object only if there are no Completed, Closed, or Pending
     * captures against it. If you cancel an order reference, all authorizations associated with
     * this order reference are also closed.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751990
     * </p>
     *
     * @param cancelOrderReferenceRequest Container for the necessary
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
    CancelOrderReferenceResponseData cancelOrderReference(CancelOrderReferenceRequest request) throws AmazonServiceException;

    /**
     * <p>
     * Call the Capture operation to capture funds from an authorized payment instrument.
     * To successfully capture a payment, you must call this operation on an Authorization object
     * before it expires, as specified by the ExpirationTimestamp returned in response of the Authorize operation call.
     * You must specify a capture amount, and the amount cannot exceed the original amount that was authorized.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752040
     * </p>
     *
     * @param captureRequest Container for the necessary
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
    CaptureResponseData capture(CaptureRequest request) throws AmazonServiceException;

    /**
     * <p>
     * Call the CloseAuthorization operation to close an authorization after the
     * total amount of the authorization has been captured.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752070
     * </p>
     *
     * @param closeAuthorizationRequest Container for the necessary
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
    CloseAuthorizationResponseData closeAuthorization(CloseAuthorizationRequest request) throws AmazonServiceException;

    /**
     * <p>
     * Call the CloseBillingAgreement operation on a previously confirmed billing agreement to
     * indicate that you want to terminate the billing agreement with the buyer and that you
     * do not expect to create any new order references or authorizations on this billing agreement.
     * All open authorizations on the billing agreement can still be used to capture funds.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751950
     * </p>
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
    CloseBillingAgreementResponseData closeBillingAgreement(CloseBillingAgreementRequest closeBillingAgreementRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the CloseOrderReference operation to indicate that a previously confirmed order reference
     * has been fulfilled (fully or partially) and that you do not expect to create any new
     * authorizations on this order reference. You can still capture funds against open
     * authorizations on the order reference.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752000
     * </p>
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
    CloseOrderReferenceResponseData closeOrderReference(CloseOrderReferenceRequest closeOrderReferenceRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the ConfirmBillingAgreement operation when the billing agreement is free of constraints,
     * indicating that all required information has been set on the billing agreement.
     * On successful completion of the ConfirmBillingAgreement call, the billing agreement
     * moves to the Open state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751710
     * </p>
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
    ConfirmBillingAgreementResponseData confirmBillingAgreement(ConfirmBillingAgreementRequest confirmBillingAgreementRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the ConfirmOrderReference operation after the order reference is free of
     * constraints and all required information has been set on the order reference.
     * After you call this operation, the order reference is set to the Open state and
     * you can submit authorizations against the order reference.
     * Documentation; https://payments.amazon.com/documentation/apireference/201751630#201751980
     * </p>
     *
     * @param confirmOrderReferenceRequest Container for the necessary
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
    ConfirmOrderReferenceResponseData confirmOrderReference(ConfirmOrderReferenceRequest request) throws AmazonServiceException;

    /**
     * <p>
     * Call the GetAuthorizationDetails operation to query the status of a particular authorization
     * and to retrieve information about the total amount captured on the authorization.
     * If you received a Pending status when you called the Authorize operation,
     * you can call this operation to get the current status.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752030
     * </p>
     *
     * @param getAuthorizationDetailsRequest Container for the necessary
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
    GetAuthorizationDetailsResponseData getAuthorizationDetails(GetAuthorizationDetailsRequest request) throws AmazonServiceException;

    /**
     * <p>
     * The GetBillingAgreementDetails operation returns details about the Billing
     * Agreement object and its current state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751690
     * </p>
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
    GetBillingAgreementDetailsResponseData getBillingAgreementDetails(GetBillingAgreementDetailsRequest getBillingAgreementDetailsRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the GetCaptureDetails operation to capture funds from an authorized payment instrument.
     * To successfully capture a payment, you must call this operation on an Authorization object
     * before it expires, as specified by the ExpirationTimestamp returned in response of the Authorize operation call.
     * You must specify a capture amount, and the amount cannot exceed the original amount that was authorized.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752060
     * </p>
     *
     * @param getCaptureDetailsRequest Container for the necessary
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
    GetCaptureDetailsResponseData getCaptureDetails(GetCaptureDetailsRequest request) throws AmazonServiceException;

    /**
     * <p>
     * The GetOrderReferenceDetails operation returns details about the
     * Order Reference object and its current state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751970
     * </p>
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
    GetOrderReferenceDetailsResponseData getOrderReferenceDetails(GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the GetProviderCreditDetails operation for getting provider credit reversal details
     * </p>
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
    GetProviderCreditDetailsResponseData getProviderCreditDetails(GetProviderCreditDetailsRequest getProviderCreditDetailsRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the GetProviderCreditReversalDetails operation for getting provider credit reversal details
     * </p>
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
    GetProviderCreditReversalDetailsResponseData getProviderCreditReversalDetails(GetProviderCreditReversalDetailsRequest getProviderCreditReversalDetailsRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the GetRefundDetails operation to query the status of a particular refund.
     * If you received a Pending status when you called the Refund operation,
     * you can call this operation to get the current status.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752100
     * </p>
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
    GetRefundDetailsResponseData getRefundDetails(GetRefundDetailsRequest getRefundDetailsRequest) throws AmazonServiceException;

    /**
     * <p>
     * This API call allows you to obtain user profile information once a user has
     * logged into your application using their Amazon credentials.
     * </p>
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
    User getUserInfo(String accessToken, String clientId) throws AmazonServiceException, IOException;

    /**
     * <p>
     * Call the Refund operation to refund a previously captured amount. You call the
     * GetRefundDetails operation to query the status of a refund.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752080
     * </p>
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
    RefundResponseData refund(RefundRequest refundRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the ReverseProviderCredit operation for getting provider credit reversal details
     * </p>
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
    ReverseProviderCreditResponseData reverseProviderCredit(ReverseProviderCreditRequest reverseProviderCreditRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the SetBillingAgreementDetails operation to specify billing agreement
     * details such as a description of the agreement and other information about the merchant.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751700
     * </p>
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
    SetBillingAgreementDetailsResponseData setBillingAgreementDetails(SetBillingAgreementDetailsRequest setBillingAgreementDetailsRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the SetOrderReferenceDetails operation to specify order details
     * such as the amount of the order,
     * a description of the order, and other order attributes.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751960
     * </p>
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
    SetOrderReferenceDetailsResponseData setOrderReferenceDetails(SetOrderReferenceDetailsRequest setOrderReferenceDetailsRequest) throws AmazonServiceException;

    /**
     * <p>
     * Call the ValidateBillingAgreement operation when the billing agreement moves to the
     * Open state (that is, after a successful call to the ConfirmBillingAgreement operation).
     * This operation validates the status of the billing agreement and the validity of the
     * payment method associated with the billing agreement.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201751720
     * </p>
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
    ValidateBillingAgreementResponseData validateBillingAgreement(ValidateBillingAgreementRequest validateBillingAgreementRequest) throws AmazonServiceException;
    
}
