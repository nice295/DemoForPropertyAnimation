package com.example.demoforpropertyanimation.myinterpolator;

import android.view.animation.Interpolator;

public class BounceEaseIn implements Interpolator {

	@Override
	public float getInterpolation(float p) {

		// BounceEaseIn
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
	    
//		if(p < 4/11.0)
//		{
//			return (121 * p * p)/16.0;
//		}
//		else if(p < 8/11.0)
//		{
//			return 121*0.04*p*p - 132 *0.04 *p +2.28;
//		}
//		else if(p < 9/10.0)
//		{
//			return (4356/361.0 * p * p) - (35442/1805.0 * p) + 16061/1805.0;
//		}
//		else
//		{
//			return (54/5.0 * p * p) - (513/25.0 * p) + 268/25.0;
//		}
	}

}
