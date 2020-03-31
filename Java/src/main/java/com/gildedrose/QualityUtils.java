package com.gildedrose;

public class QualityUtils {
	public static final int MIN_QUALITY_TRESHOLD = 0;
	public static final int MAX_QUALITY_TRESHOLD = 50;

	public static int decreaseQuality(int quality, int degradation) {
		quality = quality - degradation;
		if (quality < MIN_QUALITY_TRESHOLD) {
			quality = MIN_QUALITY_TRESHOLD;
		}
		return quality;
	}

	public static int increaseQuality(int currentQuality, int increment) {
		currentQuality = currentQuality + increment;
		if (currentQuality > GildedRose.MAX_QUALITY_TRESHOLD) {
			currentQuality = GildedRose.MAX_QUALITY_TRESHOLD;
		}
		return currentQuality;
	}

}
