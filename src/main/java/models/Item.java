package models;

/**
 * Created by Guest on 8/9/17.
 */
public class Item {
    private String itemName;
    private float itemPrice;
    private float itemWeight;
    private boolean purchased;
    private boolean packed;
    //Constructor
    public Item() {

    }





    //Getters
    public String getItemName() {
        return itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public float getItemWeight() {
        return itemWeight;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public boolean isPacked() {
        return packed;
    }
}
