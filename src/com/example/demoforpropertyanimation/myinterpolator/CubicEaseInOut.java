package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class CubicEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// CubicEaseInOut
		if(p < 0.5)
		{
			return 4 * p * p * p;
		}
		else
		{
			float f = ((2 * p) - 2);
			return 0.5f * f * f * f + 1;
		}
	}

}
