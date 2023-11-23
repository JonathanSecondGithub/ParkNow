// LoginActivity.java
package com.example.parknow.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parknow.HomePageActivity;
import com.example.parknow.R;
import com.example.parknow.data.LoginDataSource;
import com.example.parknow.data.LoginRepository;
import com.example.parknow.data.model.LoggedInUser;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button login, signup;

    private LoginRepository loginRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.edittext_email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.loginbtn1);
        signup = findViewById(R.id.signupbtn1);

        loginRepository = new LoginRepository(new LoginDataSource());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString().trim();
                String userPassword = password.getText().toString().trim();

                if (isValidInput(userEmail, userPassword)) {
                    loginUser(userEmail, userPassword);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean isValidInput(String email, String password) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length() >= 6;
    }

    private void loginUser(String email, String password) {
        loginRepository.login(email, password, new LoginDataSource.LoginCallback() {
            @Override
            public void onSuccess(LoggedInUser loggedInUser) {
                Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(LoginActivity.this, "Login failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
