package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseRefactoredTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRoseRefactored app = new GildedRoseRefactored(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

}
