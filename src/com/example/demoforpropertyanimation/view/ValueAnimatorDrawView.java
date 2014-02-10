package com.example.demoforpropertyanimation.view;
  

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

public class ValueAnimatorDrawView extends ValueAnimatorDrawBaseView implements AnimatorUpdateListener{
	ValueAnimator animator;
	Interpolator mInterpolator;
	public ValueAnimatorDrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onAnimationUpdate(ValueAnimator animation) {
		
		Integer mInteger = (Integer)animation.getAnimatedValue();

		addAPoint(mInteger.intValue());
		
		invalidate();
	}
	 
	Interpolator getmInterpolator() {
		return mInterpolator;
	}

	public void setmInterpolator(Interpolator mInterpolator) {
		this.mInterpolator = mInterpolator;
	}

	public void startAnimation()
	{
		if(animator != null)
		{
			animator.cancel();
		}
		
		clear();
		
		animator = ValueAnimator.ofInt(0,getHeight() / 4);
		if(mInterpolator != null)
		{
			animator.setInterpolator(mInterpolator);
		}
		animator.setDuration(animTime);
		animator.addUpdateListener(this);
		
		animator.start();
	}
 
}
