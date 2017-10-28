package com.higglerslab.framework.service.remote;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.higglerslab.framework.service.events.ErrorEvent;
import com.higglerslab.framework.service.events.addResourceSuccessEvent;
import com.higglerslab.framework.service.events.createPackageSuccessEvent;
import com.higglerslab.framework.service.events.getPackageSuccessEvent;
import com.higglerslab.framework.service.events.getPackagebyIdSuccessEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by work on 3/7/17.
 */

public class PackageAPI extends BaseAPI
{

    public void CreatePackage (String packageName)
    {

        // TODO: 11/12/16 define your own API URL
        app.mAPIService.createPackage(packageName).enqueue(new Callback<JsonObject>()
        {
            @Override
            public void onResponse (Call<JsonObject> call, Response<JsonObject> response)
            {
                Log.i("response", String.valueOf(response.body()));
                handleResponse(response, new createPackageSuccessEvent(response));
            }

            @Override
            public void onFailure (Call<JsonObject> call, Throwable t)
            {
                event.post(new ErrorEvent(t));
            }
        });

    }

    public void getPackage ()
    {

        // TODO: 11/12/16 define your own API URL
        app.mAPIService.getPackages().enqueue(new Callback<JsonArray>()
        {
            @Override
            public void onResponse (Call<JsonArray> call, Response<JsonArray> response)
            {
                Log.i("response", String.valueOf(response.body()));
                handleResponse(response, new getPackageSuccessEvent(response));
            }

            @Override
            public void onFailure (Call<JsonArray> call, Throwable t)
            {
                event.post(new ErrorEvent(t));
            }
        });

    }

    public void getPackagebyId (String packageId)
    {

        // TODO: 11/12/16 define your own API URL
        app.mAPIService.getPackagesbyID(packageId).enqueue(new Callback<JsonObject>()
        {
            @Override
            public void onResponse (Call<JsonObject> call, Response<JsonObject> response)
            {
                Log.i("response", String.valueOf(response.body()));
                handleResponse(response, new getPackagebyIdSuccessEvent(response));
            }

            @Override
            public void onFailure (Call<JsonObject> call, Throwable t)
            {
                event.post(new ErrorEvent(t));
            }
        });

    }

    public void addResource(String packageName, JsonObject payload)
    {

        // TODO: 11/12/16 define your own API URL
        app.mAPIService.addResource(packageName, payload).enqueue(new Callback<JsonObject>()
        {
            @Override
            public void onResponse (Call<JsonObject> call, Response<JsonObject> response)
            {
                Log.i("response", String.valueOf(response.body()));
                handleResponse(response, new addResourceSuccessEvent(response));
            }

            @Override
            public void onFailure (Call<JsonObject> call, Throwable t)
            {
                event.post(new ErrorEvent(t));
            }
        });

    }
}
