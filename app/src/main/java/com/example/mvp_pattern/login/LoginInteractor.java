package com.example.mvp_pattern.login;

import android.os.Handler;
import android.text.TextUtils;
import com.example.mvp_pattern.Utils;


class LoginInteractor {

    // Implementing all events posibles at login

    interface OnLoginFinishedListener{
            void onUserNameEmpty();
            void onPasswordEmpty();
            void onUserNameError();
            void onPasswordError();
            void onLoginSuccess();
            void onLoginError();

    }

    void logIn(final String userName , final String password , final OnLoginFinishedListener listener)
    {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(userName))
                {
                    listener.onUserNameEmpty();
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    listener.onPasswordEmpty();
                    return;
                }

                if(!userName.equals("admin"))
                {
                    listener.onUserNameError();
                    return;
                }

                if(!password.equals("123"))
                {
                    listener.onPasswordError();
                    return;
                }

                if(Utils.Enviroment.equals("Development"))
                {
                    listener.onLoginSuccess();
                }
                else
                {
                    listener.onLoginError();
                }

            }


        },400);

    }
}
