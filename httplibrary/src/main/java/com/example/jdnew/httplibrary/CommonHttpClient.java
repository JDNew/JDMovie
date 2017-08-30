package com.example.jdnew.httplibrary;

import android.support.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Created by JDNew on 2017/8/18.
 */

public class CommonHttpClient {
    private static OkHttpClient mOkHttpClient;
    private static final int TIME_OUT = 30;

    static {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        mOkHttpClient = okHttpClientBuilder.build();
    }


    /**
     * 异步的post请求
     * @param url
     * @param requestParam
     * @param commonCallBack
     */
    public static void doPostAsync(String url, CommonRequestParam requestParam , CommonCallBack commonCallBack) {
        Call call = mOkHttpClient.newCall(new CommonRequest().createPostRequest(url , requestParam));
        call.enqueue(commonCallBack);
    }

    /**
     * 异步传递一个字符串，像Json字符串
     * @param url
     * @param content
     * @param commonCallBack
     */
    public static void doPostStringAsync(String url , String content , CommonCallBack commonCallBack){
        Call call = mOkHttpClient.newCall(new CommonRequest().createPostStringRequest(url , content));
        call.enqueue(commonCallBack);
    }

    public static void doPostFileAsync(String url , File file , CommonCallBack commonCallBack){
        Call call = mOkHttpClient.newCall(new CommonRequest().createPostFileRequest(url , file));
        call.enqueue(commonCallBack);
    }

    public static void doPostUploadFileAsync(String url , File file , CommonCallBack commonCallBack){
        Call call = mOkHttpClient.newCall(new CommonRequest().createUploadFileRequest(url , file));
        call.enqueue(commonCallBack);
    }

    /**
     * 异步的Get请求
     * @param url 请求地址
     * @param requestParam 请求参数
     * @param commonCallBack 请求回调
     */
    public static void doGetAsync(String url, CommonRequestParam requestParam , CommonCallBack commonCallBack) {
        Call call = mOkHttpClient.newCall(new CommonRequest().createGetRequest(url , requestParam));
        call.enqueue(commonCallBack);

    }

    /**
     * 同步的Get请求
     * @param url 请求地址
     * @param requestParam 请求参数
     * @throws IOException
     */
    public static String doGetSync(String url , CommonRequestParam requestParam) throws IOException {
        Call call = mOkHttpClient.newCall(new CommonRequest().createGetRequest(url, requestParam));
        Response response = call.execute();
        return response.body().string();
    }


}
