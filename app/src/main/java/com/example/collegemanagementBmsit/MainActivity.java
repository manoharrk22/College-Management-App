package com.example.collegemanagementBmsit;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout=findViewById(R.id.activity_main_layout);
        //Animation for gradient
        AnimationDrawable animationDrawable=(AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        CardView adminButton = (CardView) findViewById(R.id.activity_main_admin_btn);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "admin activity", Toast.LENGTH_LONG).show();
                Intent adminIntent = new Intent(MainActivity.this, AdminLoginActivity.class);
                startActivity(adminIntent);
            }
        });

        CardView studentButton = (CardView) findViewById(R.id.activity_main_student_btn);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "student activity", Toast.LENGTH_LONG).show();
                Intent studentIntent = new Intent(MainActivity.this, studentLoginActivity.class);
                startActivity(studentIntent);
            }
        });



    }
}