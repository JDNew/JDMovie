package com.example.jdnew.jdmovie.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.adapter.HomeMovieAdapter;
import com.example.jdnew.jdmovie.model.HotSaleMovieBean;
import com.example.jdnew.jdmovie.presenter.MainPresenter;
import com.example.jdnew.jdmovie.view.IMainView;
import com.example.jdnew.jdmovie.widget.GridItemDecoration;
import com.example.jdnew.jdrecyclerview.PullToRefreshRecyclerView;

import java.util.List;

public class MainActivity extends BaseActivity implements IMainView {

    private MainPresenter mainPresenter;
    private PullToRefreshRecyclerView rl_movies;
    private HomeMovieAdapter homeMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolbar();
        initData();
        setListener();
    }

    @Override
    public void initView() {

        rl_movies = (PullToRefreshRecyclerView) findViewById(R.id.rl_movies);
       rl_movies.setDoNotLoad(true);
    }

    @Override
    public void initData() {
        homeMovieAdapter = new HomeMovieAdapter(this);
        rl_movies.setLayoutManager(new GridLayoutManager(this , 2));
        rl_movies.addItemDecoration(new GridItemDecoration(20));

        rl_movies.setAdapter(homeMovieAdapter);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.start();




    }

    @Override
    public void setListener() {
        rl_movies.setOnRefreshOrLoadListener(new PullToRefreshRecyclerView.OnRefreshOrLoadListener() {
            @Override
            public void onRefresh() {
                mainPresenter.getHotSaleMoiveList();
            }

            @Override
            public void onLoadMore() {

            }
        });

    }

    @Override
    public void getHotSalingMovieList(List<HotSaleMovieBean.MoviesBean> moviesList) {
        rl_movies.updateDataComplete();
            homeMovieAdapter.updateData(moviesList);


    }
}
