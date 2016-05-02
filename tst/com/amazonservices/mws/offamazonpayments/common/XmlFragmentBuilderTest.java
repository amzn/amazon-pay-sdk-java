package com.amazonservices.mws.offamazonpayments.common;

import com.amazonservices.mws.offamazonpayments.model.Error;
import com.amazonservices.mws.offamazonpayments.model.ReleaseEnvironment;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.DatatypeFactory;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static com.amazonservices.mws.offamazonpayments.common.TestConstants.TEST_FIELD_NAME;
import static org.junit.Assert.*;

public class XmlFragmentBuilderTest {

    private static final String EXPECTED_VALUE_SINGLE_FIELD_FMT
            = "<" + TEST_FIELD_NAME +">%s</" + TEST_FIELD_NAME + ">";

    private XmlFragmentBuilder xmlFragmentBuilder;

    @Before
    public void setUp() {
        xmlFragmentBuilder = new XmlFragmentBuilder();
    }

    @Test
    public void shouldPrintStringValueForIntegerType() throws Exception {
        validateTypeReturnsString(Integer.valueOf(5));
    }

    @Test
    public void shouldPrintStringValueForBooleanType() throws Exception {
        validateTypeReturnsString(Boolean.TRUE);
    }

    @Test
    public void shouldPrintStringValueForStringType() throws Exception {
        validateTypeReturnsString(String.valueOf("Test"));
    }

    @Test
     public void shouldPrintStringValueForXmlGregorianCalender() throws Exception {
        GregorianCalendar c = new GregorianCalendar();
        validateTypeReturnsString(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
    }

    @Test
    public void shouldPrintStringValueForEnumValue() throws Exception {
        validateTypeReturnsString(ReleaseEnvironment.LIVE);
    }

    @Test
    public void shouldPrintStringValueForErrorDetailObject() throws Exception {
        validateTypeReturnsString(new Error.Detail());
    }

    @Test
    public void shouldPrintArrayValuesCorrectly() throws Exception {
        com.amazonservices.mws.offamazonpayments.model.Error err1 = new Error();
        err1.setCode("12");

        Error err2 = new Error();
        err2.setCode("13");

        List<Error> values = Arrays.asList(err1, err2);
        xmlFragmentBuilder.addCollectionHeader("Error");
        for (Error v : values) {
            xmlFragmentBuilder.addCollectionValue("Error", v);
        }
        xmlFragmentBuilder.closeCollectionHeader("Error");

        String value = xmlFragmentBuilder.build();

        String expectedValue = "<Error><Code>12</Code></Error><Error><Code>13</Code></Error>";
        assertEquals(value, expectedValue);
    }

    private void validateTypeReturnsString(Object object) throws Exception {
        xmlFragmentBuilder.addFieldToFragmentIfSet(TEST_FIELD_NAME, object);

        String value = xmlFragmentBuilder.build();

        assertEquals(value, String.format(EXPECTED_VALUE_SINGLE_FIELD_FMT, object.toString()));
    }

}