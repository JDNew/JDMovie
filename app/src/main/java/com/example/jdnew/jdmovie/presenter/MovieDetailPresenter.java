package com.example.jdnew.jdmovie.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.jdnew.httplibrary.CommonCallBack;
import com.example.jdnew.httplibrary.CommonHttpClient;
import com.example.jdnew.httplibrary.CommonRequestParam;
import com.example.jdnew.httplibrary.ICommonCallBackListener;
import com.example.jdnew.jdmovie.common.SharedCenter;
import com.example.jdnew.jdmovie.common.Url;
import com.example.jdnew.jdmovie.model.MovieDetailBean;
import com.example.jdnew.jdmovie.view.IMovieDetailView;
import com.google.gson.Gson;

/**
 * Created by JDNew on 2017/9/2.
 */

public class MovieDetailPresenter implements BasePresenter {

    private Context mContext;
    private IMovieDetailView mIMovieDetailView;
    public MovieDetailPresenter(Activity context , IMovieDetailView iMovieDetailView){
        this.mContext = context;
        this.mIMovieDetailView = iMovieDetailView;
    }

    @Override
    public void start() {

    }

    public void getMovieDetail(int movieId) {
        CommonRequestParam commonRequestParam = new CommonRequestParam();
        commonRequestParam.put("locationId" , SharedCenter.getCityId(mContext));
        commonRequestParam.put("movieId" , movieId);
        CommonHttpClient.doGetAsync(Url.GET_MOVIE_DETAIL , commonRequestParam , new CommonCallBack(new ICommonCallBackListener() {
            @Override
            public void doLoading() {

            }

            @Override
            public void getSuccess(String string) {
                Gson gson = new Gson();
                MovieDetailBean movieDetailBean = gson.fromJson(string , MovieDetailBean.class);
mIMovieDetailView.getMovieDetail(movieDetailBean.getData());
            }

            @Override
            public void getFailed() {

            }
        }));
    }
}
