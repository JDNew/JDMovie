package com.example.jdnew.jdmovie.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.example.jdnew.jdmovie.activity.CityActivity;
import com.example.jdnew.jdmovie.activity.MainActivity;
import com.example.jdnew.jdmovie.common.SharedCenter;

/**
 * Created by JDNew on 2017/9/2.
 */

public class WelcomePresenter implements BasePresenter {

    private Activity mContext;

    public WelcomePresenter(Activity context) {
        this.mContext = context;
    }

   private Handler handler = new Handler();


    @Override
    public void start() {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    if (SharedCenter.getHaveChooseCity(mContext)) {
                        mContext.startActivity(new Intent(mContext, MainActivity.class));
                    } else {
                        mContext.startActivity(new Intent(mContext, CityActivity.class));
                    }
                    mContext.finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//       handler.postDelayed(new Runnable() {
//           @Override
//           public void run() {
//               if (SharedCenter.getHaveChooseCity(mContext)) {
//                   mContext.startActivity(new Intent(mContext, MainActivity.class));
//               } else {
//                   mContext.startActivity(new Intent(mContext, CityActivity.class));
//               }
//               mContext.finish();
//           }
//       } , 3000);

    }
}
