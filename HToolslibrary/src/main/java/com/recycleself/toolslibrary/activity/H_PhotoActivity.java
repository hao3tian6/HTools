package com.recycleself.toolslibrary.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.recycleself.toolslibrary.image.GetPhoto;

/**
 * hdl on 2017/9/11.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 *
 * 获取图片activity 基类   继承就有可以拍照
 */

public class H_PhotoActivity extends H_BaseActivity implements GetPhoto.PhotoListen {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void getSuccess() {

    }

    @Override
    public void getFaild() {

    }

    @Override
    public void getCancel() {

    }
}
