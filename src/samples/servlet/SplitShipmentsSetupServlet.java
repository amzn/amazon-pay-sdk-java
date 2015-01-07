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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SplitShipmentsSetupServlet extends IpnExampleServletBase {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
    String amazonOrderReferenceId = request.getParameter("OrderReferenceId");
    String numberOfShipments = request.getParameter("NumberOfShipments");
    String sellerNote = request.getParameter("SellerNote");
    String sellerOrderId = request.getParameter("SellerOrderId");
    String storeName = request.getParameter("StoreName");
    String softDescriptor = request.getParameter("SoftDescriptor");
    String sellerCaptureNote = request.getParameter("SellerCaptureNote");

    HttpSession session = request.getSession();
    session.setAttribute("OrderReferenceId", amazonOrderReferenceId);
    session.setAttribute("NumberOfShipments", numberOfShipments);
    session.setAttribute("SellerNote", sellerNote);
    session.setAttribute("SellerOrderId", sellerOrderId);
    session.setAttribute("StoreName", storeName);
    session.setAttribute("SoftDescriptor", softDescriptor);
    session.setAttribute("SellerCaptureNote", sellerCaptureNote);

    response.sendRedirect("splitShipment.jsp");
  }

}
