package com.example.demoforpropertyanimation.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Build;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	static {
		// Add 3 sample items.
		addItem(new DummyItem("1", "Old animations"));
		addItem(new DummyItem("2", "Property animations")); 
		addItem(new DummyItem("3", "Property animations for v4"));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			addItem(new DummyItem("4", "Kitkat Transitions"));
		}
	}

	public static final int ID_OLD_ANIMATIONS = 1;
	public static final int ID_PROPERTY_ANIMATIONS = 2;
	public static final int ID_PROPERTY_ANIMATIONS_FOR_V4 = 3;
	public static final int ID_KITKAT_TRANSITIONS = 4;

	public static final long ANIMATION_DURATION = 500;

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public String id;
		public String content;

		public DummyItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
