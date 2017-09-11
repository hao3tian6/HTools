package com.recycleself.toolslibrary;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * hdl on 2017/9/8.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 *  主要功能，修改状态栏颜色  透明  字体颜色
 *
 *  状态栏透明，只支持4.4以及以上版本
 */


public class H_SystemBarStateTools {


    /**
     * 设置状态来为某种颜色
     * @param activity
     * @param color
     * android:fitsSystemWindows=”true”  是否考虑系统的布局，这个跟需求而定
     */
    public static void setBarTrans(Activity activity,int color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(color));
        }else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window window =activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(color);
        }
    }
}
