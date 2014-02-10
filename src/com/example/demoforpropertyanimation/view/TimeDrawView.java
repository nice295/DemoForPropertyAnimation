package com.example.demoforpropertyanimation.view;

import android.animation.TimeAnimator;
import android.animation.TimeAnimator.TimeListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class TimeDrawView extends TimeDrawBaseView implements TimeListener{

	public TimeDrawView(Context context) {
		super(context); 
	}

	@Override
	public void onTimeUpdate(TimeAnimator animation, long totalTime,
			long deltaTime) { 
		
			invalidate();
		
	}
	
	

}
