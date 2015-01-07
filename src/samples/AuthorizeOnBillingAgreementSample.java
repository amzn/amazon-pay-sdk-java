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
 * Authorize On Billing Agreement  Samples
 *
 *
 */
public class AuthorizeOnBillingAgreementSample {

  /**
   * Just add few required parameters, and try the service
   * Authorize On Billing Agreement functionality
   *
   * @param args unused
   */
  public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
        new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /************************************************************************
     * Setup request parameters and try out sample for
     * Authorize On Billing Agreement 
     ***********************************************************************/
    AuthorizeOnBillingAgreementRequest request = new AuthorizeOnBillingAgreementRequest();
    request.setSellerId(config.getSellerId());

    PrintWriter outStream = new PrintWriter(System.out, true);

    AuthorizeOnBillingAgreementResponse response = invokeAuthorizeOnBillingAgreement(service, request, outStream);
    printResponse(response, outStream);
  }



  /**
   * Authorize On Billing Agreement  request sample

   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
   */
  public static AuthorizeOnBillingAgreementResponse invokeAuthorizeOnBillingAgreement(
      OffAmazonPaymentsService service, AuthorizeOnBillingAgreementRequest request, PrintWriter outStream) {
    try {
      AuthorizeOnBillingAgreementResponse response =
          service.authorizeOnBillingAgreement(request);
      return response;
    } catch (OffAmazonPaymentsServiceException ex) {
      outStream.println("Caught Exception: " + ex.getMessage());
      outStream.println("Response Status Code: " + ex.getStatusCode());
      outStream.println("Error Code: " + ex.getErrorCode());
      outStream.println("Error Type: " + ex.getErrorType());
      outStream.println("Request ID: " + ex.getRequestId());
      outStream.println("XML: " + ex.getXML());
      outStream.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
      return null;
    }
  }

  /**
   * Method to print Authorize On Billing Agreement  response to console

   *@param response instance of AuthorizeOnBillingAgreementResponse
   */
  public static void printResponse(AuthorizeOnBillingAgreementResponse response, PrintWriter outStream) {

    System.out.println ("AuthorizeOnBillingAgreement Action Response");
    System.out.println ("=============================================================================");
    System.out.println ();

    System.out.println("    AuthorizeOnBillingAgreementResponse");
    System.out.println();
    if (response.isSetAuthorizeOnBillingAgreementResult()) {
      System.out.println("        AuthorizeOnBillingAgreementResult");
      System.out.println();
      AuthorizeOnBillingAgreementResult  authorizeOnBillingAgreementResult = response.getAuthorizeOnBillingAgreementResult();
      if (authorizeOnBillingAgreementResult.isSetAuthorizationDetails()) {
        System.out.println("            AuthorizationDetails");
        System.out.println();
        AuthorizationDetails  authorizationDetails = authorizeOnBillingAgreementResult.getAuthorizationDetails();
        if (authorizationDetails.isSetAmazonAuthorizationId()) {
          System.out.println("                AmazonAuthorizationId");
          System.out.println();
          System.out.println("                    " + authorizationDetails.getAmazonAuthorizationId());
          System.out.println();
        }
        if (authorizationDetails.isSetAuthorizationReferenceId()) {
          System.out.println("                AuthorizationReferenceId");
          System.out.println();
          System.out.println("                    " + authorizationDetails.getAuthorizationReferenceId());
          System.out.println();
        }
        if (authorizationDetails.isSetAuthorizationBillingAddress()) {
          System.out.println("                AuthorizationBillingAddress");
          System.out.println();
          Address  authorizationBillingAddress = authorizationDetails.getAuthorizationBillingAddress();
          if (authorizationBillingAddress.isSetName()) {
            System.out.println("                    Name");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getName());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetAddressLine1()) {
            System.out.println("                    AddressLine1");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getAddressLine1());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetAddressLine2()) {
            System.out.println("                    AddressLine2");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getAddressLine2());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetAddressLine3()) {
            System.out.println("                    AddressLine3");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getAddressLine3());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetCity()) {
            System.out.println("                    City");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getCity());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetCounty()) {
            System.out.println("                    County");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getCounty());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetDistrict()) {
            System.out.println("                    District");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getDistrict());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetStateOrRegion()) {
            System.out.println("                    StateOrRegion");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getStateOrRegion());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetPostalCode()) {
            System.out.println("                    PostalCode");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getPostalCode());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetCountryCode()) {
            System.out.println("                    CountryCode");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getCountryCode());
            System.out.println();
          }
          if (authorizationBillingAddress.isSetPhone()) {
            System.out.println("                    Phone");
            System.out.println();
            System.out.println("                        " + authorizationBillingAddress.getPhone());
            System.out.println();
          }
        } 
        if (authorizationDetails.isSetSellerAuthorizationNote()) {
          System.out.println("                SellerAuthorizationNote");
          System.out.println();
          System.out.println("                    " + authorizationDetails.getSellerAuthorizationNote());
          System.out.println();
        }
        if (authorizationDetails.isSetAuthorizationAmount()) {
          System.out.println("                AuthorizationAmount");
          System.out.println();
          Price  authorizationAmount = authorizationDetails.getAuthorizationAmount();
          if (authorizationAmount.isSetAmount()) {
            System.out.println("                    Amount");
            System.out.println();
            System.out.println("                        " + authorizationAmount.getAmount());
            System.out.println();
          }
          if (authorizationAmount.isSetCurrencyCode()) {
            System.out.println("                    CurrencyCode");
            System.out.println();
            System.out.println("                        " + authorizationAmount.getCurrencyCode());
            System.out.println();
          }
        } 
        if (authorizationDetails.isSetCapturedAmount()) {
          System.out.println("                CapturedAmount");
          System.out.println();
          Price  capturedAmount = authorizationDetails.getCapturedAmount();
          if (capturedAmount.isSetAmount()) {
            System.out.println("                    Amount");
            System.out.println();
            System.out.println("                        " + capturedAmount.getAmount());
            System.out.println();
          }
          if (capturedAmount.isSetCurrencyCode()) {
            System.out.println("                    CurrencyCode");
            System.out.println();
            System.out.println("                        " + capturedAmount.getCurrencyCode());
            System.out.println();
          }
        } 
        if (authorizationDetails.isSetAuthorizationFee()) {
          System.out.println("                AuthorizationFee");
          System.out.println();
          Price  authorizationFee = authorizationDetails.getAuthorizationFee();
          if (authorizationFee.isSetAmount()) {
            System.out.println("                    Amount");
            System.out.println();
            System.out.println("                        " + authorizationFee.getAmount());
            System.out.println();
          }
          if (authorizationFee.isSetCurrencyCode()) {
            System.out.println("                    CurrencyCode");
            System.out.println();
            System.out.println("                        " + authorizationFee.getCurrencyCode());
            System.out.println();
          }
        } 
        if (authorizationDetails.isSetIdList()) {
          System.out.println("                IdList");
          System.out.println();
          IdList  idList = authorizationDetails.getIdList();
          java.util.List<String> memberList  =  idList.getMember();
          for (String member : memberList) { 
            System.out.println("                    member");
            System.out.println();
            System.out.println("                        " + member);
          }   
        } 
        if (authorizationDetails.isSetCreationTimestamp()) {
          System.out.println("                CreationTimestamp");
          System.out.println();
          System.out.println("                    " + authorizationDetails.getCreationTimestamp());
          System.out.println();
        }
        if (authorizationDetails.isSetExpirationTimestamp()) {
          System.out.println("                ExpirationTimestamp");
          System.out.println();
          System.out.println("                    " + authorizationDetails.getExpirationTimestamp());
          System.out.println();
        }
        if (authorizationDetails.isSetAuthorizationStatus()) {
          System.out.println("                AuthorizationStatus");
          System.out.println();
          Status  authorizationStatus = authorizationDetails.getAuthorizationStatus();
          if (authorizationStatus.isSetState()) {
            System.out.println("                    State");
            System.out.println();
            System.out.println("                        " + authorizationStatus.getState());
            System.out.println();
          }
          if (authorizationStatus.isSetLastUpdateTimestamp()) {
            System.out.println("                    LastUpdateTimestamp");
            System.out.println();
            System.out.println("                        " + authorizationStatus.getLastUpdateTimestamp());
            System.out.println();
          }
          if (authorizationStatus.isSetReasonCode()) {
            System.out.println("                    ReasonCode");
            System.out.println();
            System.out.println("                        " + authorizationStatus.getReasonCode());
            System.out.println();
          }
          if (authorizationStatus.isSetReasonDescription()) {
            System.out.println("                    ReasonDescription");
            System.out.println();
            System.out.println("                        " + authorizationStatus.getReasonDescription());
            System.out.println();
          }
        } 
        if (authorizationDetails.isSetOrderItemCategories()) {
          System.out.println("                OrderItemCategories");
          System.out.println();
          OrderItemCategories  orderItemCategories = authorizationDetails.getOrderItemCategories();
          java.util.List<String> orderItemCategoryList  =  orderItemCategories.getOrderItemCategory();
          for (String orderItemCategory : orderItemCategoryList) { 
            System.out.println("                    OrderItemCategory");
            System.out.println();
            System.out.println("                        " + orderItemCategory);
          }   
        } 
        if (authorizationDetails.isSetCaptureNow()) {
          System.out.println("                CaptureNow");
          System.out.println();
          System.out.println("                    " + authorizationDetails.isCaptureNow());
          System.out.println();
        }
        if (authorizationDetails.isSetSoftDescriptor()) {
          System.out.println("                SoftDescriptor");
          System.out.println();
          System.out.println("                    " + authorizationDetails.getSoftDescriptor());
          System.out.println();
        }
        if (authorizationDetails.isSetAddressVerificationCode()) {
            System.out.println("                AddressVerificationCode");
            System.out.println();
            System.out.println("                    " + authorizationDetails.getAddressVerificationCode());
            System.out.println();
          }
      } 
      if (authorizeOnBillingAgreementResult.isSetAmazonOrderReferenceId()) {
        System.out.println("            AmazonOrderReferenceId");
        System.out.println();
        System.out.println("                " + authorizeOnBillingAgreementResult.getAmazonOrderReferenceId());
        System.out.println();
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
