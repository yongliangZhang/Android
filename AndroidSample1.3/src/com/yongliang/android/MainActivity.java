/*
 * 消息提示语对话框
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
				// TODO 自动生成的方法存根
				Notification notify=new Notification();
				notify.icon=R.drawable.advise;
				notify.tickerText="显示第一个通知";
				notify.when=System.currentTimeMillis();
				notify.defaults=Notification.DEFAULT_ALL;
				notify.setLatestEventInfo(MainActivity.this, "无题", "每天进步一点点", null);
				notificationManager.notify(NOTIFYID_1,notify);
				Notification notify1=new Notification(R.drawable.advise2,"显示第二个通知",System.currentTimeMillis());
				notify1.flags=Notification.FLAG_AUTO_CANCEL;
				Intent intent=new Intent(MainActivity.this,ContentActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
				notify1.setLatestEventInfo(MainActivity.this, "通知", "查看详细内容", pendingIntent);
				notificationManager.notify(NOTIFYID_2,notify1);
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				notificationManager.cancel(NOTIFYID_1);
				notificationManager.cancelAll();
			}
		});
	}


}
