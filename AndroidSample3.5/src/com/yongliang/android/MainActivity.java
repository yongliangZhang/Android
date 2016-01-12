package com.yongliang.android;

import java.util.Iterator;

import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.widget.TextView;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;


public class MainActivity extends Activity {
	
	private String[] columns={
			Contacts._ID,
			Contacts.DISPLAY_NAME,
			};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView tv=(TextView) findViewById(R.id.result);
		tv.setText(getQueryData());
		
	}
	private String getQueryData(){
		StringBuilder sb=new StringBuilder();
		ContentResolver resolver=getContentResolver();
		Cursor cursor=resolver.query(Contacts.CONTENT_URI, columns, null, null, null);
		int idIndex=cursor.getColumnIndex(columns[0]);
		int displayNameIndex=cursor.getColumnIndex(columns[1]);
		for (cursor.moveToFirst();!cursor.isAfterLast() ; cursor.moveToNext()) {
			int id=cursor.getInt(idIndex);
			String displayName=cursor.getString(displayNameIndex);
			sb.append(id+":"+displayName+"\n");

		}
		cursor.close();
		return sb.toString();
	}


}
