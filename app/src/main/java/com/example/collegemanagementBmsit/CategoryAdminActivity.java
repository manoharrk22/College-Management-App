package com.example.collegemanagementBmsit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CategoryAdminActivity extends AppCompatActivity {
    CardView notice;
    private CardView uploadGallerycardview;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_admin);
        notice=(CardView)findViewById(R.id.addnotice1);
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
                Intent uploadGalleryIntent=new Intent(CategoryAdminActivity.this,AddToGalleryActivity.class);
                Toast.makeText(CategoryAdminActivity.this,"add to Gallery",Toast.LENGTH_SHORT).show();
                startActivity(uploadGalleryIntent);
            }
        });
    }
}
