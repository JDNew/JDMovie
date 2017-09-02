package com.example.jdnew.jdmovie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.adapter.CityAdapter;
import com.example.jdnew.jdmovie.presenter.CityPresenter;
import com.example.jdnew.jdmovie.model.CityBean;
import com.example.jdnew.jdmovie.view.ICityView;

import java.util.List;

/**
 * Created by JDNew on 2017/8/30.
 */

public class CityActivity extends BaseActivity implements ICityView {

    private CityPresenter cityPresenter;
    private RecyclerView rl_city;
    private CityAdapter cityAdapter;


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
        initToolbar();
        hideToolbarNavigationIcon();

    }

    @Override
    public void initData() {
        cityAdapter = new CityAdapter(this);
        rl_city.setAdapter(cityAdapter);
        rl_city.setLayoutManager(new LinearLayoutManager(this));
        cityPresenter = new CityPresenter(this , this);
        cityPresenter.start();
        setTitle("选择城市");


    }

    @Override
    public void setListener() {

    }

    @Override
    public void getCityList(List<CityBean.PBean> cityList) {
       cityAdapter.updateData(cityList);

    }
}
