package PayWithAmazon;

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
import PayWithAmazon.Utilities.ClientMappings;
import PayWithAmazon.Utilities.ParamConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class Client {
    
    String merchantId, accessKey, secretKey, regionCode, proxyName, proxyPort, proxyUser, proxyPass, applicationName, applicationVersion;
    boolean sandboxMode; 
    
    String mwsDomainName , mwsPathName , mwsEndpoint;
   
    Map<String, String> clientParameters = new HashMap<String,String>();

    public Client(String merchantId, String accessKey, String secretKey, String regionCode, boolean sandboxMode) {
        this.merchantId = merchantId;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.regionCode = regionCode;
        this.sandboxMode = sandboxMode;
        this.clientParameters.put("SellerId" , merchantId);
        this.clientParameters.put("AWSAccessKeyId" , accessKey);
        this.clientParameters.put("SignatureVersion", "2");
        this.clientParameters.put("SignatureMethod", "HmacSHA256");
        this.clientParameters.put("Version", ParamConstants.AMAZON_PAYMENTS_API_VERSION);
        setMwsUrlEndpoint();
    }
    
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
        setMwsUrlEndpoint();
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public void setProxyPass(String proxyPass) {
        this.proxyPass = proxyPass;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public void setSandboxMode(boolean sandboxMode) {
        this.sandboxMode = sandboxMode;
        setMwsUrlEndpoint();
    }

    public PayWithAmazon.ClientResponse getOrderReferenceDetails(GetOrderReferenceDetailsRequest request) {
        String postRequestString = buildPostRequest("GetOrderReferenceDetails", request.getParamMap());
        return apiPostRequest(postRequestString);
    }


    public PayWithAmazon.ClientResponse getBillingAgreementDetails(GetBillingAgreementDetailsRequest request) {
        String requestString = buildPostRequest("GetBillingAgreementDetails", request.getParamMap());
        return apiPostRequest(requestString);
    }
   
    public PayWithAmazon.ClientResponse setOrderReferenceDetails(SetOrderReferenceDetailsRequest request) {
        String requestString = buildPostRequest("SetOrderReferenceDetails", request.getParamMap());
        return apiPostRequest(requestString);
    }

    public PayWithAmazon.ClientResponse setBillingAgreementDetails(SetBillingAgreementDetailsRequest request) {
        String requestString = buildPostRequest("SetBillingAgreementDetails", request.getParamMap());
        return apiPostRequest(requestString);
    }
    
    public PayWithAmazon.ClientResponse Authorize(AuthorizeRequest request) {
        String requestString = buildPostRequest("Authorize", request.getParamMap());
        return apiPostRequest(requestString);
    }
    
    public PayWithAmazon.ClientResponse getAuthorizationDetails(GetAuthorizationDetailsRequest request) {
        String requestString = buildPostRequest("GetAuthorizationDetails", request.getParamMap());
        return apiPostRequest(requestString);
    }
    
    public PayWithAmazon.ClientResponse Capture(CaptureRequest request) {
        String requestString = buildPostRequest("Capture", request.getParamMap());
        return apiPostRequest(requestString);
    }

    public PayWithAmazon.ClientResponse getCaptureDetails(GetCaptureDetailsRequest request) {
        String requestString = buildPostRequest("GetCaptureDetails", request.getParamMap());
        return apiPostRequest(requestString);
    }

    public PayWithAmazon.ClientResponse confirmOrderReference(ConfirmOrderReferenceRequest request) {
        String requestString = buildPostRequest("ConfirmOrderReference", request.getParamMap());
        return apiPostRequest(requestString);
    }
    
    public PayWithAmazon.ClientResponse closeAuthorization(CloseAuthorizationRequest request) {
        String requestString = buildPostRequest("CloseAuthorization", request.getParamMap());
        return apiPostRequest(requestString);
    }

    
    public PayWithAmazon.ClientResponse cancelOrderReference(CancelOrderReferenceRequest request) {
        String requestString = buildPostRequest("CancelOrderReference", request.getParamMap());
        return apiPostRequest(requestString);
    }
    
    public PayWithAmazon.ClientResponse closeOrderReference(CloseOrderReferenceRequest request) {
        String requestString = buildPostRequest("CloseOrderReference", request.getParamMap());
        return apiPostRequest(requestString);
    }

    public PayWithAmazon.ClientResponse refund(RefundRequest request) {
        String requestString = buildPostRequest("Refund", request.getParamMap());
        return apiPostRequest(requestString);
    }


    public PayWithAmazon.ClientResponse getRefundDetails(GetRefundDetailsRequest request) {
        String requestString = buildPostRequest("GetRefundDetails", request.getParamMap());
        return apiPostRequest(requestString);
    }
    


    public PayWithAmazon.ClientResponse validateBillingAgreement(ValidateBillingAgreementRequest request) {
        String requestString = buildPostRequest("ValidateBillingAgreement", request.getParamMap());
        return apiPostRequest(requestString);
    }

    public PayWithAmazon.ClientResponse confirmBillingAgreement(ConfirmBillingAgreementRequest request) {
        String requestString = buildPostRequest("ConfirmBillingAgreement" ,  request.getParamMap());
        return apiPostRequest(requestString);
    }

    public PayWithAmazon.ClientResponse authorizeOnBillingAgreement(AuthorizeOnBillingAgreementRequest request) {
        String requestString = buildPostRequest("AuthorizeOnBillingAgreement", request.getParamMap());
        return apiPostRequest(requestString);
    }
    
    public PayWithAmazon.ClientResponse closeBillingAgreement(CloseBillingAgreementRequest request) {
        String requestString = buildPostRequest("CloseBillingAgreement", request.getParamMap());
        return apiPostRequest(requestString);
    }
 
    private void urlEncodeAPIParams(Map<String, String> apiParameters) {
       for (Map.Entry<String, String> entry : apiParameters.entrySet()) {
          entry.setValue(urlEncode(entry.getValue() ));
        }
    }
    
    public String buildPostRequest(String action, Map<String, String> apiParameters ) {
        
         //get all parameters
        Map<String,String> allParams = new HashMap<String,String>();
        urlEncodeAPIParams(apiParameters);
        allParams.putAll(apiParameters);
        allParams.putAll(this.clientParameters);
        allParams.put("Action", action);
        allParams.put("Timestamp", urlEncode(getTimestamp()));
        
        //Calculate the signature that needs to be signed.
        String postURLForSignature = "POST\n" + mwsDomainName.replace("https://", "")  + "\n" + mwsPathName + "\n";
        String stringToSign = getStringToSign(postURLForSignature , allParams);
       
        //add the signature to parameter list
        String signature = urlEncode( getSignature(stringToSign, secretKey));
        allParams.put("Signature" , signature);
        
        //construct the request String
        StringBuilder requestString = new StringBuilder();
        requestString.append(mwsEndpoint + "?");
        String paramsString = buildParamsString(allParams);
        requestString.append(paramsString);
        return requestString.toString();
        
        
    }

    private void setMwsUrlEndpoint() { 
        mwsDomainName = ClientMappings.regionEndpointMappings.get(ClientMappings.regionMappings.get(this.regionCode));   
        if(sandboxMode) {
            mwsPathName = "/" + "OffAmazonPayments_Sandbox" + "/" + ParamConstants.AMAZON_PAYMENTS_API_VERSION;
        }
        else { 
            mwsPathName = "/" + "OffAmazonPayments" + "/" + ParamConstants.AMAZON_PAYMENTS_API_VERSION;
        }
        mwsEndpoint = mwsDomainName + "/" + mwsPathName;
    }

    private String getTimestamp() {
        final Date date = new Date();
        final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ssz";
        final SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT);
        final TimeZone utc = TimeZone.getTimeZone("UTC");
        sdf.setTimeZone(utc);
        String ts = sdf.format(date);
        return (ts.replace("UTC", "Z"));
    }
    
    private ClientResponse postRequest(String request) {
        ClientResponse apiResponse = null;
        try {
            Connection con = Jsoup.connect(request);
            con.ignoreHttpErrors(true).post();
            apiResponse = new ClientResponse();
            apiResponse.setXmlString(con.response().parse().toString());
            apiResponse.setStatusCode(con.response().statusCode());
            apiResponse.setDocumentResponse(con.response().parse());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiResponse;
    }
    private ClientResponse apiPostRequest(String requestString) {
        ClientResponse response = null;
        
        //make the API call
        System.out.println("apiRequest: " + requestString);
        try {
            response = postRequest(requestString);
            int statusCode = response.getStatusCode();
            int retry = 0;
            while ((statusCode == 500 || statusCode == 501) && retry < 3) {
                retry++;
                if (retry == 1) {
                    Thread.sleep(1);
                } else if (retry == 2) {
                    Thread.sleep(4);
                } else if (retry == 3) {
                    Thread.sleep(10);
                } else {
                    return null;
                }
                response = postRequest(requestString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    
    private String getStringToSign(String postURL, Map<String, String> params) {
        
        String stringToSign = postURL;
        //sort all parameters 
        Map<String, String> sortedParams = new TreeMap<String, String>();
        sortedParams.putAll(params);
        stringToSign = stringToSign + buildParamsString(sortedParams);
        return stringToSign;
    }

    private String getSignature(String stringToSign, String secretKey) {
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


    String urlEncode(String str) {
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
    
    private String buildParamsString(Map<String, String> params) {
        StringBuilder paramsString = new StringBuilder();
        Iterator<Map.Entry<String, String>> pairs = params.entrySet().iterator();
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
     


     
}
