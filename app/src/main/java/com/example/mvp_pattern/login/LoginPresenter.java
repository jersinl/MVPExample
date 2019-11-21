package com.example.mvp_pattern.login;

import android.content.Context;
import com.example.mvp_pattern.R;

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView _loginView;
    private LoginInteractor _loginInteractor;
    private Context _context;

    LoginPresenter(LoginView loginView, LoginInteractor loginInteractor, Context context)
    {
        _loginView = loginView;
        _loginInteractor = loginInteractor;
        _context = context;

    }

    void validateLogin(String userName, String password)
    {
        if(_loginView!=null) _loginView.showProgressBar();

        _loginInteractor.logIn(userName,password,this);
    }

    void onDestroy()
    {
        _loginView = null;
    }

    @Override
    public void onUserNameEmpty() {

        if(_loginView!=null)
        {
            _loginView.setUserNameEmpty(_context.getResources().getString(R.string.message_login_userEmpty));
            _loginView.hideProgressBar();
        }

    }

    @Override
    public void onPasswordEmpty() {
        if(_loginView!=null)
        {
            _loginView.setPasswordEmpty(_context.getResources().getString(R.string.message_login_passwordEmpty));
            _loginView.hideProgressBar();
        }

    }

    @Override
    public void onUserNameError() {

        if(_loginView!=null)
        {
            _loginView.setUserNameError(_context.getResources().getString(R.string.message_login_userError));
            _loginView.hideProgressBar();
        }
    }

    @Override
    public void onPasswordError() {

        if(_loginView!=null)
        {
            _loginView.setPasswordError(_context.getResources().getString(R.string.message_login_passwordError));
            _loginView.hideProgressBar();
        }

    }

    @Override
    public void onLoginSuccess() {

        if(_loginView!=null)
        {
            _loginView.loginSuccessful();
            _loginView.hideProgressBar();
        }

    }

    @Override
    public void onLoginError() {

        if(_loginView!=null)
        {
            _loginView.loginError(_context.getResources().getString(R.string.messae_loginError));
            _loginView.hideProgressBar();
        }
    }
}
