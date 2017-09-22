package com.recycleself.toolslibrary;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import java.util.Stack;

/**
 * hdl on 2017/9/11.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 */

public class H_ActivityTools {

    private static Stack<Activity> activityStack;

    /**
     * 将Activity 添加到栈
     * @param activity
     */
    public static void addAcitivity(Activity activity){
        if(activityStack==null){
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 移除栈底 activity
     */
    public static void romveAcitivity(){
        if (activityStack != null && activityStack.size() > 0) {
            activityStack.pop();
        }
    }

    /**
     * 关闭所有acitivity
     */
    public static void finsihAllAcitivity(){
        if(activityStack==null|| activityStack.size()==0){
            return;
        }
        while(activityStack.size()>0){
            Activity pop = activityStack.pop();
            pop.finish();
        }
    }

    /**
     * 完全退出app
     */
    public static  void closeApp(){
        finsihAllAcitivity();
        System.exit(0);
    }


    /**
     * 隐藏基本Activity ActionBar
     * @param activity
     */
    public static void hideActionBar(Activity activity){
        ActionBar actionBar = activity.getActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }


    /**
     * 隐藏AppCompatActivity ActionBar
     * @param appCompatActivity
     */
    public static void hideSupportActionBar(AppCompatActivity appCompatActivity){
        android.support.v7.app.ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.hide();
        }
    }

    /**
     * 设置Activity 全屏  隐藏状态栏
     * @param activity
     */
    public static void setFullScreem(Activity activity){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    /**
     * 设置Activity 横屏
     * android:screenOrientation="landscape"
     * @param activity
     */
    public static void setActivityLandscape(Activity activity){
        if (activity.getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    /**
     * 设置Activity 竖屏
     * android:screenOrientation="portrait"
     * @param activity
     */
    public static void setActivityPortrait(Activity activity){
        if (activity.getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }




}
