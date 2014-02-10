package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class CubicEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// CubicEaseOut
		float f = (p - 1);
		return f * f * f + 1;

	}

}
