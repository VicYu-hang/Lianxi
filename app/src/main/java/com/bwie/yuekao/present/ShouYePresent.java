package com.bwie.yuekao.present;

import com.bwie.yuekao.bean.ShouYeBean;
import com.bwie.yuekao.model.IShouYeModel;
import com.bwie.yuekao.model.ShouYeModel;
import com.bwie.yuekao.utils.onNetListener;
import com.bwie.yuekao.view.IShowYeView;

/**
 * Created by VICYU on 2017/12/19.
 */

public class ShouYePresent {

    private IShouYeModel iShouYeModel;
    private IShowYeView iShowYeView;

    public ShouYePresent(IShowYeView iShowYeView) {
        this.iShowYeView = iShowYeView;
        iShouYeModel = new ShouYeModel();
    }

    public void getData(){

        iShouYeModel.getData(new onNetListener<ShouYeBean>() {
            @Override
            public void onSuccess(ShouYeBean shouYeBean) {
                iShowYeView.ShowData(shouYeBean);
            }

            @Override
            public void onFaliure(Exception e) {

            }
        });
    }
}
