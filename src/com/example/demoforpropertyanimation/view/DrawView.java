package com.example.demoforpropertyanimation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {

	public int color;
	Paint mPaint;
	public DrawView(Context context, AttributeSet attrs) {
		super(context, attrs); 
		
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(Color.BLUE);
		
		mPaint.setTextAlign(Align.CENTER);
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);
		canvas.drawColor(color); 
		mPaint.setTextSize(getHeight() / 5);
		canvas.drawText("ObjectAnimator", getWidth() / 2, getHeight() / 2 + mPaint.getTextSize() * 2 / 3 , mPaint);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
		postInvalidate();
	}

	
	
	
}
