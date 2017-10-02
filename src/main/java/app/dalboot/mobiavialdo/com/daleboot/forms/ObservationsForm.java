package app.dalboot.mobiavialdo.com.daleboot.forms;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentObservationsBinding;

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
        void onFragmentInteraction(Uri uri);
    }
}
