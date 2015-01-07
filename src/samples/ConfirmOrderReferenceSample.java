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
 * Confirm Order Reference  Samples
 *
 *
 */
public class ConfirmOrderReferenceSample {

  /**
   * Just add few required parameters, and try the service
   * Confirm Order Reference functionality
   *
   * @param args unused
   */
   public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
      new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /**********************************************************************
     * Setup request parameters and try out sample for
     * Confirm Order Reference 
    ***********************************************************************/
    ConfirmOrderReferenceRequest request = new ConfirmOrderReferenceRequest();
    request.setSellerId(config.getSellerId());
    
    PrintWriter outStream = new PrintWriter(System.out, true);

   ConfirmOrderReferenceResponse response = invokeConfirmOrderReference(service, request, outStream);
   printResponse(response, outStream);
  }


                                    
  /**
   * Confirm Order Reference  request sample

   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
  */
  public static ConfirmOrderReferenceResponse invokeConfirmOrderReference(
    OffAmazonPaymentsService service, ConfirmOrderReferenceRequest request, PrintWriter outStream) {
    try {
      ConfirmOrderReferenceResponse response =
        service.confirmOrderReference(request);
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
    * Method to print Confirm Order Reference  response to console

  *@param response instance of ConfirmOrderReferenceResponse
    */
    public static void printResponse(ConfirmOrderReferenceResponse response, PrintWriter outStream){

            int tabLevel = 1;
            outStream.println ("ConfirmOrderReference Action Response");
            outStream.println ("=============================================================================");
            outStream.println ();

            Utilities.printVariable("ConfirmOrderReferenceResponse", null, tabLevel, outStream);
            tabLevel++;
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
