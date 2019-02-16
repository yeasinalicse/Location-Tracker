package com.yeasin.locationtracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;

import static android.content.ContentValues.TAG;
import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

/**
 * Created by Yeasin on 16/02/19.
 */

public class LocationGPSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent!=null){

           GPSTracker gps = new GPSTracker(context);
            Toast.makeText(context, "Location"+""+gps.getLocation()+" Name : "+App.getSharedPreference(context,"USER_NAME"), Toast.LENGTH_SHORT).show();

            Intent intent1 = new Intent();
            intent1.setAction("JOB INTENT SERVICE");
            //AlarmJobIntentService.enqueueWork(context,AlarmJobIntentService.class,1,intent1);
        }
    }

}
