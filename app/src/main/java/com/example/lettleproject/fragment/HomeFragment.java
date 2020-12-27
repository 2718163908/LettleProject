package com.example.lettleproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.lettleproject.HomeApi;
import com.example.lettleproject.adapter.BrandGridAdapter;
import com.example.lettleproject.adapter.NewGoodAdapter;
import com.example.lettleproject.data.BannerBean;
import com.example.lettleproject.data.HomeBean;
import com.example.lettleproject.R;
import com.example.lettleproject.RvtopAdapter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {


    private RecyclerView recycler_brand;
    private RecyclerView rv_newGood;
    ArrayList<BannerBean> list;
    private ArrayList<String> strings;

    private RvtopAdapter adapter;
    private Banner iBanner;
    private static final String TAG = "HomeFragment";
    private BrandGridAdapter brandGridAdapter;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans;
    private VirtualLayoutManager layoutManager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);


        return view;
    }

    private void initBrand() {
        layoutManager = new VirtualLayoutManager(getContext());
        recycler_brand.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycler_brand.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,10);
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setItemCount(2);
        brandListBeans = new ArrayList<>();
        brandGridAdapter = new BrandGridAdapter(gridLayoutHelper,brandListBeans, getContext());
        recycler_brand.setLayoutManager(new GridLayoutManager(getContext(),2));
        recycler_brand.setAdapter(brandGridAdapter);
    }

    private void initView(View view) {
        recycler_brand = view.findViewById(R.id.recycler_brand);
        rv_newGood = view.findViewById(R.id.rv_newGood);
        iBanner = view.findViewById(R.id.banner);


        initBrand();
        initnewGood();

        initData();

    }

    private void initnewGood() {
        rv_newGood.setLayoutManager(new GridLayoutManager(getContext(),2));
        new NewGoodAdapter();
        rv_newGood.setAdapter();
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(HomeApi.HOME_api)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient())
                .build()
                .create(HomeApi.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        Log.d("TAG", "onNext: " + homeBean.toString());
                        list = new ArrayList<>();
                        ArrayList<String> image = new ArrayList<>();
                        List<HomeBean.DataBean.BannerBean> bannerBeans = homeBean.getData().getBanner();
                        for (int i = 0; i <bannerBeans.size(); i++) {
                            image.add(bannerBeans.get(i).getImage_url());
                        }
                        iBanner.setImages(bannerBeans)
                                .setImageLoader(new ImageLoader() {
                                    @Override
                                    public void displayImage(Context context, Object path, ImageView imageView) {
                                        HomeBean.DataBean.BannerBean beans = (HomeBean.DataBean.BannerBean) path;
                                        Glide.with(context).load(beans.getImage_url()).into(imageView);
                                    }
                                }).start();
                        brandListBeans.addAll(homeBean.getData().getBrandList());
                        brandGridAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }) ;

    }
}
