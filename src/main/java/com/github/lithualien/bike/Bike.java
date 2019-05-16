package com.github.lithualien.bike;

import java.text.NumberFormat;

/**
 * Class to define all the attributes about the bike.
 * @author Tomas Dominauskas
 */

public class Bike {

    // variables
    private String brand, type, colour;
    private double weight, wheelSize;
    private float price;
    private int gears, ID, shopID;

    /**
     * Class constructor
     */
    public Bike() {

    }

    /**
     * Class constructor to set all the variables about the bike.
     * @param ID the id of the bike.
     * @param brand the brand of the bike.
     * @param type the type of the bike.
     * @param colour the colour of the bike.
     * @param weight the weight of the bike.
     * @param gears the amount of gears the bike has.
     * @param wheelSize the size of the wheel in inches.
     * @param price the price of the bike.
     */

    public Bike(int ID, String brand, String type, String colour, double weight, int gears, double wheelSize, float price, int shopID) {
        this.ID = ID;
        this.brand = brand;
        this.type = type;
        this.colour = colour;
        this.weight = weight;
        this.gears = gears;
        this.wheelSize = wheelSize;
        this.price = price;
        this.shopID = shopID;
    }

    /**
     * Method to set the id of the bike.
     * @param ID the id of the bike.
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Method to set the brand of the bike.
     * @param brand the brand of the bike.
     */

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Method to set the type of the bike.
     * @param type the type of the bike.
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method to set the colour of the bike.
     * @param colour the colour of the bike.
     */

    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Method to set the weight of the bike.
     * @param weight the weight of the bike.
     */

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Method to set the amount of gears of the bike.
     * @param gears the amount of gears the bike has.
     */

    public void setGears(int gears) {
        this.gears = gears;
    }

    /**
     * Method to set the size of the wheel.
     * @param wheelSize the wheel size of the bike.
     */

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    /**
     * Method to set the price of the bike.
     * @param price the value of the bike in Euro.
     */

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Method to set the id of the shop.
     * @param shopID the id of the shop.
     */

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    /**
     * Method to get the ID of the bike.
     * @return the value of the ID.
     */

    public int getID() {
        return ID;
    }

    /**
     * Method to get the brand of the bike.
     * @return the value of the brand.
     */

    public String getBrand() {
        return brand;
    }

    /**
     * Method to get the type of the bike.
     * @return the value of the bike type.
     */

    public String getType() {
        return type;
    }

    /**
     * Method to get the colour of the bike.
     * @return the colour of the bike.
     */

    public String getColour() {
        return colour;
    }

    /**
     * Method to get the weight of the bike.
     * @return the weight of the bike.
     */

    public double getWeight() {
        return weight;
    }

    /**
     * Method to get the amount of gears the bike has.
     * @return the amount of gears the bike has.
     */

    public int getGears() {
        return gears;
    }

    /**
     * Method to get the wheel size of the bike.
     * @return the wheel size of the bike in inches
     */

    public double getWheelSize() {
        return wheelSize;
    }

    /**
     * Method to get the price of the bike.
     * @return the price of the bike.
     */

    public float getPrice() {
        return price;
    }

    /**
     * Method to get the id of the shop.
     * @return the id of the shop.
     */

    public int getShopID() {
        return shopID;
    }

    /**
     * Method to get the information about the bike.
     * @return Returns all the data about the bike to a single String variable.
     */
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return ID + ". Gamintojas: " + brand + " | Rūšis: " + type + " | Svoris: " + weight + "kg | Spalva: " + colour + " | Pavarų kiekis: " + gears + " | Rato dydis: " + wheelSize + " inch. | Kaina: " + format.format(price) +"\n";
    }
}
