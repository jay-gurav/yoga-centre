package com.example.aus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Long3;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {
    private ImageSlider imageSlider;

    CardView addphotos;
    CardView addyoga;
    CardView addworkshop;
    CardView addtips;
    Button logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        imageSlider=findViewById(R.id.imagesslider);
        addphotos=findViewById(R.id.upload_gallery);
        addyoga=findViewById(R.id.upload_yoga);
        addworkshop=findViewById(R.id.upload_workshop);
        addtips=findViewById(R.id.uploade_tips);
        logoutbtn=findViewById(R.id.loginBtn);

        ArrayList<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.a, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.b, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.be, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.de, ScaleTypes.FIT));


        imageSlider.setImageList(slideModels,ScaleTypes.FIT);


        addphotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin.this, "Upload Yoga clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),UploadPhotos.class));
                finish();
            }
        });

        addyoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin.this,"Upload Yoga clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),UploadYoga.class));


            }
        });


        addworkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin.this,"Upload Workshop clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),UploadWorkshop.class));


            }
        });

        addtips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin.this,"Upload Tips clicked",Toast.LENGTH_SHORT);
                startActivity(new Intent(getApplicationContext(),UploadTips.class));

            }
        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(Admin.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }


}