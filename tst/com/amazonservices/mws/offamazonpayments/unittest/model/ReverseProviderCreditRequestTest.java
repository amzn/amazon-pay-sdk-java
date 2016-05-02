package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.ReverseProviderCreditRequest;

import static junit.framework.Assert.assertNotNull;

public class ReverseProviderCreditRequestTest extends ModelTest<ReverseProviderCreditRequest>{

    @Override
    protected String getXMLTestFile(){
        return "ReverseProviderCreditRequest.xml";
    }

    @Override
    protected Class<ReverseProviderCreditRequest> getTestClassType() {
        return ReverseProviderCreditRequest.class;
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
    public void toJSONShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String jsonFragment = getTestClassObject().toJSONFragment();

        assertNotNull(jsonFragment);
    }
}
