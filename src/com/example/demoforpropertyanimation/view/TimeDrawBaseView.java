package com.example.demoforpropertyanimation.view;

import com.example.demoforpropertyanimation.R;
import com.example.demoforpropertyanimation.util.ImageUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.view.View;

abstract public class TimeDrawBaseView extends View{

	Paint mPaint;
	
	ItemInfo[] items;
	
	public TimeDrawBaseView(Context context) {
		super(context);
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(Color.BLUE);
		
		mPaint.setTextAlign(Align.CENTER);
		
		items = new ItemInfo[3];
		int x = 0;
		int y = 0;
		
		for(int i = 0 ; i < 3 ; i++)
		{
			items[i] = new ItemInfo();
			items[i].x = x;
			items[i].y = y;
			items[i].mIcon = ImageUtils.toGoldBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
			
			x += 	items[i].mIcon.getWidth();
			y += 	items[i].mIcon.getHeight();
		}
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);
		
		drawElements(canvas);
		
		mPaint.setTextSize(getHeight() / 5);
		canvas.drawText("Time Animator", getWidth() / 2, getHeight() / 2 + mPaint.getTextSize() * 2 / 3 , mPaint);
	}

	protected void drawElements(Canvas canvas)
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			ItemInfo mInfo = items[i];
			canvas.drawBitmap(mInfo.mIcon, mInfo.x, mInfo.y, null);
			
			mInfo.y += mInfo.mIcon.getHeight() / 20 ;
			mInfo.x += mInfo.mIcon.getWidth() / 30 ;
			
			if(mInfo.y > getHeight())
			{
				mInfo.y = 0;
			}
			
			if(mInfo.x > getWidth())
			{
				mInfo.x = 0;
			}
		}
	}
	
	class ItemInfo
	{
		int x;
		int y;
		Bitmap mIcon;
	}
	
}
