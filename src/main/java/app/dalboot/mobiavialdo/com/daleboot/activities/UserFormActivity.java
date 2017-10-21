package app.dalboot.mobiavialdo.com.daleboot.activities;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.ActivityUserFormBinding;
import app.dalboot.mobiavialdo.com.daleboot.forms.AdditionalInfoForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.BootSpecificationForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.CustomerInfoForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.FootMeasurementForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.ObservationsForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.RecieptForm;
import app.dalboot.mobiavialdo.com.daleboot.utils.NavigationUtils;
import app.dalboot.mobiavialdo.com.daleboot.utils.extras.EventMessage;

public class UserFormActivity extends BaseActivity implements
        AdditionalInfoForm.OnAdditionalInfoInteractionListener,
        CustomerInfoForm.OnCustomerInfoInteractionListener,
        ObservationsForm.OnFragmentInteractionListener,
        FootMeasurementForm.OnFragmentInteractionListener,
        BootSpecificationForm.OnFragmentInteractionListener,
        RecieptForm.OnFragmentInteractionListener{


    private ActivityUserFormBinding binding;
    public ViewPager viewPager;
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(UserFormActivity.this,R.layout.activity_user_form);
        parentBinding=binding;
        loadViews();

    }
//=======================================  Helper Methods ================================================//
    private void loadViews() {
        setSupportActionBar(binding.appbar.toolbar);
        setTittle("Customer Information");
        initFormPager();
        setEventsListners();
    }

    private void setEventsListners() {
        binding.formpager.addOnPageChangeListener(new OnPageListner());
        binding.appbar.toolbar.setNavigationOnClickListener(new BackNavigationListner());

    }

    private void initFormPager() {
        viewPager=binding.formpager;
        binding.formpager.setAdapter(NavigationUtils.getPagerAdapter(this,getSupportFragmentManager()));
        binding.formpager.setOffscreenPageLimit(5);

    }
    /**
     * this method will set and toolbar tittle of corressponding to current viewed screen
     * @param position
     */
    private void setToolbarTittle(int position) {
        switch (position) {
            case 0:
                setTittle("Customer Information");
                if(menu!=null) {
                    menu.findItem(R.id.nav_user_form).setTitle("Next");
                }
                break;
            case 1:
                setTittle("Additional Information");
                if(menu!=null) {
                    menu.findItem(R.id.nav_user_form).setTitle("Next");
                }
                break;
            case 2:

                //setTittle(String.valueOf(getMultiColorText("Observations\n","(Boot Tech Use Only)","#ffffff","#01CD61")));
                setTittle("Observations\n(Boot Tech Use Only)");
                if(menu!=null) {
                    menu.findItem(R.id.nav_user_form).setTitle("Next");
                }
                break;
            case 3:
                setTittle("Foot Measurements\n(Boot Tech Use Only)");
                if(menu!=null) {
                    menu.findItem(R.id.nav_user_form).setTitle("Next");
                }
                break;
            case 4:
                setTittle("Boot Specifications\n(Boot Tech Use Only)");
                if(menu!=null) {
                    menu.findItem(R.id.nav_user_form).setTitle("Next");
                }

                break;

            case 5:
                setTittle("Receipt\n(Boot Tech Use Only)");
                if(menu!=null) {
                    menu.findItem(R.id.nav_user_form).setTitle("Done");
                }
                break;

            default:
                break;


        }
    }

    private void setTittle(String s) {
        binding.appbar.mainToolbarTitle.setText(s);


    }
    /**
     * this method is used for viewpager navigation through nav icons of user form
     */
    private void navigatePage(boolean isforward) {
        if (isforward) {//executes untill when current page is not the last page
            if (binding.formpager.getCurrentItem() < 6) {
                EventBus.getDefault().post(new EventMessage(binding.formpager.getCurrentItem()));
                binding.formpager.setCurrentItem(binding.formpager.getCurrentItem() + 1);

            }
        } else {//executes untill when current page is the first page
            if (binding.formpager.getCurrentItem() > 0) {
                binding.formpager.setCurrentItem(binding.formpager.getCurrentItem() - 1);
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.form_menu, menu);
        this.menu=menu;

//        if(binding.formpager.getCurrentItem()==6){
//            menu.findItem(R.id.nav_user_form).setTitle("Done");
//
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.nav_user_form) {
            //openActivity(UserFormActivity.class);//navigate to user form screen
            navigatePage(true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    //=============================================== Inner Classess =================================================//
    private class OnPageListner implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setToolbarTittle(position);
            //EventBus.getDefault().post(new EventMessage(position));

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private class BackNavigationListner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(binding.formpager.getCurrentItem()==0){
                finish();
            }
            else {
                navigatePage(false);
            }
        }
    }
//================================================== Fragments Interactions Implemented Methods ===========================================//
    @Override
    public void onCustomerInfoInteraction(String f_name, String l_name, String c_street, String c_occupation, String c_tel, String c_city, String c_state, String c_zipcode, String c_email) {

    }
    @Override
    public void onAdditionalInfoInteraction(String bone_discomfort, String shing_bang, String your_feets, String ski_boots, String ability_level, String atttitude_skii, String preferd_sking_conditions, String height, String weight, String street_shoe_size) {

    }
    @Override
    public void onObservationFormInteraction(String arch_height, String heel_stance, String ankle, String dufluxion, String exostosis, String diff_in_legs_length, String footbed, String widlass, String forefoot, String rom) {

    }
    @Override
    public void onFootMeasurmentFormInteraction(String calf, String ankle, String foot_volume, String width, String tools_measurements, String size, String arch_length) {

    }

    @Override
    public void onBootSpecificationFormInteraction(String model_selection, String size, String linner_size, String linner_type) {

    }
    @Override
    public void onRecieptFormInteraction(String deposit, String pickup_date, String amount_paid, String invoice_number) {

    }

    @Override
    public void onBackPressed() {
        if(binding.formpager.getCurrentItem()==0){
            finish();
        }
        else {
            navigatePage(false);
        }

       // super.onBackPressed();
    }
}
