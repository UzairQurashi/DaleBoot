package app.dalboot.mobiavialdo.com.daleboot.models;

import java.util.ArrayList;

/**
 * Author: Uzair Qureshi
 * Date:  10/2/17.
 * Description:
 */

public class AllCustomers extends GeneralResponse {
    private ArrayList<Datum> Data = null;

    public ArrayList<Datum> getData() {
        return Data;
    }

    public void setData(ArrayList<Datum> data) {
        this.Data = data;
    }


    public class Datum{
        private String first_name;
        private String last_name;
        private String order_id;
        private String model_selection;
        private String saleman_name;
        private String receipt_id;
        private String pick_date;
        private String invoice_number;
        private String cantingcount;

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getModel_selection() {
            return model_selection;
        }

        public void setModel_selection(String model_selection) {
            this.model_selection = model_selection;
        }

        public String getSaleman_name() {
            return saleman_name;
        }

        public void setSaleman_name(String saleman_name) {
            this.saleman_name = saleman_name;
        }

        public String getReceipt_id() {
            return receipt_id;
        }

        public void setReceipt_id(String receipt_id) {
            this.receipt_id = receipt_id;
        }

        public String getPick_date() {
            return pick_date;
        }

        public void setPick_date(String pick_date) {
            this.pick_date = pick_date;
        }

        public String getInvoice_number() {
            return invoice_number;
        }

        public void setInvoice_number(String invoice_number) {
            this.invoice_number = invoice_number;
        }

        public String getCantingcount() {
            return cantingcount;
        }

        public void setCantingcount(String cantingcount) {
            this.cantingcount = cantingcount;
        }
    }
}
