package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
	public static final String ITEM_AGED_BRIE = "Aged Brie";
	public static final String ITEM_TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
	public static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String ITEM_CONJURED = "Conjured, The Hand of God";

	public static final int MAX_QUALITY_TRESHOLD = 50;

	public static final int NORMAL_DEGRADATION = 1;
	public static final int FAST_DEGRADATION = 2;

	public static final int SELLIN_HURRY = 6;
	public static final int SELLIN_SOME_TIME = 11;

	public static List<String> NON_BASIC_ITEMS = new ArrayList<>();

	static {
		NON_BASIC_ITEMS.add(ITEM_AGED_BRIE);
		NON_BASIC_ITEMS.add(ITEM_TAFKAL80ETC);
		NON_BASIC_ITEMS.add(ITEM_SULFURAS);
		NON_BASIC_ITEMS.add(ITEM_CONJURED);
	}

	private ItemUpdater basicItemUpdater = new ItemUpdater();
	private BackStageItemUpdater backStageItemUpdater = new BackStageItemUpdater();
	private AgedBrieItemUpdater agedBrieItemUpdater = new AgedBrieItemUpdater();
	private ConjuredItemUpdater conjuredItemUpdater = new ConjuredItemUpdater();


	private Item[] items;

	public Item[] getItems() {
		return items;
	}

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateItemQualityAndSellIn(item);
		}
	}

	private void updateItemQualityAndSellIn(Item item) {
		if (!NON_BASIC_ITEMS.contains(item.name)) {
			basicItemUpdater.updateItem(item);
		}
		if (item.name.equals(ITEM_TAFKAL80ETC)) {
			backStageItemUpdater.updateItem(item);
		}

		if (item.name.equals(ITEM_AGED_BRIE)) {
			agedBrieItemUpdater.updateItem(item);
		}

		if (item.name.equals(ITEM_CONJURED)) {
			conjuredItemUpdater.updateItem(item);
		}
	}

	private class BackStageItemUpdater extends ItemUpdater {
		@Override
		public void updateQuality(Item item) {
			int qualityIncrease = 1;
			if (item.sellIn < SELLIN_HURRY) {
				qualityIncrease = 3;
			}

			if (item.sellIn >= SELLIN_HURRY && item.sellIn < SELLIN_SOME_TIME) {
				qualityIncrease = 2;
			}

			item.quality = increaseTheQuality(item, qualityIncrease);
			if ((item.sellIn - 1) < 0) {
				item.quality = 0;
			}
		}
	}

	private class AgedBrieItemUpdater extends ItemUpdater {

		@Override
		public void updateQuality(Item item) {
			item.quality = increaseTheQuality(item, 1);
			if ((item.sellIn - 1) < 0) {
				item.quality = increaseTheQuality(item, 1);
			}
		}
	}

	private class ConjuredItemUpdater extends ItemUpdater {

		@Override
		public void updateQuality(Item item) {
			item.quality = decreaseTheQuality(item, (item.sellIn < 0 ? FAST_DEGRADATION * 2 : NORMAL_DEGRADATION * 2));
		}
	}
}