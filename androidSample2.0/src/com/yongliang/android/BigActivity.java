package com.yongliang.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class BigActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.big);
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		int imageid=bundle.getInt("imageId");
		ImageView image=(ImageView) findViewById(R.id.imageView1);
		image.setImageResource(imageid);
		Button  button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
			
		
	}

}
