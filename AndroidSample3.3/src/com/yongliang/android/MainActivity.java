package com.yongliang.android;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;

public class MainActivity extends Activity {
	private boolean flag = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LinearLayout layout = (LinearLayout) findViewById(R.id.al);
		final AnimationDrawable anim = (AnimationDrawable) layout
				.getBackground();
		layout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if (flag) {
					anim.start();
					flag = false;
				} else {
					anim.stop();
					flag = true;
				}
			}
		});
	}

}
