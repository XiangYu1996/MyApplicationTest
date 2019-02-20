package com.example.asus_pc.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    public static final String TITLE = "title";
    private Button mListViewButton;
    private Button mGridViewButton;
    private LayoutInflater mLayoutInflater;
    private Button mTestViewButton;
    private Button mFragmentButton;
    private Button mHandlerButton;
    private Button mMusicButton;
    private Button mBroadcastButton;
    private Button mWebViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mLayoutInflater = getLayoutInflater();
        mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        mLayoutInflater = LayoutInflater.from(MainActivity.this);

        View view = mLayoutInflater.inflate(R.layout.activity_main,null);


        initViews();

        handleIntentData();

        testFileDemo();
    }

    /**
     * the demo for test file
     */
    private void testFileDemo() {
        //create a new file of test.txt in the internal storage
        File file = new File(getFilesDir(),"test.txt");

        Log.i("MainActivity","getFilesDir:"+getFilesDir().getAbsolutePath());
        Log.i("MainActivity","file path:"+file.getAbsolutePath());

        try {
            boolean isSuccess = file.createNewFile();
        }catch (IOException e) {
        Log.i("MainAcyivity","test.txt create error:"+e.toString());
        e.printStackTrace();
        }
        }


    private void handleIntentData() {
        Intent intent = getIntent();
        if(intent != null){
            String title = intent.getStringExtra(SplashActivity.TITLE);
            UserInfo userInfo = (UserInfo) intent.getSerializableExtra(SplashActivity.USER_INFO);
            setTitle("名字是："+userInfo.getUserName());
        }
    }

    private void initViews() {
        mListViewButton = (Button) findViewById(R.id.list_view_button);
        mGridViewButton = (Button) findViewById(R.id.grid_view_button);
        mTestViewButton = (Button) findViewById(R.id.test_view_button);
        mFragmentButton = (Button) findViewById(R.id.fragment_button);
        mHandlerButton = (Button) findViewById(R.id.handler_button);
        mMusicButton = (Button) findViewById(R.id.music_button);
        mBroadcastButton = (Button) findViewById(R.id.broadcast_button);
        mWebViewButton = (Button) findViewById(R.id.web_view_button);

        mListViewButton.setOnClickListener(this);
        mGridViewButton.setOnClickListener(this);
        mTestViewButton.setOnClickListener(this);
        mFragmentButton.setOnClickListener(this);
        mHandlerButton.setOnClickListener(this);
        mMusicButton.setOnClickListener(this);
        mBroadcastButton.setOnClickListener(this);
        mWebViewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.list_view_button:
                startActivity(new Intent(MainActivity.this,ListViewDemoActivity.class));
            break;
            case R.id.grid_view_button:
                startActivity(new Intent(MainActivity.this,GridViewDemoActivity.class));
                break;
            case R.id.test_view_button:
                startActivity(new Intent(MainActivity.this,TestViewButtonActivity.class));
                break;
            case R.id.fragment_button:
                startActivity(new Intent(MainActivity.this,TestFragmentActivity.class));
                break;
            case R.id.handler_button:
                startActivity(new Intent(MainActivity.this,HandlerButtonActivity.class));
                break;
            case R.id.music_button:
                startActivity(new Intent(MainActivity.this,MusicButtonActivity.class));
                break;
            case R.id.broadcast_button:
                startActivity(new Intent(MainActivity.this,SendBroadcastActivity.class));
                break;
            case R.id.web_view_button:
                startActivity(new Intent(MainActivity.this,WebViewButtonActivity.class));
                break;

        }
    }
}
