package com.amazonservices.mws.offamazonpayments.common;

import com.amazonservices.mws.offamazonpayments.model.Error;
import com.amazonservices.mws.offamazonpayments.model.ReleaseEnvironment;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static com.amazonservices.mws.offamazonpayments.common.TestConstants.TEST_FIELD_NAME;
import static org.junit.Assert.*;

public class JSONFragmentBuilderTest {

    private static final String EXPECTED_VALUE_SINGLE_FIELD_FMT = "\"" + TEST_FIELD_NAME +"\" : \"%s\"";

    private JSONFragmentBuilder jsonFragmentBuilder;

    @Before
    public void setUp() {
        jsonFragmentBuilder = new JSONFragmentBuilder();
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
        Error err1 = new Error();
        err1.setCode("12");

        Error err2 = new Error();
        err2.setCode("13");

        List<Error> values =Arrays.asList(err1, err2);
        jsonFragmentBuilder.addCollectionHeader("Error");
        for (Error v : values) {
            jsonFragmentBuilder.addCollectionValue("Error", v);
        }
        jsonFragmentBuilder.closeCollectionHeader("Error");

        String value = jsonFragmentBuilder.build();

        String expectedValue = "\"Error\" : [{\"Code\" : \"12\"}, {\"Code\" : \"13\"}]";
        assertEquals(value, expectedValue);
    }

    private void validateTypeReturnsString(Object object) throws Exception {
        jsonFragmentBuilder.addFieldToFragmentIfSet(TEST_FIELD_NAME, object);

        String value = jsonFragmentBuilder.build();

        assertEquals(value, String.format(EXPECTED_VALUE_SINGLE_FIELD_FMT, object.toString()));
    }

}