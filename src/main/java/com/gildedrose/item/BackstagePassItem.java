package com.gildedrose.item;

public class BackstagePassItem implements CustomItem{
    private final Item item;

    public BackstagePassItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        if(isQualityLessThan(item, 50)){
            increaseQuality(item,1);
        }

        if (isQualityLessThan(item,50)
                && isSellInLessThan(item,11)
                || isSellInLessThan(item, 6)) {
            increaseQuality(item,1);

        }

        decreaseSellInValue(item,1);

        if (isSellInLessThan(item,0)) {
            if (isQualityLessThan(item,50)) {
                increaseQuality(item,1);
            }
        }

        System.out.println("name: "+item.name);
        System.out.println("quality: "+item.quality);
        System.out.println("sellIn: "+item.sellIn);
    }
}
