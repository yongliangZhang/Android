package com.yongliang.android;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	     Intent intent=getIntent();
	     Bundle bundle=intent.getExtras();
	    String nickname=bundle.getString("nickname");
	    TextView textview=(TextView) findViewById(R.id.nickname);
	    textview.setText("当前登陆："+nickname);
	    Button button=(Button) findViewById(R.id.m_exit);
	    button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	    
	    
	}



}
