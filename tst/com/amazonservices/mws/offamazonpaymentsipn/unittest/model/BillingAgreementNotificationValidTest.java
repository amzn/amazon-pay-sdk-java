package com.amazonservices.mws.offamazonpaymentsipn.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.model.BillingAgreementNotification;

import static junit.framework.Assert.assertNotNull;

public class BillingAgreementNotificationValidTest extends IpnModelTest<BillingAgreementNotification> {

    @Override
    protected String getXMLTestFile() {
        return "BillingAgreementNotificationValid.xml";
    }

    @Override
    protected Class<BillingAgreementNotification> getTestClassType() {
        return BillingAgreementNotification.class;
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
    public void toXMLShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String xmlFragment = getTestClassObject().toXMLFragment();

        assertNotNull(xmlFragment);
    }

    @Test
    public void toJSONShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String jsonFragment = getTestClassObject().toJSONFragment();

        assertNotNull(jsonFragment);
    }
}
