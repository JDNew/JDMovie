package com.example.jdnew.jdmovie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.model.MovieDetailBean;
import com.example.jdnew.jdmovie.presenter.MovieDetailPresenter;
import com.example.jdnew.jdmovie.view.IMovieDetailView;
import com.example.jdnew.jdvideolibrary.JDVideoView;

/**
 * Created by JDNew on 2017/9/2.
 */

public class MovieDetailActivity extends BaseActivity implements IMovieDetailView {

    private MovieDetailPresenter movieDetailPresenter;
    private Intent intent;

    private JDVideoView jdVideoView;
    private LinearLayout ll_container;


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
        jdVideoView = new JDVideoView(this);
        ll_container = (LinearLayout) findViewById(R.id.ll_container);
        ll_container.addView(jdVideoView);

    }

    @Override
    public void initData() {
        intent = getIntent();
        movieDetailPresenter = new MovieDetailPresenter(this, this);
        movieDetailPresenter.start();
        movieDetailPresenter.getMovieDetail(intent.getIntExtra("movieId", -1));


    }

    @Override
    public void setListener() {

    }


    @Override
    public void getMovieDetail(MovieDetailBean.DataBean data) {
        String videoUrl = data.getBasic().getVideo().getUrl();
        jdVideoView.setVideoUrl(videoUrl);


    }


}
