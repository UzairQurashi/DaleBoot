package app.dalboot.mobiavialdo.com.daleboot.network;

import app.dalboot.mobiavialdo.com.daleboot.models.AllCustomers;
import app.dalboot.mobiavialdo.com.daleboot.models.Notifications;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Author: Uzair Qureshi
 * Date:  10/2/17.
 * Description:
 */

public interface WebCalls {


    @GET(EndPoints.ALL_CUSTOMERS)
      Call<AllCustomers> getcustomers();
    //Call<AllCustomers> getAllCustomers();

    @GET(EndPoints.ALL_NOTIFICATIONS)
    Call<Notifications> getNotifications();


}
