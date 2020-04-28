package com.gildedrose;

public class ConjuredItemUpdater extends ItemUpdater {
	private static final int NORMAL_DEGRADATION = 2;
	private static final int FAST_DEGRADATION = 4;

	@Override
	public void updateQuality(Item item) {
		item.quality = decreaseTheQuality(item, getDegradation(item.sellIn));
	}

	private int getDegradation(int sellIn) {
		return sellIn < 0 ? FAST_DEGRADATION : NORMAL_DEGRADATION;
	}
}