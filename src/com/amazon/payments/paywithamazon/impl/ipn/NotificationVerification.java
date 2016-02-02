package com.amazon.payments.paywithamazon.impl.ipn;

import com.amazon.payments.paywithamazon.exceptions.AmazonClientException;
import com.amazon.payments.paywithamazon.response.ipn.model.Notification;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Map; 
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * Helper class to verify the Instant Payment Notifications.
 */
public class NotificationVerification {

    /**
     * Helper method to verify IPN Headers
     * @param headers 
     */
    protected void verifyHeaders(Map<String,String> headers) {
        
       final String SNS_HEADER = "x-amz-sns-message-type";
       final String SNS_HEADER_TYPE_NOTIFICATION = "Notification";
       
       if ( headers == null || !headers.containsKey(SNS_HEADER) ) {
            throw new AmazonClientException("Error with SNS message, missing header " + SNS_HEADER);
        }
        String messageType = headers.get(SNS_HEADER);
        if (!SNS_HEADER_TYPE_NOTIFICATION.equalsIgnoreCase(messageType)) {
            throw new AmazonClientException("Error with SNS message, header "+ SNS_HEADER +" has unexpected value ");
        }
    }
    
    /*
    * Helper method to verify IPN using "Signature", "Type" and "SigningCertURL"
    */
    protected boolean verifyMessage(Notification notification) {
        if(notification == null || notification.getNotificationMetadata()== null ||  !"Notification".equals(notification.getNotificationMetadata().getType())) { 
            throw new AmazonClientException("Unable to parse notification, invalid notification");
        }
        
        try {
            URL url = new URL(notification.toMap().get("SigningCertURL"));
            isValidSigningCertURL(url);
            //extract certificate from signingURL parameter
            InputStream inStream = url.openStream();
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate)cf.generateCertificate(inStream);
            inStream.close();

            //verify the signature with given message and public key
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(cert.getPublicKey());
            sig.update(getMessageBytesToSign(notification));
            if(!sig.verify(Base64.getDecoder().decode(notification.toMap().get("Signature")))) { 
              throw new SecurityException("Message signature calculation failed");
            }
            return true;
        } catch (IOException ex)  {
            throw new SecurityException("Encountered IOException, notification verification failed: ", ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new SecurityException("Encountered NoSuchAlgorithmException, notification verification failed: ", ex);
        } catch (SignatureException ex) {
            throw new SecurityException("Encountered SignatureException, notification verification failed: ", ex);
        } catch (CertificateException ex) {
            throw new SecurityException("Encountered CertificateException, notification verification failed: ", ex);
        } catch (InvalidKeyException ex) {
            throw new SecurityException("Encountered InvalidKeyException, notification verification failed: ", ex);
        }

   }
    
    /**
     * Helper method to verify SigningCertURL
     */
    private void isValidSigningCertURL(URL url) throws MalformedURLException{
        Pattern PATTERN_SNS_KEY = Pattern.compile("^sns\\.[a-zA-Z0-9\\-]{3,}\\.amazonaws\\.com(\\.cn)?$"); 
        String host = url.getHost();
        if (!"https".equals(url.getProtocol()) || !StringUtils.endsWith(url.getPath(), ".pem") || !PATTERN_SNS_KEY.matcher(host).matches()) {
            throw new SecurityException("Illegal SigningCertURL parameter: ");
        }
    }
    

   
   /*
    * Used to build the string to sign for notification messages. 
    * Name and values separated by newline characters. The name value pairs are 
    * sorted by name in byte sort order.
    */
    private byte [] getMessageBytesToSign (Notification notification) {
           String stringToSign = null;
	   stringToSign = "Message\n";
	   stringToSign += notification.toMap().get("Message")+ "\n";
	   stringToSign += "MessageId\n";
	   stringToSign += notification.toMap().get("MessageId") + "\n";
	   stringToSign += "Timestamp\n";
	   stringToSign += notification.toMap().get("Timestamp") + "\n";
	   stringToSign += "TopicArn\n";
	   stringToSign += notification.toMap().get("TopicArn") + "\n";
	   stringToSign += "Type\n";
	   stringToSign += notification.toMap().get("Type") + "\n";
	   return stringToSign.getBytes();
    }
	

    
}