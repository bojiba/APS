package com.example.project1.ui.plan.planfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.sharedpreferences.SharedPre;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainOrderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView textView69;
    private TextView textView64;
    private TextView textView62;
    private TextView textView68;
    private SharedPre sharedPre;

    public MainOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainOrder.
     */
    // TODO: Rename and change types and number of parameters
    public static MainOrderFragment newInstance(String param1, String param2) {
        MainOrderFragment fragment = new MainOrderFragment();
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
        sharedPre = new SharedPre(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_order, container, false);
        textView69 = view.findViewById(R.id.textView69);
        textView64 = view.findViewById(R.id.textView64);
        textView62 = view.findViewById(R.id.textView62);
        textView68 = view.findViewById(R.id.textView68);
        textView68.setText(sharedPre.getUnit_id());
        textView64.setText(sharedPre.getItem_id());
        textView69.setText(sharedPre.getQty());
        textView62.setText(sharedPre.getItem_name());
        return view;
    }
}