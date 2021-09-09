package com.my.invoiceapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.my.invoiceapp.Model.CustomersModel;
import com.my.invoiceapp.R;
import com.my.invoiceapp.adapter.CustomerAllAdapter;
import com.my.invoiceapp.adapter.CustomerHomeAdapter;
import com.my.invoiceapp.databinding.ActivityCutomersAllBinding;

import java.util.ArrayList;

public class CutomersAllActivity extends AppCompatActivity {

    ActivityCutomersAllBinding binding;
    private ArrayList<CustomersModel> modelList = new ArrayList<>();
    CustomerAllAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_cutomers_all);

        binding.RRBack.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRAddCustomer.setOnClickListener(v -> {

            startActivity(new Intent(CutomersAllActivity.this,AddNewCustomer.class));

        });

        setAdapter();
    }



    private void setAdapter() {

        this.modelList.add(new CustomersModel("Corn"));
        this.modelList.add(new CustomersModel("Tomotoes"));
        this.modelList.add(new CustomersModel("Cassava"));
        this.modelList.add(new CustomersModel("Cassava"));
        this.modelList.add(new CustomersModel("Cassava"));

        mAdapter = new CustomerAllAdapter(CutomersAllActivity.this,modelList);
        binding.recyclerCustomersall.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CutomersAllActivity.this);
        binding.recyclerCustomersall.setLayoutManager(linearLayoutManager);
        binding.recyclerCustomersall.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new CustomerAllAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, CustomersModel model) {

            }
        });

    }
}