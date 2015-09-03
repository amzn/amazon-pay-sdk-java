
import PayWithAmazon.Client;
import PayWithAmazon.Request.AuthorizeOnBillingAgreementRequest;
import PayWithAmazon.Request.AuthorizeRequest;
import PayWithAmazon.Request.CancelOrderReferenceRequest;
import PayWithAmazon.Request.CaptureRequest;
import PayWithAmazon.Request.CloseAuthorizationRequest;
import PayWithAmazon.Request.CloseBillingAgreementRequest;
import PayWithAmazon.Request.CloseOrderReferenceRequest;
import PayWithAmazon.Request.ConfirmBillingAgreementRequest;
import PayWithAmazon.Request.ConfirmOrderReferenceRequest;
import PayWithAmazon.Request.GetAuthorizationDetailsRequest;
import PayWithAmazon.Request.GetBillingAgreementDetailsRequest;
import PayWithAmazon.Request.GetCaptureDetailsRequest;
import PayWithAmazon.Request.GetOrderReferenceDetailsRequest;
import PayWithAmazon.Request.GetRefundDetailsRequest;
import PayWithAmazon.Request.RefundRequest;
import PayWithAmazon.Request.SetBillingAgreementDetailsRequest;
import PayWithAmazon.Request.SetOrderReferenceDetailsRequest;
import PayWithAmazon.Request.ValidateBillingAgreementRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class API extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
       String requestType = null, merchantId=null, accessKey=null, secretKey=null, regionCode=null, sandboxMode=null,  orderReferenceId = null, addressConsentToken = null, mwsAuthToken = null;
       boolean sandbox = false;
       merchantId = request.getParameter("merchantId");
       accessKey = request.getParameter("accessKey");
       secretKey = request.getParameter("secretKey");
       regionCode = request.getParameter("regionCode");
       sandboxMode = request.getParameter("sandboxMode");
       mwsAuthToken = request.getParameter("mwsAuthToken");
       requestType = request.getParameter("api");
       
       if (sandboxMode.equals("true")) {
           sandbox = true;
       }
       
       PrintWriter out = response.getWriter();
       
       Client client= new Client(merchantId,accessKey,secretKey, regionCode, true);
       
       response.setContentType("text/html");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>API Response</title>");
       out.println("</head>");
       out.println("<body>");
       out.println("<h3>API Response</h3>");
       
       if (requestType.equals("GetOrderReferenceDetails")) { 
            orderReferenceId = request.getParameter("oroId");
            addressConsentToken = request.getParameter("addressConsentToken");
            GetOrderReferenceDetailsRequest req = new GetOrderReferenceDetailsRequest().setAmazonOrderReferenceId(orderReferenceId).setAddressConsentToken(addressConsentToken).setMWSAuthToken(mwsAuthToken);
            out.println("<b>Action: GetOrderReferenceDetails</b><br/>");
       
            String outputString = client.getOrderReferenceDetails(req).getXmlAsString();
            String postRequest = client.buildPostRequest("GetOrderReferenceDetails", req.getParamMap());
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
            out.println("<br/><br/>Status Code: " + client.getOrderReferenceDetails(req).getStatusCode());
       }
       
       if (requestType.equals("SetOrderReferenceDetails")) { 
            orderReferenceId = request.getParameter("oroId");

            SetOrderReferenceDetailsRequest req = new SetOrderReferenceDetailsRequest().setAmazonOrderReferenceId(orderReferenceId).setMWSAuthToken(mwsAuthToken);
            req.setOrderAmount(request.getParameter("amount"));
            req.setOrderCurrencyCode(request.getParameter("currencyCode"));
            req.setPlatformId(request.getParameter("platformId"));
            req.setSellerNote(request.getParameter("sellerNote"));
            req.setStoreName(request.getParameter("storeName"));
            req.setSellerOrderId(request.getParameter("sellerOrderId"));
            req.setCustomInformation(request.getParameter("customInformation"));
            
            out.println("<b>Action: SetOrderReferenceDetails</b><br/>");
            String outputString = client.setOrderReferenceDetails(req).getXmlAsString();
            String postRequest = client.buildPostRequest("SetOrderReferenceDetails" , req.getParamMap());
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
            out.println("<br/><br/>Status Code: " + client.setOrderReferenceDetails(req).getStatusCode());
       }
       
       
       if (requestType.equals("Authorize")) { 
            orderReferenceId = request.getParameter("oroId");
            AuthorizeRequest req = new AuthorizeRequest().setAmazonOrderReferenceId(orderReferenceId).setMWSAuthToken(mwsAuthToken);
            req.setAuthorizationReferenceId(request.getParameter("authorizationReferenceId"));
            req.setAuthorizationAmount(request.getParameter("authorizationAmount"));
            req.setAuthorizationCurrencyCode(request.getParameter("currencyCode"));
            
            req.setSellerAuthorizationNote(request.getParameter("sellerAuthorizationNote"));
            req.setTransactionTimeout(request.getParameter("transactionTimeout"));
            req.setCaptureNow(request.getParameter("captureNow"));
            req.setSoftDescriptor(request.getParameter("softDescriptor"));
            
  
            out.println("<b>Action: Authorize</b><br/>");
       
            String outputString = client.Authorize(req).getXmlAsString();
            String postRequest = client.buildPostRequest("Authorize" ,req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");

            out.println("<br/><br/>Status Code: " + client.Authorize(req).getStatusCode());
       }
       
       if (requestType.equals("GetAuthorizationDetails")) { 
            String amazonAuthorizationId = orderReferenceId = request.getParameter("amazonAuthorizationId");

            GetAuthorizationDetailsRequest req = new GetAuthorizationDetailsRequest();
            
            req.setAmazonAuthorizationId(amazonAuthorizationId).setMWSAuthToken(mwsAuthToken);


            out.println("<b>Action: GetAuthorizationDetails</b><br/>");
       
            String outputString = client.getAuthorizationDetails(req).getXmlAsString();
            String postRequest = client.buildPostRequest("GetAuthorizationDetails" ,req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
     
       if (requestType.equals("Capture")) { 
            //Required
            String amazonAuthorizationId = orderReferenceId = request.getParameter("amazonAuthorizationId");
            String captureReferenceId = orderReferenceId = request.getParameter("captureReferenceId");
            String CaptureAmount = orderReferenceId = request.getParameter("captureAmount");
            
            //Optional
            String SellerCaptureNote = orderReferenceId = request.getParameter("sellerCaptureNote");
            String SoftDescriptor = orderReferenceId = request.getParameter("softDescriptor");

            CaptureRequest req = new CaptureRequest();
            req.setAmazonAuthorizationId(amazonAuthorizationId);
            req.setCaptureReferenceId(captureReferenceId);
            req.setCaptureAmount(CaptureAmount);
            req.setCaptureCurrencyCode(request.getParameter("currencyCode"));
            req.setSellerCaptureNote(SellerCaptureNote);
            req.setSoftDescriptor(SoftDescriptor);
            req.setMWSAuthToken(mwsAuthToken);

            out.println("<b>Action: Capture</b><br/>");
       
            String outputString = client.Capture(req).getXmlAsString();
            String postRequest = client.buildPostRequest("Capture" ,req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
     

       
       if (requestType.equals("GetCaptureDetails")) { 
            String amazonCaptureId = orderReferenceId = request.getParameter("amazonCaptureId");


            GetCaptureDetailsRequest req = new GetCaptureDetailsRequest();
            
            //required parameters
            req.setAmazonCaptureId(amazonCaptureId);
                    
            //optional parameters
            req.setMWSAuthToken(mwsAuthToken);

            out.println("<b>Action: GetCaptureDetails</b><br/>");
       
            String outputString = client.getCaptureDetails(req).getXmlAsString();
            String postRequest = client.buildPostRequest("GetCaptureDetails" , req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
       
       if (requestType.equals("ConfirmOrderReference")) { 
            orderReferenceId = request.getParameter("amazonOrderReferenceId");


            ConfirmOrderReferenceRequest req = new ConfirmOrderReferenceRequest();
            
            //required parameter
            req.setAmazonOrderReferenceId(orderReferenceId); 
            //optional parameter
            req.setMWSAuthToken(mwsAuthToken);

            out.println("<b>Action: ConfirmOrderReference</b><br/>");
       
            String outputString = client.confirmOrderReference(req).getXmlAsString();
            String postRequest = client.buildPostRequest("ConfirmOrderReference" , req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
           
       if (requestType.equals("CloseAuthorization")) { 
            String amazonAuthorizationId = request.getParameter("amazonAuthorizationId");
            String closureReason = request.getParameter("closureReason");

            CloseAuthorizationRequest req = new CloseAuthorizationRequest();
            
            //required
            req.setAmazonAuthorizationId(amazonAuthorizationId);
            
            //optional
            req.setClosureReason(closureReason);
            req.setMWSAuthToken(mwsAuthToken);


            out.println("<b>Action: CloseAuthorization</b><br/>");
       
            String outputString = client.closeAuthorization(req).getXmlAsString();
            String postRequest = client.buildPostRequest("CloseAuthorization" , req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
     
       if (requestType.equals("CloseOrderReference")) { 
            String amazonOrderReferenceId = request.getParameter("amazonOrderReferenceId");
            String closureReason = request.getParameter("closureReason");

            CloseOrderReferenceRequest req = new CloseOrderReferenceRequest();
            
            //required
            req.setAmazonOrderReferenceId(amazonOrderReferenceId);
            
            //optional
            req.setClosureReason(closureReason);
            req.setMWSAuthToken(mwsAuthToken);
            out.println("<b>Action: CloseOrderReference</b><br/>");
       
            String outputString = client.closeOrderReference(req).getXmlAsString();
            String postRequest = client.buildPostRequest("CloseOrderReference" , req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
        
       if (requestType.equals("CancelOrderReference")) { 
            String amazonOrderReferenceId = request.getParameter("amazonOrderReferenceId");
            String cancelationReason = request.getParameter("cancelationReason");

            CancelOrderReferenceRequest req = new CancelOrderReferenceRequest();
            //required
            req.setAmazonOrderReferenceId(amazonOrderReferenceId);
            //optional
            req.setCancelReason(cancelationReason);
            req.setMWSAuthToken(mwsAuthToken);

            out.println("<b>Action: CancelOrderReference</b><br/>");
       
            String outputString = client.cancelOrderReference(req).getXmlAsString();
            String postRequest = client.buildPostRequest("CancelOrderReference" , req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
        
       if (requestType.equals("Refund")) { 
            String amazonCaptureId = request.getParameter("amazonCaptureId");
            String refundReferenceId = request.getParameter("refundReferenceId");
            String refundAmount = request.getParameter("refundAmount");
            String refundCurrencyCode = request.getParameter("refundCurrencyCode");
            String sellerRefundNote = request.getParameter("sellerRefundNote");
            String softDescriptor = request.getParameter("softDescriptor");

            RefundRequest req = new RefundRequest();
            
            req.setAmazonCaptureId(amazonCaptureId).setRefundReferenceId(refundReferenceId).setRefundAmount(refundAmount).setSellerRefundNote(sellerRefundNote).setSoftDescriptor(softDescriptor).setMWSAuthToken(mwsAuthToken).setRefundCurrencyCode(refundCurrencyCode);

            out.println("<b>Action: Refund</b><br/>");
       
            String outputString = client.refund(req).getXmlAsString();
            String postRequest = client.buildPostRequest("Refund" , req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
      
       if (requestType.equals("GetRefundDetails")) { 
            String amazonRefundId = request.getParameter("amazonRefundId");
            GetRefundDetailsRequest req = new GetRefundDetailsRequest();
            
            req.setAmazonRefundId(amazonRefundId);

            req.setMWSAuthToken(mwsAuthToken);
            
            out.println("<b>Action: Refund</b><br/>");
       
            String outputString = client.getRefundDetails(req).getXmlAsString();
            String postRequest = client.buildPostRequest("GetRefundDetails" , req.getParamMap() );
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
       
      
       
       if (requestType.equals("GetBillingAgreementDetails")) { 
            String amazonBillingAgreementId = request.getParameter("amazonBillingAgreementId");
            addressConsentToken = request.getParameter("addressConsentToken");

            GetBillingAgreementDetailsRequest req = new GetBillingAgreementDetailsRequest();
            
            req.setAmazonBillingAgreementId(amazonBillingAgreementId).setAddressConsentToken(addressConsentToken).setMWSAuthToken(mwsAuthToken);
            
            out.println("<b>Action: GetBillingAgreementDetails</b><br/>");
       
            String outputString = client.getBillingAgreementDetails(req).getXmlAsString();
            String postRequest = client.buildPostRequest("GetBillingAgreementDetails", req.getParamMap());
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
       
        
       if (requestType.equals("SetBillingAgreementDetails")) { 
            String amazonBillingAgreementId = request.getParameter("amazonBillingAgreementId");
            String platformId = request.getParameter("platformId");
            String sellerNote = request.getParameter("sellerNote");
            String sellerBillingAgreementId =  request.getParameter("sellerBillingAgreementId");
            String storeName =  request.getParameter("storeName");
            String customInformation = request.getParameter("customInformation");

            SetBillingAgreementDetailsRequest req = new SetBillingAgreementDetailsRequest();
            
            req.setAmazonBillingAgreementId(amazonBillingAgreementId).setMWSAuthToken(mwsAuthToken).setCustomInformation(customInformation).setPlatformId(platformId).setSellerNote(sellerNote).setSellerBillingAgreementId(sellerBillingAgreementId).setStoreName(storeName);

            out.println("<b>Action: SetBillingAgreementDetails</b><br/>");
       
            String outputString = client.setBillingAgreementDetails(req).getXmlAsString();
            String postRequest = client.buildPostRequest("SetBillingAgreementDetails", req.getParamMap());
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
     
       if (requestType.equals("ValidateBillingAgreement")) { 
            String amazonBillingAgreementId = request.getParameter("amazonBillingAgreementId");

            ValidateBillingAgreementRequest req = new ValidateBillingAgreementRequest();
            
            req.setAmazonBillingAgreementId(amazonBillingAgreementId).setMWSAuthToken(mwsAuthToken);

            out.println("<b>Action: ValidateBillingAgreement</b><br/>");
       
            String outputString = client.validateBillingAgreement(req).getXmlAsString();
            String postRequest = client.buildPostRequest("ValidateBillingAgreement", req.getParamMap());
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
        
       if (requestType.equals("ConfirmBillingAgreement")) { 
            String amazonBillingAgreementId = request.getParameter("amazonBillingAgreementId");

             ConfirmBillingAgreementRequest req = new  ConfirmBillingAgreementRequest();
            
            req.setAmazonBillingAgreementId(amazonBillingAgreementId).setMWSAuthToken(mwsAuthToken);

            out.println("<b>Action: ConfirmBillingAgreement</b><br/>");
       
            String outputString = client.confirmBillingAgreement(req).getXmlAsString();
            String postRequest = client.buildPostRequest("ConfirmBillingAgreementt", req.getParamMap());
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }
     
     if (requestType.equals("AuthorizeOnBillingAgreement")) { 
            String amazonBillingAgreementId = request.getParameter("amazonBillingAgreementId");
            AuthorizeOnBillingAgreementRequest req = new AuthorizeOnBillingAgreementRequest();
            req.setAmazonBillingAgreementId(amazonBillingAgreementId).setMWSAuthToken(mwsAuthToken);
            req.setAuthorizationReferenceId(request.getParameter("authorizationReferenceId"));
            req.setAuthorizationAmount(request.getParameter("authorizationAmount"));
            req.setAuthorizationCurrencyCode(request.getParameter("authorizationCurrencyCode"));

            req.setSellerAuthorizationNote(request.getParameter("sellerAuthorizationNote"));
            req.setTransactionTimeout(request.getParameter("transactionTimeout"));
            req.setCaptureNow(request.getParameter("captureNow"));
            req.setSoftDescriptor(request.getParameter("softDescriptor"));
            req.setSellerNote(request.getParameter("sellerNote"));
            req.setPlatformId(request.getParameter("platformId"));
            req.setSellerOrderId(request.getParameter("sellerOrderId"));
            req.setStoreName(request.getParameter("storeName"));
            req.setCustomInformation(request.getParameter("customInformation"));
            req.setInheritShippingAddress(request.getParameter("inheritShippingAddress"));

            out.println("<b>Action: Authorize</b><br/>");
       
            String outputString = client.authorizeOnBillingAgreement(req).getXmlAsString();
            String postRequest = client.buildPostRequest("AuthorizeOnBillingAgreement", req.getParamMap());
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }

       if (requestType.equals("CloseBillingAgreement")) { 
            String amazonBillingAgreementId = request.getParameter("amazonBillingAgreementId");

            CloseBillingAgreementRequest req = new  CloseBillingAgreementRequest();
            
            req.setAmazonBillingAgreementId(amazonBillingAgreementId).setMWSAuthToken(mwsAuthToken);

            out.println("<b>Action: CloseBillingAgreement</b><br/>");
       
            String outputString = client.closeBillingAgreement(req).getXmlAsString();
            String postRequest = client.buildPostRequest("CloseBillingAgreement", req.getParamMap());
            
            out.println("Post Request String:<br/> " + "<textarea rows=\"4\" cols=\"100\">" + postRequest + "</textarea>");
            out.println("<br/><br/>Response XML String:<br/> " + "<textarea rows=\"30\" cols=\"100\">" + outputString + "</textarea>");
       }

       out.println("</body>");
       out.println("</html>");
          
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        doGet(request, response);
    }

   
    }
                