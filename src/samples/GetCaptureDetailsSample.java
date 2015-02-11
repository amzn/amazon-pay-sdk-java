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
 * Get Capture Details  Samples
 *
 *
 */
public class GetCaptureDetailsSample {

  /**
   * Just add few required parameters, and try the service
   * Get Capture Details functionality
   *
   * @param args unused
   */
   public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
      new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /**********************************************************************
     * Setup request parameters and try out sample for
     * Get Capture Details 
    ***********************************************************************/
    GetCaptureDetailsRequest request = new GetCaptureDetailsRequest();
    request.setSellerId(config.getSellerId());
    
    PrintWriter outStream = new PrintWriter(System.out, true);

   GetCaptureDetailsResponse response = invokeGetCaptureDetails(service, request, outStream);
   printResponse(response, outStream);
  }


                            
  /**
   * Get Capture Details  request sample

   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
  */
  public static GetCaptureDetailsResponse invokeGetCaptureDetails(
    OffAmazonPaymentsService service, GetCaptureDetailsRequest request, PrintWriter outStream) {
    try {
      GetCaptureDetailsResponse response =
        service.getCaptureDetails(request);
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
    * Method to print Get Capture Details  response to console

  *@param response instance of GetCaptureDetailsResponse
    */
    public static void printResponse(GetCaptureDetailsResponse response, PrintWriter outStream){

            int tabLevel = 1;
            outStream.println ("GetCaptureDetails Action Response");
            outStream.println ("=============================================================================");
            outStream.println ();

            Utilities.printVariable("GetCaptureDetailsResponse", null, tabLevel, outStream);
            tabLevel++;
            if (response.isSetGetCaptureDetailsResult()) {
                Utilities.printVariable("GetCaptureDetailsResult", null, tabLevel, outStream);
                GetCaptureDetailsResult  getCaptureDetailsResult = response.getGetCaptureDetailsResult();
                tabLevel++;
                if (getCaptureDetailsResult.isSetCaptureDetails()) {
                    Utilities.printVariable("CaptureDetails", null, tabLevel, outStream);
                    CaptureDetails  captureDetails = getCaptureDetailsResult.getCaptureDetails();
                    tabLevel++;
                    if (captureDetails.isSetAmazonCaptureId()) {
                        Utilities.printVariable("AmazonCaptureId", captureDetails.getAmazonCaptureId(), tabLevel, outStream);
                    }
                    if (captureDetails.isSetCaptureReferenceId()) {
                        Utilities.printVariable("CaptureReferenceId", captureDetails.getCaptureReferenceId(), tabLevel, outStream);
                    }
                    if (captureDetails.isSetSellerCaptureNote()) {
                        Utilities.printVariable("SellerCaptureNote", captureDetails.getSellerCaptureNote(), tabLevel, outStream);
                    }
                    if (captureDetails.isSetCaptureAmount()) {
                        Utilities.printVariable("CaptureAmount", null, tabLevel, outStream);
                        Price  captureAmount = captureDetails.getCaptureAmount();
                        tabLevel++;
                        if (captureAmount.isSetAmount()) {
                            Utilities.printVariable("Amount", captureAmount.getAmount(), tabLevel, outStream);
                        }
                        if (captureAmount.isSetCurrencyCode()) {
                            Utilities.printVariable("CurrencyCode", captureAmount.getCurrencyCode(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (captureDetails.isSetRefundedAmount()) {
                        Utilities.printVariable("RefundedAmount", null, tabLevel, outStream);
                        Price  refundedAmount = captureDetails.getRefundedAmount();
                        tabLevel++;
                        if (refundedAmount.isSetAmount()) {
                            Utilities.printVariable("Amount", refundedAmount.getAmount(), tabLevel, outStream);
                        }
                        if (refundedAmount.isSetCurrencyCode()) {
                            Utilities.printVariable("CurrencyCode", refundedAmount.getCurrencyCode(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (captureDetails.isSetCaptureFee()) {
                        Utilities.printVariable("CaptureFee", null, tabLevel, outStream);
                        Price  captureFee = captureDetails.getCaptureFee();
                        tabLevel++;
                        if (captureFee.isSetAmount()) {
                            Utilities.printVariable("Amount", captureFee.getAmount(), tabLevel, outStream);
                        }
                        if (captureFee.isSetCurrencyCode()) {
                            Utilities.printVariable("CurrencyCode", captureFee.getCurrencyCode(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (captureDetails.isSetIdList()) {
                        Utilities.printVariable("IdList", null, tabLevel, outStream);
                        IdList  idList = captureDetails.getIdList();
                        java.util.List<String> memberList  =  idList.getMember();
                        tabLevel++;
                        for (String member : memberList) { 
                            Utilities.printVariable("member", member, tabLevel, outStream);
                        }	
                        tabLevel--;
                    } 
                    if (captureDetails.isSetCreationTimestamp()) {
                        Utilities.printVariable("CreationTimestamp", captureDetails.getCreationTimestamp().toString(), tabLevel, outStream);
                    }
                    if (captureDetails.isSetCaptureStatus()) {
                        Utilities.printVariable("CaptureStatus", null, tabLevel, outStream);
                        Status  captureStatus = captureDetails.getCaptureStatus();
                        tabLevel++;
                        if (captureStatus.isSetState()) {
                            Utilities.printVariable("State", captureStatus.getState(), tabLevel, outStream);
                        }
                        if (captureStatus.isSetLastUpdateTimestamp()) {
                            Utilities.printVariable("LastUpdateTimestamp", captureStatus.getLastUpdateTimestamp().toString(), tabLevel, outStream);
                        }
                        if (captureStatus.isSetReasonCode()) {
                            Utilities.printVariable("ReasonCode", captureStatus.getReasonCode(), tabLevel, outStream);
                        }
                        if (captureStatus.isSetReasonDescription()) {
                            Utilities.printVariable("ReasonDescription", captureStatus.getReasonDescription(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (captureDetails.isSetSoftDescriptor()) {
                        Utilities.printVariable("SoftDescriptor", captureDetails.getSoftDescriptor(), tabLevel, outStream);
                    }
                    if (captureDetails.isSetProviderCreditSummaryList()) {
                    	Utilities.printVariable("ProviderCreditSummaryList", null, tabLevel, outStream);
                        ProviderCreditSummaryList  providerCreditSummaryList = captureDetails.getProviderCreditSummaryList();
                        java.util.List<ProviderCreditSummary> memberList = providerCreditSummaryList.getMember();
                        tabLevel++;
                        for (ProviderCreditSummary member : memberList) {
                        	Utilities.printVariable("member", null, tabLevel, outStream);
                            tabLevel++;
                            if (member.isSetProviderId()) {
                            	Utilities.printVariable("ProviderId", member.getProviderId(), tabLevel, outStream);
                            }
                            if (member.isSetProviderCreditId()) {
                            	Utilities.printVariable("ProviderCreditId", member.getProviderCreditId(), tabLevel, outStream);
                                
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
            tabLevel--;
            outStream.println();
            outStream.println(response.getResponseHeaderMetadata());
            outStream.println();

    }

                                
}
