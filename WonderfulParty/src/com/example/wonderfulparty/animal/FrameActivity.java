package com.example.wonderfulparty.animal;

import com.example.wonderfulparty.R;
import com.example.wonderfulparty.R.layout;
import com.example.wonderfulparty.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;

public class FrameActivity extends Activity {
	private ImageView img;
	private AnimationDrawable anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame);
		//获取UI组件
		img = (ImageView) this.findViewById(R.id.img_frame_anim);
		img.setImageResource(R.drawable.my_frame_anim);
		anim = (AnimationDrawable) img.getDrawable();
		anim.start();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				anim.stop();
				Intent intent = new Intent(FrameActivity.this,LayoutAnimal.class);
				startActivity(intent);
			}
		} , 6000);
	}

}
