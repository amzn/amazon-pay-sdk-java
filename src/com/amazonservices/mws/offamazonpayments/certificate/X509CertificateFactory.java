package com.amazonservices.mws.offamazonpayments.certificate;

import java.security.cert.X509Certificate;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;

public interface X509CertificateFactory {
	
	public X509Certificate getCertificate(String certPath) throws NotificationsException;

}
