package com.sourcebits.taskmediaplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{

	 Button startPlaybackButton, stopPlaybackButton;
	 Intent playbackServiceIntent;

	 @Override
	 public void onCreate(Bundle savedInstanceState) 
	 {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    startPlaybackButton = (Button) this.findViewById(R.id.StartPlaybackButton);
	    stopPlaybackButton = (Button) this.findViewById(R.id.StopPlaybackButton);

	    startPlaybackButton.setOnClickListener(this);
	    stopPlaybackButton.setOnClickListener(this);

	    playbackServiceIntent = new Intent(this, ServiceMediaPlayer.class);
	  }

	@Override
	public void onClick(View v) 
	{
		 if (v == startPlaybackButton) {
		      startService(playbackServiceIntent);
		      finish();
		    } else if (v == stopPlaybackButton) {
		      stopService(playbackServiceIntent);
		      finish();
		    }
		
	}
}
