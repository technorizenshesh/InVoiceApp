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
import com.my.invoiceapp.databinding.MonthlyFragmentBinding;
import com.my.invoiceapp.databinding.ReportFragmentBinding;


public class MonthlyFragment extends Fragment {

    private Fragment fragment;
    MonthlyFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.monthly_fragment, container, false);

        return binding.getRoot();

    }


}