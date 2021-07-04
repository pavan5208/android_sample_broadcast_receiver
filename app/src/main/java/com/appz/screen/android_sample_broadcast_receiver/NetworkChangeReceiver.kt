package com.appz.screen.android_sample_broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log


class NetworkChangeReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (isOnline(context)) {
            Log.d("NetworkChangeReceiver", "Connected to Internet ");
        } else {
            Log.d("NetworkChangeReceiver", "No Connectivity");
        }
    }

    private fun isOnline(context: Context?): Boolean {
        return try {
            val cm = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            //should check null because in airplane mode it will be null
            netInfo != null && netInfo.isConnected
        } catch (e: NullPointerException) {
            e.printStackTrace()
            false
        }
    }
}