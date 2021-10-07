package com.my.invoiceapp.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.my.invoiceapp.Model.CustomersModel;
import com.my.invoiceapp.R;
import com.my.invoiceapp.SliderModel;
import com.my.invoiceapp.act.CutomersAllActivity;
import com.my.invoiceapp.adapter.CustomerHomeAdapter;
import com.my.invoiceapp.adapter.SliderAdapter;
import com.my.invoiceapp.databinding.HomeFragmentBinding;
import com.my.invoiceapp.databinding.ReportFragmentBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class ReportFragment extends Fragment {

    private Fragment fragment;
    ReportFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.report_fragment, container, false);

        fragment = new AgedDebtFragment();
        loadFragment(fragment);

        binding.txtAged.setOnClickListener(v -> {
            binding.txtToolbar.setText("Aged Debt");
            binding.txtAged.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
            binding.txtbest.setTextColor(ContextCompat.getColor(getContext(), R.color.natural_gray));
            binding.txtother.setTextColor(ContextCompat.getColor(getContext(), R.color.natural_gray));

            fragment = new AgedDebtFragment();
            loadFragment(fragment);
        });

        binding.txtbest.setOnClickListener(v -> {
            binding.txtToolbar.setText("Best Sellers");
            binding.txtAged.setTextColor(ContextCompat.getColor(getContext(), R.color.natural_gray));
            binding.txtbest.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
            binding.txtother.setTextColor(ContextCompat.getColor(getContext(), R.color.natural_gray));

            fragment = new BestSellersFragment();
            loadFragment(fragment);
        });

          binding.txtother.setOnClickListener(v -> {
              binding.txtToolbar.setText("Other Report");
            binding.txtAged.setTextColor(ContextCompat.getColor(getContext(), R.color.natural_gray));
            binding.txtbest.setTextColor(ContextCompat.getColor(getContext(), R.color.natural_gray));
            binding.txtother.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));

            fragment = new OtherFragment();
            loadFragment(fragment);
        });

        return binding.getRoot();

    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_report, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }


}