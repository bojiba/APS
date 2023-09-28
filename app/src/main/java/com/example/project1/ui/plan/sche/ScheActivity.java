package com.example.project1.ui.plan.sche;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.api.GetMo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScheActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ScheAdapter scheAdapter;
    private ArrayList<HashMap<String,String>> dataList;

    ArrayList<GetMo> getMoArrayList;
    private TextView textView55;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sche);
        textView55 = findViewById(R.id.textView55);

        textView55.setOnClickListener(view -> {
            finish();
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        getMoArrayList= (ArrayList<GetMo>) getIntent().getSerializableExtra("test");
        for (int i=0;i< dataList.size();i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("count",String.valueOf(i+1));
            hashMap.put("customer",getMoArrayList.get(i).customer);
            hashMap.put("complete_date",getMoArrayList.get(i).complete_date);
            hashMap.put("so_id",getMoArrayList.get(i).so_id);
            hashMap.put("item_id",getMoArrayList.get(i).item_id);
            hashMap.put("mo_id",getMoArrayList.get(i).mo_id);
//            hashMap.put("online",getMoArrayList.get(i).customer);
            dataList.add(hashMap);
        }
        recyclerView = findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        scheAdapter = new ScheAdapter(dataList);
        recyclerView.setAdapter(scheAdapter);
    }
}