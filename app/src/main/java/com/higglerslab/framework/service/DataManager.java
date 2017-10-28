package com.higglerslab.framework.service;


import com.google.gson.JsonObject;

/**
 * Created by dvadivel
 */

public class DataManager {
    //    private static AuthAPI sAuthAPI = new AuthAPI();
//    private static ProfileAPI sprofileAPI = new ProfileAPI();
    private static JsonObject profile;
//    private static QRData qrValue;

    //    public static void forgotPassword(String id) {
//        sAuthAPI.forgotPassword(id);
//    }
//
    public static String getUserToken() {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        if (shelper != null) {
            return shelper.getData("token", null);
        }

        return null;
    }

    public static void setUserToken(String token) {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        shelper.saveData("token", token);
    }

    public static void setUserId(String id) {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        shelper.saveData("userId", id);
    }

    public static String getUserId() {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        if (shelper != null) {
            return shelper.getData("userId", null);
        }

        return null;
    }
//
    public static void logout() {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        shelper.clearPref();
    }

    public static void setSubscription(Boolean sub) {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        shelper.saveBoolean("SUBSCRIPTION", sub);
    }

    public static Boolean getSubscription() {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        if (shelper != null) {
            return shelper.getBoolean("SUBSCRIPTION", false);
        }
        return false;
    }

    public static void setRemoveAds(Boolean ads) {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        shelper.saveBoolean("REMOVEADS", ads);
    }

    public static Boolean getRemoveAds() {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        if (shelper != null) {
            return shelper.getBoolean("REMOVEADS", false);
        }
        return false;
    }

    public static void setMaxCount(int count) {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        shelper.saveInt("MAXCOUNT", count);
    }

    public static int getMaxCount() {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        if (shelper != null) {
            return shelper.getInt("MAXCOUNT", 0);
        }
        return 0;
    }

    public static void setCurrentCount(int count) {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        shelper.saveInt("CURRENTCOUNT", count);
    }

    public static int getCurrentCount() {
        SharedPreferenceHelper shelper = SharedPreferenceHelper.getInstance();
        if (shelper != null) {
            return shelper.getInt("CURRENTCOUNT", 0);
        }
        return 0;
    }
}
