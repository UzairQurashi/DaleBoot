package app.dalboot.mobiavialdo.com.daleboot.abstract_classess;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Author: Muhammad Shahab.
 * Organization: Mobitribe
 * Date: 8/28/17
 * Description: General Callback for all api calls
 */

public abstract class GeneralCallBack<T> implements Callback<T> {

    private final Context context;


    /**
     * @purpose Parameter constructor
     * @param context
     */
    public GeneralCallBack(Context context)
    {
        this.context = context;
    }

    /*this method will invoked when server gives an reponse and this have multiple implementation according to scenario*/
    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful() && response.body() != null) {
            onSuccess(response.body());
        } else {
            onServerFailure("Server error");
        }



    }


    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable instanceof IOException) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Something goes wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * @purpose When server fails due to some validations
     * @param message
     */
    private void onServerFailure( String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * @purpose this method will be implemented to all concrete class
     * @param response
     */
    abstract public void onSuccess(T response);


}
