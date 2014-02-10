package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class BounceEaseInOut implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// BounceEaseInOut
		if(p < 0.5)
		{
			return (float)(0.5 * BounceEaseIn(p*2));
		}
		else
		{
			return (float)(0.5 * BounceEaseOut(p * 2 - 1) + 0.5);
		}
	}
 
	float BounceEaseIn(float p)
	{
		return 1 - BounceEaseOut(1 - p);
	}

	float BounceEaseOut(float p)
	{
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
