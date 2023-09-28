package com.example.project1.ui.progresspage;

import android.content.Context;
import android.util.Log;

import com.example.project1.api.ApiClient;
import com.example.project1.api.GetCustomer;
import com.example.project1.api.GetMo;
import com.example.project1.api.GetSoid;
import com.example.project1.api.TokenApi;
import com.example.project1.sharedpreferences.SharedPre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DefaultObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;

public class SearchPagePresenter implements SearchPageContract.SearchPagePresenter{
    private SearchPageContract.view conView;
    private ApiClient apiClient;
    private TokenApi tokenApi;
    private SharedPre sharedPre;
    private List<GetMo> getMoList;

    public SearchPagePresenter(SearchPageContract.view view,Context context){
        this.conView = view;
        apiClient = new ApiClient();
        tokenApi = apiClient.getApi().create(TokenApi.class);
        sharedPre = new SharedPre(context);
    }
    public interface DataCallback {
        void onDataReady(ArrayList<HashMap<String, String>> dataList);
    }


    @Override
    public void getCustomerName(String key, String token) {
        tokenApi.getCustomer(key,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DefaultObserver<Response<List<GetCustomer>>>() {
                    @Override
                    public void onNext(@NonNull Response<List<GetCustomer>> listResponse) {
                        ArrayList<String> data = new ArrayList<>();
                        for(GetCustomer customerList: listResponse.body() ){
                            data.add(customerList.customer_name);
                        }
                        conView.getCustomerName(data);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getSoid(String key, String token) {
        tokenApi.getSoid(key,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DefaultObserver<Response<List<GetSoid>>>() {
                    @Override
                    public void onNext(@NonNull Response<List<GetSoid>> listResponse) {
                        ArrayList<String> data = new ArrayList<>();
                        for(GetSoid soidList: listResponse.body() ){
                            data.add(soidList.so_id);
                        }
                        conView.getSoid(data);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMo(String customer, String soid, String token) {
        tokenApi.getMo(customer,token,soid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DefaultObserver<Response<List<GetMo>>>() {
                    @Override
                    public void onNext(@NonNull Response<List<GetMo>> listResponse) {
                        getMoList = listResponse.body();
//                        ArrayList<String> customerData = new ArrayList<>();
//                        ArrayList<String> soidData = new ArrayList<>();
//                        for(GetMo moList: listResponse.body() ){
//                            customerData.add(moList.so_id);
//                            soidData.add(moList.customer);
//                        }
//                        conView.getMo(customerData,soidData);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TAG", "onError: " + e.toString() );
                        conView.dataError();
                    }
                    @Override
                    public void onComplete() {
                        conView.dataSuccess( getMoList);
                    }
                });

    }
}
