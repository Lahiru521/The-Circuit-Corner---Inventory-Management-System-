package com.example.login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dealer implements Serializable { //Define the Dealer class that implements the Serializable interface

    // Instance variables for the dealer's name, contact number, location , and a list of dealer items
    String dealerName;
    String contactNo;
    String location;
    ArrayList<DealerItem> dealeritems;

    public Dealer(){ //Constructor for the Dealer class
      this.dealeritems = new ArrayList<>(); //Initialize the dealeritems list as an empty ArrayList

    }
    //Method to add a dealerItem object to the dealerItems List
    public void addDealerItem(DealerItem dealeritem) {
        dealeritems.add(dealeritem); //add the provided DealerItem to the dealeritems list
    }

    public String getDealerName() { //Getter method to get the dealer's name
        return dealerName;
    }

    public void setDealerName(String dealerName) { //Setter method to set the dealer's name
        this.dealerName = dealerName;
    }

    public String getContactNo() { //Getter method to get the dealer's name
        return contactNo;
    }


    public void setContactNo(String contactNo) { //Setter method to set the contact No
        this.contactNo = contactNo;
    }

    public String getLocation() { //Getter method to get the dealer's name
        return location;
    }

    public void setLocation(String location) { //Setter method to set the location
        this.location = location;
    }

    public List<DealerItem> getDealeritems() { //Getter method to get the list dealer items
        return dealeritems;
    }

    public void setDealeritems(ArrayList<DealerItem> dealeritems) { //Setter method to set the list of dealer items
        this.dealeritems = dealeritems;
    }


}
