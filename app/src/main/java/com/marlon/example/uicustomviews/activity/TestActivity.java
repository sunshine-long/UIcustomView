package com.marlon.example.uicustomviews.activity;

import android.os.Bundle;
import android.view.View;

import com.marlon.example.uicustomviews.R;
import com.marlon.example.uicustomviews.base.BaseActivity;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleEditOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("点击了编辑按钮哟！@");
            }
        });
        isImmersive(true);
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_test;
    }

}
