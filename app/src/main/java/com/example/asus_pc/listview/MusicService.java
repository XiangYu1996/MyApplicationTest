package com.example.asus_pc.listview;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MusicService extends Service{

    private MediaPlayer mMediaPlayer;
    private IBinder mIBinder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this,R.raw.hot);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMediaPlayer.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        mMediaPlayer.stop();
        super.onDestroy();
    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }


    public class LocalBinder extends Binder{
        MusicService getService(){
            return MusicService.this;
        }
    }

    public int getMusicPlayProgress(){
        return 18;


    }

}
