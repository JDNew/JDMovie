package com.example.jdnew.jdmovie.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by JDNew on 2017/8/30.
 */

public abstract class BaseActivity extends AppCompatActivity {
   public abstract void initView();
    public abstract void initData();
    public abstract void setListener();



}
