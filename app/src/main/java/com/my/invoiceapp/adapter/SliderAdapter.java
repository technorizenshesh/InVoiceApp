package com.my.invoiceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.my.invoiceapp.R;
import com.my.invoiceapp.SliderModel;
import com.my.invoiceapp.databinding.ItemSliderBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapter  extends SliderViewAdapter<SliderAdapter.MyViewHolder> {


    private final Context context;
    private ArrayList<SliderModel> arrayList;

    public SliderAdapter(Context context, ArrayList<SliderModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        ItemSliderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_slider,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
       // Glide.with(context).load(arrayList.get(position).storeImg).into(viewHolder.binding.ivFav);
       /* if(arrayList.get(position).isFav==true) viewHolder.binding.ivFav.setImageDrawable(context.getDrawable(R.drawable.heart_red));
        else viewHolder.binding.ivFav.setImageDrawable(context.getDrawable(R.drawable.heart));
*/

       /* viewHolder.binding.llFav.setOnClickListener(v -> {

            if(arrayList.get(position).isFav==true){
                for (int i =0;i<arrayList.size();i++){
                    arrayList.get(i).setFav(false);
                }
                notifyDataSetChanged();

            }
            else if(arrayList.get(position).isFav==false){
                for (int i =0;i<arrayList.size();i++){
                    arrayList.get(i).setFav(true);
                }
                notifyDataSetChanged();

            }
        } );*/

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }


    public class MyViewHolder extends SliderViewAdapter.ViewHolder {
        ItemSliderBinding binding;
        public MyViewHolder(@NonNull ItemSliderBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;


        }
    }
}
