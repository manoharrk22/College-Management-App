package com.example.collegemanagementBmsit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class adminregister extends AppCompatActivity {
    Button backlogin;
    EditText emailid, password;
    CardView signup;
    FirebaseAuth mfirebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminregister);
        backlogin=(Button) findViewById(R.id.backtologin);
        mfirebaseauth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.textview1);
        password = findViewById(R.id.textview2);
        signup = findViewById(R.id.regiserbutton);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailid.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailid.setError("plese enter your email");
                    emailid.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("plese enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(adminregister.this, "fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mfirebaseauth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(adminregister.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(adminregister.this, "signup unsuccessful", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(adminregister.this, CategoryAdminActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(adminregister.this, "error occured!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
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