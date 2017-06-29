package com.marlon.example.uicustomviews;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.content_view)
    FrameLayout contentView;
    @BindView(R.id.new_bottom_layout)
    NewBottomLayout newBottomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                        Toast.makeText(MainActivity.this, "新我的", Toast.LENGTH_SHORT).show();
                        break;


                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
    }
}
