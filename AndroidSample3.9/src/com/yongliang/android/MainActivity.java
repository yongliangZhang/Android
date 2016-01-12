package com.yongliang.android;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		iv=(ImageView) findViewById(R.id.imageView1);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				final Bitmap bitmap=getPicture("http://192.168.1.66:8081/test/images/android.png");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				iv.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO 自动生成的方法存根
						iv.setImageBitmap(bitmap);
					}
				});
			}
		}).start();
		

	}

	public Bitmap getPicture(String path){
	   Bitmap bm=null;
	   try {
		URL url=new URL(path); //创建URL地址
		URLConnection conn=url.openConnection();//获取URl对象对应的连接
		conn.connect();
		InputStream is=conn.getInputStream();//获取输入流对象
		bm=BitmapFactory.decodeStream(is);  //根据输入流对象创建Bitmap对象
		
		
	} catch (MalformedURLException e1) {
		// TODO 自动生成的 catch 块
		e1.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}  
	return bm;
   }
}
