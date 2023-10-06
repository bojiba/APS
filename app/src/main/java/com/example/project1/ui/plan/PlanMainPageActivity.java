package com.example.project1.ui.plan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.api.GetMo;
import com.example.project1.sharedpreferences.SharedPre;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class PlanMainPageActivity extends AppCompatActivity {
    private TabLayout tabLayout2;
    private ViewPager2 viewPager2;
    private TextView textView24;
    private TextView textView25;
    private TextView textView26;
    private TextView textView27;
    private TextView textView28;
    private TextView textView29;
    private TextView textView37;
    private TextView textView44;
    ArrayList<GetMo> getMoArrayList;
    SharedPre sharedPre;
    private String[] tab_title = {"前關製令","本階製令","後關製令","裝配製令","銷售訂單"};
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_main_page);
        tabLayout2 = findViewById(R.id.tabLayout2);
        viewPager2 = findViewById(R.id.viewPager3);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView44 = findViewById(R.id.textView44);
        sharedPre = new SharedPre(this);
        i = sharedPre.getId()-1;
        viewPager2.setAdapter(new PlanPageAdapter(getSupportFragmentManager(),getLifecycle()));
        textView37 = findViewById(R.id.textView37);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        getMoArrayList= (ArrayList<GetMo>) getIntent().getSerializableExtra("test2");
        textView37.setOnClickListener(view -> {
            finish();
        });
                new TabLayoutMediator(tabLayout2, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        // 設定每個 Tab 的標題
                        tab.setText(tab_title[position]);
                    }
                }).attach();

                tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        // 根據選定的 Tab 來更新 textView24 的內容
                        int position = tab.getPosition();
                        if (position == 1){
                            textView24.setText(getMoArrayList.get(i).mo_id);
                            textView25.setText(getMoArrayList.get(i).so_id);
                            textView26.setText(getMoArrayList.get(i).item_id);
                            textView27.setText(getMoArrayList.get(i).item_name);
                            textView28.setText("預計上線:" + getMoArrayList.get(i).online_date);
                            textView29.setText("生產數量:" + getMoArrayList.get(i).qty);
                            textView44.setText(getMoArrayList.get(i).related_tech_route.tech_routing_name);
                        }
                        else  if (position == 4){
                            textView24.setText("4");
                            Log.d("test", String.valueOf(sharedPre.getId()));
                        }

                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        // 不需要執行任何操作
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        // 不需要執行任何操作
                    }
                });
    }
}