package com.example.androidexam

import android.Manifest
import android.app.Activity
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat


class MainActivity : AppCompatActivity() {

    val batteryBroadcast = MyBatteryBroadcast()
    val smsBroadcast = MySMSBroadcast()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(batteryBroadcast, IntentFilter("android.intent.action.BATTERY_CHANGED"))

        val filter = IntentFilter()
        filter.addAction("android.provider.Telephony.SMS_RECEIVED")

        registerReceiver(smsBroadcast, filter)
        addPerms()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(batteryBroadcast)
        unregisterReceiver(smsBroadcast)
    }

    fun addPerms() {
        val perms = Manifest.permission.RECEIVE_SMS
        val isOk = ContextCompat.checkSelfPermission(this, perms)
        if (isOk != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(perms), 1)
        }
    }
}