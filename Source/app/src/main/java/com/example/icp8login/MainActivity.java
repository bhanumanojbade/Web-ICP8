package com.example.icp8login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Defining username and password
    private final String dUsername = "Web";
    private final String dPassword = "Web123";
    // declaring variables
    private EditText userName;
    private EditText password;
    private TextView attempt;
    private Button login;
    int stepDown=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //variable binding
        userName=findViewById(R.id.username);
        password=findViewById(R.id.password);
        attempt=findViewById(R.id.attempt);
        login=findViewById(R.id.clickLoginButton);
        // method execution
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameInput = userName.getText().toString();
                String passwordInput = password.getText().toString();

                //username and password input checking
                if(usernameInput.isEmpty() || passwordInput.isEmpty()){
                    //empty case
                    Toast.makeText(MainActivity.this,"UserName/Password should not be empty",Toast.LENGTH_SHORT).show();
                }else{
                    // validation case
                      if(dUsername.equals(usernameInput) && dPassword.equals(passwordInput)){
                          Toast.makeText(MainActivity.this,"Login successfully done",Toast.LENGTH_SHORT).show();
                          // Navigating to new Activity Page
                          Intent navToNew = new Intent(MainActivity.this, HomePage.class);
                          startActivity(navToNew);
                      }else{
                          // counter value decrement
                          stepDown --;
                          attempt.setText("Attempts left: "+stepDown);
                          // error message display
                          Toast.makeText(MainActivity.this,"Enter Valid UserName/Password",Toast.LENGTH_SHORT).show();
                          if(stepDown ==0){
                              login.setEnabled(false);
                          }
                      }
                }
            }
        });
    }

}