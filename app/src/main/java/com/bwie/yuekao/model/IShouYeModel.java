package com.bwie.yuekao.model;

import com.bwie.yuekao.bean.ShouYeBean;
import com.bwie.yuekao.utils.onNetListener;

/**
 * Created by VICYU on 2017/12/19.
 */
public interface IShouYeModel {

    public void getData(onNetListener<ShouYeBean> onNetListener);

}
