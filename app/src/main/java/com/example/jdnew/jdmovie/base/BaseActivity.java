package com.example.jdnew.jdmovie.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.example.jdnew.jdmovie.R;

/**
 * Created by JDNew on 2017/8/30.
 */

public abstract class BaseActivity extends AppCompatActivity {
   public abstract void initView();
    public abstract void initData();
    public abstract void setListener();

    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);


    }

    protected void initToolbar(){
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.tb_title);
        }
    }

    protected void setTitle(String title){
        if (mToolbar != null) {
            mToolbar.setTitle(title);
        }
    }

    protected void showToolbar(){
        if (mToolbar != null) {
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    protected void hideToolbar(){
        if (mToolbar != null) {
            mToolbar.setVisibility(View.GONE);
        }
    }

    protected void setNavigationIcon(@DrawableRes int resId){
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(resId);
        }
    }


}
