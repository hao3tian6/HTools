package xyz.recycleself.htools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class WebViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_test);
        assignViews();
    }

    private WebView webview;
    private Button button;

    private void assignViews() {
        String url = "http://www.recycleself.xyz:8080";
        webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(url);
//        button = (Button) findViewById(R.id.button);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
                view.loadUrl(request.toString());
                return true;
            }
        });
         button = (Button) findViewById(R.id.button);button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "系好安全带!", Toast.LENGTH_SHORT).show();
            }});
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (event.getKeyCode()==KeyEvent.KEYCODE_BACK)
        if(event.getKeyCode()==KeyEvent.KEYCODE_BACK){
            if(webview.canGoBack()){
                webview.goBack();
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
