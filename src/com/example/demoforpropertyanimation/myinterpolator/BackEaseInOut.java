package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class BackEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// BackEaseInOut
		if(p < 0.5)
		{
			float f = 2 * p;
			return (float)(0.5 * (f * f * f - f * Math.sin(f * Math.PI)));
		}
		else
		{
			float f = (1 - (2*p - 1));
			return (float)(0.5 * (1 - (f * f * f - f * Math.sin(f * Math.PI))) + 0.5);
		}


	}

}
