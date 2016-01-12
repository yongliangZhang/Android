package com.yongliang.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class HeadActivity extends Activity {
public 	int[] imageId=new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,
	R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,
	R.drawable.img09};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.head);
       GridView gridview =(GridView) findViewById(R.id.gridView1);
       BaseAdapter adapter=new BaseAdapter() {
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO 自动生成的方法存根
			ImageView imageview;
			if(convertView==null){
				imageview=new ImageView(HeadActivity.this);
				imageview.setAdjustViewBounds(true);
				imageview.setMaxWidth(158);
				imageview.setMaxHeight(150);
				imageview.setPadding(5, 5, 5, 5);
				
			}else{
				imageview=(ImageView) convertView;
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
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int poisition,
					long id) {
				// TODO 自动生成的方法存根
				Intent intent=getIntent();
				Bundle bundle=new Bundle();
				bundle.putInt("imageId", imageId[poisition]);
		        intent.putExtras(bundle);
		        setResult(0x11,intent);
		        finish();
				
			}
		});
	}



}
