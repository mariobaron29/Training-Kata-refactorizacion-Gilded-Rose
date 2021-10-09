package com.gildedrose.item;

public class SulfurasItem implements CustomItem{
    private final Item item;

    public SulfurasItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        if(isQualityLessThan(item, 50)){
            increaseQuality(item,1);
        }

        if (isSellInLessThan(item,0)) {
            if (isQualityLessThan(item,50)) {
                increaseQuality(item,1);
            }
            assignLowestQualityToItem(item);
        }

        System.out.println("name: "+item.name);
        System.out.println("quality: "+item.quality);
        System.out.println("sellIn: "+item.sellIn);
    }
}
