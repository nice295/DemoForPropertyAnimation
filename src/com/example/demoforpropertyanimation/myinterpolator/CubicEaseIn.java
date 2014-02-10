package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class CubicEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// CubicEaseIn
		return p * p * p;

	}

}
