package com.example.project1.ui.plan.sche;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.ui.mainpage.mainpagefragment.MyAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ScheAdapter extends RecyclerView.Adapter<ScheAdapter.ViewHolder> {
    private ArrayList<HashMap<String,String>> dataList;

    public ScheAdapter(ArrayList<HashMap<String,String>> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public ScheAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ScheAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheAdapter.ViewHolder holder, int position) {
        // 在這裡綁定數據到 ViewHolder 的 View
        String itemView = String.valueOf(dataList.get(position));
        holder.textView19.setText(dataList.get(position).get("id"));
        holder.textView23.setText(dataList.get(position).get("tech_routing_name"));
        holder.textView24.setText(dataList.get(position).get("mo_id"));
        holder.textView25.setText(dataList.get(position).get("so_id"));
        holder.textView26.setText(dataList.get(position).get("item_id"));
        holder.textView27.setText(dataList.get(position).get("customer"));
        holder.textView28.setText("數量:"+dataList.get(position).get("qty"));
        holder.textView29.setText("結關日:"+dataList.get(position).get("complete_date"));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(listener != null){
//                    listener.onItemClick();
//                    }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView19;
        private TextView textView23;
        private TextView textView24;
        private TextView textView25;
        private TextView textView26;
        private TextView textView27;
        private TextView textView28;
        private TextView textView29;
        private TextView textView22;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView19 = itemView.findViewById(R.id.textView19);
            textView23 = itemView.findViewById(R.id.textView23);
            textView24 = itemView.findViewById(R.id.textView24);
            textView25 = itemView.findViewById(R.id.textView25);
            textView26 = itemView.findViewById(R.id.textView26);
            textView27 = itemView.findViewById(R.id.textView27);
            textView28 = itemView.findViewById(R.id.textView28);
            textView29 = itemView.findViewById(R.id.textView29);
            textView22 = itemView.findViewById(R.id.textView22);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int postion);
    }
    private OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
