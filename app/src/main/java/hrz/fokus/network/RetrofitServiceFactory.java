package hrz.fokus.network;

import android.util.Base64;

import java.io.IOException;

import hrz.fokus.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luthfi Haris on 02/10/2016.
 */

public class RetrofitServiceFactory {

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String credential = BuildConfig.CNN_USERNAME + ":" + BuildConfig.CNN_PASSWORD;

                String basic = "Basic " + Base64.encodeToString(credential.getBytes(), Base64.NO_WRAP);
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", basic)
                        .build();
                return chain.proceed(request);
            }
        };

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(interceptor).build())
                .build();
        return retrofit.create(clazz);
    }
}
