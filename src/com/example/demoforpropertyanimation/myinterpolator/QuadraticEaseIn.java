package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class QuadraticEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float input) { 
		
		//QuadraticEaseIn
		return input * input;
	}

}
