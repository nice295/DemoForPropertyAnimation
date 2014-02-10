package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class BackEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// BackEaseIn
		return p * p * p - (float)(p * Math.sin(p * Math.PI));


	}

}
