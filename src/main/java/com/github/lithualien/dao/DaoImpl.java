package com.github.lithualien.dao;

import com.github.lithualien.bike.Bike;
import com.github.lithualien.shop.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage the data and transfer it to the
 * @author Tomas Dominauskas
 */

public class DaoImpl implements Dao {

    private List<Bike> bikes;
    private List<Shop> shops;

    /**
     * Class constructor to create a list and add few bike.
     */

    public DaoImpl() {
        shops = new ArrayList<>();
        bikes = new ArrayList<>();

        Shop shop = new Shop(0, "BikeShopas", "Verkiu g., 45", "+37061234567");
        Shop shop1 = new Shop(1, "BikeShopas", "J. Jasinskio g., 15", "+37061234568");

        Bike bike = new Bike(0, "Baltic Wheel", "electric", "white", 14.25, 21, 8, 989.99f);
        Bike bike1 = new Bike(1, "Baltic Wheel", "electric", "red", 14.35, 20, 9, 989.99f);
        Bike bike2 = new Bike(2, "Baltic Wheel", "mountain", "red", 14.35, 21, 8, 989.99f);
        Bike bike3 = new Bike(3, "Baltic Wheel", "mountain", "blue", 14.35, 20, 9, 800.00f);
        Bike bike4 = new Bike(4, "Baltic Wheel", "mountain", "white", 14.35, 18, 7, 699.99f);
        Bike bike5 = new Bike(5, "Baltic Wheel", "electric", "yellow", 14.35, 20, 7, 696.29f);

        shops.add(shop);
        shops.add(shop1);

        bikes.add(bike);  shops.get(0).addBike(bike);
        bikes.add(bike1); shops.get(0).addBike(bike1);
                          shops.get(1).addBike(bike1);
        bikes.add(bike2); shops.get(0).addBike(bike2);
        bikes.add(bike3); shops.get(0).addBike(bike3);
        bikes.add(bike4); shops.get(0).addBike(bike4);
        bikes.add(bike5); shops.get(0).addBike(bike5);
    }

    /**
     * Method to get all bike.
     * @return Returns the Bike object list.
     */

    public List<Bike> getBikes() {
        return bikes;
    }

    /**
     * Method to get all shops.
     * @return Returns the Shop object list.
     */

    public List<Shop> getShops() {
        return shops;
    }

    /**
     * Method to get information about the selected shop.
     * @param id the id of the shop.
     * @return Shop object.
     */

    public Bike getBike(int id) {
        return bikes.get(id);
    }

    /**
     * Method to get information about the selected shop.
     * @param id the id of the shop.
     * @return Shop object.
     */

    public Shop getShop(int id) {
        return shops.get(id);
    }


    /**
     * Method to return Bike object list by selected colour.
     * @param colour the colour of the bike
     * @return Returns the Bike object list.
     */

    public List<Bike> getBikesByColour(String colour){
        List<Bike> temp = new ArrayList<>();
        for (Bike bike : bikes) {
            if (colour.equals(bike.getColour())) {
                temp.add(bike);
            }
        }
        return temp;
    }

    /**
     * Method to return Bike object list by selected type.
     * @param type the type of the bike
     * @return Returns the Bike object list.
     */
/*
    public List<Bike> getBikesByType(String type) {
        List<Bike> temp = new ArrayList<>();
        for (Bike bike : bikes) {
            if (type.equals(bike.getType())) {
                temp.add(bike);
            }
        }
        return temp;
    }
*/
    /**
     * Method to return Bike object list by selected type and colour.
     * @param type the type of the bike.
     * @param colour the colour of the bike
     * @return Returns the Bike object list.
     */
/*
    public List<Bike> getBikesByTypeAndColour(String type, String colour) {
        List<Bike> temp = new ArrayList<>();
        for (Bike bike : bikes) {
            if (type.equals(bike.getType()) && colour.equals(bike.getColour())) {
                temp.add(bike);
            }
        }
        return temp;
    }
*/
}
