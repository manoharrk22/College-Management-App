package com.example.collegemanagementBmsit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView cardView=(CardView) findViewById(R.id.loginbutton);
        cardView.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view) {
                                            Toast.makeText(view.getContext(),"category",Toast.LENGTH_SHORT).show();
                                            Intent i=new Intent(view.getContext(),Category.class);
                                            startActivity(i);
                                        }
                                    }

        );
        Button button=(Button) findViewById(R.id.registerbutton);
        button.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View view) {
                                          Toast.makeText(view.getContext(),"register",Toast.LENGTH_SHORT).show();
                                          Intent i=new Intent(view.getContext(),register.class);
                                          startActivity(i);
                                      }
                                  }

        );
    }
}