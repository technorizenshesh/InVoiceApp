package com.my.invoiceapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.invoiceapp.R;
import com.my.invoiceapp.databinding.ActivityForgotBinding;

public class ForgotActivity extends AppCompatActivity {

    ActivityForgotBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_forgot);


        SetUi();

    }

    private void SetUi() {

        binding.RRBack.setOnClickListener(v -> {

            onBackPressed();

        });

        binding.txtSend.setOnClickListener(v -> {

            startActivity(new Intent(ForgotActivity.this,VerificationActivity.class));

        });
    }
}