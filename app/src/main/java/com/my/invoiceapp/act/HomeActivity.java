package com.my.invoiceapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.my.invoiceapp.R;
import com.my.invoiceapp.databinding.ActivityHomeBinding;
import com.my.invoiceapp.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    Fragment fragment;
    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        fragment = new HomeFragment();
        loadFragment(fragment);
    }


    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeContainer, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }
}