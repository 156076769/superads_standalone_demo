package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

import com.superads.android.adsdkdemostandalone.R;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = BaseActivity.this.getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorStatus));
    }


}
