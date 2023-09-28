package com.example.project1.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project1.R;
import com.example.project1.api.TokenApi;
import com.example.project1.sharedpreferences.SharedPre;
import com.example.project1.ui.mainpage.MainPageActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {
    private Button button;
    private EditText editText;
    private EditText editText2;
    private LoginContract.tokenPresenter loginPresenter;
    private SharedPre sharedPre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        sharedPre = new SharedPre(this);
        loginPresenter = new LoginPresenter(this,this);
        editText = findViewById(R.id.editTextText);
        editText2 = findViewById(R.id.editTextText2);
        button.setOnClickListener(view -> {
//            loginPresenter.getTokenData(editText.getText().toString(),editText2.getText().toString());
            loginPresenter.getTokenData("e1001","e1001");
        });
    }

    @Override
    public void dataError() {
        Toast.makeText(this,"登入失敗",Toast.LENGTH_LONG).show();
    }

    @Override
    public void dataSuccess() {
        Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void showData(String data) {

    }
}