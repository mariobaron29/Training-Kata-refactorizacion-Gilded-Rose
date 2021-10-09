package com.gildedrose.item.factory;

import com.gildedrose.item.*;

import java.util.HashMap;
import java.util.Map;

public class CustomItemFactory {

    private final static Map<String, CustomItem> ITEM_TYPES_LIST = new HashMap<>();
    static final String BACKSTAGE_PASSES_CONCERT =  "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS_HAND_OF_RAGNAROK =  "Sulfuras, Hand of Ragnaros";
    static final String AGED_BRIE = "Aged Brie";

    public CustomItemFactory(Item item) {
        ITEM_TYPES_LIST.put(SULFURAS_HAND_OF_RAGNAROK, new SulfurasItem(item));
        ITEM_TYPES_LIST.put(AGED_BRIE, new AgedBrieItem(item));
        ITEM_TYPES_LIST.put(BACKSTAGE_PASSES_CONCERT, new BackstagePassItem(item));
    }

    public CustomItem customiseItem(Item item) {
        if (isDefaultItem(item)) {
            return new DefaultItem(item);
        }
        return ITEM_TYPES_LIST.get(item.name);
    }

    private boolean isDefaultItem(Item item) {
        return !ITEM_TYPES_LIST.containsKey(item.name);
    }
}