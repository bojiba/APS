package com.example.project1.ui.progresspage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.api.GetMo;
import com.example.project1.sharedpreferences.SharedPre;
import com.example.project1.ui.plan.sche.ScheActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SearchPageActivity extends AppCompatActivity implements SearchPageContract.view {
    private Button button3;
    private EditText editText3;
    SearchPagePresenter searchPagePresenter1;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Calendar calendar = Calendar.getInstance();
    private TextView textView17;
    private TextView textView20;
    private Dialog customerDialog;
    private ArrayList<String> arrayList;
    private List<String> dataList;
    private TextView textView21;
    private EditText editText5;
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private TextView textView31;
    private SharedPre sharedPre;
    private TextView textView18;
    private EditText editText4;
    private SearchPageContract.SearchPagePresenter searchPagePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        searchPagePresenter1 = new SearchPagePresenter(this, this);
        textView20 = findViewById(R.id.textView20);
        editText3 = findViewById(R.id.editTextText3);
        textView17 = findViewById(R.id.textView17);
        textView21 = findViewById(R.id.textView21);
        textView31 = findViewById(R.id.textView31);
        textView18 = findViewById(R.id.textView18);
        editText4 = findViewById(R.id.editTextText4);
        customerDialog = new Dialog(this);
        sharedPre = new SharedPre(this);
        customerDialog.setContentView(R.layout.customerdialog);
        editText5=findViewById(R.id.editTextText5);
        recyclerView = customerDialog.findViewById(R.id.recycler_view2);
        listAdapter = new ListAdapter(arrayList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchPagePresenter = new SearchPagePresenter(this, this);
        dateSetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                String myFormat = "yyyy/MM/dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat, Locale.TAIWAN);
                editText3.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        textView20.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(SearchPageActivity.this,
                    dateSetListener,calendar.get(Calendar.YEAR)
                    ,calendar.get(Calendar.MONTH)
                    ,calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });
        textView17.setOnClickListener(view -> {
            finish();
        });
        textView21.setOnClickListener(view -> {
            searchPagePresenter.getCustomerName(editText5.getText().toString(),sharedPre.getToken());
        });

        textView18.setOnClickListener(view -> {
            searchPagePresenter.getSoid(editText4.getText().toString(),sharedPre.getToken());
        });

        textView31.setOnClickListener(view -> {
                searchPagePresenter.getMo(editText5.getText().toString(),editText4.getText().toString(),sharedPre.getToken());

            Log.d("test","123");
        });
    }

    private void showCustomerDialog() {
        customerDialog.show();
    }
    @Override
    public void dataError() {
        Log.e("test","失敗");
    }

    @Override
    public void dataSuccess(List<GetMo> getMoList) {
        ArrayList<GetMo> getMoArrayList = new ArrayList<>();
        for(int i = 0;i<getMoList.size();i++)
            getMoArrayList.add(getMoList.get(i));
        Log.e("test","成功");
        Intent intent = new Intent(SearchPageActivity.this, ScheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("test", (Serializable) getMoArrayList);
        intent.putExtras(bundle);

        startActivity(intent);

    }

    @Override
    public void showData(String data) {

    }

    @Override
    public void getCustomerName(ArrayList<String> data) {
        arrayList = data;
        listAdapter.setDataList(arrayList);
        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String selectedItem) {
                editText5.setText(selectedItem);
                customerDialog.dismiss();
            }
        });
        showCustomerDialog();
    }
    @Override
    public void getSoid(ArrayList<String> data) {
        arrayList = data;
        listAdapter.setDataList(arrayList);
        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String selectedItem) {
                editText4.setText(selectedItem);
                customerDialog.dismiss();
            }
        });
        showCustomerDialog();
    }

    @Override
    public void getMo(ArrayList<String> data, ArrayList<String> data2) {
    }

    @Override
    public void onItemClick(String itemData) {
    }
}