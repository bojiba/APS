package com.example.project1.ui.login;

public interface LoginContract {
    interface tokenPresenter {
        void getTokenData(String account , String password);
    }
    interface loginPresenter{
        void getLoginData(String token);

        void getTokenData(String account, String password);
    }

    interface view{
        void dataError();
        void dataSuccess();
        void showData(String data);
    }
}
