package com.my.invoiceapp.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.my.invoiceapp.Model.CustomersModel;
import com.my.invoiceapp.R;
import com.my.invoiceapp.SliderModel;
import com.my.invoiceapp.act.CutomersAllActivity;
import com.my.invoiceapp.act.LoginActivity;
import com.my.invoiceapp.act.SignUpActivity;
import com.my.invoiceapp.adapter.CustomerHomeAdapter;
import com.my.invoiceapp.adapter.SliderAdapter;
import com.my.invoiceapp.databinding.HomeFragmentBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private Fragment fragment;
    SliderAdapter adapter;
    CustomerHomeAdapter mAdapter;
    HomeFragmentBinding binding;
    private ArrayList<SliderModel> modelList = new ArrayList<>();
    private ArrayList<CustomersModel> modelList_customers = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);

       setSlider();

        setAdapter();

        return binding.getRoot();

    }

    private void setSlider() {
        modelList.add(new SliderModel(""));
        modelList.add(new SliderModel(""));
        modelList.add(new SliderModel(""));

        adapter = new SliderAdapter(getActivity(), modelList);
        binding.imageSlider.setSliderAdapter(adapter);
        adapter.notifyDataSetChanged();
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(getActivity().getColor(R.color.gray));
        binding.imageSlider.setIndicatorUnselectedColor(Color.GREEN);
        binding.imageSlider.setScrollTimeInSec(4); //set scroll delay in seconds :
        binding.imageSlider.startAutoCycle();
    }


    private void setAdapter() {

        this.modelList_customers.add(new CustomersModel("Corn"));
        this.modelList_customers.add(new CustomersModel("Tomotoes"));
        this.modelList_customers.add(new CustomersModel("Cassava"));
        this.modelList_customers.add(new CustomersModel("Cassava"));
        this.modelList_customers.add(new CustomersModel("Cassava"));

        mAdapter = new CustomerHomeAdapter(getActivity(),modelList_customers);
        binding.recyclerCustomers.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerCustomers.setLayoutManager(linearLayoutManager);
        binding.recyclerCustomers.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new CustomerHomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, CustomersModel model) {

                startActivity(new Intent(getActivity(), CutomersAllActivity.class));

            }
        });

    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeContainer, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }


}