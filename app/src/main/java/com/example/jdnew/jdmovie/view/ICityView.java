package com.example.jdnew.jdmovie.view;

import com.example.jdnew.jdmovie.model.CityBean;

import java.util.List;

/**
 * Created by JDNew on 2017/8/30.
 */

public interface ICityView {
    void getCityList(List<CityBean.PBean> cityList);
}
