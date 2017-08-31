package com.marlon.example.uicustomviews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.marlon.example.uicustomviews.R;
import com.marlon.example.uicustomviews.base.BaseActivity;
import com.marlon.example.uicustomviews.views.DropView;
import com.marlon.example.uicustomviews.views.NewBottomLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.content_view)
    FrameLayout contentView;
    @BindView(R.id.new_bottom_layout)
    NewBottomLayout newBottomLayout;
    @BindView(R.id.dropView)
    DropView dropView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        newBottomLayout.setOnMenuTabClickListener(new NewBottomLayout.OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.home_radio:
                        Toast.makeText(MainActivity.this, "新首页", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.discover_radio:
                        Toast.makeText(MainActivity.this, "新发现", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mine_radio:
                      startActivity(new Intent(MainActivity.this,TestActivity.class));
                        break;
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
        List<String> stringList = new ArrayList<>();
        stringList.add("全部");
        stringList.add("甜品");
        stringList.add("蛋糕");
        stringList.add("火锅");
        stringList.add("自助餐");
        stringList.add("小吃");
        stringList.add("料理");
        stringList.add("西餐");
        stringList.add("果蔬");
        stringList.add("川菜");
        stringList.add("烤肉");
        stringList.add("湘菜");
        dropView.setCategoryData(stringList);
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("全部");
        stringList2.add("甜品");
        stringList2.add("蛋糕");
        stringList2.add("火锅");
        dropView.setSortData(stringList2);
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

}
