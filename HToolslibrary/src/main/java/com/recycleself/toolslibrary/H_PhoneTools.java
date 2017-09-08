package com.recycleself.toolslibrary;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * hdl on 2017/9/7.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 */

public class H_PhoneTools {
    /**
     * 获取imei
     * @param context
     * @return imei 值
     */
    public static String getImei(Context context) {
        String imei = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
        } catch (Exception e) {
            Log.e(H_PhoneTools.class.getSimpleName(), e.getMessage());
        }
        return imei;
    }

    /**
     * 获取手机sn码
     * @param context
     * @return
     */
    public static String getSN(Context context){
        String sn = Build.SERIAL;
        return sn;
    }
}
