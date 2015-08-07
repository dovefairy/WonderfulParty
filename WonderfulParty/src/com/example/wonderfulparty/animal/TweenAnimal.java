package com.example.wonderfulparty.animal;

import com.example.wonderfulparty.MainActivity;
import com.example.wonderfulparty.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TweenAnimal extends Activity{
	private ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_anim);
		//获取UI组件
		img = (ImageView) this.findViewById(R.id.img_my_anim);
		//设制补间动画
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.my_anim_anim);
		img.startAnimation(anim);
		anim.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent(TweenAnimal.this,FrameActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.activity_anim_start,R.anim.activity_anim_end);
			}
		});
	}

	
	
}
