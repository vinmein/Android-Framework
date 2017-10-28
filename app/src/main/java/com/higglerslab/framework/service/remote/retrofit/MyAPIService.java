package com.higglerslab.framework.service.remote.retrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by dvadivel
 */

public interface MyAPIService
{

    @Headers({"Content-Type: application/json"})
    @POST("createPackage")
    public Call<JsonObject> createPackage(@Query("packageName") String packageName);

    @GET ("createProfile")
    public Call<JsonObject> createProfile();

    @GET ("getProfile")
    public Call<JsonObject> getProfile();

    @GET ("getPackages")
    public Call<JsonArray> getPackages();

    @Headers({"Content-Type: application/json"})
    @POST("addResource")
    public Call<JsonObject> addResource(@Query("packageId") String packageId, @Body JsonObject payload);

    @GET ("getPackagesbyId")
    public Call<JsonObject> getPackagesbyID(@Query("packageId") String packageId);
}
