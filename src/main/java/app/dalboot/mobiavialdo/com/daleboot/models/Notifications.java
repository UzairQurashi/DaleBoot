package app.dalboot.mobiavialdo.com.daleboot.models;

import java.util.ArrayList;

/**
 * Author: Uzair Qureshi
 * Date:  10/2/17.
 * Description:
 */

public class Notifications extends GeneralResponse {
    public ArrayList<Datum> getData() {
        return Data;
    }

    public void setData(ArrayList<Datum> data) {
        Data = data;
    }

    private ArrayList<Datum> Data = null;

    public class Datum{
        private String id;
        private String message;
        private String order_id;
        private String time_stamp;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getTime_stamp() {
            return time_stamp;
        }

        public void setTime_stamp(String time_stamp) {
            this.time_stamp = time_stamp;
        }
    }
}
