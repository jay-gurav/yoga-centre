package com.example.aus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class WaterReminder extends AppCompatActivity implements View.OnClickListener{

    private int notificationId=1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_reminder);

        findViewById(R.id.setbtn).setOnClickListener(this);
        findViewById(R.id.cancelbtn).setOnClickListener(this);

    }
    @Override
    public void onClick(View view){
        EditText editText=findViewById(R.id.editText);
        TimePicker timePicker=findViewById(R.id.timePicker);

        Intent intent=new Intent(WaterReminder.this,AlarmReceiver.class);
        intent.putExtra("notificationId",notificationId);
        intent.putExtra("todo",editText.getText().toString());

        PendingIntent alarmIntent=PendingIntent.getBroadcast(WaterReminder.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        switch(view .getId()){
            case R.id.setbtn:
                int hour= timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();

                Calendar startTime=Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE,minute);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime=startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);

                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}