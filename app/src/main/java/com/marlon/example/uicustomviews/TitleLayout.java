package com.marlon.example.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by KangLong on 2017/6/28.
 */

public class TitleLayout extends LinearLayout {
    @BindView(R.id.title_back)
    Button titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.title_edit)
    Button titleEdit;

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view =  LayoutInflater.from(context).inflate(R.layout.title, this);
        ButterKnife.bind(this,view);
    }

    @OnClick({R.id.title_back, R.id.title_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                ((Activity)getContext()).finish();
                break;
            case R.id.title_edit:
                Toast.makeText(getContext(), "You clicked Edit Button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
