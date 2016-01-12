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
		private Bitmap bitmap;    //Դͼ�񣬱���ͼƬ
		private ShapeDrawable drawable;
		private final int RADIUS=57; //�Ŵ󾵰뾶
		private final int FACTOR=2;  //�Ŵ󾵱���
		private Matrix matrix=new Matrix();
		private Bitmap bitmap_magnifier;  //�Ŵ�λͼ
		private int m_left=0;  //�Ŵ���߾�
		private int m_top=0; //�Ŵ󾵵Ķ��߾�
		

		public MyView(Context context) {
			super(context);
			// TODO �Զ����ɵĹ��캯�����
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
			// TODO �Զ����ɵķ������
			super.onDraw(canvas);
			canvas.drawBitmap(bitmap, 0, 0,null);
			canvas.drawBitmap(bitmap_magnifier, m_left, m_top,null);
			drawable.draw(canvas);
			
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO �Զ����ɵķ������
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
