package com.yongliang.android;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		FrameLayout fl=(FrameLayout) findViewById(R.id.framelayout);
		fl.addView(new MyView(this));
	}
	
	public class MyView extends View{

		public MyView(Context context) {
			super(context);
			// TODO �Զ����ɵĹ��캯�����
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO �Զ����ɵķ������
			super.onDraw(canvas);
			Paint paint =new Paint();
			paint.setAntiAlias(true);
			paint.setColor(0xFFA4C739);
		//���ƻ����˵�ͷ
			RectF rectf_head=new RectF(10, 10, 100, 100);
			rectf_head.offset(100, 20);
			canvas.drawArc(rectf_head, -10, -160, false, paint);
			//�����۾�
			paint.setColor(Color.WHITE);
			canvas.drawCircle(135, 53, 4, paint);
			canvas.drawCircle(175, 53, 4, paint);
			paint.setColor(0xFFA4C739);
			//��������
			paint.setStrokeWidth(2);
			canvas.drawLine(120, 15, 135, 35, paint);
			canvas.drawLine(190, 15, 175, 35, paint);
			//��������
			canvas.drawRect(110, 75,200,150,paint);
			RectF rectf_body=new RectF(110, 140, 200, 160);
			canvas.drawRoundRect(rectf_body, 10, 10, paint);
			//���Ƹ첲
			RectF rectf_arm=new RectF(85, 75, 105, 140);
			canvas.drawRoundRect(rectf_arm, 10, 10, paint);
			rectf_arm.offset(120, 0);
			canvas.drawRoundRect(rectf_arm, 10, 10, paint);
			//������
			RectF rectf_leg=new RectF(125, 150, 145, 200);
			canvas.drawRoundRect(rectf_leg, 10, 10, paint);
			rectf_leg.offset(40, 0);
			canvas.drawRoundRect(rectf_leg, 10, 10, paint);
			
		}
		
		
		
	}
	

}
