package com.bwie.yuekao.client;

import com.bwie.yuekao.bean.ShouYeBean;

import retrofit2.http.GET;
import rx.Observable;

public interface ServiceApi {

    @GET("homePageApi/homePage.do")
    Observable<ShouYeBean> getBean();
}