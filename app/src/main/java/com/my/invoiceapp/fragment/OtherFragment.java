package com.my.invoiceapp.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.my.invoiceapp.R;
import com.my.invoiceapp.databinding.OtherFragmentBinding;
import com.my.invoiceapp.databinding.ReportFragmentBinding;


public class OtherFragment extends Fragment {

    private Fragment fragment;
    OtherFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.other_fragment, container, false);

        fragment = new MonthlyFragment();
        loadFragment(fragment);

        binding.txtMonthly.setOnClickListener(v -> {

            fragment = new MonthlyFragment();
            loadFragment(fragment);

            binding.txtMonthly.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
            binding.txtCustomers.setTextColor(ContextCompat.getColor(getContext(), R.color.green));
            binding.txtProduct.setTextColor(ContextCompat.getColor(getContext(), R.color.green));


        });

        binding.txtCustomers.setOnClickListener(v -> {
            binding.txtMonthly.setTextColor(ContextCompat.getColor(getContext(), R.color.green));
            binding.txtCustomers.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
            binding.txtProduct.setTextColor(ContextCompat.getColor(getContext(), R.color.green));


        });

          binding.txtProduct.setOnClickListener(v -> {
            binding.txtMonthly.setTextColor(ContextCompat.getColor(getContext(), R.color.green));
            binding.txtCustomers.setTextColor(ContextCompat.getColor(getContext(), R.color.green));
            binding.txtProduct.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));


        });

        return binding.getRoot();

    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_other, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }


}