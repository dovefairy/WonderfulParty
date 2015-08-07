package com.example.wonderfulparty.animal;

import com.example.wonderfulparty.R;

import android.os.Bundle;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.widget.ImageView;

public class MyObjectAnimator extends Activity {
	private ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.object_animator);
		//获取UI组件
		img = (ImageView) this.findViewById(R.id.img_animator);
		/*
		 * 设置属性动画ObjectAnimator
		 */
		//方法一：
//		ObjectAnimator.ofFloat(img, "translationX",0, 100f).setDuration(3000).start();
//		ObjectAnimator.ofFloat(img, "translationY",0, 100f).setDuration(3000).start();
//		ObjectAnimator.ofFloat(img, "rotation",0, 360f).setDuration(3000).start();
		//方法二：
//		PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX",0, 100f);
//		PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY",0, 100f);
//		PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation",0, 360f);
//		ObjectAnimator.ofPropertyValuesHolder(img, p1,p2,p3).setDuration(3000).start();
		//方法三(set)：
		AnimatorSet set = new AnimatorSet();
		ObjectAnimator oa1 = ObjectAnimator.ofFloat(img, "translationX",0, 100f);
		ObjectAnimator oa2 = ObjectAnimator.ofFloat(img, "translationY",0, 100f);
		ObjectAnimator oa3 = ObjectAnimator.ofFloat(img, "rotation",0, 360f);
		set.play(oa3).with(oa2);
		set.play(oa1).after(oa3);
		//set.playSequentially(oa1,oa2,oa3);
		set.setDuration(2000);
		set.start();
	}

}
