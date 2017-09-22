package com.recycleself.toolslibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * hdl on 2017/9/22.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 * 关于日期的一些工具类
 */

public class H_DateTools {


    /**
     * 获取时间
     * @return 返回 yyyy/MM/dd 时间格式
     */
    public static String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
       return simpleDateFormat.format(date);
    }

    /**
     * 获得当天是星期几
     * @return 返回星期
     */
    public static String getWeekDay(){
        String[] weekdays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1;
        if (i<0)
            i=0;

        return weekdays[i];
    }
}
