package com.yongliang.android;

import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements Runnable {

	private ImageView iv;
	private Handler handler;
	private int[] path = { R.drawable.img01, R.drawable.img02,
			R.drawable.img03, R.drawable.img04, R.drawable.img05,
			R.drawable.img06 };
	private String[] title = { "���ϵ�дʵ�", "��Ч����", "���ַ���", "�û���Ⱥ", "����ѧϰ",
			"ȫ��λ��ѯ" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		iv = (ImageView) findViewById(R.id.imageView1);
		Thread t = new Thread(this);
		t.start();
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO �Զ����ɵķ������
				TextView tv = (TextView) findViewById(R.id.textView1);
				if (msg.what == 0x101) {
					tv.setText(msg.getData().getString("title"));
					iv.setImageResource(path[msg.arg1]);
				}
				super.handleMessage(msg);

			}
		};

	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		int index = 0;
		while (!Thread.currentThread().isInterrupted()) {
			index = new Random().nextInt(path.length);
			Message m = handler.obtainMessage(); // ��ȡһ��Message
			m.arg1 = index;
			Bundle bundle = new Bundle();
			m.what = 0x101;
			bundle.putString("title", title[index]);
			m.setData(bundle);
			handler.sendMessage(m);
			try {
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}

		}
	}

}
