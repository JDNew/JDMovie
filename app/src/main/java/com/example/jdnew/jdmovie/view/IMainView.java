package com.example.jdnew.jdmovie.view;

import com.example.jdnew.jdmovie.model.HotSaleMovieBean;

import java.util.List;

/**
 * Created by JDNew on 2017/9/1.
 */

public interface IMainView {

    void getHotSalingMovieList(List<HotSaleMovieBean.MoviesBean> moviesList);
}
