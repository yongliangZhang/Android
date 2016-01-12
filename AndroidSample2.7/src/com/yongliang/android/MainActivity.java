package com.yongliang.android;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tv=(TextView) findViewById(R.id.textView1);
		registerForContextMenu(tv);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO 自动生成的方法存根
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater=new MenuInflater(this);
		inflater.inflate(R.menu.contextmenu, menu);
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.setHeaderTitle("请选择文字颜色");

	}


	public boolean onContextItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		switch(item.getItemId()){
		case R.id.color1:
			tv.setTextColor(Color.rgb(255, 0, 0));
			break;
		case R.id.color2:
			tv.setTextColor(Color.rgb(0, 255, 0));
			break;
		case R.id.color3:
			tv.setTextColor(Color.rgb(0, 0, 255));
			break;
		case R.id.color4:
			tv.setTextColor(Color.rgb(255, 180, 0));
			break;
		default:
			tv.setTextColor(Color.rgb(255, 255, 255));
		
		}
		return true;
	}



}
