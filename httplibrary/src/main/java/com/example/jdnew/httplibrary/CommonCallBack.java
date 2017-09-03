package com.example.jdnew.httplibrary;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by JDNew on 2017/8/18.
 */

public class CommonCallBack implements Callback {

    private final String TAG = "httpResult";
    private final int MSG_SUCCESS = 1;
    private final int MSG_FAILED = 2;
    private final int MSG_ERROR = 3;
    private ICommonCallBackListener iCommonCallBackListener;

    public CommonCallBack(ICommonCallBackListener iCommonCallBackListener) {
        this.iCommonCallBackListener = iCommonCallBackListener;
    }


    private Handler mHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_ERROR:
                    iCommonCallBackListener.getFailed();
                    break;
                case MSG_SUCCESS:
                    String result = (String) msg.obj;
                        iCommonCallBackListener.getSuccess(result);

                    break;
            }

        }
    };


    @Override
    public void onFailure(Call call, IOException e) {
        mHandler.sendEmptyMessage(MSG_FAILED);

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String result = response.body().string();
        Message message = new Message();
        message.what = MSG_SUCCESS;
        message.obj = result;
        mHandler.sendMessage(message);
    }
}
