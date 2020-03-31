package com.gildedrose;


import static com.gildedrose.QualityUtils.decreaseQuality;

public class ItemUpdater {
	public static final int QUALITY_NORMAL_DEGRADATION = 1;
	public static final int QUALITY_FAST_DEGRADATION = 2;

	public void updateItem(Item item) {
		updateQuality(item);
		updateSellin(item);
	}

	public void updateQuality(Item item) {
		item.quality = decreaseQuality(item.quality, (item.sellIn < 0 ? QUALITY_FAST_DEGRADATION : QUALITY_NORMAL_DEGRADATION));
	}

	public void updateSellin(Item item) {
		item.sellIn = item.sellIn - 1;
	}
}
