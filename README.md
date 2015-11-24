### Login and Pay with Amazon Java SDK

Login and Pay with Amazon API Integration


```java
import com.amazon.payments.paywithamazon.Client;
import com.amazon.payments.paywithamazon.impl.PaymentsClient;
import com.amazon.payments.paywithamazon.impl.PaymentsConfig;
```

 Your Login and Pay with Amazon keys are
 available in your Seller Central account

```java
String merchantId = "YOUR_MERCHANT_ID";
String accessKey = "YOUR_ACCESS_KEY";
String secretKey = "YOUR_SECRET_Key";

Config config = new PaymentsConfig()
                .withSellerId(merchantId)
                .withAccessKey(accessKey)
                .withSecretKey(secretKey);

Default currencyCode is USD. To override this, use config.withCurrencyCode(YOUR_CURRENCY_CODE);
Default region is US. For override this, use config.withRegion(YOUR_REGION_CODE);
Default environment is LIVE. For testing in Sandbox mode, use config.withSandboxMode(true);

Client client = new PaymentsClient(config);

```

### Making an API Call

Below is an example on how to make the GetOrderReferenceDetails API call:

```java
import com.amazon.payments.paywithamazon.Client;
import com.amazon.payments.paywithamazon.request.GetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.response.parser.GetOrderReferenceDetailsResponseData;

# These values are grabbed from the Login and Pay
# with Amazon Address and Wallet widgets

GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest = new GetOrderReferenceDetailsRequest("AMAZON_ORDER_REFERENCE_ID");
//optional parameters
getOrderReferenceDetailsRequest.setAddressConsentToken("ADDRESS_CONSENT_TOKEN");

GetOrderReferenceDetailsResponseData response = client.getOrderReferenceDetails( getOrderReferenceDetailsRequest );

```

### API Response Parsing

```java
# This will return the original response body as a String
response.toXML();

# RequestId
response.getRequestId();

# AmazonOrderReferenceId
response.getDetails().getAmazonOrderReferenceId();

# BuyerName
response.getDetails().getBuyer().getBuyerName();

Other data available are buyerEmail, buyerPhone, Destination Address 

```

### One Time Transaction API Flow

```java

# To get the buyers full address if shipping/tax
# calculations are needed you can use the following
# API call to obtain the order reference details.
GetOrderReferenceDetailsRequest req = new GetOrderReferenceDetailsRequest("AMAZON_ORDER_REFERENCE_ID");
req.setAddressConsentToken("ADDRESS_CONSENT_TOKEN");
client.getOrderReferenceDetails( req );

# Make the SetOrderReferenceDetails API call to
# configure the Amazon Order Reference Id.
# There are additional optional parameters that
# are not used below.
//construct request
SetOrderReferenceDetailsRequest setOrderReferenceDetailsRequest = new SetOrderReferenceDetailsRequest("AMAZON_ORDER_REFERENCE_ID" , "ORDER_AMOUNT");

//set optional parameters
setOrderReferenceDetailsRequest.setOrderCurrencyCode("USD");
setOrderReferenceDetailsRequest.setSellerNote("Your Seller Note");
setOrderReferenceDetailsRequest.setSellerOrderId("Your Seller Order Id");
setOrderReferenceDetailsRequest.setStoreName("Your Store Name");

//call API
client.setOrderReferenceDetails( setOrderReferenceDetailsRequest);


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
//Construct Request
AuthorizeRequest authorizeRequest = new AuthorizeRequest("AMAZON_ORDER_REFERENCE_ID" , "Your Unique Id" , "ORDER_AMOUNT");

//Set Optional parameters
authorizeRequest.setAuthorizationCurrencyCode("USD"); //Overrides currency code set in Client
authorizeRequest.setSellerAuthorizationNote("Your Authorization Note");
authorizeRequest.setTransactionTimeout("0"); //Set to 0 for synchronous mode
authorizeRequest.setCaptureNow(true); // Set this to true if you want to capture the amount in the same API call

//Call Authorize API
response = client.authorize( authorizeRequest );

# Make the Capture API call if you did not set the
# 'capture_now' parameter to 'true'. There are
# additional optional parameters that are not used
# below.
//Construct request
CaptureRequest request = new CaptureRequest("AMAZON_AUTHORIZATION_ID" , "YOUR_UNIQUE_ID" , "ORDER_AMOUNT");
//Set optional parameters
request.setCurrencyCode("USD");  //Overrides currency code set in Client
request.setSellerCaptureNote("Your Capture Note"); 

response = client.Capture( request );

# Close the order reference once your one time
# transaction is complete.
client.closeOrderReference("AMAZON_ORDER_REFERENCE_ID");


```

### Subscriptions/Recurring Payments API Flow 

