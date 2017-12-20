package com.bwie.yuekao.utils;

/**
 * Created by VICYU on 2017/12/19.
 */

public interface onNetListener<T> {

    public void onSuccess(T t);
    public void onFaliure(Exception e);

}
