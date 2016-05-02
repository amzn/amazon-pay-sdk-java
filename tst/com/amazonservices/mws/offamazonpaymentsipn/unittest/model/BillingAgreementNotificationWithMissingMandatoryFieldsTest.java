package com.amazonservices.mws.offamazonpaymentsipn.unittest.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.model.BillingAgreementNotification;

public class BillingAgreementNotificationWithMissingMandatoryFieldsTest extends IpnModelTest<BillingAgreementNotification> {

    @Override
    protected String getXMLTestFile() {
        return "BillingAgreementNotificationWithMissingMandatoryFields.xml";
    }

    @Override
    protected Class<BillingAgreementNotification> getTestClassType() {
        return BillingAgreementNotification.class;
    }

    @Test
    public void testObjectToXML() throws Exception {
        String expectedException = "Value for amazonBillingAgreementId in com.amazonservices.mws.offamazonpaymentsipn.model.BillingAgreement is NULL";
        try {
            testForNull();
            fail();
        } catch (AssertionError e) {
            assertEquals(expectedException, e.getMessage());
        }
    }

    @Test
    public void testXMLToObject() throws Exception {
        testSchema();
    }
}
