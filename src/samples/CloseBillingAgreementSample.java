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
 * Close Billing Agreement  Samples
 *
 *
 */
public class CloseBillingAgreementSample {

  /**
   * Just add few required parameters, and try the service
   * Close Billing Agreement functionality
   *
   * @param args unused
   */
  public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
        new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /************************************************************************
     * Setup request parameters and try out sample for
     * Close Billing Agreement 
     ***********************************************************************/
    CloseBillingAgreementRequest request = new CloseBillingAgreementRequest();
    request.setSellerId(config.getSellerId());

    PrintWriter outStream = new PrintWriter(System.out, true);

    CloseBillingAgreementResponse response = invokeCloseBillingAgreement(service, request, outStream);
    printResponse(response, outStream);
  }



  /**
   * Close Billing Agreement  request sample
   * Activity to close Billing Agreement.
   *   
   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
   */
  public static CloseBillingAgreementResponse invokeCloseBillingAgreement(
      OffAmazonPaymentsService service, CloseBillingAgreementRequest request, PrintWriter outStream) {
    try {
      CloseBillingAgreementResponse response =
          service.closeBillingAgreement(request);
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
   * Method to print Close Billing Agreement  response to console

   *@param response instance of CloseBillingAgreementResponse
   */
  public static void printResponse(CloseBillingAgreementResponse response, PrintWriter outStream) {

    System.out.println ("CloseBillingAgreement Action Response");
    System.out.println ("=============================================================================");
    System.out.println ();

    System.out.println("    CloseBillingAgreementResponse");
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
