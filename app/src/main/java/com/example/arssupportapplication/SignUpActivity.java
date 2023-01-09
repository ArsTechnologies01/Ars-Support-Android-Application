package com.example.arssupportapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;


public class SignUpActivity extends AppCompatActivity {

    TextInputEditText fullName, email, phoneNumber, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /* ---------------Hooks-----------*/
        fullName = findViewById(R.id.signUpFullName);
        email = findViewById(R.id.signUpEmail);
        phoneNumber = findViewById(R.id.signUpPhoneNum);
        password = findViewById(R.id.signUpPassword);
        confirmPassword = findViewById(R.id.signUpConfirmPassword);


        /* ---------onClick to login Btn------------*/
        findViewById(R.id.loginAcc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        /* ---------SignUp Button------------*/
        findViewById(R.id.signUpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validateName() | !validateEmail() | !validatePhoneNumber() | !validatePassword() | !validateConfirmPassword()) {
                    return;
                }
                if (!Objects.requireNonNull(password.getText()).toString().equals(Objects.requireNonNull(confirmPassword.getText()).toString())){
                    TextInputLayout passwordLayout = findViewById(R.id.confirmPasswordEditTextLayout);
                    passwordLayout.setError("Password does not match");
                    return;
                }
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });

    }

    /* ------------SignUp Details validation----------------*/

    private Boolean validateName() {
        String val = Objects.requireNonNull(fullName.getText()).toString();

        if (val.isEmpty()) {
            fullName.setError("Field cannot be empty!");
            return false;
        }
        return true;
    }

    private Boolean validateEmail() {
        String val = Objects.requireNonNull(email.getText()).toString();

        if (val.isEmpty()) {
            email.setError("Cannot be empty!");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(val).matches()){
            email.setError("Enter valid email");
            return false;
        }
        return true;
    }

    private Boolean validatePhoneNumber() {
        String val = Objects.requireNonNull(phoneNumber.getText()).toString();

        if (val.isEmpty()) {
            phoneNumber.setError("Cannot be empty");
            return false;
        }
        return true;
    }
    private Boolean validatePassword() {
        TextInputLayout passwordLayout = findViewById(R.id.passwordEditTextLayout);
        String val = Objects.requireNonNull(passwordLayout.getEditText()).getText().toString();
        String passwordMatcher = "^" +
                "(?=.*[@#$%^&+=])" +     // at least 1 special character
                "(?=\\S+$)" +            // no white spaces
                ".{4,}" +                // at least 4 characters
                "$";

        if (val.isEmpty()) {
            passwordLayout.setError("Cannot be empty!");
            return false;
        }else if (!val.matches(passwordMatcher)){
            passwordLayout.setError("Password is too weak");
            return false;
        }
        passwordLayout.setErrorEnabled(false);
        return true;
    }
    private Boolean validateConfirmPassword(){
        TextInputLayout passwordLayout = findViewById(R.id.confirmPasswordEditTextLayout);
        String val = Objects.requireNonNull(passwordLayout.getEditText()).getText().toString();

        if (val.isEmpty()) {
            passwordLayout.setError("Cannot be empty!");
            return false;
        }
        passwordLayout.setErrorEnabled(false);
        return true;
    }
}