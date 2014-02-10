package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class ExponentialEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// ExponentialEaseIn
		return (p == 0.0) ? p : (float)Math.pow(2, 10 * (p - 1));


	}

}
