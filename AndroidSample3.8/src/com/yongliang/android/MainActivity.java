package com.yongliang.android;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity {
	private Thread thread;
	private static MediaPlayer mp = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((Button) v).setEnabled(false); // 设置按钮不可用
				// TODO 自动生成的方法存根
				thread = new Thread(new Runnable() {
					@Override
					public void run() {
						// TODO 自动生成的方法存根
						playBGSound();
					}
				});
				thread.start();
			}
		});
	}

	private void playBGSound() {
		if (mp != null) {
			mp.release(); // 释放资源
		}
		mp = MediaPlayer.create(MainActivity.this, R.raw.jasmine);
		mp.start();
		mp.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO 自动生成的方法存根
				try {
					Thread.sleep(5000);
					playBGSound();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		if (mp != null) {
			mp.stop();
			mp.release();
			mp = null;
		}
		if (thread != null) {
			thread = null;

		}
		super.onDestroy();
	}

}
