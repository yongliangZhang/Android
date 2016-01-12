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
				// TODO �Զ����ɵķ������
				final Bitmap bitmap=getPicture("http://192.168.1.66:8081/test/images/android.png");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				iv.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO �Զ����ɵķ������
						iv.setImageBitmap(bitmap);
					}
				});
			}
		}).start();
		

	}

	public Bitmap getPicture(String path){
	   Bitmap bm=null;
	   try {
		URL url=new URL(path); //����URL��ַ
		URLConnection conn=url.openConnection();//��ȡURl�����Ӧ������
		conn.connect();
		InputStream is=conn.getInputStream();//��ȡ����������
		bm=BitmapFactory.decodeStream(is);  //�������������󴴽�Bitmap����
		
		
	} catch (MalformedURLException e1) {
		// TODO �Զ����ɵ� catch ��
		e1.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}  
	return bm;
   }
}
