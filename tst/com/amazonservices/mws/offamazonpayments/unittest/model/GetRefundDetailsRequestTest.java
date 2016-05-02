package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetRefundDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class GetRefundDetailsRequestTest extends ModelTest<GetRefundDetailsRequest>{

    @Override
    protected String getXMLTestFile(){
        return "GetRefundDetailsRequest.xml";
    }

    @Override
    protected Class<GetRefundDetailsRequest> getTestClassType() {
        return GetRefundDetailsRequest.class;
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
