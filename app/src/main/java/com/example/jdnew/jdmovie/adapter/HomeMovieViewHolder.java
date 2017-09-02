package com.example.jdnew.jdmovie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.jdnew.jdmovie.R;

/**
 * Created by JDNew on 2017/9/2.
 */

public class HomeMovieViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    private OnItemClickListener onItemClickListener;
    public HomeMovieViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.iv_movies);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(getAdapterPosition());
                }

            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }
}
