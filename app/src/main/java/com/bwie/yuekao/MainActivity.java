package com.bwie.yuekao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.yuekao.adapter.ShowYeAdapter;
import com.bwie.yuekao.bean.ShouYeBean;
import com.bwie.yuekao.present.ShouYePresent;
import com.bwie.yuekao.view.IShowYeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IShowYeView{

    @BindView(R.id.rv)
    RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        ShouYePresent shouYePresent = new ShouYePresent(this);
        shouYePresent.getData();

    }

    @Override
    public void ShowData(ShouYeBean shouYeBean) {

        ShowYeAdapter showYeAdapter= new ShowYeAdapter(this,shouYeBean);
        mRv.setAdapter(showYeAdapter);

    }
}
