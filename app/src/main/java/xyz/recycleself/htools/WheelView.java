package xyz.recycleself.htools;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * haodalong on 2017/7/20.
 * recycleself.xyz
 *
 * 自定义WheelView
 */

public class WheelView extends View {

    public WheelView(Context context) {
        super(context);
        initPaints();
    }

    public WheelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    public WheelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WheelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaints();
    }

    /**
     * 初始化 三个画笔
     */
    private void initPaints() {

    }
}
