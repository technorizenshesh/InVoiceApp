package com.my.invoiceapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.invoiceapp.R;
import com.my.invoiceapp.databinding.ActivityAddNewInvoiceCustomerBinding;

public class AddNewInvoiceCustomer extends AppCompatActivity {

    ActivityAddNewInvoiceCustomerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_invoice_customer);

        binding.RRBack.setOnClickListener(v -> {

            onBackPressed();

        });
    }
}