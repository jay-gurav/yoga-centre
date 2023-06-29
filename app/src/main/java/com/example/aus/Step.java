package com.example.aus;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Step extends AppCompatActivity {


    private TextView textView;
    private double MagnitudePrevious =0;
    private Integer stepcount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);


        textView=findViewById(R.id.STEP);
        SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        SensorEventListener stepDetector=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent!=null){
                    float x_acceleration=sensorEvent.values[0];
                    float y_acceleration=sensorEvent.values[1];
                    float z_acceleration=sensorEvent.values[2];

                    double Magnitude=Math.sqrt(x_acceleration*x_acceleration + y_acceleration*y_acceleration +z_acceleration*z_acceleration);
                    double MagnitudeDelta= Magnitude-MagnitudePrevious;
                    MagnitudePrevious=Magnitude;
                    if(MagnitudeDelta>6){
                        stepcount++;
                    }
                    textView.setText(stepcount.toString());
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }


        };
        sensorManager.registerListener(stepDetector,sensor,SensorManager.SENSOR_DELAY_NORMAL);




    }
}