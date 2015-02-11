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
 * *****************************************************************************
 *
 */


package samples.cli;

import java.io.PrintWriter;

import samples.utils.PropertyBundle;
import samples.utils.Utilities;

import com.amazonservices.mws.offamazonpayments.*;

/**
 * Helper class that has member variables and functions 
 * used across all CLI samples
 *
 */

public class CLIHelperClass {

  protected OffAmazonPaymentsServiceConfig config;
  protected OffAmazonPaymentsServiceClient service;
  protected String amazonOrderReferenceId = null;
  protected static java.util.Scanner in = 
      new java.util.Scanner(System.in).useDelimiter("\\n");
  protected PrintWriter outStream = null;

  /**
   * Constructor which you can set your own client and config
   */
  public CLIHelperClass(OffAmazonPaymentsServiceClient service,
      OffAmazonPaymentsServiceConfig config, boolean getOrderReferenceId) {
    this.service = service;
    this.config = config;
    this.outStream = new PrintWriter(System.out, true);
    if (getOrderReferenceId) {
      getOrderReferenceId();
    }
  }

  /**
   * Constructor which you can set your own config
   */
  public CLIHelperClass(OffAmazonPaymentsServiceConfig config, boolean getOrderReferenceId) {
    this(new OffAmazonPaymentsServiceClient(config), config, getOrderReferenceId);
  }

  /**
   * Constructor with option to get Amazon Order Reference ID
   */
  public CLIHelperClass(boolean getOrderReferenceId) {
    this(new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties()), getOrderReferenceId);
  }

  /**
   * Default constructor is set to get Amazon Order reference ID
   */
  public CLIHelperClass() {
    this(true);
  }

  /**
   * Method to get Amazon Order Reference Id through console
   */
  protected void getOrderReferenceId() {
    outStream.println("Enter a valid Amazon order reference Id " +
        "to run this sample: ");
    String amazonOrderReferenceId = in.nextLine().trim();
    if (amazonOrderReferenceId.equals("")){
      outStream.println("Missing Amazon Order Reference Id or invalid entry" +
          "...Amazon Order Reference ID is required to run this sample");
      System.exit(0);
    }else
      this.amazonOrderReferenceId = amazonOrderReferenceId.trim();
  }

  /**
   * Helper Method to check for NULL response object
   *
   * @param response
   * @param responseName
   * @return
   * @throws OffAmazonPaymentsServiceException
   */
  protected boolean validateResponseNotNull(Object response, String responseObjectName)
      throws OffAmazonPaymentsServiceException {
    return Utilities.validateResponseNotNull(response, responseObjectName);
  }

  /**
   * Helper Method to print with message string
   *
   * @param messageToPrint
   * @throws OffAmazonPaymentsServiceException
   */
  protected void printMessage(String messageToPrint) {
    if (messageToPrint != null) {
      outStream.println("");
      outStream.println(messageToPrint);
      outStream.println("");
    }
  }

  /**
   * Method to read any String from console
   * Empty string will return NULL
   * @return optionalSellerNote
   */
  protected String getUserStringFromConsole(String dataFor) {
    outStream.println("Enter " + dataFor + ": ");
    String data = in.next().trim();
    if (data.equals("")) {
      data = null;
    }
    return data;
  }
  
  /**
   * Check to see if Authorization should be followed with capture
   * 
   * @return
   */
  public boolean isDirectCapture() {
      System.out.println("Please confirm whether " + "if this authorization should be a direct "
              + "capture against the order reference:");
      System.out.println("1.YES");
      System.out.println("2.NO");
      System.out.println("Your Option? ");
      int option = Integer.valueOf(in.next().trim());
      switch (option) {
      case 1:
          return true;
      default:
          return false;
      }
  }

  /**
   * Get Authorization Option
   * 
   * @return 1 for Regular, 2 for Fast.
   */
  public int getAuthorizationOption() {
      System.out.println("Authorization Type?");
      System.out.println("1. Reguar Authorization (Asynchronous Response) [Default]");
      System.out.println("2. Fast Authorization (Synchronous Response)");
      int authOption = 0;
      while (!(authOption == 1 || authOption == 2)) {
          System.out.println("Your Option? ");
          authOption = Integer.valueOf(in.next().trim());
      }
      return authOption;
  }

  public void runSample(){

  }

}
