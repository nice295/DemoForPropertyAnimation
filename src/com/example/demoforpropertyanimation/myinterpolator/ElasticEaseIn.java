package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class ElasticEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// ElasticEaseIn
		return (float)(Math.sin(13 * Math.PI / 2 * p) * Math.pow(2, 10 * (p - 1)));


	}

}
