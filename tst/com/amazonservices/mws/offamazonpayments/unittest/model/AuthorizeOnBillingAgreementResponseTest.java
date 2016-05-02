package com.amazonservices.mws.offamazonpayments.unittest.model;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.AuthorizeOnBillingAgreementResponse;

import static junit.framework.Assert.assertNotNull;

public class AuthorizeOnBillingAgreementResponseTest extends ModelTest<AuthorizeOnBillingAgreementResponse>{

    @Override
    protected String getXMLTestFile(){
        return "AuthorizeOnBillingAgreementResponse.xml";
    }

    @Override
    protected Class<AuthorizeOnBillingAgreementResponse> getTestClassType() {
        return AuthorizeOnBillingAgreementResponse.class;
    }

    @Test
    public void testObjectToXML() throws Exception{
        testForNull();
    }

    @Test
    public void testXMLToObject() throws Exception {
        testSchema();
    }

    @Test
    public void toXMLShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String xmlFragment = getTestClassObject().toXML();

        assertNotNull(xmlFragment);
    }

    @Test
    public void toJSONShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String jsonFragment = getTestClassObject().toJSON();

        assertNotNull(jsonFragment);
    }

}