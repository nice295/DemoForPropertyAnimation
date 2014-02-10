package com.example.demoforpropertyanimation.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class ImageUtils  {

	public static Bitmap toGoldBitmap(Bitmap bm) {
		if (bm == null)
			return null;

		int red = 0xff;
		int green = 0xd7;
		int blue = 0x0;
		return translateBitmap(bm, red, green, blue);

	}

	private static Bitmap translateBitmap(Bitmap bm, int r, int g, int b) {

		if (bm == null)
			return null;

		int w = bm.getWidth();
		int h = bm.getHeight();
		int size = w * h;
		int[] array = new int[size];
		bm.getPixels(array, 0, w, 0, 0, w, h);

		int[] newimage = new int[size];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (array[i * w + j] != 0) {
					int color = array[i * w + j];
					int alpha = ((color & 0xff000000) >> 24); 

					int red = r;
					int green = g;
					int blue = b;

					int pix = (alpha << 24) | (red << 16) | (green << 8) | blue;
					newimage[i * w + j] = pix;

				} else {
					newimage[i * w + j] = array[i * w + j];
				}

			}

		}

		bm = Bitmap.createBitmap(newimage, w, h, Config.ARGB_8888);
		return bm;
	}
 
}
