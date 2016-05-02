package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.SetBillingAgreementDetailsResponse;

import static junit.framework.Assert.assertNotNull;

public class SetBillingAgreementDetailsResponseTest extends ModelTest<SetBillingAgreementDetailsResponse>{

    @Override
    protected String getXMLTestFile(){
        return "SetBillingAgreementDetailsResponse.xml";
    }

    @Override
    protected Class<SetBillingAgreementDetailsResponse> getTestClassType() {
        return SetBillingAgreementDetailsResponse.class;
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
