package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ItemTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    };

    public Item testItem() {
        return new Item("tent", 10.22, 14.23);
    }
    public Backpack createBackpack() {
        return new Backpack();
    }

    //Test Item methods
    @Test
    public void createItem() {
        Item testItem = testItem();
        assertTrue(testItem instanceof Item);
    }

    @Test
    public void createItemAndTestPriceGetter_price() {
        Item testItem = testItem();
        assertEquals(10.22, testItem.getItemPrice(), 0.02);
    }

    @Test
    public void createItemAndTestSetQuantity_quantity() {
        Item testItem = testItem();
        testItem.setQuantity(12);
        assertEquals(12, testItem.getQuantity());
    }

    @Test
    public void createItemAndChangePackedStatus_boolean() {
        Item testItem = testItem();
        testItem.setPacked();
        assertEquals(true, testItem.isPacked());
    }

    @Test
    public void createItemAndChangePurchasedStatus_boolean() {
        Item testItem = testItem();
        testItem.setPurchased();
        assertEquals(true, testItem.isPurchased());
    }

    //Test Backpack methods
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

}