package xyz.recycleself.htools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.recycleself.toolslibrary.ScreenTools;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "sss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screensHeight = ScreenTools.getScreensHeight(this);
        Log.i(TAG, "onCreate: "+screensHeight);
    }
}
