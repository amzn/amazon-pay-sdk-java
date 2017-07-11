package com.amazon.pay.response;

import com.amazon.pay.response.model.AuthorizationDetails;
import com.amazon.pay.response.model.CaptureDetails;
import com.amazon.pay.response.model.Environment;
import com.amazon.pay.response.model.ErrorResponse;
import com.amazon.pay.response.model.Message;
import com.amazon.pay.response.model.MessageList;
import com.amazon.pay.response.model.OrderReferenceDetails;
import com.amazon.pay.response.model.RefundDetails;
import com.amazon.pay.response.model.RefundType;
import com.amazon.pay.response.model.RequestStatus;
import com.amazon.pay.response.model.ServiceStatus;
import com.amazon.pay.response.model.Type;
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
import com.amazon.pay.response.parser.GetServiceStatusResponseData;
import com.amazon.pay.response.parser.Parser;
import com.amazon.pay.response.parser.ReverseProviderCreditResponseData;
import com.amazon.pay.response.parser.RefundResponseData;
import com.amazon.pay.response.parser.SetBillingAgreementDetailsResponseData;
import com.amazon.pay.response.parser.SetOrderReferenceDetailsResponseData;
import com.amazon.pay.response.parser.ValidateBillingAgreementResponseData;
import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.exceptions.AmazonServiceException;
import com.amazon.pay.response.parser.ResponseData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class PaymentsAPIResponseTest {

    private String loadTestFile(String fileName) throws UnsupportedEncodingException, IOException {
        final InputStream is = new FileInputStream(System.getProperty("user.dir") +"/tst/com/amazon/pay/response/xml/" + fileName);
        if (is != null) {
            final Writer writer = new StringWriter();

            final char[] buffer = new char[1024];
            try {
                final Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }

    @Test
    public void testGetOrderReferenceDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("GetOrderReferenceDetailsResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetOrderReferenceDetailsResponseData res = Parser.getOrderReferenceDetails(response);
        Assert.assertEquals(res.getDetails().getAmazonOrderReferenceId(), "P01-1234567-1234567");
        Assert.assertEquals(res.getDetails().getOrderReferenceStatus().getState(), "Draft");
        Assert.assertEquals(res.getDetails().getDestination().getDestinationType(), "Physical");
        Assert.assertEquals(res.getRequestId(), "5f20169b-7ab2-11df-bcef-d35615e2b044");
        Assert.assertEquals(res.getDetails().getReleaseEnvironment().value(), "LIVE");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCountryCode(), "US");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCity(), "New York");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getPostalCode(), "10101-9876");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getStateOrRegion(), "NY");
        Assert.assertNotNull(res.getDetails().getPaymentDescriptor());
        Assert.assertEquals(res.getDetails().getPaymentDescriptor().getName() , "Visa");
        Assert.assertEquals(res.getDetails().getPaymentDescriptor().getAccountNumberTail() , "11");
        Assert.assertEquals(res.getDetails().getPaymentDescriptor().getFullDescriptor() , "Amazon Pay (Visa **11)");
        Assert.assertEquals(res.getDetails().getPaymentDescriptor().isUseAmazonBalanceFirst() , false);
        Assert.assertNotEquals(res.getDetails().getPaymentDescriptor().isUseAmazonBalanceFirst(), true);
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testPaymentDescriptor() throws Exception {
        final String rawResponse = loadTestFile("TestPaymentDescriptor.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetOrderReferenceDetailsResponseData res = Parser.getOrderReferenceDetails(response);
        Assert.assertNull(res.getDetails().getPaymentDescriptor().getName());
        Assert.assertNull(res.getDetails().getPaymentDescriptor().getAccountNumberTail());
        Assert.assertEquals(res.getDetails().getPaymentDescriptor().getFullDescriptor() , "Amazon Pay (Visa **11)");
        Assert.assertEquals(res.getDetails().getPaymentDescriptor().isUseAmazonBalanceFirst(), true);
        Assert.assertNotNull(res.getDetails().getPaymentDescriptor());
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testNoPaymentDescriptor() throws Exception {
        final String rawResponse = loadTestFile("GetOROwithoutPaymentDescriptor.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetOrderReferenceDetailsResponseData res = Parser.getOrderReferenceDetails(response);
        Assert.assertNull(res.getDetails().getPaymentDescriptor());
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testSanitizedData() throws Exception {
        final String rawResponse = loadTestFile("SanitizedData.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final SetOrderReferenceDetailsResponseData res = Parser.setOrderReferenceDetails(response);

        Assert.assertEquals(res.getDetails().getAmazonOrderReferenceId(), "S01-9821095-0000200");
        Assert.assertEquals(res.getDetails().getOrderReferenceStatus().getState(), "Draft");
        Assert.assertEquals(res.getDetails().getDestination().getDestinationType(), "Physical");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCountryCode(), null);
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getStateOrRegion(), null);
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCity(), null);
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getPostalCode(), null);
        Assert.assertEquals(res.getDetails().getSellerNote(), "*** Removed ***");
    }

    @Test
    public void testGetPaymentDetails() throws Exception {
        final GetPaymentDetails testGetAllResponseDetails = new GetPaymentDetails();
        final String rawResponse = loadTestFile("GetOrderReferenceDetailsResponse.xml");
        final ResponseData orderReferenceDetailsResponse = new ResponseData(200, rawResponse);
        final OrderReferenceDetails parsedOrderResponse = Parser.getOrderReferenceDetails(orderReferenceDetailsResponse).getDetails();

        final String rawAuthResponse = loadTestFile("GetAuthorizationDetailsResponse.xml");
        final ResponseData authorizeDetailsResponse = new ResponseData(200, rawAuthResponse);
        final AuthorizationDetails parsedAuthorizeResponse = Parser.getAuthorizationDetailsData(authorizeDetailsResponse).getDetails();

        final String rawCaptureResponse = loadTestFile("GetCaptureDetailsResponse.xml");
        final ResponseData captureDetailsResponse = new ResponseData(200, rawCaptureResponse);
        final CaptureDetails parsedCaptureResponse = Parser.getCaptureDetailsData(captureDetailsResponse).getDetails();

        final String rawRefundResponse = loadTestFile("GetRefundDetails.xml");
        final ResponseData refundDetailsResponse = new ResponseData(200, rawRefundResponse);
        final RefundDetails parsedRefundResponse = Parser.getRefundDetailsData(refundDetailsResponse).getDetails();

        testGetAllResponseDetails.putOrderReferenceDetails("P01-1234567-1234567", parsedOrderResponse);
        Assert.assertEquals(testGetAllResponseDetails.getOrderReferenceDetails(), parsedOrderResponse);

        testGetAllResponseDetails.putAuthorizationDetails("S01-9821095-1837200-A041953",parsedAuthorizeResponse);
        Assert.assertEquals(testGetAllResponseDetails.getAuthorizationDetails().get("S01-9821095-1837200-A041953"), parsedAuthorizeResponse);

        testGetAllResponseDetails.putCaptureDetails("S01-9821095-1837200-C041953", parsedCaptureResponse);
        Assert.assertEquals(testGetAllResponseDetails.getCaptureDetails().get("S01-9821095-1837200-C041953"), parsedCaptureResponse);

        testGetAllResponseDetails.putRefundDetails("S01-5695290-1354077-R072290", parsedRefundResponse);
        Assert.assertEquals(testGetAllResponseDetails.getRefundDetails().get("S01-5695290-1354077-R072290"), parsedRefundResponse);
    }

    @Test
    public void testSetOrderReferenceDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("SetOrderReferenceDetailsResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final SetOrderReferenceDetailsResponseData res = Parser.setOrderReferenceDetails(response);

        Assert.assertEquals(res.getDetails().getAmazonOrderReferenceId(), "S01-9821095-0000200");
        Assert.assertEquals(res.getDetails().getOrderReferenceStatus().getState(), "Draft");
        Assert.assertEquals(res.getDetails().getDestination().getDestinationType(), "Physical");
        Assert.assertEquals(res.getDetails().getReleaseEnvironment(), Environment.SANDBOX);
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCountryCode(), "CA");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCity(), "Vancouver");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getPostalCode(), "V6C 3B5");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getStateOrRegion(), "BC");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T20:43:45.183Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);
        Assert.assertEquals(res.getDetails().getSellerNote(), "testing");
        Assert.assertEquals(res.getDetails().getOrderTotal().getAmount(), "500.00");
        Assert.assertEquals(res.getDetails().getOrderTotal().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getSellerOrderAttributes().getSellerOrderId(), "test1234");
        Assert.assertEquals(res.getDetails().getSellerOrderAttributes().getStoreName(), "myTestStore");
        Assert.assertEquals(res.getDetails().getSellerOrderAttributes().getCustomInformation(), "myCustomInformation");

        Assert.assertEquals(res.getDetails().getPlatformId(), "ANDRCTOTP9");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2016-04-27T20:43:45.183Z");
        Assert.assertEquals(res.getDetails().getExpirationTimestamp(), xgc2);
        Assert.assertEquals(res.getDetails().getOrderLanguage(), null);
        Assert.assertEquals(res.getDetails().getParentDetails(), null);
        Assert.assertEquals(res.getDetails().getBillingAddress(), null);
        Assert.assertEquals(res.getDetails().getBuyer(), null);

        Assert.assertEquals(res.getRequestId(), "eab0140b-e59c-4875-859b-f5012944ba");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testConfirmOrderResponse() throws Exception {
        final String rawResponse = loadTestFile("ConfirmOrderReferenceResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final ConfirmOrderReferenceResponseData res = Parser.confirmOrderReference(response);
        Assert.assertEquals(res.getRequestId(), "f1f52572-a347-4f7a-a630-be066f3ba827");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testAuthorizeResponse() throws Exception {
        final String rawResponse = loadTestFile("AuthorizeResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final AuthorizeResponseData res = Parser.getAuthorizeData(response);
        Assert.assertEquals(res.getDetails().getAmazonAuthorizationId(), "S01-9821095-1837200-A041953");
        Assert.assertEquals(res.getDetails().getSoftDescriptor(), "AMZ*testikiki");
        Assert.assertEquals(res.getDetails().getCapturedAmount().getAmount(), "0");
        Assert.assertEquals(res.getDetails().getCapturedAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getAuthorizationAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getAuthorizationAmount().getAmount(), "1.00");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T21:02:38.508Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);
        final XMLGregorianCalendar xgc1 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-29T21:02:38.508Z");
        Assert.assertEquals(res.getDetails().getExpirationTimestamp(), xgc1);
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getState(), "Closed");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getReasonCode(), "MaxCapturesProcessed");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getReasonDescription(), null);
        Assert.assertEquals(res.getDetails().getAuthorizationFee().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getAuthorizationFee().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().isCaptureNow(), true);
        Assert.assertEquals(res.getDetails().getIdList().getMember().get(0), "S01-9821095-1837200-C041953");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T21:02:38.508Z");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(res.getDetails().getAuthorizationReferenceId(), "asdcdsd5iiiii");
        Assert.assertEquals(res.getDetails().getSellerAuthorizationNote(), "testing");
        Assert.assertEquals(res.getDetails().getAddressVerificationCode(), null);
        Assert.assertEquals(res.getDetails().getOrderItemCategories(), null);
        Assert.assertEquals(res.getDetails().getAuthorizationBillingAddress(), null);
        Assert.assertEquals(res.getRequestId(), "adabc99d-8351-48dc-acef-1bc049215f55");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testAuthorizationDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("GetAuthorizationDetailsResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetAuthorizationDetailsResponseData res = Parser.getAuthorizationDetailsData(response);
        Assert.assertEquals(res.getDetails().getAmazonAuthorizationId(), "S01-9821095-1837200-A041953");
        Assert.assertEquals(res.getDetails().getSoftDescriptor(), "AMZ*testikiki");
        Assert.assertEquals(res.getDetails().getCapturedAmount().getAmount(), "1.00");
        Assert.assertEquals(res.getDetails().getCapturedAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getAuthorizationAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getAuthorizationAmount().getAmount(), "1.00");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T21:02:38.508Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);
        final XMLGregorianCalendar xgc1 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-29T21:02:38.508Z");
        Assert.assertEquals(res.getDetails().getExpirationTimestamp(), xgc1);
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getState(), "Closed");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getReasonCode(), "MaxCapturesProcessed");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getReasonDescription(), null);
        Assert.assertEquals(res.getDetails().getAuthorizationFee().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getAuthorizationFee().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().isCaptureNow(), true);
        Assert.assertEquals(res.getDetails().getIdList().getMember().get(0), "S01-9821095-1837200-C041953");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T21:02:38.508Z");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(res.getDetails().getAuthorizationReferenceId(), "asdcdsd5iiiii");
        Assert.assertEquals(res.getDetails().getSellerAuthorizationNote(), "testing");
        Assert.assertEquals(res.getRequestId(), "6173ac5a-8915-4541-922f-f9e104930731");
        Assert.assertEquals(res.toXML(), rawResponse);

    }

    @Test
    public void testCaptureResponse() throws Exception {
        final String rawResponse = loadTestFile("CaptureResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final CaptureResponseData res = Parser.getCapture(response);
        Assert.assertEquals(res.getDetails().getAmazonCaptureId(), "S01-9821095-1837200-C053432");
        Assert.assertEquals(res.getDetails().getCaptureAmount().getAmount(), "1.00");
        Assert.assertEquals(res.getDetails().getCaptureAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getCaptureFee().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getCaptureFee().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getSoftDescriptor(), "AMZ*testsd");
        Assert.assertEquals(res.getDetails().getIdList().getMember(), new ArrayList());
        Assert.assertEquals(res.getDetails().getSellerCaptureNote(), "");
        Assert.assertEquals(res.getDetails().getCaptureStatus().getState(), "Completed");
        Assert.assertEquals(res.getDetails().getRefundedAmount().getAmount(), "0");
        Assert.assertEquals(res.getDetails().getRefundedAmount().getCurrencyCode(), "USD");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T21:47:10.797Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T21:47:10.797Z");
        Assert.assertEquals(res.getDetails().getCaptureStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(res.getRequestId(), "1ec2813f-3d33-4b3a-a198-a25cd608310d");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testCaptureDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("GetCaptureDetailsResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetCaptureDetailsResponseData res = Parser.getCaptureDetailsData(response);
        Assert.assertEquals(res.getDetails().getAmazonCaptureId(), "S01-9821095-1837200-C041953");
        Assert.assertEquals(res.getDetails().getCaptureAmount().getAmount(), "1.00");
        Assert.assertEquals(res.getDetails().getCaptureAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getCaptureReferenceId(), "asdcdsd5iiiii");
        Assert.assertEquals(res.getDetails().getCaptureFee().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getCaptureFee().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getSoftDescriptor(), "AMZ*testikiki");
        Assert.assertEquals(res.getDetails().getIdList().getMember(), new ArrayList());
        Assert.assertEquals(res.getDetails().getSellerCaptureNote(), "testing");
        Assert.assertEquals(res.getDetails().getCaptureStatus().getState(), "Completed");
        Assert.assertEquals(res.getDetails().getRefundedAmount().getAmount(), "0");
        Assert.assertEquals(res.getDetails().getRefundedAmount().getCurrencyCode(), "USD");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T21:02:38.608Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-30T21:02:38.608Z");
        Assert.assertEquals(res.getDetails().getCaptureStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(res.getRequestId(), "21acf393-d625-497e-b2c0-d1dc0b0d2bb6");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testCaptureDetailsResponseMulticurrency() throws Exception {
        final String rawResponse = loadTestFile("GetCaptureDetailsResponse_Multicurrency.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetCaptureDetailsResponseData res = Parser.getCaptureDetailsData(response);
        Assert.assertEquals(res.getDetails().getAmazonCaptureId(), "S02-7423235-4925359-C052508");
        Assert.assertEquals(res.getDetails().getCaptureAmount().getAmount(), "0.99");
        Assert.assertEquals(res.getDetails().getCaptureAmount().getCurrencyCode(), "CHF");
        Assert.assertEquals(res.getDetails().getCaptureReferenceId(), "7a087b12a3cb4d0ba3cb4230aa953de4");
        Assert.assertEquals(res.getDetails().getCaptureFee().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getCaptureFee().getCurrencyCode(), "EUR");
        Assert.assertEquals(res.getDetails().getSoftDescriptor(), "AMZ*Matt's Test Stor");
        Assert.assertEquals(res.getDetails().getIdList().getMember(), new ArrayList());
        Assert.assertEquals(res.getDetails().getSellerCaptureNote(), "");
        Assert.assertEquals(res.getDetails().getCaptureStatus().getState(), "Completed");
        Assert.assertEquals(res.getDetails().getRefundedAmount().getAmount(), "0");
        Assert.assertEquals(res.getDetails().getRefundedAmount().getCurrencyCode(), "CHF");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-27T22:07:18.931Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-27T22:07:18.999Z");
        Assert.assertEquals(res.getDetails().getCaptureStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(res.getRequestId(), "a17ee562-9a97-4b22-8487-20e8e7230639");

        // The three new multi-currency specific fields
        Assert.assertEquals(res.getDetails().getConvertedAmount().getAmount(), "0.88");
        Assert.assertEquals(res.getDetails().getConvertedAmount().getCurrencyCode(), "EUR");
        Assert.assertEquals(res.getDetails().getConversionRate(), "1.1297854087");

        Assert.assertEquals(res.toXML(), rawResponse);
    }

   @Test
    public void testCancelOrderReferenceResponse() throws Exception {
        final String rawResponse = loadTestFile("CancelOrderReferenceResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final CancelOrderReferenceResponseData res = Parser.getCancelOrderReference(response);
        Assert.assertEquals(res.getRequestId(), "0714c2dd-c3fa-45af-afc7-b48055cfd7bf");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

   @Test
    public void testCloseOrderReferenceResponse() throws Exception {
        final String rawResponse = loadTestFile("CloseOrderReferenceResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final CloseOrderReferenceResponseData res = Parser.getCloseOrderReference(response);
        Assert.assertEquals(res.getRequestId(), "5f20169b-7ab2-11df-bcef-d35615e2b044");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

   @Test
    public void testCloseAuthorizationResponse() throws Exception {
        final String rawResponse = loadTestFile("CloseAuthorizationResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final CloseAuthorizationResponseData res = Parser.closeAuthorizationResponse(response);
        Assert.assertEquals(res.getRequestId(), "3e130e5b-41ae-41fd-b307-dbbf45663d79");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testReverseProviderCreditResponse() throws Exception {
        final String rawResponse = loadTestFile("ReverseProviderCreditResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final ReverseProviderCreditResponseData res = Parser.getReverseProviderCreditResponseData(response);

        Assert.assertEquals(res.getDetails().getAmazonProviderCreditReversalId(), "S01-0458164-4040121-Q021623");
        Assert.assertEquals(res.getDetails().getCreditReversalAmount().getAmount(), "0.50");
        Assert.assertEquals(res.getDetails().getCreditReversalAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getCreditReversalNote(), null);
        Assert.assertEquals(res.getDetails().getCreditReversalReferenceId(), "kvAKLMtYprId");
        Assert.assertEquals(res.getDetails().getProviderId(), "TEST_PROVIDER_ID");
        Assert.assertEquals(res.getDetails().getSellerId(), "TEST_SELLER_ID");
        Assert.assertEquals(res.getDetails().getCreditReversalStatus().getState(), "Completed");
        final XMLGregorianCalendar xgc1 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-03T19:21:09.762Z");
        Assert.assertEquals(res.getDetails().getCreditReversalStatus().getLastUpdateTimestamp(), xgc1);

        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-03T19:21:09.638Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);

        Assert.assertEquals(res.getRequestId(), "a7e0af53-ee4e-4557-a190-265cae27407d");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testGetProviderCreditReversalDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("GetProviderCreditReversalDetailsResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetProviderCreditReversalDetailsResponseData res = Parser.getProviderCreditReversalDetails(response);
        Assert.assertEquals(res.getDetails().getAmazonProviderCreditReversalId(), "S01-2117025-2155793-P045170");
        Assert.assertEquals(res.getDetails().getCreditReversalAmount().getAmount(), "1.00");
        Assert.assertEquals(res.getDetails().getCreditReversalAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getCreditReversalNote(), null);
        Assert.assertEquals(res.getDetails().getProviderId(), "TEST_PROVIDER_ID");
        Assert.assertEquals(res.getDetails().getSellerId(), "TEST_SELLER_ID");
        Assert.assertEquals(res.getDetails().getCreditReversalReferenceId(), "S01-2117025-2155793nesasdh");
        Assert.assertEquals(res.getDetails().getCreditReversalStatus().getState(), "Closed");
        Assert.assertEquals(res.getDetails().getCreditReversalStatus().getReasonCode(), "MaxAmountReversed");

        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-23T00:30:42.996Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);

        Assert.assertEquals(res.getRequestId(), "10a7736b-bb9b-447c-9be1-4f5e76166e48");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testGetProviderCreditDetailsResponse() throws Exception {
        testGetProviderCreditDetailsResponse(loadTestFile("GetProviderCreditDetailsResponse.xml"));
    }

    @Test
    public void testGetProviderCreditDetailsResponseVariation() throws Exception {
        testGetProviderCreditDetailsResponse(loadTestFile("GetProviderCreditDetailsResponse1.xml"));
    }

    public void testGetProviderCreditDetailsResponse(final String rawResponse) throws Exception {
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetProviderCreditDetailsResponseData res = Parser.getGetProviderCreditDetails(response);
        Assert.assertEquals(res.getDetails().getAmazonProviderCreditId(), "S01-2117025-2155793-P045170");
        Assert.assertEquals(res.getDetails().getCreditAmount().getAmount(), "1.00");
        Assert.assertEquals(res.getDetails().getCreditAmount().getCurrencyCode(), "USD");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-23T00:30:42.996Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc);
        Assert.assertEquals(res.getDetails().getCreditReversalAmount().getAmount(), "1.00");
        Assert.assertEquals(res.getDetails().getCreditReversalAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getCreditReversalIdList().getMember().get(0), "S01-2117025-2155793-Q068906");
        Assert.assertEquals(res.getDetails().getCreditReversalIdList().getMember().get(1), "S01-2117025-2155793-Q023847");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-26T23:26:46.945Z");
        Assert.assertEquals(res.getDetails().getCreditStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(res.getDetails().getCreditStatus().getReasonCode(), "MaxAmountReversed");
        Assert.assertEquals(res.getDetails().getCreditStatus().getState(), "Closed");
        Assert.assertEquals(res.getDetails().getCreditStatus().getReasonDescription(), null);
        Assert.assertEquals(res.getDetails().getCreditReferenceId(), "S01-2117025-2155793nesasdh");
        Assert.assertEquals(res.getDetails().getSellerId(), "TEST_SELLER_ID");
        Assert.assertEquals(res.getDetails().getProviderId(), "TEST_PROVIDER_ID");

        Assert.assertEquals(res.getRequestId(), "21162350-7135-46ae-aa20-68d5361cef17");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testGetBillingAgreementDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("GetBillingAgreementDetailsResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetBillingAgreementDetailsResponseData res = Parser.getBillingAgreementDetailsData(response);
        Assert.assertEquals(res.getDetails().getAmazonBillingAgreementId(), "C01-3925266-2250830");
        Assert.assertEquals(res.getDetails().getBillingAgreementStatus().getLastUpdatedTimestamp(), null);
        Assert.assertEquals(res.getDetails().getBillingAgreementStatus().getState(), "Draft");
        Assert.assertEquals(res.getDetails().getDestination().getDestinationType(), "Physical");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getAddressLine1(), "999 Canada Place 140");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getAddressLine2(), null);
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getAddressLine3(), null);
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCity(), "Vancouver");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCountryCode(), "CA");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getPostalCode(), "V6C 3B5");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCounty(), null);
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getDistrict(), null);
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getPhone(), "9999999999");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getName(), "TEST_NAME");
        Assert.assertEquals(res.getDetails().getConstraints().getConstraint().get(0).getConstraintID(), "BuyerConsentNotSet");
        Assert.assertEquals(res.getDetails().getConstraints().getConstraint().get(0).getDescription(), "The buyer has not given consent for this billing agreement.");
        Assert.assertEquals(res.getDetails().getBuyer().getName(), "Test Buyer");
        Assert.assertEquals(res.getDetails().getBuyer().getEmail(), "testbuyer2@amazon.com");
        Assert.assertEquals(res.getDetails().getReleaseEnvironment().SANDBOX, Environment.SANDBOX);
        final XMLGregorianCalendar xgc3 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-02T17:36:30.173Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc3);
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getAmountLimitPerTimePeriod().getAmount(), "500");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getAmountLimitPerTimePeriod().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getCurrentRemainingBalance().getAmount(), "500.00");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getCurrentRemainingBalance().getCurrencyCode(), "USD");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-12-01T00:00:00Z");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getTimePeriodEndDate(), xgc2);
        final XMLGregorianCalendar xgc4 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-01T00:00:00Z");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getTimePeriodStartDate(), xgc4);
        Assert.assertEquals(res.getDetails().getOrderLanguage(), null);
        Assert.assertEquals(res.getDetails().isBillingAgreementConsent(), false);
        Assert.assertEquals(res.getDetails().getExpirationTimestamp(), null);
        Assert.assertEquals(res.getDetails().getSellerBillingAgreementAttributes().getCustomInformation(), null);
        Assert.assertEquals(res.getDetails().getSellerBillingAgreementAttributes().getSellerBillingAgreementId(), null);
        Assert.assertEquals(res.getDetails().getSellerBillingAgreementAttributes().getStoreName(), null);
        Assert.assertEquals(res.getDetails().getBillingAddress(), null);
        Assert.assertEquals(res.getDetails().getPlatformId(), null);
        Assert.assertEquals(res.getDetails().getSellerNote(), null);

        Assert.assertEquals(res.getRequestId(), "d69e8d60-3682-43d7-bf5e-e2ef64dc685e");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testSetBillingAgreementDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("SetBillingAgreementDetailsResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final SetBillingAgreementDetailsResponseData res = Parser.getSetBillingAgreementDetailsResponse(response);
        Assert.assertEquals(res.getDetails().getAmazonBillingAgreementId(), "C01-3925266-2250830");
        Assert.assertEquals(res.getDetails().getBillingAgreementStatus().getLastUpdatedTimestamp(), null);
        Assert.assertEquals(res.getDetails().getBillingAgreementStatus().getState(), "Draft");
        Assert.assertEquals(res.getDetails().getBillingAgreementStatus().getReasonCode(), null);
        Assert.assertEquals(res.getDetails().getBillingAgreementStatus().getReasonDescription(), null);
        Assert.assertEquals(res.getDetails().getDestination().getDestinationType(), "Physical");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCity(), "Vancouver");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCountryCode(), "CA");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getPostalCode(), "V6C 3B5");
        Assert.assertEquals(res.getDetails().getConstraints().getConstraint().get(0).getConstraintID(), "BuyerConsentNotSet");
        Assert.assertEquals(res.getDetails().getConstraints().getConstraint().get(0).getDescription(), "The buyer has not given consent for this billing agreement.");
        Assert.assertEquals(res.getDetails().getReleaseEnvironment().SANDBOX, Environment.SANDBOX);
        final XMLGregorianCalendar xgc3 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-02T17:36:30.173Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc3);
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getAmountLimitPerTimePeriod().getAmount(), "500");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getAmountLimitPerTimePeriod().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getCurrentRemainingBalance().getAmount(), "500.00");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getCurrentRemainingBalance().getCurrencyCode(), "USD");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-12-01T00:00:00Z");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getTimePeriodEndDate(), xgc2);
        final XMLGregorianCalendar xgc4 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-01T00:00:00Z");
        Assert.assertEquals(res.getDetails().getBillingAgreementLimits().getTimePeriodStartDate(), xgc4);
        Assert.assertEquals(res.getRequestId(), "a01ae213-296b-4c33-bb92-0c4ad4192787");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testConfirmBillingAgreementDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("ConfirmBillingAgreementResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final ConfirmBillingAgreementResponseData res = Parser.confirmBillingAgreementResponse(response);
        Assert.assertEquals(res.getRequestId(), "3d1db999-b790-47bb-87d3-9c673c38a1ed");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testValidateBillingAgreementResponse() throws Exception {
        final String rawResponse = loadTestFile("ValidateBillingAgreementResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final ValidateBillingAgreementResponseData res = Parser.getValidateBillingAgreementResponse(response);
        Assert.assertEquals(RequestStatus.SUCCESS, res.getResult().getValidationResult());
        Assert.assertEquals("Open", res.getResult().getBillingAgreementStatus().getState());
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-02T17:38:29.511Z");
        Assert.assertEquals(xgc, res.getResult().getBillingAgreementStatus().getLastUpdatedTimestamp());
        Assert.assertEquals(res.getRequestId(), "0f48a4e0-2a7c-4036-9a8a-339e419fd53f");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testAuthorizeOnBillingAgreementResponse() throws Exception {
        final String rawResponse = loadTestFile("AuthorizeOnBillingAgreementResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final AuthorizeOnBillingAgreementResponseData res = Parser.getAuthorizeOnBillingAgreement(response);
        Assert.assertEquals(res.getDetails().getAuthorizationAmount().getAmount(), "1.00");
        Assert.assertEquals(res.getDetails().getAuthorizationAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getCapturedAmount().getAmount(), "0");
        Assert.assertEquals(res.getDetails().getCapturedAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getSoftDescriptor(), "AMZ*AMZN*test");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-12-02T17:39:58.272Z");
        Assert.assertEquals(res.getDetails().getExpirationTimestamp(), xgc);
        Assert.assertEquals(res.getDetails().getIdList().getMember().get(0), "S01-7347515-9699585-C012416");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-02T17:39:58.272Z");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getState(), "Closed");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getReasonCode(), "MaxCapturesProcessed");
        Assert.assertEquals(res.getDetails().getAuthorizationStatus().getReasonDescription(), null);
        Assert.assertEquals(res.getDetails().getAuthorizationFee().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getAuthorizationFee().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().isCaptureNow(), true);
        final XMLGregorianCalendar xgc3 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-12-02T17:39:58.272Z");
        Assert.assertEquals(res.getDetails().getExpirationTimestamp(), xgc3);
        Assert.assertEquals(res.getDetails().getSellerAuthorizationNote(), "testing");
        Assert.assertEquals(res.getDetails().getAmazonAuthorizationId(), "S01-7347515-9699585-A012416");
        Assert.assertEquals(res.getDetails().getAuthorizationReferenceId(), "8233239-775229");
        Assert.assertEquals(res.getAmazonOrderReferenceId(), "S01-7347515-9699585");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testCloseBillingAgreementResponse() throws Exception {
        final String rawResponse = loadTestFile("CloseBillingAgreementResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final CloseBillingAgreementResponseData res = Parser.closeBillingAgreementResponse(response);
        Assert.assertEquals(res.getRequestId(), "7541230f-e349-4180-a4ac-ba9f2cf6ac79");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testRefundResponse() throws Exception {
        final String rawResponse = loadTestFile("RefundResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final RefundResponseData res = Parser.getRefundData(response);
        Assert.assertEquals(res.getDetails().getRefundReferenceId(), "testRefundId1354077");
        Assert.assertEquals(res.getDetails().getAmazonRefundId(), "S01-5695290-1354077-R072290");
        Assert.assertEquals(res.getDetails().getRefundType().SELLER_INITIATED, RefundType.SELLER_INITIATED);
        Assert.assertEquals(res.getDetails().getFeeRefunded().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getFeeRefunded().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getRefundStatus().getState(), "Pending");
        Assert.assertEquals(res.getDetails().getRefundStatus().getReasonCode(), null);
        Assert.assertEquals(res.getDetails().getRefundStatus().getReasonDescription(), null);
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-02T21:18:17.751Z");
        Assert.assertEquals(res.getDetails().getRefundStatus().getLastUpdateTimestamp(), xgc);
        Assert.assertEquals(res.getDetails().getSoftDescriptor(), "AMZ*test");
        Assert.assertEquals(res.getDetails().getSellerRefundNote(), "testing");
        Assert.assertEquals(res.getDetails().getRefundAmount().getAmount(), "0.50");
        Assert.assertEquals(res.getDetails().getProviderCreditReversalSummaryList(), null);

        Assert.assertEquals(res.getRequestId(), "2be495ee-0a86-4357-a6a5-5f0af88398d9");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testGetRefundDetailsResponse() throws Exception {
        final String rawResponse = loadTestFile("GetRefundDetails.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetRefundDetailsResponseData res = Parser.getRefundDetailsData(response);
        Assert.assertEquals(res.getDetails().getRefundReferenceId(), "testRefundId1354077");
        Assert.assertEquals(res.getDetails().getAmazonRefundId(), "S01-5695290-1354077-R072290");
        Assert.assertEquals(res.getDetails().getRefundType().SELLER_INITIATED, RefundType.SELLER_INITIATED);
        Assert.assertEquals(res.getDetails().getRefundAmount().getAmount(), "0.50");
        Assert.assertEquals(res.getDetails().getRefundAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getFeeRefunded().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getFeeRefunded().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getRefundStatus().getState(), "Completed");
        Assert.assertEquals(res.getDetails().getRefundStatus().getReasonCode(), null);
        Assert.assertEquals(res.getDetails().getRefundStatus().getReasonDescription(), null);
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-02T21:18:48.932Z");
        Assert.assertEquals(res.getDetails().getRefundStatus().getLastUpdateTimestamp(), xgc);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-02T21:18:17.751Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc2);
        Assert.assertEquals(res.getDetails().getProviderCreditReversalSummaryList(), null);

        Assert.assertEquals(res.getRequestId(), "98cdadd5-8b44-4757-8e4f-351f39af7fcf");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testGetRefundDetailsResponseMulticurrency() throws Exception {
        final String rawResponse = loadTestFile("GetRefundDetails_Multicurrency.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetRefundDetailsResponseData res = Parser.getRefundDetailsData(response);
        Assert.assertEquals(res.getDetails().getRefundReferenceId(), "aed9ba8bee564c8cb943bd6481633ad1");
        Assert.assertEquals(res.getDetails().getAmazonRefundId(), "S02-8274313-3487267-R019346");
        Assert.assertEquals(res.getDetails().getRefundType().SELLER_INITIATED, RefundType.SELLER_INITIATED);
        Assert.assertEquals(res.getDetails().getRefundAmount().getAmount(), "0.33");
        Assert.assertEquals(res.getDetails().getRefundAmount().getCurrencyCode(), "NOK");
        Assert.assertEquals(res.getDetails().getFeeRefunded().getAmount(), "0.00");
        Assert.assertEquals(res.getDetails().getFeeRefunded().getCurrencyCode(), "EUR");
        Assert.assertEquals(res.getDetails().getRefundStatus().getState(), "Completed");
        Assert.assertEquals(res.getDetails().getRefundStatus().getReasonCode(), null);
        Assert.assertEquals(res.getDetails().getRefundStatus().getReasonDescription(), null);
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-28T18:15:07.659Z");
        Assert.assertEquals(res.getDetails().getRefundStatus().getLastUpdateTimestamp(), xgc);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-28T18:14:34.752Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), xgc2);
        Assert.assertEquals(res.getDetails().getProviderCreditReversalSummaryList(), null);
	Assert.assertEquals(res.getDetails().getSoftDescriptor(), "AMZ*Matt's Test Stor");

        // The three new multi-currency specific fields
        Assert.assertEquals(res.getDetails().getConvertedAmount().getAmount(), "0.03");
        Assert.assertEquals(res.getDetails().getConvertedAmount().getCurrencyCode(), "EUR");
        Assert.assertEquals(res.getDetails().getConversionRate(), "9.9248293483");

        Assert.assertEquals(res.getRequestId(), "3b14705b-0a11-4b05-98d3-eb62c9bf1d22");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testGetServiceStatusGreenI() throws Exception {
        final String rawResponse = loadTestFile("GetServiceStatusResponseGreenI.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetServiceStatusResponseData res = Parser.getServiceStatus(response);

        Assert.assertEquals(res.getStatus(), ServiceStatus.GREEN_I);
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2010-11-01T21:38:09.676Z");
        Assert.assertEquals(res.getTimestamp(), xgc);
        Assert.assertEquals(res.getMessageId(), "173964729I");

        final MessageList messages = res.getMessages();
        final List<Message> messageList = messages.getMessages();
        final Message message1 = messageList.get(0);
        final Message message2 = messageList.get(1);

        Assert.assertEquals(message1.getLocale(), "en_UK");
        Assert.assertEquals(message1.getText(), "We are experiencing high latency in UK because of heavy traffic.");
        Assert.assertEquals(message2.getLocale(), "en_US");
        Assert.assertEquals(message2.getText(), "Service is once again operating at normal capacity at 6:53 PST.");

        Assert.assertEquals(res.getRequestId(), "d80c6c7b-f7c7-4fa7-bdd7-854711cb3bcc");
        Assert.assertEquals(res.toXML(), rawResponse);
    }

    @Test
    public void testGetServiceStatusGreen() throws Exception {
        final String rawResponse = loadTestFile("GetServiceStatusResponseGreen.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final GetServiceStatusResponseData res = Parser.getServiceStatus(response);

        Assert.assertEquals(res.getStatus(), ServiceStatus.GREEN);
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2016-11-27T02:57:30.504Z");
        Assert.assertEquals(res.getTimestamp(), xgc);
        Assert.assertNull(res.getMessageId());
        Assert.assertNull(res.getMessages());

        Assert.assertEquals(res.getRequestId(), "93437336-70dd-4359-b453-f13a90dccb99");
        Assert.assertEquals(res.toXML(), rawResponse);
    }


    @Test
    public void testCreateOrderReferenceForIdResponse() throws Exception {
        final String rawResponse = loadTestFile("CreateOrderReferenceForIdResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        final CreateOrderReferenceForIdResponseData res = Parser.createOrderReferenceForId(response);

        Assert.assertEquals(res.getRequestId(), "4d5e0306-257e-4a13-b2ad-45b891c3de2a");
        Assert.assertEquals(res.getDetails().getAmazonOrderReferenceId(), "S01-6910968-3348607");
        Assert.assertEquals(res.getDetails().getOrderReferenceStatus().getState(), "Open");
        final XMLGregorianCalendar lastUpdateTimestamp =
                DatatypeFactory.newInstance().newXMLGregorianCalendar("2016-11-28T03:23:22.159Z");
        Assert.assertEquals(res.getDetails().getOrderReferenceStatus().getLastUpdateTimestamp(), lastUpdateTimestamp);
        Assert.assertEquals(res.getDetails().getDestination().getDestinationType(), "Physical");
        Assert.assertEquals(res.getDetails().getReleaseEnvironment().value(), "SANDBOX");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCountryCode(), "US");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getCity(), "Chicago");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getPostalCode(), "60602");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getStateOrRegion(), "IL");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getAddressLine1(), "10 Ditka Ave");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getAddressLine2(), "Suite 2500");
        Assert.assertEquals(res.getDetails().getDestination().getPhysicalDestination().getPhone(), "800-000-0000");
        Assert.assertEquals(res.getDetails().getSellerOrderAttributes().getStoreName(), "Top of the World Store");
        Assert.assertEquals(res.getDetails().getSellerOrderAttributes().getCustomInformation(), "One two three four five");
        Assert.assertEquals(res.getDetails().getSellerOrderAttributes().getSellerOrderId(), "OR# 12345");
        Assert.assertEquals(res.getDetails().getParentDetails().getType(), Type.BILLING_AGREEMENT);
        Assert.assertEquals(res.getDetails().getParentDetails().getId(), "C01-5996379-1389374");
        Assert.assertEquals(res.getDetails().getOrderTotal().getCurrencyCode(), "USD");
        Assert.assertEquals(res.getDetails().getOrderTotal().getAmount(), "0.45");
        final XMLGregorianCalendar expirationTimestamp =
                DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-05-27T03:23:21.923Z");
        Assert.assertEquals(res.getDetails().getExpirationTimestamp(), expirationTimestamp);
        final XMLGregorianCalendar creationTimestamp =
                DatatypeFactory.newInstance().newXMLGregorianCalendar("2016-11-28T03:23:21.923Z");
        Assert.assertEquals(res.getDetails().getCreationTimestamp(), creationTimestamp);
        Assert.assertEquals(res.getDetails().getSellerNote(), "My seller note goes here");
        Assert.assertEquals(res.getDetails().getRequestPaymentAuthorization(), "false");
        Assert.assertEquals(res.getDetails().getBuyer().getName(), "Sandbox Guillot");
        Assert.assertEquals(res.getDetails().getBuyer().getEmail(), "not+a+real+email@inter.net");

        Assert.assertEquals(res.toXML(), rawResponse);
    }



    @Test
    // This test purposefully causes an Exception by trying to parse results of a
    // GetAuthorizationDetails API call with the RefundDetails parser.
    // It's essentially just confirming we end up in the catch block.
    // I'm adding this comment in case you turn on the special event handler
    // for debugging purposes, and see strange FATAL_ERROR messages scrolling by:
    // Setting special event handlerDefaultValidationEventHandler:
    // [FATAL_ERROR]: unexpected element (uri:"http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01", local:"GetAuthorizationDetailsResponse").
    // Expected elements are <{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}GetRefundDetailsResponse>,
    // <{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}GetRefundDetailsResult>,<{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ResponseMetadata>
    public void testJAXBExceptionResponse() throws Exception {
        final String rawResponse = loadTestFile("GetAuthorizationDetailsResponse.xml");
        final ResponseData response = new ResponseData(200, rawResponse);
        try {
            final GetRefundDetailsResponseData res = Parser.getRefundDetailsData(response);
            Assert.fail();
        } catch (AmazonClientException e) {
            Assert.assertEquals(e.getResponseXml(), rawResponse);
            Assert.assertEquals(e.getStatusCode(), 200);
        }
    }

    @Test
    public void testErrorResponse() throws Exception {

        final String rawResponse = loadTestFile("ErrorResponse.xml");
        final ResponseData response = new ResponseData(404, rawResponse);
        try {
            Parser.marshalXML(ErrorResponse.class, response);
            Assert.fail();
        } catch (AmazonServiceException e) {
            Assert.assertEquals(e.getResponseXml(), rawResponse);
            Assert.assertEquals(e.getStatusCode(), 404);
            Assert.assertEquals(e.getErrorCode(), "OrderReferenceNotModifiable");
            Assert.assertEquals(e.getErrorType(), "Sender");
            Assert.assertEquals(e.getRequestId(), "6d4699b8-1238-4c09-b539-176e2c2f5462");
            Assert.assertEquals(e.getErrorMessage(), "OrderReference S01-5695290-1354077 is not in draft state and cannot be modified with the request submitted by you.");

        }
    }
}

