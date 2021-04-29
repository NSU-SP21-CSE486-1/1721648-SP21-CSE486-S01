package com.example.broadcastreceiverheadphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null) {
            String toastMessage="unknown intent";
            int state = intent.getIntExtra("state", -1);
            if (Intent.ACTION_HEADSET_PLUG.equals(intentAction)) {
                switch (state) {
                    case 0:
                        toastMessage="Headset plugged out";
                        break;
                    case 1:
                        toastMessage="Headset plugged in";
                        break;
                }
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
