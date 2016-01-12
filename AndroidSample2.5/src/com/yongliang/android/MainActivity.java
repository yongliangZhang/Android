package com.yongliang.android;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Button b = (Button) v;
				b.setEnabled(false);
				b.setText("我是不可用按钮");
				Toast.makeText(MainActivity.this, "按钮为不可用", Toast.LENGTH_SHORT)
						.show();
			}
		});
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				button.setEnabled(true);
				button.setText("我是可用按钮");
			}
		});
	}
}
