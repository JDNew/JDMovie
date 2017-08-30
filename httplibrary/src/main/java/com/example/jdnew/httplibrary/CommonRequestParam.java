package com.example.jdnew.httplibrary;

import android.support.annotation.NonNull;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by JDNew on 2017/8/19.
 */

public class CommonRequestParam {

    ConcurrentHashMap<String , String> urlParams = new ConcurrentHashMap<>();
    public CommonRequestParam(){

    }

    public void put(@NonNull String key , @NonNull String value){
       urlParams.put(key , value);
    }
}
