package com.example.login;

public class DealerItem { //Define the dealerItem class
    String itemName;
    String brand;
    float itemPrice;
    int itemQuantity;

//Instance variables for the item's name,brand,price, and quantity

    //Constructor for the DealerItem class
    public DealerItem(String itemName,String brand,float itemPrice,int itemQuantity){
        //Initialize the instance variables with provided values
        this.itemName =itemName;
        this.brand = brand;
        this.itemPrice =itemPrice;
        this.itemQuantity =itemQuantity;

    }

    public String getItemName() {
        return itemName;
    } //Getter method to get the item's name

    public void setItemName(String itemName) {
        this.itemName = itemName;
    } //Setter method to set the item's name

    public String getBrand() {
        return brand;
    } //Getter method to get the brand

    public void setBrand(String brand) {
        this.brand = brand;
    } //Setter method to set the brand

    public float getItemPrice() {
        return itemPrice;
    } //Getter method to get the price

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    } //Setter method to set the item price

    public int getItemQuantity() { //Getter method to get the Item quantity
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    } //Setter method to set the Item Quantity
}

