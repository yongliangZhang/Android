package com.yongliang.android;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements Runnable {
    private Thread thread;
	int i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button1=(Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				i=0;
				thread=new Thread(MainActivity.this);
				thread.start();
			}
		});
		Button button2=(Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				if(thread!=null){
					thread.interrupt();
					thread=null;
				}
				Log.i("��ʾ��", "�ж��߳�");
			}
		});
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while (!Thread.currentThread().isInterrupted()) {
                i++;
                Log.i("ѭ������", String.valueOf(i));  
		}
	}

	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		if(thread!=null){
			thread.interrupt();
			thread=null;
		}
		super.onDestroy();
	}
}
