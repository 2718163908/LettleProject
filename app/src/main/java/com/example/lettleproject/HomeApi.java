package com.example.lettleproject;

import com.example.lettleproject.data.BannerBean;
import com.example.lettleproject.data.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HomeApi {
    String HOME_api="http://cdplay.cn/api/";
    @GET("index")
    Observable<HomeBean> getData();
}
