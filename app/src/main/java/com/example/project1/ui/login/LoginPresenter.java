package com.example.project1.ui.login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.project1.api.ApiClient;
import com.example.project1.api.GetLogin;
import com.example.project1.api.GetToken;
import com.example.project1.api.TokenApi;
import com.example.project1.sharedpreferences.SharedPre;
import com.example.project1.ui.mainpage.MainPageActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.tokenPresenter{
    private LoginContract.view conView;
    private ApiClient apiClient;
    private TokenApi tokenApi;
    SharedPre sharedPre;

    public LoginPresenter(LoginContract.view view,Context context){
        this.conView = view;
        apiClient = new ApiClient();
        sharedPre = new SharedPre(context);
        tokenApi = apiClient.getApi().create(TokenApi.class);
    }
    @Override
    public void getTokenData(String account, String password) {
        if(account.equals("") || password.equals("")) {
            return;
        }
        tokenApi.getToken(account,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<Response<GetToken>>() {
                    @Override
                    public void onNext(@NonNull Response<GetToken> getTokenResponse) {
                        if(getTokenResponse.code() == 200) {
                            sharedPre.setToken("");
                            String tokenData = getTokenResponse.body().token;
                            sharedPre.setToken(tokenData);
                            getLoginData();
                        }
                        else{

                            conView.dataError();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("test",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getLoginData() {
        tokenApi.getLogin(sharedPre.getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<Response<GetLogin>>() {
                @Override
            public void onNext(@NonNull Response<GetLogin> getLoginResponse) {
                sharedPre.setName(getLoginResponse.body().name);
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
                conView.dataSuccess();
            }
        });
    }
}
