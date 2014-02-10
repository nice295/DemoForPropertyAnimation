package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class SineEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// SineEaseInOut
		return (float)(0.5 * (1 - Math.cos(p * Math.PI /2 )));

	}

}
