package com.higglerslab.framework.service.events;

import com.google.gson.JsonObject;

import retrofit2.Response;

/**
 * Created by work on 8/9/17.
 */

public class getProfileSuccessEvent extends BaseEvent {

    private JsonObject response;


    public getProfileSuccessEvent(Response<JsonObject> js) {
        this.response = js.body();
        processData();
    }

    private void processData() {

    }

    public JsonObject getResponse() {
        return this.response;
    }

}
