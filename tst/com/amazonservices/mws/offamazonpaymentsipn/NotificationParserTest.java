package com.amazonservices.mws.offamazonpaymentsipn;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.common.OffAmazonPaymentsServiceConfigBuilder;
import com.amazonservices.mws.offamazonpaymentsipn.cache.ICache;
import com.amazonservices.mws.offamazonpaymentsipn.notifications.INotification;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.IpnNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.SnsNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.XmlNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.validators.SnsMessageValidator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class NotificationParserTest {

    private static final String TEST_HEADER = "testHeader";
    private static final String TEST_HEADER_VALUE = "testValue";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String MOCK_BODY = "This is a sample value " + NEW_LINE + "over two lines";
    private static final String EXPECTED_MOCK_BODY = MOCK_BODY.replace(NEW_LINE, "");

    private SnsMessageValidator snsMessageValidator;
    private NotificationParser notificatonParser;
    private SnsNotificationParser snsNotificationParser;
    private IpnNotificationParser ipnNotificationParser;
    private XmlNotificationParser xmlNotificationParser;

    @Before
    public void setUp() {
        this.snsMessageValidator = mock(SnsMessageValidator.class);
        this.snsNotificationParser = mock(SnsNotificationParser.class);
        this.ipnNotificationParser = mock(IpnNotificationParser.class);
        this.xmlNotificationParser = mock(XmlNotificationParser.class);

        this.notificatonParser = new NotificationParser(snsNotificationParser,
                snsMessageValidator, ipnNotificationParser, xmlNotificationParser);
    }

    @Test
    public void shouldCreateInstanceOfValidatorWithDefaultCacheAndProperties() {
        OffAmazonPaymentsServiceConfig config = new OffAmazonPaymentsServiceConfigBuilder().withDefaults().build();

        NotificationParser notificatonParser= new NotificationParser(config);

        assertNotNull(notificatonParser);
    }

    @Test
    public void shouldCreateInstanceOfValidatorWithCustomCacheAndProperties() {
        ICache cache = mock(ICache.class);
        OffAmazonPaymentsServiceConfig config = new OffAmazonPaymentsServiceConfigBuilder().withDefaults().build();

        NotificationParser notificatonParser = new NotificationParser(cache, config);

        assertNotNull(notificatonParser);
    }

    @Test
    public void shouldParseRawMessageFromHeadersAndBodyIfNoUnderlyingExceptionIsThrown() throws Exception {
        Map<String,String> headers = new HashMap<String, String>();
        String body = new String();

        INotification expected = setupMocksForMessageParsing(headers, body);

        INotification result = notificatonParser.parseRawMessage(headers, body);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldParseRawMessageFromHttpServletRequestAndStripNewLinesIfNoUnderlyingExceptionIsThrown() throws Exception {
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        Vector<String> headers = new Vector<String>(Arrays.asList(TEST_HEADER));
        Map<String, String> expectedHeaders = new HashMap<String, String>();
        expectedHeaders.put(TEST_HEADER, TEST_HEADER_VALUE);

        given(mockRequest.getHeaderNames()).willReturn(headers.elements());
        given(mockRequest.getHeader(TEST_HEADER)).willReturn(TEST_HEADER_VALUE);
        given(mockRequest.getReader()).willReturn(new BufferedReader(new StringReader(MOCK_BODY)));

        INotification expected = setupMocksForMessageParsing(expectedHeaders, EXPECTED_MOCK_BODY);

        INotification result = notificatonParser.parseRawMessage(mockRequest);

        Assert.assertEquals(expected, result);
    }

    private INotification setupMocksForMessageParsing(Map<String, String> headers, String body) throws NotificationsException {
        Message snsMessage = mock(Message.class);
        Message ipnMessage = mock(Message.class);
        INotification expected = mock(INotification.class);

        given(this.snsNotificationParser.parseNotification(headers, body)).willReturn(snsMessage);
        given(this.ipnNotificationParser.parseSnsMessage(snsMessage)).willReturn(ipnMessage);
        given(this.xmlNotificationParser.parseIpnMessage(ipnMessage)).willReturn(expected);
        return expected;
    }
}