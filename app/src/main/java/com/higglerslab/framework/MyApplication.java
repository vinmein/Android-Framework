package com.higglerslab.framework;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.android.gms.common.api.GoogleApiClient;
import com.higglerslab.framework.service.SharedPreferenceHelper;
import com.higglerslab.framework.service.remote.retrofit.MyAPIService;
import com.higglerslab.framework.service.remote.retrofit.RetrofitServiceFactory;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by dvadivel
 */

public class MyApplication extends Application {
    private static MyApplication sApp;
    public MyAPIService mAPIService;
    public SharedPreferenceHelper sHelper;
    public GoogleApiClient mGoogleApiClient;
    public Location mLastLocation;
    EventBus event;

    public static MyApplication getInstance() {
        if (sApp == null) {
            sApp = new MyApplication();
        }

        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sApp = this;
        sHelper = SharedPreferenceHelper.getInstance(getApplicationContext());
        mAPIService = RetrofitServiceFactory.createService(MyAPIService.class);

    }

    public boolean isNetworkAvailable() {
        ConnectivityManager lConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo lNetworkInfo = lConnectivityManager.getActiveNetworkInfo();
        return lNetworkInfo != null && lNetworkInfo.isConnected();
    }
}
