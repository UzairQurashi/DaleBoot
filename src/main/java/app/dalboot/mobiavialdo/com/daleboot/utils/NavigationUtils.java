package app.dalboot.mobiavialdo.com.daleboot.utils;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import app.dalboot.mobiavialdo.com.daleboot.activities.MainActivity;
import app.dalboot.mobiavialdo.com.daleboot.activities.UserFormActivity;
import app.dalboot.mobiavialdo.com.daleboot.adapters.NavigationPagerAdapter;
import app.dalboot.mobiavialdo.com.daleboot.forms.AdditionalInfoForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.BootSpecificationForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.CustomerInfoForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.FootMeasurementForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.ObservationsForm;
import app.dalboot.mobiavialdo.com.daleboot.forms.RecieptForm;
import app.dalboot.mobiavialdo.com.daleboot.fragments.AllUsersFragment;
import app.dalboot.mobiavialdo.com.daleboot.fragments.NotificationsFragment;

/**
 * Author: Uzair Qureshi
 * Date:  9/29/17.
 * Description:
 */

public class NavigationUtils {
    public static NavigationPagerAdapter getPagerAdapter(Context context, FragmentManager fragmentManager){
        NavigationPagerAdapter adapter=new NavigationPagerAdapter(fragmentManager);

        if(context instanceof MainActivity)
        {
            adapter.addFragment(AllUsersFragment.newInstance("", ""), "Forms", null);
            adapter.addFragment(NotificationsFragment.newInstance("", ""), "Notifications", null);

        }
        else if (context instanceof UserFormActivity)
        {
            adapter.addFragment(CustomerInfoForm.newInstance(),"CustomerInfoForm",null);
            adapter.addFragment(AdditionalInfoForm.newInstance(),"AdditionalInfoForm",null);
            adapter.addFragment(ObservationsForm.newInstance(null,null),"ObservationsForm",null);
            adapter.addFragment(FootMeasurementForm.newInstance(null,null),"FootMeasurementForm",null);
            adapter.addFragment(BootSpecificationForm.newInstance(null,null),"BootSpecificationForm",null);
            adapter.addFragment(RecieptForm.newInstance(null,null),"RecieptForm",null);




        }

        return adapter;

    }
}
