/******************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * ****************************************************************************
 * 
 *  Off Amazon Payments Service Java Library
 *  API Version: 2013-01-01
 * 
 */

package com.amazonservices.mws.offamazonpayments;

import com.amazonservices.mws.offamazonpayments.model.*;

import java.util.HashMap;
import java.util.Map;

import com.amazonservices.mws.offamazonpayments.requestclient.HttpRequestClient;
import com.amazonservices.mws.offamazonpayments.requestclient.HttpRequestClientFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Coral service for marketplace
 * payment API operations for external
 * merchants.
 * 
 *
 *
 * OffAmazonPaymentsServiceClient is implementation of OffAmazonPaymentsService based on the
 * Apache <a href="http://jakarta.apache.org/commons/httpclient/">HttpClient</a>.
 *
 */
public  class OffAmazonPaymentsServiceClient implements OffAmazonPaymentsService {

    private final Log log = LogFactory.getLog(OffAmazonPaymentsServiceClient.class);

    private final HttpRequestClient httpRequestClient;
    private final OffAmazonPaymentsServiceConfig config;

    /**
     * Constructs OffAmazonPaymentsServiceClient with OffAmazonPaymentsServiceConfig.
     * Use OffAmazonPaymentsServiceConfig to pass required
     * configuration that affects how service is being called.
     *
     * @param config
     *          OffAmazonPaymentsServiceConfig object
     */
    public OffAmazonPaymentsServiceClient(OffAmazonPaymentsServiceConfig config) {
        this(config, new HttpRequestClientFactory(config).createInstance());
    }

    /**
     * Constructs OffAmazonPaymentsServiceClient with OffAmazonPaymentsServiceConfig.
     * Use OffAmazonPaymentsServiceConfig to pass required
     * configuration that affects how service is being called.
     *
     * @param config
     *          OffAmazonPaymentsServiceConfig object
     * @param requestClient
     *
     */
    public OffAmazonPaymentsServiceClient(OffAmazonPaymentsServiceConfig config, HttpRequestClient requestClient) {
        this.httpRequestClient = requestClient;
        this.config = config;
    }

    // Public API ------------------------------------------------------------//
    
