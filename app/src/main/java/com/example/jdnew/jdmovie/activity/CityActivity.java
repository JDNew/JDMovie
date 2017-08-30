package com.example.jdnew.jdmovie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.base.BaseActivity;
import com.example.jdnew.jdmovie.base.CityPresenter;
import com.example.jdnew.jdmovie.model.CityBean;
import com.example.jdnew.jdmovie.view.ICityView;

import java.util.List;

/**
 * Created by JDNew on 2017/8/30.
 */

public class CityActivity extends BaseActivity implements ICityView {

    private CityPresenter cityPresenter;
    private RecyclerView rl_city;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initView();
        initData();
        setListener();


    }

    @Override
    public void initView() {

        rl_city = (RecyclerView) findViewById(R.id.rl_city);

    }

    @Override
    public void initData() {
        cityPresenter = new CityPresenter(this , this);
        cityPresenter.start();

    }

    @Override
    public void setListener() {

    }

    @Override
    public void getCityList(List<CityBean.PBean> cityList) {

    }
}
