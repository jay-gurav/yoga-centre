package com.example.aus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class LifeTrack extends AppCompatActivity {

    CardView cardstepcounter;
    CardView cardwaterreminder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_track);


        cardstepcounter=findViewById(R.id.stepcounteractivity);
        cardwaterreminder=findViewById(R.id.waterreminder);

        cardstepcounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Step.class));
            }
        });

        cardwaterreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),WaterReminder.class));
            }
        });
    }


}


