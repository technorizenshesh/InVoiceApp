package com.my.invoiceapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.invoiceapp.R;
import com.my.invoiceapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);


         Setup();
    }

    private void Setup() {

        binding.RRSignUp.setOnClickListener(v -> {

            startActivity(new Intent(LoginActivity.this,SignUpActivity.class));

        });

        binding.loginID.setOnClickListener(v -> {

            startActivity(new Intent(LoginActivity.this,HomeActivity.class));

        });

        binding.RRforger.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this,ForgotActivity.class));
        });
    }
}