package com.amazonservices.mws.offamazonpayments.common;
 
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
 
public class Util {
    
    private static final String SIGNATURE_ALGORITHM = "HmacSHA256";
    private static final String ENCODING = "UTF-8";
    
    /**
     * Helper method to calculate base64 encoded signature using specified secret key
     * @throws NoSuchAlgorithmException 
     * @throws UnsupportedEncodingException 
     * @throws InvalidKeyException 
     *
     */
    public static String getSignature(String stringToSign, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac mac = Mac.getInstance(SIGNATURE_ALGORITHM);
        mac.init(new SecretKeySpec(secretKey.getBytes(ENCODING), SIGNATURE_ALGORITHM));
        byte[] signature = mac.doFinal(stringToSign.getBytes(ENCODING));
        String signatureBase64 = new String(Base64.encodeBase64(signature), ENCODING);
        return signatureBase64;
    }
}
