package com.my.invoiceapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.invoiceapp.R;
import com.my.invoiceapp.databinding.ActivityCutomersDetailsBinding;

public class CutomersDetails extends AppCompatActivity {

    ActivityCutomersDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_cutomers_details);

        binding.RRBack.setOnClickListener(v -> {
            onBackPressed();
        });

        
    }
}