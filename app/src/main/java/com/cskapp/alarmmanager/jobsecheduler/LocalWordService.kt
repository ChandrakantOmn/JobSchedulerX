package com.cskapp.alarmmanager.jobsecheduler

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.util.*

/**
 * Created by Chandra Kant on 28/11/18.
 */
class LocalWordService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Date", Date().toString())
        Toast.makeText(applicationContext, "Hiiiii", Toast.LENGTH_SHORT).show()
    }
}