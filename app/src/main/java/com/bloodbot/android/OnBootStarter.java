package com.bloodbot.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by mashnoor on 1/26/17.
 */

public class OnBootStarter extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, LocService.class);
        context.startService(i);

    }
}
