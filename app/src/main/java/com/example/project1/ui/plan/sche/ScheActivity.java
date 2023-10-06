package com.example.project1.ui.plan.sche;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.api.GetMo;
import com.example.project1.sharedpreferences.SharedPre;
import com.example.project1.ui.mainpage.mainpagefragment.MyAdapter;
import com.example.project1.ui.plan.PlanMainPageActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScheActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ScheAdapter scheAdapter;
    ArrayList<HashMap<String,String>> dataList;
    SharedPre sharedPre;
    ArrayList<GetMo> getMoArrayList;
    private TextView textView55;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sche);
        textView55 = findViewById(R.id.textView55);
        sharedPre = new SharedPre(this);
        textView55.setOnClickListener(view -> {
            finish();
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        dataList = new ArrayList<>();
        getMoArrayList= (ArrayList<GetMo>) getIntent().getSerializableExtra("test");
        for (int i=0;i<getMoArrayList.size();i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("id",String.valueOf(getMoArrayList.get(i).id));
            hashMap.put("customer",getMoArrayList.get(i).customer);
            hashMap.put("complete_date",getMoArrayList.get(i).complete_date);
            hashMap.put("so_id",getMoArrayList.get(i).so_id);
            hashMap.put("item_id",getMoArrayList.get(i).item_id);
            hashMap.put("mo_id",getMoArrayList.get(i).mo_id);
            hashMap.put("qty", String.valueOf(getMoArrayList.get(i).qty));
            hashMap.put("tech_routing_name",getMoArrayList.get(i).related_tech_route.tech_routing_name);
            dataList.add(hashMap);
        }
        recyclerView = findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        scheAdapter = new ScheAdapter(dataList);
        recyclerView.setAdapter(scheAdapter);
        scheAdapter.setOnItemClickListener(new ScheAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int poistion) {
                sharedPre.setId(Integer.parseInt(dataList.get(poistion).get("id")));
                String itemnumber =dataList.get(poistion).get("id");
                sharedPre.setUnit_id(getMoArrayList.get(Integer.parseInt(itemnumber)).related_parent_part.unit_id);
                sharedPre.setItem_id(getMoArrayList.get(Integer.parseInt(itemnumber)).item_id);
                sharedPre.setQty(String.valueOf(getMoArrayList.get(Integer.parseInt(itemnumber)).qty));
                sharedPre.setItem_name(getMoArrayList.get(Integer.parseInt(itemnumber)).item_name);
                Log.d("Test", String.valueOf(sharedPre.getId()));
                Intent intent1 = new Intent();
                intent1.setClass(ScheActivity.this, PlanMainPageActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("test2", (Serializable) getMoArrayList);
                intent1.putExtras(bundle1);
                startActivity(intent1);

            }
        });
    }
}