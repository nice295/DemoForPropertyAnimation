package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class ExponentialEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// ExponentialEaseOut
		return (p == 1.0) ? p : 1 - (float)Math.pow(2, -10 * p);

	}

}
