package PayWithAmazon;

import PayWithAmazon.Request.AuthorizeRequest;
import PayWithAmazon.Request.CaptureRequest;
import PayWithAmazon.Request.CloseOrderReferenceRequest;
import PayWithAmazon.Request.ConfirmOrderReferenceRequest;
import PayWithAmazon.Request.GetAuthorizationDetailsRequest;
import PayWithAmazon.Request.GetCaptureDetailsRequest;
import PayWithAmazon.Request.GetOrderReferenceDetailsRequest;
import PayWithAmazon.Request.GetRefundDetailsRequest;
import PayWithAmazon.Request.Recurring.AuthorizeOnBillingAgreementRequest;
import PayWithAmazon.Request.Recurring.CloseBillingAgreementRequest;
import PayWithAmazon.Request.Recurring.ConfirmBillingAgreementRequest;
import PayWithAmazon.Request.Recurring.GetBillingAgreementRequest;
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
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PayWithAmazonUtilities {

    public PayWithAmazonClientRequest client;
    public static final String AMAZON_PAYMENTS_API_VERSION = "2013-01-01";

    public PayWithAmazonUtilities(PayWithAmazonClientRequest r) {
        client = r;
    }


    public String getPostURL() {
        return "POST\n" + client.getAmazonPaymentsServiceURL().replace("https://", "") + "\n" + client.getAmazonPaymentsServiceAPIVersion() + "\n";
    }


   



    public String apiRequest(String action, Map<String, String> params) {
        String apiResponse = null;
        String request = buildRequest(action, params);
        System.out.println("apiRequest: " + request);
        try {
            Document response = Jsoup.connect(request).ignoreHttpErrors(true).post();
            System.out.println(response);
            apiResponse = response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public String buildRequest(String action, Map<String, String> params) {
        String ts = urlEncode(getTimestamp());
        params.put("Action", action);
        params.put("AWSAccessKeyId", client.access_key);
        params.put("SellerId", client.merchant_id);
        params.put("SignatureVersion", "2");
        params.put("SignatureMethod", "HmacSHA256");
        params.put("Version", AMAZON_PAYMENTS_API_VERSION);
        params.put("Timestamp", ts);
        String sts = getStringToSign(params);
        String sig = getSignature(sts, client.secret_key);
        //System.out.println("sts = \n" + sts);
        //System.out.println("sig = \n" + sig);
        params.put("Signature", urlEncode(sig));
        StringBuilder requestString = new StringBuilder();
        requestString.append(client.amazon_payments_endpoint + "?");
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
       // System.out.println("getStringToSign (end) sts = " + sts);
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
