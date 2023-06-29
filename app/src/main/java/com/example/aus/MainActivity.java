package com.example.aus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageSlider imageSlider;
    CardView cardgallery;
    CardView cardyoga;
    CardView cardworkshop;
    CardView cardlife;
    Button logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider=findViewById(R.id.imgslider);
        cardgallery=findViewById(R.id.Gallery);
        cardyoga=findViewById(R.id.Yoga);
        cardworkshop=findViewById(R.id.Workshop);
        cardlife=findViewById(R.id.Life);
        logout=findViewById(R.id.logout);


        ArrayList<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.a, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.b, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.be, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.de, ScaleTypes.FIT));


        imageSlider.setImageList(slideModels,ScaleTypes.FIT);




        cardgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Gallery clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Gallery.class));


            }
        });

        cardyoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Yoga clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Yoga.class));

            }
        });

        cardworkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Workshop clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Workshop.class));

            }
        });

        cardlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"LifeTrack clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),LifeTrack.class));

            }
        });

      logout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              FirebaseAuth.getInstance().signOut();
              Intent intent=new Intent(MainActivity.this,Login.class);
              startActivity(intent);
              finish();
          }
      });
    }
}