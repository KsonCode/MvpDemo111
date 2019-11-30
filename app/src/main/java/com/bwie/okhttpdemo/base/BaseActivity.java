package com.bwie.okhttpdemo.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    /**
     * 绑定根视图
     * @return
     */
    protected abstract int bindLayoutId();

    /**
     * 显示toast
     * @param msg
     */
    public void showToast(String msg){

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
