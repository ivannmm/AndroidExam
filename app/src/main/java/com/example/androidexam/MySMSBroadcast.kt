package com.example.androidexam

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class MySMSBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val smsArray = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        for (sms in smsArray) {
            Log.i("EXAM2", sms.displayMessageBody)
        }
    }
}