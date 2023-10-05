package com.example.broadcastreceiverexample;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    // String constant that defines the custom broadcast Action.
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction=intent.getAction();
        int num=intent.getIntExtra("data",0);
        Log.d("Random", "onReceive: "+num);

        if (intentAction!=null){
            String toastMessage="unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage="Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage="Power disconnected!";
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    toastMessage="Headset plugged!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage="Custom Broadcast Received "+"Square of the random number "+num*num;
                    break;
            }
            //display the toast
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}