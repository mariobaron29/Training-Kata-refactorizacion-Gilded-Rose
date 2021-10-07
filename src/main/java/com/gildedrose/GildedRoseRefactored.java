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
        for (Item currentItem : items) {
            if (!isItemAgedBrie(currentItem)
            && !isItemBackstagePassConcert(currentItem)
            && !isItemSulfurasHandOfRagnarok(currentItem)
                    && currentItem.quality > 0
            ) {

                currentItem.quality -= 1;
            }

            if (currentItem.quality < 50) {
                currentItem.quality += 1;

                if (isItemBackstagePassConcert(currentItem)) {
                    if (currentItem.sellIn < 11 && currentItem.quality < 50) {
                        currentItem.quality += 1;

                    }

                    if (currentItem.sellIn < 6 && currentItem.quality < 50) {
                        currentItem.quality += 1;

                    }
                }
            }

            if (!isItemSulfurasHandOfRagnarok(currentItem)) {
                currentItem.sellIn -= 1;
            }

            if (currentItem.sellIn < 0) {
                if (!isItemAgedBrie(currentItem)) {
                    if (!isItemBackstagePassConcert(currentItem)) {
                        if (currentItem.quality > 0 &&
                                !isItemSulfurasHandOfRagnarok(currentItem)) {
                            currentItem.quality -= 1;

                        }
                    } else {
                        currentItem.quality = 0;
                    }
                } else {
                    if (currentItem.quality < 50) {
                        currentItem.quality = currentItem.quality + 1;
                    }
                }
            }
        }
    }

    private boolean isItemSulfurasHandOfRagnarok(Item item) {
        return item.name.equals(SULFURAS_HAND_OF_RAGNAROK);
    }

    private boolean isItemBackstagePassConcert(Item item) {
        return item.name.equals(BACKSTAGE_PASSES_CONCERT);
    }

    private boolean isItemAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
}