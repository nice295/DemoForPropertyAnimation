package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class CircularEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// CircularEaseInOut
		if(p < 0.5)
		{
			return 0.5f * (1 - (float)Math.sqrt(1 - 4 * (p * p)));
		}
		else
		{
			return 0.5f * ((float)Math.sqrt(-((2 * p) - 3) * ((2 * p) - 1)) + 1);
		}

	}

}
