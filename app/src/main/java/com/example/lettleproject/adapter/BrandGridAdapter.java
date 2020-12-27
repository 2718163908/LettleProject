package com.example.lettleproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.lettleproject.R;
import com.example.lettleproject.data.HomeBean;

import java.util.ArrayList;
//import com.example.v_layout.R;
//import com.bumptech.glide.Glide;
//import com.wf.ds.R;

public class BrandGridAdapter extends DelegateAdapter.Adapter {



    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans;
    private Context context;

    public BrandGridAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.brandListBeans = brandListBeans;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_grid_itm_layout, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = ( ViewHolder) holder;
        viewHolder.tv_pinpaishang.setText(brandListBeans.get(position).getName());
        Glide.with(context).load(brandListBeans.get(position).getPic_url()).into(viewHolder.iv_pinpaishang);
    }

    @Override
    public int getItemCount() {
        return brandListBeans.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView tv_pinpaishang;
        ImageView iv_pinpaishang;

        ViewHolder(View view) {
            super(view);
            this.tv_pinpaishang = (TextView) view.findViewById(R.id.title_brand);
            this.iv_pinpaishang = (ImageView) view.findViewById(R.id.img_brand);
        }
    }

}
