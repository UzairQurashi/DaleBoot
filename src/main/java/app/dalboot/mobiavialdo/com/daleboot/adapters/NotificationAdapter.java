package app.dalboot.mobiavialdo.com.daleboot.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.viewholders.FormViewHolder;
import app.dalboot.mobiavialdo.com.daleboot.viewholders.NotificationViewHolder;

/**
 * Author: Uzair Qureshi
 * Date:  9/26/17.
 * Description:
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    private Context mContext;

    public NotificationAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item_layout,parent,false);
        NotificationViewHolder holder=new NotificationViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
