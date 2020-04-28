package com.gildedrose;

public class AgedBrieItemUpdater extends ItemUpdater {

	@Override
	public void updateQuality(Item item) {
		item.quality = increaseTheQuality(item, 1);
		if (item.sellIn <= 0) {
			item.quality = increaseTheQuality(item, 1);
		}
	}
}
