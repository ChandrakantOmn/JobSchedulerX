package com.cskapp.alarmmanager

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.util.*

/**
 * Created by Chandra Kant on 3/9/21.
 */
class AlarmReceiver : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, Date().toString(), Toast.LENGTH_LONG).show()
        Log.d("Date", Date().toString())

        // this will trigger at the alarm time

        // show notification or vibration here
    }
}