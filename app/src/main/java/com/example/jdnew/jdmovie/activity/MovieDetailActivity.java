package com.example.jdnew.jdmovie.activity;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Surface;
import android.view.TextureView;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.model.MovieDetailBean;
import com.example.jdnew.jdmovie.presenter.MovieDetailPresenter;
import com.example.jdnew.jdmovie.view.IMovieDetailView;

import java.io.IOException;

/**
 * Created by JDNew on 2017/9/2.
 */

public class MovieDetailActivity extends BaseActivity implements IMovieDetailView {

    private MovieDetailPresenter movieDetailPresenter;
    private Intent intent;
    private TextureView tv_video;
    private MediaPlayer mMediaPlayer;
    private Surface mSurface;

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

        tv_video = (TextureView) findViewById(R.id.tv_video);

    }

    @Override
    public void initData() {
        intent = getIntent();
        movieDetailPresenter = new MovieDetailPresenter(this, this);
        movieDetailPresenter.start();
        movieDetailPresenter.getMovieDetail(intent.getIntExtra("movieId", -1));
        mMediaPlayer = new MediaPlayer();


    }

    @Override
    public void setListener() {
        setTextureViewListener();
        setMediaPlayerListener();
    }

    private void setMediaPlayerListener() {
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mMediaPlayer.start();
            }
        });
        mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        });
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });
    }

    private void setTextureViewListener() {
        tv_video.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                mSurface = new Surface(surface);
                mMediaPlayer.setSurface(mSurface);
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {

            }
        });
    }

    @Override
    public void getMovieDetail(MovieDetailBean.DataBean data) {
        String videoUrl = data.getBasic().getVideo().getUrl();

        try {
            mMediaPlayer.setDataSource(videoUrl);
            mMediaPlayer.prepareAsync();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
