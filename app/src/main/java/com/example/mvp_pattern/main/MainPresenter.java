package com.example.mvp_pattern.main;

import com.example.mvp_pattern.main.model.UserListDTO;

import java.util.ArrayList;

public class MainPresenter implements MainInteractor.FinishedListener {

    private MainView mainView;
    private MainInteractor mainInteractor;

    MainPresenter(MainView mainView, MainInteractor mainInteractor)
    {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }

    void onResume()
    {
        if(mainView!=null) mainView.showProgressBar();

        mainInteractor.loadItems(this);
    }

    void onDestroy()
    {
        mainView = null;
    }

    void onItemClick( UserListDTO userListDTO)
    {
        if(mainView!=null) mainView.showMessage(userListDTO.getUserName());

    }


    @Override
    public void onFinishLoadingItems(ArrayList<UserListDTO> users) {
        if(mainView!=null)
        {
            mainView.hideProgressBar();
            mainView.addItems(users);
        }
    }
}
