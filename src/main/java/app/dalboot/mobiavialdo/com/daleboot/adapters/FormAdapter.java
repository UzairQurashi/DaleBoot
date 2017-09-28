package app.dalboot.mobiavialdo.com.daleboot.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.viewholders.FormViewHolder;

/**
 * Author: Uzair Qureshi
 * Date:  9/26/17.
 * Description:
 */

public class FormAdapter extends RecyclerView.Adapter<FormViewHolder> {
    private Context mContext;


    public FormAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.form_item_layout,parent,false);
        FormViewHolder holder=new FormViewHolder(itemView);


        return holder;
    }

    @Override
    public void onBindViewHolder(FormViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
