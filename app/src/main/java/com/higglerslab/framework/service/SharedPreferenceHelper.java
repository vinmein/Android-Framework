package com.higglerslab.framework.service;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dinesh on 30/6/17.
 */

public class SharedPreferenceHelper {
    private static SharedPreferenceHelper myPref;
    private SharedPreferences sharedPreferences;
    Context ctc;

    public static SharedPreferenceHelper getInstance(Context context) {
        if (myPref == null) {
            myPref = new SharedPreferenceHelper(context);
        }
        return myPref;
    }

    public static SharedPreferenceHelper getInstance() {
        if (myPref != null) {
            return myPref;
        }

        //Option 1:
        throw new IllegalArgumentException("Should use getInstance(Context) at least once before using this method.");

        //Option 2:
        // Alternatively, you can create a new instance here
        // with something like this:
        // getInstance(MyCustomApplication.getAppContext());
    }

    public SharedPreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("com.higglerslab.dvadivel.foodiehuts", Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putString(key, value);
        prefsEditor.commit();
    }

    public void saveBoolean(String key, Boolean value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.commit();
    }

    public Boolean getBoolean(String key, Boolean defautValue) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getBoolean(key, defautValue);
        }
        return false;
    }

    public void saveInt(String key, int value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.commit();
    }

    public int getInt(String key, int defautValue) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getInt(key, defautValue);
        }
        return 0;
    }

    public String getData(String key, String defautValue) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, defautValue);
        }
        return "";
    }

    public void clearPref(){
        sharedPreferences.edit().clear().commit();
    }
}
