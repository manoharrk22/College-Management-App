package com.example.collegemanagementBmsit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class CategoryStudentActivity extends AppCompatActivity {
    Button btn;
    FirebaseAuth mfirebaseauth;
    private FirebaseAuth.AuthStateListener mauthstatelistener;
    private CardView uploadGallerycardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_student);
        btn = findViewById(R.id.buttonlogout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(CategoryStudentActivity.this, studentLoginActivity.class);
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
