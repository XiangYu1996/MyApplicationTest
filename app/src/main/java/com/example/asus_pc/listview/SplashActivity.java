package com.example.asus_pc.listview;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String USER_INFO = "userInfo";
    Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView textView = (TextView) findViewById(R.id.title_text_view);
        final String title = textView.getText().toString();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                UserInfo userInfo = new UserInfo("小明",12);
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                intent.putExtra(TITLE,title);
                intent.putExtra(USER_INFO, userInfo);
                startActivity(intent);
            }
        },1000);
    }

}
