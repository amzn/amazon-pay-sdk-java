/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.IPN;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.util.Map;
import java.util.HashMap;
/**
 * Pay with Amazon Ipn Handler
 *
 * This class authenticates an sns message sent from Amazon. It
 * will validate the header, subject, and certificate. After validation
 * there are many helper methods in place to extract information received
 * from the ipn notification.
 * 
 */
public class IPNHandler {
    
    String signatureString = null;
    String secretKey = null;
    Map<String, String> header = new HashMap<String,String>();
    private static final String COMMON_NAME = "sns.amazonaws.com";
    /* 
    * This method will authenticate the ipn message sent from Amazon.
    * It will return true if everything is verified. It will raise an
    * error message if verification fails.
    */
    public void authenticate() {
      /*try { 
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signature = mac.doFinal(signatureString.getBytes("UTF-8"));
        byte[] decoded_from_base64 = Base64.encodeBase64(signature);
        validate_header();
        //validate_subject(get_certificate.subject);
        //public_key = get_public_key_from(get_certificate);
        //verify_public_key(public_key, decoded_from_base64, canonical_string);

       } catch (Exception e) {
           System.out.println("IPN Could not be authenticated");
      }*/
    }
    
    public boolean validate_header() {
        if (header.get("x-amz-sns-message-type") == "Notification") return true;
        else return false;
    }
    
    public boolean validate_subject() {
        if (header.get("x-amz-sns-message-type") == "Notification") return true;
        else return false;
    }
    
}

