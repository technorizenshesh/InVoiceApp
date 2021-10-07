package com.my.invoiceapp.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.my.invoiceapp.Model.CustomersModel;
import com.my.invoiceapp.R;
import com.my.invoiceapp.adapter.AgedDebtAdapter;
import com.my.invoiceapp.adapter.BEstSellerAdapter;
import com.my.invoiceapp.databinding.AgedDebtFragmentBinding;
import com.my.invoiceapp.databinding.BestsellerFragmentBinding;

import java.util.ArrayList;


public class BestSellersFragment extends Fragment {

    private Fragment fragment;
    BestsellerFragmentBinding binding;
    private ArrayList<CustomersModel> modelList = new ArrayList<>();
    BEstSellerAdapter mAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.bestseller_fragment, container, false);

        setAdapter();

        return binding.getRoot();

    }

    private void setAdapter() {

        this.modelList.add(new CustomersModel("Corn"));
        this.modelList.add(new CustomersModel("Tomotoes"));


        mAdapter = new BEstSellerAdapter(getActivity(),modelList);
        binding.recyclerCustomersall.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerCustomersall.setLayoutManager(linearLayoutManager);
        binding.recyclerCustomersall.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new BEstSellerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, CustomersModel model) {

            }
        });
    }


}