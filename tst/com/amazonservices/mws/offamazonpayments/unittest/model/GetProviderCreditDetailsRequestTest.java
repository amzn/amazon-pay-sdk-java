package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class GetProviderCreditDetailsRequestTest extends ModelTest<GetProviderCreditDetailsRequest> {

    @Override
    protected String getXMLTestFile() {
        return "GetProviderCreditDetailsRequest.xml";
    }

    @Override
    protected Class<GetProviderCreditDetailsRequest> getTestClassType() {
        return GetProviderCreditDetailsRequest.class;
    }

    @Test
    public void testObjectToXML() throws Exception {
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
