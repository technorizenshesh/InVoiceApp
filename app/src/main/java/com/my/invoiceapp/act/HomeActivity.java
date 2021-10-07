package com.my.invoiceapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.my.invoiceapp.R;
import com.my.invoiceapp.databinding.ActivityHomeBinding;
import com.my.invoiceapp.fragment.HomeFragment;
import com.my.invoiceapp.fragment.ReportFragment;
import com.my.invoiceapp.fragment.SettingBottomFragment;

public class HomeActivity extends AppCompatActivity {

    Fragment fragment;
    ActivityHomeBinding binding;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);


        binding.RRHome.setOnClickListener(v -> {

            binding.txtHome.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.blue));
            binding.txtReport.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.natural_gray));
            binding.txtSetting.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.natural_gray));

            binding.imgHome.setImageResource(R.drawable.home_blue);
            binding.imgReport.setImageResource(R.drawable.report_gray);
            binding.imgSetting.setImageResource(R.drawable.setting);

            fragment = new HomeFragment();
            loadFragment(fragment);

        });

        binding.RRReport.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.drawable.home);
            binding.imgReport.setImageResource(R.drawable.report_blue);
            binding.imgSetting.setImageResource(R.drawable.setting);


            binding.txtHome.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.natural_gray));
            binding.txtReport.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.blue));
            binding.txtSetting.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.natural_gray));

            fragment = new ReportFragment();
            loadFragment(fragment);
        });

        binding.RRSetting.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.drawable.home);
            binding.imgReport.setImageResource(R.drawable.report_gray);
            binding.imgSetting.setImageResource(R.drawable.setting_blue);


            binding.txtHome.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.natural_gray));
            binding.txtReport.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.natural_gray));
            binding.txtSetting.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.blue));

            fragment = new SettingBottomFragment();
            loadFragment(fragment);
        });

        fragment = new HomeFragment();
        loadFragment(fragment);

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        binding.txtHome.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.blue));
        binding.txtReport.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.natural_gray));
        binding.txtSetting.setTextColor(ContextCompat.getColor(HomeActivity.this, R.color.natural_gray));

        binding.imgHome.setImageResource(R.drawable.home_blue);
        binding.imgReport.setImageResource(R.drawable.report_gray);
        binding.imgSetting.setImageResource(R.drawable.setting);

        fragment = new HomeFragment();
        loadFragment(fragment);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {

                doubleBackToExitPressedOnce=false;

                finishAffinity();
            }
        }, 2000);
    }


    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeContainer, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }
}