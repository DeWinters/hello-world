package com.springapp.mvc;

/**
 * Created by Derek on 12/07/2016.
 */
public class Item {

    private String itemId;
    private String itemName;
    private long itemPrice;

    public void setItemId(String itemId){ this.itemId = itemId; }
    public String getItemId(){ return itemId; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getItemName() { return itemName; }

    public void setItemPrice(long itemPrice) { this.itemPrice = itemPrice; }
    public long getItemPrice() { return itemPrice; }


}
