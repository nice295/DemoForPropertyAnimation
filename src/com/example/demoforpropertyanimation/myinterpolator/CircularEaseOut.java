package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class CircularEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// CircularEaseOut
		return (float)Math.sqrt((2 - p) * p);


	}

}
