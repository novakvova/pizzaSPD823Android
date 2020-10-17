package com.example.testbutton.network;

import com.example.testbutton.constants.Urls;
import com.example.testbutton.network.interceptors.JWTInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    //private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String BASE_URL = "http://10.0.2.2:61937";
    //private static final String BASE_URL = "http://10.0.2.2:5000";
    private Retrofit mRetrofit;

    private NetworkService() {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new JWTInterceptor());
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }
    public JSONPlaceHolderApi getJSONApi() {
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }
    public static String getBaseUrl() {
        return Urls.BASE_URL;
    }
}
