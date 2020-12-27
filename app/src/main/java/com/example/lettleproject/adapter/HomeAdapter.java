package com.example.lettleproject.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;


public class HomeAdapter extends DelegateAdapter.Adapter {
    private GridLayoutHelper gridLayoutHelper;
    private LinearLayoutHelper linearLayoutHelper;

    public HomeAdapter(LinearLayoutHelper linearLayoutHelper) {
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
//            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_itm_layout, parent, false);
//            return new MyViewHolder(inflate);
//            new BrandGridAdapter(gridLayoutHelper,)
        }else if (viewType==2){
//            return ;
        }else if (viewType==3){
//            return ;
        }else if (viewType==4){
//            return ;
        }
//        return 5;
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textView.setText("手动阀手动阀");



    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 1;
        }else if (position==1){
            return 2;
        }else if (position==2){
            return 3;
        }else if (position==3){
            return 4;
        }
        return 5;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            textView = itemView.findViewById(R.id.line_text);
        }
    }

}
