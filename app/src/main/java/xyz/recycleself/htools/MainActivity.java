package xyz.recycleself.htools;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.recycleself.toolslibrary.H_ScreenTools;
import com.recycleself.toolslibrary.H_SystemBarStateTools;

import java.util.Stack;

import xyz.recycleself.htools.view.FavorLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "hao";
    private TextView viewById;
    private TextView viewById1;
    private TextView viewById2;
    private TextView viewById3;
    private ImageView iv;
    private ImageView iv_1
            ;
    private FavorLayout favorLayout;
    private WebView webView;
    private Button testBt;
    private TextView sssss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        H_SystemBarStateTools.setBarBgColor(MainActivity.this,R.color.colorAccent);
        setContentView(R.layout.activity_main);
        favorLayout = (FavorLayout) findViewById(R.id.fl);
        favorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favorLayout.addHeartView();
            }
        });


        int screensHeight = H_ScreenTools.getScreensHeight(this);
        Log.i(TAG, "onCreate: "+screensHeight);
        String url = "http://www.recycleself.xyz:8080";
        webView = (WebView) findViewById(R.id.wv);
        webView.loadUrl(url);
        testBt = (Button) findViewById(R.id.testBt);
        testBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,WebViewTestActivity.class));
                H_SystemBarStateTools.setBarBgColor(MainActivity.this,R.color.colorAccent);
            }
        });

        H_ScreenTools.getScreensHeight(this);
//        viewById = (TextView) findViewById(R.id.tv);
//        viewById1 = (TextView) findViewById(R.id.tv1);
//        viewById2 = (TextView) findViewById(R.id.tv2);
//        viewById3 = (TextView) findViewById(R.id.tv3);
//        viewById.setText("欢饮来到这个世界");
//        viewById1.setText("2f欢饮来到这个世界");
//        viewById1.setScaleX(2f);
//        viewById2.setText("0.5f欢饮来到这个世界");
//        viewById2.setScaleX(0.5f);
//        viewById3.setText("欢饮来到这个世界");
//        viewById3.setScaleX(1.1f);


        iv = (ImageView) findViewById(R.id.iv_);


        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"scaleX",1f,2f,3f,2f,1f);
        animator.setDuration(1000);
//        animator.start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv,"scaleY",1f,2f,3f,2f,1f);
        animator1.setDuration(1000);
//        animator1.start();

        ObjectAnimator animatory = ObjectAnimator.ofFloat(iv,"translationY",0,-300f,300f);


        AnimatorSet set = new AnimatorSet();
//        set.play(animator).with(animator1).after(animatory);
//        set.setDuration(3000);
//        set.start();

        set.play(animator).with(animator1).after(5000).before(animatory);
        set.setDuration(3000);
        set.start();

//        animator.setDuration(2000);
//        animator.start();
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "xksk", Toast.LENGTH_SHORT).show();
//            }
//        });

//        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"rotation",0f,356f,0f);
//        animator.setDuration(3000);
//        animator.start();

//        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"alpha",1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f);
//        animator.setDuration(2000);
////        animator.setRepeatMode(ObjectAnimator.REVERSE);
//        animator.setRepeatCount(1);
//        animator.start();


//        ObjectAnimator animator = ObjectAnimator.ofFloat(iv,"rotation",0f,360f);
//        animator.setDuration(2000);
//        animator.setRepeatCount(-1);
//        animator.setRepeatMode(ObjectAnimator.REVERSE);
//        animator.start();
//        ObjectAnimator anim = ObjectAnimator.ofFloat(iv, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f);
//        anim.setRepeatCount(-1);
//        anim.setRepeatMode(ObjectAnimator.REVERSE);
//        anim.setDuration(2000);
//        anim.start();

//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tanslate_demo);
//        animation.setFillAfter(true);
//        iv.startAnimation(animation);
//
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "点击啦", Toast.LENGTH_SHORT).show();
//            }
//        });
//        AnimationDrawable drawable= (AnimationDrawable) iv.getDrawable();
//        drawable.start();
//        iv_1 = (ImageView) findViewById(R.id.iv_1);

        sssss = (TextView) findViewById(R.id.tv3);

        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);

        while (stack.size()>0){
            if(((Integer)stack.peek())==4){
//                st

                break;
            }else {
                stack.pop();
            }

        }

        Toast.makeText(this, ""+stack.toString(), Toast.LENGTH_SHORT).show();
        sssss.setText(stack.toString());

    }
}
