package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class ExponentialEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// ExponentialEaseInOut
		if(p == 0.0 || p == 1.0) return p;
		
		if(p < 0.5)
		{
			return 0.5f * (float)Math.pow(2, (20 * p) - 10);
		}
		else
		{
			return -0.5f * (float)Math.pow(2, (-20 * p) + 10) + 1;
		}

	}

}
