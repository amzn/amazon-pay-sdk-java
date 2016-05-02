package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetCaptureDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class GetCaptureDetailsRequestTest extends ModelTest<GetCaptureDetailsRequest>{

    @Override
    protected String getXMLTestFile(){
        return "GetCaptureDetailsRequest.xml";
    }

    @Override
    protected Class<GetCaptureDetailsRequest> getTestClassType() {
        return GetCaptureDetailsRequest.class;
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
