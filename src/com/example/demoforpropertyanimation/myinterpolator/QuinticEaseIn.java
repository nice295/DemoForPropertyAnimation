package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuinticEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// QuinticEaseIn
		return p * p * p * p * p;
	}

}
