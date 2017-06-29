package com.marlon.example.uicustomviews;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by KangLong on 2017/6/28.
 */

public class NewBottomLayout extends LinearLayout {
    @BindView(R.id.home_radio)
    RadioButton homeRadio;
    @BindView(R.id.discover_radio)
    RadioButton discoverRadio;
    @BindView(R.id.mine_radio)
    RadioButton mineRadio;

    public OnMenuTabClickListener getOnMenuTabClickListener() {
        return onMenuTabClickListener;
    }

    public void setOnMenuTabClickListener(OnMenuTabClickListener onMenuTabClickListener) {
        this.onMenuTabClickListener = onMenuTabClickListener;
    }

    private OnMenuTabClickListener onMenuTabClickListener;

    public NewBottomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.new_bottom, this);
        ButterKnife.bind(view,this);
        homeRadio.setChecked(true);
    }

    @OnClick({R.id.home_radio, R.id.discover_radio, R.id.mine_radio})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_radio:
                onMenuTabClickListener.onMenuTabSelected(R.id.home_radio);
                break;
            case R.id.discover_radio:
                onMenuTabClickListener.onMenuTabSelected(R.id.discover_radio);
                break;
            case R.id.mine_radio:
                onMenuTabClickListener.onMenuTabSelected(R.id.mine_radio);
                break;
        }
    }

   public interface OnMenuTabClickListener{
       void onMenuTabSelected(@IdRes int menuItemId);

       void onMenuTabReSelected(@IdRes int menuItemId);
   }
}
