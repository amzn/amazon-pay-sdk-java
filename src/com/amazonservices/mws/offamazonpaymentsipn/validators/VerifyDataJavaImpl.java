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

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.List;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.validators.jca.IJCAAdapter;
import com.amazonservices.mws.offamazonpaymentsipn.validators.jca.JCAAdapterBouncyCastleImpl;

public class VerifyDataJavaImpl implements IVerifyData {

	private final String expectedCertCN;
	private final IJCAAdapter jcaAdapter;

	/**
	 * Validate that the CN field contains the expected value,
	 * using the bouncy castle implementation of JCA
	 * @param expectedCertCN value of CN field
	 */
	public VerifyDataJavaImpl(String expectedCertCN) {
		this(expectedCertCN, new JCAAdapterBouncyCastleImpl());
	}

	/**
	 * Validate that the CN field contains the expected value,
	 * using the provided JCAAdapter implementation
	 * @param expectedCertCN value of CN field
	 * @param jcaAdapter wrapper around required JCA functions
	 */
	public VerifyDataJavaImpl(String expectedCertCN, IJCAAdapter jcaAdapter) {
		this.expectedCertCN = expectedCertCN;
		this.jcaAdapter = jcaAdapter;
	}


	/**
	 * Perform the comparison of the message data with the signature, as
	 * described on
	 * http://docs.aws.amazon.com/sns/latest/dg/SendMessageToHttp.verify
	 * .signature.html, for version 1 of the signature algorithm.
	 * 
	 * @param data
	 *            Byte data to compare using SHA1 hash
	 * @param signature
	 *            decoded signature byte array
	 * @param cert
	 *            Certificate to verify
	 * @return true if verified
	 * @throws NotificationsException
	 */
	public boolean verifyMsgMatchesSignatureWithPublicCert(final byte[] data,final byte[] signature, final X509Certificate cert)
			throws NotificationsException {
		PublicKey csp = cert.getPublicKey();
		try {
			Signature s = Signature.getInstance("SHA1withRSA");
			s.initVerify(csp);
			s.update(data);
			return s.verify(signature);
		} catch (InvalidKeyException e) {
			throw new NotificationsException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new NotificationsException(e.getMessage());
		} catch (SignatureException e) {
			throw new NotificationsException(e.getMessage());
		}
	}

	/**
	 * Verify that certificate is valid and issued by Amazon.
	 * 
	 * @param cert x509 certificate
	 *            Certificate
	 * @return true if verified
	 */
	public boolean verifyCertIsIssuedByAmazon(final X509Certificate cert) throws NotificationsException {
		List<String> cnNames = jcaAdapter.getCNNamesForCert(cert);
		return isCertCNPresent(cnNames);
	}

	/**
	 * Validate that one of the CNs included in the RDN set contain the
	 * amazon issued certCN
	 * @param cnNames subject CN fields
	 * @return true if a match is found
	 */
	private boolean isCertCNPresent(List<String> cnNames) {
		return cnNames.contains(expectedCertCN);
	}
}
