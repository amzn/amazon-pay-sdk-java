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
package samples.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceClient;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;

import samples.utils.PropertyBundle;
import samples.utils.Utilities;

public class IpnExampleServletBase extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected OffAmazonPaymentsServiceConfig config;
  protected OffAmazonPaymentsServiceClient service;
  PrintWriter outStream = null;

  /**
   * Constructor which you can set your own client and config
   */
  public IpnExampleServletBase(OffAmazonPaymentsServiceClient service,
      OffAmazonPaymentsServiceConfig config) {
    this.service = service;
    this.config = config;
  }

  /**
   * Constructor which you can set your own config
   */
  public IpnExampleServletBase(OffAmazonPaymentsServiceConfig config) {
    this(new OffAmazonPaymentsServiceClient(config), config);
  }

  public IpnExampleServletBase() {
    this(new OffAmazonPaymentsServiceConfig(PropertyBundle.getProperties()));
  }

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  protected void printMessage(String string) {
    outStream.println();
    outStream.println(string);
    outStream.println();
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
  

}
