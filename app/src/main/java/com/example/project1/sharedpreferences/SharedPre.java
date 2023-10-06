package com.example.project1.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPre extends AppCompatActivity  {
    private String token;
    private SharedPreferences shpf;
    private Context context;
    private String name;
    private int id;
    private String unit_id;
    private String item_id;
    private String qty;
    private String item_name;

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

    public int getId() {
        return shpf.getInt("id",0);
    }

    public void setId(int id) {
        shpf.edit().putInt("id",id).commit();
    }

    public String getUnit_id() {
        return shpf.getString("unit_id","");
    }

    public void setUnit_id(String unit_id) {
        shpf.edit().putString("unit_id",unit_id).commit();
    }

    public String getItem_id() {
        return shpf.getString("item_id","");
    }

    public void setItem_id(String item_id) {
        shpf.edit().putString("item_id",item_id).commit();
    }

    public String getQty() {
        return shpf.getString("qty","");
    }

    public void setQty(String qty) {
        shpf.edit().putString("qty",qty).commit();    }

    public String getItem_name() {
        return shpf.getString("item_name","");
    }

    public void setItem_name(String item_name) {
        shpf.edit().putString("item_name",item_name).commit();
    }
}
