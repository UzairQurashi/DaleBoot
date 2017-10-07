package app.dalboot.mobiavialdo.com.daleboot.viewholders;

import android.support.v7.widget.RecyclerView;

import app.dalboot.mobiavialdo.com.daleboot.databinding.NotificationItemLayoutBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.response.Notifications;
import app.dalboot.mobiavialdo.com.daleboot.utils.DateTimeUtility;

/**
 * Author: Uzair Qureshi
 * Date:  9/26/17.
 * Description:
 */

public class NotificationViewHolder extends RecyclerView.ViewHolder {
    public NotificationItemLayoutBinding itemLayoutBinding;

    public NotificationViewHolder(NotificationItemLayoutBinding itemLayoutBinding) {
        super(itemLayoutBinding.getRoot());
        this.itemLayoutBinding=itemLayoutBinding;

    }
    public void bindData(Notifications.Datum notificatoins){
        itemLayoutBinding.notificationMsg.setText(notificatoins.getMessage());
        itemLayoutBinding.orderId.setText("Order #"+" "+notificatoins.getOrder_id() +" " +"is in progress");
        itemLayoutBinding.notificationTime.setText(DateTimeUtility.getLocalDate(notificatoins.getTime_stamp()));
        //itemLayoutBinding.notificationTime.setText(notificatoins.getTime_stamp());

    }
}
