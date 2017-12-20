package com.bwie.yuekao.client;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

private static OkHttpClient okHttpClient;
private static ServiceApi serviceApi;

static {
    initOkHttpClient();
}

public static OkHttpClient initOkHttpClient() {

    if(okHttpClient==null){
        synchronized (OkHttpClient.class){
            if(okHttpClient==null){
                okHttpClient=new OkHttpClient();
            }
        }
    }
    return okHttpClient;
}
public static ServiceApi getServiceApi(){

    if(serviceApi==null){
        synchronized (ServiceApi.class){
            if(serviceApi==null){
                serviceApi=RetrofitHelper.CreateApi(ServiceApi.class, Api.HOST);
            }
        }
    }
    return serviceApi;

}
public static<T>T CreateApi(Class<T>tClass,String url){

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    return retrofit.create(tClass);
}
}