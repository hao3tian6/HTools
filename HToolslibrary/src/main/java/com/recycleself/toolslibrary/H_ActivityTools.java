package com.recycleself.toolslibrary;

import android.app.Activity;

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




}
