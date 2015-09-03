Login and Pay with Amazon Java SDK

Login and Pay with Amazon API Integration


```java
import PayWithAmazon.Client;
```

 Your Login and Pay with Amazon keys are
 available in your Seller Central account

```java
String merchantId = "YOUR_MERCHANT_ID";
String accessKey = "YOUR_ACCESS_KEY";
String secretKey = "YOUR_SECRET_Key";
String regionCode = "na"; 
boolean sandboxMode = false;

Client client = new Client(merchantId , accessKey, secretKey, regionCode, sandboxMode);
```

### Making an API Call

Below is an example on how to make the GetOrderReferenceDetails API call:

```java
import PayWithAmazon.Client;
import PayWithAmazon.Request.GetOrderReferenceDetailsRequest;

# Your Login and Pay with Amazon keys are
# available in your Seller Central account
String merchantId = 'YOUR_MERCHANT_ID'
String accessKey = 'YOUR_ACCESS_KEY'
String secretKey = "YOUR_SECRET_Key";
String regionCode = "na"; 
boolean sandboxMode = false;

Client client = new Client(merchantId , accessKey, secretKey, regionCode, sandboxMode);

# These values are grabbed from the Login and Pay
# with Amazon Address and Wallet widgets
GetOrderReferenceDetailsRequest req = new GetOrderReferenceDetailsRequest();
req.setAmazonOrderReferenceId("AMAZON_ORDER_REFERENCE_ID");

client.getOrderReferenceDetails( req );

```

### Response Parsing

```java
# These values are grabbed from the Login and Pay
# with Amazon Address and Wallet widgets

response = client.getOrderReferenceDetails( req );

# This will return the original response body as a String
response.getXmlAsString();

# This will return the status code of the response
response.getStatusCode();
```

### Instant Payment Notification Verification and Parsing

```java
# This can be placed in your application for a method
# that is configured to receive a "POST" IPN from Amazon.

Scanner scan = new Scanner(request.getInputStream());
        StringBuilder builder = new StringBuilder();
        while (scan.hasNextLine()) {
            builder.append(scan.nextLine());
        }
              
IPNHandler ipn = new IPNHandler(builder.toString());

# This will return "true" if the notification is a  
# valid IPN from Amazon
ipn.isNotificationValid();

# The following are methods used to extract the necessary
# data from the IPN
ipn.getType();
ipn.getMessageId();
ipn.getTopicArn();
ipn.getMessage();
ipn.getTimeStamp();
ipn.getSignature();
ipn.getSignatureVersion();
ipn.getSigningCertUrl();
ipn.getUnsubscribeUrl();
ipn.getNotificationType;
ipn.getSellerId();
ipn.getEnvironment();
ipn.getVersion();
ipn.getNotificationData();
ipn.getMessageTimestamp();

```

### One Time Transaction API Flow

```java
import PayWithAmazon.Client;
import PayWithAmazon.Request.*;

# Your Login and Pay with Amazon keys are
# available in your Seller Central account
String merchantId = 'YOUR_MERCHANT_ID'
String accessKey = 'YOUR_ACCESS_KEY'
String secretKey = "YOUR_SECRET_Key";
String regionCode = "na"; 
boolean sandboxMode = false;

Client client = new Client(merchantId , accessKey, secretKey, regionCode, sandboxMode);

# These values are grabbed from the Login and Pay
# with Amazon Address and Wallet widgets
amazon_order_reference_id = 'AMAZON_ORDER_REFERENCE_ID'
address_consent_token = 'ADDRESS_CONSENT_TOKEN'

# To get the buyers full address if shipping/tax
# calculations are needed you can use the following
# API call to obtain the order reference details.
GetOrderReferenceDetailsRequest req = new GetOrderReferenceDetailsRequest();
req.setAmazonOrderReferenceId("AMAZON_ORDER_REFERENCE_ID");
req.setAddressConsentToken("ADDRESS_CONSENT_TOKEN");

client.getOrderReferenceDetails( req );

# Make the SetOrderReferenceDetails API call to
# configure the Amazon Order Reference Id.
# There are additional optional parameters that
# are not used below.
SetOrderReferenceDetailsRequest request = new SetOrderReferenceDetailsRequest();
request.setAmazonOrderReferenceId("AMAZON_ORDER_REFERENCE_ID");
request.setOrderAmount("10");
request.setOrderCurrencyCode("USD");
request.setSellerNote("Your Seller Note");
request.setSellerOrderId("Your Seller Order Id");
request.setStoreName("Your Store Name");

client.setOrderReferenceDetails( request);


# Make the ConfirmOrderReference API call to
# confirm the details set in the API call
# above.
client.confirmOrderReference("AMAZON_ORDER_REFERENCE_ID");

# Set a unique id for your current authorization
# of this payment.

# Make the Authorize API call to authorize the
# transaction. You can also capture the amount
# in this API call or make the Capture API call
# separately. There are additional optional
# parameters not used below.
AuthorizeRequest request = new AuthorizeRequest();
request.setAmazonOrderReferenceId("AMAZON_ORDER_REFERENCE_ID");
request.setAuthorizationReferenceId("Your Unique Id");
request.setAuthorizationAmount("1");
request.setAuthorizationCurrencyCode("USD"); //Defaults to USD.
request.setSellerAuthorizationNote("Your Authorization Note");
request.setTransactionTimeout("0"); //Set to 0 for synchronous mode
request.setCaptureNow("true"); // Set this to true if you want to capture the amount in the same API call
response = client.authorize( request);

# Make the Capture API call if you did not set the
# 'capture_now' parameter to 'true'. There are
# additional optional parameters that are not used
# below.
CaptureRequest request = new CaptureRequest();
request.setAmazonAuthorizationId("Your Unique Id");
request.setCaptureReferenceId("Your Unique Id");
request.setCaptureAmount("1");
request.setCurrencyCode("USD"); //Default: USD
request.setSellerCaptureNote("Your Capture Note"); 

client.Capture( request );

# Close the order reference once your one time
# transaction is complete.
client.closeOrderReference("AMAZON_ORDER_REFERENCE_ID");

```



