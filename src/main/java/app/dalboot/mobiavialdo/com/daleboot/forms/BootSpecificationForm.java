package app.dalboot.mobiavialdo.com.daleboot.forms;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentBootSpecificationFormBinding;
import app.dalboot.mobiavialdo.com.daleboot.models.request.Customer;
import app.dalboot.mobiavialdo.com.daleboot.utils.extras.EventMessage;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BootSpecificationForm.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BootSpecificationForm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BootSpecificationForm extends FormsParentFragment {

    private OnFragmentInteractionListener mListener;
    private FragmentBootSpecificationFormBinding viewbinding;

    public BootSpecificationForm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BootSpecificationForm.
     */
    // TODO: Rename and change types and number of parameters
    public static BootSpecificationForm newInstance(String param1, String param2) {
        BootSpecificationForm fragment = new BootSpecificationForm();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(BootSpecificationForm.this);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       viewbinding= DataBindingUtil.inflate(inflater,R.layout.fragment_boot_specification_form, container, false);
        loadViews();
        return viewbinding.getRoot();
    }

    private void loadViews() {
        loadSpinners();
    }

    private void loadSpinners() {
        viewbinding.linnerTypeSpinner.setItemsArray(liner_types);
        viewbinding.modelSelectionSpinner.setItemsArray(models_selection);
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
        void onBootSpecificationFormInteraction(String model_selection, String size, String linner_size, String linner_type);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage event) {
        if(event.getPage() == 4) {
            Customer.getInstance().setModel_selection((String) viewbinding.modelSelectionSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setSize_select(viewbinding.size.getText().toString());
            Customer.getInstance().setLiner_size(viewbinding.linnerSize.getText().toString());
            Customer.getInstance().setLiner_type((String) viewbinding.linnerTypeSpinner.getSpinner().getSelectedItem());
//
        }
    }
}
