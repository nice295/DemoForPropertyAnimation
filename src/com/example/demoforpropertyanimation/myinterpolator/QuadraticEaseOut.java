package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuadraticEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float input) { 
		
		//QuadraticEaseOut
		return -(input * (input - 2));
	}

}
