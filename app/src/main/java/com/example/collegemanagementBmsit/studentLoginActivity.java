package com.example.collegemanagementBmsit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class studentLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        Button studentLoginBtn = (Button) findViewById(R.id.student_login_button);
        studentLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentLoginToCategory = new Intent(studentLoginActivity.this, CategoryActivity.class);
                startActivity(studentLoginToCategory);
            }
        });
    }
}
