package com.gildedrose.item;

public interface CustomItem {
    public void updateItemState();

    default void decreaseQuality(Item item, Integer quantity){item.quality -= quantity;}

    default void increaseQuality(Item item, Integer quantity){item.quality += quantity;}

    default boolean isSellInLessThan(Item item, Integer number) {return item.sellIn < number;}

    default boolean isQualityGreaterThan(Item item, Integer number) {return item.quality > number;}

     default boolean isQualityLessThan(Item item, Integer number) {return item.quality < number;}

    default void decreaseSellInValue(Item item, Integer number) {item.sellIn -= number;}

    default void assignLowestQualityToItem(Item item) {item.quality = 0;}

}
