package com.example.mvp_pattern.login;

public interface LoginView {

    void showProgressBar();
    void hideProgressBar();
    void setUserNameEmpty(String message);
    void setPasswordEmpty(String message);
    void setUserNameError(String message);
    void setPasswordError(String message);
    void loginSuccessful();
    void loginError(String message);

}
