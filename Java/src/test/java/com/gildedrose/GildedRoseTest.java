package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQualityBasicItem() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.getItems()[0].name);
        assertEquals(-1, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
        app.updateQuality();
        assertEquals(-2, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
    }

    @Test
    void updateQualityAgedBrieItem() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.getItems()[0].name);
        assertEquals(-1, app.getItems()[0].sellIn);
        assertEquals(2, app.getItems()[0].quality);
        app.updateQuality();
        assertEquals(-2, app.getItems()[0].sellIn);
        assertEquals(4, app.getItems()[0].quality);
        app.updateQuality();
        assertEquals(-3, app.getItems()[0].sellIn);
        assertEquals(6, app.getItems()[0].quality);
    }

    @Test
    void updateQualitySulfurasItem() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.getItems()[0].name);
        assertEquals(0, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
        app.updateQuality();
        assertEquals(0, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
        app.updateQuality();
        assertEquals(0, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
    }

    @Test
    void updateQualityBackstageItem() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getItems()[0].name);
        assertEquals(-1, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
        app.updateQuality();
        assertEquals(-2, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
        app.updateQuality();
        assertEquals(-3, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
    }
}
