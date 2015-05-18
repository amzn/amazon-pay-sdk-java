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
 * Create Order Reference For Id  Samples
 *
 *
 */
public class CreateOrderReferenceForIdSample {

    /**
     * Just add few required parameters, and try the service
     * Create Order Reference For Id functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        OffAmazonPaymentsServiceConfig config =
                new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
        OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out 
         * sample for Create Order Reference For Id 
         ***********************************************************************/
        CreateOrderReferenceForIdRequest request = new CreateOrderReferenceForIdRequest();
        request.setSellerId(config.getSellerId());

        PrintWriter outStream = new PrintWriter(System.out, true);

        CreateOrderReferenceForIdResponse response = invokeCreateOrderReferenceForId(service, request, outStream);
        printResponse(response, outStream);
    }



    /**
     * Create Order Reference For Id  request sample

     * @param service instance of OffAmazonPaymentsService service
     * @param request Action to invoke
     */
    public static CreateOrderReferenceForIdResponse invokeCreateOrderReferenceForId(
            OffAmazonPaymentsService service, CreateOrderReferenceForIdRequest request, PrintWriter outStream) {
        try {
            CreateOrderReferenceForIdResponse response =
                    service.createOrderReferenceForId(request);
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
     * Method to print Create Order Reference For Id  response to console

     *@param response instance of CreateOrderReferenceForIdResponse
     */
    public static void printResponse(CreateOrderReferenceForIdResponse response, PrintWriter outStream){

        System.out.println ("CreateOrderReferenceForId Action Response");
        System.out.println ("=============================================================================");
        System.out.println ();

        System.out.println("    CreateOrderReferenceForIdResponse");
        System.out.println();
        if (response.isSetCreateOrderReferenceForIdResult()) {
            System.out.println("        CreateOrderReferenceForIdResult");
            System.out.println();
            CreateOrderReferenceForIdResult  createOrderReferenceForIdResult = response.getCreateOrderReferenceForIdResult();
            if (createOrderReferenceForIdResult.isSetOrderReferenceDetails()) {
                System.out.println("            OrderReferenceDetails");
                System.out.println();
                OrderReferenceDetails  orderReferenceDetails = createOrderReferenceForIdResult.getOrderReferenceDetails();
                if (orderReferenceDetails.isSetAmazonOrderReferenceId()) {
                    System.out.println("                AmazonOrderReferenceId");
                    System.out.println();
                    System.out.println("                    " + orderReferenceDetails.getAmazonOrderReferenceId());
                    System.out.println();
                }
                if (orderReferenceDetails.isSetBuyer()) {
                    System.out.println("                Buyer");
                    System.out.println();
                    Buyer  buyer = orderReferenceDetails.getBuyer();
                    if (buyer.isSetName()) {
                        System.out.println("                    Name");
                        System.out.println();
                        System.out.println("                        " + buyer.getName());
                        System.out.println();
                    }
                    if (buyer.isSetEmail()) {
                        System.out.println("                    Email");
                        System.out.println();
                        System.out.println("                        " + buyer.getEmail());
                        System.out.println();
                    }
                    if (buyer.isSetPhone()) {
                        System.out.println("                    Phone");
                        System.out.println();
                        System.out.println("                        " + buyer.getPhone());
                        System.out.println();
                    }
                } 
                if (orderReferenceDetails.isSetOrderTotal()) {
                    System.out.println("                OrderTotal");
                    System.out.println();
                    OrderTotal  orderTotal = orderReferenceDetails.getOrderTotal();
                    if (orderTotal.isSetCurrencyCode()) {
                        System.out.println("                    CurrencyCode");
                        System.out.println();
                        System.out.println("                        " + orderTotal.getCurrencyCode());
                        System.out.println();
                    }
                    if (orderTotal.isSetAmount()) {
                        System.out.println("                    Amount");
                        System.out.println();
                        System.out.println("                        " + orderTotal.getAmount());
                        System.out.println();
                    }
                } 
                if (orderReferenceDetails.isSetSellerNote()) {
                    System.out.println("                SellerNote");
                    System.out.println();
                    System.out.println("                    " + orderReferenceDetails.getSellerNote());
                    System.out.println();
                }
                if (orderReferenceDetails.isSetPlatformId()) {
                    System.out.println("                PlatformId");
                    System.out.println();
                    System.out.println("                    " + orderReferenceDetails.getPlatformId());
                    System.out.println();
                }
                if (orderReferenceDetails.isSetDestination()) {
                    System.out.println("                Destination");
                    System.out.println();
                    Destination  destination = orderReferenceDetails.getDestination();
                    if (destination.isSetDestinationType()) {
                        System.out.println("                    DestinationType");
                        System.out.println();
                        System.out.println("                        " + destination.getDestinationType());
                        System.out.println();
                    }
                    if (destination.isSetPhysicalDestination()) {
                        System.out.println("                    PhysicalDestination");
                        System.out.println();
                        Address  physicalDestination = destination.getPhysicalDestination();
                        if (physicalDestination.isSetName()) {
                            System.out.println("                        Name");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getName());
                            System.out.println();
                        }
                        if (physicalDestination.isSetAddressLine1()) {
                            System.out.println("                        AddressLine1");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getAddressLine1());
                            System.out.println();
                        }
                        if (physicalDestination.isSetAddressLine2()) {
                            System.out.println("                        AddressLine2");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getAddressLine2());
                            System.out.println();
                        }
                        if (physicalDestination.isSetAddressLine3()) {
                            System.out.println("                        AddressLine3");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getAddressLine3());
                            System.out.println();
                        }
                        if (physicalDestination.isSetCity()) {
                            System.out.println("                        City");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getCity());
                            System.out.println();
                        }
                        if (physicalDestination.isSetCounty()) {
                            System.out.println("                        County");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getCounty());
                            System.out.println();
                        }
                        if (physicalDestination.isSetDistrict()) {
                            System.out.println("                        District");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getDistrict());
                            System.out.println();
                        }
                        if (physicalDestination.isSetStateOrRegion()) {
                            System.out.println("                        StateOrRegion");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getStateOrRegion());
                            System.out.println();
                        }
                        if (physicalDestination.isSetPostalCode()) {
                            System.out.println("                        PostalCode");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getPostalCode());
                            System.out.println();
                        }
                        if (physicalDestination.isSetCountryCode()) {
                            System.out.println("                        CountryCode");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getCountryCode());
                            System.out.println();
                        }
                        if (physicalDestination.isSetPhone()) {
                            System.out.println("                        Phone");
                            System.out.println();
                            System.out.println("                            " + physicalDestination.getPhone());
                            System.out.println();
                        }
                    } 
                } 
                if (orderReferenceDetails.isSetBillingAddress()) {
                    System.out.println("                BillingAddress");
                    System.out.println();
                    BillingAddress  billingAddress = orderReferenceDetails.getBillingAddress();
                    if (billingAddress.isSetAddressType()) {
                        System.out.println("                    AddressType");
                        System.out.println();
                        System.out.println("                        " + billingAddress.getAddressType());
                        System.out.println();
                    }
                    if (billingAddress.isSetPhysicalAddress()) {
                        System.out.println("                    PhysicalAddress");
                        System.out.println();
                        Address  physicalAddress = billingAddress.getPhysicalAddress();
                        if (physicalAddress.isSetName()) {
                            System.out.println("                        Name");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getName());
                            System.out.println();
                        }
                        if (physicalAddress.isSetAddressLine1()) {
                            System.out.println("                        AddressLine1");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getAddressLine1());
                            System.out.println();
                        }
                        if (physicalAddress.isSetAddressLine2()) {
                            System.out.println("                        AddressLine2");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getAddressLine2());
                            System.out.println();
                        }
                        if (physicalAddress.isSetAddressLine3()) {
                            System.out.println("                        AddressLine3");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getAddressLine3());
                            System.out.println();
                        }
                        if (physicalAddress.isSetCity()) {
                            System.out.println("                        City");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getCity());
                            System.out.println();
                        }
                        if (physicalAddress.isSetCounty()) {
                            System.out.println("                        County");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getCounty());
                            System.out.println();
                        }
                        if (physicalAddress.isSetDistrict()) {
                            System.out.println("                        District");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getDistrict());
                            System.out.println();
                        }
                        if (physicalAddress.isSetStateOrRegion()) {
                            System.out.println("                        StateOrRegion");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getStateOrRegion());
                            System.out.println();
                        }
                        if (physicalAddress.isSetPostalCode()) {
                            System.out.println("                        PostalCode");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getPostalCode());
                            System.out.println();
                        }
                        if (physicalAddress.isSetCountryCode()) {
                            System.out.println("                        CountryCode");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getCountryCode());
                            System.out.println();
                        }
                        if (physicalAddress.isSetPhone()) {
                            System.out.println("                        Phone");
                            System.out.println();
                            System.out.println("                            " + physicalAddress.getPhone());
                            System.out.println();
                        }
                    }
                }
                if (orderReferenceDetails.isSetReleaseEnvironment()) {
                    System.out.println("                ReleaseEnvironment");
                    System.out.println();
                    System.out.println("                    " + orderReferenceDetails.getReleaseEnvironment().value());
                    System.out.println();
                }
                if (orderReferenceDetails.isSetSellerOrderAttributes()) {
                    System.out.println("                SellerOrderAttributes");
                    System.out.println();
                    SellerOrderAttributes  sellerOrderAttributes = orderReferenceDetails.getSellerOrderAttributes();
                    if (sellerOrderAttributes.isSetSellerOrderId()) {
                        System.out.println("                    SellerOrderId");
                        System.out.println();
                        System.out.println("                        " + sellerOrderAttributes.getSellerOrderId());
                        System.out.println();
                    }
                    if (sellerOrderAttributes.isSetStoreName()) {
                        System.out.println("                    StoreName");
                        System.out.println();
                        System.out.println("                        " + sellerOrderAttributes.getStoreName());
                        System.out.println();
                    }
                    if (sellerOrderAttributes.isSetOrderItemCategories()) {
                        System.out.println("                    OrderItemCategories");
                        System.out.println();
                        OrderItemCategories  orderItemCategories = sellerOrderAttributes.getOrderItemCategories();
                        java.util.List<String> orderItemCategoryList  =  orderItemCategories.getOrderItemCategory();
                        for (String orderItemCategory : orderItemCategoryList) { 
                            System.out.println("                        OrderItemCategory");
                            System.out.println();
                            System.out.println("                            " + orderItemCategory);
                        }	
                    } 
                    if (sellerOrderAttributes.isSetCustomInformation()) {
                        System.out.println("                    CustomInformation");
                        System.out.println();
                        System.out.println("                        " + sellerOrderAttributes.getCustomInformation());
                        System.out.println();
                    }
                } 
                if (orderReferenceDetails.isSetOrderReferenceStatus()) {
                    System.out.println("                OrderReferenceStatus");
                    System.out.println();
                    OrderReferenceStatus  orderReferenceStatus = orderReferenceDetails.getOrderReferenceStatus();
                    if (orderReferenceStatus.isSetState()) {
                        System.out.println("                    State");
                        System.out.println();
                        System.out.println("                        " + orderReferenceStatus.getState());
                        System.out.println();
                    }
                    if (orderReferenceStatus.isSetLastUpdateTimestamp()) {
                        System.out.println("                    LastUpdateTimestamp");
                        System.out.println();
                        System.out.println("                        " + orderReferenceStatus.getLastUpdateTimestamp());
                        System.out.println();
                    }
                    if (orderReferenceStatus.isSetReasonCode()) {
                        System.out.println("                    ReasonCode");
                        System.out.println();
                        System.out.println("                        " + orderReferenceStatus.getReasonCode());
                        System.out.println();
                    }
                    if (orderReferenceStatus.isSetReasonDescription()) {
                        System.out.println("                    ReasonDescription");
                        System.out.println();
                        System.out.println("                        " + orderReferenceStatus.getReasonDescription());
                        System.out.println();
                    }
                } 
                if (orderReferenceDetails.isSetConstraints()) {
                    System.out.println("                Constraints");
                    System.out.println();
                    Constraints  constraints = orderReferenceDetails.getConstraints();
                    java.util.List<Constraint> constraintList = constraints.getConstraint();
                    for (Constraint constraint : constraintList) {
                        System.out.println("                    Constraint");
                        System.out.println();
                        if (constraint.isSetConstraintID()) {
                            System.out.println("                        ConstraintID");
                            System.out.println();
                            System.out.println("                            " + constraint.getConstraintID());
                            System.out.println();
                        }
                        if (constraint.isSetDescription()) {
                            System.out.println("                        Description");
                            System.out.println();
                            System.out.println("                            " + constraint.getDescription());
                            System.out.println();
                        }
                    }
                } 
                if (orderReferenceDetails.isSetCreationTimestamp()) {
                    System.out.println("                CreationTimestamp");
                    System.out.println();
                    System.out.println("                    " + orderReferenceDetails.getCreationTimestamp());
                    System.out.println();
                }
                if (orderReferenceDetails.isSetExpirationTimestamp()) {
                    System.out.println("                ExpirationTimestamp");
                    System.out.println();
                    System.out.println("                    " + orderReferenceDetails.getExpirationTimestamp());
                    System.out.println();
                }
                if (orderReferenceDetails.isSetParentDetails()) {
                    System.out.println("                ParentDetails");
                    System.out.println();
                    ParentDetails  parentDetails = orderReferenceDetails.getParentDetails();
                    if (parentDetails.isSetId()) {
                        System.out.println("                    Id");
                        System.out.println();
                        System.out.println("                        " + parentDetails.getId());
                        System.out.println();
                    }
                    if (parentDetails.isSetType()) {
                        System.out.println("                    Type");
                        System.out.println();
                        System.out.println("                        " + parentDetails.getType().value());
                        System.out.println();
                    }
                }
                if (orderReferenceDetails.isSetIdList()) {
                    System.out.println("                IdList");
                    System.out.println();
                    IdList  idList = orderReferenceDetails.getIdList();
                    java.util.List<String> memberList  =  idList.getMember();
                    for (String member : memberList) { 
                    	System.out.println("                    " + member);
                    }
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
