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
 * Set Order Reference Details  Samples
 *
 *
 */
public class SetOrderReferenceDetailsSample {

  /**
   * Just add few required parameters, and try the service
   * Set Order Reference Details functionality
   *
   * @param args unused
   */
   public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
      new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /**********************************************************************
     * Setup request parameters and try out sample for
     * Set Order Reference Details 
    ***********************************************************************/
    SetOrderReferenceDetailsRequest request = new SetOrderReferenceDetailsRequest();
    request.setSellerId(config.getSellerId());
    
    PrintWriter outStream = new PrintWriter(System.out, true);

   SetOrderReferenceDetailsResponse response = invokeSetOrderReferenceDetails(service, request, outStream);
   printResponse(response, outStream);
  }


                                                
  /**
   * Set Order Reference Details  request sample

   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
 * @param outStream 
  */
  public static SetOrderReferenceDetailsResponse invokeSetOrderReferenceDetails(
    OffAmazonPaymentsService service, SetOrderReferenceDetailsRequest request, PrintWriter outStream) {
    try {
      SetOrderReferenceDetailsResponse response =
        service.setOrderReferenceDetails(request);
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
    * Method to print Set Order Reference Details  response to console

  *@param response instance of SetOrderReferenceDetailsResponse
    */
    public static void printResponse(SetOrderReferenceDetailsResponse response, PrintWriter outStream){

            int tabLevel = 1;
            outStream.println ("SetOrderReferenceDetails Action Response");
            outStream.println ("=============================================================================");
            outStream.println ();

            Utilities.printVariable("SetOrderReferenceDetailsResponse", null, tabLevel, outStream);
            tabLevel++;
            if (response.isSetSetOrderReferenceDetailsResult()) {
                Utilities.printVariable("SetOrderReferenceDetailsResult", null, tabLevel, outStream);
                SetOrderReferenceDetailsResult  setOrderReferenceDetailsResult = response.getSetOrderReferenceDetailsResult();
                tabLevel++;
                if (setOrderReferenceDetailsResult.isSetOrderReferenceDetails()) {
                    Utilities.printVariable("OrderReferenceDetails", null, tabLevel, outStream);
                    OrderReferenceDetails  orderReferenceDetails = setOrderReferenceDetailsResult.getOrderReferenceDetails();
                    tabLevel++;
                    if (orderReferenceDetails.isSetAmazonOrderReferenceId()) {
                        Utilities.printVariable("AmazonOrderReferenceId", orderReferenceDetails.getAmazonOrderReferenceId(), tabLevel, outStream);
                    }
                    tabLevel++;
                    if (orderReferenceDetails.isSetBuyer()) {
                        Utilities.printVariable("Buyer", null, tabLevel, outStream);
                        Buyer  buyer = orderReferenceDetails.getBuyer();
                        tabLevel++;
                        if (buyer.isSetName()) {
                            Utilities.printVariable("Name", buyer.getName(), tabLevel, outStream);
                        }
                        if (buyer.isSetEmail()) {
                            Utilities.printVariable("Email", buyer.getEmail(), tabLevel, outStream);
                        }
                        if (buyer.isSetPhone()) {
                            Utilities.printVariable("Phone", buyer.getPhone(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (orderReferenceDetails.isSetOrderTotal()) {
                        Utilities.printVariable("OrderTotal", null, tabLevel, outStream);
                        OrderTotal  orderTotal = orderReferenceDetails.getOrderTotal();
                        tabLevel++;
                        if (orderTotal.isSetCurrencyCode()) {
                            Utilities.printVariable("CurrencyCode", orderTotal.getCurrencyCode(), tabLevel, outStream);
                        }
                        if (orderTotal.isSetAmount()) {
                            Utilities.printVariable("Amount", orderTotal.getAmount(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (orderReferenceDetails.isSetSellerNote()) {
                        Utilities.printVariable("SellerNote", orderReferenceDetails.getSellerNote(), tabLevel, outStream);
                    }
                    if (orderReferenceDetails.isSetPlatformId()) {
                        Utilities.printVariable("PlatformId", orderReferenceDetails.getPlatformId(), tabLevel, outStream);
                    }
                    if (orderReferenceDetails.isSetDestination()) {
                        Utilities.printVariable("Destination", null, tabLevel, outStream);
                        Destination  destination = orderReferenceDetails.getDestination();
                        tabLevel++;
                        if (destination.isSetDestinationType()) {
                            Utilities.printVariable("DestinationType", destination.getDestinationType(), tabLevel, outStream);
                        }
                        if (destination.isSetPhysicalDestination()) {
                            Utilities.printVariable("PhysicalDestination", null, tabLevel, outStream);
                            Address  physicalDestination = destination.getPhysicalDestination();
                            tabLevel++;
                            if (physicalDestination.isSetName()) {
                                Utilities.printVariable("Name", physicalDestination.getName(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetAddressLine1()) {
                                Utilities.printVariable("AddressLine1", physicalDestination.getAddressLine1(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetAddressLine2()) {
                                Utilities.printVariable("AddressLine2", physicalDestination.getAddressLine2(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetAddressLine3()) {
                                Utilities.printVariable("AddressLine3", physicalDestination.getAddressLine3(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetCity()) {
                                Utilities.printVariable("City", physicalDestination.getCity(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetCounty()) {
                                Utilities.printVariable("County", physicalDestination.getCounty(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetDistrict()) {
                                Utilities.printVariable("District", physicalDestination.getDistrict(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetStateOrRegion()) {
                                Utilities.printVariable("StateOrRegion", physicalDestination.getStateOrRegion(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetPostalCode()) {
                                Utilities.printVariable("PostalCode", physicalDestination.getPostalCode(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetCountryCode()) {
                                Utilities.printVariable("CountryCode", physicalDestination.getCountryCode(), tabLevel, outStream);
                            }
                            if (physicalDestination.isSetPhone()) {
                                Utilities.printVariable("Phone", physicalDestination.getPhone(), tabLevel, outStream);
                            }
                            tabLevel--;
                        } 
                        tabLevel--;
                    }
                    if (orderReferenceDetails.isSetBillingAddress()) {
    					Utilities.printVariable("BillingAddress", null, tabLevel,
    							outStream);
    					BillingAddress billingAddress = orderReferenceDetails
    							.getBillingAddress();
    					tabLevel++;
    					if (billingAddress.isSetAddressType()) {
    						Utilities.printVariable("AddressType",
    								billingAddress.getAddressType(), tabLevel,
    								outStream);
    					}
    					if (billingAddress.isSetPhysicalAddress()) {
    						Utilities.printVariable("PhysicalAddress", null,
    								tabLevel, outStream);
    						Address physicalAddress = billingAddress
    								.getPhysicalAddress();
    						tabLevel++;
    						if (physicalAddress.isSetName()) {
    							Utilities.printVariable("Name",
    									physicalAddress.getName(), tabLevel,
    									outStream);
    						}
    						if (physicalAddress.isSetAddressLine1()) {
    							Utilities.printVariable("AddressLine1",
    									physicalAddress.getAddressLine1(),
    									tabLevel, outStream);
    						}
    						if (physicalAddress.isSetAddressLine2()) {
    							Utilities.printVariable("AddressLine2",
    									physicalAddress.getAddressLine2(),
    									tabLevel, outStream);
    						}
    						if (physicalAddress.isSetAddressLine3()) {
    							Utilities.printVariable("AddressLine3",
    									physicalAddress.getAddressLine3(),
    									tabLevel, outStream);
    						}
    						if (physicalAddress.isSetCity()) {
    							Utilities.printVariable("City",
    									physicalAddress.getCity(), tabLevel,
    									outStream);
    						}
    						if (physicalAddress.isSetCounty()) {
    							Utilities.printVariable("County",
    									physicalAddress.getCounty(), tabLevel,
    									outStream);
    						}
    						if (physicalAddress.isSetDistrict()) {
    							Utilities.printVariable("District",
    									physicalAddress.getDistrict(),
    									tabLevel, outStream);
    						}
    						if (physicalAddress.isSetStateOrRegion()) {
    							Utilities.printVariable("StateOrRegion",
    									physicalAddress.getStateOrRegion(),
    									tabLevel, outStream);
    						}
    						if (physicalAddress.isSetPostalCode()) {
    							Utilities.printVariable("PostalCode",
    									physicalAddress.getPostalCode(),
    									tabLevel, outStream);
    						}
    						if (physicalAddress.isSetCountryCode()) {
    							Utilities.printVariable("CountryCode",
    									physicalAddress.getCountryCode(),
    									tabLevel, outStream);
    						}
    						if (physicalAddress.isSetPhone()) {
    							Utilities.printVariable("Phone",
    									physicalAddress.getPhone(), tabLevel,
    									outStream);
    						}
    						tabLevel--;
    					}
    					tabLevel--;
    				}
                    if (orderReferenceDetails.isSetReleaseEnvironment()) {
                        Utilities.printVariable("ReleaseEnvironment", orderReferenceDetails.getReleaseEnvironment().value(), tabLevel, outStream);
                    }
                    if (orderReferenceDetails.isSetSellerOrderAttributes()) {
                        Utilities.printVariable("SellerOrderAttributes", null, tabLevel, outStream);
                        SellerOrderAttributes  sellerOrderAttributes = orderReferenceDetails.getSellerOrderAttributes();
                        tabLevel++;
                        if (sellerOrderAttributes.isSetSellerOrderId()) {
                            Utilities.printVariable("SellerOrderId", sellerOrderAttributes.getSellerOrderId(), tabLevel, outStream);
                        }
                        if (sellerOrderAttributes.isSetStoreName()) {
                            Utilities.printVariable("StoreName", sellerOrderAttributes.getStoreName(), tabLevel, outStream);
                        }
                        if (sellerOrderAttributes.isSetOrderItemCategories()) {
                            Utilities.printVariable("OrderItemCategories", null, tabLevel, outStream);
                            OrderItemCategories  orderItemCategories = sellerOrderAttributes.getOrderItemCategories();
                            java.util.List<String> orderItemCategoryList  =  orderItemCategories.getOrderItemCategory();
                            tabLevel++;
                            for (String orderItemCategory : orderItemCategoryList) { 
                                Utilities.printVariable("OrderItemCategory", orderItemCategory, tabLevel, outStream);
                            }	
                            tabLevel--;
                        } 
                        if (sellerOrderAttributes.isSetCustomInformation()) {
                            Utilities.printVariable("CustomInformation", sellerOrderAttributes.getCustomInformation(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (orderReferenceDetails.isSetOrderReferenceStatus()) {
                        Utilities.printVariable("OrderReferenceStatus", null, tabLevel, outStream);
                        OrderReferenceStatus  orderReferenceStatus = orderReferenceDetails.getOrderReferenceStatus();
                        tabLevel++;
                        if (orderReferenceStatus.isSetState()) {
                            Utilities.printVariable("State", orderReferenceStatus.getState(), tabLevel, outStream);
                        }
                        if (orderReferenceStatus.isSetLastUpdateTimestamp()) {
                            Utilities.printVariable("LastUpdateTimestamp", orderReferenceStatus.getLastUpdateTimestamp().toString(), tabLevel, outStream);
                        }
                        if (orderReferenceStatus.isSetReasonCode()) {
                            Utilities.printVariable("ReasonCode", orderReferenceStatus.getReasonCode(), tabLevel, outStream);
                        }
                        if (orderReferenceStatus.isSetReasonDescription()) {
                            Utilities.printVariable("ReasonDescription", orderReferenceStatus.getReasonDescription(), tabLevel, outStream);
                        }
                        tabLevel--;
                    } 
                    if (orderReferenceDetails.isSetConstraints()) {
                        Utilities.printVariable("Constraints", null, tabLevel, outStream);
                        Constraints  constraints = orderReferenceDetails.getConstraints();
                        java.util.List<Constraint> constraintList = constraints.getConstraint();
                        tabLevel++;
                        for (Constraint constraint : constraintList) {
                            Utilities.printVariable("Constraint", null, tabLevel, outStream);
                            tabLevel++;
                            if (constraint.isSetConstraintID()) {
                                Utilities.printVariable("ConstraintID", constraint.getConstraintID(), tabLevel, outStream);
                            }
                            if (constraint.isSetDescription()) {
                                Utilities.printVariable("Description", constraint.getDescription(), tabLevel, outStream);
                            }
                            tabLevel--;
                        }
                        tabLevel--;
                    } 
                    if (orderReferenceDetails.isSetCreationTimestamp()) {
                        Utilities.printVariable("CreationTimestamp", orderReferenceDetails.getCreationTimestamp().toString(), tabLevel, outStream);
                    }
                    if (orderReferenceDetails.isSetExpirationTimestamp()) {
                        Utilities.printVariable("ExpirationTimestamp", orderReferenceDetails.getExpirationTimestamp().toString(), tabLevel, outStream);
                    }
                    if (orderReferenceDetails.isSetIdList()) {
                        Utilities.printVariable("IdList", null, tabLevel, outStream);
                        IdList  idList = orderReferenceDetails.getIdList();
                        java.util.List<String> memberList  =  idList.getMember();
                        tabLevel++;
                        for (String member : memberList) { 
                            Utilities.printVariable("member", member, tabLevel, outStream);
                        }   
                        tabLevel--;
                    } 
                }
                tabLevel--;
            } 
            tabLevel--;
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
