package com.example.jdnew.jdmovie.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by JDNew on 2017/9/2.
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    public GridItemDecoration(int space){
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = space;
        outRect.right = space;
        outRect.top = space;
        outRect.bottom = space;

    }
}
