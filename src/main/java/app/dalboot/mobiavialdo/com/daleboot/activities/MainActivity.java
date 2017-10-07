package app.dalboot.mobiavialdo.com.daleboot.activities;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import app.dalboot.mobiavialdo.com.daleboot.R;
import app.dalboot.mobiavialdo.com.daleboot.databinding.ActivityMainBinding;
import app.dalboot.mobiavialdo.com.daleboot.fragments.AllUsersFragment;
import app.dalboot.mobiavialdo.com.daleboot.fragments.NotificationsFragment;
import app.dalboot.mobiavialdo.com.daleboot.utils.NavigationUtils;

public class MainActivity extends BaseActivity implements
        AllUsersFragment.OnFragmentInteractionListener,
        NotificationsFragment.OnFragmentInteractionListener{
    private ActivityMainBinding binding;
    private int[]tabicons=new int[]{R.drawable.form_tabs,R.drawable.notifications_tabs};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        parentBinding=binding;
        loadViews();



    }
//===================================== Helper Methods =================================================//

    /**
     * this method will loads an screen view
     */
    private void loadViews() {
        setSupportActionBar(binding.appbar.toolbar);
        binding.appbar.toolbar.setNavigationIcon(null);
        setTittle("Forms");
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

        binding.mainPager.setAdapter(NavigationUtils.getPagerAdapter(this,getSupportFragmentManager()));
        binding.tab.setupWithViewPager(binding.mainPager);
        setTabicons(binding.tab);




    }
    /**
     * this method will set an tab icons
     * @param tabLayout
     */
    public void setTabicons(TabLayout tabLayout)
    {
        tabLayout.getTabAt(0).setIcon(tabicons[0]);
        tabLayout.getTabAt(1).setIcon(tabicons[1]);


    }

    /**
     * this method will set and toolbar tittle of corressponding to current viewed screen
     * @param position
     */
    private void setToolbarTittle(int position) {
        switch (position) {
            case 0:
                setTittle("Forms");

                break;
            case 1:
                setTittle("Notifications");
                 break;

            default:
                break;


        }
    }
    private void setTittle(String s) {
        binding.appbar.mainToolbarTitle.setText(s);


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


        if (id == R.id.add_user_form) {
            openActivity(UserFormActivity.class);//navigate to user form screen
            // openActivity(SuccessActivty.class);//navigate to user form screen

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
