package com.example.project1.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPre extends AppCompatActivity  {
    private String token;
    private SharedPreferences shpf;
    private Context context;
    private String name;
    private String soid;
    private String customerName;

    public SharedPre(Context context){
        this.context=context;
        //設定SharedPreferences的模式。設定為只有自己(app_name)才可以讀寫。
        shpf=this.context.getSharedPreferences("USER",MODE_PRIVATE);
    }
    public String getToken() {
        return shpf.getString("TOKEN","");
    }
    public void setToken(String token) {
        shpf.edit().putString("TOKEN",token).commit();
    }
    public String getName() {
        return shpf.getString("name","");
    }
    public void setName(String name) {
        shpf.edit().putString("name",name).commit();
    }

    public String getSoid() {
        return shpf.getString("soid","");
    }

    public void setSoid(String soid) {
        shpf.edit().putString("soid",soid).commit();
    }

    public String getCustomerName() {
        return shpf.getString("customerName","");
    }

    public void setCustomerName(String customerName) {
        shpf.edit().putString("customerName",customerName).commit();
    }
}
