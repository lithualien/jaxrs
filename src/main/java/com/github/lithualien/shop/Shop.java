package com.github.lithualien.shop;

/**
 * Class to define information about the shop.
 */

public class Shop {
    private String address;
    private String number;

    /**
     * Class constructor.
     */
    public Shop() {

    }

    /**
     * Class constructor to set information about the shop.
     * @param address the address of the shop.
     * @param number the phone number of the shop.
     */

    public Shop(String address, String number) {
        this.address = address;
        this.number = number;
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
     * @return Returns the phone number of the shop.
     */

    public String getNumber() {
        return number;
    }

    /**
     * @return Returns the address of the shop.
     */

    public String getAddress() {
        return address;
    }

    /**
     * @return returns the information about the shop to a single string attribute.
     */

    public String toString() {
        return " | Adresas: " + address + " | Numeris: " + number;
    }
}
