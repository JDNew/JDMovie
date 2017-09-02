package com.example.jdnew.jdmovie.common;

import com.example.jdnew.httplibrary.CommonCallBack;
import com.example.jdnew.httplibrary.CommonHttpClient;
import com.example.jdnew.httplibrary.CommonRequestParam;
import com.example.jdnew.httplibrary.ICommonCallBackListener;

/**
 * Created by JDNew on 2017/8/30.
 */

public class RequestCenter {

    public static void getCityList(String url , CommonRequestParam commonRequestParam , CommonCallBack commonCallBack) {
        CommonHttpClient.doGetAsync(url, commonRequestParam, commonCallBack);
    }
}
