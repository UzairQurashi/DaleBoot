package app.dalboot.mobiavialdo.com.daleboot.activities;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.adapters.NavigationPagerAdapter;
import app.dalboot.mobiavialdo.com.daleboot.databinding.ActivityMainBinding;
import app.dalboot.mobiavialdo.com.daleboot.fragments.FormsFragment;
import app.dalboot.mobiavialdo.com.daleboot.fragments.NotificationsFragment;

public class MainActivity extends BaseActivity implements
        FormsFragment.OnFragmentInteractionListener,
        NotificationsFragment.OnFragmentInteractionListener{
    private ActivityMainBinding binding;
    private NavigationPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        loadViews();



    }
//===================================== Helper Methods =================================================//

    /**
     * this method will loads an screen view
     */
    private void loadViews() {
        setSupportActionBar(binding.toolbar);
        setViewPager();
        setEventsListners();

    }

    private void setEventsListners() {
        binding.mainPager.addOnPageChangeListener(new OnPageChange());
    }

    /**
     * this method will sets adapter of viewpager  and associated with tablayout.
     */
    private void setViewPager() {
        pagerAdapter = new NavigationPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(FormsFragment.newInstance("", ""), "Forms", null);
        pagerAdapter.addFragment(NotificationsFragment.newInstance("", ""), "Notifications", null);
        binding.mainPager.setAdapter(pagerAdapter);
        binding.tab.setupWithViewPager(binding.mainPager);
        pagerAdapter.setTabicons(binding.tab);




    }

    /**
     * this method will set and toolbar tittle of corressponding to current viewed screen
     * @param position
     */
    private void setToolbarTittle(int position) {
        switch (position) {
            case 0:
                binding.mainToolbarTitle.setText("" + "Forms");

                break;
            case 1:
                binding.mainToolbarTitle.setText("" + "Notifications");
                break;

            default:
                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private class OnPageChange implements ViewPager.OnPageChangeListener {
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
}
