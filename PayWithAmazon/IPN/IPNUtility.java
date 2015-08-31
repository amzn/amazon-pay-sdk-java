package PayWithAmazon.IPN;

import java.io.InputStream;
import java.net.URL;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64; 
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;

/**
 * Helper class to validate the Instant Payment Notifications.
 */
public class IPNUtility {

    private static byte [] getMessageBytesToSign (IPNMessage ipn) {
		byte [] bytesToSign = null;
		bytesToSign = buildNotificationStringToSign(ipn).getBytes();
		return bytesToSign;
	}
	
   /*
    *Build the string to sign for Notification messages.
    */
    private static String buildNotificationStringToSign( IPNMessage ipn) {
	   String stringToSign = null;
		 
  	   //Build the string to sign from the values in the message.
	   //Name and values separated by newline characters
  	   //The name value pairs are sorted by name 
	   //in byte sort order.
	   stringToSign = "Message\n";
	   stringToSign += ipn.getMessage() + "\n";
	   stringToSign += "MessageId\n";
	   stringToSign += ipn.getMessageId() + "\n";
	   stringToSign += "Timestamp\n";
	   stringToSign += ipn.getTimestamp() + "\n";
	   stringToSign += "TopicArn\n";
	   stringToSign += ipn.getTopicArn() + "\n";
	   stringToSign += "Type\n";
	   stringToSign += ipn.getType() + "\n";
	   return stringToSign;
	 }

    public static boolean isMessageSignatureValid(IPNMessage ipn) {
        try {
          //extract certificate from signingURL parameter
          URL url = new URL(ipn.getSigningCertURL());
          InputStream inStream = url.openStream();
          CertificateFactory cf = CertificateFactory.getInstance("X.509");
          X509Certificate cert = (X509Certificate)cf.generateCertificate(inStream);
          inStream.close();

          
          //verify CN of certificate
          boolean isCNValid = false;
          String dn = cert.getSubjectX500Principal().getName();
          LdapName ldapDN = new LdapName(dn);
          for(Rdn rdn: ldapDN.getRdns()) {
                if("CN".equals(rdn.getType()) && "sns.amazonaws.com".equals(rdn.getValue()) ) {
                    isCNValid  = true;
                    break;
                }
          }
          if (isCNValid == false ) {
              throw new SecurityException("Notification validation failed");
          }
          
          //verify the signature with given message and public key
          Signature sig = Signature.getInstance("SHA1withRSA");
          sig.initVerify(cert.getPublicKey());
          sig.update(getMessageBytesToSign(ipn));
          return sig.verify(Base64.getDecoder().decode(ipn.getSignature()));
        }
        catch (Exception e) {
       	  throw new SecurityException("Verify method failed.", e);
        }
   }
    



    
}
