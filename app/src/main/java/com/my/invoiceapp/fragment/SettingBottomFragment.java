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
import com.my.invoiceapp.databinding.ReportFragmentBinding;
import com.my.invoiceapp.databinding.SettingFragmentBinding;


public class SettingBottomFragment extends Fragment {

    private Fragment fragment;
    SettingFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.setting_fragment, container, false);

        fragment = new AgedDebtFragment();
        loadFragment(fragment);

        binding.txtProduct.setOnClickListener(v -> {
            binding.txtToolbar.setText("Product");
            binding.txtProduct.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
            binding.txtAccount.setTextColor(ContextCompat.getColor(getContext(), R.color.natural_gray));

            fragment = new AgedDebtFragment();
            loadFragment(fragment);
        });

        binding.txtAccount.setOnClickListener(v -> {
            binding.txtToolbar.setText("Account");
            binding.txtProduct.setTextColor(ContextCompat.getColor(getContext(), R.color.natural_gray));
            binding.txtAccount.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));

            fragment = new AgedDebtFragment();
            loadFragment(fragment);
        });


        return binding.getRoot();

    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_setting, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }


}