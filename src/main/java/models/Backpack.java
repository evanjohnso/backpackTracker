package models;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private List<Item> packed = new ArrayList<Item>();
    private float totalCost;
    private float totalWeight;

    //Constructor
    public Backpack() {
        this.totalCost = 0;
        this.totalWeight = 0;
    }

    //Setters
    public void setPacked(Item justPacked) {
        justPacked.setPacked();
        packed.add(justPacked);
    }

    //Getters
    public float getTotalCost() {
        for (Item good : packed) {
            totalCost += good.getItemPrice() * good.getQuantity();
        }
        //round this later on
        return totalCost;
    }

    public float getTotalWeight() {
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
