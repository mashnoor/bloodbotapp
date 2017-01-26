package com.bloodbot.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import im.delight.android.location.SimpleLocation;

public class LocService extends Service {
    SimpleLocation location;
    @Override
    public void onCreate() {
        super.onCreate();
        location = new SimpleLocation(this);
        location.beginUpdates();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    Log.d("-------- LAT", "" + location.getLatitude());

                    Log.d("-------- LON", "" + location.getLongitude());
                    location.endUpdates();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }



            }
        });
        thread.start();
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
