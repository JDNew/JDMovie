package com.example.jdnew.jdmovie.presenter;

import android.app.Activity;

import com.example.jdnew.httplibrary.CommonCallBack;
import com.example.jdnew.httplibrary.ICommonCallBackListener;
import com.example.jdnew.jdmovie.http.RequestCenter;
import com.example.jdnew.jdmovie.http.Url;
import com.example.jdnew.jdmovie.model.CityBean;
import com.example.jdnew.jdmovie.view.ICityView;
import com.google.gson.Gson;

/**
 * Created by JDNew on 2017/8/30.
 */

public class CityPresenter implements BasePresenter {

    private Activity mContext;
    private ICityView mICityView;
    public CityPresenter(Activity context , ICityView iCityView){
        this.mContext = context;
        this.mICityView = iCityView;
    }


    @Override
    public void start() {
        RequestCenter.getCityList(Url.GET_CITY , null , new CommonCallBack(new ICommonCallBackListener() {
            @Override
            public void doLoading() {

            }

            @Override
            public void getSuccess(String string) {
                Gson gson = new Gson();
                CityBean cityBean = gson.fromJson(string , CityBean.class);
                mICityView.getCityList(cityBean.getP());
            }

            @Override
            public void getFailed() {

            }
        }));
    }
}
