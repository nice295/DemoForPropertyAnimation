package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuarticEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// QuarticEaseIn
		return p * p * p * p;
	}

}
