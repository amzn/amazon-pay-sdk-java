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



package samples;

import java.io.PrintWriter;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

import samples.utils.PropertyBundle;
import samples.utils.Utilities;

/**
 *
 * Get Refund Details  Samples
 *
 *
 */
public class GetRefundDetailsSample {

  /**
   * Just add few required parameters, and try the service
   * Get Refund Details functionality
   *
   * @param args unused
   */
   public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
      new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /**********************************************************************
     * Setup request parameters and try out sample for
     * Get Refund Details 
    ***********************************************************************/
    GetRefundDetailsRequest request = new GetRefundDetailsRequest();
    request.setSellerId(config.getSellerId());

    PrintWriter outStream = new PrintWriter(System.out, true);
    
   GetRefundDetailsResponse response = invokeGetRefundDetails(service, request, outStream);
   printResponse(response, outStream);
  }


                        
  /**
   * Get Refund Details  request sample

   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
  */
  public static GetRefundDetailsResponse invokeGetRefundDetails(
    OffAmazonPaymentsService service, GetRefundDetailsRequest request, PrintWriter outStream) {
    try {
      GetRefundDetailsResponse response =
        service.getRefundDetails(request);
      return response;
    } catch (OffAmazonPaymentsServiceException ex) {
        outStream.println("Caught Exception: " + ex.getMessage());
        outStream.println("Response Status Code: " + ex.getStatusCode());
        outStream.println("Error Code: " + ex.getErrorCode());
        outStream.println("Error Type: " + ex.getErrorType());
        outStream.println("Request ID: " + ex.getRequestId());
        outStream.println("XML: " + ex.getXML());
        outStream.println("ResponseHeaderMetadata: " +
      	  ex.getResponseHeaderMetadata());
        return null;
  }
}

    /**
    * Method to print Get Refund Details  response to console

  *@param response instance of GetRefundDetailsResponse
    */
    public static void printResponse(GetRefundDetailsResponse response, PrintWriter outStream){

            int tabLevel = 1;
            outStream.println ("GetRefundDetails Action Response");
            outStream.println ("=============================================================================");
            outStream.println ();

            Utilities.printVariable("GetRefundDetailsResponse", null, tabLevel, outStream);
            tabLevel++;
            if (response.isSetGetRefundDetailsResult()) {
                Utilities.printVariable("GetRefundDetailsResult", null, tabLevel, outStream);
                GetRefundDetailsResult  getRefundDetailsResult = response.getGetRefundDetailsResult();
                tabLevel++;
                if (getRefundDetailsResult.isSetRefundDetails()) {
                    Utilities.printVariable("RefundDetails", null, tabLevel, outStream);
                    RefundDetails  refundDetails = getRefundDetailsResult.getRefundDetails();
                    tabLevel++;
                    if (refundDetails.isSetAmazonRefundId()) {
                        Utilities.printVariable("AmazonRefundId", refundDetails.getAmazonRefundId(), tabLevel, outStream);
                    }
                    if (refundDetails.isSetRefundReferenceId()) {
                        Utilities.printVariable("RefundReferenceId", refundDetails.getRefundReferenceId(), tabLevel, outStream);
                    }
                    if (refundDetails.isSetSellerRefundNote()) {
                        Utilities.printVariable("SellerRefundNote", refundDetails.getSellerRefundNote(), tabLevel, outStream);
                    }
                    if (refundDetails.isSetRefundType()) {
                        Utilities.printVariable("RefundType", refundDetails.getRefundType().value(), tabLevel, outStream);
                    }
                    if (refundDetails.isSetRefundAmount()) {
                        Utilities.printVariable("RefundAmount", null, tabLevel, outStream);
                        Price  refundAmount = refundDetails.getRefundAmount();
                        tabLevel++;
                        if (refundAmount.isSetAmount()) {
                            Utilities.printVariable("Amount", refundAmount.getAmount(), tabLevel, outStream);
                        }
                        if (refundAmount.isSetCurrencyCode()) {
                            Utilities.printVariable("CurrencyCode", refundAmount.getCurrencyCode(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (refundDetails.isSetFeeRefunded()) {
                        Utilities.printVariable("FeeRefunded", null, tabLevel, outStream);
                        Price  feeRefunded = refundDetails.getFeeRefunded();
                        tabLevel++;
                        if (feeRefunded.isSetAmount()) {
                            Utilities.printVariable("Amount", feeRefunded.getAmount(), tabLevel, outStream);
                        }
                        if (feeRefunded.isSetCurrencyCode()) {
                            Utilities.printVariable("CurrencyCode", feeRefunded.getCurrencyCode(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (refundDetails.isSetCreationTimestamp()) {
                        Utilities.printVariable("CreationTimestamp", refundDetails.getCreationTimestamp().toString(), tabLevel, outStream);
                    }
                    if (refundDetails.isSetRefundStatus()) {
                        Utilities.printVariable("RefundStatus", null, tabLevel, outStream);
                        Status  refundStatus = refundDetails.getRefundStatus();
                        tabLevel++;
                        if (refundStatus.isSetState()) {
                            Utilities.printVariable("State", refundStatus.getState(), tabLevel, outStream);
                        }
                        if (refundStatus.isSetLastUpdateTimestamp()) {
                            Utilities.printVariable("LastUpdateTimestamp", refundStatus.getLastUpdateTimestamp().toString(), tabLevel, outStream);
                        }
                        if (refundStatus.isSetReasonCode()) {
                            Utilities.printVariable("ReasonCode", refundStatus.getReasonCode(), tabLevel, outStream);
                        }
                        if (refundStatus.isSetReasonDescription()) {
                            Utilities.printVariable("ReasonDescription", refundStatus.getReasonDescription(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (refundDetails.isSetSoftDescriptor()) {
                        Utilities.printVariable("SoftDescriptor", refundDetails.getSoftDescriptor(), tabLevel, outStream);
                    }
                    if (refundDetails.isSetProviderCreditReversalSummaryList()) {
                    	Utilities.printVariable("ProviderCreditReversalSummaryList", null, tabLevel, outStream);
                        ProviderCreditReversalSummaryList  providerCreditReversalSummaryList = refundDetails.getProviderCreditReversalSummaryList();
                        java.util.List<ProviderCreditReversalSummary> memberList = providerCreditReversalSummaryList.getMember();
                        tabLevel++;
                        for (ProviderCreditReversalSummary member : memberList) {
                        	Utilities.printVariable("member", null, tabLevel, outStream);
                            tabLevel++;
                            if (member.isSetProviderId()) {
                            	Utilities.printVariable("ProviderId", member.getProviderId(), tabLevel, outStream);
                            }
                            if (member.isSetProviderCreditReversalId()) {
                            	Utilities.printVariable("ProviderCreditReversalId", member.getProviderCreditReversalId(), tabLevel, outStream);                                
                            }
                            tabLevel--;
                        }
                        tabLevel--;
                    } 
                }
                tabLevel--;
            } 
            if (response.isSetResponseMetadata()) {
                Utilities.printVariable("ResponseMetadata", null, tabLevel, outStream);
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                tabLevel++;
                if (responseMetadata.isSetRequestId()) {
                    Utilities.printVariable("RequestId", responseMetadata.getRequestId(), tabLevel, outStream);
                }
                tabLevel--;
            } 
            outStream.println();
            outStream.println(response.getResponseHeaderMetadata());
            outStream.println();

    }
}
