package com.example.mvp_pattern.main;

import com.example.mvp_pattern.main.model.UserListDTO;

import java.util.ArrayList;

public interface MainView {

    void showProgressBar();
    void hideProgressBar();
    void addItems(ArrayList<UserListDTO> users);
    void showMessage(String message);
}
