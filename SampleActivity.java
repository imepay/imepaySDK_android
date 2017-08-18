package com.swifttechnology.imepaysample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.swifttechnology.imepaysdk.IMEPayment;
import com.swifttechnology.imepaysdk.IMEPaymentCallback;
import com.swifttechnology.imepaysdk.ENVIRONMENT;

public class SampleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        findViewById(R.id.imepay).setOnClickListener(SampleActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imepay:

                String merchantCode = "TEST";
                String merchantName = "TEST";
                String module = "TEST";
                String username = "TEST";
                String password = "TEST";
                String customer_mobile = "9849999999";
                String reference_value = "Reference Value";
                String amount = "2000.00";
                String merchant_transaction_recording_url = "https://merchantname.com/merchant_transaction_recording_method"

                IMEPayment imePayment = new IMEPayment(this, ENVIRONMENT.TEST);

                imePayment.performPayment(merchantCode,
                        merchantName,
                        merchant_transaction_recording_url,
                        amount,
                        customer_mobile,
                        reference_value,
                        module,
                        username,
                        password,
                        new IMEPaymentCallback() {

                            @Override
                            public void onSuccess(int responseCode,String responseDescription, String transactionId, String msisdn, String amount, String refId) {
                                //Handle Response Code
                            }
                        });

                break;

        }
    }
}
