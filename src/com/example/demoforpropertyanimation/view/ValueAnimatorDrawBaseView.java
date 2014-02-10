package com.example.demoforpropertyanimation.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public abstract class ValueAnimatorDrawBaseView extends View {
  
	ArrayList<Point> mArrayList;
	
	final int animTime = 1000;
	
//	int refreshTime = animTime / 10;
	
	Paint mPaint;
	Paint mPaintLine;
	Paint mPaintBorader;
	
	public ValueAnimatorDrawBaseView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mPaint = new Paint();
		mPaint.setColor(Color.CYAN);
		
		mPaintLine = new Paint();
		mPaintLine.setColor(Color.RED);
		
		mPaintBorader = new Paint();
		mPaintBorader.setColor(Color.YELLOW);
		
		
		mArrayList = new ArrayList<Point>();
	}

	@Override
	protected void dispatchDraw(Canvas canvas) { 
		super.dispatchDraw(canvas);

		canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mPaintBorader);
		
		canvas.drawLine(0, getHeight() / 4, getWidth(), getHeight() / 4, mPaintBorader);
		
		canvas.drawLine(0, getHeight() * 3 / 4, getWidth(), getHeight() * 3 / 4, mPaintBorader);
		
		canvas.drawLine(0, 0, 0, getHeight(), mPaintBorader);
		
		final int count = mArrayList.size();
		for(int i = 0 ; i < count ; i++)
		{
			Point mPoint = mArrayList.get(i);
			canvas.drawCircle(mPoint.x, getHeight() / 2 - mPoint.y, 2, mPaint);
		}
		
		if(count > 1)
		{
			for(int i = 0 ; i < count - 1 ; i++)
			{
				Point mPoint = mArrayList.get(i);
				Point mPoint2 = mArrayList.get(i+1);
				canvas.drawLine(mPoint.x,  getHeight() / 2 - mPoint.y, mPoint2.x,   getHeight() / 2   -mPoint2.y, mPaintLine);
			}
		}
		
		
		
	}
	
	class Point
	{
		int x;
		int y;
	}
	
	abstract public void startAnimation();
	 
	protected void addAPoint(int Y)
	{
		  int count = mArrayList.size();
		  Point mPoint = new Point();
		  mPoint.y = Y;
		  mPoint.x = count * 5;	  
		  if(mPoint.x - 5 < 0)
		  {
			  mPoint.x += 5;
		  }
		  else if(mPoint.x + 5 > getWidth())
		  {
			  mPoint.x -= 5;
		  }
		  mArrayList.add(mPoint);
		  
		  Log.e("VIEW", "point : " + mArrayList.size());
	}
	
	protected void clear()
	{
		mArrayList.clear();
	}
}
