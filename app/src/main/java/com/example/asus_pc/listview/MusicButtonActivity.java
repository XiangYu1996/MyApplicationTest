package com.example.asus_pc.listview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class MusicButtonActivity extends Activity implements View.OnClickListener {

    private Button mStartButton;
    private Button mStopButton;
    private MusicService mMusicService;
    private ServiceConnection mServiceConnection = new  ServiceConnection(){




        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.LocalBinder localBinder = (MusicService.LocalBinder) service;
            mMusicService = localBinder.getService();


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_button);

        mStartButton = (Button) findViewById(R.id.start);
        mStopButton = (Button) findViewById(R.id.stop);

        mStartButton.setOnClickListener(this);
        mStopButton.setOnClickListener(this);

        if (mMusicService != null){
           int progress = mMusicService.getMusicPlayProgress();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start:
                startService(new Intent(MusicButtonActivity.this,MusicService.class));
                bindService(new Intent(MusicButtonActivity.this,MusicService.class),mServiceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.stop:
                unbindService(mServiceConnection);
                stopService(new Intent(MusicButtonActivity.this,MusicService.class));
                break;

        }
    }
}
