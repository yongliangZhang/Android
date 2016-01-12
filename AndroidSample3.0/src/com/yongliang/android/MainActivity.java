/*
 * ����2Dͼ��
 * 201-02-04
 */
package com.yongliang.android;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
public class MainActivity extends Activity {
    public class MyView extends View{

		public MyView(Context context) {
			super(context);
			// TODO �Զ����ɵĹ��캯�����
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO �Զ����ɵķ������
			super.onDraw(canvas);
			canvas.drawColor(Color.WHITE);
			Paint paint=new Paint();
			paint.setAntiAlias(true); //ʹ�ÿ���ݹ���
			paint.setStrokeWidth(3); //���ñʴ����
			paint.setStyle(Style.STROKE); //���������ʽΪ���
			paint.setColor(Color.BLUE);
			canvas.drawCircle(50, 50, 30, paint); //������ɫ��Բ��
			paint.setColor(Color.YELLOW);
			canvas.drawCircle(100, 50, 30, paint); //���ƻ�ɫ��Բ��
			paint.setColor(Color.BLACK);
			canvas.drawCircle(150, 50, 30, paint);
			paint.setColor(Color.GREEN);
			canvas.drawCircle(75, 90, 30, paint);
			paint.setColor(Color.RED);
			canvas.drawCircle(125, 90, 30, paint);
			
			
			
		}
    	
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		FrameLayout  fl=(FrameLayout) findViewById(R.id.framelayout);
		fl.addView(new MyView(this));
	}

}
