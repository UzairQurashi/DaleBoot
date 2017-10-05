package app.dalboot.mobiavialdo.com.daleboot.forms;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentCustomerInfoBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.request.Customer;
import app.dalboot.mobiavialdo.com.daleboot.utils.ValidationUtility;
import app.dalboot.mobiavialdo.com.daleboot.utils.extras.EventMessage;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnCustomerInfoInteractionListener} interface
 * to handle interaction events.
 */
public class CustomerInfoForm extends FormsParentFragment {

    private FragmentCustomerInfoBinding viewbinding;
    private OnCustomerInfoInteractionListener mListener;

    public CustomerInfoForm() {
        // Required empty public constructor
    }

    public static CustomerInfoForm newInstance() {
        
        Bundle args = new Bundle();
        
        CustomerInfoForm fragment = new CustomerInfoForm();
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewbinding= DataBindingUtil.inflate(inflater,R.layout.fragment_customer_info, container, false);
        return viewbinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActualActivity(UserFormActivity.class).viewPager.
        EventBus.getDefault().register(CustomerInfoForm.this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCustomerInfoInteractionListener) {
            mListener = (OnCustomerInfoInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAdditionalInfoInteractionListener");
        }
    }

     private boolean isValidate(){
         if(!ValidationUtility.edittextValidator(viewbinding.firstname)){
             return false;
         }
         else if (!ValidationUtility.edittextValidator(viewbinding.lastname)){
             return false;
         }
         else if (!ValidationUtility.edittextValidator(viewbinding.street)){
             return false;
         }
         else if(!ValidationUtility.edittextValidator(viewbinding.occupation)){
             return false;
         }
         else if(!ValidationUtility.edittextValidator(viewbinding.telephone)){
             return false;
         }
         else if(!ValidationUtility.edittextValidator(viewbinding.city)){
             return false;
         }
         else if(!ValidationUtility.edittextValidator(viewbinding.state)){
             return false;
         }
         else if(!ValidationUtility.edittextValidator(viewbinding.zipcode)){
             return false;
         }
         else if(!ValidationUtility.edittextValidator(viewbinding.email)){
             return false;
         }

          return true;
     }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCustomerInfoInteractionListener {
        // TODO: Update argument type and name
        void onCustomerInfoInteraction(String f_name, String l_name , String c_street, String c_occupation, String c_tel, String c_city, String c_state, String c_zipcode, String c_email);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage event) {
        if(event.getPage()==0){

            // if(isValidate()){
                 Customer.getInstance().setFirst_name(viewbinding.firstname.getText().toString());
                 Customer.getInstance().setLast_name(viewbinding.firstname.getText().toString());
                 Customer.getInstance().setStreet(viewbinding.firstname.getText().toString());
                 Customer.getInstance().setOccupation(viewbinding.firstname.getText().toString());
                 Customer.getInstance().setTel(viewbinding.firstname.getText().toString());
                 Customer.getInstance().setZip_code(viewbinding.firstname.getText().toString());
                 Customer.getInstance().setState(viewbinding.firstname.getText().toString());
                 Customer.getInstance().setCity(viewbinding.firstname.getText().toString());
                 Customer.getInstance().setEmail(viewbinding.firstname.getText().toString());



//             }


        }

    }

}
