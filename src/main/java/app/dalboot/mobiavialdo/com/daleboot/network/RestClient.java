package app.dalboot.mobiavialdo.com.daleboot.network;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Uzair Qureshi on 06-Jun-16.
 */
public class RestClient {

    private static WebCalls authRestClient;

     static {
         setupClient();
     }

    private static void setupClient() {

        // Todo remove log level while release

        setupRestClient();

    }



    private static   void setupRestClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request newRequest;
                        newRequest = request.newBuilder()
                                .addHeader("Accept","application/json")
                                .build();
                        return chain.proceed(newRequest);
                    }
                })
                .addInterceptor(logging)
                .connectTimeout(20000, TimeUnit.MILLISECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(NetworkConstants.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                client(httpClient).
                build();

      authRestClient = retrofit.create(WebCalls.class);
    }








    public static WebCalls getAuthAdapter(){
        return authRestClient;
    }


}


