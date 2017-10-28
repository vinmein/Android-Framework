package com.higglerslab.framework.service.remote.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.higglerslab.framework.service.DataManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dvadivel
 */

public class RetrofitServiceFactory {
    // TODO: 11/12/16 define your own base url
    private static final String BASE_URL = "https://us-central1-packmythings-21eb0.cloudfunctions.net/";
    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new DataTypeAdapterFactory()).create();
    private static final Retrofit.Builder sBuilder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create(gson));

    public static Retrofit sRetrofit;

    public static <S> S createService(Class<S> serviceClass) {
        final String[] authHeader = new String[1];

        final String[] userId = new String[1];
        httpClient.addInterceptor(new ResponseInterceptor());
        //add authorization header
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                if (DataManager.getUserToken() != null) {
                    authHeader[0] = "Bearer " + DataManager.getUserToken();
                } else {
                    authHeader[0] = "";
                }

                if (DataManager.getUserId() != null) {
                    userId[0] = DataManager.getUserId();
                } else {
                    userId[0] = "";
                }


                Request lOriginalRequest = chain.request();
                Log.i("body", String.valueOf(lOriginalRequest.body()));
                Log.i("method", String.valueOf(lOriginalRequest.method()));
                Request lRequest = lOriginalRequest.newBuilder().header("Authorization", authHeader[0])
                        .header("userId", userId[0])
                        .method(lOriginalRequest.method(), lOriginalRequest.body()).build();

                return chain.proceed(lRequest);
            }
        });
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient lClient = httpClient.build();
        httpClient.addInterceptor(logging);
        sRetrofit = sBuilder.client(lClient).build();
        return sRetrofit.create(serviceClass);
    }

}
