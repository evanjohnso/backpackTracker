package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class BackpackTest {

    public Item testItem() {
        return new Item("tent", 10.22, 14.23);
    }

    public Backpack createBackpack() {
        return new Backpack();
    }

    @Test
    public void createBackpackAndAddItemToIt_Item() {
        Backpack testBackpack = createBackpack();
        Item testItem = testItem();
        testBackpack.setPacked(testItem);
        assertTrue(testBackpack instanceof Backpack);
        assertEquals(true, testBackpack.getPacked().contains(testItem));
    }

    @Test
    public void addMultipleItemsToBackpackAndReturnCost_cost() {
        Backpack testBackpack = createBackpack();
        Item testItem = testItem();
        Item secondItem = new Item("sleeping bag", 10.33, 13.50);
        testItem.setQuantity(1);
        secondItem.setQuantity(1);
        testBackpack.setPacked(testItem);
        testBackpack.setPacked(secondItem);
        assertEquals(2, testBackpack.getPacked().size());
        assertEquals(20.55, testBackpack.getTotalCost(), 0.02);
        assertEquals(27.73, testBackpack.getTotalWeight(), 0.05);
    }

    @Test
    public void findByIdItemsCanBeFound_Item() {
        Backpack testBackpack = createBackpack();
        Item testItem = testItem();
        Item secondItem = new Item("sleeping bag", 10.33, 13.50);
        testBackpack.setPacked(testItem);
        testBackpack.setPacked(secondItem);
        Item foundItem = testBackpack.findById(testItem.getId());
        assertEquals(testItem, foundItem);
    }

}