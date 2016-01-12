package com.yongliang.andriod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		LinearLayout linearLayout=new LinearLayout(this);
		linearLayout.setPadding(20, 20, 20, 20);
		TextView tv=new TextView(this);
		tv.setTextSize(24);
		tv.setText(R.string.about);
		linearLayout.addView(tv);
		setContentView(linearLayout);
		
	}

}
