package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuinticEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// QuinticEaseOut
		float f = (p - 1);
		return f * f * f * f * f + 1;

	}

}
