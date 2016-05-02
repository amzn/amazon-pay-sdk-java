package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.RefundRequest;

import static junit.framework.Assert.assertNotNull;

public class RefundRequestTest extends ModelTest<RefundRequest>{

    @Override
    protected String getXMLTestFile(){
        return "RefundRequest.xml";
    }

    @Override
    protected Class<RefundRequest> getTestClassType() {
        return RefundRequest.class;
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
