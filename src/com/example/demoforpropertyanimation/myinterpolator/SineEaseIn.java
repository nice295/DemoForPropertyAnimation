package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class SineEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// SineEaseIn
		return (float)Math.sin((p - 1) * Math.PI / 2) + 1;

	}

}
