package com.gildedrose;

class GildedRose {
	public static final String ITEM_AGED_BRIE = "Aged Brie";
	public static final String ITEM_TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
	public static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";

	public static final int MIN_QUALITY_TRESHOLD = 0;
	public static final int MAX_QUALITY_TRESHOLD = 50;

	private Item[] items;

	public Item[] getItems() {
		return items;
	}

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals(ITEM_AGED_BRIE)
					&& !items[i].name.equals(ITEM_TAFKAL80ETC)
					&& !items[i].name.equals(ITEM_SULFURAS)) {
				items[i].quality = calculateBasicQuality(items[i]);
			}

			if (items[i].name.equals(ITEM_AGED_BRIE) || items[i].name.equals(ITEM_TAFKAL80ETC)) {
				items[i].quality = incrementQuality(items[i].quality);
			}

			if (items[i].name.equals(ITEM_TAFKAL80ETC)) {
				if (items[i].sellIn < 11) {
					items[i].quality = incrementQuality(items[i].quality);
				}

				if (items[i].sellIn < 6) {
					items[i].quality = incrementQuality(items[i].quality);
				}
			}

			if (!items[i].name.equals(ITEM_SULFURAS)) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (items[i].name.equals(ITEM_AGED_BRIE)) {
					items[i].quality = incrementQuality(items[i].quality);
				}

				if (items[i].name.equals(ITEM_TAFKAL80ETC)) {
					items[i].quality = 0;
				}
			}
		}
	}

	private static int decreaseQuality(int quality) {
		if (quality > MIN_QUALITY_TRESHOLD) {
			quality = quality - 1;
		}
		return quality;
	}

	private static int incrementQuality(int currentQuality) {
		if (currentQuality < GildedRose.MAX_QUALITY_TRESHOLD) {
			currentQuality = currentQuality + 1;
		}
		return currentQuality;
	}

	private static int calculateBasicQuality(Item item) {
		int calculatedQuality = decreaseQuality(item.quality);
		if (item.sellIn < 0){
			calculatedQuality = decreaseQuality(calculatedQuality);
		}
		return calculatedQuality;
	}
}