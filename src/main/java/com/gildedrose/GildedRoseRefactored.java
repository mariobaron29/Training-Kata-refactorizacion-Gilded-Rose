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
        for (Item item : items) {
            System.out.println("name: "+item.name);
            System.out.println("quality: "+item.quality);
            System.out.println("sellIn: "+item.sellIn);

            if (!isItemAgedBrie(item)
            && !isItemBackstagePassConcert(item)
            && !isItemSulfurasHandOfRagnarok(item)
                    && isQualityGreaterThan(item, 0)
            ) {

                decreaseQuality(item,1);
            }

            if (isQualityLessThan(item, 50)) {
                increaseQuality(item,1);

                if (isItemBackstagePassConcert(item)) {
                    if (isSellInLessThan(item,11)
                            && isQualityLessThan(item,50)) {
                        increaseQuality(item,1);

                    }

                    if (isSellInLessThan(item, 6)
                            && isQualityLessThan(item,50)) {
                        increaseQuality(item,1);

                    }
                }
            }

            if (!isItemSulfurasHandOfRagnarok(item)) {
                item.sellIn -= 1;
            }

            if (isSellInLessThan(item,0)) {
                if (!isItemAgedBrie(item)) {
                    if (!isItemBackstagePassConcert(item)) {
                        if (isQualityGreaterThan(item, 0) &&
                                !isItemSulfurasHandOfRagnarok(item)) {
                            decreaseQuality(item,1);

                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (isQualityLessThan(item,50)) {
                        increaseQuality(item,1);
                    }
                }
            }
            System.out.println("name: "+item.name);
            System.out.println("quality: "+item.quality);
            System.out.println("sellIn: "+item.sellIn);

        }
    }

    private void decreaseQuality(Item item, Integer quantity){item.quality -= quantity;}

    private void increaseQuality(Item item, Integer quantity){item.quality += quantity;}

    private boolean isSellInLessThan(Item item, Integer number) {return item.sellIn < number;}

    private boolean isQualityGreaterThan(Item item, Integer number) {return item.quality > number;}

    private boolean isQualityLessThan(Item item, Integer number) {return item.quality < number;}

    private boolean isItemSulfurasHandOfRagnarok(Item item) {return item.name.equals(SULFURAS_HAND_OF_RAGNAROK);}

    private boolean isItemBackstagePassConcert(Item item) {
        return item.name.equals(BACKSTAGE_PASSES_CONCERT);
    }

    private boolean isItemAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
}