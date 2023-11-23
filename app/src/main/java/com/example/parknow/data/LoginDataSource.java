package com.example.parknow.data;

import com.example.parknow.data.model.LoggedInUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

import java.io.IOException;

public class LoginDataSource {

    private FirebaseAuth firebaseAuth;

    public LoginDataSource() {
        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void login(String username, String password, LoginCallback callback) {
        try {
            // Firebase Authentication
            firebaseAuth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            if (firebaseUser != null) {
                                // Authentication successful
                                LoggedInUser loggedInUser = new LoggedInUser(
                                        firebaseUser.getUid(),
                                        firebaseUser.getDisplayName()
                                );
                                callback.onSuccess(loggedInUser);
                            }
                        } else {
                            // Authentication failed
                            Exception e = task.getException();
                            if (e instanceof FirebaseAuthInvalidUserException) {
                                // User not found
                                callback.onError(new IOException("User not found", e));
                            } else if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                // Invalid password
                                callback.onError(new IOException("Invalid password", e));
                            } else {
                                // Other authentication error
                                callback.onError(new IOException("Authentication failed", e));
                            }
                        }
                    });
        } catch (Exception e) {
            callback.onError(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // Firebase Logout
        firebaseAuth.signOut();
    }

    public void register(String email, String password, LoginCallback callback) {
        // Firebase User Registration
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Registration successful
                        // You might want to handle additional steps, like sending a verification email
                    } else {
                        // Registration failed
                        Exception e = task.getException();
                        if (e instanceof FirebaseAuthInvalidCredentialsException) {
                            // Invalid email or password format
                            // Handle the failure, e.g., display an error message to the user
                            callback.onError(new IOException("Invalid email or password format", e));
                        } else if (e instanceof FirebaseAuthInvalidUserException) {
                            // User already exists
                            // Handle the failure, e.g., display an error message to the user
                            callback.onError(new IOException("User already exists", e));
                        } else {
                            // Other registration error
                            // Handle the failure, e.g., display a generic error message to the user
                            callback.onError(new IOException("Registration failed", e));
                        }
                    }
                });
    }

    // Callback interface for login operations
    public interface LoginCallback {
        void onSuccess(LoggedInUser loggedInUser);
        void onError(Exception e);
    }
}
