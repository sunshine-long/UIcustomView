package com.marlon.example.uicustomviews.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.marlon.example.uicustomviews.R;
import com.marlon.example.uicustomviews.views.TitleLayout;

public abstract class BaseActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private TitleLayout titleBar;

    private LinearLayout baseContentview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        titleBar = (TitleLayout) findViewById(R.id.titleBar);
        baseContentview = (LinearLayout) findViewById(R.id.base_contentview);
        baseContentview.addView(View.inflate(this,setContentView(),null));
    }

    protected abstract int setContentView();

    /**
     * 设置titleBarS是否可见
     *
     * @param visiable
     */
    public void setTitleBarVisiable(boolean visiable) {
        if (!visiable) {
            titleBar.setVisibility(View.GONE);
        }
    }

    /**
     * 是否是沉浸式状态栏
     *
     * @param immersive
     */

    public void isImmersive(boolean immersive) {
        if (immersive) {
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }


    public void setTitleEditOnClickListener(View.OnClickListener listener) {
        titleBar.setTitleEditOnClickListener(listener);
    }

    public void setTitleBackOnClickListener(View.OnClickListener listener) {
        titleBar.setTitleBackOnClickListener(listener);
    }

    public void setTitleText(String title) {
        titleBar.setTitleText(title);
    }

    public void setTitleBackText(String title) {
        titleBar.setTitleBackText(title);
    }

    public void setTitleEditText(String title) {
        titleBar.setTitleEditText(title);
    }

    public void setTitleEditBackground(int background) {
        titleBar.setTitleEditBackground(background);
    }

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
