package com.my.invoiceapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.invoiceapp.R;
import com.my.invoiceapp.databinding.ActivityStateMentBinding;

public class StateMentActivity extends AppCompatActivity {

    ActivityStateMentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_state_ment);

        binding.RRBack.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRAddStatement.setOnClickListener(v -> {
            startActivity(new Intent(StateMentActivity.this, AddStatementCustomer.class));
        });

    }
}