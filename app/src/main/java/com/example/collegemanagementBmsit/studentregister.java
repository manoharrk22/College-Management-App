package com.example.collegemanagementBmsit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class studentregister extends AppCompatActivity {
     EditText emailid,password;
    CardView signup;
    Button login;
    FirebaseAuth mfirebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentregister);
        mfirebaseauth=FirebaseAuth.getInstance();
        emailid=findViewById(R.id.student_register_username_edittext);
        password=findViewById(R.id.student_register_password_edittext);
        signup=findViewById(R.id.student_register_register_btn);
        login=findViewById(R.id.backtologin);
        signup.setOnClickListener(new View.OnClickListener(){
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
                                              Toast.makeText(studentregister.this,"fields are empty",Toast.LENGTH_SHORT).show();
                                          }
                                          else if(!(email.isEmpty() && pwd.isEmpty())){
                                                 mfirebaseauth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(studentregister.this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
      if(!task.isSuccessful()){
          Toast.makeText(studentregister.this,"signup unsuccessful",Toast.LENGTH_SHORT).show();
      }else{
startActivity(new Intent(studentregister.this, CategoryStudentActivity.class));
      }
    }
});
                                          }
                                          else{
                                              Toast.makeText(studentregister.this,"error occured!!!",Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }

        );
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(studentregister.this,studentLoginActivity.class);
                startActivity(i);
            }
        });
    }
}