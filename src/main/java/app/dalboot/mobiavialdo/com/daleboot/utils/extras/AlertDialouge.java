package app.dalboot.mobiavialdo.com.daleboot.utils.extras;

import android.content.Context;
import android.graphics.Color;


import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Author: Uzair Qureshi
 * Date:  2/27/17.
 * Description:
 */

public class AlertDialouge {
    public static void showError(Context context, String message)
    {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));

        pDialog.setTitleText("Oops...");
        pDialog.setContentText(message);

        //pDialog.setCancelable(false);
        pDialog.show();
    }
    public static void showRetry(Context context, String message, final DialogeCallback dialogeCallback)
    {
        final SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#ff0000"));

        pDialog.setTitleText("Oops..");
        pDialog.setContentText(message);

        pDialog.setConfirmText("RETRY");
        pDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                pDialog.dismissWithAnimation();
                //listner.yesCall();
                dialogeCallback.yesCall();

            }
        });
        pDialog.show();
    }

    public static void showDialoge(Context context, String message)
    {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));

        pDialog.setTitleText("Alert!");
        pDialog.setContentText(message);

        //pDialog.setCancelable(false);
        pDialog.show();
    }
    public static void showConfirmation(Context context, String message)
    {
        final SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(String.valueOf("#a8c54a")));
       // "#A5DC86"
        pDialog.setTitleText("Confirmation");
        pDialog.setContentText(message);
     pDialog.show();

    }

    public static void showContinueLister(Context context, String message, final DialogeCallback listner)
    {
        final SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#ff0000"));

        pDialog.setTitleText("Success!");
        pDialog.setContentText(message);
        pDialog.setConfirmText("Continue");
        pDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                pDialog.dismissWithAnimation();
                listner.yesCall();

            }
        });
        pDialog.show();

    }






}
