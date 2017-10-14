package app.dalboot.mobiavialdo.com.daleboot.activities;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;

import com.wang.avi.AVLoadingIndicatorView;

import app.dalboot.mobiavialdo.com.daleboot.utils.ProgressLoader;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    protected ViewDataBinding parentBinding;
    private ProgressLoader progressLoader;
   // private AVLoadingIndicatorView avi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //========================================Helper Methods =========================================//
    public View getView()
    {
        if (parentBinding!=null)
            return parentBinding.getRoot();
        else return null;

    }


    /**
     * @usage It use to show any message provided by the caller
     * @param message
     */
    public void showMessage(String message)
    {
        if (getView()!=null) {
            Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
        }
    }
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


    public void showProgress()
    {
        try {
            if (progressLoader == null)
            {
                progressLoader = new ProgressLoader();
            }

            progressLoader.show(getSupportFragmentManager(),TAG);
        }
        catch (IllegalStateException e)
        {
            Log.e(TAG, "showProgress:" + e.getMessage());
        }

    }

    public void hideProgress() {
        if (progressLoader != null) {
            try {
                progressLoader.dismissAllowingStateLoss();
            } catch (Exception e) {
                Log.e(TAG, "hideProgress:" + e.getMessage());
            }
        }
    }
    protected Spanned getMultiColorText(String text1, String text2, String color1, String color2){
        String fulltext = "";
        try {
            fulltext="<font color='"+color1+"'>" + text1 + "</font>" + " " + "<font color='"+color2+"' ><strong>" + text2 + "</strong></font>";
        }
        catch (Exception e){}

        return Html.fromHtml(fulltext);

    }

}
