package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.ConfirmBillingAgreementResponse;

import static junit.framework.Assert.assertNotNull;

public class ConfirmBillingAgreementResponseTest extends ModelTest<ConfirmBillingAgreementResponse>{

    @Override
    protected String getXMLTestFile(){
        return "ConfirmBillingAgreementResponse.xml";
    }

    @Override
    protected Class<ConfirmBillingAgreementResponse> getTestClassType() {

        return ConfirmBillingAgreementResponse.class;
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