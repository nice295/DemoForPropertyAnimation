package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class CircularEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// CircularEaseIn
		return 1 -(float) Math.sqrt(1 - (p * p));

	}

}
