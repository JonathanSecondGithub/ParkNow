package com.example.parknow.data;

import com.example.parknow.data.model.LoggedInUser;
import com.google.firebase.auth.FirebaseAuth;

public class LoginRepository {

    private static volatile LoginRepository instance;

    private LoginDataSource dataSource;
    private FirebaseAuth firebaseAuth;
    private LoggedInUser user = null;

    // Public constructor
    public LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        firebaseAuth.signOut();
    }

    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public void login(String email, String password, LoginDataSource.LoginCallback callback) {
        dataSource.login(email, password, callback);
    }

    public void register(String email, String password, LoginDataSource.LoginCallback callback) {
        dataSource.register(email, password, callback);
    }
}