    /**
     * Capture 
     *

     * @param request
     *          CaptureRequest request
     * @return
     *          Capture Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CaptureResponse capture(CaptureRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(CaptureResponse.class, convertCapture(request));
    }

    
    /**
     * Refund 
     *

     * @param request
     *          RefundRequest request
     * @return
     *          Refund Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public RefundResponse refund(RefundRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(RefundResponse.class, convertRefund(request));
    }

    
    /**
     * Close Authorization 
     *

     * @param request
     *          CloseAuthorizationRequest request
     * @return
     *          CloseAuthorization Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CloseAuthorizationResponse closeAuthorization(CloseAuthorizationRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(CloseAuthorizationResponse.class, convertCloseAuthorization(request));
    }

    
    /**
     * Get Refund Details 
     *

     * @param request
     *          GetRefundDetailsRequest request
     * @return
     *          GetRefundDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetRefundDetailsResponse getRefundDetails(GetRefundDetailsRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(GetRefundDetailsResponse.class, convertGetRefundDetails(request));
    }

    
    /**
     * Get Capture Details 
     *

     * @param request
     *          GetCaptureDetailsRequest request
     * @return
     *          GetCaptureDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetCaptureDetailsResponse getCaptureDetails(GetCaptureDetailsRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(GetCaptureDetailsResponse.class, convertGetCaptureDetails(request));
    }

    
    /**
     * Close Order Reference 
     *

     * @param request
     *          CloseOrderReferenceRequest request
     * @return
     *          CloseOrderReference Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CloseOrderReferenceResponse closeOrderReference(CloseOrderReferenceRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(CloseOrderReferenceResponse.class, convertCloseOrderReference(request));
    }

    
    /**
     * Confirm Order Reference 
     *

     * @param request
     *          ConfirmOrderReferenceRequest request
     * @return
     *          ConfirmOrderReference Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public ConfirmOrderReferenceResponse confirmOrderReference(ConfirmOrderReferenceRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(ConfirmOrderReferenceResponse.class, convertConfirmOrderReference(request));
    }

    
    /**
     * Get Order Reference Details 
     *

     * @param request
     *          GetOrderReferenceDetailsRequest request
     * @return
     *          GetOrderReferenceDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetOrderReferenceDetailsResponse getOrderReferenceDetails(GetOrderReferenceDetailsRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(GetOrderReferenceDetailsResponse.class, convertGetOrderReferenceDetails(request));
    }

    
    /**
     * Authorize 
     *

     * @param request
     *          AuthorizeRequest request
     * @return
     *          Authorize Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public AuthorizeResponse authorize(AuthorizeRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(AuthorizeResponse.class, convertAuthorize(request));
    }

    
    /**
     * Set Order Reference Details 
     *

     * @param request
     *          SetOrderReferenceDetailsRequest request
     * @return
     *          SetOrderReferenceDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public SetOrderReferenceDetailsResponse setOrderReferenceDetails(SetOrderReferenceDetailsRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(SetOrderReferenceDetailsResponse.class, convertSetOrderReferenceDetails(request));
    }

    
    /**
     * Get Authorization Details 
     *

     * @param request
     *          GetAuthorizationDetailsRequest request
     * @return
     *          GetAuthorizationDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetAuthorizationDetailsResponse getAuthorizationDetails(GetAuthorizationDetailsRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(GetAuthorizationDetailsResponse.class, convertGetAuthorizationDetails(request));
    }

    
    /**
     * Cancel Order Reference 
     *

     * @param request
     *          CancelOrderReferenceRequest request
     * @return
     *          CancelOrderReference Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CancelOrderReferenceResponse cancelOrderReference(CancelOrderReferenceRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(CancelOrderReferenceResponse.class, convertCancelOrderReference(request));
    }

    
    /**
     * Create Order Reference For Id 
     *
     * @param request
     *          CreateOrderReferenceForIdRequest request
     * @return
     *          CreateOrderReferenceForId Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CreateOrderReferenceForIdResponse createOrderReferenceForId(CreateOrderReferenceForIdRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(CreateOrderReferenceForIdResponse.class, convertCreateOrderReferenceForId(request));
    }

    
    /**
     * Get Billing Agreement Details 
     *
     * @param request
     *          GetBillingAgreementDetailsRequest request
     * @return
     *          GetBillingAgreementDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetBillingAgreementDetailsResponse getBillingAgreementDetails(GetBillingAgreementDetailsRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(GetBillingAgreementDetailsResponse.class, convertGetBillingAgreementDetails(request));
    }

    
    /**
     * Set Billing Agreement Details 
     *
     * @param request
     *          SetBillingAgreementDetailsRequest request
     * @return
     *          SetBillingAgreementDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public SetBillingAgreementDetailsResponse setBillingAgreementDetails(SetBillingAgreementDetailsRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(SetBillingAgreementDetailsResponse.class, convertSetBillingAgreementDetails(request));
    }

    
    /**
     * Confirm Billing Agreement 
     *
     * @param request
     *          ConfirmBillingAgreementRequest request
     * @return
     *          ConfirmBillingAgreement Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public ConfirmBillingAgreementResponse confirmBillingAgreement(ConfirmBillingAgreementRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(ConfirmBillingAgreementResponse.class, convertConfirmBillingAgreement(request));
    }

    
    /**
     * Validate Billing Agreement 
     *
     * @param request
     *          ValidateBillingAgreementRequest request
     * @return
     *          ValidateBillingAgreement Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public ValidateBillingAgreementResponse validateBillingAgreement(ValidateBillingAgreementRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(ValidateBillingAgreementResponse.class, convertValidateBillingAgreement(request));
    }

    
    /**
     * Authorize On Billing Agreement 
     *
     * @param request
     *          AuthorizeOnBillingAgreementRequest request
     * @return
     *          AuthorizeOnBillingAgreement Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public AuthorizeOnBillingAgreementResponse authorizeOnBillingAgreement(AuthorizeOnBillingAgreementRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(AuthorizeOnBillingAgreementResponse.class, convertAuthorizeOnBillingAgreement(request));
    }

    
    /**
     * Close Billing Agreement 
     *
     * @param request
     *          CloseBillingAgreementRequest request
     * @return
     *          CloseBillingAgreement Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CloseBillingAgreementResponse closeBillingAgreement(CloseBillingAgreementRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(CloseBillingAgreementResponse.class, convertCloseBillingAgreement(request));
    }
    
    /**
     * Get Provider Credit Details 
     *
     * A query API for ProviderCredits.  Both Provider and Seller sellerIds are authorized to call this API.
     * 
     * @param request
     *          GetProviderCreditDetailsRequest request
     * @return
     *          GetProviderCreditDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetProviderCreditDetailsResponse getProviderCreditDetails(GetProviderCreditDetailsRequest request) throws OffAmazonPaymentsServiceException {
    	return httpRequestClient.invoke(GetProviderCreditDetailsResponse.class, convertGetProviderCreditDetails(request));
    }

    /**
     * Get Provider Credit Reversal Details 
     *
     * Activity to query the funds reversed against a given Provider Credit reversal.
     * 
     * @param request
     *          GetProviderCreditReversalDetailsRequest request
     * @return
     *          GetProviderCreditReversalDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetProviderCreditReversalDetailsResponse getProviderCreditReversalDetails(GetProviderCreditReversalDetailsRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(GetProviderCreditReversalDetailsResponse.class, convertGetProviderCreditReversalDetails(request));
    }

    /**
     * Reverse Provider Credit 
     *
     * Activity to enable the Caller/Provider to reverse the funds credited to Provider.
     * 
     * @param request
     *          ReverseProviderCreditRequest request
     * @return
     *          ReverseProviderCredit Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public ReverseProviderCreditResponse reverseProviderCredit(ReverseProviderCreditRequest request) throws OffAmazonPaymentsServiceException {
        return httpRequestClient.invoke(ReverseProviderCreditResponse.class, convertReverseProviderCredit(request));
    }

    
    // Private API ------------------------------------------------------------//

   /**
     * Convert CaptureRequest to name value pairs
     */
    private Map<String, String> convertCapture(CaptureRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "Capture");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonAuthorizationId()) {
            params.put("AmazonAuthorizationId", request.getAmazonAuthorizationId());
        }
        if (request.isSetCaptureReferenceId()) {
            params.put("CaptureReferenceId", request.getCaptureReferenceId());
        }
        if (request.isSetCaptureAmount()) {
            Price  captureAmount = request.getCaptureAmount();
            if (captureAmount.isSetAmount()) {
                params.put("CaptureAmount" + "." + "Amount", captureAmount.getAmount());
            }
            if (captureAmount.isSetCurrencyCode()) {
                params.put("CaptureAmount" + "." + "CurrencyCode", captureAmount.getCurrencyCode());
            }
        } 
        if (request.isSetSellerCaptureNote()) {
            params.put("SellerCaptureNote", request.getSellerCaptureNote());
        }
        if (request.isSetSoftDescriptor()) {
            params.put("SoftDescriptor", request.getSoftDescriptor());
        }
        if (request.isSetProviderCreditList()) {
            ProviderCreditList  providerCreditList = request.getProviderCreditList();
            java.util.List<ProviderCredit> memberList = providerCreditList.getMember();
            int memberListIndex = 1;
            for (ProviderCredit member : memberList) {
                if (member.isSetProviderId()) {
                    params.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "ProviderId", member.getProviderId());
                }
                if (member.isSetCreditAmount()) {
                    Price  creditAmount = member.getCreditAmount();
                    if (creditAmount.isSetAmount()) {
                        params.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "Amount", creditAmount.getAmount());
                    }
                    if (creditAmount.isSetCurrencyCode()) {
                        params.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "CurrencyCode", creditAmount.getCurrencyCode());
                    }
                } 

                memberListIndex++;
            }
        } 

        return params;
    }
        
        
    
    
                    
   /**
     * Convert RefundRequest to name value pairs
     */
    private Map<String, String> convertRefund(RefundRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "Refund");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonCaptureId()) {
            params.put("AmazonCaptureId", request.getAmazonCaptureId());
        }
        if (request.isSetRefundReferenceId()) {
            params.put("RefundReferenceId", request.getRefundReferenceId());
        }
        if (request.isSetRefundAmount()) {
            Price  refundAmount = request.getRefundAmount();
            if (refundAmount.isSetAmount()) {
                params.put("RefundAmount" + "." + "Amount", refundAmount.getAmount());
            }
            if (refundAmount.isSetCurrencyCode()) {
                params.put("RefundAmount" + "." + "CurrencyCode", refundAmount.getCurrencyCode());
            }
        } 
        if (request.isSetSellerRefundNote()) {
            params.put("SellerRefundNote", request.getSellerRefundNote());
        }
        if (request.isSetSoftDescriptor()) {
            params.put("SoftDescriptor", request.getSoftDescriptor());
        }
        if (request.isSetProviderCreditReversalList()) {
            ProviderCreditReversalList  providerCreditReversalList = request.getProviderCreditReversalList();
            java.util.List<ProviderCreditReversal> memberList = providerCreditReversalList.getMember();
            int memberListIndex = 1;
            for (ProviderCreditReversal member : memberList) {
                if (member.isSetProviderId()) {
                    params.put("ProviderCreditReversalList" + "." + "member" + "."  + memberListIndex + "." + "ProviderId", member.getProviderId());
                }
                if (member.isSetCreditReversalAmount()) {
                    Price  creditReversalAmount = member.getCreditReversalAmount();
                    if (creditReversalAmount.isSetAmount()) {
                        params.put("ProviderCreditReversalList" + "." + "member" + "."  + memberListIndex + "." + "CreditReversalAmount" + "." + "Amount", creditReversalAmount.getAmount());
                    }
                    if (creditReversalAmount.isSetCurrencyCode()) {
                        params.put("ProviderCreditReversalList" + "." + "member" + "."  + memberListIndex + "." + "CreditReversalAmount" + "." + "CurrencyCode", creditReversalAmount.getCurrencyCode());
                    }
                } 

                memberListIndex++;
            }
        } 
        return params;
    }
        
        
    
    
                    
   /**
     * Convert CloseAuthorizationRequest to name value pairs
     */
    private Map<String, String> convertCloseAuthorization(CloseAuthorizationRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "CloseAuthorization");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonAuthorizationId()) {
            params.put("AmazonAuthorizationId", request.getAmazonAuthorizationId());
        }
        if (request.isSetClosureReason()) {
            params.put("ClosureReason", request.getClosureReason());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert GetRefundDetailsRequest to name value pairs
     */
    private Map<String, String> convertGetRefundDetails(GetRefundDetailsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "GetRefundDetails");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonRefundId()) {
            params.put("AmazonRefundId", request.getAmazonRefundId());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert GetCaptureDetailsRequest to name value pairs
     */
    private Map<String, String> convertGetCaptureDetails(GetCaptureDetailsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "GetCaptureDetails");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonCaptureId()) {
            params.put("AmazonCaptureId", request.getAmazonCaptureId());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert CloseOrderReferenceRequest to name value pairs
     */
    private Map<String, String> convertCloseOrderReference(CloseOrderReferenceRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "CloseOrderReference");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonOrderReferenceId()) {
            params.put("AmazonOrderReferenceId", request.getAmazonOrderReferenceId());
        }
        if (request.isSetClosureReason()) {
            params.put("ClosureReason", request.getClosureReason());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert ConfirmOrderReferenceRequest to name value pairs
     */
    private Map<String, String> convertConfirmOrderReference(ConfirmOrderReferenceRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "ConfirmOrderReference");
        if (request.isSetAmazonOrderReferenceId()) {
            params.put("AmazonOrderReferenceId", request.getAmazonOrderReferenceId());
        }
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }

        return params;
    }
        
        
    
                    
   /**
     * Convert GetOrderReferenceDetailsRequest to name value pairs
     */
    private Map<String, String> convertGetOrderReferenceDetails(GetOrderReferenceDetailsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "GetOrderReferenceDetails");
        if (request.isSetAmazonOrderReferenceId()) {
            params.put("AmazonOrderReferenceId", request.getAmazonOrderReferenceId());
        }
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetAddressConsentToken()) {
            params.put("AddressConsentToken", request.getAddressConsentToken());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert AuthorizeRequest to name value pairs
     */
    private Map<String, String> convertAuthorize(AuthorizeRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "Authorize");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonOrderReferenceId()) {
            params.put("AmazonOrderReferenceId", request.getAmazonOrderReferenceId());
        }
        if (request.isSetAuthorizationReferenceId()) {
            params.put("AuthorizationReferenceId", request.getAuthorizationReferenceId());
        }
        if (request.isSetAuthorizationAmount()) {
            Price  authorizationAmount = request.getAuthorizationAmount();
            if (authorizationAmount.isSetAmount()) {
                params.put("AuthorizationAmount" + "." + "Amount", authorizationAmount.getAmount());
            }
            if (authorizationAmount.isSetCurrencyCode()) {
                params.put("AuthorizationAmount" + "." + "CurrencyCode", authorizationAmount.getCurrencyCode());
            }
        } 
        if (request.isSetSellerAuthorizationNote()) {
            params.put("SellerAuthorizationNote", request.getSellerAuthorizationNote());
        }
        if (request.isSetOrderItemCategories()) {
            OrderItemCategories  orderItemCategories = request.getOrderItemCategories();
            java.util.List<String> orderItemCategoryList  =  orderItemCategories.getOrderItemCategory();
            int orderItemCategoryListIndex = 1;
            for  (String orderItemCategory : orderItemCategoryList) { 
                params.put("OrderItemCategories" + "." + "OrderItemCategory" + "."  + orderItemCategoryListIndex, orderItemCategory);
                orderItemCategoryListIndex++;
            }
        } 
        if (request.isSetTransactionTimeout()) {
            params.put("TransactionTimeout", String.valueOf(request.getTransactionTimeout()));
        }
        if (request.isSetCaptureNow()) {
            params.put("CaptureNow", String.valueOf(request.isCaptureNow()));
        }
        if (request.isSetSoftDescriptor()) {
            params.put("SoftDescriptor", request.getSoftDescriptor());
        }
        if (request.isSetProviderCreditList()) {
            ProviderCreditList  providerCreditList = request.getProviderCreditList();
            java.util.List<ProviderCredit> memberList = providerCreditList.getMember();
            int memberListIndex = 1;
            for (ProviderCredit member : memberList) {
                if (member.isSetProviderId()) {
                    params.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "ProviderId", member.getProviderId());
                }
                if (member.isSetCreditAmount()) {
                    Price  creditAmount = member.getCreditAmount();
                    if (creditAmount.isSetAmount()) {
                        params.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "Amount", creditAmount.getAmount());
                    }
                    if (creditAmount.isSetCurrencyCode()) {
                        params.put("ProviderCreditList" + "." + "member" + "."  + memberListIndex + "." + "CreditAmount" + "." + "CurrencyCode", creditAmount.getCurrencyCode());
                    }
                } 

                memberListIndex++;
            }
        } 

        return params;
    }
        
        
    
    
                    
   /**
     * Convert SetOrderReferenceDetailsRequest to name value pairs
     */
    private Map<String, String> convertSetOrderReferenceDetails(SetOrderReferenceDetailsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "SetOrderReferenceDetails");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonOrderReferenceId()) {
            params.put("AmazonOrderReferenceId", request.getAmazonOrderReferenceId());
        }
        if (request.isSetOrderReferenceAttributes()) {
            OrderReferenceAttributes  orderReferenceAttributes = request.getOrderReferenceAttributes();
            if (orderReferenceAttributes.isSetOrderTotal()) {
                OrderTotal  orderTotal = orderReferenceAttributes.getOrderTotal();
                if (orderTotal.isSetCurrencyCode()) {
                    params.put("OrderReferenceAttributes" + "." + "OrderTotal" + "." + "CurrencyCode", orderTotal.getCurrencyCode());
                }
                if (orderTotal.isSetAmount()) {
                    params.put("OrderReferenceAttributes" + "." + "OrderTotal" + "." + "Amount", orderTotal.getAmount());
                }
            } 
            if (orderReferenceAttributes.isSetPlatformId()) {
                params.put("OrderReferenceAttributes" + "." + "PlatformId", orderReferenceAttributes.getPlatformId());
            }
            if (orderReferenceAttributes.isSetSellerNote()) {
                params.put("OrderReferenceAttributes" + "." + "SellerNote", orderReferenceAttributes.getSellerNote());
            }
            if (orderReferenceAttributes.isSetPlatformId()) {
                params.put("OrderReferenceAttributes" + "." + "PlatformId", orderReferenceAttributes.getPlatformId());
            }
            if(orderReferenceAttributes.isSetRequestPaymentAuthorization()) {
                params.put("OrderReferenceAttributes" + "." + "RequestPaymentAuthorization", orderReferenceAttributes.isRequestPaymentAuthorization().toString());
            }
            if (orderReferenceAttributes.isSetSellerOrderAttributes()) {
                SellerOrderAttributes  sellerOrderAttributes = orderReferenceAttributes.getSellerOrderAttributes();
                if (sellerOrderAttributes.isSetSellerOrderId()) {
                    params.put("OrderReferenceAttributes" + "." + "SellerOrderAttributes" + "." + "SellerOrderId", sellerOrderAttributes.getSellerOrderId());
                }
                if (sellerOrderAttributes.isSetStoreName()) {
                    params.put("OrderReferenceAttributes" + "." + "SellerOrderAttributes" + "." + "StoreName", sellerOrderAttributes.getStoreName());
                }
                if (sellerOrderAttributes.isSetOrderItemCategories()) {
                    OrderItemCategories  orderItemCategories = sellerOrderAttributes.getOrderItemCategories();
                    java.util.List<String> orderItemCategoryList  =  orderItemCategories.getOrderItemCategory();
                    int orderItemCategoryListIndex = 1;
                    for  (String orderItemCategory : orderItemCategoryList) { 
                        params.put("OrderReferenceAttributes" + "." + "SellerOrderAttributes" + "." + "OrderItemCategories" + "." + "OrderItemCategory" + "."  + orderItemCategoryListIndex, orderItemCategory);
                        orderItemCategoryListIndex++;
                    }
                } 
                if (sellerOrderAttributes.isSetCustomInformation()) {
                    params.put("OrderReferenceAttributes" + "." + "SellerOrderAttributes" + "." + "CustomInformation", sellerOrderAttributes.getCustomInformation());
                }
            } 
        } 

        return params;
    }
        
        
    
    
                    
   /**
     * Convert GetAuthorizationDetailsRequest to name value pairs
     */
    private Map<String, String> convertGetAuthorizationDetails(GetAuthorizationDetailsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "GetAuthorizationDetails");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonAuthorizationId()) {
            params.put("AmazonAuthorizationId", request.getAmazonAuthorizationId());
        }

        return params;
    }
        
        
    
    
                    
   /**
     * Convert CancelOrderReferenceRequest to name value pairs
     */
    private Map<String, String> convertCancelOrderReference(CancelOrderReferenceRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "CancelOrderReference");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonOrderReferenceId()) {
            params.put("AmazonOrderReferenceId", request.getAmazonOrderReferenceId());
        }
        if (request.isSetCancelationReason()) {
            params.put("CancelationReason", request.getCancelationReason());
        }

        return params;
    }
        
        
    
    
    
   /**
     * Convert CreateOrderReferenceForIdRequest to name value pairs
     */
    private Map<String, String> convertCreateOrderReferenceForId(CreateOrderReferenceForIdRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "CreateOrderReferenceForId");
        if (request.isSetId()) {
            params.put("Id", request.getId());
        }
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetIdType()) {
            params.put("IdType", request.getIdType());
        }
        if (request.isSetInheritShippingAddress()) {
            params.put("InheritShippingAddress", String.valueOf(request.isInheritShippingAddress()));
        }
        if (request.isSetConfirmNow()) {
            params.put("ConfirmNow", String.valueOf(request.isConfirmNow()));
        }
        if (request.isSetOrderReferenceAttributes()) {
            OrderReferenceAttributes  orderReferenceAttributes = request.getOrderReferenceAttributes();
            if (orderReferenceAttributes.isSetOrderTotal()) {
                OrderTotal  orderTotal = orderReferenceAttributes.getOrderTotal();
                if (orderTotal.isSetCurrencyCode()) {
                    params.put("OrderReferenceAttributes" + "." + "OrderTotal" + "." + "CurrencyCode", orderTotal.getCurrencyCode());
                }
                if (orderTotal.isSetAmount()) {
                    params.put("OrderReferenceAttributes" + "." + "OrderTotal" + "." + "Amount", orderTotal.getAmount());
                }
            } 
            if (orderReferenceAttributes.isSetPlatformId()) {
                params.put("OrderReferenceAttributes" + "." + "PlatformId", orderReferenceAttributes.getPlatformId());
            }
            if (orderReferenceAttributes.isSetSellerNote()) {
                params.put("OrderReferenceAttributes" + "." + "SellerNote", orderReferenceAttributes.getSellerNote());
            }
            if (orderReferenceAttributes.isSetSellerOrderAttributes()) {
                SellerOrderAttributes  sellerOrderAttributes = orderReferenceAttributes.getSellerOrderAttributes();
                if (sellerOrderAttributes.isSetSellerOrderId()) {
                    params.put("OrderReferenceAttributes" + "." + "SellerOrderAttributes" + "." + "SellerOrderId", sellerOrderAttributes.getSellerOrderId());
                }
                if (sellerOrderAttributes.isSetStoreName()) {
                    params.put("OrderReferenceAttributes" + "." + "SellerOrderAttributes" + "." + "StoreName", sellerOrderAttributes.getStoreName());
                }
                if (sellerOrderAttributes.isSetOrderItemCategories()) {
                    OrderItemCategories  orderItemCategories = sellerOrderAttributes.getOrderItemCategories();
                    java.util.List<String> orderItemCategoryList  =  orderItemCategories.getOrderItemCategory();
                    int orderItemCategoryListIndex = 1;
                    for  (String orderItemCategory : orderItemCategoryList) { 
                        params.put("OrderReferenceAttributes" + "." + "SellerOrderAttributes" + "." + "OrderItemCategories" + "." + "OrderItemCategory" + "."  + orderItemCategoryListIndex, orderItemCategory);
                        orderItemCategoryListIndex++;
                    }   
                } 
                if (sellerOrderAttributes.isSetCustomInformation()) {
                    params.put("OrderReferenceAttributes" + "." + "SellerOrderAttributes" + "." + "CustomInformation", sellerOrderAttributes.getCustomInformation());
                }
            } 
        } 

        return params;
    }
        
        
    
    
    
   /**
     * Convert GetBillingAgreementDetailsRequest to name value pairs
     */
    private Map<String, String> convertGetBillingAgreementDetails(GetBillingAgreementDetailsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "GetBillingAgreementDetails");
        if (request.isSetAmazonBillingAgreementId()) {
            params.put("AmazonBillingAgreementId", request.getAmazonBillingAgreementId());
        }
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAddressConsentToken()) {
            params.put("AddressConsentToken", request.getAddressConsentToken());
        }

        return params;
    }
        
        
    
    
    
   /**
     * Convert SetBillingAgreementDetailsRequest to name value pairs
     */
    private Map<String, String> convertSetBillingAgreementDetails(SetBillingAgreementDetailsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "SetBillingAgreementDetails");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonBillingAgreementId()) {
            params.put("AmazonBillingAgreementId", request.getAmazonBillingAgreementId());
        }
        if (request.isSetBillingAgreementAttributes()) {
            BillingAgreementAttributes  billingAgreementAttributes = request.getBillingAgreementAttributes();
            if (billingAgreementAttributes.isSetPlatformId()) {
                params.put("BillingAgreementAttributes" + "." + "PlatformId", billingAgreementAttributes.getPlatformId());
            }
            if (billingAgreementAttributes.isSetSellerNote()) {
                params.put("BillingAgreementAttributes" + "." + "SellerNote", billingAgreementAttributes.getSellerNote());
            }
            if (billingAgreementAttributes.isSetSellerBillingAgreementAttributes()) {
                SellerBillingAgreementAttributes  sellerBillingAgreementAttributes = billingAgreementAttributes.getSellerBillingAgreementAttributes();
                if (sellerBillingAgreementAttributes.isSetSellerBillingAgreementId()) {
                    params.put("BillingAgreementAttributes" + "." + "SellerBillingAgreementAttributes" + "." + "SellerBillingAgreementId", sellerBillingAgreementAttributes.getSellerBillingAgreementId());
                }
                if (sellerBillingAgreementAttributes.isSetStoreName()) {
                    params.put("BillingAgreementAttributes" + "." + "SellerBillingAgreementAttributes" + "." + "StoreName", sellerBillingAgreementAttributes.getStoreName());
                }
                if (sellerBillingAgreementAttributes.isSetCustomInformation()) {
                    params.put("BillingAgreementAttributes" + "." + "SellerBillingAgreementAttributes" + "." + "CustomInformation", sellerBillingAgreementAttributes.getCustomInformation());
                }
            } 
        } 

        return params;
    }
        
    
    
    
    
    /**
     * Convert ConfirmBillingAgreementRequest to name value pairs
     */
    private Map<String, String> convertConfirmBillingAgreement(ConfirmBillingAgreementRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "ConfirmBillingAgreement");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonBillingAgreementId()) {
            params.put("AmazonBillingAgreementId", request.getAmazonBillingAgreementId());
        }

        return params;
    }
    
    
    
    
    
   /**
     * Convert ValidateBillingAgreementRequest to name value pairs
     */
    private Map<String, String> convertValidateBillingAgreement(ValidateBillingAgreementRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "ValidateBillingAgreement");
        if (request.isSetAmazonBillingAgreementId()) {
            params.put("AmazonBillingAgreementId", request.getAmazonBillingAgreementId());
        }
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }

        return params;
    }
        
        
    
    
    
   /**
     * Convert AuthorizeOnBillingAgreementRequest to name value pairs
     */
    private Map<String, String> convertAuthorizeOnBillingAgreement(AuthorizeOnBillingAgreementRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "AuthorizeOnBillingAgreement");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonBillingAgreementId()) {
            params.put("AmazonBillingAgreementId", request.getAmazonBillingAgreementId());
        }
        if (request.isSetAuthorizationReferenceId()) {
            params.put("AuthorizationReferenceId", request.getAuthorizationReferenceId());
        }
        if (request.isSetAuthorizationAmount()) {
            Price  authorizationAmount = request.getAuthorizationAmount();
            if (authorizationAmount.isSetAmount()) {
                params.put("AuthorizationAmount" + "." + "Amount", authorizationAmount.getAmount());
            }
            if (authorizationAmount.isSetCurrencyCode()) {
                params.put("AuthorizationAmount" + "." + "CurrencyCode", authorizationAmount.getCurrencyCode());
            }
        } 
        if (request.isSetSellerAuthorizationNote()) {
            params.put("SellerAuthorizationNote", request.getSellerAuthorizationNote());
        }
        if (request.isSetTransactionTimeout()) {
            params.put("TransactionTimeout", String.valueOf(request.getTransactionTimeout()));
        }
        if (request.isSetCaptureNow()) {
            params.put("CaptureNow", String.valueOf(request.isCaptureNow()));
        }
        if (request.isSetSoftDescriptor()) {
            params.put("SoftDescriptor", request.getSoftDescriptor());
        }
        if (request.isSetSellerNote()) {
            params.put("SellerNote", request.getSellerNote());
        }
        if (request.isSetPlatformId()) {
            params.put("PlatformId", request.getPlatformId());
        }
        if (request.isSetSellerOrderAttributes()) {
            SellerOrderAttributes  sellerOrderAttributes = request.getSellerOrderAttributes();
            if (sellerOrderAttributes.isSetSellerOrderId()) {
                params.put("SellerOrderAttributes" + "." + "SellerOrderId", sellerOrderAttributes.getSellerOrderId());
            }
            if (sellerOrderAttributes.isSetStoreName()) {
                params.put("SellerOrderAttributes" + "." + "StoreName", sellerOrderAttributes.getStoreName());
            }
            if (sellerOrderAttributes.isSetOrderItemCategories()) {
                OrderItemCategories  orderItemCategories = sellerOrderAttributes.getOrderItemCategories();
                java.util.List<String> orderItemCategoryList  =  orderItemCategories.getOrderItemCategory();
                int orderItemCategoryListIndex = 1;
                for  (String orderItemCategory : orderItemCategoryList) { 
                    params.put("SellerOrderAttributes" + "." + "OrderItemCategories" + "." + "OrderItemCategory" + "."  + orderItemCategoryListIndex, orderItemCategory);
                    orderItemCategoryListIndex++;
                }   
            } 
            if (sellerOrderAttributes.isSetCustomInformation()) {
                params.put("SellerOrderAttributes" + "." + "CustomInformation", sellerOrderAttributes.getCustomInformation());
            }
        } 
        if (request.isSetInheritShippingAddress()) {
            params.put("InheritShippingAddress", String.valueOf(request.isInheritShippingAddress()));
        }

        return params;
    }
    
        
        
    
                    
   /**
     * Convert CloseBillingAgreementRequest to name value pairs
     */
    private Map<String, String> convertCloseBillingAgreement(CloseBillingAgreementRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "CloseBillingAgreement");
        if (request.isSetAmazonBillingAgreementId()) {
            params.put("AmazonBillingAgreementId", request.getAmazonBillingAgreementId());
        }
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetClosureReason()) {
            params.put("ClosureReason", request.getClosureReason());
        }
        if (request.isSetReasonCode()) {
            params.put("ReasonCode", request.getReasonCode());
        }

        return params;
    }
    
    
    
    /**
     * Convert GetProviderCreditDetailsRequest to name value pairs
     */
    private Map<String, String> convertGetProviderCreditDetails(GetProviderCreditDetailsRequest request) {
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("Action", "GetProviderCreditDetails");
    	if (request.isSetSellerId()) {
    		params.put("SellerId", request.getSellerId());
    	}
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
    	if (request.isSetAmazonProviderCreditId()) {
    		params.put("AmazonProviderCreditId", request.getAmazonProviderCreditId());
    	}
    	return params;
    }


        
    /**
     * Convert GetProviderCreditReversalDetailsRequest to name value pairs
     */
    private Map<String, String> convertGetProviderCreditReversalDetails(GetProviderCreditReversalDetailsRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "GetProviderCreditReversalDetails");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonProviderCreditReversalId()) {
            params.put("AmazonProviderCreditReversalId", request.getAmazonProviderCreditReversalId());
        }

        return params;
    }
        
    /**
     * Convert ReverseProviderCreditRequest to name value pairs
     */
    private Map<String, String> convertReverseProviderCredit(ReverseProviderCreditRequest request) {
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "ReverseProviderCredit");
        if (request.isSetSellerId()) {
            params.put("SellerId", request.getSellerId());
        }
        if (request.isSetMWSAuthToken()) {
            params.put("MWSAuthToken", request.getMWSAuthToken());
        }
        if (request.isSetAmazonProviderCreditId()) {
            params.put("AmazonProviderCreditId", request.getAmazonProviderCreditId());
        }
        if (request.isSetCreditReversalReferenceId()) {
            params.put("CreditReversalReferenceId", request.getCreditReversalReferenceId());
        }
        if (request.isSetCreditReversalAmount()) {
            Price  creditReversalAmount = request.getCreditReversalAmount();
            if (creditReversalAmount.isSetAmount()) {
                params.put("CreditReversalAmount" + "." + "Amount", creditReversalAmount.getAmount());
            }
            if (creditReversalAmount.isSetCurrencyCode()) {
                params.put("CreditReversalAmount" + "." + "CurrencyCode", creditReversalAmount.getCurrencyCode());
            }
        } 
        if (request.isSetCreditReversalNote()) {
            params.put("CreditReversalNote", request.getCreditReversalNote());
        }

        return params;
    }
}
