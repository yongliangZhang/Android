/*
 * ��Ϣ��ʾ��Ի���
 * 2013-12-19
 */
package com.yongliang.android;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	final static  int NOTIFYID_1=123;
	final static  int NOTIFYID_2=234;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final  NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Button button1=(Button) findViewById(R.id.button1);
		Button button2=(Button) findViewById(R.id.button2);
		button1.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Notification notify=new Notification();
				notify.icon=R.drawable.advise;
				notify.tickerText="��ʾ��һ��֪ͨ";
				notify.when=System.currentTimeMillis();
				notify.defaults=Notification.DEFAULT_ALL;
				notify.setLatestEventInfo(MainActivity.this, "����", "ÿ�����һ���", null);
				notificationManager.notify(NOTIFYID_1,notify);
				Notification notify1=new Notification(R.drawable.advise2,"��ʾ�ڶ���֪ͨ",System.currentTimeMillis());
				notify1.flags=Notification.FLAG_AUTO_CANCEL;
				Intent intent=new Intent(MainActivity.this,ContentActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
				notify1.setLatestEventInfo(MainActivity.this, "֪ͨ", "�鿴��ϸ����", pendingIntent);
				notificationManager.notify(NOTIFYID_2,notify1);
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				notificationManager.cancel(NOTIFYID_1);
				notificationManager.cancelAll();
			}
		});
	}


}
