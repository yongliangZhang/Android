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
 private final static String[] COUNTRIES=new String[]{"���տƼ�","���տƼ����޹�˾","���ձ�̴ʵ�","��������ã�","����"};
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
				// TODO �Զ����ɵķ������
				Toast.makeText(MainActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}

