package app.dalboot.mobiavialdo.com.daleboot.viewholders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.activities.CantingInfoActivity;
import app.dalboot.mobiavialdo.com.daleboot.databinding.FormItemLayoutBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.response.AllCustomers;

/**
 * Author: Uzair Qureshi
 * Date:  9/26/17.
 * Description:
 */

public class FormViewHolder extends RecyclerView.ViewHolder {
    public FormItemLayoutBinding binding;

    public FormViewHolder( FormItemLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void bindData(AllCustomers.Datum customer){
        binding.username.setText(customer.getFirst_name()+" " +customer.getLast_name());
        binding.formId.setText(customer.getInvoice_number());
        binding.salesman.setText(customer.getSaleman_name());
        binding.bootType.setText(customer.getModel_selection());
        setCanting(customer);

    }

    private void setCanting(final AllCustomers.Datum customer) {
        if (Integer.parseInt(customer.getCantingcount())==0){
            binding.canting.setBackgroundColor(binding.getRoot().getResources().getColor(R.color.primaryred));
            binding.canting.setText(customer.getPick_date());
            binding.addCanting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), CantingInfoActivity.class);
                    intent.putExtra("order_id",customer.getOrder_id());
                    v.getContext().startActivity(new Intent(intent));
                }
            });

        }
        else if(Integer.parseInt(customer.getCantingcount())==1){
            binding.canting.setBackgroundColor(binding.getRoot().getResources().getColor(R.color.primary_green));


        }
    }


//
}
