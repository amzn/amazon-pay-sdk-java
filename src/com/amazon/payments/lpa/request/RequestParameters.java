package com.amazon.payments.lpa.request;

import com.amazon.payments.lpa.helper.ServiceConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParameters {
    
    public static Map<String,String> getParams(GetOrderReferenceDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "GetOrderReferenceDetails");
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        }
        if(request.getAddressConsentToken() != null) {
            parameters.put(ServiceConstants.ADDRESS_CONSENT_TOKEN , request.getAddressConsentToken());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        return parameters;
    }
    
    public static Map<String,String> getParams(SetOrderReferenceDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "SetOrderReferenceDetails");
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        } if(request.getOrderAmount() != null) {
            parameters.put(ServiceConstants.ORDER_AMOUNT, request.getOrderAmount());
        } if(request.getOrderCurrencyCode() != null) {
            parameters.put(ServiceConstants.ORDER_CURRENCY_CODE, request.getOrderCurrencyCode()); 
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
        return parameters;
    }
    
    public static Map<String,String> getParams(AuthorizeRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "Authorize");
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        } if(request.getAuthorizationReferenceId() != null) { 
            parameters.put(ServiceConstants.AUTHORIZATION_REFERENCE_ID, request.getAuthorizationReferenceId());
        } if(request.getAuthorizationAmount() != null) {
            parameters.put(ServiceConstants.AUTHORIZATION_AMOUNT, request.getAuthorizationAmount());
        } if(request.getCurrencyCode() != null) {
            parameters.put(ServiceConstants.AUTHORIZATION_CURRENCEYCODE, request.getCurrencyCode());
        } if(request.getSellerAuthorizationNote() != null) {
            parameters.put(ServiceConstants.SELLER_AUTHORIZATION_NOTE, request.getSellerAuthorizationNote());
        } if(request.getTransactionTimeout() != null) {
            parameters.put(ServiceConstants.TRANSACTION_TIMEOUT, request.getTransactionTimeout());
        } if(request.getCaptureNow() != null) {
            parameters.put(ServiceConstants.CAPTURE_NOW, request.getCaptureNow());
        } if(request.getSoftDescriptor() != null) {
            parameters.put(ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        } if(request.getProviderCredit() != null) {
        int memberListIndex = 1;
        List<ProviderCredit> pc = request.getProviderCredit();
        for (ProviderCredit member : pc) {
            if (member.getProviderId() != null) {
                    parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "ProviderId", member.getProviderId());
                }
                if (member.getCreditAmount() != null) {
                    Price  creditAmount = member.getCreditAmount();
                    if (creditAmount != null) {
                        parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "Amount", creditAmount.getAmount());
                    }
                    if (member.getCreditAmount().getCurrencyCode()!= null) {
                        parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "CurrencyCode", creditAmount.getCurrencyCode());
                    }
                } 

          memberListIndex++;
        }
        }
        return parameters;
    }
    
    public static Map<String,String> getParams(GetAuthorizationDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "GetAuthorizationDetails");
        if(request.getAmazonAuthorizationId() != null) {
            parameters.put(ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        return parameters;
    }
    
    public static Map<String,String> getParams(CaptureRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "Capture");
        if(request.getAmazonAuthorizationId() != null) {
            parameters.put( ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId() );
        } if(request.getCaptureReferenceId() != null) {
            parameters.put( ServiceConstants.CAPTURE_REFERENCE_ID , request.getCaptureReferenceId() );
        } if(request.getCaptureAmount() != null) {
            parameters.put( ServiceConstants.CAPTURE_AMOUNT , request.getCaptureAmount() );
        } if(request.getCaptureCurrencyCode() != null) {
            parameters.put( ServiceConstants.CAPTURE_CURRENCEYCODE , request.getCaptureCurrencyCode() );
        } if(request.getSellerCaptureNote() != null) {
            parameters.put( ServiceConstants.CAPTURE_NOTE , request.getSellerCaptureNote() );
        } if(request.getSoftDescriptor() != null) {
            parameters.put( ServiceConstants.SOFT_DESCRIPTOR , request.getSoftDescriptor() );
        } if(request.getMwsAuthToken() != null) {
            parameters.put( ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        if(request.getProviderCredit() != null) {
        List<ProviderCredit> pc = request.getProviderCredit();
        int memberListIndex = 1;
        for (ProviderCredit member : pc) {
            if (member.getProviderId() != null) {
                    parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "ProviderId", member.getProviderId());
                }
                if (member.getCreditAmount() != null) {
                    Price  creditAmount = member.getCreditAmount();
                    if (creditAmount != null) {
                        parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "Amount", creditAmount.getAmount());
                    }
                    if (member.getCreditAmount().getCurrencyCode()!= null) {
                        parameters.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "CurrencyCode", creditAmount.getCurrencyCode());
                    }
                } 

          memberListIndex++;
        }
        }
        return parameters;
    }

    public static Map<String,String> getParams(GetCaptureDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "GetCaptureDetails");
        if(request.getAmazonCaptureId() != null) {
            parameters.put(ServiceConstants.AMAZON_CAPTURE_ID, request.getAmazonCaptureId());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        return parameters;
    }
    
    public static Map<String,String> getParams(ConfirmOrderReferenceRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "ConfirmOrderReference");
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID , request.getAmazonOrderReferenceId());   
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        return parameters;
    }
    
    public static Map<String,String> getParams(CancelOrderReferenceRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "CancelOrderReference");
        if(request.getAmazonOrderReferenceId() != null) { 
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID, request.getAmazonOrderReferenceId());
        } if(request.getCancelationReason() != null) {
            parameters.put(ServiceConstants.CANCELATION_REASON, request.getCancelationReason());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        return parameters;
    }
    
    public static Map<String,String> getParams(CloseOrderReferenceRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "CloseOrderReference");
        if(request.getAmazonOrderReferenceId() != null) {
            parameters.put(ServiceConstants.AMAZON_ORDER_REFERENCE_ID , request.getAmazonOrderReferenceId()); 
        } if(request.getClosureReason() != null) {
            parameters.put(ServiceConstants.CLOSURE_REASON , request.getClosureReason());
        } if(request.getMwsAuthToken() != null) { 
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        return parameters;
    }
    
    public static Map<String,String> getParams(CloseAuthorizationRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "CloseAuthorization");
        if(request.getAmazonAuthorizationId() != null) {
            parameters.put(ServiceConstants.AMAZON_AUTHORIZATION_ID, request.getAmazonAuthorizationId());
        } if(request.getClosureReason() != null) { 
            parameters.put(ServiceConstants.CLOSURE_REASON, request.getClosureReason());
        } if(request.getMwsAuthToken() != null) {
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        }
        return parameters;
    }
    
    public static Map<String,String> getParams(RefundRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
            parameters.put("Action" , "Refund");
        if(request.getAmazonCaptureId() != null) {
            parameters.put(ServiceConstants.AMAZON_CAPTURE_ID, request.getAmazonCaptureId());
        } if( request.getRefundReferenceId() != null) { 
            parameters.put(ServiceConstants.REFUND_REFERENCE_ID, request.getRefundReferenceId());
        } if(request.getRefundAmount() != null) { 
            parameters.put(ServiceConstants.REFUND_AMOUNT, request.getRefundAmount());
        } if(request.getRefundCurrencyCode() != null) {
            parameters.put(ServiceConstants.REFUND_AMOUNT_CURRENCY_CODE, request.getRefundCurrencyCode());
        } if(request.getSellerRefundNote() != null) {
            parameters.put(ServiceConstants.SELLER_REFUND_NOTE, request.getSellerRefundNote());
        } if(request.getSoftDescriptor() != null) { 
            parameters.put(ServiceConstants.SOFT_DESCRIPTOR, request.getSoftDescriptor());
        } if(request.getMwsAuthToken() != null) { 
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        } if(request.getProviderCreditReversalDetails() != null) { 
        List<Map<String,String>> providerCreditReversalDetails = request.getProviderCreditReversalDetails();
        int member = 0;
        for (Map<String,String> m : providerCreditReversalDetails) {
            parameters.put("ProviderCreditReversalList.member."+member+".ProviderId", m.get("providerId") );
            parameters.put("ProviderCreditReversalList.member."+member+".CreditReversalAmount.Amount", m.get("amount") );
            parameters.put("ProviderCreditReversalList.member."+member+".CreditReversalAmount.CurrencyCode", m.get("currencyCode") );
            member++;
        }
        }
        return parameters;
    }
        
    public static Map<String,String> getParams(GetRefundDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "GetRefundDetails");
        if(request.getAmazonRefundId() != null)
        parameters.put(ServiceConstants.AMAZON_REFUND_ID, request.getAmazonRefundId());
        if(request.getMwsAuthToken() != null)
        parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        return parameters;
    }
    
    public static Map<String,String> getParams(GetProviderCreditDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "GetProviderCreditDetails");
        if(request.getAmazonProviderCreditId() != null)
        parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_ID , request.getAmazonProviderCreditId());
        if(request.getSellerId() != null)
        parameters.put(ServiceConstants.SELLER_ID , request.getSellerId());
        if(request.getMwsAuthToken() != null )
        parameters.put(ServiceConstants.MWS_AUTH_TOKEN , request.getMwsAuthToken());
        return parameters;
    }
    
    public static Map<String,String> getParams(GetProviderCreditReversalDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "GetProviderCreditReversalDetails");
        if(request.getAmazonProviderCreditReversalId() != null)
        parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_REVERSAL_ID , request.getAmazonProviderCreditReversalId());
        if(request.getSellerId() != null)
        parameters.put(ServiceConstants.SELLER_ID , request.getSellerId());
        if(request.getMwsAuthToken() != null)
        parameters.put(ServiceConstants.MWS_AUTH_TOKEN , request.getMwsAuthToken());
        return parameters;
    }
    
    public static Map<String,String> getParams(ReverseProviderCreditRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "ReverseProviderCredit");
        if(request.getAmazonProviderCreditId() != null)
        parameters.put(ServiceConstants.AMAZON_PROVIDER_CREDIT_ID , request.getAmazonProviderCreditId());
        if(request.getCreditReversalReferenceId() != null)
        parameters.put(ServiceConstants.CREDIT_REVERSAL_REFERENCE_ID , request.getCreditReversalReferenceId());
        if(request.getCreditReversalAmount() != null)
        parameters.put(ServiceConstants.CREDIT_REVERSAL_AMOUNT , request.getCreditReversalAmount());
        if(request.getSellerId() != null)
        parameters.put(ServiceConstants.SELLER_ID , request.getSellerId());
        if(request.getCreditReversalAmountCurrencyCode() != null)
        parameters.put(ServiceConstants.CREDIT_REVERSAL_AMOUNT_CURRENCY_CODE , request.getCreditReversalAmountCurrencyCode());
        if(request.getCreditReversalNote() != null)
        parameters.put(ServiceConstants.CREDIT_REVERSAL_NOTE , request.getCreditReversalNote());
        if(request.getMwsAuthToken() != null)
        parameters.put(ServiceConstants.MWS_AUTH_TOKEN ,request.getMwsAuthToken());
        return parameters;
    }
    
    public static Map<String,String> getParams(GetBillingAgreementDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "GetBillingAgreementDetails");
        if(request.getAmazonBillingAgreementId() != null )
        parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getMwsAuthToken() != null)
        parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        if(request.getAddressConsentToken() != null)
        parameters.put(ServiceConstants.ADDRESS_CONSENT_TOKEN , request.getAddressConsentToken());
        return parameters;
    }
    
    public static Map<String,String> getParams(SetBillingAgreementDetailsRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "SetBillingAgreementDetails");
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
        return parameters;
    }
    
    public static Map<String,String> getParams(ConfirmBillingAgreementRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "ConfirmBillingAgreement");
        if(request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN , request.getMwsAuthToken());
        return parameters;
    }
    
    public static Map<String,String> getParams(CloseBillingAgreementRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "CloseBillingAgreement");
        if(request.getAmazonBillingAgreementId() != null)
        parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getClosureReason() != null)
        parameters.put(ServiceConstants.CLOSURE_REASON , request.getClosureReason());
        if(request.getMwsAuthToken() != null)
        parameters.put(ServiceConstants.MWS_AUTH_TOKEN, request.getMwsAuthToken());
        return parameters;
    }
    
   public static Map<String,String> getParams(AuthorizeOnBillingAgreementRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
            parameters.put("Action" , "AuthorizeOnBillingAgreement");
        if(request.getAmazonBillingAgreementId() != null )
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getAuthorizationReferenceId()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_REFERENCE_ID, request.getAuthorizationReferenceId());
        if(request.getAuthorizationAmount()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_AMOUNT, request.getAuthorizationAmount());
        if(request.getAuthorizationCurrencyCode()  != null)
            parameters.put(ServiceConstants.AUTHORIZATION_CURRENCEYCODE, request.getAuthorizationCurrencyCode());
        if(request.getSellerAuthorizationNote()  != null)
            parameters.put(ServiceConstants.SELLER_AUTHORIZATION_NOTE, request.getSellerAuthorizationNote());
        if(request.getTransactionTimeout() != null)
            parameters.put(ServiceConstants.TRANSACTION_TIMEOUT, request.getTransactionTimeout());
        if(request.getCaptureNow() != null)
            parameters.put(ServiceConstants.CAPTURE_NOW, request.getCaptureNow());
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
        return parameters;
    }
   
   public static Map<String,String> getParams(ValidateBillingAgreementRequest request) {
        Map<String,String> parameters = new HashMap<String,String>();
        parameters.put("Action" , "ValidateBillingAgreement");
        if(request.getAmazonBillingAgreementId() != null)
            parameters.put(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID, request.getAmazonBillingAgreementId());
        if(request.getMwsAuthToken() != null)
            parameters.put(ServiceConstants.MWS_AUTH_TOKEN , request.getMwsAuthToken());
       return parameters;
    }
}
