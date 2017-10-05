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
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentFootMeasurementFormBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.request.Customer;
import app.dalboot.mobiavialdo.com.daleboot.utils.extras.EventMessage;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FootMeasurementForm.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FootMeasurementForm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FootMeasurementForm extends FormsParentFragment {

   private FragmentFootMeasurementFormBinding viewbinding;

    private OnFragmentInteractionListener mListener;

    public FootMeasurementForm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FootMeasurementForm.
     */
    // TODO: Rename and change types and number of parameters
    public static FootMeasurementForm newInstance(String param1, String param2) {
        FootMeasurementForm fragment = new FootMeasurementForm();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(FootMeasurementForm.this);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewbinding= DataBindingUtil.inflate(inflater,R.layout.fragment_foot_measurement_form, container, false);
        loadViews();
        return viewbinding.getRoot();
    }
//================================================Helper Methods =====================================================//
    private void loadViews() {
        loadSpinners();
    }
    /**
     * sets all spinners data and load them
     */
    private void loadSpinners() {
        viewbinding.measurmntToolSpinner.setItemsArray(tools_measures_items);
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
        void onFootMeasurmentFormInteraction(String calf, String ankle, String foot_volume, String width, String tools_measurements, String size, String arch_length);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage event) {
        if(event.getPage()==3){
            Customer.getInstance().setCalf(viewbinding.leftCalf.getText().toString()+"-"+viewbinding.rightCalf.getText().toString()+"cm");
            Customer.getInstance().setAnkle((viewbinding.leftAnkle.getText().toString()+"-"+viewbinding.rightAnkle.getText().toString()+"cm"));
            Customer.getInstance().setFoot_volue((viewbinding.leftFootVol.getText().toString()+"-"+viewbinding.rightFootVol.getText().toString()+"cm"));
            Customer.getInstance().setWidth((viewbinding.leftWidth.getText().toString()+"-"+viewbinding.rightWidth.getText().toString()+"cm"));
            Customer.getInstance().setMeasurement_below((String) viewbinding.measurmntToolSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setArch_length(viewbinding.leftArch.getText().toString()+"-"+viewbinding.rightArch.getText().toString()+"cm");
            Customer.getInstance().setSize(viewbinding.leftSize.getText().toString()+"-"+viewbinding.rightSize.getText().toString()+"cm");


        }

    }
}
