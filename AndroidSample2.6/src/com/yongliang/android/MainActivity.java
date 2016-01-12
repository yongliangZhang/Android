package com.yongliang.android;

import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.res.XmlResourceParser;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		XmlResourceParser xrp=getResources().getXml(R.xml.customers);
		StringBuilder ss=new StringBuilder();
        try {
			while(xrp.getEventType()!=XmlResourceParser.END_DOCUMENT){
				if(xrp.getEventType()==XmlResourceParser.START_TAG){
					String tagName=xrp.getName();
					if(tagName.equals("customer")){
						ss.append("姓名 ："+xrp.getAttributeValue(0)+"");
						ss.append("联系电话  :"+xrp.getAttributeValue(1)+"");
						ss.append("E-mail ："+xrp.getAttributeValue(2));
						ss.append("\n");
						
					}
				}
				xrp.next();
			}
			TextView text=(TextView) findViewById(R.id.textView1);
			text.setText(ss.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	
	


	}
}
