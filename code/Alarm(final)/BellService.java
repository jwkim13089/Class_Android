package com.example.getready;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;

public class BellService extends Service {

MediaPlayer mp;

public BellService() {
}
@Override
public void onCreate() {
super.onCreate();
mp = MediaPlayer.create(this,R.raw.snd);
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
mp.start();
return super.onStartCommand(intent, flags, startId);
}

@Override
public void onDestroy() {
mp.stop();
super.onDestroy();
}

@Override
public IBinder onBind(Intent intent) {
// TODO: Return the communication channel to the service.
throw new UnsupportedOperationException("Not yet implemented");
}
}