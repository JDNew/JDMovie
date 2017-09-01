package com.example.jdnew.jdmovie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.jdnew.jdmovie.R;

/**
 * Created by JDNew on 2017/8/31.
 */

public class CityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public TextView textView;

    private ItemClickListener itemClickListener;

    public CityViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.tv_city);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null) {
            itemClickListener.onClick(getAdapterPosition());
        }

    }

    @Override
    public boolean onLongClick(View v) {
        if (itemClickListener != null) {
            itemClickListener.onLongClick(getAdapterPosition());
        }

        return false;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onClick(int adapterPosition);
        void onLongClick(int adapterPosition);
    }
}
