package PayWithAmazon;

import PayWithAmazon.Request.AuthorizeRequest;
import PayWithAmazon.Request.CancelOrderReferenceRequest;
import PayWithAmazon.Request.CaptureRequest;
import PayWithAmazon.Request.CloseAuthorizationRequest;
import PayWithAmazon.Request.CloseOrderReferenceRequest;
import PayWithAmazon.Request.ConfirmOrderReferenceRequest;
import PayWithAmazon.Request.GetAuthorizationDetailsRequest;
import PayWithAmazon.Request.GetCaptureDetailsRequest;
import PayWithAmazon.Request.GetOrderReferenceDetailsRequest;
import PayWithAmazon.Request.GetRefundDetailsRequest;
import PayWithAmazon.Request.Recurring.AuthorizeOnBillingAgreementRequest;
import PayWithAmazon.Request.Recurring.CloseBillingAgreementRequest;
import PayWithAmazon.Request.Recurring.ConfirmBillingAgreementRequest;
import PayWithAmazon.Request.Recurring.GetBillingAgreementDetailsRequest;
import PayWithAmazon.Request.Recurring.SetBillingAgreementDetailsRequest;
import PayWithAmazon.Request.Recurring.ValidateBillingAgreementRequest;
import PayWithAmazon.Request.RefundRequest;
import PayWithAmazon.Request.SetOrderReferenceDetailsRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import java.util.Map;

public class Client {

    public ClientRequest clientRequest;
    public static final String AMAZON_PAYMENTS_API_VERSION = "2013-01-01";

    public Client(ClientRequest request) {
        clientRequest = request;
    }


    public String getPostURL() {
        return "POST\n" + clientRequest.getAmazonPaymentsServiceURL().replace("https://", "") + "\n" + clientRequest.getAmazonPaymentsServiceAPIVersion() + "\n";
    }

    public PayWithAmazon.Response.Response getOrderReferenceDetails(GetOrderReferenceDetailsRequest request) {
        return apiRequest("GetOrderReferenceDetails", request.getParamMap());
    }
    

    public String getOrderReferenceDetailsPostRequest(GetOrderReferenceDetailsRequest request) {
        return buildRequest("GetOrderReferenceDetails", request.getParamMap());
    }

    public PayWithAmazon.Response.Response getBillingAgreementDetails(GetBillingAgreementDetailsRequest request) {
        return apiRequest("GetBillingAgreementDetails", request.getParamMap());
    }
    
    public String getBillingAgreementDetailsPostRequest(GetBillingAgreementDetailsRequest request) {
       return buildRequest("GetBillingAgreementDetails", request.getParamMap());
    }
    
    public PayWithAmazon.Response.Response setOrderReferenceDetails(SetOrderReferenceDetailsRequest request) {
        return apiRequest("SetOrderReferenceDetails", request.getParamMap());
    }
    
    public String setOrderReferenceDetailsPostRequest(SetOrderReferenceDetailsRequest request) {
        return buildRequest("SetOrderReferenceDetails", request.getParamMap());
    }
    
    public PayWithAmazon.Response.Response setBillingAgreementDetails(SetBillingAgreementDetailsRequest request) {
        return apiRequest("SetBillingAgreementDetails", request.getParamMap());
    }

    public String setBillingAgreementDetailsPostRequest(SetBillingAgreementDetailsRequest request) {
       return buildRequest("SetBillingAgreementDetails", request.getParamMap());
    }

    public PayWithAmazon.Response.Response validateBillingAgreement(ValidateBillingAgreementRequest request) {
        return apiRequest("ValidateBillingAgreement", request.getParamMap());
    }

    public String validateBillingAgreementPostRequest(ValidateBillingAgreementRequest request) {
        return buildRequest("ValidateBillingAgreement", request.getParamMap());
    }
    
    public PayWithAmazon.Response.Response confirmOrderReference(ConfirmOrderReferenceRequest request) {
        return apiRequest("ConfirmOrderReference", request.getParamMap());
    }
    
    public String confirmOrderReferencePostRequest(ConfirmOrderReferenceRequest request) {

        return buildRequest("ConfirmOrderReference", request.getParamMap());
    }
    
    public PayWithAmazon.Response.Response confirmBillingAgreement(ConfirmBillingAgreementRequest request) {
        return apiRequest("ConfirmBillingAgreement", request.getParamMap());
    }
    
