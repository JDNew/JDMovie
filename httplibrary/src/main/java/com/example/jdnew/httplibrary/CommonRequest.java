package com.example.jdnew.httplibrary;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by JDNew on 2017/8/18.
 */

public class CommonRequest {

    /**
     * 设置Get请求的Request参数
     *
     * @param url
     * @param requestParam
     * @return
     */
    public Request createGetRequest(String url, CommonRequestParam requestParam) {
        StringBuilder stringBuilder = new StringBuilder(url).append("?");
        if (requestParam != null) {
            for (Map.Entry<String, String> entry : requestParam.urlParams.entrySet()) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue())
                        .append("&");
            }
        }

        String newUrl = stringBuilder.substring(0, stringBuilder.length() - 1);

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.get();
        requestBuilder.url(newUrl);
        Request request = requestBuilder.build();
        return request;

    }

    /**
     * 设置Post请求的Request参数
     * @param url
     * @param requestParam
     * @return
     */
    public Request createPostRequest(String url, CommonRequestParam requestParam) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : requestParam.urlParams.entrySet()) {
            formBodyBuilder.add(entry.getKey(), entry.getValue());
        }


        RequestBody requestBody = formBodyBuilder.build();
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.post(requestBody).url(url);
        Request request = requestBuilder.build();
        return request;
    }

    public Request createPostStringRequest(String url, String content) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;charset=utf-8") , content);
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.post(requestBody).url(url);
        Request request = requestBuilder.build();
        return request;

    }

    /**
     * 提交文件
     * @param url
     * @param file
     * @return
     */
    public Request createPostFileRequest(String url, File file) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream") , file);
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.post(requestBody).url(url);
        Request request = requestBuilder.build();
        return request;
    }

    /**
     * 上传文件
     * @param url
     * @param file
     * @return
     */
    public Request createUploadFileRequest(String url, File file) {

        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM)
                .addFormDataPart("mPhoto" , "helloFile.jpg" , RequestBody.create(MediaType.parse("application/octet-stream") , file));
        RequestBody requestBody = multipartBuilder.build();
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.post(requestBody).url(url);
        Request request = requestBuilder.build();

        return request;
    }
}
