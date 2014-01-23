package com.talenguyen.TaleSamples;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebView;

/**
 * Created by TALE on 1/18/14.
 */
public class WebActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file://" + Environment.getExternalStorageDirectory() + "/Download/matching_game/index.html");
    }
}
