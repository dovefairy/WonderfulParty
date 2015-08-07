package com.example.wonderfulparty.animal;

import java.util.ArrayList;
import java.util.List;

import com.example.wonderfulparty.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class LayoutAnimal extends Activity {
	private ListView lv;
	private List<String> list;
	private Context mContext;
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout_animal);
		mContext = this;
		//获得UI组件
		lv = (ListView) this.findViewById(R.id.Layout_lv);
		btn = (Button) this.findViewById(R.id.btn_next_animator);
		//初始化数据
		initData();
		//创建布局动画
		initDrawable();
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LayoutAnimal.this,MyObjectAnimator.class);
				startActivity(intent);
			}
		});
	}
	
	//设置布局动画
	private void initDrawable() {
		LayoutAnimationController lac = new LayoutAnimationController(new AnimationUtils().loadAnimation(mContext, R.anim.layout_anim));
		lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
		lv.setLayoutAnimation(lac);
		lv.startLayoutAnimation();
	}

	//设置初始化数据
	private void initData() {
		list = new ArrayList<String>();
		for(int i=0;i<20;i++){
			list.add("数据条数"+i);
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_list_item_1,list);
		lv.setAdapter(adapter);
	}

}
