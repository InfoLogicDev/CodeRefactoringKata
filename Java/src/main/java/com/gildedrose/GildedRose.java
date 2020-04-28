package com.gildedrose;

import static com.gildedrose.ItemUpdaterFactory.getItemUpdaterForItem;

class GildedRose {
	static final int MAX_QUALITY_TRESHOLD = 50;
	private Item[] items;

	Item[] getItems() {
		return items;
	}

	GildedRose(Item[] items) {
		this.items = items;
	}

	void updateQuality() {
		for (Item item : items) {
			ItemUpdater itemUpdater = getItemUpdaterForItem(item);
			itemUpdater.updateItem(item);
		}
	}
}