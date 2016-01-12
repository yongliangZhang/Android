package com.yongliang.android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this dds items to the action bar if it is present.
		MenuInflater inflater=new MenuInflater(this);
		inflater.inflate(R.menu.optionmenu, menu);
           return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		if(item.getGroupId()==R.id.setting){
			if(item.isChecked()){
				item.setChecked(false);
			}else{
				item.setChecked(true);
			}

		}
		if(item.getItemId()!=R.id.item2){
			Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
		}
		
		
		return true; 
	}
	

}
