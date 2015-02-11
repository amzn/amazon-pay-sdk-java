/*******************************************************************************
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
 * *****************************************************************************
 * 
 *  Off Amazon Payments Service Java Library
 *  API Version: 2013-01-01
 * 
 */



package samples;

import java.io.PrintWriter;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

import samples.utils.PropertyBundle;
/**
 *
 * Get Provider Credit Details  Samples
 *
 *
 */
public class GetProviderCreditDetailsSample {

    /**
     * Just add few required parameters, and try the service
     * Get Provider Credit Details functionality
     *
     * @param args unused
     */
     public static void main(String... args) {
        OffAmazonPaymentsServiceConfig config = new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());			
		OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

		/************************************************************************
         * Setup request parameters and try out 
         * sample for Get Provider Credit Details 
         ***********************************************************************/
         GetProviderCreditDetailsRequest request = new GetProviderCreditDetailsRequest();
         request.setSellerId(config.getSellerId());
         
         GetProviderCreditDetailsResponse response = invokeGetProviderCreditDetails(service, request);
         printResponse(response, new PrintWriter(System.out, true));
    }


                            
    /**
     * Get Provider Credit Details  request sample
     * A query API for ProviderCredits.  Both Provider and Seller sellerIds are authorized to call this API.
     *   
     * @param service instance of OffAmazonPaymentsService service
     * @param request Action to invoke
     */
    public static GetProviderCreditDetailsResponse invokeGetProviderCreditDetails(OffAmazonPaymentsService service, GetProviderCreditDetailsRequest request) {
        try {
        
            GetProviderCreditDetailsResponse response = service.getProviderCreditDetails(request);            
            return response; 
            
        } catch (OffAmazonPaymentsServiceException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.println("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
            return null;
        }
    }
    
    /**
    * Method to print Get Provider Credit Details  response to console
     * A query API for ProviderCredits.  Both Provider and Seller sellerIds are authorized to call this API.
     * 
	*@param response instance of GetProviderCreditDetailsResponse
    */
    public static void printResponse(GetProviderCreditDetailsResponse response, PrintWriter outStream){
    
                
            outStream.println ("GetProviderCreditDetails Action Response");
            outStream.println ("=============================================================================");
            outStream.println ();

            outStream.println("    GetProviderCreditDetailsResponse");
            outStream.println();
            if (response.isSetGetProviderCreditDetailsResult()) {
                outStream.println("        GetProviderCreditDetailsResult");
                outStream.println();
                GetProviderCreditDetailsResult  getProviderCreditDetailsResult = response.getGetProviderCreditDetailsResult();
                if (getProviderCreditDetailsResult.isSetProviderCreditDetails()) {
                    outStream.println("            ProviderCreditDetails");
                    outStream.println();
                    ProviderCreditDetails  providerCreditDetails = getProviderCreditDetailsResult.getProviderCreditDetails();
                    if (providerCreditDetails.isSetAmazonProviderCreditId()) {
                        outStream.println("                AmazonProviderCreditId");
                        outStream.println();
                        outStream.println("                    " + providerCreditDetails.getAmazonProviderCreditId());
                        outStream.println();
                    }
                    if (providerCreditDetails.isSetSellerId()) {
                        outStream.println("                SellerId");
                        outStream.println();
                        outStream.println("                    " + providerCreditDetails.getSellerId());
                        outStream.println();
                    }
                    if (providerCreditDetails.isSetProviderId()) {
                        outStream.println("                ProviderId");
                        outStream.println();
                        outStream.println("                    " + providerCreditDetails.getProviderId());
                        outStream.println();
                    }
                    if (providerCreditDetails.isSetCreditReferenceId()) {
                        outStream.println("                CreditReferenceId");
                        outStream.println();
                        outStream.println("                    " + providerCreditDetails.getCreditReferenceId());
                        outStream.println();
                    }
                    if (providerCreditDetails.isSetCreditAmount()) {
                        outStream.println("                CreditAmount");
                        outStream.println();
                        Price  creditAmount = providerCreditDetails.getCreditAmount();
                        if (creditAmount.isSetAmount()) {
                            outStream.println("                    Amount");
                            outStream.println();
                            outStream.println("                        " + creditAmount.getAmount());
                            outStream.println();
                        }
                        if (creditAmount.isSetCurrencyCode()) {
                            outStream.println("                    CurrencyCode");
                            outStream.println();
                            outStream.println("                        " + creditAmount.getCurrencyCode());
                            outStream.println();
                        }
                    } 
                    if (providerCreditDetails.isSetCreditReversalAmount()) {
                        outStream.println("                CreditReversalAmount");
                        outStream.println();
                        Price  creditReversalAmount = providerCreditDetails.getCreditReversalAmount();
                        if (creditReversalAmount.isSetAmount()) {
                            outStream.println("                    Amount");
                            outStream.println();
                            outStream.println("                        " + creditReversalAmount.getAmount());
                            outStream.println();
                        }
                        if (creditReversalAmount.isSetCurrencyCode()) {
                            outStream.println("                    CurrencyCode");
                            outStream.println();
                            outStream.println("                        " + creditReversalAmount.getCurrencyCode());
                            outStream.println();
                        }
                    } 
                    if (providerCreditDetails.isSetCreditReversalIdList()) {
                        outStream.println("                CreditReversalIdList");
                        outStream.println();
                        IdList  creditReversalIdList = providerCreditDetails.getCreditReversalIdList();
                        java.util.List<String> memberList  =  creditReversalIdList.getMember();
                        for (String member : memberList) { 
                            outStream.println("                    member");
                                outStream.println();
                            outStream.println("                        " + member);
                        }	
                    } 
                    if (providerCreditDetails.isSetCreationTimestamp()) {
                        outStream.println("                CreationTimestamp");
                        outStream.println();
                        outStream.println("                    " + providerCreditDetails.getCreationTimestamp());
                        outStream.println();
                    }
                    if (providerCreditDetails.isSetCreditStatus()) {
                        outStream.println("                CreditStatus");
                        outStream.println();
                        Status  creditStatus = providerCreditDetails.getCreditStatus();
                        if (creditStatus.isSetState()) {
                            outStream.println("                    State");
                            outStream.println();
                            outStream.println("                        " + creditStatus.getState());
                            outStream.println();
                        }
                        if (creditStatus.isSetLastUpdateTimestamp()) {
                            outStream.println("                    LastUpdateTimestamp");
                            outStream.println();
                            outStream.println("                        " + creditStatus.getLastUpdateTimestamp());
                            outStream.println();
                        }
                        if (creditStatus.isSetReasonCode()) {
                            outStream.println("                    ReasonCode");
                            outStream.println();
                            outStream.println("                        " + creditStatus.getReasonCode());
                            outStream.println();
                        }
                        if (creditStatus.isSetReasonDescription()) {
                            outStream.println("                    ReasonDescription");
                            outStream.println();
                            outStream.println("                        " + creditStatus.getReasonDescription());
                            outStream.println();
                        }
                    } 
                } 
            } 
            if (response.isSetResponseMetadata()) {
                outStream.println("        ResponseMetadata");
                outStream.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    outStream.println("            RequestId");
                    outStream.println();
                    outStream.println("                " + responseMetadata.getRequestId());
                    outStream.println();
                }
            } 
            outStream.println();
            outStream.println(response.getResponseHeaderMetadata());
            outStream.println();

    }
    
                                                                                    
}
