package com.yongliang.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ImageButton button1 =(ImageButton) findViewById(R.id.imageButton1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
				alert.setTitle("退出？");
				alert.setIcon(R.drawable.advise);
				alert.setMessage("您确定要退出泡泡龙游戏么？");
				alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 自动生成的方法存根
						finish();
						
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 自动生成的方法存根
						
					}
				});
				alert.show();
			}
		});
	}

}
