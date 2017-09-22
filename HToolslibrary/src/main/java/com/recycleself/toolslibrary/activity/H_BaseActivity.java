package com.recycleself.toolslibrary.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.recycleself.toolslibrary.H_ActivityTools;

/**
 * haodalong on 2017/9/8.
 * recycleself.xyz
 *
 * 主要功能，状态栏显示，透明   activity控制
 *
 */

public class H_BaseActivity extends AppCompatActivity {

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        H_ActivityTools.addAcitivity(this);
        mContext = this;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        H_ActivityTools.romveAcitivity();
    }
}
