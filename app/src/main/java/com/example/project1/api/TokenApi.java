package com.example.project1.api;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TokenApi {
    @POST("api/auth/login")
    Observable<Response<GetToken>> getToken(
        @Query("account") String mAccount,
        @Query("password") String mPassword
    );
    @GET("api/auth")
    Observable<Response<GetLogin>> getLogin(
            @Query("token") String mToken
    );
    @GET("api/app-search-customer")
    Observable<Response<List<GetCustomer>>> getCustomer(
            @Query("customer_name")String mCustomer_name
            ,@Query("token")String mToken
    );
    @GET("/api/app-search-so")
    Observable<Response<List<GetSoid>>> getSoid(
            @Query("so_id")String mSo_id
            ,@Query("token")String mToken
    );
    @GET("api/get-manufacture")
    Observable<Response<List<GetMo>>> getMo(
            @Query("customer_name")String mCustomer_name
            ,@Query("token")String mToken
            ,@Query("so_id")String mSo_id
    );
}
