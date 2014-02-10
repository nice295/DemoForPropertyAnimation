package com.example.demoforpropertyanimation.view;
 
import com.nineoldandroids.animation.TimeAnimator;
import com.nineoldandroids.animation.TimeAnimator.TimeListener;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class TimeDrawViewV4 extends TimeDrawBaseView implements TimeListener{

	public TimeDrawViewV4(Context context) {
		super(context); 
	}

	
	@Override
	public void onTimeUpdate(TimeAnimator arg0, long totalTime,
			long deltaTime) {
		
		invalidate();
		
	} 
}
