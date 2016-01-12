/*
 * 使用Intent打电话
 */

package com.yongliang.android;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		EditText editText=(EditText) findViewById(R.id.editText1);
		final  String number=editText.getText().toString();
		 Button button=(Button) findViewById(R.id.button1);
		 button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:"+number));
				startActivity(intent);
				
			}
		});
				
	}



}
