package com.amazonservices.mws.offamazonpayments.certificate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.CertificateFactory;
import java.util.Calendar;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.cache.ICache;

public class X509CertificateFactoryImpl implements X509CertificateFactory {

    private static final String ERROR_REQUESTING_CERTIFICATE_ERR_MSG = "Error requesting certificate";
    private static final String CERT_KEY = "OffAmazonPaymentNotifications:";

    private final ICache cache;
    private final CertificateFactory certificateFactory;

    public X509CertificateFactoryImpl(final ICache cache) {
        this(cache, getX509CertificateFactory());
    }

    public X509CertificateFactoryImpl(final ICache cache, final CertificateFactory certificateFactory) {
        this.cache = cache;
        this.certificateFactory = certificateFactory;
    }

    private static CertificateFactory getX509CertificateFactory() {
        try {
            return CertificateFactory.getInstance("X.509");
        } catch (CertificateException ex) {
            throw new RuntimeException("Unable to get X509 certificate factory", ex);
        }
    }

    @Override
    public final X509Certificate getCertificate(final String certPath) throws NotificationsException {

        X509Certificate cert = getCertFromCache(certPath);
        if (cert == null) {
            cert = getCertFromURL(certPath);
            cacheCert(certPath, cert);
        }
        return cert;
    }

    private X509Certificate getCertFromCache(final String certPath) {
        String cacheKey = constructCacheKey(certPath);
        X509Certificate cert = (X509Certificate) cache.get(cacheKey);
        return cert;
    }

    private X509Certificate getCertFromURL(final String certPath) throws NotificationsException {

        InputStream stream = null;
        try {
            URL url = new URL(certPath);
            stream = url.openStream();
            return (X509Certificate)this.certificateFactory.generateCertificate(stream);

            /*
            Using pre-java 7 catch blocks for exception handling
            to support clients running earlier versions of java.
             */
        } catch (CertificateException e) {
            return throwExceptionForGetCertificateError(e);
        } catch (IOException e) {
            return throwExceptionForGetCertificateError(e);
        } finally {
            closeStreamQuietly(stream);
        }
    }

    private X509Certificate throwExceptionForGetCertificateError(Exception e) throws NotificationsException {
        throw new NotificationsException(ERROR_REQUESTING_CERTIFICATE_ERR_MSG, e);
    }

    private void cacheCert(final String certPath, final X509Certificate cert) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cache.put(constructCacheKey(certPath), cert, cal);
    }

    private String constructCacheKey(final String certPath) {
        return CERT_KEY + certPath;
    }

    private void closeStreamQuietly(final InputStream stream) {
        try {
            stream.close();
        } catch (Exception e) {
            // Ignore
        }
    }
}
