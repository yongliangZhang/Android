package com.yongliang.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText content;
	private Button button;
	private Handler handler;
	private String result;
	private TextView resultTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		content = (EditText) findViewById(R.id.content);
		resultTV = (TextView) findViewById(R.id.result);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if ("".equals(content.getText().toString())) {
					Toast.makeText(MainActivity.this, "请输入要发表的内容",
							Toast.LENGTH_SHORT).show();
					return;

				}
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO 自动生成的方法存根
						send();
						Message m = handler.obtainMessage();
						handler.sendMessage(m);
					}
				}).start();
			}
		});
		handler=new Handler(){
		  public  void handlerMessage(Message msg) {
			// TODO 自动生成的方法存根
              if(result!=null){
            	  resultTV.setText(result);
            	  content.setText("");
              }
              super.handleMessage(msg);
		}
		};
	}

	public void send() {
		String target = "";
		target = "http://192.168.1.66:8080/Blogs/index.jsp?content="
				+ base64(content.getText().toString().trim());
		URL url;
		try {
			url = new URL(target);
			HttpURLConnection urlConn = (HttpURLConnection) url
					.openConnection();
			InputStreamReader in = new InputStreamReader(
					urlConn.getInputStream()); // 获得读取的内容
			BufferedReader buffer = new BufferedReader(in); // 获取输入流对象
			String inputLine = null;
			while ((inputLine = buffer.readLine()) != null) {
				result += inputLine + "\n";
			}
			in.close();
			urlConn.disconnect();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	private String base64(String content) {
		// TODO 自动生成的方法存根
		try {
			content = Base64.encodeToString(content.getBytes("utf-8"),
					Base64.DEFAULT);
			content = URLEncoder.encode(content);
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return content;
	}
	

}
