package com.recycleself.toolslibrary;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * hdl on 2017/7/18.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 */

public class H_ScreenTools {

    /**
     * 获取屏幕的宽度
     * @param activity
     * @return
     */
    public static int getScreensWidth(Activity activity) {

        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        return metrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @param activity
     * @return
     */
    public static int getScreensHeight(Activity activity) {

        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        return metrics.heightPixels;
    }
}
