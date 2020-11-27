package com.example.collegemanagementBmsit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        CardView adminLoginBtn= (CardView) findViewById(R.id.admin_login_login_btn);
        adminLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminLoginToCategoryIntent = new Intent(AdminLoginActivity.this, CategoryActivity.class);
                startActivity(adminLoginToCategoryIntent);
            }
        });
    }
}
