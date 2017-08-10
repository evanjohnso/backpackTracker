package models;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

public class Backpack {
    private List<Item> packed = new ArrayList<Item>();
    private float totalCost;
    private float totalWeight;

    //Constructor
    public Backpack() {
        this.totalCost = 0;
        this.totalWeight = 0;
    }

    //     //Setters
    public void setPacked(Item addToPack, int itemsToAdd) {
        String thisID = addToPack.getId();
        Item thisItem = findById(thisID);

        if (thisItem != null) {
            thisItem.setQuantity(itemsToAdd);
        } else {
            addToPack.setQuantity(itemsToAdd);
            packed.add(addToPack);
        }
    }

    //Getters
    public float getTotalCost() {
        totalCost = 0;
        for (Item good : packed) {
            totalCost += good.getItemPrice() * good.getQuantity();
        }
        //round this later on
        return totalCost;
    }

    public float getTotalWeight() {
        totalWeight = 0;
        for (Item good : packed) {
            totalWeight += good.getItemWeight() * good.getQuantity();
        }
        //round this later on
        return totalWeight;
    }

    public List<Item> getPacked() {
        return packed;
    }

    public Item findById(String itemId) {
        Item foundGood = null;
        for (Item good: packed) {
            if (good.getId().equals(itemId))
                foundGood = good;
        }
        return foundGood;
    }
}
