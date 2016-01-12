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
				// TODO �Զ����ɵķ������
				Button b = (Button) v;
				b.setEnabled(false);
				b.setText("���ǲ����ð�ť");
				Toast.makeText(MainActivity.this, "��ťΪ������", Toast.LENGTH_SHORT)
						.show();
			}
		});
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				button.setEnabled(true);
				button.setText("���ǿ��ð�ť");
			}
		});
	}
}
