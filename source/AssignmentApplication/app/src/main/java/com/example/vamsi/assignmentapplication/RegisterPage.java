package com.example.vamsi.assignmentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
    }

    public void home(View V)
    {
        Intent abc = new Intent(RegisterPage.this,loginpage.class);
        startActivity(abc);
    }
}
