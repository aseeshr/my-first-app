package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.TextView;

public class Splash extends Activity {
	MediaPlayer ourSong;
//	TextView splashCounter;

	@Override
	protected void onCreate(Bundle MyFirstApps) {
		// TODO Auto-generated method stub
		super.onCreate(MyFirstApps);
		setContentView(R.layout.splash);
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound);
		ourSong.start();
//		splashCounter = (TextView) findViewById(R.id.splashCounter);
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openMainActivity = new Intent(
							"com.example.myfirstapp.MainActivity");
					startActivity(openMainActivity);
				}

			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
//		ourSong.release();
		finish();
	}

}
