package com.example.androidexam

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log

class MyBatteryBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val capacity = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        Log.i("EXAM1", capacity.toString())
    }
}