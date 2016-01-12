package com.yongliang.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	final  public int CODE=0X717;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				String user=((EditText)findViewById(R.id.editText1)).getText().toString();
				String password=((EditText)findViewById(R.id.editText2)).getText().toString();
				String repassword=((EditText)findViewById(R.id.editText3)).getText().toString();
				String email=((EditText)findViewById(R.id.editText4)).getText().toString();
				if(!"".equals(user)&&!"".equals(password)&&!"".equals(email)){
					if(!password.equals(repassword)){
						Toast.makeText(MainActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
						((EditText)findViewById(R.id.editText2)).setText("");
						((EditText)findViewById(R.id.editText3)).setText("");
						((EditText)findViewById(R.id.editText2)).requestFocus();
						
					}else{
						Intent  intent=new Intent(MainActivity.this, RegisterActivity.class);
						Bundle bundle=new Bundle();
						bundle.putCharSequence("user", user);
						bundle.putCharSequence("password", password);
						bundle.putCharSequence("Email", email);
						intent.putExtras(bundle);
						startActivityForResult(intent, CODE);
						}
				}else{
					Toast.makeText(MainActivity.this, "请将注册信息填写完整！", Toast.LENGTH_SHORT).show();
				}
				
				
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==CODE&&resultCode==CODE){
			((EditText)findViewById(R.id.editText2)).setText("");
			((EditText)findViewById(R.id.editText3)).setText("");
			
		}
	}
	

}
