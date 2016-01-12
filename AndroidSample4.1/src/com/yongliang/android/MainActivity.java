package com.yongliang.android;

import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private int i = 0;
	private ImageView mouse;
	private Handler handler;
	public int[][] poisition = new int[][] { { 231, 325 }, { 424, 249 },
			{ 521, 256 }, { 543, 296 }, { 719, 245 }, { 832, 292 },
			{ 772, 358 } };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mouse = (ImageView) findViewById(R.id.imageView1);
		mouse.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO 自动生成的方法存根
				v.setVisibility(View.INVISIBLE);
				i++;
				Toast.makeText(MainActivity.this, "打到[" + i + "]只地鼠！",
						Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		handler = new Handler() {
			public void handleMessage(Message msg) {
				int index = 0;
				if (msg.what == 0x101) {
					index = msg.arg1;
					mouse.setX(poisition[index][0]);
					mouse.setY(poisition[index][1]);
					mouse.setVisibility(View.VISIBLE);
				}
				super.handleMessage(msg);

			}
		};
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				int index = 0;
				while (!Thread.interrupted()) {
					index = new Random().nextInt(poisition.length);
					Message m = handler.obtainMessage();
					m.arg1 = index;
					m.what = 0x101;
					handler.sendMessage(m);
					try {
						Thread.sleep(new Random().nextInt(500) + 500);

					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}

			}
		});
		t.start();
	}

}
