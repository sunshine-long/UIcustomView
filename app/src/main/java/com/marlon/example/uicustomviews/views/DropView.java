package com.marlon.example.uicustomviews.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ToggleButton;

import com.marlon.example.uicustomviews.R;
import com.marlon.example.uicustomviews.adapter.DropViewListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by KangLong on 2017/8/30.
 * 仿美团下来列表
 */

public class DropView extends LinearLayout {
    private static final String TAG = "DropView";
    @BindView(R.id.category)
    ToggleButton category;
    @BindView(R.id.distance)
    ToggleButton distance;
    @BindView(R.id.sort)
    ToggleButton sort;
    @BindView(R.id.screen)
    ToggleButton screen;
    @BindView(R.id.top_layout)
    LinearLayout topLayout;


    private PopupWindow mPopupWindow;
    private View mCategoryView, mDistanceView, mSortView, mScreenView;
    private DropViewListAdapter mListAdapter;
    private Context mContext;
    private ListView mCategorylist,mSortList;

    public DropView(Context context) {
        this(context, null);
    }

    public DropView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.dropview_layout, this);
        ButterKnife.bind(view, this);
        initPopWindows(context);
        initContentView(context);
    }

    private void initContentView(Context context) {

        mCategoryView = LayoutInflater.from(context).inflate(R.layout.category_pop_layout, null);
        mCategoryView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mPopupWindow && mPopupWindow.isShowing()){
                    mPopupWindow.dismiss();
                }
            }
        });
        mCategorylist = (ListView) mCategoryView.findViewById(R.id.list_view);
        mDistanceView = LayoutInflater.from(context).inflate(R.layout.category_pop_layout, null);
        mSortView = LayoutInflater.from(context).inflate(R.layout.category_pop_layout, null);
        mSortList = (ListView) mSortView.findViewById(R.id.list_view);
        mScreenView = LayoutInflater.from(context).inflate(R.layout.category_pop_layout, null);
    }

    public void setCategoryData(List<String> lists) {
        mListAdapter = new DropViewListAdapter(mContext);
        mListAdapter.setList(lists);
        mCategorylist.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();
    }
    public void setSortData(List<String> lists){
        mListAdapter = new DropViewListAdapter(mContext);
        mListAdapter.setList(lists);
        mSortList.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();
    }

    private void initPopWindows(Context context) {
        mPopupWindow = new PopupWindow(context);
        mPopupWindow.setWidth(LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(LayoutParams.MATCH_PARENT);
//        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
    }

    @OnClick({R.id.category, R.id.distance, R.id.sort, R.id.screen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.category:
                if (category.isChecked()){
                    mPopupWindow.setContentView(mCategoryView);
                    mPopupWindow.showAsDropDown(topLayout);
                }else {
                    if (mPopupWindow.isShowing()) {
                        mPopupWindow.dismiss();
                    }
                }
                break;
            case R.id.distance:
                break;
            case R.id.sort:
                if (sort.isChecked()){
                    mPopupWindow.setContentView(mSortView);
                    mPopupWindow.showAsDropDown(topLayout);
                }else {
                    if (mPopupWindow.isShowing()) {
                        mPopupWindow.dismiss();
                    }
                }
                break;
            case R.id.screen:
                break;
        }
    }
}
