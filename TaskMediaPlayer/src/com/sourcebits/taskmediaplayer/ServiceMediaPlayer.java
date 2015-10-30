package com.sourcebits.taskmediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;

public class ServiceMediaPlayer extends Service implements OnCompletionListener
{

	MediaPlayer mediaPlayer;

	  @Override
	  public IBinder onBind(Intent intent) {
	    return null;
	  }

	  @Override
	  public void onCreate() {
	    mediaPlayer = MediaPlayer.create(this, R.raw.darling);// raw/s.mp3
	    mediaPlayer.setOnCompletionListener(this);
	  }

	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
	    if (!mediaPlayer.isPlaying()) {
	      mediaPlayer.start();
	    }
	    return START_STICKY;
	  }

	  public void onDestroy() {
	    if (mediaPlayer.isPlaying()) {
	      mediaPlayer.stop(); 
	    }
	    mediaPlayer.release();
	  }

	  public void onCompletion(MediaPlayer _mediaPlayer) {
	    stopSelf();
	  }

}
