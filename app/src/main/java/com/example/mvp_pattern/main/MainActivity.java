package com.example.mvp_pattern.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvp_pattern.R;
import com.example.mvp_pattern.main.model.UserListDTO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        components();
    }

    void components()
    {

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        mainPresenter = new MainPresenter(this,new MainInteractor());

        events();
    }

    void events()
    {

    }


    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();

    }

    @Override
    public void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void addItems(ArrayList<UserListDTO> users) {
        recyclerView.setAdapter(new UserAdapter(users,MainActivity.this,mainPresenter::onItemClick));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }

}
