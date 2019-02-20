package com.example.asus_pc.listview;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;

public class SendBroadcastActivity extends Activity {

    public static final String COM_EXAMPLE_ASUS_PC_LISTVIEW_BROADCAST = "com.example.asus_pc.listview.broadcast";
    private TestBroadcatReceiver mTestBroadcatReceiver = new TestBroadcatReceiver();
    private Button mSendBroadcastButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_broadcast);



        mSendBroadcastButton = findViewById(R.id.send_broadcast_button);

        mSendBroadcastButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //发送广播
                Intent intent = new Intent();
                intent.setAction(COM_EXAMPLE_ASUS_PC_LISTVIEW_BROADCAST);
                intent.putExtra("toast","this is my toast of broadcast");

                //普通广播
                sendBroadcast(intent);

                //有序广播
                // sendOrderedBroadcast( );
                //本应用内的广播
                // LocalBroadcastManager;
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        //有一个IntentFilter  动态注册广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(COM_EXAMPLE_ASUS_PC_LISTVIEW_BROADCAST);
        registerReceiver(mTestBroadcatReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mTestBroadcatReceiver);
    }
}
