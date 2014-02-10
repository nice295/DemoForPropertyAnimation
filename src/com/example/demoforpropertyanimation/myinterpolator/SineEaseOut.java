package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class SineEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// SineEaseOut
		return (float)Math.sin(p  * Math.PI / 2);

	}

}
