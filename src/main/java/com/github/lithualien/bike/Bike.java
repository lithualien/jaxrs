package com.github.lithualien.bike;

import com.github.lithualien.shop.Shop;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to define all the attributes about the bike.
 * @author Tomas Dominauskas
 */

public class Bike {

    // variables
    private String brand, type, colour, address, number;
    private double weight;
    private float price;
    private int wheelSize, gears, ID;
    private List<Shop> shops = new ArrayList<>();

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
    public Bike(int ID, String brand, String type, String colour, double weight, int gears, int wheelSize, float price, Shop shop) {
        this.ID = ID;
        this.brand = brand;
        this.type = type;
        this.colour = colour;
        this.weight = weight;
        this.gears = gears;
        this.wheelSize = wheelSize;
        this.price = price;
        this.address = address;
        this.number = number;
        shops.add(shop);
    }

    /**
     * Set the id of the bike.
     * @param ID the id of the bike.
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Set the brand of the bike.
     * @param brand the brand of the bike.
     */

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Set the type of the bike.
     * @param type the type of the bike.
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set the colour of the bike.
     * @param colour the colour of the bike.
     */

    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Set the weight of the bike.
     * @param weight the weight of the bike.
     */

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Set the amount of gears of the bike.
     * @param gears the amount of gears the bike has.
     */

    public void setGears(int gears) {
        this.gears = gears;
    }

    /**
     * Set the size of the wheel.
     * @param wheelSize the wheel size of the bike.
     */

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    /**
     * Set the price of the bike.
     * @param price the value of the bike in Euro.
     */

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return Returns the ID.
     */

    public int getID() {
        return ID;
    }

    /**
     * @return Returns the value of the brand.
     */

    public String getBrand() {
        return brand;
    }

    /**
     * @return Returns the value of the bike type.
     */

    public String getType() {
        return type;
    }

    /**
     * @return Returns the colour of the bike.
     */

    public String getColour() {
        return colour;
    }

    /**
     * @return Returns the weight of the bike.
     */

    public double getWeight() {
        return weight;
    }

    /**
     * @return Returns the amount of gears the bike has.
     */

    public int getGears() {
        return gears;
    }

    /**
     * @return Returns the wheel size of the bike in inches
     */

    public int getWheelSize() {
        return wheelSize;
    }

    /**
     * @return Returns the price.
     */

    public float getPrice() {
        return price;
    }

    /**
     * Set the information about the shop.
     * @param address the address of the shop.
     * @param number the number of the shop.
     */

    public void setShop(List<Shop> shops) {
        this.shops = shops;
    }

    /**
     * @return returns the information about the shop.
     */

    public List<Shop> getShop() {
        return shops;
    }

    /**
     * @return Returns all the data about the bike to a single String variable.
     */
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return ID + ". Gamintojas: " + brand + " | Rūšis: " + type + " | Svoris: " + weight + "kg | Spalva: " + colour + " | Pavarų kiekis: " + gears + " | Rato dydis: " + wheelSize + " inch. | Kaina: " + format.format(price) + " | Adresas: " + getShop().get(0).getAddress() + " | Telefonas: " + getShop().get(0).getNumber() + "\n";
    }
}
