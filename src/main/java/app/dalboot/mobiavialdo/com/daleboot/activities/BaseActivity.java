package app.dalboot.mobiavialdo.com.daleboot.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //========================================Helper Methods =========================================//
    /**
     * @usage it opens the activity receives in parameter
     * @param activity
     */
    public void openActivity(Class activity)
    {
        startActivity(new Intent(this,activity));
    }

    /**
     * @usage it opens the activity receives in parameter and finish  the current activity running
     * @param activity
     */
    public void openActivityWithFinish(Class activity)
    {
        startActivity(new Intent(this,activity));
        finish();
    }

    /**
     * @usage it opens the activity with provide intent and finish  the current activity running
     * @param intent
     */
    public void openActivityWithFinish(Intent intent)
    {
        startActivity(intent);
        finish();
    }

    /**
     * @usage It opens the activity with the provided bundle as a parameter
     * @param activity
     * @param bundle
     */
    public void openActivity(Class activity, Bundle bundle)
    {
        startActivity(new Intent(this,activity).putExtras(bundle));
    }

    /**
     * @usage It opens the activity for result with the provided bundle as a parameter
     * @param activity
     * @param bundle
     */
    public void openActivityForResults(Class activity, Bundle bundle, int requestCode)
    {
        startActivityForResult(new Intent(this,activity).putExtras(bundle), requestCode);
    }


    /**
     * @usage It opens the activity for result
     * @param activity
     */
    public void openActivityForResults(Class activity, int requestCode)
    {
        startActivityForResult(new Intent(this,activity), requestCode);
    }


}
