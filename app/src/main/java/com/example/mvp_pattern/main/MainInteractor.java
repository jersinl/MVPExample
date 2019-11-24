package com.example.mvp_pattern.main;

import android.os.Handler;

import com.example.mvp_pattern.main.model.UserListDTO;

import java.util.ArrayList;

class MainInteractor {

    interface FinishedListener
    {
        void onFinishLoadingItems(ArrayList<UserListDTO> users);
    }

    void loadItems(final FinishedListener listener)
    {
        new Handler().postDelayed(() -> {

            ArrayList<UserListDTO> users = new ArrayList<>();

            UserListDTO user = new UserListDTO();
            user.setUserId(1);
            user.setUserName("jlazaro");
            user.setEmail("jlazaro@gmail.com");
            user.setAdmin(false);

            users.add(user);

            UserListDTO userdto = new UserListDTO();
            userdto.setUserId(2);
            userdto.setUserName("Admin");
            userdto.setEmail("admin@gmail.com");
            userdto.setAdmin(true);

            users.add(userdto);

            listener.onFinishLoadingItems(users);


        },5000);
    }


}
