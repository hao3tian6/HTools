package com.recycleself.toolslibrary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * hdl on 2017/9/7.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 * 网络工具类
 */

public class H_NetTools {

    /**
     * 判断网络是否可用
     * @param mContext
     * @return true 可用 false 不可用
     */
    public static boolean isAbailable(Context mContext) {

        ConnectivityManager manager= (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo!=null){
            return networkInfo.isAvailable();
        }
        return false;
    }



}
