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
 */



package com.amazonservices.mws.offamazonpayments;

import com.amazonservices.mws.offamazonpayments.model.*;



/**
 * Coral service for marketplace
 * payment API operations for external
 * merchants.
 * 
 * 
 */
public interface  OffAmazonPaymentsService {
    

        
    /**
     * Capture 
     *
  
     * @param request
     *          Capture Action
     * @return
     *          Capture Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CaptureResponse capture(CaptureRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Refund 
     *
  
     * @param request
     *          Refund Action
     * @return
     *          Refund Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public RefundResponse refund(RefundRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Close Authorization 
     *
  
     * @param request
     *          CloseAuthorization Action
     * @return
     *          CloseAuthorization Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CloseAuthorizationResponse closeAuthorization(CloseAuthorizationRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Get Refund Details 
     *
  
     * @param request
     *          GetRefundDetails Action
     * @return
     *          GetRefundDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetRefundDetailsResponse getRefundDetails(GetRefundDetailsRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Get Capture Details 
     *
  
     * @param request
     *          GetCaptureDetails Action
     * @return
     *          GetCaptureDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetCaptureDetailsResponse getCaptureDetails(GetCaptureDetailsRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Close Order Reference 
     *
  
     * @param request
     *          CloseOrderReference Action
     * @return
     *          CloseOrderReference Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CloseOrderReferenceResponse closeOrderReference(CloseOrderReferenceRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Confirm Order Reference 
     *
  
     * @param request
     *          ConfirmOrderReference Action
     * @return
     *          ConfirmOrderReference Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public ConfirmOrderReferenceResponse confirmOrderReference(ConfirmOrderReferenceRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Get Order Reference Details 
     *
  
     * @param request
     *          GetOrderReferenceDetails Action
     * @return
     *          GetOrderReferenceDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetOrderReferenceDetailsResponse getOrderReferenceDetails(GetOrderReferenceDetailsRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Authorize 
     *
  
     * @param request
     *          Authorize Action
     * @return
     *          Authorize Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public AuthorizeResponse authorize(AuthorizeRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Set Order Reference Details 
     *
  
     * @param request
     *          SetOrderReferenceDetails Action
     * @return
     *          SetOrderReferenceDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public SetOrderReferenceDetailsResponse setOrderReferenceDetails(SetOrderReferenceDetailsRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Get Authorization Details 
     *
  
     * @param request
     *          GetAuthorizationDetails Action
     * @return
     *          GetAuthorizationDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetAuthorizationDetailsResponse getAuthorizationDetails(GetAuthorizationDetailsRequest request) throws OffAmazonPaymentsServiceException;


        
    /**
     * Cancel Order Reference 
     *
  
     * @param request
     *          CancelOrderReference Action
     * @return
     *          CancelOrderReference Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CancelOrderReferenceResponse cancelOrderReference(CancelOrderReferenceRequest request) throws OffAmazonPaymentsServiceException;


    
    /**
     * Create Order Reference For Id 
     *
     *   
     * @param request
     *          CreateOrderReferenceForId Action
     * @return
     *          CreateOrderReferenceForId Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CreateOrderReferenceForIdResponse createOrderReferenceForId(CreateOrderReferenceForIdRequest request) throws OffAmazonPaymentsServiceException;


    
    /**
     * Get Billing Agreement Details 
     *
     *   
     * @param request
     *          GetBillingAgreementDetails Action
     * @return
     *          GetBillingAgreementDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetBillingAgreementDetailsResponse getBillingAgreementDetails(GetBillingAgreementDetailsRequest request) throws OffAmazonPaymentsServiceException;


    
    /**
     * Set Billing Agreement Details 
     *
     *   
     * @param request
     *          SetBillingAgreementDetails Action
     * @return
     *          SetBillingAgreementDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public SetBillingAgreementDetailsResponse setBillingAgreementDetails(SetBillingAgreementDetailsRequest request) throws OffAmazonPaymentsServiceException;


    
    /**
     * Confirm Billing Agreement 
     *
     *   
     * @param request
     *          ConfirmBillingAgreement Action
     * @return
     *          ConfirmBillingAgreement Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public ConfirmBillingAgreementResponse confirmBillingAgreement(ConfirmBillingAgreementRequest request) throws OffAmazonPaymentsServiceException;


    
    /**
     * Validate Billing Agreement 
     *
     *   
     * @param request
     *          ValidateBillingAgreement Action
     * @return
     *          ValidateBillingAgreement Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public ValidateBillingAgreementResponse validateBillingAgreement(ValidateBillingAgreementRequest request) throws OffAmazonPaymentsServiceException;


    
    /**
     * Authorize On Billing Agreement 
     *
     *   
     * @param request
     *          AuthorizeOnBillingAgreement Action
     * @return
     *          AuthorizeOnBillingAgreement Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public AuthorizeOnBillingAgreementResponse authorizeOnBillingAgreement(AuthorizeOnBillingAgreementRequest request) throws OffAmazonPaymentsServiceException;


    
    /**
     * Close Billing Agreement 
     *
     *   
     * @param request
     *          CloseBillingAgreement Action
     * @return
     *          CloseBillingAgreement Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public CloseBillingAgreementResponse closeBillingAgreement(CloseBillingAgreementRequest request) throws OffAmazonPaymentsServiceException;
    
    
    
    /**
     * Get Provider Credit Details 
     *
     * A query API for ProviderCredits.  Both Provider and Seller sellerIds are authorized to call this API.
     *   
     * @param request
     *          GetProviderCreditDetails Action
     * @return
     *          GetProviderCreditDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetProviderCreditDetailsResponse getProviderCreditDetails(GetProviderCreditDetailsRequest request) throws OffAmazonPaymentsServiceException;
    
    
    /**
     * Get Provider Credit Reversal Details 
     *
     * Activity to query the funds reversed against a given Provider Credit reversal.
     *   
     * @param request
     *          GetProviderCreditReversalDetails Action
     * @return
     *          GetProviderCreditReversalDetails Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public GetProviderCreditReversalDetailsResponse getProviderCreditReversalDetails(GetProviderCreditReversalDetailsRequest request) throws OffAmazonPaymentsServiceException;


    
    
    /**
     * Reverse Provider Credit 
     *
     * Activity to enable the Caller/Provider to reverse the funds credited to Provider.
     *   
     * @param request
     *          ReverseProviderCredit Action
     * @return
     *          ReverseProviderCredit Response from the service
     *
     * @throws OffAmazonPaymentsServiceException
     */
    public ReverseProviderCreditResponse reverseProviderCredit(ReverseProviderCreditRequest request) throws OffAmazonPaymentsServiceException;


    





}