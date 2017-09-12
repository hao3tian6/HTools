package com.recycleself.toolslibrary.activity;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;

import com.recycleself.toolslibrary.R;

public class H_SelectPhotoActivity extends FragmentActivity {

    private String[] STORE_IMAGE = {
            MediaStore.Images.Media.DISPLAY_NAME,

    };
    private LoaderManager loaderManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        //获取手机中所有的图片
        getAllPhoto();

    }

    /**
     * 获取所有图片
     */
    private void getAllPhoto() {
         loaderManager = getLoaderManager();
        loaderManager.initLoader(0, null, new LoaderManager.LoaderCallbacks<Cursor>() {


            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {

//                new CursorLoader()
                return null;
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {

            }
        });
    }


}
