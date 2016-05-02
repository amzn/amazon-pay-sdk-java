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

package com.amazonservices.mws.offamazonpaymentsipn.validators.jca;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;

import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class JCAAdapterBouncyCastleImpl implements IJCAAdapter {

    @Override
    public List<String> getCNNamesForCert(final X509Certificate certificate) throws NotificationsException {
        JcaX509CertificateHolder x509CertificateHolder = getX509CertificateHolder(certificate);
        RDN[] cnNames = getCNNames(x509CertificateHolder);

        return convertToStringList(cnNames);
    }

    /**
     * Convert the java x509 certificate into a bouncycastle crypto library X509
     * certificate holder
     *
     * @param cert amazon issued signing certificate
     * @return JcaX509CertificateHolder representation of same cert
     * @throws NotificationsException if the notification holder cannot be created
     */
    private JcaX509CertificateHolder getX509CertificateHolder(X509Certificate cert) throws NotificationsException {
        try {
            return new JcaX509CertificateHolder(cert);
        } catch (CertificateEncodingException e) {
            throw new NotificationsException(e.getMessage());
        }
    }

    /**
     * Extract the list of subject CN fields attached to this signature
     *
     * @param jcaX509CertificateHolder certificate information structure
     * @return RDN[] array of relative distinguished names that are matched to the
     *              CN field of the x509 certificate
     */
    private RDN[] getCNNames(JcaX509CertificateHolder jcaX509CertificateHolder) {
        X500Name subject = jcaX509CertificateHolder.getSubject();
        return subject.getRDNs(BCStyle.CN);
    }

    /**
     * Convert from an array of RDN fields to a list of strings
     * @param cnNames RDN array containing CN fields
     * @return list of CN fields as strings
     */
    private List<String> convertToStringList(RDN[] cnNames) {
        List<String> cnNameList = new ArrayList<String>(cnNames.length);
        for (RDN rdn : cnNames) {
            cnNameList.add(rdn.getFirst().getValue().toString());
        }

        return cnNameList;
    }
}
