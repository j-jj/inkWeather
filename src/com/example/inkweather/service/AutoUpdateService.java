package com.example.inkweather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;

public class AutoUpdateService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new Thread(new Runnable() {
			public void run() {
				updateWeather();
			}

		}).start();
		AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
		int anhour = 8 * 60 * 60 * 1000;
		long triggerAtime = SystemClock.elapsedRealtime() + anhour;
		Intent i = new Intent(this, AutoUpdateReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtime, pi);
		return super.onStartCommand(intent, flags, startId);
	}

	private void updateWeather() {
     SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(this);
     String weatherCode = spf.getString("weather_code", "");
     
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
