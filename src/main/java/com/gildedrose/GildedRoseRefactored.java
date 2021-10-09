package com.gildedrose;

import com.gildedrose.item.*;
import com.gildedrose.item.factory.CustomItemFactory;

class GildedRoseRefactored {
    Item[] items;

    public GildedRoseRefactored(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            System.out.println("name: "+item.name);
            System.out.println("quality: "+item.quality);
            System.out.println("sellIn: "+item.sellIn);

            CustomItem customItem = getCustomItem(item);
            customItem.updateItemState();
        }
    }

    private CustomItem getCustomItem(Item item) {
        return new CustomItemFactory(item).customiseItem(item);
    }

    private boolean isItemSulfurasHandOfRagnarok(CustomItem item) {
        return item instanceof SulfurasItem;
    }

    private boolean isItemBackstagePassConcert(CustomItem item) {
        return item instanceof BackstagePassItem;
    }

    private boolean isItemAgedBrie(CustomItem item) {
        return item instanceof AgedBrieItem;
    }

    private boolean isDefaultItem(CustomItem item) {
        return item instanceof DefaultItem;
    }
}