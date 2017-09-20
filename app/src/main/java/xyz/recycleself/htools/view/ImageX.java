package xyz.recycleself.htools.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * hdl on 2017/9/18.
 * https://github.com/hao3tian5/HTools.git
 * xintian13@126.com
 */

public class ImageX extends android.support.v7.widget.AppCompatImageView {
    public ImageX(Context context) {
        super(context);
    }

    public ImageX(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageX(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // mode
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        //size
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(width/2,MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
