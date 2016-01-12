package com.yongliang.android;

import android.R.anim;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
 private final static String[] COUNTRIES=new String[]{"明日科技","明日科技有限公司","明日编程词典","明天更美好！","明日"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	 final AutoCompleteTextView textView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,COUNTRIES);
		textView.setAdapter(adapter);
		Button button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Toast.makeText(MainActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}

