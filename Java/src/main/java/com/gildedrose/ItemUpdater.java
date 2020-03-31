package com.gildedrose;


import static com.gildedrose.QualityUtils.decreaseQuality;
import static com.gildedrose.QualityUtils.increaseQuality;

public class ItemUpdater {
	public static final int QUALITY_NORMAL_DEGRADATION = 1;
	public static final int QUALITY_FAST_DEGRADATION = 2;

	public void updateItem(Item item) {
		updateQuality(item);
		updateSellin(item);
	}

	public void updateQuality(Item item) {
		item.quality = decreaseTheQuality(item, (item.sellIn < 0 ? QUALITY_FAST_DEGRADATION : QUALITY_NORMAL_DEGRADATION));
	}

	public void updateSellin(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	protected int increaseTheQuality(Item item, int qualityIncrease){
		return increaseQuality(item.quality, qualityIncrease);
	}

	protected int decreaseTheQuality(Item item, int qualityDecrease){
		return decreaseQuality(item.quality, qualityDecrease);
	}
}
