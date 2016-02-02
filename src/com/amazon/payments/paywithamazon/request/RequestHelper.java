package com.amazon.payments.paywithamazon.request;

import com.amazon.payments.paywithamazon.request.AuthorizeRequest;
import com.amazon.payments.paywithamazon.request.CloseAuthorizationRequest;
import com.amazon.payments.paywithamazon.request.CaptureRequest;
import com.amazon.payments.paywithamazon.request.GetProviderCreditReversalDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.request.SetBillingAgreementDetailsRequest;
import com.amazon.payments.paywithamazon.request.ReverseProviderCreditRequest;
import com.amazon.payments.paywithamazon.request.ConfirmBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.CloseBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.GetBillingAgreementDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetProviderCreditDetailsRequest;
import com.amazon.payments.paywithamazon.request.ConfirmOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.CloseOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.SetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetRefundDetailsRequest;
import com.amazon.payments.paywithamazon.request.GetAuthorizationDetailsRequest;
import com.amazon.payments.paywithamazon.request.CancelOrderReferenceRequest;
import com.amazon.payments.paywithamazon.request.AuthorizeOnBillingAgreementRequest;
import com.amazon.payments.paywithamazon.request.GetCaptureDetailsRequest;
import com.amazon.payments.paywithamazon.request.RefundRequest;
import com.amazon.payments.paywithamazon.request.ValidateBillingAgreementRequest;
import com.amazon.payments.paywithamazon.exceptions.AmazonClientException;
import com.amazon.payments.paywithamazon.impl.PaymentsConfig;
import com.amazon.payments.paywithamazon.types.ServiceConstants;
import com.amazon.payments.paywithamazon.impl.Util;
import com.amazon.payments.paywithamazon.response.parser.ResponseData;
import com.amazon.payments.paywithamazon.response.model.Price;
import com.amazon.payments.paywithamazon.response.model.ProviderCredit;
import com.amazon.payments.paywithamazon.response.model.Environment;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestHelper {

    public PaymentsConfig paymentsConfig;
    
    public RequestHelper(PaymentsConfig paymentsConfig){
        this.paymentsConfig = paymentsConfig;
    }
    
    private Map<String,String> addClientParameters(Map<String,String> params) {
     try { 
        params.put(ServiceConstants.SELLER_ID , paymentsConfig.getSellerId());
        params.put(ServiceConstants.AWSACCESSKEYID , paymentsConfig.getAccessKey());
        params.put(ServiceConstants.SIGNATUREVERSION, "2");
        params.put(ServiceConstants.SIGNATUREMETHOD, "HmacSHA256");
        params.put(ServiceConstants.VERSION, ServiceConstants.AMAZON_PAYMENTS_API_VERSION);
        params.put(ServiceConstants.TIMESTAMP, Util.getTimestamp());
        Util.urlEncodeAPIParams(params);
        String signature = constructSignature(params);
        params.put(ServiceConstants.SIGNATURE , signature);
        return params;
     } catch(UnsupportedEncodingException e) {
            throw new AmazonClientException("Encountered client exception:", e);
     }
    }
    
    private String constructSignature(Map<String, String> params ) {
      String signature = null;
      try { 
        String domainName = ServiceConstants.mwsEndpointMappings.get(paymentsConfig.getRegion());   
        String postHeader = "POST\n" + domainName.replace("https://", "")  + "\n" + Util.getServiceVersionName(paymentsConfig.getEnvironment()) + "\n";
        Map<String, String> sortedParams = new TreeMap<String, String>();
        sortedParams.putAll(params);
        String stringToSign = postHeader + Util.convertParameterMapToString(sortedParams);
        signature = Util.urlEncode(Util.getSignature(stringToSign, paymentsConfig.getSecretKey()));
      } catch(UnsupportedEncodingException ex )  {
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
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.GET_ORDER_REFERENCE_DETAILS);
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        }
        if(request.getAddressConsentToken() != null) {
            parameters.put(ServiceConstants.ADDRESS_CONSENT_TOKEN , request.getAddressConsentToken());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(SetOrderReferenceDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        if(request.getOrderCurrencyCode() == null) 
            request.setOrderCurrencyCode(paymentsConfig.getCurrencyCode());
        
        parameters.put(ServiceConstants.ACTION , ServiceConstants.SET_ORDER_REFERENCE_DETAILS);
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        } if(request.getOrderAmount() != null) {
            parameters.put(ServiceConstants.ORDER_AMOUNT, request.getOrderAmount());
        } if(request.getOrderCurrencyCode() != null) {
            parameters.put(ServiceConstants.ORDER_CURRENCY_CODE, request.getOrderCurrencyCode().toString()); 
        } if(request.getPlatformId() != null) {
            parameters.put(ServiceConstants.PLATFORM_ID, request.getPlatformId());
        } if(request.getSellerNote() != null) {
            parameters.put(ServiceConstants.SELLER_NOTE, request.getSellerNote());
        } if(request.getSellerOrderId() != null) {
            parameters.put(ServiceConstants.SELLER_ORDER_ID, request.getSellerOrderId());
        } if(request.getStoreName() != null) {
        parameters.put(ServiceConstants.STORE_NAME, request.getStoreName()); 
        } if(request.getCustomInformation() != null) {
            parameters.put(ServiceConstants.CUSTOM_INFORMATION, request.getCustomInformation());
        } if(request.getMwsAuthToken() != null) {
        parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(AuthorizeRequest request)  {
        Map<String,String> parameters = new HashMap<String,String>();
        if(request.getAuthorizationCurrencyCode()== null) 
            request.setAuthorizationCurrencyCode(paymentsConfig.getCurrencyCode());
        
        parameters.put(ServiceConstants.ACTION , ServiceConstants.AUTHORIZE);
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        } if(request.getAuthorizationReferenceId() != null) { 
            parameters.put(ServiceConstants.AUTHORIZATION_REFERENCE_ID, request.getAuthorizationReferenceId());
        } if(request.getAuthorizationAmount() != null) {
            parameters.put(ServiceConstants.AUTHORIZATION_AMOUNT, request.getAuthorizationAmount());
        } if(request.getAuthorizationCurrencyCode() != null) {
            parameters.put(ServiceConstants.AUTHORIZATION_CURRENCEYCODE, request.getAuthorizationCurrencyCode().toString());
        } if(request.getSellerAuthorizationNote() != null) {
            parameters.put(ServiceConstants.SELLER_AUTHORIZATION_NOTE, request.getSellerAuthorizationNote());
        } if(request.getTransactionTimeout() != null) {
            parameters.put(ServiceConstants.TRANSACTION_TIMEOUT, request.getTransactionTimeout());
        } if(request.getCaptureNow() != null) {
            parameters.put(ServiceConstants.CAPTURE_NOW, Boolean.toString(request.getCaptureNow()));
        } if(request.getSoftDescriptor() != null) {
            parameters.put(ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        } if(request.getProviderCredit() != null) { 
            addProivderCreditToParamMap(request.getProviderCredit() , parameters);
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(GetAuthorizationDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.GET_AUTHORIZATION_DETAILS);
        if(request.getAmazonAuthorizationId() != null) {
            parameters.put(ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(CaptureRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.CAPTURE);
        
        if(request.getCaptureCurrencyCode()== null) 
            request.setCaptureCurrencyCode(paymentsConfig.getCurrencyCode());
        
        if(request.getAmazonAuthorizationId() != null) {
            parameters.put( ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId() );
        } if(request.getCaptureReferenceId() != null) {
            parameters.put( ServiceConstants.CAPTURE_REFERENCE_ID , request.getCaptureReferenceId() );
        } if(request.getCaptureAmount() != null) {
            parameters.put( ServiceConstants.CAPTURE_AMOUNT , request.getCaptureAmount() );
        } if(request.getCaptureCurrencyCode() != null) {
            parameters.put( ServiceConstants.CAPTURE_CURRENCEYCODE , request.getCaptureCurrencyCode().toString() );
        } if(request.getSellerCaptureNote() != null) {
            parameters.put( ServiceConstants.CAPTURE_NOTE , request.getSellerCaptureNote() );
        } if(request.getSoftDescriptor() != null) {
            parameters.put( ServiceConstants.SOFT_DESCRIPTOR , request.getSoftDescriptor() );
        } if(request.getMwsAuthToken() != null) {
            parameters.put( ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        } if(request.getProviderCredit() != null) { 
            addProivderCreditToParamMap(request.getProviderCredit() , parameters);
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }

    public  String getPostURL(GetCaptureDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.GET_CAPTURE_DETAILS);
        if(request.getAmazonCaptureId() != null) {
            parameters.put(ServiceConstants.AMAZON_CAPTURE_ID, request.getAmazonCaptureId());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(ConfirmOrderReferenceRequest request)  {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.CONFIRM_ORDER_REFERENCE);
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID , request.getAmazonOrderReferenceId());   
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(CancelOrderReferenceRequest request)  {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.CANCEL_ORDER_REFERENCE);
        if(request.getAmazonOrderReferenceId() != null) { 
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        } if(request.getCancelationReason() != null) {
            parameters.put(ServiceConstants.CANCELATION_REASON, request.getCancelationReason());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(CloseOrderReferenceRequest request)  {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.CLOSE_ORDER_REFERENCE);
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID , request.getAmazonOrderReferenceId()); 
        } if(request.getClosureReason() != null) {
            parameters.put(ServiceConstants.CLOSURE_REASON , request.getClosureReason());
        } if(request.getMwsAuthToken() != null) { 
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(CloseAuthorizationRequest request)  {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.CLOSE_AUTHORIZATION);
        if(request.getAmazonAuthorizationId() != null) {
            parameters.put(ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId());
        } if(request.getClosureReason() != null) { 
            parameters.put(ServiceConstants.CLOSURE_REASON, request.getClosureReason());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(RefundRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.REFUND);
        if(request.getRefundCurrencyCode()== null) 
            request.setRefundCurrencyCode(paymentsConfig.getCurrencyCode());
        
        if(request.getAmazonCaptureId() != null) {
            parameters.put(ServiceConstants.AMAZON_CAPTURE_ID, request.getAmazonCaptureId());
        } if( request.getRefundReferenceId() != null) { 
            parameters.put(ServiceConstants.REFUND_REFERENCE_ID, request.getRefundReferenceId());
        } if(request.getRefundAmount() != null) { 
            parameters.put(ServiceConstants.REFUND_AMOUNT, request.getRefundAmount());
        } if(request.getRefundCurrencyCode() != null) {
            parameters.put(ServiceConstants.REFUND_AMOUNT_CURRENCY_CODE, request.getRefundCurrencyCode().toString());
        } if(request.getSellerRefundNote() != null) {
            parameters.put(ServiceConstants.SELLER_REFUND_NOTE, request.getSellerRefundNote());
        } if(request.getSoftDescriptor() != null) { 
            parameters.put(ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        } if(request.getMwsAuthToken() != null) { 
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        } if(request.getProviderCredit() != null) { 
            addProivderCreditToParamMap(request.getProviderCredit() , parameters);
        }
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
        
    public String getPostURL(GetRefundDetailsRequest request)  {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.GET_REFUND_DETAILS);
        if(request.getAmazonRefundId() != null)
            parameters.put(ServiceConstants.AMAZON_REFUND_ID, request.getAmazonRefundId());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public String getPostURL(GetProviderCreditDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.GET_PROVIDER_CREDIT_DETAILS);
        if(request.getAmazonProviderCreditId() != null)
            parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_ID , request.getAmazonProviderCreditId());
        if(request.getSellerId() != null)
            parameters.put(ServiceConstants.SELLER_ID , request.getSellerId());
        if(request.getMwsAuthToken() != null )
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN , request.getMwsAuthToken());
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public String getPostURL(GetProviderCreditReversalDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.GET_REVERSE_PROVIDER_CREDIT_DETAILS);
        if(request.getAmazonProviderCreditReversalId() != null)
            parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_REVERSAL_ID , request.getAmazonProviderCreditReversalId());
        if(request.getSellerId() != null)
            parameters.put(ServiceConstants.SELLER_ID , request.getSellerId());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN , request.getMwsAuthToken());
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public String getPostURL(ReverseProviderCreditRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.REVERSE_PROVIDER_CREDIT_DETAILS);
        if(request.getCreditReversalAmountCurrencyCode()== null) 
            request.setCreditReversalCurrencyCode(paymentsConfig.getCurrencyCode());
        if(request.getAmazonProviderCreditId() != null)
            parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_ID , request.getAmazonProviderCreditId());
        if(request.getCreditReversalReferenceId() != null)
            parameters.put(ServiceConstants.CREDIT_REVERSAL_REFERENCE_ID , request.getCreditReversalReferenceId());
        if(request.getCreditReversalAmount() != null)
            parameters.put(ServiceConstants.CREDIT_REVERSAL_AMOUNT , request.getCreditReversalAmount());
        if(request.getSellerId() != null)
            parameters.put(ServiceConstants.SELLER_ID , request.getSellerId());
        if(request.getCreditReversalAmountCurrencyCode() != null)
            parameters.put(ServiceConstants.CREDIT_REVERSAL_AMOUNT_CURRENCY_CODE , request.getCreditReversalAmountCurrencyCode().toString());
        if(request.getCreditReversalNote() != null)
            parameters.put(ServiceConstants.CREDIT_REVERSAL_NOTE , request.getCreditReversalNote());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN ,request.getMwsAuthToken());
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public  String getPostURL(GetBillingAgreementDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.GET_BILLING_AGREEMENT_DETAILS);
        if(request.getAmazonBillingAgreementId() != null )
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        if(request.getAddressConsentToken() != null)
            parameters.put(ServiceConstants.ADDRESS_CONSENT_TOKEN , request.getAddressConsentToken());
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public String getPostURL(SetBillingAgreementDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.SET_BILLING_AGREEMENT_DETAILS);
        if(request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        if(request.getPlatformId() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_PLATFORM_ID, request.getPlatformId());
        if(request.getSellerNote() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_SELLER_NOTE, request.getSellerNote());
        if(request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_SELLER_BILLING_AGREEMENT_ID, request.getSellerBillingAgreementId());
        if(request.getStoreName()!= null )
            parameters.put(ServiceConstants.BILLING_AGREEMENT_SELLER_STORE_NAME, request.getStoreName()); 
        if(request.getCustomInformation() != null)
            parameters.put(ServiceConstants.BILLING_AGREEMENT_SELLER_CUSTOM_INFORMATION, request.getCustomInformation());  
        addClientParameters(parameters);
       return Util.convertParameterMapToString(parameters);
    }
    
    public String getPostURL(ConfirmBillingAgreementRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.CONFIRM_BILLING_AGREEMENT_DETAILS);
        if(request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN , request.getMwsAuthToken());
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
    
    public String getPostURL(CloseBillingAgreementRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.CLOSE_BILLING_AGREEMENT_DETAILS);
        if(request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getClosureReason() != null)
            parameters.put(ServiceConstants.CLOSURE_REASON , request.getClosureReason());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        addClientParameters(parameters);
       return Util.convertParameterMapToString(parameters);
    }
    
   public String getPostURL(AuthorizeOnBillingAgreementRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
            parameters.put(ServiceConstants.ACTION , ServiceConstants.AUTHORIZE_BILLING_AGREEMENT_DETAILS);
        if(request.getAuthorizationCurrencyCode()== null) 
           request.setAuthorizationCurrencyCode(paymentsConfig.getCurrencyCode());
        if(request.getAmazonBillingAgreementId() != null )
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getAuthorizationReferenceId()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_REFERENCE_ID, request.getAuthorizationReferenceId());
        if(request.getAuthorizationAmount()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_AMOUNT, request.getAuthorizationAmount());
        if(request.getAuthorizationCurrencyCode()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_CURRENCEYCODE, request.getAuthorizationCurrencyCode().toString());
        if(request.getSellerAuthorizationNote()  != null)
            parameters.put(ServiceConstants.SELLER_AUTHORIZATION_NOTE, request.getSellerAuthorizationNote());
        if(request.getTransactionTimeout() != null)
            parameters.put(ServiceConstants.TRANSACTION_TIMEOUT, request.getTransactionTimeout());
        if(request.getCaptureNow() != null)
            parameters.put(ServiceConstants.CAPTURE_NOW, Boolean.toString(request.getCaptureNow()));
        if(request.getSoftDescriptor() != null)
            parameters.put(ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        if(request.getSellerNote() != null)
            parameters.put(ServiceConstants.SELLER_NOTE, request.getSellerNote());
        if(request.getPlatformId() != null)
            parameters.put(ServiceConstants.PLATFORM_ID, request.getPlatformId());
        if(request.getSellerOrderId() != null)
            parameters.put(ServiceConstants.BA_SELLER_ORDER_ID, request.getSellerOrderId());
        if(request.getStoreName() != null)
            parameters.put(ServiceConstants.BA_STORE_NAME, request.getStoreName());
        if(request.getCustomInformation() != null)
            parameters.put(ServiceConstants.BA_CUSTOM_INFORMATION, request.getCustomInformation());
        if(request.getInheritShippingAddress() != null)
            parameters.put(ServiceConstants.INHERIT_SHIPPING_ADDRESS, request.getInheritShippingAddress());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        addClientParameters(parameters);
        return Util.convertParameterMapToString(parameters);
    }
   
   public String getPostURL(ValidateBillingAgreementRequest request)  {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put(ServiceConstants.ACTION , ServiceConstants.VALIDATE_BILLING_AGREEMENT_DETAILS);
        if(request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN , request.getMwsAuthToken());
        addClientParameters(parameters);
       return Util.convertParameterMapToString(parameters);
    }
   
   private void addProivderCreditToParamMap(List<ProviderCredit> providerCreditList , Map<String,String> parameters) {
       if(providerCreditList != null) {
            int memberListIndex = 1;
            for (ProviderCredit member : providerCreditList) {
                if(member != null) { 
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