    public String confirmBillingAgreementPostRequest(ConfirmBillingAgreementRequest request) {
        return buildRequest("ConfirmBillingAgreement", request.getParamMap());
    }

    public PayWithAmazon.Response.Response Authorize(AuthorizeRequest request) {
        return apiRequest("Authorize", request.getParamMap());
    }
    
    public PayWithAmazon.Response.Response cancelOrderReference(CancelOrderReferenceRequest request) {
        return apiRequest("CancelOrderReference", request.getParamMap());
    }
    
    public String cancelOrderReferencePostRequest(CancelOrderReferenceRequest request) {
        return buildRequest("CancelOrderReference", request.getParamMap());

    }
    public String AuthorizePostRequest(AuthorizeRequest request) {
        return buildRequest("Authorize", request.getParamMap());
    }

    public PayWithAmazon.Response.Response authorizeOnBillingAgreement(AuthorizeOnBillingAgreementRequest request) {
        return apiRequest("AuthorizeOnBillingAgreementDetails", request.getParamMap());
    }
    
    public String authorizeOnBillingAgreementPostRequest(AuthorizeOnBillingAgreementRequest request) {
        return buildRequest("AuthorizeOnBillingAgreement", request.getParamMap());
    }
    
    public PayWithAmazon.Response.Response getAuthorizationDetails(GetAuthorizationDetailsRequest request) {
        return apiRequest("GetAuthorizationDetails", request.getParamMap());
    }
    
    public String getAuthorizationDetailsPostRequest(GetAuthorizationDetailsRequest request) {
        return buildRequest("GetAuthorizationDetails", request.getParamMap());
    }
    
    public PayWithAmazon.Response.Response closeAuthorization(CloseAuthorizationRequest request) {
        return apiRequest("CloseAuthorization", request.getParamMap());
    }
    
    public String closeAuthorizationPostRequest(CloseAuthorizationRequest request) {
        return buildRequest("CloseAuthorization", request.getParamMap());
    }
    public PayWithAmazon.Response.Response Capture(CaptureRequest request) {
        return apiRequest("Capture", request.getParamMap());
    }
    
    public String CapturePostRequest(CaptureRequest request) {
        return buildRequest("Capture", request.getParamMap());
    }

    public PayWithAmazon.Response.Response getCaptureDetails(GetCaptureDetailsRequest request) {
        return apiRequest("GetCaptureDetails", request.getParamMap());
    }

    public String getCaptureDetailsPostRequest(GetCaptureDetailsRequest request) {
        return buildRequest("GetCaptureDetails", request.getParamMap());
    }

    public PayWithAmazon.Response.Response refund(RefundRequest request) {
        return apiRequest("Refund", request.getParamMap());
    }
    public String refundPostRequest(RefundRequest request) {
        return buildRequest("Refund", request.getParamMap());
    }

    public PayWithAmazon.Response.Response getRefundDetails(GetRefundDetailsRequest request) {
        return apiRequest("GetRefundDetails", request.getParamMap());
    }
    
    public String getRefundDetailsPostRequest(GetRefundDetailsRequest request) {
        return buildRequest("GetRefundDetails", request.getParamMap());
    }

    public PayWithAmazon.Response.Response closeOrderReference(CloseOrderReferenceRequest request) {
        return apiRequest("CloseOrderReference", request.getParamMap());
    }
    public String closeOrderReferencePostRequest(CloseOrderReferenceRequest request) {
        return buildRequest("CloseOrderReference", request.getParamMap());
    }
    
    public PayWithAmazon.Response.Response closeBillingAgreement(CloseBillingAgreementRequest request) {
        return apiRequest("CloseBillingAgreement" , request.getParamMap());
    }
    
