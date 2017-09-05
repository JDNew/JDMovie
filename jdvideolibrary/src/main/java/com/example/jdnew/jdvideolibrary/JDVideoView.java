package com.example.jdnew.jdvideolibrary;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.io.IOException;

/**
 * Created by JDNew on 2017/9/3.
 */

public class JDVideoView extends RelativeLayout implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, TextureView.SurfaceTextureListener {

    private RelativeLayout rl_container;
    private TextureView tv_video;
    private ImageView iv_play;
    private MediaPlayer mMediaPlayer;
    private String mVideoUrl;
    private Surface mSurface;
    private int mScreenWidth;
    private int mVideoHeight;
    private ProgressBar progressBar;


    public JDVideoView(Context context) {
        super(context);
        initView();
        initData();
        setListener();
    }


    private void initView() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        rl_container = (RelativeLayout) layoutInflater.inflate(R.layout.layout_jd_video_view, this);
        tv_video = (TextureView) rl_container.findViewById(R.id.tv_video);
        iv_play = (ImageView) rl_container.findViewById(R.id.iv_play);
        progressBar = (ProgressBar) rl_container.findViewById(R.id.progressbar);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        mScreenWidth = displayMetrics.widthPixels;
        mVideoHeight = mScreenWidth * 9 / 16;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mScreenWidth, mVideoHeight);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        rl_container.setLayoutParams(layoutParams);


    }

    private void initData() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.reset();
    }

    private void setListener() {
        iv_play.setOnClickListener(this);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnErrorListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        tv_video.setSurfaceTextureListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_video) {
            pauseVideo();
        } else if (id == R.id.iv_play) {
            playVideo();
        }
    }

    private void pauseVideo() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }

    }

    private void playVideo() {
        mMediaPlayer.start();
        showPlayingView();
    }


    public void setVideoUrl(String url) {
        mVideoUrl = url;
        try {
            mMediaPlayer.setDataSource(mVideoUrl);
            mMediaPlayer.prepareAsync();
            showLoadingView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    @Override
    public void onPrepared(MediaPlayer mp) {

        pauseVideo();
        showPauseView();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mMediaPlayer.seekTo(0);
        mMediaPlayer.pause();
        showPauseView();
    }

    private void showPauseView() {
        progressBar.setVisibility(GONE);
        iv_play.setVisibility(VISIBLE);
    }

    private void showLoadingView() {
        progressBar.setVisibility(VISIBLE);
        iv_play.setVisibility(GONE);
    }

    private void showPlayingView() {
        progressBar.setVisibility(GONE);
        iv_play.setVisibility(GONE);
    }
}
