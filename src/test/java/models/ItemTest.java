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
    }

    @Test
    public void createItem() {
        Item testItem = new Item("tent", 10.22, 14.23);
        assertTrue(testItem instanceof Item);
    }

}