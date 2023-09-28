package com.example.project1.ui.progresspage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.project1.R;

public class SettingsPageActivity extends AppCompatActivity {
    private TextView textView38;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        textView38 = findViewById(R.id.textView38);
        textView38.setOnClickListener(view -> {
            finish();
        });
    }
}
