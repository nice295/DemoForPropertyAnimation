package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class BounceEaseOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// BounceEaseOut
		 if (p < 4/11.0)
		    {
		        return (7.5625f*p*p);
		    } else if (p < 8/11.0)
		    {
		        return (float)(121*0.03f*(p-(1.5/2.75))*(p-(1.5/2.75)) + 0.84f);
		    } else if (p < 9/10.0)
		    {
		        return (float)(7.5625f*(p-(2.25/2.75))*(p-(2.25/2.75)) + 0.9375f);
		    } else
		    {
		        return (float)(7.5625f*(p-(2.625/2.75))*(p-(2.625/2.75)) + 0.984375f);
		    }
		     
	}
 

}
