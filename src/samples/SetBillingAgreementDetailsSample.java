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
 * Set Billing Agreement Details  Samples
 *
 *
 */
public class SetBillingAgreementDetailsSample {

  /**
   * Just add few required parameters, and try the service
   * Set Billing Agreement Details functionality
   *
   * @param args unused
   */
  public static void main(String... args) {
    OffAmazonPaymentsServiceConfig config =
        new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties());
    OffAmazonPaymentsService service = new OffAmazonPaymentsServiceClient(config);

    /************************************************************************
     * Setup request parameters and try out sample for
     * Set Billing Agreement Details 
     ***********************************************************************/
    SetBillingAgreementDetailsRequest request = new SetBillingAgreementDetailsRequest();
    request.setSellerId(config.getSellerId());

    PrintWriter outStream = new PrintWriter(System.out, true);

    SetBillingAgreementDetailsResponse response = invokeSetBillingAgreementDetails(service, request, outStream);
    printResponse(response, outStream);
  }



  /**
   * Set Billing Agreement Details  request sample

   * @param service instance of OffAmazonPaymentsService service
   * @param request Action to invoke
   */
  public static SetBillingAgreementDetailsResponse invokeSetBillingAgreementDetails(
      OffAmazonPaymentsService service, SetBillingAgreementDetailsRequest request, PrintWriter outStream) {
    try {
      SetBillingAgreementDetailsResponse response =
          service.setBillingAgreementDetails(request);
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
   * Method to print Set Billing Agreement Details  response to console

   *@param response instance of SetBillingAgreementDetailsResponse
   */
  public static void printResponse(SetBillingAgreementDetailsResponse response, PrintWriter outStream){

    System.out.println ("SetBillingAgreementDetails Action Response");
    System.out.println ("=============================================================================");
    System.out.println ();

    System.out.println("    SetBillingAgreementDetailsResponse");
    System.out.println();
    if (response.isSetSetBillingAgreementDetailsResult()) {
      System.out.println("        SetBillingAgreementDetailsResult");
      System.out.println();
      SetBillingAgreementDetailsResult  setBillingAgreementDetailsResult = response.getSetBillingAgreementDetailsResult();
      if (setBillingAgreementDetailsResult.isSetBillingAgreementDetails()) {
        System.out.println("            BillingAgreementDetails");
        System.out.println();
        BillingAgreementDetails  billingAgreementDetails = setBillingAgreementDetailsResult.getBillingAgreementDetails();
        if (billingAgreementDetails.isSetAmazonBillingAgreementId()) {
          System.out.println("                AmazonBillingAgreementId");
          System.out.println();
          System.out.println("                    " + billingAgreementDetails.getAmazonBillingAgreementId());
          System.out.println();
        }
        if (billingAgreementDetails.isSetBillingAgreementLimits()) {
          System.out.println("                BillingAgreementLimits");
          System.out.println();
          BillingAgreementLimits  billingAgreementLimits = billingAgreementDetails.getBillingAgreementLimits();
          if (billingAgreementLimits.isSetAmountLimitPerTimePeriod()) {
            System.out.println("                    AmountLimitPerTimePeriod");
            System.out.println();
            Price  amountLimitPerTimePeriod = billingAgreementLimits.getAmountLimitPerTimePeriod();
            if (amountLimitPerTimePeriod.isSetAmount()) {
              System.out.println("                        Amount");
              System.out.println();
              System.out.println("                            " + amountLimitPerTimePeriod.getAmount());
              System.out.println();
            }
            if (amountLimitPerTimePeriod.isSetCurrencyCode()) {
              System.out.println("                        CurrencyCode");
              System.out.println();
              System.out.println("                            " + amountLimitPerTimePeriod.getCurrencyCode());
              System.out.println();
            }
          } 
          if (billingAgreementLimits.isSetTimePeriodStartDate()) {
            System.out.println("                    TimePeriodStartDate");
            System.out.println();
            System.out.println("                        " + billingAgreementLimits.getTimePeriodStartDate());
            System.out.println();
          }
          if (billingAgreementLimits.isSetTimePeriodEndDate()) {
            System.out.println("                    TimePeriodEndDate");
            System.out.println();
            System.out.println("                        " + billingAgreementLimits.getTimePeriodEndDate());
            System.out.println();
          }
          if (billingAgreementLimits.isSetCurrentRemainingBalance()) {
            System.out.println("                    CurrentRemainingBalance");
            System.out.println();
            Price  currentRemainingBalance = billingAgreementLimits.getCurrentRemainingBalance();
            if (currentRemainingBalance.isSetAmount()) {
              System.out.println("                        Amount");
              System.out.println();
              System.out.println("                            " + currentRemainingBalance.getAmount());
              System.out.println();
            }
            if (currentRemainingBalance.isSetCurrencyCode()) {
              System.out.println("                        CurrencyCode");
              System.out.println();
              System.out.println("                            " + currentRemainingBalance.getCurrencyCode());
              System.out.println();
            }
          } 
        } 
        if (billingAgreementDetails.isSetBuyer()) {
          System.out.println("                Buyer");
          System.out.println();
          Buyer  buyer = billingAgreementDetails.getBuyer();
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
        if (billingAgreementDetails.isSetSellerNote()) {
          System.out.println("                SellerNote");
          System.out.println();
          System.out.println("                    " + billingAgreementDetails.getSellerNote());
          System.out.println();
        }
        if (billingAgreementDetails.isSetPlatformId()) {
          System.out.println("                PlatformId");
          System.out.println();
          System.out.println("                    " + billingAgreementDetails.getPlatformId());
          System.out.println();
        }
        if (billingAgreementDetails.isSetDestination()) {
          System.out.println("                Destination");
          System.out.println();
          Destination  destination = billingAgreementDetails.getDestination();
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
        if (billingAgreementDetails.isSetBillingAddress()) {
            System.out.println("                BillingAddress");
            System.out.println();
            BillingAddress  billingAddress = billingAgreementDetails.getBillingAddress();
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
        if (billingAgreementDetails.isSetReleaseEnvironment()) {
          System.out.println("                ReleaseEnvironment");
          System.out.println();
          System.out.println("                    " + billingAgreementDetails.getReleaseEnvironment().value());
          System.out.println();
        }
        if (billingAgreementDetails.isSetSellerBillingAgreementAttributes()) {
          System.out.println("                SellerBillingAgreementAttributes");
          System.out.println();
          SellerBillingAgreementAttributes  sellerBillingAgreementAttributes = billingAgreementDetails.getSellerBillingAgreementAttributes();
          if (sellerBillingAgreementAttributes.isSetSellerBillingAgreementId()) {
            System.out.println("                    SellerBillingAgreementId");
            System.out.println();
            System.out.println("                        " + sellerBillingAgreementAttributes.getSellerBillingAgreementId());
            System.out.println();
          }
          if (sellerBillingAgreementAttributes.isSetStoreName()) {
            System.out.println("                    StoreName");
            System.out.println();
            System.out.println("                        " + sellerBillingAgreementAttributes.getStoreName());
            System.out.println();
          }
          if (sellerBillingAgreementAttributes.isSetCustomInformation()) {
            System.out.println("                    CustomInformation");
            System.out.println();
            System.out.println("                        " + sellerBillingAgreementAttributes.getCustomInformation());
            System.out.println();
          }
        } 
        if (billingAgreementDetails.isSetBillingAgreementStatus()) {
          System.out.println("                BillingAgreementStatus");
          System.out.println();
          BillingAgreementStatus  billingAgreementStatus = billingAgreementDetails.getBillingAgreementStatus();
          if (billingAgreementStatus.isSetState()) {
            System.out.println("                    State");
            System.out.println();
            System.out.println("                        " + billingAgreementStatus.getState());
            System.out.println();
          }
          if (billingAgreementStatus.isSetLastUpdatedTimestamp()) {
            System.out.println("                    LastUpdatedTimestamp");
            System.out.println();
            System.out.println("                        " + billingAgreementStatus.getLastUpdatedTimestamp());
            System.out.println();
          }
          if (billingAgreementStatus.isSetReasonCode()) {
            System.out.println("                    ReasonCode");
            System.out.println();
            System.out.println("                        " + billingAgreementStatus.getReasonCode());
            System.out.println();
          }
          if (billingAgreementStatus.isSetReasonDescription()) {
            System.out.println("                    ReasonDescription");
            System.out.println();
            System.out.println("                        " + billingAgreementStatus.getReasonDescription());
            System.out.println();
          }
        } 
        if (billingAgreementDetails.isSetConstraints()) {
          System.out.println("                Constraints");
          System.out.println();
          Constraints  constraints = billingAgreementDetails.getConstraints();
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
        if (billingAgreementDetails.isSetCreationTimestamp()) {
          System.out.println("                CreationTimestamp");
          System.out.println();
          System.out.println("                    " + billingAgreementDetails.getCreationTimestamp());
          System.out.println();
        }
        if (billingAgreementDetails.isSetExpirationTimestamp()) {
          System.out.println("                ExpirationTimestamp");
          System.out.println();
          System.out.println("                    " + billingAgreementDetails.getExpirationTimestamp());
          System.out.println();
        }
        if (billingAgreementDetails.isSetBillingAgreementConsent()) {
          System.out.println("                BillingAgreementConsent");
          System.out.println();
          System.out.println("                    " + billingAgreementDetails.isBillingAgreementConsent());
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
