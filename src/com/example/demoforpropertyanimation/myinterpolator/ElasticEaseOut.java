package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class ElasticEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// ElasticEaseOut
		return (float)(Math.sin(-13 * Math.PI / 2 * (p + 1)) * Math.pow(2, -10 * p) + 1);


	}

}
