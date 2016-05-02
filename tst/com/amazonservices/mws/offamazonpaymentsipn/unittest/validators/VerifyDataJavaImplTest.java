package com.amazonservices.mws.offamazonpaymentsipn.unittest.validators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

import com.amazonservices.mws.offamazonpaymentsipn.validators.jca.IJCAAdapter;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.amazonservices.mws.offamazonpaymentsipn.validators.IVerifyData;
import com.amazonservices.mws.offamazonpaymentsipn.validators.VerifyDataJavaImpl;

public class VerifyDataJavaImplTest {

	private static final String VALID_CN_NAME = "sns.amazonaws.com";
	private static final String INVALID_CN_NAME = "mws.amazon.com";

	private IVerifyData verifyData;
	private IJCAAdapter mockJcaAdapter;
	private X509Certificate mockCert;

	@Before
	public void setUp() throws Exception {
		this.mockJcaAdapter = Mockito.mock(IJCAAdapter.class);
		this.mockCert = Mockito.mock(X509Certificate.class, Mockito.RETURNS_DEEP_STUBS);

		this.verifyData = new VerifyDataJavaImpl(VALID_CN_NAME, mockJcaAdapter);
	}

	@Test
	public void shouldReturnTrueIfCNNameIsInReturnedList() throws Exception {
		List<String> successList = Arrays.asList(VALID_CN_NAME, INVALID_CN_NAME);
		given(mockJcaAdapter.getCNNamesForCert(mockCert)).willReturn(successList);

		boolean certIsAmazonIssued = verifyData.verifyCertIsIssuedByAmazon(mockCert);
		assertTrue(certIsAmazonIssued);
	}

	@Test
	public void shouldReturnFalseIfCNListDoesNotContainExpectedCNField() throws Exception {
		List<String> failureList = Arrays.asList(INVALID_CN_NAME);
		given(mockJcaAdapter.getCNNamesForCert(mockCert)).willReturn(failureList);

		boolean certIsAmazonIssued = verifyData.verifyCertIsIssuedByAmazon(mockCert);
		assertFalse(certIsAmazonIssued);
	}

	@Test
	public void shouldCreateDefaultAdapterWithBouncyCastleImplExpectedCNNameIsSpecified() {
		IVerifyData verifyData = new VerifyDataJavaImpl(VALID_CN_NAME);

		Assert.assertNotNull(verifyData);
	}
}
