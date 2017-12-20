package com.bwie.yuekao.model;

import com.bwie.yuekao.bean.ShouYeBean;
import com.bwie.yuekao.client.RetrofitHelper;
import com.bwie.yuekao.client.ServiceApi;
import com.bwie.yuekao.utils.onNetListener;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ShouYeModel implements IShouYeModel{


    @Override
    public void getData(final onNetListener<ShouYeBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        Observable<ShouYeBean> bean = serviceApi.getBean();
        bean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ShouYeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShouYeBean shouYeBean) {
                        onNetListener.onSuccess(shouYeBean);
                    }
                });

    }
}