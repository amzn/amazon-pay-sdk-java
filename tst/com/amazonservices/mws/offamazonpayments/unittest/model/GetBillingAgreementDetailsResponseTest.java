package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetBillingAgreementDetailsResponse;

import static junit.framework.Assert.assertNotNull;

public class GetBillingAgreementDetailsResponseTest extends ModelTest<GetBillingAgreementDetailsResponse>{

    @Override
    protected String getXMLTestFile(){
        return "GetBillingAgreementDetailsResponse.xml";
    }

    @Override
    protected Class<GetBillingAgreementDetailsResponse> getTestClassType() {
        return GetBillingAgreementDetailsResponse.class;
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