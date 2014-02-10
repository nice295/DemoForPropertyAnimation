package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuarticEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// QuarticEaseInOut
		if(p < 0.5)
		{
			return 8 * p * p * p * p;
		}
		else
		{
			float f = (p - 1);
			return -8 * f * f * f * f + 1;
		}
	}

}
