package models;

import java.util.ArrayList;
import java.util.List;

public class Distributor {
    private String[] name = {"Sleeping bag", "Tent","Peanut butter"};
    private double[] prices = {89.99, 150.00, 3.99};
    private double[] weights = {1.00, 5.75, 1.00};
    private List<Item> itemBank = new ArrayList<Item>();

    public Distributor() {
        for (int i = 0; i < name.length; i++) {
            itemBank.add( new Item(name[i], prices[i], weights[i]) );
        }
    }

    public List<Item> goodsBank() {
        return itemBank;
    }

    public Item findById(String itemId) {
        Item foundGood = null;
        for (Item good: itemBank) {
            if (good.getId().equals(itemId))
                foundGood = good;
        }
        return foundGood;
    }
}

