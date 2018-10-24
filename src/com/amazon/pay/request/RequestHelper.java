/**
 * Copyright 2016-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.request;

import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.impl.PayConfig;
import com.amazon.pay.impl.PayLogUtil;
import com.amazon.pay.impl.Util;
import com.amazon.pay.response.model.Price;
import com.amazon.pay.response.model.ProviderCredit;
import com.amazon.pay.types.OrderReferenceStatus;
import com.amazon.pay.types.ServiceConstants;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class RequestHelper {

    public PayConfig payConfig;
    private PayLogUtil payUtil;


    public RequestHelper(PayConfig payConfig) {
        this.payConfig = payConfig;
        this.payUtil = new PayLogUtil();
    }

    private Map<String,String> addClientParameters(Map<String,String> params, DelegateRequest request) {
        try {
            if ((request != null) && (request.getMwsAuthToken() != null)) {
                params.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
            }

            if ((request != null) && (request.getSellerId() != null)) {
                params.put(ServiceConstants.SELLER_ID, request.getSellerId());
            } else {
                params.put(ServiceConstants.SELLER_ID, payConfig.getSellerId());
            }

            params.put(ServiceConstants.AWSACCESSKEYID, payConfig.getAccessKey());
            params.put(ServiceConstants.SIGNATUREVERSION, "2");
            params.put(ServiceConstants.SIGNATUREMETHOD, "HmacSHA256");
            params.put(ServiceConstants.VERSION, ServiceConstants.AMAZON_PAY_API_VERSION);
            params.put(ServiceConstants.TIMESTAMP, Util.getTimestamp());
            Util.urlEncodeAPIParams(params);
            String signature = constructSignature(params);
            params.put(ServiceConstants.SIGNATURE, signature);
            return params;
        } catch (UnsupportedEncodingException e) {
            throw new AmazonClientException("Encountered client exception:", e);
        }
    }

    private String constructSignature(Map<String, String> params) {
        String signature = null;
        try {
            String domainName;
            if (payConfig.getOverrideServiceURL() != null) {
                domainName = payConfig.getOverrideServiceURL();
            } else {
                domainName = ServiceConstants.mwsEndpointMappings.get(payConfig.getRegion());
            }
            final String postHeader = "POST\n" + domainName.replace("https://", "")  + "\n" + Util.getServiceVersionName(payConfig.getEnvironment()) + "\n";
            final Map<String, String> sortedParams = new TreeMap<String, String>();
            sortedParams.putAll(params);

            /* Log all the client parameters */
            payUtil.logMessage("Client Parameters: " + sortedParams.toString());

            final String stringToSign = postHeader + Util.convertParameterMapToString(sortedParams);
            signature = Util.urlEncode(Util.getSignature(stringToSign, payConfig.getSecretKey()));
        } catch (UnsupportedEncodingException ex) {
            throw new AmazonClientException("Encountered UnsupportedEncodingException:", ex);
        } catch (IllegalStateException ex) {
            throw new AmazonClientException("Encountered IllegalStateException:", ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new AmazonClientException("Encountered NoSuchAlgorithmException:", ex);
        } catch (InvalidKeyException ex) {
            throw new AmazonClientException("Encountered InvalidKeyException:", ex);
        }
        return signature;
    }


    public  String getPostURL(GetOrderReferenceDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_ORDER_REFERENCE_DETAILS);
        if (request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        }
        if (request.getAddressConsentToken() != null) {
            parameters.put(ServiceConstants.ADDRESS_CONSENT_TOKEN, request.getAddressConsentToken());
        }
        if (request.getAccessToken() != null) {
            parameters.put(ServiceConstants.ACCESS_TOKEN, request.getAccessToken());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(SetOrderReferenceDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String, String>();
        if (request.getOrderCurrencyCode() == null)
            request.setOrderCurrencyCode(payConfig.getCurrencyCode());

        parameters.put(ServiceConstants.ACTION, ServiceConstants.SET_ORDER_REFERENCE_DETAILS);
        if (request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        }
        if (request.getOrderAmount() != null) {
            parameters.put(ServiceConstants.ORDER_AMOUNT, request.getOrderAmount());
        }
        if (request.getOrderCurrencyCode() != null) {
            parameters.put(ServiceConstants.ORDER_CURRENCY_CODE, request.getOrderCurrencyCode().toString());
        }
        if (request.getPlatformId() != null) {
            parameters.put(ServiceConstants.PLATFORM_ID, request.getPlatformId());
        }
        if (request.getSellerNote() != null) {
            parameters.put(ServiceConstants.SELLER_NOTE, request.getSellerNote());
        }
        if (request.getSellerOrderId() != null) {
            parameters.put(ServiceConstants.SELLER_ORDER_ID, request.getSellerOrderId());
        }
        if (request.getStoreName() != null) {
            parameters.put(ServiceConstants.STORE_NAME, request.getStoreName());
        }
        if (request.getSupplementaryData() != null) {
            parameters.put(ServiceConstants.SUPPLEMENTARY_DATA, request.getSupplementaryData());
        }
        if (request.getCustomInformation() != null) {
            parameters.put(ServiceConstants.CUSTOM_INFORMATION, request.getCustomInformation());
        }
        if (request.getRequestPaymentAuthorization() != null) {
            parameters.put(ServiceConstants.REQUEST_PAYMENT_AUTHORIZATION, Boolean.toString(request.getRequestPaymentAuthorization()));
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(AuthorizeRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        if (request.getAuthorizationCurrencyCode() == null)
            request.setAuthorizationCurrencyCode(payConfig.getCurrencyCode());

        parameters.put(ServiceConstants.ACTION, ServiceConstants.AUTHORIZE);
        if (request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        }
        if (request.getAuthorizationReferenceId() != null) {
            parameters.put(ServiceConstants.AUTHORIZATION_REFERENCE_ID, request.getAuthorizationReferenceId());
        }
        if (request.getAuthorizationAmount() != null) {
            parameters.put(ServiceConstants.AUTHORIZATION_AMOUNT, request.getAuthorizationAmount());
        }
        if (request.getAuthorizationCurrencyCode() != null) {
            parameters.put(ServiceConstants.AUTHORIZATION_CURRENCEYCODE, request.getAuthorizationCurrencyCode().toString());
        }
        if (request.getSellerAuthorizationNote() != null) {
            parameters.put(ServiceConstants.SELLER_AUTHORIZATION_NOTE, request.getSellerAuthorizationNote());
        }
        if (request.getTransactionTimeout() != null) {
            parameters.put(ServiceConstants.TRANSACTION_TIMEOUT, request.getTransactionTimeout());
        }
        if (request.getCaptureNow() != null) {
            parameters.put(ServiceConstants.CAPTURE_NOW, Boolean.toString(request.getCaptureNow()));
        }
        if (request.getSoftDescriptor() != null) {
            parameters.put(ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        }
        if (request.getProviderCredit() != null) {
            addProviderCreditToParamMap(request.getProviderCredit(), parameters);
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(GetAuthorizationDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_AUTHORIZATION_DETAILS);
        if (request.getAmazonAuthorizationId() != null) {
            parameters.put(ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(CaptureRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.CAPTURE);

        if (request.getCaptureCurrencyCode() == null)
            request.setCaptureCurrencyCode(payConfig.getCurrencyCode());

        if (request.getAmazonAuthorizationId() != null) {
            parameters.put( ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId());
        }
        if (request.getCaptureReferenceId() != null) {
            parameters.put( ServiceConstants.CAPTURE_REFERENCE_ID, request.getCaptureReferenceId());
        }
        if (request.getCaptureAmount() != null) {
            parameters.put( ServiceConstants.CAPTURE_AMOUNT, request.getCaptureAmount());
        }
        if (request.getCaptureCurrencyCode() != null) {
            parameters.put( ServiceConstants.CAPTURE_CURRENCEYCODE, request.getCaptureCurrencyCode().toString());
        }
        if (request.getSellerCaptureNote() != null) {
            parameters.put( ServiceConstants.CAPTURE_NOTE, request.getSellerCaptureNote());
        }
        if (request.getSoftDescriptor() != null) {
            parameters.put( ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        }
        if (request.getProviderCredit() != null) {
            addProviderCreditToParamMap(request.getProviderCredit(), parameters);
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(GetCaptureDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_CAPTURE_DETAILS);
        if (request.getAmazonCaptureId() != null) {
            parameters.put(ServiceConstants.AMAZON_CAPTURE_ID, request.getAmazonCaptureId());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(ConfirmOrderReferenceRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.CONFIRM_ORDER_REFERENCE);
        if (request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(CancelOrderReferenceRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.CANCEL_ORDER_REFERENCE);
        if (request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        }
        if (request.getCancelationReason() != null) {
            parameters.put(ServiceConstants.CANCELATION_REASON, request.getCancelationReason());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(CloseOrderReferenceRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.CLOSE_ORDER_REFERENCE);
        if (request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        }
        if (request.getClosureReason() != null) {
            parameters.put(ServiceConstants.CLOSURE_REASON, request.getClosureReason());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(CloseAuthorizationRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.CLOSE_AUTHORIZATION);
        if (request.getAmazonAuthorizationId() != null) {
            parameters.put(ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId());
        }
        if (request.getClosureReason() != null) {
            parameters.put(ServiceConstants.CLOSURE_REASON, request.getClosureReason());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(RefundRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.REFUND);
        if (request.getRefundCurrencyCode() == null)
            request.setRefundCurrencyCode(payConfig.getCurrencyCode());

        if (request.getAmazonCaptureId() != null) {
            parameters.put(ServiceConstants.AMAZON_CAPTURE_ID, request.getAmazonCaptureId());
        }
        if (request.getRefundReferenceId() != null) {
            parameters.put(ServiceConstants.REFUND_REFERENCE_ID, request.getRefundReferenceId());
        }
        if (request.getRefundAmount() != null) {
            parameters.put(ServiceConstants.REFUND_AMOUNT, request.getRefundAmount());
        }
        if (request.getRefundCurrencyCode() != null) {
            parameters.put(ServiceConstants.REFUND_AMOUNT_CURRENCY_CODE, request.getRefundCurrencyCode().toString());
        }
        if (request.getSellerRefundNote() != null) {
            parameters.put(ServiceConstants.SELLER_REFUND_NOTE, request.getSellerRefundNote());
        }
        if (request.getSoftDescriptor() != null) {
            parameters.put(ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        }
        if (request.getProviderCredit() != null) {
            addProviderCreditToParamMap(request.getProviderCredit(), parameters);
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(GetRefundDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_REFUND_DETAILS);
        if (request.getAmazonRefundId() != null) {
            parameters.put(ServiceConstants.AMAZON_REFUND_ID, request.getAmazonRefundId());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(GetProviderCreditDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_PROVIDER_CREDIT_DETAILS);
        if (request.getAmazonProviderCreditId() != null) {
            parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_ID, request.getAmazonProviderCreditId());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(GetProviderCreditReversalDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_REVERSE_PROVIDER_CREDIT_DETAILS);
        if (request.getAmazonProviderCreditReversalId() != null) {
            parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_REVERSAL_ID, request.getAmazonProviderCreditReversalId());
        }
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(ReverseProviderCreditRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.REVERSE_PROVIDER_CREDIT_DETAILS);
        if (request.getCreditReversalAmountCurrencyCode() == null)
            request.setCreditReversalCurrencyCode(payConfig.getCurrencyCode());
        if (request.getAmazonProviderCreditId() != null)
            parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_ID, request.getAmazonProviderCreditId());
        if (request.getCreditReversalReferenceId() != null)
            parameters.put(ServiceConstants.CREDIT_REVERSAL_REFERENCE_ID, request.getCreditReversalReferenceId());
        if (request.getCreditReversalAmount() != null)
            parameters.put(ServiceConstants.CREDIT_REVERSAL_AMOUNT, request.getCreditReversalAmount());
        if (request.getCreditReversalAmountCurrencyCode() != null)
            parameters.put(ServiceConstants.CREDIT_REVERSAL_AMOUNT_CURRENCY_CODE, request.getCreditReversalAmountCurrencyCode().toString());
        if (request.getCreditReversalNote() != null)
            parameters.put(ServiceConstants.CREDIT_REVERSAL_NOTE, request.getCreditReversalNote());
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(GetBillingAgreementDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_BILLING_AGREEMENT_DETAILS);
        if (request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if (request.getAddressConsentToken() != null)
            parameters.put(ServiceConstants.ADDRESS_CONSENT_TOKEN , request.getAddressConsentToken());
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(SetBillingAgreementDetailsRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.SET_BILLING_AGREEMENT_DETAILS);
        if (request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if (request.getPlatformId() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_PLATFORM_ID, request.getPlatformId());
        if (request.getSellerNote() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_SELLER_NOTE, request.getSellerNote());
        if (request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_SELLER_BILLING_AGREEMENT_ID, request.getSellerBillingAgreementId());
        if (request.getStoreName() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_SELLER_STORE_NAME, request.getStoreName());
        if (request.getCustomInformation() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_SELLER_CUSTOM_INFORMATION, request.getCustomInformation());
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(ConfirmBillingAgreementRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.CONFIRM_BILLING_AGREEMENT_DETAILS);
        if (request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(CloseBillingAgreementRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.CLOSE_BILLING_AGREEMENT_DETAILS);
        if (request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if (request.getClosureReason() != null)
            parameters.put(ServiceConstants.CLOSURE_REASON, request.getClosureReason());
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(AuthorizeOnBillingAgreementRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.AUTHORIZE_BILLING_AGREEMENT_DETAILS);
        if (request.getAuthorizationCurrencyCode() == null)
            request.setAuthorizationCurrencyCode(payConfig.getCurrencyCode());
        if (request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if (request.getAuthorizationReferenceId()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_REFERENCE_ID, request.getAuthorizationReferenceId());
        if (request.getAuthorizationAmount()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_AMOUNT, request.getAuthorizationAmount());
        if (request.getAuthorizationCurrencyCode()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_CURRENCEYCODE, request.getAuthorizationCurrencyCode().toString());
        if (request.getSellerAuthorizationNote()  != null)
            parameters.put(ServiceConstants.SELLER_AUTHORIZATION_NOTE, request.getSellerAuthorizationNote());
        if (request.getTransactionTimeout() != null)
            parameters.put(ServiceConstants.TRANSACTION_TIMEOUT, request.getTransactionTimeout());
        if (request.getCaptureNow() != null)
            parameters.put(ServiceConstants.CAPTURE_NOW, Boolean.toString(request.getCaptureNow()));
        if (request.getSoftDescriptor() != null)
            parameters.put(ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        if (request.getSellerNote() != null)
            parameters.put(ServiceConstants.BA_SELLER_NOTE, request.getSellerNote());
        if (request.getPlatformId() != null)
            parameters.put(ServiceConstants.BA_PLATFORM_ID, request.getPlatformId());
        if (request.getSellerOrderId() != null)
            parameters.put(ServiceConstants.BA_SELLER_ORDER_ID, request.getSellerOrderId());
        if (request.getStoreName() != null)
            parameters.put(ServiceConstants.BA_STORE_NAME, request.getStoreName());
        if (request.getSupplementaryData() != null)
            parameters.put(ServiceConstants.BA_SUPPLEMENTARY_DATA, request.getSupplementaryData());
        if (request.getCustomInformation() != null)
            parameters.put(ServiceConstants.BA_CUSTOM_INFORMATION, request.getCustomInformation());
        if (request.getInheritShippingAddress() != null)
            parameters.put(ServiceConstants.INHERIT_SHIPPING_ADDRESS, Boolean.toString(request.getInheritShippingAddress()));
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(ValidateBillingAgreementRequest request) {
        Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.VALIDATE_BILLING_AGREEMENT_DETAILS);
        if (request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(CreateOrderReferenceForIdRequest request) {
        final Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.CREATE_ORDER_REFERENCE_FOR_ID);

        if (request.getOrderTotalCurrencyCode() == null)
            request.setOrderTotalCurrencyCode(payConfig.getCurrencyCode());

        // API documenation says the InheritShippingAddress defaults is true
        // Testing in Sandbox showed this is not actually the case
        // For documentation consistency, if not defined by user, SDK sets to true
        if (request.getInheritShippingAddress() == null)
            request.setInheritShippingAddress(true);

        if (request.getId() != null)
            parameters.put(ServiceConstants.ID, request.getId());
        if (request.getIdType() != null)
            parameters.put(ServiceConstants.ID_TYPE, request.getIdType().value());
        if (request.getInheritShippingAddress() != null)
            parameters.put(ServiceConstants.INHERIT_SHIPPING_ADDRESS, Boolean.toString(request.getInheritShippingAddress()));
        if (request.getConfirmNow() != null)
            parameters.put(ServiceConstants.CONFIRM_NOW, Boolean.toString(request.getConfirmNow()));
        if (request.getOrderTotalCurrencyCode() != null)
            parameters.put(ServiceConstants.ORDER_CURRENCY_CODE, request.getOrderTotalCurrencyCode().toString());
        if (request.getOrderTotalAmount() != null)
            parameters.put(ServiceConstants.ORDER_AMOUNT, request.getOrderTotalAmount());
        if (request.getPlatformId() != null)
            parameters.put(ServiceConstants.PLATFORM_ID, request.getPlatformId());
        if (request.getSellerNote() != null)
            parameters.put(ServiceConstants.SELLER_NOTE, request.getSellerNote());
        if (request.getSellerOrderId() != null)
            parameters.put(ServiceConstants.SELLER_ORDER_ID, request.getSellerOrderId());
        if (request.getStoreName() != null)
            parameters.put(ServiceConstants.STORE_NAME, request.getStoreName());
        if (request.getSupplementaryData() != null)
            parameters.put(ServiceConstants.SUPPLEMENTARY_DATA, request.getSupplementaryData());
        if (request.getCustomInformation() != null)
            parameters.put(ServiceConstants.CUSTOM_INFORMATION, request.getCustomInformation());

        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURLGetServiceStatus() {
        final Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_SERVICE_STATUS);
        addClientParameters(parameters, null);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPaymentDomain(String region) {
        String paymentDomain = "NA_USD";

        if (region.equals("DE")) {
            paymentDomain = "EU_EUR";
        } else if (region.equals("UK")) {
            paymentDomain = "EU_GBP";
        } else if (region.equals("JP")) {
            paymentDomain = "FE_JPY";
        }
        return paymentDomain;
    }

    public String getPostURL(ListOrderReferenceRequest request){
        final Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.LIST_ORDER_REFERENCE);
        parameters.put(ServiceConstants.PAYMENT_DOMAIN, getPaymentDomain(payConfig.getRegion().toString()));

        if (request.getStartTime() != null)
            parameters.put(ServiceConstants.START_TIME, request.getStartTime().toString());
        if (request.getEndTime() != null)
            parameters.put(ServiceConstants.END_TIME, request.getEndTime().toString());
        if (request.getQueryId() != null)
            parameters.put(ServiceConstants.QUERY_ID, request.getQueryId());
        if (request.getQueryIdType() != null)
            parameters.put(ServiceConstants.QUERY_ID_TYPE, request.getQueryIdType());
        if (request.getSortOrder() != null)
            parameters.put(ServiceConstants.SORT_ORDER, request.getSortOrder().toString());
        if (request.getPageSize() != null)
            parameters.put(ServiceConstants.PAGE_SIZE, request.getPageSize().toString());
        if (request.getOrderReferenceStatusListFilter() != null){
            EnumSet<OrderReferenceStatus> filters = request.getOrderReferenceStatusListFilter();
            int count = 1;
            for (OrderReferenceStatus filter: filters){
                parameters.put(ServiceConstants.ORDER_REFERENCE_STATUS_LIST_FILTER + "." + count, filter.toString());
                count++;
            }
        }

        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(ListOrderReferenceByNextTokenRequest request){
        final Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.LIST_ORDER_REFERENCE_BY_NEXT_TOKEN);

        if (request.getNextPageToken() != null)
            parameters.put(ServiceConstants.NEXT_PAGE_TOKEN, request.getNextPageToken());

        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(SetOrderAttributesRequest request){
        final Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.SET_ORDER_ATTRIBUTES);

        if (request.getAmazonOrderReferenceId() != null)
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        if (request.getAmount() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_AMOUNT, request.getAmount());
        if (request.getCurrencyCode() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_CURRENCY_CODE, request.getCurrencyCode().toString());
        if (request.getSellerNote() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_SELLER_NOTE, request.getSellerNote());
        if (request.getRequestPaymentAuthorization() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_REQUEST_PAYMENT_AUTHORIZATION, Boolean.toString(request.getRequestPaymentAuthorization()));
        if (request.getSellerOrderId() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_SELLER_ORDER_ID, request.getSellerOrderId());
        if (request.getStoreName() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_STORE_NAME, request.getStoreName());
        if (request.getSupplementaryData() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_SUPPLEMENTARY_DATA, request.getSupplementaryData());
        if (request.getPlatformId() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_PLATFORM_ID, request.getPlatformId());
        if (request.getCustomInformation() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_CUSTOM_INFORMATION, request.getCustomInformation());
        if (request.getPaymentServiceProviderId() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_PAYMENT_SERVICE_PROVIDER_ID, request.getPaymentServiceProviderId());
        if (request.getPaymentServiceProviderOrderId() != null)
            parameters.put(ServiceConstants.ORDER_ATTRIBUTES_PAYMENT_SERVICE_PROVIDER_ORDER_ID, request.getPaymentServiceProviderOrderId());
        if (request.getOrderItemCategories() != null){
            Set<String> orderItemCategories = request.getOrderItemCategories();
            int count = 1;
            for (String orderItemCategory: orderItemCategories){
                parameters.put(ServiceConstants.ORDER_ATTRIBUTES_ORDER_ITEM_CATEGORIES + "." + count, orderItemCategory);
                count++;
            }
        }

        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    public String getPostURL(GetMerchantAccountStatusRequest request){
        final Map<String,String> parameters = new TreeMap<String,String>();
        parameters.put(ServiceConstants.ACTION, ServiceConstants.GET_MERCHANT_ACCOUNT_STATUS);

        addClientParameters(parameters, request);
        return Util.convertParameterMapToString(parameters);
    }

    private void addProviderCreditToParamMap(List<ProviderCredit> providerCreditList, Map<String,String> parameters) {
        if (providerCreditList != null) {
            int memberListIndex = 1;
            for (ProviderCredit member : providerCreditList) {
                if (member != null) {
                    if (member.getProviderId() != null) {
                        parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "ProviderId", member.getProviderId());
                    }
                    Price creditAmount = member.getCreditAmount();
                    if (creditAmount != null) {
                        parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "Amount", creditAmount.getAmount());
                        parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "CurrencyCode", creditAmount.getCurrencyCode());
                    }
                    memberListIndex++;
                }
            }
        }
    }

}
