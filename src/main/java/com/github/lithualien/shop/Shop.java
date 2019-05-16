package com.github.lithualien.shop;

import com.github.lithualien.bike.Bike;

/**
 * Class to define information about the shop.
 */

public class Shop {
    private int ID;
    private String name, address, number;

    /**
     * Class constructor.
     */
    public Shop() {

    }

    /**
     * Class constructor to set information about the shop.
     * @param ID the id of the shop.
     * @param name the name of the shop.
     * @param address the address of the shop.
     * @param number the phone number of the shop.
     */

    public Shop(int ID, String name, String address, String number) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.number = number;
    }

    /**
     * Method to set the name of the shop.
     * @param name the name of the shop.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to set the id.
     * @param ID the id of the shop.
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Set the phone number of the shop.
     * @param number the number of the shop.
     */

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Set the address of the shop.
     * @param address the address of the shop.
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method to get the id of the shop.
     * @return Returns the id of the shop.
     */

    public int getID() {
        return ID;
    }

    /**
     * Method to get the name of the shop.
     * @return Returns the name of the shop.
     */

    public String getName() {
        return name;
    }

    /**
     * Method to get the phone number of the shop.
     * @return Returns the phone number of the shop.
     */

    public String getNumber() {
        return number;
    }

    /**
     * Method to get the address of the shop.
     * @return Returns the address of the shop.
     */

    public String getAddress() {
        return address;
    }

    /**
     * Method to get all the information about the shop.
     * @return returns the information about the shop to a single string attribute.
     */

    public String toString() {
        return "id : " + ID + "\nname : " + name + "\naddress : " + address + "\nnumber : " + number +"\n";
    }
}