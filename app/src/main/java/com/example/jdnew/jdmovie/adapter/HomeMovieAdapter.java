package com.example.jdnew.jdmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.activity.MovieDetailActivity;
import com.example.jdnew.jdmovie.model.HotSaleMovieBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDNew on 2017/9/2.
 */

public class HomeMovieAdapter extends RecyclerView.Adapter<HomeMovieViewHolder> {

    private Context mContext;
    private List<HotSaleMovieBean.MoviesBean> mMoviesList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public HomeMovieAdapter(Context context, List<HotSaleMovieBean.MoviesBean> moviesList) {
        this.mContext = context;
        this.mMoviesList = moviesList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    public HomeMovieAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public HomeMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_home_movie, null);
        HomeMovieViewHolder homeMovieViewHolder = new HomeMovieViewHolder(view);
        return homeMovieViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeMovieViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mMoviesList.get(position).getImg())
                .into(holder.imageView);
        holder.setOnItemClickListener(new HomeMovieViewHolder.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(mContext, MovieDetailActivity.class);
                intent.putExtra("movieId", mMoviesList.get(position).getMovieId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    public void updateData(List<HotSaleMovieBean.MoviesBean> moviesList) {
        this.mMoviesList.clear();
        this.mMoviesList.addAll(moviesList);
        notifyDataSetChanged();
    }
}
