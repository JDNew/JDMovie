package com.example.jdnew.jdmovie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.model.MovieDetailBean;
import com.example.jdnew.jdmovie.presenter.MovieDetailPresenter;
import com.example.jdnew.jdmovie.view.IMovieDetailView;

/**
 * Created by JDNew on 2017/9/2.
 */

public class MovieDetailActivity extends BaseActivity implements IMovieDetailView {

    private MovieDetailPresenter movieDetailPresenter;
    private Intent intent ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initToolbar();
        initView();
        initData();
        setListener();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        intent = getIntent();
        movieDetailPresenter = new MovieDetailPresenter(this , this);
        movieDetailPresenter.start();
        movieDetailPresenter.getMovieDetail(intent.getIntExtra("movieId" , -1));

    }

    @Override
    public void setListener() {

    }

    @Override
    public void getMovieDetail(MovieDetailBean.DataBean data) {

    }
}
