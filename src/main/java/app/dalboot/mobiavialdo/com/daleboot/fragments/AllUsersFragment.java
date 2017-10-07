package app.dalboot.mobiavialdo.com.daleboot.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.abstract_classess.GeneralCallBack;
import app.dalboot.mobiavialdo.com.daleboot.activities.BaseActivity;
import app.dalboot.mobiavialdo.com.daleboot.activities.MainActivity;
import app.dalboot.mobiavialdo.com.daleboot.adapters.AllUsersAdapter;
import app.dalboot.mobiavialdo.com.daleboot.databinding.FragmentFormsBinding;
import app.dalboot.mobiavialdo.com.daleboot.forms.FormsParentFragment;
import app.dalboot.mobiavialdo.com.daleboot.models.response.AllCustomers;
import app.dalboot.mobiavialdo.com.daleboot.network.RestClient;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AllUsersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AllUsersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllUsersFragment extends FormsParentFragment {

    private FragmentFormsBinding formsBinding;



    private OnFragmentInteractionListener mListener;
    private AllUsersAdapter adapter;

    public AllUsersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllUsersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllUsersFragment newInstance(String param1, String param2) {
        AllUsersFragment fragment = new AllUsersFragment();
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
        formsBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_forms,container,false);
        loadViews();
        return formsBinding.getRoot();
    }

    private void loadViews() {
       initrecyclerview();
        getAllCustomers();


    }

    /**
     * this method will initialize recyclerview
     * @param
     */
    private void initrecyclerview() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        formsBinding.formRecylerview.setLayoutManager(mLayoutManager);
        formsBinding.formRecylerview.setItemAnimator(new DefaultItemAnimator());

    }
    private void setAdapter(ArrayList<AllCustomers.Datum> data) {
        AllUsersAdapter adapter=new AllUsersAdapter(this.getContext(),data);
        formsBinding.formRecylerview.setAdapter(adapter);

    }


    private void populateRecyclerView(ArrayList<AllCustomers.Datum> cutomers){
        adapter.swap(cutomers);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAdditionalInfoInteractionListener");
        }
    }

    /**
     *
     */
private void getAllCustomers(){
    getActualActivity(BaseActivity.class).showProgress();
    RestClient.getAuthAdapter().getcustomers().enqueue(new GeneralCallBack<AllCustomers>(getActualActivity(MainActivity.class)) {
        @Override
        public void onSuccess(AllCustomers response) {
            if(response!=null) {
                getActualActivity(BaseActivity.class).hideProgress();
                setAdapter(response.getData());
            }

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
        void onFragmentInteraction(Uri uri);
    }
}
