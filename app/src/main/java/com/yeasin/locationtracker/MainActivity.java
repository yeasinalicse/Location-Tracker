package com.yeasin.locationtracker;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      updateLocationRepeatedly(60); // 10 min == 600000 miliseconds
        App.setSharedPreference(MainActivity.this, "USER_NAME", "Yeasin");
    }
    private void updateLocationRepeatedly(long interval) { // 600000 = 10 min, from android 5.1 value will be 60000 (60 seconds) minimum by force

        Intent alarmIntent = new Intent(this, LocationGPSReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + 10000, interval, pendingIntent);
    }



}
