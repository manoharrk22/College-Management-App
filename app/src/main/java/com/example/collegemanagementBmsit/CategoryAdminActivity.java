package com.example.collegemanagementBmsit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class CategoryAdminActivity extends AppCompatActivity {
    CardView mail;
    CardView notice;
    private CardView uploadGallerycardview;
    FirebaseAuth mfirebaseauth;
    private FirebaseAuth.AuthStateListener mauthstatelistener;
    FloatingActionButton logout;
    CardView staff;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_admin);
        notice=(CardView)findViewById(R.id.addnotice1);
        mail=(CardView)findViewById(R.id.sendmail);
        logout=(FloatingActionButton)findViewById(R.id.buttonlogout) ;
        staff=(CardView)findViewById(R.id.faculty);
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CategoryAdminActivity.this, staffdetails.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(CategoryAdminActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i=new Intent(CategoryAdminActivity.this,adminmail.class);
              startActivity(i);
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryAdminActivity.this,addnotice.class);
                Toast.makeText(CategoryAdminActivity.this,"add notice",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        uploadGallerycardview=(CardView)findViewById(R.id.addgalleryimage);
        uploadGallerycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uploadGalleryIntent=new Intent(CategoryAdminActivity.this,HomeActivity.class);
                Toast.makeText(CategoryAdminActivity.this,"add to Gallery",Toast.LENGTH_SHORT).show();
                startActivity(uploadGalleryIntent);
            }
        });
    }
}
