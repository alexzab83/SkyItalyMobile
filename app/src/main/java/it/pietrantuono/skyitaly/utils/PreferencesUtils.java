package it.pietrantuono.skyitaly.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import it.pietrantuono.skyitaly.network.model.User;

public class PreferencesUtils {

    public static final String PREF_EMAIL = "pref_email";

    private static SharedPreferences getPref(Context c){
        return c.getSharedPreferences("user_skiresort", Context.MODE_PRIVATE);
    }
    public static User getUser(Context c){
        SharedPreferences preferences = getPref(c);
        String json = preferences.getString("user_skiresort", "");
        if (json.equals("")) return null;
        User user = new Gson().fromJson(json, User.class);
        return user;
    }

    public static void putUser(Context c, User u){
        SharedPreferences preferences = getPref(c);
        preferences.edit().putString("user_skiresort", new Gson().toJson(u)).commit();
    }

    public static void deleteUser(Context c, User u){
        SharedPreferences preferences = getPref(c);
        preferences.edit().remove("user_skiresort");
    }


}
