package com.example.project1.ui.plan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.example.project1.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PlanMainPageActivity extends AppCompatActivity {
    private TabLayout tabLayout2;
    private ViewPager2 viewPager2;
    private TextView textView37;
    private String[] tab_title = {"前關製令","本階製令","後關製令","裝配製令","銷售訂單"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_main_page);
        tabLayout2 = findViewById(R.id.tabLayout2);
        viewPager2 = findViewById(R.id.viewPager3);
        viewPager2.setAdapter(new PlanPageAdapter(getSupportFragmentManager(),getLifecycle()));
        textView37 = findViewById(R.id.textView37);
        textView37.setOnClickListener(view -> {
            finish();
        });
        new TabLayoutMediator(tabLayout2, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
        }).attach();
        for(int i = 0 ; i < tabLayout2.getTabCount() ; i++){
            tabLayout2.getTabAt(i).setText(tab_title[i]);
        }
    }
}