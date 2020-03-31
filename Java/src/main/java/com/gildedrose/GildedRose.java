package com.gildedrose;

class GildedRose {
	public static final String ITEM_AGED_BRIE = "Aged Brie";
	public static final String ITEM_TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
	public static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(ITEM_AGED_BRIE)
                    && !items[i].name.equals(ITEM_TAFKAL80ETC)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(ITEM_SULFURAS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(ITEM_TAFKAL80ETC)) {
                        if (items[i].sellIn < 11) {
							ifQualityLessThen50Increment(items[i]);
						}

                        if (items[i].sellIn < 6) {
							ifQualityLessThen50Increment(items[i]);
						}
                    }
                }
            }

            if (!items[i].name.equals(ITEM_SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(ITEM_AGED_BRIE)) {
                    if (!items[i].name.equals(ITEM_TAFKAL80ETC)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(ITEM_SULFURAS)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
					ifQualityLessThen50Increment(items[i]);
				}
            }
        }
    }

	private void ifQualityLessThen50Increment(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
}