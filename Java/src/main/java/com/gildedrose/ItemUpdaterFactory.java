package com.gildedrose;

public class ItemUpdaterFactory {
	private static final String ITEM_AGED_BRIE = "Aged Brie";
	private static final String ITEM_TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
	private static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String ITEM_CONJURED = "Conjured, The Hand of God";

	private static ItemUpdater basicItemUpdater = new ItemUpdater();
	private static BackStageItemUpdater backStageItemUpdater = new BackStageItemUpdater();
	private static AgedBrieItemUpdater agedBrieItemUpdater = new AgedBrieItemUpdater();
	private static ConjuredItemUpdater conjuredItemUpdater = new ConjuredItemUpdater();
	private static DummyIItemUpdater dummyIItemUpdater = new DummyIItemUpdater();

	public static ItemUpdater getItemUpdaterForItem(Item item) {
		ItemUpdater itemUpdater;
		switch (item.name) {
			case ITEM_TAFKAL80ETC:
				itemUpdater = backStageItemUpdater;
				break;
			case ITEM_AGED_BRIE:
				itemUpdater = agedBrieItemUpdater;
				break;
			case ITEM_CONJURED:
				itemUpdater = conjuredItemUpdater;
				break;
			case ITEM_SULFURAS:
				itemUpdater = dummyIItemUpdater;
				break;
			default:
				itemUpdater = basicItemUpdater;
		}

		return itemUpdater;
	}
}
