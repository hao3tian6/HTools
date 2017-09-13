package com.recycleself.toolslibrary.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.recycleself.toolslibrary.R;
import com.recycleself.toolslibrary.helper.Constants;

public class H_SelectPhotoActivity extends FragmentActivity {

    //需要查询的字段
    private final String[] projection = new String[]{MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.DATA
    };
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        //获取手机中所有的图片
        getAllPhoto();

    }

    @Override
    protected void onStart() {
        super.onStart();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case Constants.AGREED_PERMISSION:
                        Toast.makeText(H_SelectPhotoActivity.this, "xxxx", Toast.LENGTH_SHORT).show();
                        break;
                    case Constants.REJECT_PERMISSION:
                        
                        break;
                }
            }
        };

        //1.检查是否有读取内存的权限
        checkAppPermission();
    }

    private void checkAppPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //请求权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constants.PERMISSION_REQUEST_READ_EXTERNAL_STORAGE);
        }

        //权限请求成功  发布消息请求数据
        Message message = handler.obtainMessage();
        message.what = Constants.AGREED_PERMISSION;
        message.sendToTarget();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==Constants.PERMISSION_REQUEST_READ_EXTERNAL_STORAGE){
            Message message = handler.obtainMessage();
            message.what = grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED?Constants.AGREED_PERMISSION:Constants.REJECT_PERMISSION;
            message.sendToTarget();
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    /**
     * 获取所有图片
     */
    private void getAllPhoto() {
        new Thread() {
            @Override
            public void run() {
                //查询数据库内容
                Cursor cursor = getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, MediaStore.Images.Media.DATE_ADDED);
            }
        }.start();
    }
}
