package com.gildedrose;

class GildedRose {
	public static final String ITEM_AGED_BRIE = "Aged Brie";
	public static final String ITEM_TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
	public static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";

	public static final int MIN_QUALITY_TRESHOLD = 0;
	public static final int MAX_QUALITY_TRESHOLD = 50;

	public static final int NORMAL_DEGRADATION = 1;
	public static final int FAST_DEGRADATION = 2;

	private Item[] items;

	public Item[] getItems() {
		return items;
	}

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			if (!item.name.equals(ITEM_AGED_BRIE)
					&& !item.name.equals(ITEM_TAFKAL80ETC)
					&& !item.name.equals(ITEM_SULFURAS)) {
				handleBasicItem(item);
			}

			if (item.name.equals(ITEM_TAFKAL80ETC)) {
				handleBackStageItem(item);
			}

			if (item.name.equals(ITEM_AGED_BRIE)) {
				handleAgedBrie(item);
			}
		}
	}

	private void handleBackStageItem(Item item) {
		int qualityIncrease = 1;
		if (item.sellIn < 6) {
			qualityIncrease = 3;
		}

		if (item.sellIn >=  6 && item.sellIn < 11) {
			qualityIncrease = 2;
		}

		item.quality = increaseQuality(item.quality, qualityIncrease);
		item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) {
			item.quality = 0;
		}
	}

	private void handleAgedBrie(Item item) {
		item.quality = increaseQuality(item.quality, 1);
		item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) {
			item.quality = increaseQuality(item.quality, 1);
		}
	}

	private void handleBasicItem(Item item) {
		item.quality = decreaseQuality(item.quality, (item.sellIn < 0? FAST_DEGRADATION: NORMAL_DEGRADATION));
		item.sellIn = item.sellIn - 1;
	}

	private static int decreaseQuality(int quality, int degradation) {
		quality = quality - degradation;
		if (quality < MIN_QUALITY_TRESHOLD) {
			quality = MIN_QUALITY_TRESHOLD;
		}
		return quality;
	}

	private static int increaseQuality(int currentQuality, int increment) {
		currentQuality = currentQuality + increment;
		if (currentQuality > GildedRose.MAX_QUALITY_TRESHOLD) {
			currentQuality = GildedRose.MAX_QUALITY_TRESHOLD;
		}
		return currentQuality;
	}
}