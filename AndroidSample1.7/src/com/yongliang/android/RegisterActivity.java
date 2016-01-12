package com.yongliang.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		final Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		TextView  user=(TextView) findViewById(R.id.user);
		user.setText("用户名："+bundle.getString("user"));
		TextView password=(TextView) findViewById(R.id.password);
		password.setText("密码："+bundle.getString("password"));
		TextView email=(TextView) findViewById(R.id.email);
		email.setText("邮箱："+bundle.getString("Email"));
		Button button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				setResult(0x717,intent);
				finish();
			}
		});
	}

}
