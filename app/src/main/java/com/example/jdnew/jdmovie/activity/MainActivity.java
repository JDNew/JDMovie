package com.example.jdnew.jdmovie.activity;

import android.os.Bundle;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.model.HotSaleMovieBean;
import com.example.jdnew.jdmovie.presenter.MainPresenter;
import com.example.jdnew.jdmovie.view.IMainView;

import java.util.List;

public class MainActivity extends BaseActivity implements IMainView {

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolbar();
        initData();
        setListener();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
mainPresenter = new MainPresenter(this , this);
        mainPresenter.start();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void getHotSalingMovieList(List<HotSaleMovieBean.MoviesBean> moviesList) {

    }
}
