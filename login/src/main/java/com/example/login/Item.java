package com.example.login;
import java.io.Serializable;

public class Item implements Serializable { //Define a class named "Item" that implements the Serializable interface
     //Declare instance variables for the Item class
    int index; //An integer to represent the index of the item
     String name;//A string to represent the name of the item
     String brandName;//A String to represent the brand Name of the item
     float price;//A float to represent the price of the item
     int quantity;//An integer to represent the quantity of the item
     String category;//A String to represent the category of the item
     String purchasedDate;//A String to represent the purchasedDate of the item

    //Create a consturctor for the Item class to initialize its instance variables
    public Item(int index,String name,String brandName,float price,int quantity,String category,String purchasedDate){
        this.index = index; //initialize the index with the provided value
        this.name = name;//initialize the name with the provided value
        this.brandName = brandName;//initialize the brand name with the provided value
        this.price = price;//initialize the price with the provided value
        this.quantity = quantity;//initialize the quantity with the provided value
        this.category = category;//initialize the category with the provided value
        this.purchasedDate = purchasedDate;//initialize the purchased Date with the provided value
    }

    public int getIndex(){ // Getter method to retrieve the value of the index variable

        return index;
    }
    public void setIndex(int index){//Setter method to set the value of the index variable

        this.index = index;
    }
    public String getName(){ // Getter method to retrieve the value of the name variable

        return name;
    }

    public void setName(String name){//Setter method to set the value of the name variable

        this.name=name;
    }

    public String getBrandName(){
        return brandName;
    } // Getter method to retrieve the value of the brandName variable

    public void setBrandName(String brandName){//Setter method to set the value of the brandName variable

        this.brandName=brandName;
    }

    public float getPrice(){ // Getter method to retrieve the value of the price variable

        return price;
    }
    public void setPrice(float price){ //Setter method to set the value of the price variable

        this.price=price;
    }

    public int getQuantity(){
        return quantity;
    } // Getter method to retrieve the value of the quantity variable

    public void setQuantity(int quantity){
        this.quantity=quantity;
    } //Setter method to set the value of the quantity variable

    public String getCategory(){
        return category;
    } // Getter method to retrieve the value of the category variable

    public void setCategory(String category){
        this.category=category;
    } //Setter method to set the value of the category variable

    public String getPurchasedDate(){
        return purchasedDate;
    } // Getter method to retrieve the value of the Purchased Date variable

    public void setPurchasedDate(String purchasedDate){
        this.purchasedDate=purchasedDate;
    } //Setter method to set the value of the Purchased Date variable
}
