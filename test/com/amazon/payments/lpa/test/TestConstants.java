package com.amazon.payments.lpa.test;

public class TestConstants {
    public static final String billingAgreementId = "C01-2603200-6123270";
    public static final String billinAgreementIdDraft ="C01-2603200-6123270";
    public static final String addressConsentToken = "Atza|IQEBLzAtAhUAiXyHC676Cze21Dsxu6MaHFl__g8CFCAQptXbcKibWz40TGHJucQyJ3vSxRxsAQhMXfEs_sUiDEbCzitFf_JajAfFTkr_1mvLmAZ_iDRs0nt4x1oKlSbWZA6FGR001lcSgNRPbb9mJDHOZ52dX5goceIwnduhtzDTr8uzT6_GujSDEas9qKbMySqNUUaUk8oHEFkLjyKcyFPvGuQq06XHARkLhNreuecFrSzOLqT-fOFU4VojIR12kF91BEdvS0pln7o2lzWk58uMCBG8-55hCmVx1WyIFeEkCckoy-TvugLXO_kezekVACXIdBKtnznsn5CSwRHlaTwWIqAkPPs4RTv8RqqAoiiK86LYU5ZMxu4lObFdrh2M6ga0knafK6Ok-NSqmwBTRDURc5zolb1U-9xqh3-qtB0ZNXwkndzTqS1Rk3sHyzXjMLG6NpvDoOJxtlB7Y5jjo8C-qaA";
    public static final String merchantId = "A2K7NDRMCETORTCHANTID";
    public static final String accessKey = "AKIAUIIACAEPPP3A66AA";
    public static final String secretKey = "yoursecretkeyasdfQdstsdf";
    public static final String region = "us";
    public static final String sandbox_mode = "true";
    public static final String timeStamp = "2015-00-00T00:00:00Z";
    public static final String urlEncoded_TimeStamp = "2015-00-00T00%3A00%3A00Z";
    public static final String platformId = "A11WKBU7ADWTAU";
    public static final String MWS_URL = "https://mws.amazonservices.com//OffAmazonPayments_Sandbox/2013-01-01";
    public static final String mwsAuthToken = "amzn.mws.d0e-4e99-9bdb2b381589";
    public static final String sampletext ="testNote";
    public static final String storeName ="TestStore";
    public static final String sellerBillingAgreementId = "A3452";
    public static final String softDescriptor = "AMZNTestTest";
    public static final String amazonOrderReferenceId = "S01-1230123123";
    public static final String Endpoint500 = "https://www.dseteam.net/";
    public static final String providerSellerId = "SVSDFproviderSellerId";
    public static final String providerCreditId = "ADSVproviderCreditId";
    public static final String reversalProviderCreditId = "ADSVproviderReversalCreditId";
    public static final String reversalProviderCreditReferenceId = "ADSVproviderReversalCreditId";
    public static final String reversalProviderAmount = "5";
    public static final String creditReferenceReversalId = "as2q3fasdfa";
    
    public static final String authorizationReferenceId = "AuthReferenceId";
    
    public static final String sampleCaptureNotification = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"        <CaptureNotification xmlns=\"https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01\">\n" +
"            <CaptureDetails>\n" +
"                <AmazonCaptureId>P01-0000000-0000000-000000</AmazonCaptureId>\n" +
"                <CaptureReferenceId>P01-0000000-0000000-000000</CaptureReferenceId>\n" +
"                <CaptureAmount>\n" +
"                    <Amount>0.0</Amount>\n" +
"                    <CurrencyCode>USD</CurrencyCode>\n" +
"                </CaptureAmount>\n" +
"                <RefundedAmount>\n" +
"                    <Amount>0.0</Amount>\n" +
"                    <CurrencyCode>USD</CurrencyCode>\n" +
"                </RefundedAmount>\n" +
"                <CaptureFee>\n" +
"                    <Amount>0.0</Amount>\n" +
"                    <CurrencyCode>USD</CurrencyCode>\n" +
"                </CaptureFee>\n" +
"                <IdList />\n" +
"                <CreationTimestamp>2013-01-01T01:01:01.001Z</CreationTimestamp>\n" +
"                <CaptureStatus>\n" +
"                    <State>Completed</State>    \n" +
"                    <LastUpdateTimestamp>2013-01-01T01:01:01.001Z</LastUpdateTimestamp>\n" +
"                    <ReasonCode>None</ReasonCode>\n" +
"                </CaptureStatus>\n" +
"                <SoftDescriptor>AMZ*softDescriptor</SoftDescriptor>\n" +
"                </CaptureDetails>\n" +
"        </CaptureNotification>";

