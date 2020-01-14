[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.amazon.pay/amazon-pay-java-sdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.amazon.pay/amazon-pay-java-sdk)

### Amazon Pay Java SDK

### Requirements

* Amazon Pay - [Register here](https://pay.amazon.com/signup)
* Java 1.6 or higher *(including JCE Java Cryptography Extension)*
* Apache Commons Logging 1.2 *(or JCL-over-SLF4J drop in replacement)*
* Apache Commons Codec 1.10
* Google Gson 2.2.2 or higher *(for GetUserInfo and IPN handling only)*

Amazon Pay API Integration

```java
import com.amazon.pay.Client;
import com.amazon.pay.Config;
import com.amazon.pay.impl.PayClient;
import com.amazon.pay.impl.PayConfig;
```

 Your Amazon Pay keys are
 available in your Seller Central account

```java
String merchantId = "YOUR_MERCHANT_ID";
String accessKey = "YOUR_ACCESS_KEY";
String secretKey = "YOUR_SECRET_KEY";

Config config = new PayConfig()
                .withSellerId(merchantId)
                .withAccessKey(accessKey)
                .withSecretKey(secretKey)
                .withCurrencyCode(CurrencyCode.YOUR_CURRENCY_CODE)
                .withSandboxMode(sandboxMode)
                .withRegion(Region.YOUR_REGION_CODE);

//Default currencyCode is what is set in config file. To override, use below
//config.withCurrencyCode(CurrencyCode.YOUR_CURRENCY_CODE);

//Default region is what is set in config file. To override, use below
//config.withRegion(Region.YOUR_REGION_CODE);

//Default environment is what is set in config file. For testing in Sandbox mode, use
//config.withSandboxMode(true);

Client client = new PayClient(config);

```

### Making an API Call

Below is an example on how to make the GetOrderReferenceDetails API call:

```java
import com.amazon.pay.Client;
import com.amazon.pay.request.GetOrderReferenceDetailsRequest;
import com.amazon.pay.response.parser.GetOrderReferenceDetailsResponseData;

// These values are grabbed from the Amazon Pay Address and Wallet widgets

GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest = new GetOrderReferenceDetailsRequest("AMAZON_ORDER_REFERENCE_ID");
//optional parameters
getOrderReferenceDetailsRequest.setAddressConsentToken("ADDRESS_CONSENT_TOKEN");

GetOrderReferenceDetailsResponseData response = client.getOrderReferenceDetails(getOrderReferenceDetailsRequest);

```

### API Response Parsing

```java
// This will return the original response body as a String
response.toXML();

// RequestId
response.getRequestId();

// AmazonOrderReferenceId
response.getDetails().getAmazonOrderReferenceId();

// BuyerName
response.getDetails().getBuyer().getBuyerName();

Other data available are buyerEmail, buyerPhone, Destination Address 

// For testing/debugging purposes, see all response fields using below
response.toString();

```

### One Time Transaction API Flow

```java

// To get the buyers full address if shipping/tax
// calculations are needed you can use the following
// API call to obtain the order reference details.
GetOrderReferenceDetailsRequest req = new GetOrderReferenceDetailsRequest("AMAZON_ORDER_REFERENCE_ID");
req.setAddressConsentToken("ADDRESS_CONSENT_TOKEN");
client.getOrderReferenceDetails(req);

// Make the SetOrderReferenceDetails API call to
// configure the Amazon Order Reference Id.
// There are additional optional parameters that
// are not used below.
//construct request
SetOrderReferenceDetailsRequest setOrderReferenceDetailsRequest = new SetOrderReferenceDetailsRequest("AMAZON_ORDER_REFERENCE_ID" , "ORDER_AMOUNT");

//set optional parameters
setOrderReferenceDetailsRequest.setOrderCurrencyCode(CurrencyCode.YOUR_CURRENCY_CODE);
setOrderReferenceDetailsRequest.setSellerNote("YOUR_SELLER_NOTE");
setOrderReferenceDetailsRequest.setSellerOrderId("YOUR_SELLER_ORDER_ID");
setOrderReferenceDetailsRequest.setStoreName("YOUR_STORE_NAME");

//call API
client.setOrderReferenceDetails(setOrderReferenceDetailsRequest);


// Make the ConfirmOrderReference API call to
// confirm the details set in the API call
// above.
client.confirmOrderReference("AMAZON_ORDER_REFERENCE_ID");

// Set a unique id for your current authorization
// of this payment.

// Make the Authorize API call to authorize the
// transaction. You can also capture the amount
// in this API call or make the Capture API call
// separately. There are additional optional
// parameters not used below.
//Construct Request
AuthorizeRequest authorizeRequest = new AuthorizeRequest("AMAZON_ORDER_REFERENCE_ID" , "YOUR_UNIQUE_ID" , "ORDER_AMOUNT");

//Set Optional parameters
authorizeRequest.setAuthorizationCurrencyCode(CurrencyCode.YOUR_CURRENCY_CODE); //Overrides currency code set in Client
authorizeRequest.setSellerAuthorizationNote("Your Authorization Note");
authorizeRequest.setTransactionTimeout("0"); //Set to 0 for synchronous mode
authorizeRequest.setCaptureNow(true); // Set this to true if you want to capture the amount in the same API call

//Call Authorize API
AuthorizeResponseData response = client.authorize(authorizeRequest);

// Make the Capture API call if you did not set the
// 'capture_now' parameter to 'true'. There are
// additional optional parameters that are not used below.

//Construct request
CaptureRequest request = new CaptureRequest("AMAZON_AUTHORIZATION_ID" , "YOUR_UNIQUE_ID" , "ORDER_AMOUNT");
//Set optional parameters
request.setCaptureCurrencyCode(CurrencyCode.YOUR_CURRENCY_CODE);  //Overrides currency code set in Client
request.setSellerCaptureNote("YOUR_CAPTURE_NOTE");

CaptureResponseData response = client.capture(request);

// Close the order reference once your one time
// transaction is complete.
client.closeOrderReference(new CloseOrderReferenceRequest("AMAZON_ORDER_REFERENCE_ID"));


```

### Subscriptions/Recurring Payments API Flow

```java
String merchantId = "YOUR_MERCHANT_ID";
String accessKey = "YOUR_ACCESS_KEY";
String secretKey = "YOUR_SECRET_KEY";

Config config = new PayConfig()
                .withSellerId(merchantId)
                .withAccessKey(accessKey)
                .withSecretKey(secretKey);

Default currencyCode is what is set in config file. To override this, use config.withCurrencyCode(CurrencyCode.YOUR_CURRENCY_CODE);
Default region is what is set in config file. For override this, use config.withRegion(Region.YOUR_REGION);
Default environment is what is set in config file. For testing in Sandbox mode, use config.withSandboxMode(true);

Client client = new PayClient(config);

// These values are grabbed from the Amazon Pay
// Address and Wallet widgets
String billingAgreementId = "AMAZON_BILLING_AGREEMENT_ID";
String addressConsentToken = "ADDRESS_CONSENT_TOKEN";
GetBillingAgreementDetailsRequest getBillingAgreementDetailsRequest = new GetBillingAgreementDetailsRequest(billingAgreementId).setAddressConsentToken(addressConsentToken);

// Next you will need to set the various details
// for this subscription with the following API call.
// There are additional optional parameters that
// are not used below.
String billingAgreementId = "AMAZON_BILLING_AGREEMENT_ID";
SetBillingAgreementDetailsRequest setBillingAgreementDetailsRequest = new SetBillingAgreementDetailsRequest(billingAgreementId).setSellerNote("testing");
client.setBillingAgreementDetails(setBillingAgreementDetailsRequest);

// Make the ConfirmBillingAgreement API call to confirm
// the Amazon Billing Agreement Id with the details set above.
// Be sure that everything is set correctly above before
// confirming.
ConfirmBillingAgreementRequest confirmBillingAgreementRequest = new ConfirmBillingAgreementRequest(billingAgreementId);
client.confirmBillingAgreement(confirmBillingAgreementRequest);

// The following API call is not needed at this point, but
// can be used in the future when you need to validate that
// the payment method is still valid with the associated billing
// agreement id.
ValidateBillingAgreementRequest validateBillingAgreementRequest = new ValidateBillingAgreementRequest(billingAgreementId);
client.validateBillingAgreement(validateBillingAgreementRequest);

// Set the amount for your first authorization.
String amount = "10.00";

// Set a unique authorization reference id for your
// first transaction on the billing agreement.
String authorizationReferenceId = "YOUR_UNIQUE_Id";

// Now you can authorize your first transaction on the
// billing agreement id. Every month you can make the
// same API call to continue charging your buyer
// with the 'capture_now' parameter set to true. You can
// also make the Capture API call separately. There are
// additional optional parameters that are not used
// below.
AuthorizeOnBillingAgreementRequest authOnBillingRequest = new AuthorizeOnBillingAgreementRequest(billingAgreementId , authorizationReferenceId , amount);
AuthorizeOnBillingAgreementResponseData response = client.authorizeOnBillingAgreement(authOnBillingRequest);

// You will need the Amazon Authorization Id from the
// AuthorizeOnBillingAgreement API response if you decide
// to make the Capture API call separately.
String amazonAuthorizationId = response.getDetails().getAmazonAuthorizationId();

// Set a unique id for your current capture of
// this transaction.
String captureReferenceId = "YOUR_UNIQUE_ID";

// Make the Capture API call if you did not set the
// 'capture_now' parameter to 'true'. There are
// additional optional parameters that are not used
// below.

// The following API call should not be made until you
// are ready to terminate the billing agreement.
CloseBillingAgreementRequest request = new CloseBillingAgreementRequest(billingAgreementId).setMWSAuthToken(mwsAuthToken);
client.closeBillingAgreement(request);

```
### Get Login Profile API
```java

// This API call allows you to obtain user profile information once a user has logged into your application using their Amazon credentials. 

// Your client id is located in your Seller Central account.
String clientId = "YOUR_CLIENT_ID";

// The access token is available in the return URL parameters after a user has logged in.
String accessToken = "USER_ACCESS_TOKEN";

User user = client.getUserInfo(accessToken, clientId);

// Below profile information can be retrieved from User object.
user.getName();
user.getEmail();
user.getUserId();

```

### Handling Instant Payment Notifications

```java

    /** 
    * This can be placed in your java application for a method
    * that is configured to receive a "POST" IPN from Amazon.
    **/
    Map<String,String> headers = IPN_MESSAGE_HEADER
    String body = IPN_MESSAGE_BODY

    Notification notification = NotificationFactory.parseNotification(headers, body);
    
    //To view received notification JSON body
    notification.toJSON(); //We recommend to log this value for debugging purposes

    //Determine the notification type
    NotificationType type = notification.getNotificationType();
	
	//Retrieve notification object based on type
        switch (type) {
            case CaptureNotification:
                CaptureNotification cn = (CaptureNotification)notification;
                //To access capture details like captureId, captureAmount etc. 
                cn.getCaptureDetails().getAmazonCaptureId();
                break;
            case AuthorizationNotification:
                 AuthorizationNotification an = (AuthorizationNotification)notification;
                 //To access authorizationDetails like authorizationReferenceId, authorizationAmount etc..
                 an.getAuthorizationDetails().getAmazonAuthorizationId();
                 break;
            case BillingAgreementNotification:
                BillingAgreementNotification bn = (BillingAgreementNotification)notification;
                break;
            case OrderReferenceNotification:
                OrderReferenceNotification on = (OrderReferenceNotification)notification;
                break;
            case ProviderCreditNotification:
                ProviderCreditNotification pc = (ProviderCreditNotification)notification;
                break;
            case ProviderCreditReversalNotification:
                ProviderCreditReversalNotification pcrn = (ProviderCreditReversalNotification)notification;
                break;
            case RefundNotification:
                RefundNotification refundNotification = (RefundNotification)notification;
                break;
            case SolutionProviderMerchantNotification:
                SolutionProviderMerchantNotification sp = (SolutionProviderMerchantNotification)notification;
                break;
        }

    //To access metadata 
    notification.getNotificationMetadata();

    //To view original notification body
    notification.toJSON(); or notification.toMap();

```


### Adding Logging

Below are the steps to turn on the logging feature for your project.

- Select a logging framework to use for your project.
- Set the Logger instance 'log' in PayLogUtil to the value of the logging framework.

```java
    private static Logger log = Logger.getLogger(PayLogUtil.class);
```
- logMessage is called from 3 different places
    * NotificationFactory.java that logs Headers and Notification Body
    * RequestHelper.java logs Client Parameters
    * ResponseData.java logs all the response data (GetOrderReferenceDetails,GetAuthorizationDetails, etc.)
- Add log4j.properties file containing the below properties. (You may change as per your requirements)

```java
// Root logger option
log4j.rootLogger=DEBUG, stdout, file

// Redirect log messages to console
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

// Redirect log messages to a log file, support file rolling.
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=C:\\log4j-application.log
log4j.appender.file.MaxFileSize=5MB
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
```

### Convenience Method Workflow

This API allows you to make one API call 'getPaymentDetails' to retrieve OrderReference, Authorize, Capture and Refund Details.

```java
//Call GetPaymentDetails API
GetPaymentDetails response = client.getPaymentDetails("AMAZON_ORDER_REFERENCE_ID");
//Order Reference Details
response.getOrderReferenceDetails().getBillingAddress();
response.getOrderReferenceDetails().getRequestPaymentAuthorization();
//Authorize Details
response.getAuthorizationDetails().get("AMAZON_AUTHORIZATION_ID").getCapturedAmount();
response.getAuthorizationDetails().get("AMAZON_AUTHORIZATION_ID").getAuthorizationStatus();
//Capture Details
response.getCaptureDetails().get("AMAZON_CAPTURE_ID").getCaptureAmount();
response.getCaptureDetails().get("AMAZON_CAPTURE_ID").getCaptureStatus();
//Refund Details
response.getRefundDetails().get("AMAZON_REFUND_ID").getFeeRefunded();
response.getRefundDetails().get("AMAZON_REFUND_ID").getRefundStatus();
```

### Retrieving Payment Descriptor in GetOrderReferenceDetails call

This feature allows you to retrieve Payment Descriptor in the GetOrderReferenceDetails call.
Steps to follow to retrieve payment Descriptor as are below -

1. Your Amazon Pay Client ID (amzn1.xxxxxxx) needs to be whitelisted with the “payments:instrument_descriptor” scope.
Please contact Amazon Pay Support for whitelisting your Client ID.
2. Add the “payments:instrument_descriptor” scope to your (test) site button.
3. Pass the obtained “access_token” and Order Reference ID’s to the GetOrderReferenceDetails request.

```java
GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest = new GetOrderReferenceDetailsRequest("AMAZON_ORDER_REFERENCE_ID");
getOrderReferenceDetailsRequest.setAccessToken(ACCESS_TOKEN);
GetOrderReferenceDetailsResponseData response = client.getOrderReferenceDetails(getOrderReferenceDetailsRequest);

log.info("OrderReferenceID = " + response.getDetails().getAmazonOrderReferenceId());
log.info("Buyer = " + response.getDetails().getBuyer());

PaymentDescriptor paymentDescriptor = response.getDetails().getPaymentDescriptor();
if (paymentDescriptor != null) {
        log.info("Full Descriptor = " + paymentDescriptor.getFullDescriptor());
        log.info("Use Amazon Balance First = " + paymentDescriptor.isUseAmazonBalanceFirst());
}
```

### Retrieving orders with seller order id
1. ListOrderReference
This API provides a list of orders corresponding to a particular seller order id.

```java
EnumSet<OrderReferenceStatus> filter = EnumSet.of(OrderReferenceStatus.OPEN, OrderReferenceStatus.CANCELED);
XMLGregorianCalendar startTime =
                DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-09-27T07:00:00Z");
XMLGregorianCalendar endTime =
                DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-09-30T07:00:00Z");

ListOrderReferenceRequest listOrderReferenceRequest =
        new ListOrderReferenceRequest("YOUR_SELLER_ORDER_ID", "SellerOrderId");
// optional parameters
listOrderReferenceRequest.setMWSAuthToken("YOUR_MWS_AUTH_TOKEN");
listOrderReferenceRequest.setStartTime(startTime);
listOrderReferenceRequest.setEndTime(endTime);
listOrderReferenceRequest.setPageSize(5);
listOrderReferenceRequest.setOrderReferenceStatusListFilter(filter);
listOrderReferenceRequest.setSortOrder(SortOrder.Ascending); //sort order can be ascending or descending

ListOrderReferenceResponseData response = client.listOrderReference(listOrderReferenceRequest);
String nextPageToken = response.getNextPageToken(); //to be used in the ListOrderReferenceByNextToken call
```
2. ListOrderReferenceByNextToken
This API returns a list of the continued orders from the previous call (ListOrderReference) using a NextPageToken value to render the next page of data, if a page size was used to split the list of orders into multiple pages.

```java
ListOrderReferenceByNextTokenRequest listOrderReferenceByNextTokenRequest = new ListOrderReferenceByNextTokenRequest(nextPageToken); //nextPageToken is derived from the ListOrderReference response explained above
//optional parameters
listOrderReferenceByNextTokenRequest.setMWSAuthToken("YOUR_MWS_AUTH_TOKEN");

ListOrderReferenceByNextTokenResponseData response =
   client.listOrderReferenceByNextToken(listOrderReferenceByNextTokenRequest);
```

### Get Merchant Account Status API
The GetMerchantAccountStatus operation is used to query the status of a particular merchant account and to retrieve information if the account is active or inactive.

```java
import com.amazon.pay.response.model.AccountStatus;
import com.amazon.pay.response.parser.GetMerchantAccountStatusResponseData;
import com.amazon.pay.request.GetMerchantAccountStatusRequest;
...

// To check the status of your merchant account
final GetMerchantAccountStatusResponseData response = client.getMerchantAccountStatus();
final AccountStatus accountStatus = response.getAccountStatus();

if (accountStatus.equals(AccountStatus.ACTIVE)) {
    System.out.println("Merchant account is enabled");
} else if (accountStatus.equals(AccountStatus.INACTIVE)) {
    System.out.println("Merchant account is disabled");
}

// Or using MWS delegation to check on the status of another merchant account
final GetMerchantAccountStatusRequest request = new GetMerchantAccountStatusRequest();
request.setSellerId("REPLACE_WITH_OTHER_MERCHANT_ID");
request.setMWSAuthToken("REPLACE_WITH_MWS_AUTH_TOKEN");

final GetMerchantAccountStatusResponseData resp = client.getMerchantAccountStatus(request);
final AccountStatus status = resp.getAccountStatus();

if (status.equals(AccountStatus.ACTIVE)) {
    System.out.println("Child merchant account is enabled");
} else if (status.equals(AccountStatus.INACTIVE)) {
    System.out.println("Child merchant account is disabled");
}
```
