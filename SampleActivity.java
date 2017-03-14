package com.swifttechnology.imepaysample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.swifttechnology.imepaysdk.IMEPayment;
import com.swifttechnology.imepaysdk.IMEPaymentCallback;
import com.swifttechnology.imepaysdk.PLATFORM;

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

                IMEPayment imePayment = new IMEPayment(this, PLATFORM.TEST);

                imePayment.performPayment(merchantCode,
                        merchantName,
                        amount,
                        customer_mobile,
                        reference_value,
                        module,
                        username,
                        password,
                        new IMEPaymentCallback() {

                            @Override
                            public void onSuccess(int i) {
                                //Handle Response Code
                            }
                        });

                break;

        }
    }
}
