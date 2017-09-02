package com.example.jdnew.jdmovie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.presenter.WelcomePresenter;

/**
 * Created by JDNew on 2017/9/2.
 */

public class WelcomeActivity extends BaseActivity {

    private WelcomePresenter welcomePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initView();
        initData();
        setListener();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        welcomePresenter = new WelcomePresenter(this);
        welcomePresenter.start();
    }

    @Override
    public void setListener() {

    }
}
