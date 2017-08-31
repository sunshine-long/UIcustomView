package com.marlon.example.uicustomviews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.marlon.example.uicustomviews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KangLong on 2017/8/30.
 */

public class DropViewListAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public DropViewListAdapter(@NonNull Context context) {
        super();
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView view;
        if (convertView == null) {
            convertView =  LayoutInflater.from(mContext).inflate(R.layout.choose_item, null);
            view = (TextView) convertView;
            convertView.setTag(view);
        }else {
            view = (TextView) convertView.getTag();
        }
        if (mList.size() >0){
            view.setText(mList.get(position));
        }
        return view;
    }

    public void setList(List<String> list){
        this.mList.clear();
        this.mList = list;

    }
}
