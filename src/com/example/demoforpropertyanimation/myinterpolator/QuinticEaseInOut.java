package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuinticEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// QuinticEaseInOut
		if(p < 0.5)
		{
			return 16 * p * p * p * p * p;
		}
		else
		{
			float f = ((2 * p) - 2);
			return  0.5f * f * f * f * f * f + 1;
		}

	}

}
