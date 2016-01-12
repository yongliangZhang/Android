package com.yongliang.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		Button button = (Button) findViewById(R.id.login);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				String number = ((EditText) findViewById(R.id.editText1))
						.getText().toString();
				String pwd = ((EditText) findViewById(R.id.editText2))
						.getText().toString();
				boolean flag = false;
				String nickname = "";
				for (int i = 0; i < Data.USER.length; i++) {
					if (number.equals(Data.USER[i][0])) {
						if (pwd.equals(Data.USER[i][1])) {
							nickname = Data.USER[i][2];
							flag = true;
							break;
						}
					}

				}
				if(flag){
					Intent intent=new Intent(LoginActivity.this,MainActivity.class);
					Bundle bundle=new Bundle();
					bundle.putString("nickname", nickname);
					intent.putExtras(bundle);
					startActivity(intent);
					
				}else{
					Toast.makeText(LoginActivity.this, "您输入的账户或密码错误！", Toast.LENGTH_SHORT).show();
					
				}

			}
		});
		Button exit=(Button) findViewById(R.id.exit);
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	}

}
