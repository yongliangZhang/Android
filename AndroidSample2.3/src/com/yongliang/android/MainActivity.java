/*
 * 图片预览窗格效果
 */

package com.yongliang.android;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import android.app.Activity;

public class MainActivity extends Activity {

	public int[] imageId = new int[] { 
			R.drawable.img01, R.drawable.img02,
			R.drawable.img03, R.drawable.img04, R.drawable.img05,
			R.drawable.img06, R.drawable.img07, R.drawable.img08,
			R.drawable.img09, R.drawable.img10,
			R.drawable.img11, R.drawable.img12 };
	private ImageSwitcher imageswitcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		GridView gridview = (GridView) findViewById(R.id.gridView1);
		imageswitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		imageswitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		imageswitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));
		imageswitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				// TODO 自动生成的方法存
				ImageView imageview = new ImageView(MainActivity.this);
				imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageview.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				return imageview;
			}
		});
		imageswitcher.setImageResource(imageId[6]);
		BaseAdapter adapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO 自动生成的方法存根
				ImageView imageview;
				if (convertView == null) {
					imageview = new ImageView(MainActivity.this);
					imageview.setAdjustViewBounds(true);
					imageview.setMaxWidth(150);
					imageview.setMaxHeight(113);
					imageview.setPadding(5, 5, 5, 5);

				} else {
					imageview = (ImageView) convertView;
				}
				imageview.setImageResource(imageId[position]);
				return imageview;
			}

			@Override
			public long getItemId(int position) {
				// TODO 自动生成t的方法存根
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
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				imageswitcher.setImageResource(imageId[position]);
			}
		});
	}
}
