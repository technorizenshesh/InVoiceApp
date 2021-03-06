package com.my.invoiceapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.my.invoiceapp.Model.CustomersModel;
import com.my.invoiceapp.R;
import com.my.invoiceapp.act.AddNewCustomer;
import com.my.invoiceapp.act.CustomerInvoice;
import com.my.invoiceapp.act.CutomersAllActivity;
import com.my.invoiceapp.act.StateMentActivity;

import java.util.ArrayList;


public class CustomerAllAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<CustomersModel> modelList;
    private OnItemClickListener mItemClickListener;


    public CustomerAllAdapter(Context context, ArrayList<CustomersModel> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<CustomersModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_customers_all, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final CustomersModel model = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.txtInvoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mContext.startActivity(new Intent(mContext, CustomerInvoice.class));

                }
            });

            genericViewHolder.txtStatement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mContext.startActivity(new Intent(mContext, StateMentActivity.class));

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private CustomersModel getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {

        void onItemClick(View view, int position, CustomersModel model);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtInvoice;
        TextView txtStatement;
        public ViewHolder(final View itemView) {
            super(itemView);

       this.txtInvoice=itemView.findViewById(R.id.txtInvoice);
       this.txtStatement=itemView.findViewById(R.id.txtStatement);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });
        }
    }


}

