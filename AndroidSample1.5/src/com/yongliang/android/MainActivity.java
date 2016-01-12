package com.yongliang.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listView=(ListView) findViewById(R.id.listView1);
        int[] imageId =new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08
        	};
        String[] title=new String[]{"保密设置","安全","系统设置","上网","我的文档","Gps导航","我的音乐","E-mail"};
	    List<Map<String,Object>> listiems=new ArrayList<Map<String,Object>>();
	    for (int i = 0; i < imageId.length; i++) {
			Map<String,Object>  map=new HashMap<String,Object>();
			map.put("image", imageId[i]);
			map.put("title", title[i]);
			listiems.add(map);
			
		}
	    SimpleAdapter adapter=new SimpleAdapter(this, listiems, R.layout.items, new String[]{"title","image"}, new int[]{R.id.title,R.id.image});
	    listView.setAdapter(adapter);
	
	}

}
