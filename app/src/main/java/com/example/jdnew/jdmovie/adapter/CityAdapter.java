package com.example.jdnew.jdmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jdnew.jdmovie.R;
import com.example.jdnew.jdmovie.activity.MainActivity;
import com.example.jdnew.jdmovie.common.Constant;
import com.example.jdnew.jdmovie.common.SharedCenter;
import com.example.jdnew.jdmovie.model.CityBean;
import com.example.jdnew.jdmovie.util.SharedUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDNew on 2017/8/31.
 */

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder> {

    private Context mContext;
    private List<CityBean.PBean> mCityList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public CityAdapter(Context context, List<CityBean.PBean> cityList) {
        this.mContext = context;
        this.mCityList = cityList;
        this.mLayoutInflater = LayoutInflater.from(mContext);

    }

    public CityAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(mContext);

    }


    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_city , null);
        CityViewHolder cityViewHolder = new CityViewHolder(view);
        return cityViewHolder;
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.textView.setText(mCityList.get(position).getN());
        holder.setItemClickListener(new CityViewHolder.ItemClickListener() {
            @Override
            public void onClick(int adapterPosition) {
                SharedCenter.putHaveChooseCity(mContext , true);
                SharedCenter.putCityName(mContext , mCityList.get(adapterPosition).getN());
                SharedCenter.putCityId(mContext , mCityList.get(adapterPosition).getId());

                mContext.startActivity(new Intent(mContext , MainActivity.class));
            }

            @Override
            public void onLongClick(int adapterPosition) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    public void updateData(List<CityBean.PBean> cityList){
        this.mCityList.clear();
        this.mCityList.addAll(cityList);
        notifyDataSetChanged();

    }


}
