package com.example.asus_pc.listview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class HandlerButtonActivity extends Activity {

    public static final int MASSAGE_CODE = 888888;

    private TextView mTextView;

    private TestHandler mTestHandler = new TestHandler(this)
            ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mTextView = (TextView) findViewById(R.id.handler_text_view);

        Message message = mTestHandler.obtainMessage();

        message.arg1 = 0;
        message.arg2 = 1;
        message.what = MASSAGE_CODE;
        message.obj = 10000;

        mTestHandler.sendMessageDelayed(message,1000);

        mTestHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000);





    }

    public TextView getTextView() {
        return mTextView;
    }

    public static class TestHandler extends Handler{
        public final WeakReference<HandlerButtonActivity> mHandlerButtonActivityWeakReference;

        public TestHandler(HandlerButtonActivity activity){


            mHandlerButtonActivityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            HandlerButtonActivity handlerButtonActivity = mHandlerButtonActivityWeakReference.get();
            //接收消息
            switch (msg.what){
                case MASSAGE_CODE:
                    int value = (int) msg.obj;
                    handlerButtonActivity.getTextView().setText(String.valueOf(value/1000));

                    msg =Message.obtain();
                    msg.arg1 = 0;
                    msg.arg2 = 1;
                    msg.what = MASSAGE_CODE;
                    msg.obj = value-1000;
                    if(value>0){
                        sendMessageDelayed(msg,1000);
                    }
                    break;
            }
        }
    }


}
