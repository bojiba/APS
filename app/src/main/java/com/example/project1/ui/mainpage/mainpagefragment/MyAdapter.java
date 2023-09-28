package com.example.project1.ui.mainpage.mainpagefragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<HashMap<String,String>> dataList;

    public MyAdapter(ArrayList<HashMap<String,String>> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 創建 ViewHolder 並連結項目佈局檔案
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // 在這裡綁定數據到 ViewHolder 的 View
        String itemView = String.valueOf(dataList.get(position));
        holder.textView19.setText(dataList.get(position).get("count"));
        holder.textView24.setText(dataList.get(position).get("data_1"));
        holder.textView25.setText(dataList.get(position).get("data_2"));
        holder.textView26.setText(dataList.get(position).get("data_3"));
        holder.textView27.setText(dataList.get(position).get("data_4"));
        holder.textView28.setText(dataList.get(position).get("data_5"));
        holder.textView29.setText(dataList.get(position).get("online"));
        holder.textView22.setText(dataList.get(position).get("data_6"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onItemClick(itemView);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // 返回項目的數量
        return dataList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView19;
        TextView textView24;
        TextView textView25;
        TextView textView26;
        TextView textView27;
        TextView textView28;
        TextView textView29;
        TextView textView22;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // 綁定佈局檔案中的 View
            textView19 = itemView.findViewById(R.id.textView19);
            textView24 = itemView.findViewById(R.id.textView24);
            textView25 = itemView.findViewById(R.id.textView25);
            textView26 = itemView.findViewById(R.id.textView26);
            textView27 = itemView.findViewById(R.id.textView27);
            textView28 = itemView.findViewById(R.id.textView28);
            textView29 = itemView.findViewById(R.id.textView29);
            textView22 = itemView.findViewById(R.id.textView22);
        }
    }
    public interface OnItemClickListener{
        void onItemClick(String item);
    }
    private OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
