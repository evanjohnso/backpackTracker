package models;


public class Item {
    private String itemName;
    private double itemPrice;
    private double itemWeight;
    private boolean purchased = false;
    private boolean packed = false;
    private int quantity;

    //Constructor
    public Item(String itemName, double itemPrice, double itemWeight) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemWeight = itemWeight;
    }

    //Setters
    public void setPacked() {
        this.packed = !packed;
    }
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    //Getters
    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public boolean isPacked() {
        return packed;
    }

    public int getQuantity() {
        return quantity;
    }
}
