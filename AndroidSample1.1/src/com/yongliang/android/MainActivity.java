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
				// TODO �Զ����ɵķ������
				AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
				alert.setTitle("�˳���");
				alert.setIcon(R.drawable.advise);
				alert.setMessage("��ȷ��Ҫ�˳���������Ϸô��");
				alert.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO �Զ����ɵķ������
						finish();
						
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO �Զ����ɵķ������
						
					}
				});
				alert.show();
			}
		});
	}

}
