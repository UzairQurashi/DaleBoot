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
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentAdditionalInfoBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.request.Customer;
import app.dalboot.mobiavialdo.com.daleboot.utils.extras.EventMessage;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnAdditionalInfoInteractionListener} interface
 * to handle interaction events.
 */
public class AdditionalInfoForm extends FormsParentFragment {

    private FragmentAdditionalInfoBinding viewbinding;
    private OnAdditionalInfoInteractionListener mListener;

    public AdditionalInfoForm() {
        // Required empty public constructor
    }

    public static AdditionalInfoForm newInstance() {

        Bundle args = new Bundle();

        AdditionalInfoForm fragment = new AdditionalInfoForm();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(AdditionalInfoForm.this);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewbinding= DataBindingUtil.inflate(inflater,R.layout.fragment_additional_info, container, false);
        loadViews();
        return viewbinding.getRoot();
    }

    private void loadViews() {
        loadAllSpinners();
    }

    /**
     * sets all spinners data and load them
     */
    private void loadAllSpinners() {
        viewbinding.addInfoQOneSpinner.setItemsArray(upperspinner_items);
        viewbinding.addInfoQTwoSpinner.setItemsArray(upperspinner_items);
        viewbinding.addInfoQThreespinner.setItemsArray(upperspinner_items);
        viewbinding.addInfoQFourSpinner.setItemsArray(ability_level_items);
        viewbinding.addInfoQFiveSpinner.setItemsArray(att_sking_items);
        viewbinding.addInfoQSixSpinner.setItemsArray(prefered_sking_items);


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAdditionalInfoInteractionListener) {
            mListener = (OnAdditionalInfoInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAdditionalInfoInteractionListener");
        }
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
    public interface OnAdditionalInfoInteractionListener {
        // TODO: Update argument type and name
        void onAdditionalInfoInteraction(String bone_discomfort, String shing_bang, String your_feets, String ski_boots, String ability_level,
                                         String atttitude_skii, String preferd_sking_conditions, String height, String weight, String street_shoe_size);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage event) {
        if(event.getPage()==1){
            Customer.getInstance().setBone_discomfort((String) viewbinding.addInfoQOneSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setShin_bang((String) viewbinding.addInfoQTwoSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setYour_feets((String) viewbinding.addInfoQThreespinner.getSpinner().getSelectedItem());
            Customer.getInstance().setSki_boots(viewbinding.skiboots.getText().toString());
            Customer.getInstance().setAbility_level((String) viewbinding.addInfoQFourSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setAttitude_while_skiing((String) viewbinding.addInfoQFiveSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setSkiing_condition((String) viewbinding.addInfoQSixSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setHeight(viewbinding.height.getText().toString());
            Customer.getInstance().setWeight(viewbinding.weight.getText().toString());
            Customer.getInstance().setStreet_shoe_size(viewbinding.streetShoeSize.getText().toString());

        }


    }


}
