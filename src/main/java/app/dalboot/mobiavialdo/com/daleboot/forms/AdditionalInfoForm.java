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
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentAdditionalInfoBinding;

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
        void onFragmentInteraction(Uri uri);
    }
}
