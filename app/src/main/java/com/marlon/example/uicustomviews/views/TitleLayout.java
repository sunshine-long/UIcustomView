package com.marlon.example.uicustomviews.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.marlon.example.uicustomviews.R;

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

    //定义了各个控件的属性变量
    String title, leftText, rightText;
    int titleColor, leftTextColor, rightTextColor;
    float titleTextSize,leftTextSize,rightTextSize;
    Drawable leftBackground, rightBackground;

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view =  LayoutInflater.from(context).inflate(R.layout.title, this);
        ButterKnife.bind(this,view);
        initTypedArray(context, attrs);
        init();
    }

    private void init() {
        if (null != title){
        titleText.setText(title);
        }
        titleText.setTextSize(titleTextSize);
        titleText.setTextColor(titleColor);
        if (leftText!= null) {
            titleBack.setText(leftText);
        }
        if (leftTextColor!=0) {
            titleBack.setTextColor(leftTextColor);
        }
        titleBack.setTextSize(leftTextSize);
        if (leftBackground!= null) {
            titleBack.setBackgroundDrawable(leftBackground);
        }
        if (rightText!= null){
            titleEdit.setText(rightText);
        }
        if (rightTextColor!= 0) {
            titleEdit.setTextColor(rightTextColor);
        }
        titleEdit.setTextSize(rightTextSize);
        if (rightBackground!=null) {
            titleEdit.setBackgroundDrawable(rightBackground);
        }
    }

    private void initTypedArray(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout);
        title = typedArray.getString(R.styleable.TitleLayout_title);
        titleColor = typedArray.getColor(R.styleable.TitleLayout_titleColor,0);
        titleTextSize=  typedArray.getDimension(R.styleable.TitleLayout_titleSize,18);
        leftText = typedArray.getString(R.styleable.TitleLayout_leftText);
        leftTextColor = typedArray.getColor(R.styleable.TitleLayout_leftTextColor, 0);
        leftTextSize = typedArray.getDimension(R.styleable.TitleLayout_leftTextSize,12);
        leftBackground = typedArray.getDrawable(R.styleable.TitleLayout_leftBackground);
        rightText = typedArray.getString(R.styleable.TitleLayout_rightText);
        rightTextColor = typedArray.getColor(R.styleable.TitleLayout_rightTextColor, 0);
        rightTextSize = typedArray.getDimension(R.styleable.TitleLayout_rightTextSize,12);
        rightBackground = typedArray.getDrawable(R.styleable.TitleLayout_rightBackground);
        typedArray.recycle();
    }

    @OnClick({R.id.title_back, R.id.title_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                ((Activity)getContext()).finish();
                break;
            case R.id.title_edit:
//                Toast.makeText(getContext(), "You clicked Edit Button", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void setTitleEditOnClickListener(OnClickListener listener) {
        titleEdit.setOnClickListener(listener);
    }

    public void setTitleBackOnClickListener(OnClickListener listener) {
        titleEdit.setOnClickListener(listener);
    }

    public void setTitleText(String title){
        titleText.setText(title);
    }

    public void setTitleBackText(String title){
        titleBack.setText(title);
    }

    public void setTitleEditText(String title){
        titleEdit.setText(title);
    }
    public void setTitleEditBackground(int background){
        titleEdit.setBackgroundResource(background);
    }

}
