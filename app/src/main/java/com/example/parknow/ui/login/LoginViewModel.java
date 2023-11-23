package com.example.parknow.ui.login;
import android.util.Patterns;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.parknow.R;
import com.example.parknow.data.LoginDataSource;
import com.example.parknow.data.LoginRepository;
import com.example.parknow.data.Result;
import com.example.parknow.data.model.LoggedInUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String email, String password) {
        // Check for a valid email and password format
        if (!isUserNameValid(email) || !isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, R.string.invalid_password));
            return;
        }

        // Call the login method in the LoginRepository
        loginRepository.login(email, password, new LoginDataSource.LoginCallback() {
            @Override
            public void onSuccess(LoggedInUser loggedInUser) {
                LoggedInUserView loggedInUserView = new LoggedInUserView(loggedInUser.getDisplayName());
                loginResult.setValue(new LoginResult(loggedInUserView));
            }

            @Override
            public void onError(Exception e) {
                // Handle Firebase authentication errors
                loginResult.setValue(new LoginResult(e));
            }
        });
    }

    public void loginDataChanged(String email, String password) {
        if (!isUserNameValid(email)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String email) {
        return email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
