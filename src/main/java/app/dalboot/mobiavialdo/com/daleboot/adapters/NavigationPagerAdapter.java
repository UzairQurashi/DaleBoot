package app.dalboot.mobiavialdo.com.daleboot.adapters;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import app.dalboot.mobiavialdo.com.daleboot.R;

/**
 * Created by Uzair on 12/9/16.
 */

public class NavigationPagerAdapter extends FragmentPagerAdapter

{
    private final List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private final List<String> mFragmentTitleList = new ArrayList<String>();
    private int[]tabicons=new int[]{R.drawable.form_tabs,R.drawable.notifications_tabs};
    public NavigationPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);

    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addFragment(Fragment fragment, String fragmenttittle, Bundle bundle)
    {
        fragment.setArguments(bundle);
        mFragmentList.add(fragment);
        mFragmentTitleList.add(fragmenttittle);
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//
//        return mFragmentTitleList.get(position);
//        //return "";
//    }

    /**
     * this method will set an tab icons
     * @param tabLayout
     */
    public void setTabicons(TabLayout tabLayout)
    {
        tabLayout.getTabAt(0).setIcon(tabicons[0]);
        tabLayout.getTabAt(1).setIcon(tabicons[1]);


    }
}
