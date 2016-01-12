package com.yongliang.android;

import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.widget.TextView;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;

public class MainActivity extends Activity {

	private String[] columns = { Contacts._ID, Contacts.DISPLAY_NAME,
			Phone.NUMBER, Phone.CONTACT_ID };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView tv = (TextView) findViewById(R.id.result);
		tv.setText(getQueryData());
	}

	private String getQueryData() {
		StringBuilder sb = new StringBuilder();
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(Contacts.CONTENT_URI, null, null, null,null);
		while (cursor.moveToNext()) {
			int idIndex = cursor.getColumnIndex(columns[0]);
			int displayNameIndex = cursor.getColumnIndex(columns[1]);
			int id = cursor.getInt(idIndex);
			String displayName = cursor.getString(displayNameIndex);
			Cursor phone = resolver.query(Phone.CONTENT_URI, null,columns[3] + "=" + id, null, null);
			while (phone.moveToNext()) {
				int phoneNumberIndex = phone.getColumnIndex(columns[2]); // 获得电话索引
				String phoneNumber = phone.getString(phoneNumberIndex);
				sb.append(displayName + ":" + phoneNumber + "\n");				
			}
		
		}
		cursor.close();
		return sb.toString();

	}
}
