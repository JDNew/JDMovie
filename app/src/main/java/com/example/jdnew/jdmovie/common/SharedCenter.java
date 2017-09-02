package com.example.jdnew.jdmovie.common;

import android.content.Context;

import com.example.jdnew.jdmovie.util.SharedUtil;

/**
 * Created by JDNew on 2017/9/2.
 * 管理存放进来的SharedPreference
 */

public class SharedCenter {

    public static void putHaveChooseCity(Context context , boolean value){
        SharedUtil.putBoolean(context , Constant.SHARED_HAVE_CHOOSE_CITY , value);
    }

    public static boolean getHaveChooseCity(Context context){
        return SharedUtil.getBoolean(context , Constant.SHARED_HAVE_CHOOSE_CITY);
    }

    public static void putCityName(Context context , String value){
        SharedUtil.putString(context , Constant.SHARED_CITY_NAME, value);
    }

    public static String getCityName(Context context){
        return SharedUtil.getString(context , Constant.SHARED_CITY_NAME);
    }

    public static void putCityId(Context context , int value){
        SharedUtil.putInt(context , Constant.SHARED_CITY_ID , value);
    }

    public static int getCityId(Context context){
        return SharedUtil.getInt(context , Constant.SHARED_CITY_ID);
    }





}
