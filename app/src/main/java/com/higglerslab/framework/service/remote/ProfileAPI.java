package com.higglerslab.framework.service.remote;

import android.util.Log;

import com.google.gson.JsonObject;
import com.higglerslab.framework.service.events.ErrorEvent;
import com.higglerslab.framework.service.events.createProfileSuccessEvent;
import com.higglerslab.framework.service.events.getProfileSuccessEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by work on 3/7/17.
 */

public class ProfileAPI extends BaseAPI
{

    public void createProfile ()
    {

        // TODO: 11/12/16 define your own API URL
        app.mAPIService.createProfile().enqueue(new Callback<JsonObject>()
        {
            @Override
            public void onResponse (Call<JsonObject> call, Response<JsonObject> response)
            {
                Log.i("response", String.valueOf(response.body()));
                handleResponse(response, new createProfileSuccessEvent(response));
            }

            @Override
            public void onFailure (Call<JsonObject> call, Throwable t)
            {
                event.post(new ErrorEvent(t));
            }
        });

    }

    public void getProfile ()
    {

        // TODO: 11/12/16 define your own API URL
        app.mAPIService.getProfile().enqueue(new Callback<JsonObject>()
        {
            @Override
            public void onResponse (Call<JsonObject> call, Response<JsonObject> response)
            {
                Log.i("response", String.valueOf(response.body()));
                handleResponse(response, new getProfileSuccessEvent(response));
            }

            @Override
            public void onFailure (Call<JsonObject> call, Throwable t)
            {
                event.post(new ErrorEvent(t));
            }
        });

    }

}
