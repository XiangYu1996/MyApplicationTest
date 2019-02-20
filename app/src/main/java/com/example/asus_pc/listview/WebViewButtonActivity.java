package com.example.asus_pc.listview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewButtonActivity extends AppCompatActivity {

    private WebView mWebView;


    public class TestJSEvent{
        @JavascriptInterface
        public void showToast(String toast){
            Toast.makeText(WebViewButtonActivity.this,"toast",Toast.LENGTH_LONG).show();

        }


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = (WebView) findViewById(R.id.web_view);


        //  要安卓4.4以上  可以开启调试WebView.setWebContentsDebuggingEnabled(true);



        mWebView.loadUrl("http://www.baidu.com");
        //mWebView.loadUrl("file:///android_assets/aa.html");

        //mWebView.getSettings().setJavaScriptEnabled(true);



        //JS调用原生App
       // mWebView.addJavascriptInterface(new TestJSEvent(),"TestApp");



        //原生App调用JS
        //mWebView.loadUrl("javascpript:javaCallJS()");


//        CookieManager cookieManager = CookieManager.getInstance();
//        cookieManager.setAcceptCookie(true);
//        cookieManager.setCookie("domain","cookie");
        //cookieManager.removeAllCookies();




        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //是不是重新加载 （拦截见面）
                //404页面

               if(url.contains("404")){
               }
               // view.loadUrl("www.zhihu.com");
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //页面开始：显示loading动画
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //页面开始：隐藏loading动画
                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                //加载资源的时候
                //url  替换
                if (url.contains("logo.img")){


                }
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                return super.shouldInterceptRequest(view, url);
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                //request        hybrid 离线网页
                return super.shouldInterceptRequest(view, request);
            }
        });


        mWebView.setWebChromeClient(new TestWebChromeClient());


    }



    public class TestWebChromeClient extends WebChromeClient{
        public TestWebChromeClient() {
            super();
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

        @Override
        public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
            super.onReceivedTouchIconUrl(view, url, precomposed);
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
        }
    }




    @Override
    public void onBackPressed() {
        if (mWebView != null&& mWebView.canGoBack()){


//            WebBackForwardList webBackForwardList = mWebView.copyBackForwardList();
//
//            WebHistoryItem historyItem = webBackForwardList.getItemAtIndex(0);
//
//            String historyUrl = historyItem.getUrl();
//

            mWebView.goBack();//后退
//            mWebView.goForward();//前进
//            mWebView.goBackOrForward(+1);//前进（正数）或后退（负数） 还有步数
//            mWebView.reload();//刷新

        }else {
            super.onBackPressed();
        }
    }
}
