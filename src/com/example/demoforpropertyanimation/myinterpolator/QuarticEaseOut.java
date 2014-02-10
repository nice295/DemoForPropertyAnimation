package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuarticEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// QuarticEaseOut
		float f = (p - 1);
		return f * f * f * (1 - p) + 1;
	}

}
