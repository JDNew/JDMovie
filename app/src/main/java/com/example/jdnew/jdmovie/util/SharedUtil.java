package com.example.jdnew.jdmovie.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JDNew on 2017/9/1.
 * 封装一个SharedPreference类
 */

public class SharedUtil {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;


    private static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getPackageName(),
                context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private static void commit() {
        editor.commit();
    }

    public static void putInt(Context context, String key, int value) {
        init(context);
        editor.putInt(key, value);
        commit();
    }

    public static void putBoolean(Context context, String key, boolean value){
        init(context);
        editor.putBoolean(key, value);
        commit();
    }

    public static void putString(Context context , String key , String value){
        init(context);
        editor.putString(key , value);
        commit();
    }

    public static int getInt(Context context, String key){
        init(context);
        return sharedPreferences.getInt(key , -1);
    }

    public static boolean getBoolean(Context context , String key){
        init(context);
        return sharedPreferences.getBoolean(key , false);
    }
}
