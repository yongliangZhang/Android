/*
 * 绘制2D图形
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
			// TODO 自动生成的构造函数存根
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO 自动生成的方法存根
			super.onDraw(canvas);
			canvas.drawColor(Color.WHITE);
			Paint paint=new Paint();
			paint.setAntiAlias(true); //使用抗锯齿功能
			paint.setStrokeWidth(3); //设置笔触宽度
			paint.setStyle(Style.STROKE); //设置填充样式为描边
			paint.setColor(Color.BLUE);
			canvas.drawCircle(50, 50, 30, paint); //绘制蓝色的圆形
			paint.setColor(Color.YELLOW);
			canvas.drawCircle(100, 50, 30, paint); //绘制黄色的圆形
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
