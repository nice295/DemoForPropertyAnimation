package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuadraticEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) { 
		
		//QuadraticEaseInOut
		if(p < 0.5)
		{
			return 2 * p * p;
		}
		else
		{
			return (-2 * p * p) + (4 * p) - 1;
		}
	}

}
