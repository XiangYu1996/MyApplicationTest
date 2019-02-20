package com.example.asus_pc.listview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

public class TestBroadcatReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        //receive broadcast,handle data

        //>10秒   会ANR   做耗时操作可以Thread
        if (intent != null){
            if (TextUtils.equals(intent.getAction(),SendBroadcastActivity.COM_EXAMPLE_ASUS_PC_LISTVIEW_BROADCAST)){
                String toastString = intent.getStringExtra("toast");
                Toast.makeText(context,toastString,Toast.LENGTH_LONG).show();


            }
        }
    }
}
