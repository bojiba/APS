package com.example.project1.ui.mainpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.sharedpreferences.SharedPre;
import com.example.project1.ui.mainpage.mainpagefragment.PageAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainPageActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private String[] tab_title = {"生產排程","當日進度表","訊息通知"};@SuppressLint("MissingInflatedId")
    private TextView textView6;
    private SharedPre sharedPre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian_page);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPage);
        textView6 = findViewById(R.id.textView6);
        sharedPre = new SharedPre(this);
        textView6.setText(sharedPre.getName());
        viewPager2.setAdapter(new PageAdapter(getSupportFragmentManager(),getLifecycle()));
        new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
        }).attach();
        for(int i = 0 ; i < tabLayout.getTabCount() ; i++){
            tabLayout.getTabAt(i).setText(tab_title[i]);
        }
    }
}