package com.example.parknow.ui.login;

import androidx.annotation.Nullable;

/**
 * Authentication result: success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private LoggedInUserView success;
    @Nullable
    private Integer errorRes; // Resource ID for string error message
    @Nullable
    private Exception firebaseError; // Add Firebase error field

    LoginResult(@Nullable Integer errorRes) {
        this.errorRes = errorRes;
        this.firebaseError = null;
        this.success = null;
    }

    LoginResult(@Nullable LoggedInUserView success) {
        this.success = success;
        this.errorRes = null;
        this.firebaseError = null;
    }

    LoginResult(@Nullable Exception firebaseError) {
        this.firebaseError = firebaseError;
        this.success = null;
        this.errorRes = null;
    }

    @Nullable
    LoggedInUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getErrorRes() {
        return errorRes;
    }

    @Nullable
    Exception getFirebaseError() {
        return firebaseError;
    }
}
