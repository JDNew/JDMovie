package com.example.jdnew.jdmovie.activity;

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
        if (!toobarIsNotNull()) {
            mToolbar = (Toolbar) findViewById(R.id.tb_title);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    protected void setTitle(String title){
        if (toobarIsNotNull()) {
            mToolbar.setTitle(title);
        }
    }

    protected void showToolbar(){
        if (toobarIsNotNull()) {
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    protected void hideToolbar(){
        if (toobarIsNotNull()) {
            mToolbar.setVisibility(View.GONE);
        }
    }

    protected void setToolbarNavigationIcon(@DrawableRes int resId){
        if (toobarIsNotNull()) {
            mToolbar.setNavigationIcon(resId);
        }
    }

    protected void hideToolbarNavigationIcon(){
        if (toobarIsNotNull()) {
            mToolbar.setNavigationIcon(null);
        }
    }



    private boolean toobarIsNotNull(){
        if (mToolbar != null) {
            return true;
        }else {
            return false;
        }
    }


}
