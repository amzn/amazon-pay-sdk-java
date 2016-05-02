/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
 */
package com.amazonservices.mws.offamazonpaymentsipn.validators;

import java.io.UnsupportedEncodingException;
import java.security.cert.X509Certificate;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.xml.bind.DatatypeConverter;
import java.net.URL;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import java.net.MalformedURLException;

import com.amazonservices.mws.offamazonpayments.certificate.X509CertificateFactory;
import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;

/**
 * Implements the environment independent portion of signature verification.
 */
public class SnsSignatureVerification implements ISnsSignatureVerification {

    /**
     * Contains environment specific verification functions.
     */
    private IVerifyData verifyData;
    
    /**
     * Factory for obtaining certificates from a URL
     */
    private final X509CertificateFactory certFactory;

    /**
     * Format string for IPN timestamps, in ISO8601 format with millseconds, in UTC.
     */
    private final String Iso8601UTCDateWithMillisecondsFormatString = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /**
     * Formatter to perform the formatting of the above format.
     */
    private final Format Iso8601UTCDateWithMillisecondsFormatter = new SimpleDateFormat(Iso8601UTCDateWithMillisecondsFormatString);

    /**
     * Error string for unknown notification type.
     */
    private final static String UNKNOWN_NOTIF_ERROR = "Error with sns message verification - message is not of type Notification, no implementation of signing algorithm is present for other notification types";
    
    /**
     * Error string for invalid certificate
     */
    private final static String INVALID_CERT_ERROR = "Error with sns message verification - certificate in notification is not a valid certificate issued by Amazon";
        
    /**
     * Create a new instance of the sns signature verification using
     * an implementation of the data verification interface.
     * @param verifyData
     */
    public SnsSignatureVerification(final IVerifyData verifyData, final X509CertificateFactory certFactory){
        this.verifyData = verifyData;
        this.certFactory = certFactory;        		
    }

    /**
     * Perform the comparison of the message data with the signature,
     * as described on http://docs.aws.amazon.com/sns/latest/dg/SendMessageToHttp.verify.signature.html,
     * for version 1 of the signature algorithm.
     * @param snsMessage sns message with metadata
     * @return true if verified, otherwise false
     */
    @Override
    public boolean verifyMsgMatchesSignatureV1WithCert(final Message snsMessage) throws NotificationsException{
        if (!snsMessage.getMandatoryField("Type").equals("Notification")) {
            throw new NotificationsException(UNKNOWN_NOTIF_ERROR);
        }

        X509Certificate cert = getCertificate(snsMessage);
        if (!verifyData.verifyCertIsIssuedByAmazon(cert)) {
            throw new NotificationsException(INVALID_CERT_ERROR);	
        }
        
        String msg = getMessageToSign(snsMessage);
        byte[] decodedSignature = DatatypeConverter.parseBase64Binary(snsMessage.getMandatoryField("Signature"));
        byte[] data = null;
        try {
            data = msg.getBytes("UTF-8");
            return verifyData.verifyMsgMatchesSignatureWithPublicCert(data, decodedSignature, cert);
        } catch (UnsupportedEncodingException e) {
            throw new NotificationsException(e.getMessage());
        }
    }

    /**
     * Extract the contents of the message and build a string to has in order
     * to verify the signature
     *
     * Expected string is a single string in format field name\n field value\n,
     * with the field names in alphabetical byte order (e.g. A-Za-z)
     * notification use the Message, MessageId, Subject if provided,
     * Timestamp, TopicArn & Type fields
     * @param snsMessage Sns message with metadata
     * @return Signature comparision string, unhashed
     * @throws NotificationsException
     */
    private String getMessageToSign(final Message snsMessage) throws NotificationsException
    {
        StringBuilder builder = new StringBuilder();

        builder.append("Message\n");
        builder.append(snsMessage.getMandatoryField("Message"));
        builder.append("\n");
        builder.append("MessageId\n");
        builder.append(snsMessage.getMandatoryField("MessageId"));
        builder.append("\n");
        String subject = snsMessage.getField("Subject");
        if (subject != null) {
            builder.append("Subject\n");
            builder.append(subject);
            builder.append("\n");
        }
        builder.append("Timestamp\n");

        builder.append(Iso8601UTCDateWithMillisecondsFormatter.format(snsMessage.getMandatoryFieldAsDate("Timestamp")));
        builder.append("\n");
        builder.append("TopicArn\n");
        builder.append(snsMessage.getMandatoryField("TopicArn"));
        builder.append("\n");
        builder.append("Type\n");
        builder.append(snsMessage.getMandatoryField("Type"));
        builder.append("\n");

        return builder.toString();
    }
    
    private X509Certificate getCertificate(final Message snsMessage) throws NotificationsException {
    	 String certPath = snsMessage.getMandatoryField("SigningCertURL");
    	 X509Certificate cert = null;
         Pattern PATTERN_SNS_KEY = Pattern.compile("^sns\\.[a-zA-Z0-9\\-]{3,}\\.amazonaws\\.com(\\.cn)?$"); 
         try { 
            URL  certPathURL = new URL(certPath);
            String host = certPathURL.getHost();
            if (!"https".equals(certPathURL.getProtocol()) || !StringUtils.endsWith(certPath, ".pem") || !PATTERN_SNS_KEY.matcher(host).matches()) {
                throw new SecurityException("Detected Illegal SigningCertURL: " + certPath);
            } 
            cert = certFactory.getCertificate(certPath);
            } catch(MalformedURLException e) {
                throw new SecurityException("Failed parsing signingCertURL: " + certPath , e);
         }
        return cert;
    }
    
}
