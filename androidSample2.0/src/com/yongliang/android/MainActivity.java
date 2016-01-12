package com.yongliang.android;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	public int[] imageId = new int[] { R.drawable.img01, R.drawable.img02,
			R.drawable.img03, R.drawable.img04, R.drawable.img05,
			R.drawable.img06, R.drawable.img07, R.drawable.img08,
			R.drawable.img09, R.drawable.img10, R.drawable.img11,
			R.drawable.img12 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		GridView gridview = (GridView) findViewById(R.id.gridView1);
		BaseAdapter baseAdapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO 自动生成的方法存根
				ImageView imageview;
				if (convertView == null) {
					imageview = new ImageView(MainActivity.this);
					imageview.setAdjustViewBounds(true);
					imageview.setMaxWidth(180);
					imageview.setMaxHeight(135);
					imageview.setPadding(5, 5, 5, 5);
				} else {
					imageview = (ImageView) convertView;
				}
				imageview.setImageResource(imageId[position]);

				return imageview;
			}

			@Override
			public long getItemId(int position) {
				// TODO 自动生成的方法存根
				return position;
			}

			@Override
			public Object getItem(int position) {
				// TODO 自动生成的方法存根
				return position;
			}

			@Override
			public int getCount() {
				// TODO 自动生成的方法存根
				return imageId.length;
			}
		};
		gridview.setAdapter(baseAdapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MainActivity.this, BigActivity.class);
				Bundle bundle = new Bundle();
				bundle.putInt("imageId", imageId[position]);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});

	}
}
