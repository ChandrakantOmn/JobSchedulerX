package com.cskapp.alarmmanager.jobsecheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

/**
 * Created by Chandra Kant on 28/11/18.
 */
class TestJobService : JobService() {
    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onStartJob(params: JobParameters): Boolean {
        val service = Intent(applicationContext, LocalWordService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            applicationContext.startForegroundService(service)
        } else {
            applicationContext.startService(service)
        }
        Util.scheduleJob(applicationContext) // reschedule the job
        Toast.makeText(applicationContext, "Hiiiii", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        return true
    }

    companion object {
        private const val TAG = "SyncService"
    }
}