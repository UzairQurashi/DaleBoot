package app.dalboot.mobiavialdo.com.daleboot.network;

import java.util.Map;

import app.dalboot.mobiavialdo.com.daleboot.models.response.AllCustomers;
import app.dalboot.mobiavialdo.com.daleboot.models.response.GeneralResponse;
import app.dalboot.mobiavialdo.com.daleboot.models.response.Notifications;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
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
    @FormUrlEncoded
    @POST(EndPoints.ADD_CUSTOMERS)
    Call<GeneralResponse> addCustomers(@FieldMap Map<String ,String> customer);

    @FormUrlEncoded
    @POST(EndPoints.ADD_CANTING)
    Call<GeneralResponse> addCanting(@Field("cant_wand") String cant_wand,
                                     @Field("canted_sole") String canted_sole,
                                     @Field("after_cant") String after_cant,
                                     @Field("notes") String notes,
                                     @Field("order_id") String order_id);


}
