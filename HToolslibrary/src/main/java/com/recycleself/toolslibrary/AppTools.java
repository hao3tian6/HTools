package com.recycleself.toolslibrary;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import java.io.File;

/**
 * haodalong on 2017/9/7.
 * recycleself.xyz
 *
 * 获取app一些信息
 */

public class AppTools {





    /**
     * 根据应用包名获取 相应应用信息
     * @param context 上下文
     * @param packageName 包名
     * @return 获取packageName app 应用信息
     */
    public static PackageInfo getAppInfoByPackageName(Context context , String packageName){
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(packageName, 0);
            return packageInfo;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取自身应用信息
     * @param context
     * @return
     */
    public static PackageInfo getAppInfo(Context context){
        return getAppInfoByPackageName(context,context.getPackageName());
    }


    /**
     * 获取当前应用的版本号
     * @return 获取当前应用的版本号
     */
    public static String getVersionName(Context context) {
        PackageInfo info = getAppInfo(context);
        return info==null?"":info.versionName;
    }

    /**
     * 获取版本号
     * @return 当前应用的版本号
     */
    public static int getVersion(Context context) {
        PackageInfo info = getAppInfo(context);
        return  info==null?0:info.versionCode;
    }


    /**
     * 安装指定路径下的apk
     * @param context
     * @param filePath 文件目录
     * @return
     *         <p>
     *         最后的做法应该是调用startActivityForResult 回调判断安装是否成功 安装应用 需要读写内存卡的权限
     *         <uses-permission
     *         android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
     *         <uses-permission
     *         android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
     */
    public boolean installApp(Context context, String filePath) {
        if (filePath != null
                && filePath.length() > 4
                && filePath.toLowerCase().substring(filePath.length() - 4)
                .equals(".apk")) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            File file = new File(filePath);
            if (file.exists() && file.isFile() && file.length() > 0) {
                intent.setDataAndType(Uri.fromFile(file),
                        "application/vnd.android.package-archive");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                return true;
            }

        }
        return false;
    }

    /**
     * 通过包名，打开指定app
     * @param context
     * @param packageName
     * @return true 打开成功 false 打开失败
     */
    public  boolean openAppByPackageName(Context context, String packageName) {
        if (!TextUtils.isEmpty(packageName)) {
            PackageManager pm = context.getPackageManager();
            Intent launchIntentForPackage = pm.getLaunchIntentForPackage(packageName);
            if (launchIntentForPackage != null) {
                context.startActivity(launchIntentForPackage);
                return true;
            }
        }
        return false;
    }
}
