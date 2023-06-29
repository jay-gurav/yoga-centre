package com.example.aus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView textView;
    Button animatedbutton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        animatedbutton=findViewById(R.id.animatedbtn);


        TextView textView=findViewById(R.id.animatedText);
        textView.animate().translationX(1000).setDuration(1000).setStartDelay(2500);


        animatedbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


    }

}