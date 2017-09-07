package xyz.recycleself.htools.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

import xyz.recycleself.htools.R;

/**
 * haodalong on 2017/8/12.
 * recycleself.xyz
 *
 * 重定义RelavtiveLayout
 */

public class FavorLayout extends RelativeLayout {

    private int dHeight; //爱心的高度
    private int dWidth; //爱心的宽度
    private int mHeight; //自定义布局的高度
    private int mWidth;  //自定义布局的宽度
    private Drawable[] drawables
            ;
    private LayoutParams layoutParams;
    private Random random;

    public FavorLayout(Context context) {
        super(context);
    }

    public FavorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.color.colorAccent);
        //初始化一些东西
        init();
    }

    private void init() {
        random = new Random();
        drawables = new Drawable[3];
        Drawable red = ContextCompat.getDrawable(getContext(), R.mipmap.a1);
        Drawable yellow = ContextCompat.getDrawable(getContext(), R.mipmap.a2);
        Drawable blue = ContextCompat.getDrawable(getContext(), R.mipmap.a3);
        drawables[0] = red;
        drawables[1] = yellow;
        drawables[2] = blue;

        dHeight = red.getIntrinsicHeight();
        dWidth = red.getIntrinsicWidth();

        layoutParams = new LayoutParams(dWidth, dHeight);
        layoutParams.addRule(CENTER_HORIZONTAL,TRUE);
        layoutParams.addRule(ALIGN_PARENT_BOTTOM,TRUE);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

    }

    public FavorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FavorLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void addHeartView(){
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(drawables[random.nextInt(3)]);
        imageView.setLayoutParams(layoutParams);
        addView(imageView);
//        imageView.setAnimation(getEnterAnimtor());
        AnimatorSet animtor = getEnterAnimtor(imageView);
        animtor.addListener(new AnimationListener(imageView));
        animtor.start();
    }

    class AnimationListener extends AnimatorListenerAdapter {
        private final ImageView target;

        public AnimationListener(ImageView imageView) {
            this.target = imageView;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            removeView(target);
        }
    }

    /**
     * 设置图片的动画
     * @param target 目标对象
     * @return
     */
    private AnimatorSet getEnterAnimtor(View target){
        ObjectAnimator scalex = ObjectAnimator.ofFloat(target,View.SCALE_X,0.2f,1f);
        ObjectAnimator scaley = ObjectAnimator.ofFloat(target,View.SCALE_Y,0.2f,1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(target, View.ALPHA,1f,0f);

        AnimatorSet set = new AnimatorSet();
        set.setInterpolator(new LinearInterpolator());
        set.playTogether(scalex,scaley,alpha);
        set.setDuration(500);
        set.setTarget(target);
        return set;
    }
}
