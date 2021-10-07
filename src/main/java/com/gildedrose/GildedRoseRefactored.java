package com.gildedrose;

class GildedRoseRefactored {
    Item[] items;
    static final String BACKSTAGE_PASSES_CONCERT =  "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS_HAND_OF_RAGNAROK =  "Sulfuras, Hand of Ragnaros";
    static final String AGED_BRIE = "Aged Brie";

    public GildedRoseRefactored(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];

            if (!currentItem.name.equals(AGED_BRIE)
                    && !currentItem.name.equals(BACKSTAGE_PASSES_CONCERT)) {
                if (currentItem.quality > 0 && !currentItem.name.equals(SULFURAS_HAND_OF_RAGNAROK)) {
                        currentItem.quality = currentItem.quality - 1;

                }
            } else {
                if (currentItem.quality < 50) {
                    currentItem.quality = currentItem.quality + 1;

                    if (currentItem.name.equals(BACKSTAGE_PASSES_CONCERT)) {
                        if (currentItem.sellIn < 11 && currentItem.quality < 50) {
                                currentItem.quality = currentItem.quality + 1;

                        }

                        if (currentItem.sellIn < 6 && currentItem.quality < 50) {
                                currentItem.quality = currentItem.quality + 1;

                        }
                    }
                }
            }

            if (!currentItem.name.equals(SULFURAS_HAND_OF_RAGNAROK)) {
                currentItem.sellIn = currentItem.sellIn - 1;
            }

            if (currentItem.sellIn < 0) {
                if (!currentItem.name.equals(AGED_BRIE)) {
                    if (!currentItem.name.equals(BACKSTAGE_PASSES_CONCERT)) {
                        if (currentItem.quality > 0 &&
                                !currentItem.name.equals(SULFURAS_HAND_OF_RAGNAROK)) {
                                currentItem.quality = currentItem.quality - 1;

                        }
                    } else {
                        currentItem.quality = currentItem.quality - currentItem.quality;
                    }
                } else {
                    if (currentItem.quality < 50) {
                        currentItem.quality = currentItem.quality + 1;
                    }
                }
            }
        }
    }
}