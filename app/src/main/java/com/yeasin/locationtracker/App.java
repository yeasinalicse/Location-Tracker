package com.yeasin.locationtracker;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.maps.model.LatLng;
import org.json.JSONObject;

/**
 * Created by Yeasin on 16/02/19.
 */

public class App extends Application {
    private static App instence;

    private static String SVR_KEY_URL = "MYAP_HST_KE_AP_URL";
    public static String APP_PREF_KEY = "MYAP_KYE_APP";

    private static Dialog progressDialog;
    private static ProgressDialog pgDialog;

    public static String getURL(Context _ctx, String _path) {
        return "api url";
    }

    private static JSONObject company;

    public static LatLng COMPANY_LOCATION = new LatLng(23.7514363, 90.3917723); // zoom with 19z


    /*App permission related coed*/
    public static final int LOCATION_REQUEST_CODE = 109;
    public static final int ALARM_REQUEST_CODE = 111;
    public static final int REBOOT_REQUEST_CODE = 113;
    public static final int PHONE_STATE_REQUEST_CODE = 114;
    public static final int MULTIPLE_PERMISSION_CODE = 99;


    // manage app shared preference data ---- START

    public static String getSharedPreference(Context _context, String key) {
        return getSharedPreference(_context, key, "");
    }


    public static String getSharedPreference(Context _context, String key, String _default) {
        SharedPreferences sharedPreferences = _context.getSharedPreferences(App.APP_PREF_KEY, Context.MODE_PRIVATE);

        try {
            return sharedPreferences.getString(key, _default).trim();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static void setSharedPreference(Context _context, String key, String value) {
        SharedPreferences sharedPreferences = _context.getSharedPreferences(App.APP_PREF_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);

        editor.commit();
    }

    public static void destroySharedPreferenceData(Context _context) {
        SharedPreferences sharedPreferences = _context.getSharedPreferences(App.APP_PREF_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }




    public static JSONObject getCompany() {
        return company;
    }

    public static void setCompany(JSONObject com) {
        company = com;
    }

    public void onCreate() {
        super.onCreate();
    }

    private App() {
    }

    public static synchronized App getInstance() {
        App app;
        synchronized (App.class) {
            if (instence == null) {
                instence = new App();
            }
            app = instence;
        }
        return app;
    }

    public static void destroyApp() {
        instence = null;
    }

    //https://console.developers.google.com/cloud-resource-manager?pli=1
}
