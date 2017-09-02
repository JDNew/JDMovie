package com.example.jdnew.jdmovie.presenter;

import android.app.Activity;

import com.example.jdnew.httplibrary.CommonCallBack;
import com.example.jdnew.httplibrary.CommonHttpClient;
import com.example.jdnew.httplibrary.CommonRequestParam;
import com.example.jdnew.httplibrary.ICommonCallBackListener;
import com.example.jdnew.jdmovie.common.Constant;
import com.example.jdnew.jdmovie.common.Url;
import com.example.jdnew.jdmovie.model.HotSaleMovieBean;
import com.example.jdnew.jdmovie.util.SharedUtil;
import com.example.jdnew.jdmovie.view.IMainView;
import com.google.gson.Gson;

/**
 * Created by JDNew on 2017/9/1.
 */

public class MainPresenter implements BasePresenter {

    private Activity mContext;
    private IMainView mIMainView;
    public MainPresenter(Activity context , IMainView iMainView){
        this.mContext = context;
        this.mIMainView = iMainView;
    }

    @Override
    public void start() {

        getHotSaleMoiveList();

    }

    public void getHotSaleMoiveList() {
        CommonRequestParam requestParam = new CommonRequestParam();
        requestParam.put("locationId" , SharedUtil.getInt(mContext , Constant.SHARED_CITY_ID));
        CommonHttpClient.doGetAsync(Url.GET_SALING_MOVIES , requestParam , new CommonCallBack(new ICommonCallBackListener() {
            @Override
            public void doLoading() {

            }

            @Override
            public void getSuccess(String string) {
                Gson gson = new Gson();
                HotSaleMovieBean hotSaleMovieBean = gson.fromJson(string , HotSaleMovieBean.class);

                mIMainView.getHotSalingMovieList(hotSaleMovieBean.getMovies());
            }

            @Override
            public void getFailed() {

            }
        }));

    }
}
