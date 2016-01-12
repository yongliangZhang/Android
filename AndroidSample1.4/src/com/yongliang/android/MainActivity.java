/*
 * 时间拾取器
 * 2013-12-31
 */
package com.yongliang.android;

import java.util.Calendar;

import android.os.Bundle;
import android.provider.CalendarContract.Calendars;
import android.app.Activity;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;

	private void show(int year, int month, int day, int hourOfday, int minute) {
		String str = year + "年" + (month + 1) + "月" + day + "天" + hour + ":"
				+ minute;
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
		TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker1);
		timePicker.setIs24HourView(true);
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		datePicker.init(year, month, day, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year, int month,
					int day) {
				// TODO 自动生成的方法存根
				MainActivity.this.year = year;
				MainActivity.this.month = month;
				MainActivity.this.day = day;
				show(year, month, day, hour, minute);

			}

		}

		);
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO 自动生成的方法存根
				MainActivity.this.hour = hourOfDay;
				MainActivity.this.minute = minute;
				show(year, month, day, hourOfDay, minute);

			}
		});

	}

}
