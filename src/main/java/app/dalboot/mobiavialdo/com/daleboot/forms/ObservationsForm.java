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
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentObservationsBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.request.Customer;
import app.dalboot.mobiavialdo.com.daleboot.utils.extras.EventMessage;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ObservationsForm.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ObservationsForm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObservationsForm extends FormsParentFragment {



    private OnFragmentInteractionListener mListener;
    private FragmentObservationsBinding viewbinding;

    public ObservationsForm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @return A new instance of fragment ObservationsForm.
     */
    // TODO: Rename and change types and number of parameters
    public static ObservationsForm newInstance(String param1, String param2) {
        ObservationsForm fragment = new ObservationsForm();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(ObservationsForm.this);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       viewbinding = DataBindingUtil.inflate(inflater,R.layout.fragment_observations, container, false);
        loadViews();
        return viewbinding.getRoot();
    }
//============================================== Helper Methods ========================================================//
    private void loadViews() {
        loadSpinners();
    }

    /**
     * sets all spinners data and load them
     */
    private void loadSpinners() {
        viewbinding.heelStancespinner.setItemsArray(heel_stance_items);
        viewbinding.ankleSpinner.setItemsArray(ankle_items);
        viewbinding.exostosisSpinner.setItemsArray(exostosis_items);
        viewbinding.foodBedSpinner.setItemsArray(forbed_items);
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
        void onObservationFormInteraction(String arch_height, String heel_stance, String ankle, String dufluxion, String exostosis, String diff_in_legs_length, String footbed,
                                          String widlass, String forefoot, String rom);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage event) {
        if(event.getPage()==2){
            Customer.getInstance().setArch_height(String.valueOf(5));
            Customer.getInstance().setHeel_stance((String) viewbinding.heelStancespinner.getSpinner().getSelectedItem());
            Customer.getInstance().setAnkle_select((String) viewbinding.ankleSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setDoorflexion( String.valueOf(5));
            Customer.getInstance().setExostosis((String) viewbinding.exostosisSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setDifference_leg_length(viewbinding.leftLeg.getText().toString()+"-"+viewbinding.rightLeg.getText().toString()+"cm");
            Customer.getInstance().setWindlass(viewbinding.leftWindlass.getText().toString()+"-"+viewbinding.rightWindLass.getText().toString()+"cm");
            Customer.getInstance().setRom(viewbinding.leftRom.getText().toString()+"-"+viewbinding.rightRom.getText().toString()+"cm");
            Customer.getInstance().setFoot_bed(viewbinding.leftForefoot.getText().toString()+"-"+viewbinding.rightForefoot.getText().toString()+"cm");
            Customer.getInstance().setForefoot(viewbinding.leftForefoot.getText().toString()+"-"+viewbinding.rightForefoot.getText().toString()+"cm");


        }


    }

}
