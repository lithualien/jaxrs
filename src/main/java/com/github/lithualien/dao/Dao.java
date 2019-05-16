package com.github.lithualien.dao;
import com.github.lithualien.bike.Bike;
import com.github.lithualien.shop.Shop;

import java.util.List;

/**
 * The Data Access Object to save and transfer data to web service.
 * @author Tomas Dominauskas
 */

public interface Dao {

    /**
     * Method to get all bike.
     * @return the Bike object list of all bike.
     */

    List<Bike> getBikes();

    /**
     * Method to get all shops.
     * @return the Shop object list of all shops.
     */

    List<Shop> getShops();

    /**
     * Method to get information about the selected shop.
     * @param id the id of the shop.
     * @return the Shop object to get the specific
     */

    List<Bike> getBike(int id);

    /**
     * Method to get information about the selected shop.
     * @param id the id of the shop.
     * @return the Shop object.
     */

    List<Shop> getShop(int id);

    /**
     * Method to return Bike object list by selected attributes.
     * @param colour the colour of the bike.
     * @param type the type of the bike.
     * @return the Bike object list of selected attributes.
     */

    List<Bike> getBikesByColourAndType(String colour, String type);

    /**
     * Method to return the Bike object of added bike.
     * @param bike the Bike object.
     * @return the Bike object of added bike.
     */

    Bike addBike(Bike bike);

    /**
     * Method to add a new shop.
     * @param shop Shop class object.
     * @return the information about the new shop.
     */

    Shop addShop(Shop shop);

    /**
     * Method to delete the selected shop.
     * @param id the id of the shop.
     * @return true or false, depending on success of the operation.
     */

    boolean deleteShop(int id);

    /**
     * Method to delete the selected bike.
     * @param id the id of the bike.
     * @return true or false, depending on success of the operation.
     */

    boolean deleteBike(int id);

}
