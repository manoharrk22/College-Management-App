package com.example.collegemanagementBmsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class adminregister extends AppCompatActivity {
    Button backlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminregister);
        backlogin=(Button) findViewById(R.id.backtologin);
        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(adminregister.this,AdminLoginActivity.class);
                Toast.makeText(adminregister.this,"login here",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

    }
}