    public static final String sampleIPNNotification = "{  \"Type\" : \"Notification\",  \"MessageId\" : \"33bd40e3-6a9a-58cf-b6be-0eb9ca6bc4e9\",  \"TopicArn\" : \"arn:aws:sns:us-east-1:291180941288:A3BXB0YN3XH17HA2K7NDRCTOTPW9\",  \"Message\" : \"{\\\"MarketplaceID\\\":\\\"A3BXB0YN3XH17H\\\",\\\"ReleaseEnvironment\\\":\\\"Sandbox\\\",\\\"Version\\\":\\\"2013-01-01\\\",\\\"NotificationType\\\":\\\"PaymentCapture\\\",\\\"SellerId\\\":\\\"A2K7NDRCTOTPW9\\\",\\\"NotificationReferenceId\\\":\\\"1111111-1111-11111-1111-11111EXAMPLE\\\",\\\"IsSample\\\":true,\\\"Timestamp\\\":\\\"2015-08-28T17:47:29.215Z\\\",\\\"NotificationData\\\":\\\"<?xml version=\\\\\\\"1.0\\\\\\\" encoding=\\\\\\\"UTF-8\\\\\\\"?>\\\\n        <CaptureNotification xmlns=\\\\\\\"https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01\\\\\\\">\\\\n            <CaptureDetails>\\\\n                <AmazonCaptureId>P01-0000000-0000000-000000<\\\\/AmazonCaptureId>\\\\n                <CaptureReferenceId>P01-0000000-0000000-000000<\\\\/CaptureReferenceId>\\\\n                <CaptureAmount>\\\\n                    <Amount>0.0<\\\\/Amount>\\\\n                    <CurrencyCode>USD<\\\\/CurrencyCode>\\\\n                <\\\\/CaptureAmount>\\\\n                <RefundedAmount>\\\\n                    <Amount>0.0<\\\\/Amount>\\\\n                    <CurrencyCode>USD<\\\\/CurrencyCode>\\\\n                <\\\\/RefundedAmount>\\\\n                <CaptureFee>\\\\n                    <Amount>0.0<\\\\/Amount>\\\\n                    <CurrencyCode>USD<\\\\/CurrencyCode>\\\\n                <\\\\/CaptureFee>\\\\n                <IdList />\\\\n                <CreationTimestamp>2013-01-01T01:01:01.001Z<\\\\/CreationTimestamp>\\\\n                <CaptureStatus>\\\\n                    <State>Completed<\\\\/State>    \\\\n                    <LastUpdateTimestamp>2013-01-01T01:01:01.001Z<\\\\/LastUpdateTimestamp>\\\\n                    <ReasonCode>None<\\\\/ReasonCode>\\\\n                <\\\\/CaptureStatus>\\\\n                <SoftDescriptor>AMZ*softDescriptor<\\\\/SoftDescriptor>\\\\n                <\\\\/CaptureDetails>\\\\n        <\\\\/CaptureNotification>\\\"}\",  \"Timestamp\" : \"2015-08-28T17:47:29.280Z\",  \"SignatureVersion\" : \"1\",  \"Signature\" : \"eUInUlaydzV4eoOcSKHSyNqt9yFAa1r0kFQz2PxXlNV4Ik04pYRyZlgbXy5NdhzdRzGKwIlPG8QcL2HlNe7nFkKecQapQZYmI7cWpvEslO/xrJgP6jTH5j18Xkk7/lmhV79wgwIWjT7LtbMrc3jC7QNDqwiNcRT694WKpFx1+PFa4BdUd0cUCyPLQrWFcNpS0z8fcaERqO98BUZkkPVfwWA7bQhIwQnxJNVzL9dFxWAhs98W7N89/8yEEg7nz/OK0hr9vfaT0P7ZGCYNsrDlwooGbhtJlhj2aLjfFwR91P7h5cK20nx3eBgN3Nen6BXU1jqnz7plA3QVuygzRIUJmA==\",  \"SigningCertURL\" : \"https://sns.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem\",  \"UnsubscribeURL\" : \"https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-east-1:291180941288:A3BXB0YN3XH17HA2K7NDRCTOTPW9:05542723-375e-4609-98f1-8abcf427d95f\"}";
    
