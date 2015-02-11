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

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

import samples.utils.PropertyBundle;

/**
 *
 * Confirm Billing Agreement  Samples
 *
 *
 */
public class ConfirmBillingAgreementSample {

  /**
   * Just add few required parameters, and try the service
   * Confirm Billing Agreement functionality
   *
   * @param args unused
   */
  public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
        new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /************************************************************************
     * Setup request parameters and try out sample for
     * Confirm Billing Agreement 
     ***********************************************************************/
    ConfirmBillingAgreementRequest request = new ConfirmBillingAgreementRequest();
    request.setSellerId(config.getSellerId());

    PrintWriter outStream = new PrintWriter(System.out, true);

    ConfirmBillingAgreementResponse response = invokeConfirmBillingAgreement(service, request, outStream);
    printResponse(response, outStream);
  }



  /**
   * Confirm Billing Agreement  request sample

   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
   */
  public static ConfirmBillingAgreementResponse invokeConfirmBillingAgreement(
      OffAmazonPaymentsService service, ConfirmBillingAgreementRequest request, PrintWriter outStream) {
    try {
      ConfirmBillingAgreementResponse response =
          service.confirmBillingAgreement(request);
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
   * Method to print Confirm Billing Agreement  response to console

   *@param response instance of ConfirmBillingAgreementResponse
   */
  public static void printResponse(ConfirmBillingAgreementResponse response, PrintWriter outStream){

    System.out.println ("ConfirmBillingAgreement Action Response");
    System.out.println ("=============================================================================");
    System.out.println ();

    System.out.println("    ConfirmBillingAgreementResponse");
    System.out.println();
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
