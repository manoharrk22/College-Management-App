package com.example.collegemanagementBmsit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminLoginActivity extends AppCompatActivity {
    public EditText emailid, password;
    CardView signin;
    Button signup;
    FirebaseAuth mfirebaseauth;
    private FirebaseAuth.AuthStateListener mauthstatelistener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        mfirebaseauth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.admin_login_username_edittext);
        password = findViewById(R.id.admin_login_password_edittext);
        signin = (CardView) findViewById(R.id.admin_login_login_btn);
        signup=(Button)findViewById(R.id.button1);
        mauthstatelistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfirebaseuser = mfirebaseauth.getCurrentUser();
                if (mfirebaseuser != null) {
                    Toast.makeText(AdminLoginActivity.this, "you are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(AdminLoginActivity.this, CategoryAdminActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(AdminLoginActivity.this, "plese login", Toast.LENGTH_SHORT).show();
                }
            }
        };
        signin.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          String email = emailid.getText().toString();
                                          String pwd = password.getText().toString();
                                          if (email.isEmpty()) {
                                              emailid.setError("plese enter your email");
                                              emailid.requestFocus();
                                          } else if (pwd.isEmpty()) {
                                              emailid.setError("plese enter your password");
                                              emailid.requestFocus();
                                          } else if (email.isEmpty() && pwd.isEmpty()) {
                                              Toast.makeText(AdminLoginActivity.this, "fields are empty", Toast.LENGTH_SHORT).show();
                                          } else if (!(email.isEmpty() && pwd.isEmpty())) {
                                              mfirebaseauth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(AdminLoginActivity.this, new OnCompleteListener<AuthResult>() {
                                                  @Override
                                                  public void onComplete(@NonNull Task<AuthResult> task) {
                                                      if (!task.isSuccessful()) {
                                                          Toast.makeText(AdminLoginActivity.this, "login error,please login again", Toast.LENGTH_SHORT).show();
                                                      } else {
                                                          Intent intocategory = new Intent(AdminLoginActivity.this, CategoryAdminActivity.class);
                                                          startActivity(intocategory);
                                                      }
                                                  }
                                              });
                                          } else {
                                              Toast.makeText(AdminLoginActivity.this, "error occured!!!", Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }
        );






























        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminLoginActivity.this,"admin register",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(AdminLoginActivity.this,adminregister.class);
                startActivity(i);
            }
        });
    }
}
