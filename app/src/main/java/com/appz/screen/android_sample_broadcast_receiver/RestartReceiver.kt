package com.appz.screen.android_sample_broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class RestartReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
//        if (SharedPrefs.getMyServiceStatus()) {
            context?.startService(Intent(context, MyService::class.java))
//            )
        }
    }