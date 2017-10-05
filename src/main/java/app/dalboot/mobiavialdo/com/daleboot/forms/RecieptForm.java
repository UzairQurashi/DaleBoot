package app.dalboot.mobiavialdo.com.daleboot.forms;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.abstract_classess.GeneralCallBack;
import app.dalboot.mobiavialdo.com.daleboot.activities.UserFormActivity;
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentRecieptFormBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.request.Customer;
import app.dalboot.mobiavialdo.com.daleboot.models.response.GeneralResponse;
import app.dalboot.mobiavialdo.com.daleboot.network.RestClient;
import app.dalboot.mobiavialdo.com.daleboot.utils.extras.EventMessage;
import app.dalboot.mobiavialdo.com.daleboot.utils.extras.Hashes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecieptForm.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecieptForm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecieptForm extends FormsParentFragment {
    private FragmentRecieptFormBinding viewbinding;


    private OnFragmentInteractionListener mListener;

    public RecieptForm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecieptForm.
     */
    // TODO: Rename and change types and number of parameters
    public static RecieptForm newInstance(String param1, String param2) {
        RecieptForm fragment = new RecieptForm();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(RecieptForm.this);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       viewbinding= DataBindingUtil.inflate(inflater,R.layout.fragment_reciept_form, container, false);
        return viewbinding.getRoot();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
//    private void addCustomer(Customer customer){
//        getActualActivity(UserFormActivity.class).showProgress();
//        RestClient.getAuthAdapter().addCustomers(Hashes.getCustomerKey(customer)).enqueue(new GeneralCallBack<GeneralResponse>(getContext()) {
//            @Override
//            public void onSuccess(GeneralResponse response) {
//                getActualActivity(UserFormActivity.class).hideProgress();
//                getActualActivity(UserFormActivity.class).showMessage(response.getDeveloper_message());
//
//
//
//
//
//            }
//        });
//
//    }
    private void addCustomer(Customer customer){
        getActualActivity(UserFormActivity.class).showProgress();
        RestClient.getAuthAdapter().addCustomers(Hashes.getCustomerKey(customer)).enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                if((response.isSuccessful() ) &&(response!=null))
                {
                    getActualActivity(UserFormActivity.class).hideProgress();

                    getActualActivity(UserFormActivity.class).showMessage(response.body().getDeveloper_message());



                }
                else {
                    getActualActivity(UserFormActivity.class).showMessage("Server Error");


                }
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                getActualActivity(UserFormActivity.class).hideProgress();
                getActualActivity(UserFormActivity.class).showMessage(t.toString());


            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onRecieptFormInteraction(String deposit, String pickup_date, String amount_paid, String invoice_number);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage event) {
        if(event.getPage() == 5) {
            Customer.getInstance().setDeposit(viewbinding.deposit.getText().toString());
            Customer.getInstance().setPick_date(viewbinding.pickupDate.getText().toString());
            Customer.getInstance().setAmount(viewbinding.amountPaid.getText().toString());
            Customer.getInstance().setInvoice_number(viewbinding.invoiceNumber.getText().toString());

            addCustomer(Customer.getInstance());
//
        }
    }
}
