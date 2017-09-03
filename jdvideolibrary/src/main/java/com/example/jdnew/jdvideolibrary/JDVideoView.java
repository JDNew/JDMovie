package com.example.jdnew.jdvideolibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.widget.RelativeLayout;

/**
 * Created by JDNew on 2017/9/3.
 */

public class JDVideoView extends RelativeLayout{

    private RelativeLayout rl_container;
    private TextureView tv_video;

    public JDVideoView(Context context) {
        super(context);

        initView();
    }

    private void initView() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        rl_container = (RelativeLayout) layoutInflater.inflate(R.layout.layout_jd_video_view , this);
        tv_video = (TextureView) rl_container.findViewById(R.id.tv_video);

    }

}