```java
String merchantId = "YOUR_MERCHANT_ID";
String accessKey = "YOUR_ACCESS_KEY";
String secretKey = "YOUR_SECRET_Key";

Config config = new PaymentsConfig()
                .withSellerId(merchantId)
                .withAccessKey(accessKey)
                .withSecretKey(secretKey);

Default currencyCode is USD. To override this, use config.withCurrencyCode(YOUR_CURRENCY_CODE);
Default region is US. For override this, use config.withRegion(YOUR_REGION_CODE);
Default environment is LIVE. For testing in Sandbox mode, use config.withSandboxMode(true);

Client client = new PaymentsClient(config);

# These values are grabbed from the Login and Pay
# with Amazon Address and Wallet widgets
String billingAgreementId = 'AMAZON_BILLING_AGREEMENT_ID'
String addressConsentToken = 'ADDRESS_CONSENT_TOKEN'
GetBillingAgreementDetailsRequest getBillingAgreementDetailsRequest = new GetBillingAgreementDetailsRequest(billingAgreementId).setAddressConsentToken(addressConsentToken);

# Next you will need to set the various details
# for this subscription with the following API call.
# There are additional optional parameters that
# are not used below.
String billingAgreementId = 'AMAZON_BILLING_AGREEMENT_ID';
SetBillingAgreementDetailsRequest setBillingAgreementDetailsRequest = new SetBillingAgreementDetailsRequest(billingAgreementId).setSellerNote("testing");
client.setBillingAgreementDetails(setBillingAgreementDetailsRequest);

# Make the ConfirmBillingAgreement API call to confirm
# the Amazon Billing Agreement Id with the details set above.
# Be sure that everything is set correctly above before
# confirming.
ConfirmBillingAgreementRequest confirmBillingAgreementRequest = new ConfirmBillingAgreementRequest(billingAgreementId);
client.confirmBillingAgreement(confirmBillingAgreementRequest);

# The following API call is not needed at this point, but
# can be used in the future when you need to validate that
# the payment method is still valid with the associated billing
# agreement id.
ValidateBillingAgreementRequest validateBillingAgreementRequest = new ValidateBillingAgreementRequest(billingAgreementId);
client.validateBillingAgreement(validateBillingAgreementRequest);

# Set the amount for your first authorization.
String amount = '10.00';

# Set a unique authorization reference id for your
# first transaction on the billing agreement.
String authorizationReferenceId = "YOUR_UNIQUE_Id";

# Now you can authorize your first transaction on the
# billing agreement id. Every month you can make the
# same API call to continue charging your buyer
# with the 'capture_now' parameter set to true. You can
# also make the Capture API call separately. There are
# additional optional parameters that are not used
# below.
AuthorizeOnBillingAgreementRequest authOnBillingRequest = new AuthorizeOnBillingAgreementRequest(billingAgreementId , authorizationReferenceId , amount);
AuthorizeOnBillingAgreementResponseData response = client.authorizeOnBillingAgreement(authOnBillingRequest);

# You will need the Amazon Authorization Id from the
# AuthorizeOnBillingAgreement API response if you decide
# to make the Capture API call separately.
String amazonAuthorizationId = response.getDetails().getAmazonAuthorizationId();

# Set a unique id for your current capture of
# this transaction.
String captureReferenceId = "YOUR_UNIQUE_Id";

# Make the Capture API call if you did not set the
# 'capture_now' parameter to 'true'. There are
# additional optional parameters that are not used
# below.

# The following API call should not be made until you
# are ready to terminate the billing agreement.
CloseBillingAgreementRequest request = new CloseBillingAgreementRequest(billingAgreementId).setMWSAuthToken(mwsAuthToken);
client.closeBillingAgreement(request);

```
### Get Login Profile API
```java

This API call allows you to obtain user profile information once a user has logged into your application using their Amazon credentials. 

# Your client id is located in your Seller
# Central account.
String clientId = "Your Client Id";

# The access token is available in the return URL
# parameters after a user has logged in.
String accessToken = "User Access Token";

User user = client.getUserInfo(accessToken, clientId);

Below profile information can be retrieved from User object.
user.getName();
user.getEmail();
user.getUserId();

```

### Handling Instant Payment Notifications

```java

# This can be placed in your java application for a method
# that is configured to receive a "POST" IPN from Amazon.
    Map<String,String> headers = IPN_MESSAGE_HEADER
    String body = IPN_MESSAGE_BODY

    Notification notification = NotificationFactory.parseNotification(headers, body);

    NotificationType type = notification.getNotificationType();
        switch (type) {
            case CaptureNotification:
                CaptureNotification cp = (CaptureNotification)notification;
                break;
            case AuthorizationNotification:
                 AuthorizationNotification an = (AuthorizationNotification)notification;
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
                RefundNotification rn = (RefundNotification)notification;
                break;
            case SolutionProviderMerchantNotification:
                SolutionProviderMerchantNotification sp = (SolutionProviderMerchantNotification)notification;
                break;
        }

    To access metadata, call notification.getNotificationMetadata()