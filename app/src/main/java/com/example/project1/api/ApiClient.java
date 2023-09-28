package com.example.project1.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public Retrofit getApi(){
        return new Retrofit.Builder()
                .baseUrl("http://10.20.1.2:8089/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory.create())
                .build();
    }
}
