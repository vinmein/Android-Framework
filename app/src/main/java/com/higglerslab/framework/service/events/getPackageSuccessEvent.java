package com.higglerslab.framework.service.events;

import com.google.gson.JsonArray;

import retrofit2.Response;

/**
 * Created by work on 8/9/17.
 */

public class getPackageSuccessEvent extends BaseEvent {

    private JsonArray response;


    public getPackageSuccessEvent(Response<JsonArray> js){
        this.response = js.body();
        processData();
    }

    private void processData() {

    }

    public JsonArray getResponse(){
        return this.response;
    }


}
