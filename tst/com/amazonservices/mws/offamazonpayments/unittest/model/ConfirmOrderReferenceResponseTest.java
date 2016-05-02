package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.ConfirmOrderReferenceResponse;

import static junit.framework.Assert.assertNotNull;

public class ConfirmOrderReferenceResponseTest extends ModelTest<ConfirmOrderReferenceResponse>{

    @Override
    protected String getXMLTestFile(){
        return "ConfirmOrderReferenceResponse.xml";
    }

    @Override
    protected Class<ConfirmOrderReferenceResponse> getTestClassType() {
        return ConfirmOrderReferenceResponse.class;
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