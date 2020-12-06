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

public class CategoryStudentActivity extends AppCompatActivity {
    FloatingActionButton btn;
    FirebaseAuth mfirebaseauth;
    private FirebaseAuth.AuthStateListener mauthstatelistener;
    private CardView uploadGallerycardview;
    private CardView notice;
private CardView mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_student);
        btn =(FloatingActionButton) findViewById(R.id.buttonlogout);
        notice=(CardView)findViewById(R.id.addnotice1);
        mail=(CardView)findViewById(R.id.sendmail1);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent i=new Intent(CategoryStudentActivity.this,studentmail.class);
startActivity(i);
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryStudentActivity.this,viewnotice.class);
                Toast.makeText(CategoryStudentActivity.this,"notices",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(CategoryStudentActivity.this,studentLoginActivity.class);
                startActivity(i);
            }
        });


        uploadGallerycardview=(CardView)findViewById(R.id.addgalleryimage);
        uploadGallerycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uploadGalleryIntent=new Intent(CategoryStudentActivity.this,HomeActivity.class);
                Toast.makeText(CategoryStudentActivity.this,"add to Gallery",Toast.LENGTH_SHORT).show();
                startActivity(uploadGalleryIntent);
            }
        });
    }
}
