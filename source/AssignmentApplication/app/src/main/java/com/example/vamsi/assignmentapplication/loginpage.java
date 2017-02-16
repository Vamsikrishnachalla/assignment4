package com.example.vamsi.assignmentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {
    String susername;
    String spwd;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
          username = (EditText) findViewById(R.id.username);
         password = (EditText) findViewById(R.id.password);
         //Button login = (Button) findViewById(R.id.login);
         //Button signup = (Button) findViewById(R.id.register);

        }



    public void redirect(View V) {
        Intent xyz = new Intent(loginpage.this, RegisterPage.class);
        startActivity(xyz);
    }

    public void login1(View V)
    {
        susername = username.getText().toString();
        spwd = password.getText().toString();
        boolean validationFlag = false;
        //Verify if the username and password are not empty.
        if (susername.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"User is blank",Toast.LENGTH_SHORT).show();
        }
        if(!susername.isEmpty() && !spwd.isEmpty()) {
            if(susername.equals("Admin") && spwd.equals("Admin")) {
                validationFlag = true;
                Intent pqr = new Intent(loginpage.this,MainPage.class);
                startActivity(pqr);

            }
            if (!validationFlag) {
                Toast.makeText(getApplicationContext(), "Enter Credentials", Toast.LENGTH_SHORT).show();
            }
    }}}





