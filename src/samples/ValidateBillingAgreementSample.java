/******************************************************************************* 
 *  Copyright 2008-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 * 
 *  Off Amazon Payments Service Java Library
 *  API Version: 2013-01-01
 * 
 */



package samples;

import java.io.PrintWriter;

import samples.utils.PropertyBundle;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

/**
 *
 * Validate Billing Agreement  Samples
 *
 *
 */
public class ValidateBillingAgreementSample {

  /**
   * Just add few required parameters, and try the service
   * Validate Billing Agreement functionality
   *
   * @param args unused
   */
  public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
        new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /************************************************************************
     * Setup request parameters and try out sample for
     * Validate Billing Agreement 
     ***********************************************************************/
    ValidateBillingAgreementRequest request = new ValidateBillingAgreementRequest();
    request.setSellerId(config.getSellerId());

    PrintWriter outStream = new PrintWriter(System.out, true);

    ValidateBillingAgreementResponse response = invokeValidateBillingAgreement(service, request, outStream);
    printResponse(response, outStream);
  }



  /**
   * Validate Billing Agreement  request sample
   * Activity for validating Payment Plan of Billing Agreement.
   *   
   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
   */
  public static ValidateBillingAgreementResponse invokeValidateBillingAgreement(
      OffAmazonPaymentsService service, ValidateBillingAgreementRequest request, PrintWriter outStream) {
    try {
      ValidateBillingAgreementResponse response =
          service.validateBillingAgreement(request);
      return response;
    } catch (OffAmazonPaymentsServiceException ex) {
      System.out.println("Caught Exception: " + ex.getMessage());
      System.out.println("Response Status Code: " + ex.getStatusCode());
      System.out.println("Error Code: " + ex.getErrorCode());
      System.out.println("Error Type: " + ex.getErrorType());
      System.out.println("Request ID: " + ex.getRequestId());
      System.out.println("XML: " + ex.getXML());
      System.out.print("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
      return null;
    }
  }

  /**
   * Method to print Validate Billing Agreement  response to console

   *@param response instance of ValidateBillingAgreementResponse
   */
  public static void printResponse(ValidateBillingAgreementResponse response, PrintWriter outStream){

    System.out.println ("ValidateBillingAgreement Action Response");
    System.out.println ("=============================================================================");
    System.out.println ();

    System.out.println("    ValidateBillingAgreementResponse");
    System.out.println();
    if (response.isSetValidateBillingAgreementResult()) {
      System.out.println("        ValidateBillingAgreementResult");
      System.out.println();
      ValidateBillingAgreementResult  validateBillingAgreementResult = response.getValidateBillingAgreementResult();
      if (validateBillingAgreementResult.isSetValidationResult()) {
        System.out.println("            ValidationResult");
        System.out.println();
        System.out.println("                " + validateBillingAgreementResult.getValidationResult().value());
        System.out.println();
      }
      if (validateBillingAgreementResult.isSetFailureReasonCode()) {
        System.out.println("            FailureReasonCode");
        System.out.println();
        System.out.println("                " + validateBillingAgreementResult.getFailureReasonCode());
        System.out.println();
      }
      if (validateBillingAgreementResult.isSetBillingAgreementStatus()) {
        System.out.println("            BillingAgreementStatus");
        System.out.println();
        BillingAgreementStatus  billingAgreementStatus = validateBillingAgreementResult.getBillingAgreementStatus();
        if (billingAgreementStatus.isSetState()) {
          System.out.println("                State");
          System.out.println();
          System.out.println("                    " + billingAgreementStatus.getState());
          System.out.println();
        }
        if (billingAgreementStatus.isSetLastUpdatedTimestamp()) {
          System.out.println("                LastUpdatedTimestamp");
          System.out.println();
          System.out.println("                    " + billingAgreementStatus.getLastUpdatedTimestamp());
          System.out.println();
        }
        if (billingAgreementStatus.isSetReasonCode()) {
          System.out.println("                ReasonCode");
          System.out.println();
          System.out.println("                    " + billingAgreementStatus.getReasonCode());
          System.out.println();
        }
        if (billingAgreementStatus.isSetReasonDescription()) {
          System.out.println("                ReasonDescription");
          System.out.println();
          System.out.println("                    " + billingAgreementStatus.getReasonDescription());
          System.out.println();
        }
      } 
    } 
    if (response.isSetResponseMetadata()) {
      System.out.println("        ResponseMetadata");
      System.out.println();
      ResponseMetadata  responseMetadata = response.getResponseMetadata();
      if (responseMetadata.isSetRequestId()) {
        System.out.println("            RequestId");
        System.out.println();
        System.out.println("                " + responseMetadata.getRequestId());
        System.out.println();
      }
    } 
    System.out.println();
    System.out.println(response.getResponseHeaderMetadata());
    System.out.println();
  }

}
