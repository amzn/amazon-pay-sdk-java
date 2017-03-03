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
package com.amazon.pay.response.parser;

import com.amazon.pay.response.model.AuthorizeOnBillingAgreementResponse;
import com.amazon.pay.response.model.AuthorizeResponse;
import com.amazon.pay.response.model.CaptureResponse;
import com.amazon.pay.response.model.CancelOrderReferenceResponse;
import com.amazon.pay.response.model.CloseAuthorizationResponse;
import com.amazon.pay.response.model.CloseBillingAgreementResponse;
import com.amazon.pay.response.model.CloseOrderReferenceResponse;
import com.amazon.pay.response.model.ConfirmBillingAgreementResponse;
import com.amazon.pay.response.model.ConfirmOrderReferenceResponse;
import com.amazon.pay.response.model.CreateOrderReferenceForIdResponse;
import com.amazon.pay.response.model.ErrorResponse;
import com.amazon.pay.response.model.GetAuthorizationDetailsResponse;
import com.amazon.pay.response.model.GetBillingAgreementDetailsResponse;
import com.amazon.pay.response.model.GetCaptureDetailsResponse;
import com.amazon.pay.response.model.GetOrderReferenceDetailsResponse;
import com.amazon.pay.response.model.GetProviderCreditReversalDetailsResponse;
import com.amazon.pay.response.model.GetProviderCreditDetailsResponse;
import com.amazon.pay.response.model.GetRefundDetailsResponse;
import com.amazon.pay.response.model.GetServiceStatusResponse;
import com.amazon.pay.response.model.RefundResponse;
import com.amazon.pay.response.model.ReverseProviderCreditResponse;
import com.amazon.pay.response.model.SetBillingAgreementDetailsResponse;
import com.amazon.pay.response.model.SetOrderReferenceDetailsResponse;
import com.amazon.pay.response.model.ValidateBillingAgreementResponse;
import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.exceptions.AmazonServiceException;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Parser {

    public static GetOrderReferenceDetailsResponseData getOrderReferenceDetails(ResponseData rawResponse) throws AmazonServiceException {
        GetOrderReferenceDetailsResponse response = marshalXML(GetOrderReferenceDetailsResponse.class, rawResponse);
        return new GetOrderReferenceDetailsResponseData(response, rawResponse);
    }


    public static SetOrderReferenceDetailsResponseData setOrderReferenceDetails(ResponseData rawResponse) throws AmazonServiceException {
        SetOrderReferenceDetailsResponse response = marshalXML(SetOrderReferenceDetailsResponse.class, rawResponse);
        return new SetOrderReferenceDetailsResponseData(response, rawResponse);
    }


    public static AuthorizeResponseData getAuthorizeData(ResponseData rawResponse) throws AmazonServiceException {
        AuthorizeResponse response = marshalXML(AuthorizeResponse.class, rawResponse);
        return new AuthorizeResponseData(response, rawResponse);
    }

    public static GetAuthorizationDetailsResponseData getAuthorizationDetailsData(ResponseData rawResponse) throws AmazonServiceException {
        GetAuthorizationDetailsResponse response = marshalXML(GetAuthorizationDetailsResponse.class, rawResponse);
        return new GetAuthorizationDetailsResponseData(response, rawResponse);
    }

    public static CaptureResponseData getCapture(ResponseData rawResponse) throws AmazonServiceException {
        CaptureResponse response = marshalXML(CaptureResponse.class, rawResponse);
        return new CaptureResponseData(response, rawResponse);
    }

    public static GetCaptureDetailsResponseData getCaptureDetailsData(ResponseData rawResponse) throws AmazonServiceException {
        GetCaptureDetailsResponse response = marshalXML(GetCaptureDetailsResponse.class, rawResponse);
        return new GetCaptureDetailsResponseData(response, rawResponse);
    }

    public static ConfirmOrderReferenceResponseData confirmOrderReference(ResponseData rawResponse) throws AmazonServiceException {
        ConfirmOrderReferenceResponse response = marshalXML(ConfirmOrderReferenceResponse.class, rawResponse);
        return new ConfirmOrderReferenceResponseData(response, rawResponse);
    }

    public static CloseAuthorizationResponseData closeAuthorizationResponse(ResponseData rawResponse) throws AmazonServiceException {
        CloseAuthorizationResponse response = marshalXML(CloseAuthorizationResponse.class, rawResponse);
        return new CloseAuthorizationResponseData(response, rawResponse);
    }

    public static CancelOrderReferenceResponseData getCancelOrderReference(ResponseData rawResponse) throws AmazonServiceException {
        CancelOrderReferenceResponse response = marshalXML(CancelOrderReferenceResponse.class, rawResponse);
        return new CancelOrderReferenceResponseData(response, rawResponse);
    }

    public static CloseOrderReferenceResponseData getCloseOrderReference(ResponseData rawResponse) throws AmazonServiceException {
        CloseOrderReferenceResponse response = marshalXML(CloseOrderReferenceResponse.class, rawResponse);
        return new CloseOrderReferenceResponseData(response, rawResponse);
    }

    public static RefundResponseData getRefundData(ResponseData rawResponse) throws AmazonServiceException {
        RefundResponse response = marshalXML(RefundResponse.class, rawResponse);
        return new RefundResponseData(response, rawResponse);
    }

    public static GetRefundDetailsResponseData getRefundDetailsData(ResponseData rawResponse) throws AmazonServiceException {
        GetRefundDetailsResponse response = marshalXML(GetRefundDetailsResponse.class, rawResponse);
        return new GetRefundDetailsResponseData(response, rawResponse);
    }

    public static GetBillingAgreementDetailsResponseData getBillingAgreementDetailsData(ResponseData rawResponse) throws AmazonServiceException {
        GetBillingAgreementDetailsResponse response = marshalXML(GetBillingAgreementDetailsResponse.class, rawResponse);
        return new GetBillingAgreementDetailsResponseData(response, rawResponse);
    }

    public static SetBillingAgreementDetailsResponseData getSetBillingAgreementDetailsResponse(ResponseData rawResponse) throws AmazonServiceException {
        SetBillingAgreementDetailsResponse response = marshalXML(SetBillingAgreementDetailsResponse.class, rawResponse);
        return new SetBillingAgreementDetailsResponseData(response, rawResponse);
    }

    public static ValidateBillingAgreementResponseData getValidateBillingAgreementResponse(ResponseData rawResponse) throws AmazonServiceException {
        ValidateBillingAgreementResponse response = marshalXML(ValidateBillingAgreementResponse.class, rawResponse);
        return new ValidateBillingAgreementResponseData(response, rawResponse);
    }

    public static ConfirmBillingAgreementResponseData confirmBillingAgreementResponse(ResponseData rawResponse) throws AmazonServiceException {
        ConfirmBillingAgreementResponse response = marshalXML(ConfirmBillingAgreementResponse.class, rawResponse);
        return new ConfirmBillingAgreementResponseData(response, rawResponse);
    }

    public static AuthorizeOnBillingAgreementResponseData getAuthorizeOnBillingAgreement(ResponseData rawResponse) throws AmazonServiceException {
        AuthorizeOnBillingAgreementResponse response = marshalXML(AuthorizeOnBillingAgreementResponse.class, rawResponse);
        return new AuthorizeOnBillingAgreementResponseData(response, rawResponse);
    }

    public static CloseBillingAgreementResponseData closeBillingAgreementResponse(ResponseData rawResponse) throws AmazonServiceException {
        CloseBillingAgreementResponse response = marshalXML(CloseBillingAgreementResponse.class, rawResponse);
        return new CloseBillingAgreementResponseData(response, rawResponse);
    }

    public static GetProviderCreditDetailsResponseData getGetProviderCreditDetails(ResponseData rawResponse) throws AmazonServiceException {
        GetProviderCreditDetailsResponse response = marshalXML(GetProviderCreditDetailsResponse.class, rawResponse);
        return new GetProviderCreditDetailsResponseData(response, rawResponse);
    }

    public static GetProviderCreditReversalDetailsResponseData getProviderCreditReversalDetails(ResponseData rawResponse) throws AmazonServiceException {
        GetProviderCreditReversalDetailsResponse response = marshalXML(GetProviderCreditReversalDetailsResponse.class, rawResponse);
        return new GetProviderCreditReversalDetailsResponseData(response, rawResponse);
    }

    public static ReverseProviderCreditResponseData getReverseProviderCreditResponseData(ResponseData rawResponse) throws AmazonServiceException {
        ReverseProviderCreditResponse response = marshalXML(ReverseProviderCreditResponse.class, rawResponse);
        return new ReverseProviderCreditResponseData(response, rawResponse);
    }

    public static GetServiceStatusResponseData getServiceStatus(
                ResponseData rawResponse) throws AmazonServiceException {
        final GetServiceStatusResponse response = marshalXML(
                GetServiceStatusResponse.class, rawResponse);
        return new GetServiceStatusResponseData(response, rawResponse);
    }

    public static CreateOrderReferenceForIdResponseData createOrderReferenceForId(
                ResponseData rawResponse) throws AmazonServiceException {
        final CreateOrderReferenceForIdResponse response = marshalXML(
                CreateOrderReferenceForIdResponse.class, rawResponse);
        return new CreateOrderReferenceForIdResponseData(response, rawResponse);
    }

    public static <T> T marshalXML(Class<T> clazz, ResponseData rawResponse) throws AmazonServiceException  {
        try {
            if (rawResponse.getStatusCode() == 200) {
                T responseObject = null;
                JAXBContext context = JAXBContext.newInstance(clazz);
                StringReader reader = new StringReader(rawResponse.toXML());
                Unmarshaller unmarshaller = context.createUnmarshaller();

                // If you need to do some deep dive troubleshooting to trace hard to find
                // XML parsing/unmarshalling issues, consider uncommenting the next line:
                // unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

                XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
                xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
                xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
                XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
                responseObject = (T) unmarshaller.unmarshal(xmlStreamReader);

                return responseObject;
            } else {
                generateErrorException(rawResponse);
            }
        } catch (JAXBException e) {
            throw new AmazonClientException(rawResponse, "Encountered marshalling error while marshalling data " + rawResponse.toXML(), e);
        }
        catch (XMLStreamException e) {
            throw new AmazonClientException(rawResponse, "Encountered marshalling error while marshalling data " + rawResponse.toXML(), e);
        }

        return null;
    }

    public static void generateErrorException(ResponseData rawResponse) throws AmazonServiceException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(ErrorResponse.class);
        StringReader reader = new StringReader(rawResponse.toXML());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        try {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            ErrorResponse result = (ErrorResponse) unmarshaller.unmarshal(xmlStreamReader);
            throw new AmazonServiceException(result, rawResponse);
        } catch (XMLStreamException e) {
            throw new AmazonClientException(rawResponse, "Encountered marshalling error while marshalling data " + rawResponse.toXML(), e);
        }
    }
}
