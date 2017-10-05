package app.dalboot.mobiavialdo.com.daleboot.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.FormItemLayoutBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.response.AllCustomers;
import app.dalboot.mobiavialdo.com.daleboot.viewholders.FormViewHolder;

/**
 * Author: Uzair Qureshi
 * Date:  9/26/17.
 * Description:
 */

public class FormAdapter extends RecyclerView.Adapter<FormViewHolder> {
    private Context mContext;
    private ArrayList<AllCustomers.Datum> customers;


    public FormAdapter(Context mContext, ArrayList<AllCustomers.Datum> customers) {
        this.mContext = mContext;
        this.customers = customers;
    }





    @Override
    public FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.form_item_layout,parent,false);
        FormItemLayoutBinding itemBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.form_item_layout,parent,false);
        return new FormViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(FormViewHolder holder, int position) {

        ( (FormViewHolder)holder).bindData(customers.get(position));





    }

    @Override
    public int getItemCount() {
        return customers.size();
    }
    public void swap(ArrayList<AllCustomers.Datum> data) {
        customers.clear();
        customers.addAll(data);
        notifyDataSetChanged();
    }

}
