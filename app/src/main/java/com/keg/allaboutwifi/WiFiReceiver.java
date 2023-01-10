package com.keg.allaboutwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Switch;

public class WiFiReceiver extends BroadcastReceiver {
    private final String TAG = "[KEG]";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        switch (action) {
            case WifiManager.ACTION_WIFI_SCAN_AVAILABILITY_CHANGED :
                Log.e(TAG,"ACTION_WIFI_SCAN_AVAILABILITY_CHANGED");
                break;

                /*
                        WifiManager.NETWORK_STATE_CHANGED_ACTION

                 */
            case WifiManager.NETWORK_STATE_CHANGED_ACTION :
                Log.e(TAG,"NETWORK_STATE_CHANGED_ACTION");
                NetworkInfo netinfo = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                Log.e("KEG"," \n netinfo.getType "+ netinfo.getType() + " \n netinfo.isConnected : "+ netinfo.isConnected() +
                        " \n netinfo.getExtraInfo : "+ netinfo.getExtraInfo()+ " \n netinfo.getReason :"+ netinfo.getReason()
                + " \n netinfo.getTypeName : "+ netinfo.getTypeName());

                break;

            case WifiManager.ACTION_REQUEST_SCAN_ALWAYS_AVAILABLE:
                Log.e(TAG,"ACTION_REQUEST_SCAN_ALWAYS_AVAILABLE");
                break;


                  /*
                        WifiManager.WIFI_STATE_CHANGED_ACTION
                        EXTRA_WIFI_STATE
                            WIFI_STATE_DISABLING : 0
                            WIFI_STATE_DISABLED : 1
                            WIFI_STATE_ENABLING : 2
                            WIFI_STATE_ENABLED : 3

                        EXTRA_PREVIOUS_WIFI_STATE

                 */
            case WifiManager.WIFI_STATE_CHANGED_ACTION:
                Log.e(TAG,"WIFI_STATE_CHANGED_ACTION");
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,100);
                Log.e("KEG","wifiState : "+ wifiState);
                int previousState = intent.getIntExtra(WifiManager.EXTRA_PREVIOUS_WIFI_STATE,101);
                Log.e("KEG","prev wifiState : " + previousState);
                break;
        }
    }
}
