package app.dalboot.mobiavialdo.com.daleboot.activities;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.ActivityUserFormBinding;
import app.dalboot.mobiavialdo.com.daleboot.forms.AdditionalInfoForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.BootSpecificationForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.CustomerInfoForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.FootMeasurementForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.ObservationsForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.RecieptForm;
import app.dalboot.mobiavialdo.com.daleboot.utils.NavigationUtils;

public class UserFormActivity extends BaseActivity implements
        AdditionalInfoForm.OnAdditionalInfoInteractionListener,
        CustomerInfoForm.OnCustomerInfoInteractionListener,
        ObservationsForm.OnFragmentInteractionListener,
        FootMeasurementForm.OnFragmentInteractionListener,
        BootSpecificationForm.OnFragmentInteractionListener,
        RecieptForm.OnFragmentInteractionListener{


    private ActivityUserFormBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(UserFormActivity.this,R.layout.activity_user_form);
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
        binding.formpager.setAdapter(NavigationUtils.getPagerAdapter(this,getSupportFragmentManager()));

    }
    /**
     * this method will set and toolbar tittle of corressponding to current viewed screen
     * @param position
     */
    private void setToolbarTittle(int position) {
        switch (position) {
            case 0:
                setTittle("Customer Information");
                break;
            case 1:
                setTittle("Additional Information");
                break;
            case 2:
                setTittle("ObservationsForm\n[Boots tech use only]");
                break;
            case 3:
                setTittle("Foot Measurements\n(Boots tech use only)");
                break;
            case 4:
                setTittle("Boot Specifications\n(Boots tech use only)");
                break;

            case 5:
                setTittle("Reciept\n(Boots tech use only)");
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
                binding.formpager.setCurrentItem(binding.formpager.getCurrentItem() + 1);
            }
        } else {//executes untill when current page is the first page
            if (binding.formpager.getCurrentItem() > 0) {
                binding.formpager.setCurrentItem(binding.formpager.getCurrentItem() - 1);
            }

        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.form_menu, menu);
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
}
