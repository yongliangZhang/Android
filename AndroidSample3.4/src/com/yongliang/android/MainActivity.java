package com.yongliang.android;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;


public class MainActivity extends Activity {
         private AnimationDrawable anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final ImageView image=(ImageView) findViewById(R.id.imageView1);
		final Animation translaterright=AnimationUtils.loadAnimation(this, R.animator.motionright);
		final Animation translaterleft=AnimationUtils.loadAnimation(this, R.animator.motionleft);
		anim=(AnimationDrawable) image.getBackground();
		LinearLayout layout=(LinearLayout) findViewById(R.id.LinearLayout);
		Toast.makeText(this, "������Ļ��ʼ����", Toast.LENGTH_SHORT).show();
         layout.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO �Զ����ɵķ������
				anim.start();
				image.startAnimation(translaterright);
				return false;
			}
		});
         translaterright.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO �Զ����ɵķ������
				
			    }
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO �Զ����ɵķ������
				image.setBackgroundResource(R.animator.motionleft);
				image.startAnimation(translaterleft);
			    anim=(AnimationDrawable) image.getBackground();
			    anim.start();
			}
		});
		translaterleft.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO �Զ����ɵķ������
				image.setBackgroundResource(R.animator.motionright);
				image.startAnimation(translaterright);
				anim=(AnimationDrawable) image.getBackground();
				anim.start();
			}
		});
		
	}

}
