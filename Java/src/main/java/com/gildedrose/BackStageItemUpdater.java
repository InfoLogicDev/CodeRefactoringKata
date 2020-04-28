package com.gildedrose;

public class BackStageItemUpdater extends ItemUpdater {
	private static final int SELLIN_HURRY = 6;
	private static final int SELLIN_SOME_TIME = 11;

	@Override
	public void updateQuality(Item item) {
		item.quality = increaseTheQuality(item, getQualityIncrease(item));
		ifSellInBelowZeroQualityToZero(item);
	}

	private int getQualityIncrease(Item item) {
		return 1 + increment(item.sellIn < SELLIN_HURRY) + increment(item.sellIn >= SELLIN_HURRY && item.sellIn < SELLIN_SOME_TIME);
	}

	private void ifSellInBelowZeroQualityToZero(Item item) {
		if (item.sellIn <= 0) {
			item.quality = 0;
		}
	}

	private int increment(boolean needToIncrement){
		return (needToIncrement?1:0);
	}


}