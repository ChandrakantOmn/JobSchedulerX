package com.cskapp.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity1 extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                setAlarm();
            }
        });

        scheduleAlarm(this);
    }

    private void setAlarm() {
        Intent intent = new Intent(this, MyService.class);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
        Toast.makeText(this, "Alarm will ring after every 15 minutes interval", Toast.LENGTH_LONG).show();
    }

    void scheduleAlarm(Context context) {

        // scheduling an alarm at 05:00 PM

        //getting instance of a calendar
        Calendar calendar = Calendar.getInstance();

        //setting exact date and time of alarm
        // in my case it is 17/11/2020 at 05.00 PM
        calendar.set(Calendar.MONTH,2); // month count starts from 0; here 10 denotes November
        calendar.set(Calendar.YEAR,2021); // year
        calendar.set(Calendar.DAY_OF_MONTH,9); // day
        calendar.set(Calendar.HOUR_OF_DAY,15); // hour
        calendar.set(Calendar.MINUTE,51); // min

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,12345678,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        android.app.AlarmManager alarmManager = (android.app.AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),5000,pendingIntent);
    }

}
