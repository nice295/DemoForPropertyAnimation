package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class ElasticEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// ElasticEaseInOut
		if(p < 0.5)
		{
			return (float)(0.5 * Math.sin(13 * Math.PI / 2 * (2 * p)) * Math.pow(2, 10 * ((2 * p) - 1)));
		}
		else
		{
			return (float)(0.5 * (Math.sin(-13 * Math.PI / 2 * ((2 * p - 1) + 1)) * Math.pow(2, -10 * (2 * p - 1)) + 2));
		}

	}

}
