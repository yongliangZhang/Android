package com.yongliang.android;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		FrameLayout fl=(FrameLayout) findViewById(R.id.framelayout);
		fl.addView(new MyView(this));
	}
	public class MyView extends View{
		private Bitmap bitmap;    //源图像，背景图片
		private ShapeDrawable drawable;
		private final int RADIUS=57; //放大镜半径
		private final int FACTOR=2;  //放大镜倍数
		private Matrix matrix=new Matrix();
		private Bitmap bitmap_magnifier;  //放大镜位图
		private int m_left=0;  //放大镜左边距
		private int m_top=0; //放大镜的顶边距
		

		public MyView(Context context) {
			super(context);
			// TODO 自动生成的构造函数存根
			Bitmap bitmap_source=BitmapFactory.decodeResource(getResources(), R.drawable.source);
			bitmap=bitmap_source;
		    BitmapShader shader=new BitmapShader(Bitmap.createScaledBitmap(bitmap_source, bitmap_source.getWidth()*FACTOR, bitmap_source.getHeight()*FACTOR, true), TileMode.CLAMP, TileMode.CLAMP
		    );
		    drawable= new ShapeDrawable(new OvalShape());
		    drawable.getPaint().setShader(shader);
		    drawable.setBounds(0,0,RADIUS*2,RADIUS*2);
		    bitmap_magnifier=BitmapFactory.decodeResource(getResources(), R.drawable.magnifier);
		    m_left=RADIUS-bitmap_magnifier.getWidth()/2;
		    m_top=RADIUS-bitmap_magnifier.getHeight()/2;
		    
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO 自动生成的方法存根
			super.onDraw(canvas);
			canvas.drawBitmap(bitmap, 0, 0,null);
			canvas.drawBitmap(bitmap_magnifier, m_left, m_top,null);
			drawable.draw(canvas);
			
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO 自动生成的方法存根
			final int x=(int) event.getX();
			final int y=(int) event.getY();
			matrix.setTranslate(RADIUS-x*FACTOR, RADIUS-y*FACTOR);
			drawable.getPaint().getShader().setLocalMatrix(matrix);
			drawable.setBounds(x-RADIUS,y-RADIUS,x+RADIUS,y+RADIUS);
			m_left=x-bitmap_magnifier.getWidth()/2;
			m_top=y-bitmap_magnifier.getHeight()/2;
			invalidate();
			return true;
		}
		
		
	}

}
