package it.pietrantuono.skyitaly.utils;

import android.content.Context;
import android.content.SharedPreferences;

import it.pietrantuono.skyitaly.network.model.User;

public class PreferencesUtils {

    public static final String PREF_EMAIL = "pref_email";

    private static SharedPreferences getPref(Context c){
        return c.getSharedPreferences("user_skiresort", Context.MODE_PRIVATE);
    }
    public static User getUser(Context c){
        SharedPreferences preferences = getPref(c);
        User user = new User();
        user.setEmail(preferences.getString(PREF_EMAIL, ""));
        return user;
    }
}
