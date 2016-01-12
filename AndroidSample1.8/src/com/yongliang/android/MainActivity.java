package com.yongliang.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button  button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(MainActivity.this,HeadActivity.class);
				startActivityForResult(intent, 0x11);
				
				
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==0x11&&resultCode==0x11){
			Bundle bundle=data.getExtras();
			int imageId=bundle.getInt("imageId");
			ImageView imageview=(ImageView) findViewById(R.id.imageView1);
			imageview.setImageResource(imageId);
		}
	}
	



}