    public String closeBillingAgreementPostRequest(CloseBillingAgreementRequest request) {
        return buildRequest("CloseBillingAgreement", request.getParamMap());
    }
    
    
    public PayWithAmazon.Response.Response apiRequest(String action, Map<String, String> params) {
        PayWithAmazon.Response.Response response = null;
        String request = buildRequest(action, params);
        System.out.println("apiRequest: " + request);
        try {
            response = postRequest(request);
            
            int statusCode = response.getStatusCode();
            int retry = 0;
            
            while((statusCode == 500 || statusCode == 501) && retry < 3) {
                 retry++;
                 if (retry == 1) { 
                     java.lang.Thread.sleep(1); 
                 }
                 else if(retry == 2) { 
                     java.lang.Thread.sleep(4); 
                 }
                 else if(retry == 3)  
                 { 
                      java.lang.Thread.sleep(10); 
                 }
                 else 
                     return null;
                 response = postRequest(request);
           }
        }
      
        catch(Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    private PayWithAmazon.Response.Response postRequest(String request) {
       PayWithAmazon.Response.Response apiResponse = null;

        try{
            Connection con = Jsoup.connect(request);
            con.ignoreHttpErrors(true).post();
            
            apiResponse = new PayWithAmazon.Response.Response();
            apiResponse.setXmlString(con.response().parse().toString());
            apiResponse.setStatusCode(con.response().statusCode());
            apiResponse.setDocumentResponse(con.response().parse());
        }
           catch (IOException e) {
                e.printStackTrace();
        }
        return apiResponse;
    }
    
    public void getParamMap(String action, Map<String,String> params) {
        String ts = urlEncode(getTimestamp());
        params.remove("Signature");
        params.put("Action", action);
        params.put("AWSAccessKeyId", clientRequest.access_key);
        params.put("SellerId", clientRequest.merchant_id);
        params.put("SignatureVersion", "2");
        params.put("SignatureMethod", "HmacSHA256");
        params.put("Version", AMAZON_PAYMENTS_API_VERSION);
        params.put("Timestamp", ts);
}
    public String buildRequest(String action, Map<String, String> params) {

        getParamMap(action,params);
        String sts = getStringToSign(params);
        String sig = getSignature(sts, clientRequest.secret_key);
        System.out.println("sts = \n" + sts);
        System.out.println("sig = \n" + sig);
        params.put("Signature", urlEncode(sig));
        StringBuilder requestString = new StringBuilder();
        requestString.append(clientRequest.amazon_payments_endpoint + "?");
        String paramsString = buildParamsString(params);
        requestString.append(paramsString);
        //System.out.println("buildRequest string: " + requestString.toString());
        return requestString.toString();
    }

    public String buildParamsString(Map<String, String> params) {
        StringBuilder paramsString = new StringBuilder();
        Iterator<Entry<String, String>> pairs = params.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            if (pair.getValue() != null) {
                paramsString.append(pair.getKey() + "=" + pair.getValue());
            } else {
                paramsString.append(pair.getKey() + "=");
            }
            if (pairs.hasNext()) {
                paramsString.append("&"); // Delimit parameters with ampersand (&)
            }
        }
        return paramsString.toString();
    }

    public String getStringToSign(Map<String, String> params) {
        String sts = getPostURL();
       // System.out.println("getStringToSign (start) sts = \n" + sts);
        StringBuilder data = new StringBuilder();
        Map<String, String> sortedParams = new TreeMap<String, String>();
        sortedParams.putAll(params);
        Iterator<Entry<String, String>> pairs = sortedParams.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            if (pair.getValue() != null) {
                data.append(pair.getKey() + "=" + pair.getValue());
            } else {
                data.append(pair.getKey() + "=");
            }
            if (pairs.hasNext()) {
                data.append("&"); // Delimit parameters with ampersand (&)
            }
        }
        sts = sts + data.toString();
        return sts;
    }

    public String getSignature(String stringToSign, String secretKey) {
        String sig = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signature = mac.doFinal(stringToSign.getBytes("UTF-8"));
            String signatureBase64 = new String(Base64.encodeBase64(signature), "UTF-8");
            sig = signatureBase64;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sig;
    }

    public String getTimestamp() {
        final Date date = new Date();
        final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ssz";
        final SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT);
        final TimeZone utc = TimeZone.getTimeZone("UTC");
        sdf.setTimeZone(utc);
        String ts = sdf.format(date);
        return (ts.replace("UTC", "Z"));
    }

    public String urlEncode(String str) {
        String val = (str == null) ? "" : str;
        String encoded = null;

        try {
            encoded = URLEncoder.encode(val, "UTF-8")
                    .replace("+", "%20")
                    .replace("*", "%2A")
                    .replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encoded;
    }

}
