//package com.example.project1.ui.plan.sche;
//
//import android.content.Context;
//
//import com.example.project1.api.ApiClient;
//import com.example.project1.api.TokenApi;
//import com.example.project1.sharedpreferences.SharedPre;
//import com.example.project1.ui.progresspage.SearchPageContract;
//
//public class SchePresenter implements ScheContract.SchePresenter{
//    private ScheContract.view conView;
//    private ApiClient apiClient;
//    private TokenApi tokenApi;
//    private SharedPre sharedPre;
//
//    public SchePresenter(ScheContract.view view, Context context){
//        this.conView = view;
//        apiClient = new ApiClient();
//        tokenApi = apiClient.getApi().create(TokenApi.class);
//        sharedPre = new SharedPre(context);
//    }
//
//    @Override
//    public void getMo(String customer,String soid,String token) {
//    }
//}
