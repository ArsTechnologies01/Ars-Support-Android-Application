package com.example.arssupportapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText phoneNum, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* ---------------Hooks-----------*/
        phoneNum = findViewById(R.id.loginPhoneNum);
        password = findViewById(R.id.loginPassword);


        /* ---------onClick to signUp Btn------------*/
        findViewById(R.id.signUpAcc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });

        /* ---------Login Button------------*/
        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }
}