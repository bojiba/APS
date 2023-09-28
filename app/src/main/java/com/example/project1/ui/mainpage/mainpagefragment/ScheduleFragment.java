package com.example.project1.ui.mainpage.mainpagefragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project1.R;
import com.example.project1.ui.plan.PlanMainPageActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ArrayList<HashMap<String,String>> dataList;
    private String[] data_1 = new String[]{"1MO1812040031","1MO1812040030","1MO1812040027","1MO1812030024"
            ,"1MO1812030012","1MO1812030010","1MO1812040028","1MO1812030023"};
    private String[] data_2 =new String[]{"1SO1811270009","1SO1811270009","1SO1811270010","1SOA1811300002"
            ,"1SOA1811300001","1SOA1811300001","1SO1811270008","1SO1811270008"};
    private String[] data_3 =new String[]{"F260011ATN-2","F260011ATN-1","F260001-1","F10318M-3A"
            ,"F10217M-5A","F10217M-1","F260001ATN-1A","F10318M-2A"};
    private String[] data_4 =new String[]{"MATADOR","MATADOR","MATADOR","祥雲工具股..."
            ,"祥雲工具股...","祥雲工具股...","MATADOR","MATADOR"};
    private String[] data_5 =new String[]{"數量：3","數量：3","數量：30","數量：10"
            ,"數量：10","數量：10","數量：6","數量：70"};
    private String[] data_6 =new String[]{"計劃開始：08:00","計劃開始：08:05","計劃開始：08:10","計劃開始：08:45"
            ,"計劃開始：09:20","計劃開始：09:50","計劃開始：10:30","計劃開始：10:40"};

    public ScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Schedule.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 在 onViewCreated 方法中執行初始化操作
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        dataList = new ArrayList<>();
        // 在這裡添加你的數據到 dataList 中
        for(int i =0;i<=7;i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("count",String.valueOf(i+1));
            hashMap.put("data_1",data_1[i]);
            hashMap.put("data_2",data_2[i]);
            hashMap.put("data_3",data_3[i]);
            hashMap.put("data_4",data_4[i]);
            hashMap.put("data_5",data_5[i]);
            hashMap.put("online","結關日:2018-12-07");
            hashMap.put("data_6",data_6[i]);
            dataList.add(hashMap);
        }
        myAdapter = new MyAdapter(dataList);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), PlanMainPageActivity.class);
                startActivity(intent);
            }
        });
    }
}