package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class BackEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// BackEaseOut
		float f = (1 - p);
		return 1 - (float)(f * f * f - f * Math.sin(f * Math.PI));



	}

}