    public static final String GetOrderReferenceDetailsResponse = "<GetOrderReferenceDetailsResponse\n" +
"    xmlns=\"http://mws.amazonservices.com/" + "schema/OffAmazonPayments/2013-01-01\">\n" +
"  <GetOrderReferenceDetailsResult>\n" +
"    <OrderReferenceDetails>\n" +
"      <AmazonOrderReferenceId>P01-1234567-1234567</AmazonOrderReferenceId>\n" +
"      <CreationTimestamp>2012-11-05T20:21:19Z</CreationTimestamp>\n" +
"      <ExpirationTimestamp>2013-05-07T23:21:19Z</ExpirationTimestamp>\n" +
"      <OrderReferenceStatus>\n" +
"        <State>Draft</State>\n" +
"      </OrderReferenceStatus>\n" +
"      <Destination>\n" +
"        <DestinationType>Physical</DestinationType>\n" +
"        <PhysicalDestination>\n" +
"          <City>New York</City>\n" +
"          <StateOrRegion>NY</StateOrRegion>\n" +
"          <PostalCode>10101-9876</PostalCode>\n" +
"          <CountryCode>US</CountryCode>\n" +
"        </PhysicalDestination>\n" +
"      </Destination>\n" +
"      <ReleaseEnvironment>Live</ReleaseEnvironment>\n" +
"    </OrderReferenceDetails>\n" +
"  </GetOrderReferenceDetailsResult>\n" +
"  <ResponseMetadata>\n" +
"    <RequestId>5f20169b-7ab2-11df-bcef-d35615e2b044</RequestId>\n" +
"  </ResponseMetadata>\n" +
"  </GetOrderReferenceDetailsResponse>";

    
    public final static String GetProviderCreditDetailsResponse = "<GetProviderCreditDetailsResponse xmlns=\"http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01\">  <GetProviderCreditDetailsResult>    <ProviderCreditDetails>      <SellerId>A37GX652OWOXVH</SellerId>      <CreditReversalIdList>        <member>S01-2117025-2155793-Q068906</member>        <member>S01-2117025-2155793-Q023847</member>      </CreditReversalIdList>      <CreditReversalAmount>        <CurrencyCode>USD</CurrencyCode>        <Amount>1.00</Amount>      </CreditReversalAmount>      <CreditReferenceId>S01-2117025-2155793nesasdh</CreditReferenceId>      <ProviderId>A2K7NDRCTOTPW9</ProviderId>      <CreationTimestamp>2015-10-23T00:30:42.996Z</CreationTimestamp>      <AmazonProviderCreditId>S01-2117025-2155793-P045170</AmazonProviderCreditId>      <CreditStatus>        <LastUpdateTimestamp>2015-10-26T23:26:46.945Z</LastUpdateTimestamp>        <ReasonCode>MaxAmountReversed</ReasonCode>        <State>Closed</State>      </CreditStatus>      <CreditAmount>        <CurrencyCode>USD</CurrencyCode>        <Amount>1.00</Amount>      </CreditAmount>    </ProviderCreditDetails>  </GetProviderCreditDetailsResult>  <ResponseMetadata>    <RequestId>21162350-7135-46ae-aa20-68d5361cef17</RequestId>  </ResponseMetadata></GetProviderCreditDetailsResponse>";
}
