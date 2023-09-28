package com.example.project1.ui.progresspage;

import com.example.project1.api.GetMo;

import java.util.ArrayList;
import java.util.List;

public interface SearchPageContract {
    interface SearchPagePresenter{
        void getCustomerName(String key,String token);
        void getSoid(String key,String token);
        void getMo(String customer, String soid, String token );
    }
    interface view{
        void dataError();
        void dataSuccess(List<GetMo> getMoList);
        void showData(String data);
        void getCustomerName(ArrayList<String> data);
        void getSoid(ArrayList<String> data);
        void getMo(ArrayList<String> data , ArrayList<String> data2);
        void onItemClick(String itemData);
    }
}
