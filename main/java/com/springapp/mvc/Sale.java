package com.springapp.mvc;

/**
 * Created by Derek on 12/07/2016.
 */
public class Sale {

    private int invoice;
    private long memberId;
    private String itemId;
    private String date;
    private float price;

    public void setInvoice(int invoice){ this.invoice = invoice; }
    public int getInvoice() { return invoice; }

    public void setMemberId(long memberId){ this.memberId = memberId; }
    public long getMemberId() { return memberId; }

    public void setItemId(String itemId){ this.itemId = itemId; }
    public String getItemId() { return itemId; }

    public void setDate(String date) { this.date = date; }
    public String getDate() { return date; }

    public void setPrice(float price) {this.price = price; }
    public float getPrice() { return price; }


}
