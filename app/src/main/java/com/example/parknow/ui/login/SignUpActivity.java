// SignUpActivity.java
package com.example.parknow.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parknow.HomePageActivity;
import com.example.parknow.R;
import com.example.parknow.data.LoginDataSource;
import com.example.parknow.data.LoginRepository;
import com.example.parknow.data.model.LoggedInUser;
import com.example.parknow.user;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {


    private EditText email, password,name,regno,phoneno;
    private Button signup, login;

    private LoginRepository loginRepository;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

//        String carReg = regno.getText().toString().trim();


        email = findViewById(R.id.edittext_email);
        password = findViewById(R.id.password);

        name = findViewById(R.id.name);
        regno = findViewById(R.id.carreg);
        phoneno = findViewById(R.id.phone);


        signup = findViewById(R.id.signupbtn);
        login = findViewById(R.id.loginbtn);

        loginRepository = new LoginRepository(new LoginDataSource());

        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString().trim();
                String userPassword = password.getText().toString().trim();

                if (isValidInput(userEmail, userPassword)) {
                    registerUser(userEmail, userPassword);
                    insertUserData();
                    Intent intent = new Intent(SignUpActivity.this, HomePageActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the login activity
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void insertUserData(){

        String name1 = name.getText().toString();
        String carregistration = regno.getText().toString();
        String phone = phoneno.getText().toString();
        String email1 = email.getText().toString();
        String pass = password.getText().toString();

        user newuser = new user(name1,carregistration,phone,email1,pass);
        mDatabase.push().setValue(newuser);
        Toast.makeText(SignUpActivity.this, "SIGNED UP!!", Toast.LENGTH_SHORT).show();

    }

    private boolean isValidInput(String email, String password) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length() >= 6;
    }

    private void registerUser(String email, String password) {
        loginRepository.register(email, password, new LoginDataSource.LoginCallback() {
            @Override
            public void onSuccess(LoggedInUser loggedInUser) {
                Intent intent = new Intent(SignUpActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(SignUpActivity.this, "Registration failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
