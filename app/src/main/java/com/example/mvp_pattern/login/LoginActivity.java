package com.example.mvp_pattern.login;
import com.example.mvp_pattern.R;
import com.example.mvp_pattern.main.MainActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginView {

    // Initialize id from components

    EditText edtUser,edtPassword;
    Button btnLogin;
    ProgressBar progressBar;

    // Initialize LoginPresenter
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Loading components
        components();
    }

    void components()
    {

        // Set LoginPresenter with params of constructor.
        // this : context of loginView , loginInteractor and context of LoginActivity

        loginPresenter = new LoginPresenter(this,new LoginInteractor(),LoginActivity.this);

        edtUser = findViewById(R.id.edtUser);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);
        edtPassword = findViewById(R.id.edtPassword);

        // Set events to components
        events();


    }

    void events()
    {
        btnLogin.setOnClickListener(LoginActivity.this);
    }

    @Override
    public void onClick(View v) {
        loginPresenter.validateLogin(edtUser.getText().toString(),edtPassword.getText().toString());
    }

    @Override
    public void showProgressBar() {
        btnLogin.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        btnLogin.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameEmpty(String message) {
        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordEmpty(String message) {
        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUserNameError(String message) {
        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError(String message) {
        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginSuccessful() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void loginError(String message) {
        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    // cyclelife of activity

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }
}
