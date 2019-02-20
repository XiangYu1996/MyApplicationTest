package com.example.asus_pc.listview;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.support.annotation.Nullable;

public class TestIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService(String name) {
        super(name);
    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        //not do more works  这是UI线程  >10秒 --》ANR：application not responsed应用程序无响应


        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //排队  -->>像MessageQueue 同步操作：排队领书  、处理Intent数据



    }
}
