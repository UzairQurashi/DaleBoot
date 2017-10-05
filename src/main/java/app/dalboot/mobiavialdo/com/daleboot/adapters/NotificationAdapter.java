package app.dalboot.mobiavialdo.com.daleboot.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.NotificationItemLayoutBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.response.Notifications;
import app.dalboot.mobiavialdo.com.daleboot.viewholders.NotificationViewHolder;

/**
 * Author: Uzair Qureshi
 * Date:  9/26/17.
 * Description:
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    private Context mContext;
    private ArrayList<Notifications.Datum> notifications;


    public NotificationAdapter(Context mContext, ArrayList<Notifications.Datum> notifications) {
        this.mContext = mContext;
        this.notifications = notifications;
    }




    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NotificationItemLayoutBinding itemLayoutBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.notification_item_layout,parent,true);
        NotificationViewHolder holder=new NotificationViewHolder(itemLayoutBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        ((NotificationViewHolder)holder).bindData(notifications.get(position));

    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }
}
