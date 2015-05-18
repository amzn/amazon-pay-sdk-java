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
 * Authorize  Samples
 *
 *
 */
public class AuthorizeSample {

    /**
     * Just add few required parameters, and try the service
     * Authorize functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        OffAmazonPaymentsServiceConfig config =
                new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
        OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

        /**********************************************************************
         * Setup request parameters and try out sample for
         * Authorize 
         ***********************************************************************/
        AuthorizeRequest request = new AuthorizeRequest();
        request.setSellerId(config.getSellerId());
        /**********************************************************************
         * To use Fast Authorization, set the optional parameter Transaction Timeout
         * in the request to 0. Uncomment the line of code below.
         ***********************************************************************/
        // request.setTransactionTimeout(0);
        PrintWriter outStream = new PrintWriter(System.out, true);

        AuthorizeResponse response = invokeAuthorize(service, request, outStream);
        printResponse(response, outStream);
    }



    /**
     * Authorize  request sample
     *
     * @param service instance of OffAmazonPaymentsService service
     * @param request Action to invoke
     */
    public static AuthorizeResponse invokeAuthorize(
            OffAmazonPaymentsService service, AuthorizeRequest request, PrintWriter outStream) {
        try {
            AuthorizeResponse response =
                    service.authorize(request);
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
     * Method to print Authorize  response to console
     *
     *@param response instance of AuthorizeResponse
     */
    public static void printResponse(AuthorizeResponse response, PrintWriter outStream){


        int tabLevel = 1;
        outStream.println ("Authorize Action Response");
        outStream.println ("=============================================================================");
        outStream.println ();

        Utilities.printVariable("AuthorizeResponse", null, tabLevel, outStream);
        if (response.isSetAuthorizeResult()) {
            tabLevel++;
            Utilities.printVariable("AuthorizeResult", null, tabLevel, outStream);
            AuthorizeResult  authorizeResult = response.getAuthorizeResult();
            if (authorizeResult.isSetAuthorizationDetails()) {
                tabLevel++;
                AuthorizationDetails  authorizationDetails = authorizeResult.getAuthorizationDetails();
                Utilities.printVariable("AuthorizationDetails", null, tabLevel, outStream);
                if (authorizationDetails.isSetAmazonAuthorizationId()) {
                    Utilities.printVariable("AmazonAuthorizationId", authorizationDetails.getAmazonAuthorizationId(), tabLevel, outStream);
                }
                if (authorizationDetails.isSetAuthorizationReferenceId()) {
                    Utilities.printVariable("AuthorizationReferenceId", authorizationDetails.getAuthorizationReferenceId(), tabLevel, outStream);
                }
                if (authorizationDetails.isSetAuthorizationBillingAddress()) {
                	Utilities.printVariable("AuthorizationBillingAddress", null, tabLevel, outStream);
                	Address authorizationBillingAddress = authorizationDetails.getAuthorizationBillingAddress();
                	tabLevel++;
                    if (authorizationBillingAddress.isSetName()) {
                        Utilities.printVariable("Name", authorizationBillingAddress.getName(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetAddressLine1()) {
                        Utilities.printVariable("AddressLine1", authorizationBillingAddress.getAddressLine1(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetAddressLine2()) {
                        Utilities.printVariable("AddressLine2", authorizationBillingAddress.getAddressLine2(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetAddressLine3()) {
                        Utilities.printVariable("AddressLine3", authorizationBillingAddress.getAddressLine3(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetCity()) {
                        Utilities.printVariable("City", authorizationBillingAddress.getCity(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetCounty()) {
                        Utilities.printVariable("County", authorizationBillingAddress.getCounty(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetDistrict()) {
                        Utilities.printVariable("District", authorizationBillingAddress.getDistrict(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetStateOrRegion()) {
                        Utilities.printVariable("StateOrRegion", authorizationBillingAddress.getStateOrRegion(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetPostalCode()) {
                        Utilities.printVariable("PostalCode", authorizationBillingAddress.getPostalCode(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetCountryCode()) {
                        Utilities.printVariable("CountryCode", authorizationBillingAddress.getCountryCode(), tabLevel, outStream);
                    }
                    if (authorizationBillingAddress.isSetPhone()) {
                        Utilities.printVariable("Phone", authorizationBillingAddress.getPhone(), tabLevel, outStream);
                    }
                    tabLevel--;
                }
                if (authorizationDetails.isSetSellerAuthorizationNote()) {
                    Utilities.printVariable("SellerAuthorizationNote", authorizationDetails.getSellerAuthorizationNote(), tabLevel, outStream);
                }
                tabLevel++;
                if (authorizationDetails.isSetAuthorizationAmount()) {
                    Utilities.printVariable("AuthorizationAmount", null, tabLevel, outStream);
                    Price  authorizationAmount = authorizationDetails.getAuthorizationAmount();
                    if (authorizationAmount.isSetAmount()) {
                        Utilities.printVariable("Amount", authorizationAmount.getAmount(), tabLevel, outStream);
                    }
                    if (authorizationAmount.isSetCurrencyCode()) {
                        Utilities.printVariable("CurrencyCode", authorizationAmount.getCurrencyCode(), tabLevel, outStream);
                    }
                } 
                if (authorizationDetails.isSetCapturedAmount()) {
                    Utilities.printVariable("CapturedAmount", null, tabLevel, outStream);
                    Price  capturedAmount = authorizationDetails.getCapturedAmount();
                    if (capturedAmount.isSetAmount()) {
                        Utilities.printVariable("Amount", capturedAmount.getAmount(), tabLevel, outStream);
                    }
                    if (capturedAmount.isSetCurrencyCode()) {
                        Utilities.printVariable("CurrencyCode", capturedAmount.getCurrencyCode(), tabLevel, outStream);
                    }
                } 
                if (authorizationDetails.isSetAuthorizationFee()) {
                    Utilities.printVariable("AuthorizationFee", null, tabLevel, outStream);
                    Price  authorizationFee = authorizationDetails.getAuthorizationFee();
                    if (authorizationFee.isSetAmount()) {
                        Utilities.printVariable("Amount", authorizationFee.getAmount(), tabLevel, outStream);
                    }
                    if (authorizationFee.isSetCurrencyCode()) {
                        Utilities.printVariable("CurrencyCode", authorizationFee.getCurrencyCode(), tabLevel, outStream);
                    }
                } 
                if (authorizationDetails.isSetIdList()) {
                    Utilities.printVariable("IdList", null, tabLevel, outStream);
                    IdList  idList = authorizationDetails.getIdList();
                    java.util.List<String> memberList  =  idList.getMember();
                    for (String member : memberList) { 
                        Utilities.printVariable("member", member, tabLevel, outStream);
                    }   
                } 
                tabLevel--;
                if (authorizationDetails.isSetCreationTimestamp()) {
                    Utilities.printVariable("CreationTimestamp", authorizationDetails.getCreationTimestamp().toString(), tabLevel, outStream);
                }
                if (authorizationDetails.isSetExpirationTimestamp()) {
                    Utilities.printVariable("ExpirationTimestamp", authorizationDetails.getExpirationTimestamp().toString(), tabLevel, outStream);
                }
                if (authorizationDetails.isSetAuthorizationStatus()) {
                    Utilities.printVariable("AuthorizationStatus", null, tabLevel, outStream);
                    Status  authorizationStatus = authorizationDetails.getAuthorizationStatus();
                    tabLevel++;
                    if (authorizationStatus.isSetState()) {
                        Utilities.printVariable("State", authorizationStatus.getState(), tabLevel, outStream);
                    }
                    if (authorizationStatus.isSetLastUpdateTimestamp()) {
                        Utilities.printVariable("LastUpdateTimestamp", authorizationStatus.getLastUpdateTimestamp().toString(), tabLevel, outStream);
                    }
                    if (authorizationStatus.isSetReasonCode()) {
                        Utilities.printVariable("ReasonCode", authorizationStatus.getReasonCode(), tabLevel, outStream);
                    }
                    if (authorizationStatus.isSetReasonDescription()) {
                        Utilities.printVariable("ReasonDescription", authorizationStatus.getReasonDescription(), tabLevel, outStream);
                    }
                    tabLevel--;
                } 
                if (authorizationDetails.isSetOrderItemCategories()) {
                    Utilities.printVariable("OrderItemCategories", null, tabLevel, outStream);
                    OrderItemCategories  orderItemCategories = authorizationDetails.getOrderItemCategories();
                    java.util.List<String> orderItemCategoryList  =  orderItemCategories.getOrderItemCategory();
                    tabLevel++;
                    for (String orderItemCategory : orderItemCategoryList) { 
                        Utilities.printVariable("OrderItemCategory", orderItemCategory, tabLevel, outStream);
                    }   
                    tabLevel--;
                } 
                if (authorizationDetails.isSetCaptureNow()) {
                    Utilities.printVariable("CaptureNow", authorizationDetails.isCaptureNow() + "", tabLevel, outStream);
                }
                if (authorizationDetails.isSetSoftDescriptor()) {
                    Utilities.printVariable("SoftDescriptor", authorizationDetails.getSoftDescriptor(), tabLevel, outStream);
                }
                if (authorizationDetails.isSetAddressVerificationCode()) {
                    Utilities.printVariable("AddressVerificationCode", authorizationDetails.getAddressVerificationCode(), tabLevel, outStream);
                }
                tabLevel--;
            } 
        }
        if (response.isSetResponseMetadata()) {
            Utilities.printVariable("ResponseMetadata", null, tabLevel, outStream);
            ResponseMetadata  responseMetadata = response.getResponseMetadata();
            tabLevel++;
            if (responseMetadata.isSetRequestId()) {
                Utilities.printVariable("RequestId", responseMetadata.getRequestId(), tabLevel, outStream);
            }
        } 
        
        outStream.println();
        outStream.println(response.getResponseHeaderMetadata());
        outStream.println();
    }


}
