package com.example.lettleproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lettleproject.HomeApi;
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


    private RecyclerView rv_top;
    private RecyclerView rv_down;
    ArrayList<BannerBean> list;
    private ArrayList<String> strings;

    private RvtopAdapter adapter;
    private Banner banner;
    private static final String TAG = "HomeFragment";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        rv_top = view.findViewById(R.id.rv_top);
        rv_down = view.findViewById(R.id.rv_down);
        banner = view.findViewById(R.id.banner);

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
                        List<HomeBean.DataBean.BannerBean> bannerr = homeBean.getData().getBanner();
                        for (int i = 0; i <bannerr.size(); i++) {
                            image.add(bannerr.get(i).getImage_url());
                        }
//                        image.add();
                        HomeFragment.this.banner.setImages(image)
                                .setImageLoader(new ImageLoader() {
                                    @Override
                                    public void displayImage(Context context, Object path, ImageView imageView) {

                                        Glide.with(context).load(path).into(imageView);
                                    }
                                }).start();

                        Log.d("tag", "getBanner: " + homeBean.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        adapter = new RvtopAdapter();
    }

    private void initData() {

    }
}
