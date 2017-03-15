# IME PAY : ANDROID MERCHANT PAYMENT SDK

Receive payment from your customer through IME pay.

Overview
--------

1. Introduction
2. SDK Feature
3. SDK Initialization
  * Authenticate Merchant
  * Get Transaction Token
  * Perform Payment
  * Validate Payment
4. Response Codes
5. Sample Code

Introduction
------------

The IME Pay Payment SDK for Android gives access to merchants to receive payment from IME Pay customers through their native android application.

SDK Features
------------
IME pay Android Merchant Payment SDK enables merchants to receive payments from IME pay customes through their native application. The application performs the payment and verifies the transaction status.

SDK Initialization 
------------------
1. Add ime-pay-sdk-vx.x.aar file dependency to your project. 
2. In your activity create an instance for IMEPayment.

```java
IMEPayment imePayment = new IMEPayment(activity.this, PLATFORM.LIVE);
```

Note : Use PLATFORM.TEST for test purposes.

Authenticate Merchant / Get Transaction Token
---------------------------------------------

The merchant is verified using the merchant code, merchant username, merchant password, module which will be provided by the IME pay Developer Support to applicable merchants. 

Perform Payment
---------------

This SDK enables merchants to receive payments through IME pay, using the instance of IMEPayment call the method performpayment().

```java
IMEPayment imePayment = new IMEPayment(activity.this, PLATFORM.LIVE);

imePayment.performPayment(“MERCHANT_CODE”, 
                          “MERCHANT_NAME", 
                          "AMOUNT",
                          "CUSTOMER_MOBILENUMBER",
                          "REFERENCE_ID", 
                          "MODULE",
                          "USERNAME",
                          "PASSWORD",
                          new IMEPaymentCallback() {
           @Override
           public void onSuccess(int ResponseCode) {
              // 100 : Transaction successful.
              // 101 : Transaction failed. 
           }
});
```

Validate Payment
----------------
After performing payment the SDK will verify the payment. This feature is handled by the SDK itself. On the basis of the validate payment response the developer will get a response in IMEPaymentCallback(). There are two types of responses that a developer can get in IMEPaymentCallback 

* Response Code 100 : 
  Payment was successfully executed and verified.

* Response Code 101 : 
  Payment was successfully executed and but could not get verified. The customer executing the payment will get an SMS for the confirmation.

Response Codes
--------------
These response codes mentioned below are handled by the SDK itself.

* 403 : Application unauthorized to use the service.
* 500 : Your request cannot be processed at the moment
* 401 : Application request cannot be processed at the moment

Sample Code
-----------

[ Click here for Sample Code ](https://github.com/imepay/imepaySDK_android/blob/master/SampleActivity.java)
