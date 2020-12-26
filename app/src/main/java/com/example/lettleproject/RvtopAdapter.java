package com.example.lettleproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lettleproject.data.HomeBean;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class RvtopAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.BannerBean> list;
    private ArrayList<String> strings;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toolbar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holderOne = (ViewHolder) holder;
//        holderOne.mIvPinpai
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        }
        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView mIvPinpai;

        ViewHolder(View view) {
            super(view);
            this.mIvPinpai = (ImageView) view.findViewById(R.id.iv_pinpai);
        }
    }
}
