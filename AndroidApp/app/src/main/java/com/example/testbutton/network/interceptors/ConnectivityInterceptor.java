package com.example.testbutton.network.interceptors;

import android.content.Context;

import com.example.testbutton.application.HomeApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

//public class ConnectivityInterceptor implements Interceptor {

//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Context context= HomeApplication.getAppContext();
//        Request originalRequest = chain.request();
//
//        if (!NetworkUtil.isOnline(context)) {
//            HomeApplication covidApplication = (HomeApplication) context;
//            BaseActivity a = (BaseActivity) covidApplication.getCurrentActivity();
//            //ConnectionInternetError errorNavigation = (ConnectionInternetError) covidApplication.getCurrentActivity();
//            a.navigateErrorPage();
//
//        }
//        Request newRequest = originalRequest.newBuilder()
//                .build();
//        return chain.proceed(newRequest);
//    }
//}
