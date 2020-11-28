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

public class studentLoginActivity extends AppCompatActivity {
    public EditText emailid,password;
    CardView signin;
    Button signup;
    FirebaseAuth mfirebaseauth;
    private FirebaseAuth.AuthStateListener mauthstatelistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);
        mfirebaseauth=FirebaseAuth.getInstance();
        emailid=findViewById(R.id.student_login_username_edittext);
        password=findViewById(R.id.student_login_password_edittext);
        signin=findViewById(R.id.student_login_login_btn);
        signup=findViewById(R.id.student_login_registerHere_btn);
       mauthstatelistener=new FirebaseAuth.AuthStateListener() {
           @Override
           public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
               FirebaseUser mfirebaseuser=mfirebaseauth.getCurrentUser();
               if(mfirebaseuser!=null){
                   Toast.makeText(studentLoginActivity.this,"you are logged in",Toast.LENGTH_SHORT).show();
                   Intent i=new Intent(studentLoginActivity.this,CategoryStudentActivity.class);
                   startActivity(i);
               }else{
                   Toast.makeText(studentLoginActivity.this,"plese login",Toast.LENGTH_SHORT).show();
               }
           }
       };
       signin.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View view) {
                                         String email=emailid.getText().toString();
                                         String pwd=password.getText().toString();
                                         if(email.isEmpty()){
                                             emailid.setError("plese enter your email");
                                             emailid.requestFocus();
                                         }
                                         else if(pwd.isEmpty()){
                                             emailid.setError("plese enter your password");
                                             emailid.requestFocus();
                                         }
                                         else if(email.isEmpty() && pwd.isEmpty()){
                                             Toast.makeText(studentLoginActivity.this,"fields are empty",Toast.LENGTH_SHORT).show();
                                         }
                                         else if(!(email.isEmpty() && pwd.isEmpty())){
                                             mfirebaseauth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(studentLoginActivity.this, new OnCompleteListener<AuthResult>() {
                                                 @Override
                                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                                     if(!task.isSuccessful()){
                                                         Toast.makeText(studentLoginActivity.this,"login error,please login again",Toast.LENGTH_SHORT).show();
                                                     }else{
                                                         Intent intocategory=new Intent(studentLoginActivity.this,CategoryStudentActivity.class);
                                                         startActivity(intocategory);
                                                     }
                                                 }
                                             });
                                         }
                                         else{
                                             Toast.makeText(studentLoginActivity.this,"error occured!!!",Toast.LENGTH_SHORT).show();
                                         }
                                     }
                                 }
       );
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intosignup=new Intent(studentLoginActivity.this,studentregister.class);
                startActivity(intosignup);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mfirebaseauth.addAuthStateListener(mauthstatelistener);
    }
}
