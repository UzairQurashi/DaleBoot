package app.dalboot.mobiavialdo.com.daleboot.forms;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

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
    private int arch_height_seekbar_value,dorsifloxion_seekbar_value=1;
    private StringBuilder left_heel_stance=new StringBuilder();
    private StringBuilder right_heel_stance=new StringBuilder();
    private StringBuilder exostosis=new StringBuilder();



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
        setListners();
    }

    private void setListners() {
        viewbinding.archHeightSeekbar.setOnSeekBarChangeListener(new OnSeekBarProgressListner(viewbinding.archHeightSeekbar));
        viewbinding.dorsifloxionSeekbar.setOnSeekBarChangeListener(new OnSeekBarProgressListner(viewbinding.dorsifloxionSeekbar));
    }

    /**
     * sets all spinners data and load them
     */
    private void loadSpinners() {
        //viewbinding.heelStancespinner.setItemsArray(heel_stance_items);
        viewbinding.ankleSpinner.setItemsArray(ankle_items);
       // viewbinding.exostosisSpinner.setItemsArray(exostosis_items);
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

    private String getleftheelstance(){
        if(viewbinding.leftHeelNormalCheck.isChecked()){
            appendleftheelChecks(viewbinding.leftHeelNormalCheck.getText().toString());
        }
        if(viewbinding.leftHeelPronationCheck.isChecked()){
            appendleftheelChecks(viewbinding.leftHeelPronationCheck.getText().toString());
        }
        if(viewbinding.leftHeelSupinationCheck.isChecked()){
            appendleftheelChecks(viewbinding.leftHeelSupinationCheck.getText().toString());
        }
        return left_heel_stance.toString();
    }
    private String getrightheelstance(){
        if(viewbinding.rightHeelNormalCheck.isChecked()){
            appendrightheelChecks(viewbinding.rightHeelNormalCheck.getText().toString());
        }
        if(viewbinding.rightHeelPronationCheck.isChecked()){
            appendrightheelChecks(viewbinding.rightHeelPronationCheck.getText().toString());
        }
        if(viewbinding.rightHeelSupinationCheck.isChecked()){
            appendrightheelChecks(viewbinding.rightHeelSupinationCheck.getText().toString());
        }
        return right_heel_stance.toString();
    }
    private String getexostosis(){
        if(viewbinding.instepBumpCheck.isChecked()){
            appendexostosisChecks(viewbinding.instepBumpCheck.getText().toString());
        }
        if(viewbinding.haluxValgusCheck.isChecked()){
            appendexostosisChecks(viewbinding.haluxValgusCheck.getText().toString());
        }
        if(viewbinding.tailorBunionCheck.isChecked()){
            appendexostosisChecks(viewbinding.tailorBunionCheck.getText().toString());
        }
        if(viewbinding.pumpBumpCheck.isChecked()){
            appendexostosisChecks(viewbinding.pumpBumpCheck.getText().toString());
        }
        if(viewbinding.bunionCheck.isChecked()){
            appendexostosisChecks(viewbinding.bunionCheck.getText().toString());
        }
        if(viewbinding.mortonFootCheck.isChecked()){
            appendexostosisChecks(viewbinding.mortonFootCheck.getText().toString());
        }
        if(viewbinding.otherCheck.isChecked()){
            appendexostosisChecks(viewbinding.otherCheck.getText().toString());
        }
        return exostosis.toString();
    }



    private void appendleftheelChecks(String status) {
        if (!left_heel_stance.toString().isEmpty()) {
            left_heel_stance.append(",").append(status);
        } else {
            left_heel_stance.append(status);
        }

    }
    private void appendrightheelChecks(String status) {
        if (!right_heel_stance.toString().isEmpty()) {
            right_heel_stance.append(",").append(status);
        } else {
            right_heel_stance.append(status);
        }

    }
    private void appendexostosisChecks(String status) {
        if (!right_heel_stance.toString().isEmpty()) {
            right_heel_stance.append(",").append(status);
        } else {
            right_heel_stance.append(status);
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage event) {
        if(event.getPage()==2){
            Customer.getInstance().setArch_height(String.valueOf(arch_height_seekbar_value+"ft"));

           Customer.getInstance().setHeel_stance("L:"+getleftheelstance()+"R:"+getrightheelstance());

            Customer.getInstance().setAnkle_select((String) viewbinding.ankleSpinner.getSpinner().getSelectedItem());
            Customer.getInstance().setDoorflexion( String.valueOf(dorsifloxion_seekbar_value+"ft"));
            Customer.getInstance().setExostosis(getexostosis());
            Customer.getInstance().setDifference_leg_length(viewbinding.leftLeg.getText().toString()+"-"+viewbinding.rightLeg.getText().toString()+us_metric);
            Customer.getInstance().setWindlass(viewbinding.leftWindlass.getText().toString()+"-"+viewbinding.rightWindLass.getText().toString()+us_metric);
            Customer.getInstance().setRom(viewbinding.leftRom.getText().toString()+"-"+viewbinding.rightRom.getText().toString()+us_metric);
            Customer.getInstance().setFoot_bed(viewbinding.leftForefoot.getText().toString()+"-"+viewbinding.rightForefoot.getText().toString()+us_metric);
            Customer.getInstance().setForefoot(viewbinding.leftForefoot.getText().toString()+"-"+viewbinding.rightForefoot.getText().toString()+us_metric);


        }


    }

    private class OnSeekBarProgressListner implements SeekBar.OnSeekBarChangeListener {
        private View view;
        public OnSeekBarProgressListner(View view) {
            this.view=view;

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            switch (view.getId()){
                case  R.id.arch_height_seekbar:
                    arch_height_seekbar_value= seekBar.getProgress();
                    break;

                case  R.id.dorsifloxion_seekbar:
                   dorsifloxion_seekbar_value= seekBar.getProgress();
                    break;
            }

        }
    }
}
